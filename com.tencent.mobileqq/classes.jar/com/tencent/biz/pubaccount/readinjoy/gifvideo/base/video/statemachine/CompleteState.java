package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine;

import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/CompleteState;", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState;", "state", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "videoPlayController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;)V", "getAction", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAction", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getState", "setState", "getVideoPlayController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;)V", "getVideoView", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "setVideoView", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;)V", "handleAction", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CompleteState
  extends VideoState
{
  @Nullable
  private VideoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
  @Nullable
  private VideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
  @NotNull
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  @NotNull
  private AtomicInteger b;
  
  public CompleteState(@NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2, @Nullable VideoView paramVideoView, @Nullable VideoPlayController paramVideoPlayController)
  {
    super(paramAtomicInteger1, paramAtomicInteger2, paramVideoView, paramVideoPlayController);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger1;
    this.b = paramAtomicInteger2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView = paramVideoView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController = paramVideoPlayController;
  }
  
  @Nullable
  public VideoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
  }
  
  @Nullable
  public VideoView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
  }
  
  @NotNull
  public AtomicInteger a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public void a()
  {
    VideoPlayController localVideoPlayController = a();
    if (localVideoPlayController != null) {
      localVideoPlayController.f();
    }
  }
  
  @NotNull
  public AtomicInteger b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine.CompleteState
 * JD-Core Version:    0.7.0.1
 */