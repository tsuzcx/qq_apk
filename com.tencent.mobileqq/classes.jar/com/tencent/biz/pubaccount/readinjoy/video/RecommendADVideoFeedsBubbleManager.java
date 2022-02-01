package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

public class RecommendADVideoFeedsBubbleManager
{
  private void a(IProteusItemView paramIProteusItemView, VideoPlayParam paramVideoPlayParam, IVideoPlayManager paramIVideoPlayManager)
  {
    paramIProteusItemView = paramIProteusItemView.a().getVirtualView().findViewBaseByName("id_article_bubble_view");
    if ((paramIProteusItemView != null) && (paramIProteusItemView.getNativeView() != null) && ((paramIProteusItemView instanceof ReadInJoyAdBubbleView))) {
      try
      {
        paramIProteusItemView = (ReadInJoyAdBubbleView)paramIProteusItemView;
        if ((paramIVideoPlayManager != null) && (paramIVideoPlayManager.a() != null) && ((paramIVideoPlayManager.a().d() instanceof ReadInJoyAdBubbleNativeView)))
        {
          paramIVideoPlayManager = (ReadInJoyAdBubbleNativeView)paramIVideoPlayManager.a().d();
          paramIVideoPlayManager.a((AdvertisementInfo)paramVideoPlayParam.a);
          paramIVideoPlayManager.setVisibility(0);
          paramIProteusItemView.a();
          return;
        }
      }
      catch (Throwable paramIProteusItemView)
      {
        paramVideoPlayParam = new StringBuilder();
        paramVideoPlayParam.append(" showBubble exception = ");
        paramVideoPlayParam.append(paramIProteusItemView.toString());
        QLog.e("RecommendADVideoFeedsBubbleManager", 1, paramVideoPlayParam.toString());
      }
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, ReadInJoyXListView paramReadInJoyXListView, IVideoPlayManager paramIVideoPlayManager)
  {
    if ((paramVideoPlayParam != null) && (paramReadInJoyXListView != null))
    {
      int i = 0;
      while (i < paramReadInJoyXListView.getChildCount())
      {
        View localView = paramReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131380884);
        if (((localObject instanceof IReadInJoyModel)) && (((IReadInJoyModel)localObject).a() == paramVideoPlayParam.a) && ((localView instanceof IProteusItemView)))
        {
          a((IProteusItemView)localView, paramVideoPlayParam, paramIVideoPlayManager);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsBubbleManager
 * JD-Core Version:    0.7.0.1
 */