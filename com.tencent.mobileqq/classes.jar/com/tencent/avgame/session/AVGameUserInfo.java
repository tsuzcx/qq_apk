package com.tencent.avgame.session;

import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qphone.base.util.QLog;

public class AVGameUserInfo
  extends QavDef.MultiUserInfo
{
  public int mAudioEnergy;
  public boolean mBigVideo;
  public long mEnterTime;
  public boolean mIsSelf;
  public boolean mIsSpeaking;
  public boolean mSubVideoOn;
  public int mSubVideoSrc;
  public long mSubVideoTime;
  public boolean mVideoOn;
  public int mVideoSrc;
  public long mVideoTime;
  public int mVolumeValue;
  
  public AVGameUserInfo(QavDef.MultiUserInfo paramMultiUserInfo, long paramLong)
  {
    boolean bool = false;
    this.mVideoOn = false;
    this.mVideoSrc = 0;
    this.mBigVideo = false;
    this.mVideoTime = 0L;
    this.mSubVideoOn = false;
    this.mSubVideoSrc = 0;
    this.mSubVideoTime = 0L;
    this.mEnterTime = 0L;
    this.mVolumeValue = 0;
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
      boolean bool4 = SecurityPolicyChecker.a().c();
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hasCameraVideo, uin[");
          localStringBuilder.append(this.mUin);
          localStringBuilder.append("], ret[");
          localStringBuilder.append(bool1);
          localStringBuilder.append("], videoOn[");
          localStringBuilder.append(this.mVideoOn);
          localStringBuilder.append("], bigVideo[");
          localStringBuilder.append(this.mBigVideo);
          localStringBuilder.append("]");
          QLog.i("AVGameSession", 4, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVGameUserInfo{mUin=");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append(", mOpenId='");
    localStringBuilder.append(this.mOpenId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMicOn=");
    localStringBuilder.append(this.mMicOn);
    localStringBuilder.append(", mVideoOn=");
    localStringBuilder.append(this.mVideoOn);
    localStringBuilder.append(", mSubVideoOn=");
    localStringBuilder.append(this.mSubVideoOn);
    localStringBuilder.append(", mAudioEnergy=");
    localStringBuilder.append(this.mAudioEnergy);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.session.AVGameUserInfo
 * JD-Core Version:    0.7.0.1
 */