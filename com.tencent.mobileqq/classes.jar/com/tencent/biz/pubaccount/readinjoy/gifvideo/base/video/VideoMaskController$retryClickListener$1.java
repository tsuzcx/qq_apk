package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VideoMaskController$retryClickListener$1
  implements View.OnClickListener
{
  VideoMaskController$retryClickListener$1(VideoMaskController paramVideoMaskController) {}
  
  public final void onClick(View paramView)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
    if (paramView.getId() == 2131381440)
    {
      QLog.d(this.a.a(), 1, "click feedback button");
      if ((VideoMaskController.a(this.a).getContext() instanceof Activity))
      {
        Context localContext = VideoMaskController.a(this.a).getContext();
        if (localContext == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
        PlayFeedbackHelper.a((Activity)localContext, (BaseArticleInfo)VideoMaskController.a(this.a), null, 6, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d(this.a.a(), 1, "click retry button");
      this.a.k();
      VideoMaskController.a(this.a).destroy();
      VideoMaskController.a(this.a).startPlay(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.retryClickListener.1
 * JD-Core Version:    0.7.0.1
 */