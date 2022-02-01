package com.tencent.avgame.session;

import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qphone.base.util.QLog;

public class AVGameUserInfo
  extends QavDef.MultiUserInfo
{
  public int mAudioEnergy;
  public boolean mBigVideo = false;
  public long mEnterTime = 0L;
  public boolean mIsSelf;
  public boolean mIsSpeaking;
  public boolean mSubVideoOn = false;
  public int mSubVideoSrc = 0;
  public long mSubVideoTime = 0L;
  public boolean mVideoOn = false;
  public int mVideoSrc = 0;
  public long mVideoTime = 0L;
  public int mVolumeValue = 0;
  
  public AVGameUserInfo(QavDef.MultiUserInfo paramMultiUserInfo, long paramLong)
  {
    this.mUin = paramMultiUserInfo.mUin;
    this.mOpenId = paramMultiUserInfo.mOpenId;
    this.mMicOn = paramMultiUserInfo.mMicOn;
    if (paramLong == this.mUin) {
      bool = true;
    }
    this.mIsSelf = bool;
  }
  
  public boolean hasCameraVideo()
  {
    boolean bool2 = this.mVideoOn;
    boolean bool3 = bool2;
    if (bool2)
    {
      boolean bool4 = SecurityPolicyChecker.a().b();
      boolean bool1 = bool2;
      if (bool4)
      {
        bool1 = bool2;
        if (!this.mBigVideo)
        {
          bool1 = bool2;
          if (!SecurityPolicyChecker.a().b(this.mUin)) {
            bool1 = false;
          }
        }
      }
      bool3 = bool1;
      if (bool4)
      {
        bool3 = bool1;
        if (QLog.isDevelopLevel())
        {
          QLog.i("AVGameSession", 4, "hasCameraVideo, uin[" + this.mUin + "], ret[" + bool1 + "], videoOn[" + this.mVideoOn + "], bigVideo[" + this.mBigVideo + "]");
          bool3 = bool1;
        }
      }
    }
    return bool3;
  }
  
  public boolean hasSubVideo()
  {
    return this.mSubVideoOn;
  }
  
  public boolean hasVideo()
  {
    return (this.mVideoOn) || (this.mSubVideoOn);
  }
  
  public String toString()
  {
    return "AVGameUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + '\'' + ", mMicOn=" + this.mMicOn + ", mVideoOn=" + this.mVideoOn + ", mSubVideoOn=" + this.mSubVideoOn + ", mAudioEnergy=" + this.mAudioEnergy + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.session.AVGameUserInfo
 * JD-Core Version:    0.7.0.1
 */