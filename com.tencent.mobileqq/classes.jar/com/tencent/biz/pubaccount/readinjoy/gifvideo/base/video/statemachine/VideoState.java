package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine;

import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState;", "", "state", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "videoPlayController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;)V", "getAction", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAction", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getState", "setState", "getVideoPlayController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;)V", "getVideoView", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "setVideoView", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;)V", "changeToNewState", "", "newState", "", "goToNextState", "handleAction", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class VideoState
{
  public static final VideoState.Companion a;
  @Nullable
  private VideoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
  @Nullable
  private VideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
  @NotNull
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  @NotNull
  private AtomicInteger b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoStatemachineVideoState$Companion = new VideoState.Companion(null);
  }
  
  public VideoState(@NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2, @Nullable VideoView paramVideoView, @Nullable VideoPlayController paramVideoPlayController)
  {
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
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 83	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual 86	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState:a	()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +85 -> 101
    //   19: aload_1
    //   20: getfield 92	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView:tag	Ljava/lang/String;
    //   23: astore_1
    //   24: ldc 94
    //   26: iconst_1
    //   27: aload_2
    //   28: aload_1
    //   29: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 100
    //   34: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokevirtual 102	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState:a	()Ljava/util/concurrent/atomic/AtomicInteger;
    //   41: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: ldc 107
    //   46: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: invokevirtual 109	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState:b	()Ljava/util/concurrent/atomic/AtomicInteger;
    //   53: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: invokevirtual 109	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState:b	()Ljava/util/concurrent/atomic/AtomicInteger;
    //   66: invokevirtual 125	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   69: bipush 7
    //   71: if_icmpne +27 -> 98
    //   74: aload_0
    //   75: invokevirtual 127	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState:a	()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +18 -> 98
    //   83: aload_1
    //   84: new 129	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState$handleAction$1
    //   87: dup
    //   88: aload_0
    //   89: invokespecial 132	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState$handleAction$1:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/statemachine/VideoState;)V
    //   92: checkcast 134	kotlin/jvm/functions/Function0
    //   95: invokevirtual 140	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController:e	(Lkotlin/jvm/functions/Function0;)V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: aconst_null
    //   102: astore_1
    //   103: goto -79 -> 24
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	VideoState
    //   14	89	1	localObject1	Object
    //   106	4	1	localObject2	Object
    //   9	19	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	15	106	finally
    //   19	24	106	finally
    //   24	79	106	finally
    //   83	98	106	finally
  }
  
  public final void a(int paramInt)
  {
    int i = a().get();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = a();
    if (localObject != null) {}
    for (localObject = ((VideoView)localObject).tag;; localObject = null)
    {
      QLog.d("VideoState", 1, (String)localObject + " change state from " + i + " to " + paramInt);
      a().set(paramInt);
      d();
      localObject = a();
      if (localObject != null) {
        ((VideoPlayController)localObject).a(i, paramInt);
      }
      return;
    }
  }
  
  @NotNull
  public AtomicInteger b()
  {
    return this.b;
  }
  
  public final void d()
  {
    VideoPlayController localVideoPlayController = a();
    if (localVideoPlayController != null) {
      localVideoPlayController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine.VideoState
 * JD-Core Version:    0.7.0.1
 */