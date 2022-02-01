package com.tencent.TMG.ptt;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import android.util.Log;
import java.io.File;

public class Recorder
{
  private static final int ABNORMAL_NO_DATA = 0;
  private static final int AUDIO_FORMAT = 2;
  private static final int CHANNEL_CONFIG = 16;
  private static final int DEFAULT_FRAME_LENGTH_PER_READ = 800;
  private static final int DEFAULT_RECORDER_INIT_BUFFER_SIZE = 20480;
  private static final int FRAME_LENGTH_160 = 160;
  private static final int INVALID_VALUE = -1;
  private static final int SAMPLE_RATE_IN_HZ = 16000;
  private static final String TAG = "Recorder";
  public static final int VOLUME_STATE_INIT = 0;
  public static final int VOLUME_STATE_LOW = 1;
  public static final int VOLUME_STATE_NORMAL = 2;
  private String DEVICE_BBK = "bbk";
  private String DEVICE_MEIZU = "meizu";
  private String DEVICE_OPPO = "oppo";
  private String DEVICE_VIVO = "vivo";
  private int IGNORE_DATA_FRAME_MEIZU = 15;
  private int IGNORE_DATA_FRAME_NORMAL = 10;
  private int MAX_NO_DATA_TIME_MS = 1000;
  private int MAX_RECORD_TIME = 60000;
  private int MIN_RECORD_TIME = 1000;
  private Context context = null;
  private String deviceInfo = "";
  private int frameLengthPerRead = 800;
  AudioManager mAudioManager = null;
  private int mAudioSource = -1;
  private Recorder.OnQQRecorderListener mListener = null;
  private int mMode = -1;
  AudioRecord mRecord = null;
  private long maxRecorderTime = this.MAX_RECORD_TIME;
  public String pcmFilePath = null;
  Recorder.RecordThread recordThread = null;
  private int recorderInitBufSize = 20480;
  String recorderPath = null;
  private RingBuffer ringBuffer = null;
  public String silkFilePath = null;
  
  public Recorder(Context paramContext)
  {
    this.context = paramContext;
    this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.ringBuffer = new RingBuffer(6400);
    this.deviceInfo = Build.MANUFACTURER;
    paramContext = new StringBuilder();
    paramContext.append("device info = ");
    paramContext.append(this.deviceInfo);
    Log.d("Recorder", paramContext.toString());
    this.mMode = 0;
    this.mAudioSource = 0;
    paramContext = new StringBuilder();
    paramContext.append("mMode = ");
    paramContext.append(this.mMode);
    paramContext.append(" | mAudioSource = ");
    paramContext.append(this.mAudioSource);
    paramContext.append(" | recorderBufSize = ");
    paramContext.append(this.recorderInitBufSize);
    paramContext.append(" | readLength = ");
    paramContext.append(this.frameLengthPerRead);
    Log.d("Recorder", paramContext.toString());
  }
  
  private void initBufferSize(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = AudioRecord.getMinBufferSize(16000, 16, 2);
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.recorderInitBufSize = (paramInt2 * paramInt1);
      }
    }
    else if (paramInt2 != -1)
    {
      this.recorderInitBufSize = paramInt2;
    }
    if (paramInt3 != -1) {
      this.frameLengthPerRead = paramInt3;
    }
  }
  
  private void releaseRecordThreadResource()
  {
    AudioRecord localAudioRecord = this.mRecord;
    if (localAudioRecord != null) {
      localAudioRecord.release();
    }
    this.mRecord = null;
    this.recordThread = null;
    this.recorderPath = null;
  }
  
  public void cancel()
  {
    Object localObject = this.recordThread;
    if (localObject != null) {
      ((Recorder.RecordThread)localObject).unNormal = true;
    }
    stop();
    localObject = new File(this.silkFilePath);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  public boolean initRecording()
  {
    Object localObject1 = this.mRecord;
    if (localObject1 != null)
    {
      ((AudioRecord)localObject1).release();
      this.mRecord = null;
    }
    localObject1 = this.mAudioManager;
    int i;
    if (localObject1 != null) {
      i = ((AudioManager)localObject1).getMode();
    } else {
      i = 0;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Record :startRecording | audio mode = ");
    ((StringBuilder)localObject1).append(i);
    Log.d("Recorder", ((StringBuilder)localObject1).toString());
    if ((this.mAudioManager != null) && (this.mMode != -1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Record :initRecording --> SetMode ,mode = ");
      ((StringBuilder)localObject1).append(this.mMode);
      Log.d("Recorder", ((StringBuilder)localObject1).toString());
      this.mAudioManager.setMode(this.mMode);
    }
    Object localObject2;
    if (this.mRecord == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Record: new AudioRecord --> mAudioSource = ");
      ((StringBuilder)localObject1).append(this.mAudioSource);
      ((StringBuilder)localObject1).append(" ,SAMPLE_RATE_IN_HZ =");
      ((StringBuilder)localObject1).append(16000);
      ((StringBuilder)localObject1).append(" ,CHANNEL_CONFIG = ");
      ((StringBuilder)localObject1).append(16);
      ((StringBuilder)localObject1).append(" ,AUDIO_FORMAT =");
      ((StringBuilder)localObject1).append(2);
      ((StringBuilder)localObject1).append(" ,recorderInitBufSize = ");
      ((StringBuilder)localObject1).append(this.recorderInitBufSize);
      Log.d("Recorder", ((StringBuilder)localObject1).toString());
      try
      {
        this.mRecord = new AudioRecord(0, 16000, 16, 2, this.recorderInitBufSize);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Record : new AudioRecord Failed:");
        localStringBuilder.append(Log.getStackTraceString(localIllegalArgumentException));
        Log.d("Recorder", localStringBuilder.toString(), localIllegalArgumentException);
        localObject2 = this.mListener;
        if (localObject2 != null) {
          ((Recorder.OnQQRecorderListener)localObject2).onRecorderFailed(this.recorderPath, 3);
        }
        return false;
      }
    }
    if (this.mRecord.getState() != 1)
    {
      i = this.mRecord.getState();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Record State = ");
      ((StringBuilder)localObject2).append(i);
      Log.d("Recorder", ((StringBuilder)localObject2).toString());
      localObject2 = this.mRecord;
      if (localObject2 != null) {
        ((AudioRecord)localObject2).release();
      }
      this.mRecord = null;
      localObject2 = this.mListener;
      if (localObject2 != null)
      {
        ((Recorder.OnQQRecorderListener)localObject2).onRecorderFailed(this.recorderPath, 3);
        return false;
      }
    }
    return true;
  }
  
  public boolean isRecording()
  {
    return this.recordThread != null;
  }
  
  public boolean isStop()
  {
    Recorder.RecordThread localRecordThread = this.recordThread;
    if (localRecordThread == null) {
      return true;
    }
    return localRecordThread.isRunning ^ true;
  }
  
  public void setMaxRecorderTime(int paramInt)
  {
    int i = this.MAX_RECORD_TIME;
    if (paramInt <= i)
    {
      this.maxRecorderTime = paramInt;
      return;
    }
    this.maxRecorderTime = i;
  }
  
  public void setQQRecorderListener(Recorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    Log.d("Recorder", "setQQRecorderListener");
    if (paramOnQQRecorderListener == null)
    {
      Log.d("Recorder", "setQQRecorderListener--> listener is null");
      return;
    }
    this.mListener = paramOnQQRecorderListener;
  }
  
  public void start(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQRecord Start --> Path = ");
    ((StringBuilder)localObject).append(paramString);
    Log.d("Recorder", ((StringBuilder)localObject).toString());
    if (this.recordThread == null)
    {
      this.recordThread = new Recorder.RecordThread(this, paramString);
      TraeJni.getInstance().initTRAE();
      this.recordThread.start();
      return;
    }
    Log.d("Recorder", "Record :start --> Record is Not Ready");
    localObject = this.mListener;
    if (localObject != null) {
      ((Recorder.OnQQRecorderListener)localObject).onRecorderFailed(paramString, 1);
    }
  }
  
  public void stop()
  {
    Log.d("Recorder", "QQRecord Stop");
    Recorder.RecordThread localRecordThread = this.recordThread;
    if (localRecordThread != null) {
      localRecordThread.isRunning = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.Recorder
 * JD-Core Version:    0.7.0.1
 */