package com.tencent.biz.qqstory.newshare.callback;

import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import java.lang.ref.WeakReference;

public class OnPlayModeShareListener
  extends OnSimpleShareListener
{
  private final WeakReference a;
  
  public OnPlayModeShareListener(VideoPlayModeBase paramVideoPlayModeBase)
  {
    this.a = new WeakReference(paramVideoPlayModeBase);
  }
  
  public void a()
  {
    super.a();
    VideoPlayModeBase localVideoPlayModeBase = (VideoPlayModeBase)this.a.get();
    if (localVideoPlayModeBase != null) {
      localVideoPlayModeBase.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.callback.OnPlayModeShareListener
 * JD-Core Version:    0.7.0.1
 */