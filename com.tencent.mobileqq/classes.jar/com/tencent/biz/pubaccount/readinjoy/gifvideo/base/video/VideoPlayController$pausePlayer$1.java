package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoPlayController$pausePlayer$1
  extends Lambda
  implements Function0<Unit>
{
  VideoPlayController$pausePlayer$1(VideoPlayController paramVideoPlayController, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    IPlayer localIPlayer = this.this$0.a();
    if (localIPlayer != null) {
      localIPlayer.b();
    }
    this.$runnable.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController.pausePlayer.1
 * JD-Core Version:    0.7.0.1
 */