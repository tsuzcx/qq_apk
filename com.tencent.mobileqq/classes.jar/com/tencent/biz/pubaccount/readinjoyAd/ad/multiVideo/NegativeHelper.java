package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo.NegFeedback;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.KandianPopupWindowForAd;
import java.util.ArrayList;

public class NegativeHelper
  implements INegativeHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private IAdapter jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIAdapter;
  private KandianPopupWindowForAd jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd;
  
  public NegativeHelper(Activity paramActivity, IAdapter paramIAdapter)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIAdapter = paramIAdapter;
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = new KandianPopupWindowForAd(paramActivity);
  }
  
  public void a()
  {
    KandianPopupWindowForAd localKandianPopupWindowForAd = this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd;
    if ((localKandianPopupWindowForAd != null) && (localKandianPopupWindowForAd.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    NegativeHelper.2 local2 = new NegativeHelper.2(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a()) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd;
    int i = 0;
    ((KandianPopupWindowForAd)localObject).b = false;
    localObject = new ArrayList();
    if ((paramVideoInfo.a != null) && (paramVideoInfo.a.e != null)) {
      while (i < paramVideoInfo.a.e.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_Long = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_Long;
        localDislikeInfo.jdField_a_of_type_JavaLangString = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_JavaLangString;
        ((ArrayList)localObject).add(localDislikeInfo);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0)
    {
      ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.a);
      if (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a(paramInt, (ArrayList)localObject)) {
        this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a(paramView, local2);
      }
    }
  }
  
  public void a(View paramView, int paramInt, Object paramObject)
  {
    a(paramView, paramInt, (VideoInfo)paramObject);
  }
  
  public void b()
  {
    KandianPopupWindowForAd localKandianPopupWindowForAd = this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd;
    if ((localKandianPopupWindowForAd != null) && (localKandianPopupWindowForAd.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper
 * JD-Core Version:    0.7.0.1
 */