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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mVideoRoundCorner: ");
    localStringBuilder2.append(this.mVideoRoundCorner);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mPlayVideoFrame: ");
    localStringBuilder2.append(this.mPlayVideoFrame);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mPlayAudioFrame: ");
    localStringBuilder2.append(this.mPlayAudioFrame);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mEnableAntiAlias: ");
    localStringBuilder2.append(this.mEnableAntiAlias);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mEnableFilter: ");
    localStringBuilder2.append(this.mEnableFilter);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mRequestedFPS: ");
    localStringBuilder2.append(this.mRequestedFPS);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mDecodeType: ");
    localStringBuilder2.append(this.mDecodeType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mVfPath: ");
    localStringBuilder2.append(this.mVfPath);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mAfPath: ");
    localStringBuilder2.append(this.mAfPath);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mTotalTime: ");
    localStringBuilder2.append(this.mTotalTime);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mVideoFrames: ");
    localStringBuilder2.append(this.mVideoFrames);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("] ");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.VideoDrawable.VideoDrawableParams
 * JD-Core Version:    0.7.0.1
 */