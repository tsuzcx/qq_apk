package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGuideProxy;", "", "()V", "columnGuideManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "getColumnGuideManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "setColumnGuideManager", "(Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;)V", "hasShowVideoColumnGuide", "", "userGuideController", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "getUserGuideController", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "setUserGuideController", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;)V", "dismissGuideAnim", "", "getPlayPercent", "", "currentTs", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "hideUserGuide", "needShowVideoColumnGuide", "onVideoProgressChange", "rootView", "Landroid/view/View;", "videoRootView", "setFullScreen", "fullScreen", "setNeedUserGuide", "needGuide", "showUserGuide", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsGuideProxy
{
  public static final VideoFeedsGuideProxy.Companion a;
  @Nullable
  private VideofeedsUserGuideController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController;
  @Nullable
  private VideoColumnGuideManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnGuideManager;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy$Companion = new VideoFeedsGuideProxy.Companion(null);
  }
  
  private final float a(long paramLong, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (paramVideoPlayParam != null) {}
    for (long l = paramVideoPlayParam.b();; l = 0L) {
      return (float)paramLong * 100.0F / (float)l;
    }
  }
  
  private final boolean a(long paramLong, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    return (PlayerHelper.a.a()) && (!this.jdField_a_of_type_Boolean) && (a(paramLong, paramVideoPlayParam) >= 20) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  public final void a()
  {
    VideofeedsUserGuideController localVideofeedsUserGuideController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController;
    if (localVideofeedsUserGuideController != null) {
      localVideofeedsUserGuideController.a();
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoInfo.a == null)
    {
      VideofeedsUserGuideController localVideofeedsUserGuideController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController;
      if (localVideofeedsUserGuideController != null) {
        localVideofeedsUserGuideController.a(paramVideoInfo);
      }
    }
  }
  
  public final void a(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (a(paramLong, paramVideoPlayParam))
    {
      paramVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnGuideManager;
      if (paramVideoPlayParam == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = paramVideoPlayParam.a(paramView1, paramView2);; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public final void a(@Nullable VideofeedsUserGuideController paramVideofeedsUserGuideController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController = paramVideofeedsUserGuideController;
  }
  
  public final void a(@Nullable VideoColumnGuideManager paramVideoColumnGuideManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnGuideManager = paramVideoColumnGuideManager;
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController;
    if (localObject != null) {
      ((VideofeedsUserGuideController)localObject).a(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnGuideManager;
    if (localObject != null) {
      ((VideoColumnGuideManager)localObject).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController;
    if (localObject != null) {
      ((VideofeedsUserGuideController)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnGuideManager;
    if (localObject != null) {
      ((VideoColumnGuideManager)localObject).a();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    VideofeedsUserGuideController localVideofeedsUserGuideController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController;
    if (localVideofeedsUserGuideController != null) {
      localVideofeedsUserGuideController.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGuideProxy
 * JD-Core Version:    0.7.0.1
 */