package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter$onColumnActionObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "onViolaPageFailed", "", "violaPageName", "", "fromType", "", "onViolaTopicVideoAnimStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter$onColumnActionObserver$1
  extends ReadInJoyObserver
{
  public void f(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "violaPageName");
    if ((paramInt == 1) || (paramInt == 2))
    {
      paramString = this.a.a();
      if (paramString == null) {
        break label64;
      }
    }
    label64:
    for (paramString = paramString.a; paramString != null; paramString = null)
    {
      paramString = this.a.a();
      if (paramString != null)
      {
        paramString = paramString.a;
        if (paramString != null) {
          paramString.o();
        }
      }
      return;
    }
    QLog.e("VideoFeedsRecommendPresenter", 2, "onViolaPageFailed callback, attachVideoPlayer videoPlayer is null");
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendPresenter", 2, "onViolaTopicVideoAnimStart mVideoFromType：" + this.a.b());
    }
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this);
    if (ReadInJoyHelper.g(this.a.b()))
    {
      localObject = this.a.a();
      if (localObject != null) {
        ((Activity)localObject).finish();
      }
    }
    do
    {
      return;
      VideoFeedsRecommendPresenter.a(this.a, true);
    } while (this.a.a() == null);
    Object localObject = this.a.a();
    if (localObject != null) {
      ((VideoFeedsPlayManager.VideoPlayParam)localObject).a = ((VideoPlayerWrapper)null);
    }
    this.a.a().b(ReportConstants.VideoEndType.EXIT_SCENE);
    this.a.a().b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.onColumnActionObserver.1
 * JD-Core Version:    0.7.0.1
 */