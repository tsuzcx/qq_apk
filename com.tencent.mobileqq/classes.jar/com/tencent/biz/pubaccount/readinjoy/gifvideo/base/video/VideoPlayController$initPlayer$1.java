package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoPlayController$initPlayer$1
  extends Lambda
  implements Function0<Unit>
{
  VideoPlayController$initPlayer$1(VideoPlayController paramVideoPlayController, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if ((this.this$0.b().get() == 3) || (this.this$0.b().get() == 8)) {
      VideoPlayController.a(this.this$0, (Function0)new VideoPlayController.initPlayer.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController.initPlayer.1
 * JD-Core Version:    0.7.0.1
 */