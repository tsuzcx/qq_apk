package com.tencent.image;

public class VideoDrawable$VideoDrawableParams
{
  public String mAfPath;
  public int mDecodeType = 0;
  public boolean mEnableAntiAlias = false;
  public boolean mEnableFilter = false;
  public boolean mPlayAudioFrame = false;
  public boolean mPlayVideoFrame = true;
  public int mRequestedFPS = -1;
  public int mTotalTime;
  public String mVfPath;
  public int mVideoFrames;
  public int mVideoRoundCorner;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(" mVideoRoundCorner: " + this.mVideoRoundCorner);
    localStringBuilder.append(" mPlayVideoFrame: " + this.mPlayVideoFrame);
    localStringBuilder.append(" mPlayAudioFrame: " + this.mPlayAudioFrame);
    localStringBuilder.append(" mEnableAntiAlias: " + this.mEnableAntiAlias);
    localStringBuilder.append(" mEnableFilter: " + this.mEnableFilter);
    localStringBuilder.append(" mRequestedFPS: " + this.mRequestedFPS);
    localStringBuilder.append(" mDecodeType: " + this.mDecodeType);
    localStringBuilder.append(" mVfPath: " + this.mVfPath);
    localStringBuilder.append(" mAfPath: " + this.mAfPath);
    localStringBuilder.append(" mTotalTime: " + this.mTotalTime);
    localStringBuilder.append(" mVideoFrames: " + this.mVideoFrames);
    localStringBuilder.append("] ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.VideoDrawable.VideoDrawableParams
 * JD-Core Version:    0.7.0.1
 */