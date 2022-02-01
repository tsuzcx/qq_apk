package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioRecord;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class TXCAudioSysRecord
  implements Runnable
{
  private static final String TAG;
  private static TXCAudioSysRecord instance = null;
  private int mAECType = 0;
  private int mBits = 16;
  private int mChannels = 1;
  private Context mContext;
  private boolean mIsCapFirstFrame = false;
  private boolean mIsRunning = false;
  private AudioRecord mMic;
  private AtomicBoolean mPause = new AtomicBoolean(false);
  private byte[] mRecordBuffer = null;
  private Thread mRecordThread = null;
  private int mSampleRate = 48000;
  private boolean mSendMuteData = false;
  private WeakReference<c> mWeakRefListener;
  private Object threadMutex = new Object();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioCenter:");
    localStringBuilder.append(TXCAudioSysRecord.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  private TXCAudioSysRecord()
  {
    nativeClassInit();
  }
  
  public static TXCAudioSysRecord getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new TXCAudioSysRecord();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void init()
  {
    int m = this.mSampleRate;
    int n = this.mChannels;
    int i1 = this.mBits;
    int i = this.mAECType;
    TXCLog.i(TAG, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i) }));
    if (n == 1) {
      i = 16;
    } else {
      i = 12;
    }
    int j;
    if (i1 == 8) {
      j = 3;
    } else {
      j = 2;
    }
    int k = AudioRecord.getMinBufferSize(m, i, j);
    try
    {
      TXCLog.i(TAG, "audio record type: system normal");
      try
      {
        this.mMic = new AudioRecord(1, m, i, j, k * 2);
      }
      catch (IllegalArgumentException localIllegalArgumentException1) {}
      TXCLog.e(TAG, "create AudioRecord failed.", localIllegalArgumentException2);
    }
    catch (IllegalArgumentException localIllegalArgumentException2) {}
    AudioRecord localAudioRecord = this.mMic;
    if ((localAudioRecord != null) && (localAudioRecord.getState() == 1))
    {
      i = n * 1024 * i1 / 8;
      if (i > k) {
        this.mRecordBuffer = new byte[k];
      } else {
        this.mRecordBuffer = new byte[i];
      }
      TXCLog.i(TAG, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(this.mRecordBuffer.length), Integer.valueOf(this.mMic.getState()) }));
      localAudioRecord = this.mMic;
      if (localAudioRecord != null) {
        try
        {
          localAudioRecord.startRecording();
          return;
        }
        catch (Exception localException)
        {
          TXCLog.e(TAG, "mic startRecording failed.", localException);
          onRecordError(-1, "start recording failed!");
        }
      }
      return;
    }
    TXCLog.e(TAG, "audio record: initialize the mic failed.");
    uninit();
    onRecordError(-1, "microphone permission denied!");
  }
  
  private native void nativeClassInit();
  
  private native void nativeSendSysRecordAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private void onRecordError(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.mWeakRefListener != null)
        {
          localc = (c)this.mWeakRefListener.get();
          if (localc != null)
          {
            localc.onAudioRecordError(paramInt, paramString);
            return;
          }
          TXCLog.e(TAG, "onRecordError:no callback");
          return;
        }
      }
      finally {}
      c localc = null;
    }
  }
  
  private void onRecordPcmData(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    Object localObject = this.mWeakRefListener;
    if (localObject != null) {
      localObject = (c)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((c)localObject).onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
      return;
    }
    TXCLog.e(TAG, "onRecordPcmData:no callback");
  }
  
  private void onRecordStart()
  {
    for (;;)
    {
      try
      {
        if (this.mWeakRefListener != null)
        {
          c localc = (c)this.mWeakRefListener.get();
          if (localc != null)
          {
            localc.onAudioRecordStart();
            return;
          }
          TXCLog.e(TAG, "onRecordStart:no callback");
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  private void onRecordStop()
  {
    for (;;)
    {
      try
      {
        if (this.mWeakRefListener != null)
        {
          c localc = (c)this.mWeakRefListener.get();
          if (localc != null)
          {
            localc.onAudioRecordStop();
            return;
          }
          TXCLog.e(TAG, "onRecordStop:no callback");
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  private void uninit()
  {
    if (this.mMic != null)
    {
      TXCLog.i(TAG, "stop mic");
      try
      {
        this.mMic.setRecordPositionUpdateListener(null);
        this.mMic.stop();
        this.mMic.release();
      }
      catch (Exception localException)
      {
        TXCLog.e(TAG, "stop AudioRecord failed.", localException);
      }
    }
    this.mMic = null;
    this.mRecordBuffer = null;
    this.mIsCapFirstFrame = false;
  }
  
  public boolean isRecording()
  {
    try
    {
      boolean bool = this.mIsRunning;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void pause(boolean paramBoolean)
  {
    TXCLog.i(TAG, "system audio record pause");
    this.mPause.set(true);
    this.mSendMuteData = paramBoolean;
  }
  
  public void resume()
  {
    TXCLog.i(TAG, "system audio record resume");
    this.mPause.set(false);
  }
  
  public void run()
  {
    if (!this.mIsRunning)
    {
      TXCLog.w(TAG, "audio record: abandom start audio sys record thread!");
      return;
    }
    onRecordStart();
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("start capture audio data ...,mIsRunning:");
    ((StringBuilder)localObject2).append(this.mIsRunning);
    ((StringBuilder)localObject2).append(" Thread.interrupted:");
    ((StringBuilder)localObject2).append(Thread.interrupted());
    ((StringBuilder)localObject2).append(" mMic:");
    ((StringBuilder)localObject2).append(this.mMic);
    TXCLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    init();
    int j;
    for (;;)
    {
      j = 0;
      int i = 0;
      for (;;)
      {
        if ((!this.mIsRunning) || (Thread.interrupted()) || (this.mMic == null) || (j > 5)) {
          break label349;
        }
        System.currentTimeMillis();
        localObject1 = this.mMic;
        localObject2 = this.mRecordBuffer;
        int k = ((AudioRecord)localObject1).read((byte[])localObject2, i, localObject2.length - i);
        if (k == this.mRecordBuffer.length - i) {
          break;
        }
        if (k <= 0)
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("read pcm error, len =");
          ((StringBuilder)localObject2).append(k);
          TXCLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
          j += 1;
        }
        else
        {
          i += k;
        }
      }
      boolean bool = this.mIsCapFirstFrame;
      j = 1;
      if (!bool)
      {
        onRecordError(-6, "First frame captured#");
        this.mIsCapFirstFrame = true;
      }
      if (this.mSendMuteData) {
        Arrays.fill(this.mRecordBuffer, (byte)0);
      }
      i = j;
      if (this.mPause.get()) {
        if (this.mSendMuteData) {
          i = j;
        } else {
          i = 0;
        }
      }
      if (i != 0)
      {
        localObject1 = this.mRecordBuffer;
        onRecordPcmData((byte[])localObject1, localObject1.length, TXCTimeUtil.getTimeTick());
        localObject1 = this.mRecordBuffer;
        nativeSendSysRecordAudioData((byte[])localObject1, localObject1.length, this.mSampleRate, this.mChannels, this.mBits);
      }
    }
    label349:
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("stop capture audio data ...,mIsRunning:");
    ((StringBuilder)localObject2).append(this.mIsRunning);
    ((StringBuilder)localObject2).append(" mMic:");
    ((StringBuilder)localObject2).append(this.mMic);
    ((StringBuilder)localObject2).append(" nFailedCount:");
    ((StringBuilder)localObject2).append(j);
    TXCLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    uninit();
    if (j > 5)
    {
      onRecordError(-1, "read data failed!");
      return;
    }
    onRecordStop();
  }
  
  public void setAudioRecordListener(c paramc)
  {
    if (paramc == null) {}
    try
    {
      this.mWeakRefListener = null;
      break label26;
      this.mWeakRefListener = new WeakReference(paramc);
      label26:
      return;
    }
    finally {}
  }
  
  public void start(int paramInt1, int paramInt2, int paramInt3)
  {
    TXCLog.i(TAG, "start");
    synchronized (this.threadMutex)
    {
      stop();
      this.mSampleRate = paramInt1;
      this.mChannels = paramInt2;
      this.mBits = paramInt3;
      this.mIsRunning = true;
      this.mRecordThread = new Thread(this, "AudioSysRecord Thread");
      this.mRecordThread.start();
      TXCLog.i(TAG, "start ok");
      return;
    }
  }
  
  public void stop()
  {
    TXCLog.i(TAG, "stop");
    synchronized (this.threadMutex)
    {
      this.mIsRunning = false;
      long l1 = System.currentTimeMillis();
      if ((this.mRecordThread != null) && (this.mRecordThread.isAlive()))
      {
        long l2 = Thread.currentThread().getId();
        long l3 = this.mRecordThread.getId();
        if (l2 != l3) {
          try
          {
            this.mRecordThread.join();
          }
          catch (Exception localException)
          {
            localObject3 = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("record stop Exception: ");
            localStringBuilder.append(localException.getMessage());
            TXCLog.e((String)localObject3, localStringBuilder.toString());
          }
        }
      }
      String str = TAG;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("stop ok,stop record cost time(MS): ");
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - l1);
      TXCLog.i(str, ((StringBuilder)localObject3).toString());
      this.mRecordThread = null;
      TXCLog.i(TAG, "stop ok");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord
 * JD-Core Version:    0.7.0.1
 */