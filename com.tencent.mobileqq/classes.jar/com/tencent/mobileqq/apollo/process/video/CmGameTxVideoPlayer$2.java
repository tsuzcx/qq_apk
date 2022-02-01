package com.tencent.mobileqq.apollo.process.video;

import android.view.SurfaceHolder;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

class CmGameTxVideoPlayer$2
  implements IVideoViewBase.IVideoViewCallBack
{
  CmGameTxVideoPlayer$2(CmGameTxVideoPlayer paramCmGameTxVideoPlayer) {}
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    CmGameTxVideoPlayer.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */