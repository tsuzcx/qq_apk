package com.tencent.biz.qqstory.base.videoupload;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import xvv;
import ypi;

@TargetApi(14)
public class VideoCompositeHelper$MusicCallBack
  extends ExecuteBinResponseCallback
{
  private int mErrorCode = 941000;
  private String mInPath;
  private String mOutPath;
  private long mStartTime = SystemClock.elapsedRealtime();
  private VideoCompositeHelper.VideoCompositeCallBack mVideoCompositeCallBack;
  
  public VideoCompositeHelper$MusicCallBack(String paramString1, String paramString2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    this.mInPath = paramString1;
    this.mOutPath = paramString2;
    this.mVideoCompositeCallBack = paramVideoCompositeCallBack;
  }
  
  public void onFailure(String paramString)
  {
    if (paramString.equals(String.valueOf(941001))) {
      this.mVideoCompositeCallBack.onVideoCompositeFinish(941001, paramString, "");
    }
    for (;;)
    {
      xvv.d(VideoCompositeHelper.TAG, "combine audio fail %s, %d", new Object[] { paramString, Integer.valueOf(this.mErrorCode) });
      ypi.g(this.mInPath);
      return;
      if (paramString.equals(String.valueOf(941002))) {
        this.mVideoCompositeCallBack.onVideoCompositeFinish(941002, paramString, "");
      } else {
        this.mVideoCompositeCallBack.onVideoCompositeFinish(this.mErrorCode, paramString, "");
      }
    }
  }
  
  public void onSuccess(String paramString)
  {
    xvv.a(VideoCompositeHelper.TAG, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.mStartTime));
    this.mVideoCompositeCallBack.onVideoCompositeFinish(0, "", this.mOutPath);
    ypi.g(this.mInPath);
  }
  
  public void setErrorCode(int paramInt)
  {
    this.mErrorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.MusicCallBack
 * JD-Core Version:    0.7.0.1
 */