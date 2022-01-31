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
    Log.d("Recorder", "device info = " + this.deviceInfo);
    this.mMode = 0;
    this.mAudioSource = 0;
    Log.d("Recorder", "mMode = " + this.mMode + " | mAudioSource = " + this.mAudioSource + " | recorderBufSize = " + this.recorderInitBufSize + " | readLength = " + this.frameLengthPerRead);
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
    for (;;)
    {
      if (paramInt3 != -1) {
        this.frameLengthPerRead = paramInt3;
      }
      return;
      if (paramInt2 != -1) {
        this.recorderInitBufSize = paramInt2;
      }
    }
  }
  
  private void releaseRecordThreadResource()
  {
    if (this.mRecord != null) {
      this.mRecord.release();
    }
    this.mRecord = null;
    this.recordThread = null;
    this.recorderPath = null;
  }
  
  public void cancel()
  {
    if (this.recordThread != null) {
      this.recordThread.unNormal = true;
    }
    stop();
    File localFile = new File(this.silkFilePath);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public boolean initRecording()
  {
    if (this.mRecord != null)
    {
      this.mRecord.release();
      this.mRecord = null;
    }
    if (this.mAudioManager != null) {}
    for (int i = this.mAudioManager.getMode();; i = 0)
    {
      Log.d("Recorder", "Record :startRecording | audio mode = " + i);
      if ((this.mAudioManager != null) && (this.mMode != -1))
      {
        Log.d("Recorder", "Record :initRecording --> SetMode ,mode = " + this.mMode);
        this.mAudioManager.setMode(this.mMode);
      }
      if (this.mRecord == null) {
        Log.d("Recorder", "Record: new AudioRecord --> mAudioSource = " + this.mAudioSource + " ,SAMPLE_RATE_IN_HZ =" + 16000 + " ,CHANNEL_CONFIG = " + 16 + " ,AUDIO_FORMAT =" + 2 + " ,recorderInitBufSize = " + this.recorderInitBufSize);
      }
      try
      {
        this.mRecord = new AudioRecord(0, 16000, 16, 2, this.recorderInitBufSize);
        if (this.mRecord.getState() == 1) {
          break label353;
        }
        i = this.mRecord.getState();
        Log.d("Recorder", "Record State = " + i);
        if (this.mRecord != null) {
          this.mRecord.release();
        }
        this.mRecord = null;
        if (this.mListener == null) {
          break label353;
        }
        this.mListener.onRecorderFailed(this.recorderPath, 3);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        do
        {
          Log.d("Recorder", "Record : new AudioRecord Failed:" + Log.getStackTraceString(localIllegalArgumentException), localIllegalArgumentException);
        } while (this.mListener == null);
        this.mListener.onRecorderFailed(this.recorderPath, 3);
        return false;
      }
      return false;
      label353:
      return true;
    }
  }
  
  public boolean isRecording()
  {
    return this.recordThread != null;
  }
  
  public boolean isStop()
  {
    if (this.recordThread == null) {}
    while (!this.recordThread.isRunning) {
      return true;
    }
    return false;
  }
  
  public void setMaxRecorderTime(int paramInt)
  {
    if (paramInt <= this.MAX_RECORD_TIME)
    {
      this.maxRecorderTime = paramInt;
      return;
    }
    this.maxRecorderTime = this.MAX_RECORD_TIME;
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
    Log.d("Recorder", "QQRecord Start --> Path = " + paramString);
    if (this.recordThread == null)
    {
      this.recordThread = new Recorder.RecordThread(this, paramString);
      TraeJni.getInstance().initTRAE();
      this.recordThread.start();
    }
    do
    {
      return;
      Log.d("Recorder", "Record :start --> Record is Not Ready");
    } while (this.mListener == null);
    this.mListener.onRecorderFailed(paramString, 1);
  }
  
  public void stop()
  {
    Log.d("Recorder", "QQRecord Stop");
    if (this.recordThread != null) {
      this.recordThread.isRunning = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.ptt.Recorder
 * JD-Core Version:    0.7.0.1
 */