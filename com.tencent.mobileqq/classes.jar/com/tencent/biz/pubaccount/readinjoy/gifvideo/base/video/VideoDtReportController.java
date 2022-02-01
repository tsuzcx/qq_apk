package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDtReportController;", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "videoPlayController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "dtPgid", "getDtPgid", "setDtPgid", "playSessionId", "getPlaySessionId", "setPlaySessionId", "getVideoPlayController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "onStateChanged", "", "oldState", "", "newState", "reportDtVideoEnd", "reportDtVideoStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoDtReportController
  implements VideoPlayController.OnStateChangeListener
{
  @Nullable
  private VideoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private String b;
  @Nullable
  private String c;
  
  public VideoDtReportController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController = paramVideoPlayController;
    this.jdField_a_of_type_JavaLangString = "VideoDtReportController";
    paramVideoPlayController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  private final void a()
  {
    BaseArticleInfo localBaseArticleInfo = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayController)localObject1).a();
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
      if (localObject2 == null) {
        break label100;
      }
      localObject2 = ((VideoPlayController)localObject2).a();
      label31:
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
      if (localObject3 == null) {
        break label105;
      }
      localObject3 = ((VideoPlayController)localObject3).a();
      if (localObject3 == null) {
        break label105;
      }
    }
    label100:
    label105:
    for (Object localObject3 = ((IVideoView)localObject3).a();; localObject3 = null)
    {
      VideoPlayController localVideoPlayController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
      if (localVideoPlayController != null) {
        localBaseArticleInfo = localVideoPlayController.a();
      }
      KotlinUtilKt.a(localObject1, localObject2, localObject3, localBaseArticleInfo, (Function4)new VideoDtReportController.reportDtVideoStart.1(this));
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label31;
    }
  }
  
  private final void b()
  {
    BaseArticleInfo localBaseArticleInfo = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayController)localObject1).a();
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
      if (localObject2 == null) {
        break label100;
      }
      localObject2 = ((VideoPlayController)localObject2).a();
      label31:
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
      if (localObject3 == null) {
        break label105;
      }
      localObject3 = ((VideoPlayController)localObject3).a();
      if (localObject3 == null) {
        break label105;
      }
    }
    label100:
    label105:
    for (Object localObject3 = ((IVideoView)localObject3).a();; localObject3 = null)
    {
      VideoPlayController localVideoPlayController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
      if (localVideoPlayController != null) {
        localBaseArticleInfo = localVideoPlayController.a();
      }
      KotlinUtilKt.a(localObject1, localObject2, localObject3, localBaseArticleInfo, (Function4)new VideoDtReportController.reportDtVideoEnd.1(this));
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label31;
    }
  }
  
  @Nullable
  public final String a()
  {
    return this.b;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @Nullable
  public final String b()
  {
    return this.c;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoDtReportController
 * JD-Core Version:    0.7.0.1
 */