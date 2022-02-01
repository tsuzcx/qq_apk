package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoPlayController$executeOnSubThread$1
  implements Runnable
{
  VideoPlayController$executeOnSubThread$1(VideoPlayController paramVideoPlayController, Function0 paramFunction0) {}
  
  public final void run()
  {
    VideoView localVideoView = this.this$0.a();
    if (localVideoView != null) {}
    try
    {
      this.a.invoke();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController.executeOnSubThread.1
 * JD-Core Version:    0.7.0.1
 */