package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine;

import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState$Companion;", "", "()V", "COMPLETE", "", "DESTROY", "ERROR", "IDLE", "INITED", "INITING", "INSTALLED", "INSTALLING", "OPENING", "PAUSE", "PLAYING", "PREPARED", "STOP", "TAG", "", "createPTSVideoState", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState;", "state", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "videoPlayManager", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoState$Companion
{
  @NotNull
  public final VideoState a(@NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2, @Nullable VideoView paramVideoView, @Nullable VideoPlayController paramVideoPlayController)
  {
    Intrinsics.checkParameterIsNotNull(paramAtomicInteger1, "state");
    Intrinsics.checkParameterIsNotNull(paramAtomicInteger2, "action");
    switch (paramAtomicInteger1.get())
    {
    default: 
      return (VideoState)new IdleState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case -1: 
      return (VideoState)new ErrorState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 0: 
      return (VideoState)new IdleState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 1: 
      return (VideoState)new InstallingState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 2: 
      return (VideoState)new InstalledState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 3: 
      return (VideoState)new InitingState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 4: 
      return (VideoState)new InitedState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 5: 
      return (VideoState)new OpeningState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 6: 
      return (VideoState)new PreparedState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 7: 
      return (VideoState)new PlayingState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 8: 
      return (VideoState)new PauseState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 9: 
      return (VideoState)new StopState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    case 10: 
      return (VideoState)new CompleteState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    }
    return (VideoState)new DestroyState(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine.VideoState.Companion
 * JD-Core Version:    0.7.0.1
 */