package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TXCAudioUGCRecorder
  implements c
{
  private static final TXCAudioUGCRecorder INSTANCE = new TXCAudioUGCRecorder();
  private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
  private final int AAC_SAMPLE_NUM = 1024;
  protected int mAACFrameLength = this.mChannels * 1024 * this.mBits / 8;
  protected int mAECType = 0;
  private a mBGMRecorder = null;
  protected int mBits = 16;
  protected int mChannels = 1;
  protected Context mContext;
  private boolean mCurBGMRecordFlag = false;
  private boolean mEnableBGMRecord = false;
  private final List<byte[]> mEncodedAudioList = new ArrayList();
  protected boolean mIsEarphoneOn = false;
  private boolean mIsMute = false;
  private boolean mIsPause = false;
  private boolean mIsRunning = false;
  private long mLastPTS = 0L;
  protected int mReverbType = 0;
  protected AtomicInteger mSampleRate = new AtomicInteger(48000);
  private int mShouldClearAACDataCnt = 0;
  private AtomicReference<Float> mSpeedRate = new AtomicReference(Float.valueOf(1.0F));
  protected int mVoiceChangerType = 0;
  private float mVolume = 1.0F;
  private WeakReference<e> mWeakRecordListener;
  
  static
  {
    f.f();
  }
  
  private TXCAudioUGCRecorder()
  {
    TXCAudioSysRecord.getInstance();
    nativeClassInit();
  }
  
  public static TXCAudioUGCRecorder getInstance()
  {
    return INSTANCE;
  }
  
  private native void nativeClassInit();
  
  private native void nativeEnableMixMode(boolean paramBoolean);
  
  private native void nativeSetChangerType(int paramInt);
  
  private native void nativeSetReverbType(int paramInt);
  
  private native void nativeSetSpeedRate(float paramFloat);
  
  private native void nativeSetVolume(float paramFloat);
  
  private native void nativeStartAudioRecord(int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeStopAudioRecord();
  
  private void updateAudioEffector()
  {
    for (boolean bool = false;; bool = true) {
      try
      {
        if ((!this.mEnableBGMRecord) && (this.mAECType != 1))
        {
          if (!bool)
          {
            nativeSetReverbType(this.mReverbType);
            nativeSetChangerType(this.mVoiceChangerType);
            if (this.mIsMute) {
              nativeSetVolume(0.0F);
            } else {
              nativeSetVolume(this.mVolume);
            }
          }
          if (bool) {
            nativeSetVolume(0.0F);
          }
          nativeEnableMixMode(bool);
          nativeSetSpeedRate(((Float)this.mSpeedRate.get()).floatValue());
          return;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void clearCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 12
    //   4: ldc 163
    //   6: invokestatic 169	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 122	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEncodedAudioList	Ljava/util/List;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 122	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEncodedAudioList	Ljava/util/List;
    //   20: invokeinterface 174 1 0
    //   25: aload_1
    //   26: monitorexit
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_2
    //   31: aload_1
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	TXCAudioUGCRecorder
    //   35	4	1	localObject1	Object
    //   30	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	30	finally
    //   31	33	30	finally
    //   2	16	35	finally
    //   33	35	35	finally
  }
  
  public void enableBGMRecord(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableBGMRecord: ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
    if ((this.mEnableBGMRecord != paramBoolean) && (!paramBoolean)) {
      this.mShouldClearAACDataCnt = 2;
    }
    this.mEnableBGMRecord = paramBoolean;
    updateAudioEffector();
  }
  
  public int getChannels()
  {
    return this.mChannels;
  }
  
  public e getListener()
  {
    WeakReference localWeakReference = this.mWeakRecordListener;
    if (localWeakReference != null) {
      return (e)localWeakReference.get();
    }
    return null;
  }
  
  public int getSampleRate()
  {
    return this.mSampleRate.get();
  }
  
  public boolean isPaused()
  {
    return this.mIsPause;
  }
  
  public boolean isRecording()
  {
    return this.mIsRunning;
  }
  
  public void onAudioRecordError(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sys audio record error: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", ((StringBuilder)localObject).toString());
    localObject = getListener();
    if (localObject != null) {
      ((e)localObject).onRecordError(paramInt, paramString);
    }
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    long l2 = this.mLastPTS;
    long l1 = paramLong;
    if (l2 >= paramLong) {
      l1 = 2L + l2;
    }
    synchronized (this.mEncodedAudioList)
    {
      do
      {
        if ((this.mEncodedAudioList.isEmpty()) || (this.mIsPause)) {
          break;
        }
        paramArrayOfByte = (byte[])this.mEncodedAudioList.get(0);
        this.mEncodedAudioList.remove(0);
        if (this.mShouldClearAACDataCnt > 0)
        {
          this.mShouldClearAACDataCnt -= 1;
          break;
        }
        paramLong = l1;
        if (paramArrayOfByte != null)
        {
          this.mLastPTS = l1;
          e locale = getListener();
          if (locale != null) {
            locale.onRecordEncData(paramArrayOfByte, l1, this.mSampleRate.get(), this.mChannels, this.mBits);
          } else {
            TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "onAudioRecordPCM listener is null");
          }
          paramInt = this.mSampleRate.get();
          paramLong = l1;
          if (paramInt > 0) {
            paramLong = l1 + (((Float)this.mSpeedRate.get()).floatValue() * 1024000.0F / paramInt);
          }
        }
        l1 = paramLong;
      } while (paramArrayOfByte != null);
      return;
    }
  }
  
  public void onAudioRecordStart()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record start");
  }
  
  public void onAudioRecordStop()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record stop");
  }
  
  public void onEncodedData(byte[] paramArrayOfByte)
  {
    synchronized (this.mEncodedAudioList)
    {
      this.mEncodedAudioList.add(paramArrayOfByte);
      return;
    }
  }
  
  public void pause()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "pause");
    TXCAudioEngine.getInstance().pauseLocalAudio();
    synchronized (this.mEncodedAudioList)
    {
      this.mIsPause = true;
      return;
    }
  }
  
  public void resume()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "resume");
    TXCAudioEngine.getInstance().resumeLocalAudio();
    synchronized (this.mEncodedAudioList)
    {
      this.mIsPause = false;
      nativeEnableMixMode(this.mEnableBGMRecord);
      if ((!this.mIsMute) && (!this.mEnableBGMRecord))
      {
        nativeSetVolume(this.mVolume);
        return;
      }
      nativeSetVolume(0.0F);
      return;
    }
  }
  
  public void setAECType(int paramInt, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAECType: ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
    this.mAECType = paramInt;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
  }
  
  public void setChangerType(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setChangerType: ");
      localStringBuilder.append(paramInt);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
      this.mVoiceChangerType = paramInt;
      nativeSetChangerType(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setChannels(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setChannels: ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
    this.mChannels = paramInt;
  }
  
  public void setListener(e parame)
  {
    if (parame == null) {}
    try
    {
      this.mWeakRecordListener = null;
      break label26;
      this.mWeakRecordListener = new WeakReference(parame);
      label26:
      return;
    }
    finally {}
  }
  
  public void setMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMute: ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
    this.mIsMute = paramBoolean;
    if (paramBoolean)
    {
      nativeSetVolume(0.0F);
      return;
    }
    nativeSetVolume(this.mVolume);
  }
  
  public void setReverbType(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setReverbType: ");
      localStringBuilder.append(paramInt);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
      this.mReverbType = paramInt;
      nativeSetReverbType(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSampleRate(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSampleRate: ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
    this.mSampleRate.set(paramInt);
  }
  
  public void setSpeedRate(float paramFloat)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeedRate: ");
      localStringBuilder.append(paramFloat);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
      this.mSpeedRate.set(Float.valueOf(paramFloat));
      nativeSetSpeedRate(((Float)this.mSpeedRate.get()).floatValue());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setVolume(float paramFloat)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVolume: ");
      localStringBuilder.append(paramFloat);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", localStringBuilder.toString());
      this.mVolume = paramFloat;
      if (this.mIsMute) {
        nativeSetVolume(0.0F);
      } else {
        nativeSetVolume(paramFloat);
      }
      return;
    }
    finally {}
  }
  
  public int startRecord(Context paramContext)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "startRecord");
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    updateAudioEffector();
    TXCAudioSysRecord.getInstance().setAudioRecordListener(this);
    nativeStartAudioRecord(this.mSampleRate.get(), this.mChannels, this.mBits);
    this.mIsRunning = true;
    this.mLastPTS = 0L;
    return 0;
  }
  
  public int stopRecord()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "stopRecord");
    TXCAudioSysRecord.getInstance().setAudioRecordListener(null);
    ??? = this.mBGMRecorder;
    if (??? != null)
    {
      ((a)???).a();
      this.mBGMRecorder = null;
    }
    nativeStopAudioRecord();
    nativeEnableMixMode(false);
    nativeSetVolume(1.0F);
    synchronized (this.mEncodedAudioList)
    {
      this.mEncodedAudioList.clear();
      this.mIsRunning = false;
      this.mLastPTS = 0L;
      this.mIsPause = false;
      this.mIsMute = false;
      this.mShouldClearAACDataCnt = 0;
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioUGCRecorder
 * JD-Core Version:    0.7.0.1
 */