package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.widget.KandianNegativeWindowForAd;

class FeedItemCell$4
  implements PopupWindow.OnDismissListener
{
  FeedItemCell$4(FeedItemCell paramFeedItemCell, KandianNegativeWindowForAd paramKandianNegativeWindowForAd) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(1.0F);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell.a.c())
    {
      VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell.a.a();
      if (localVideoPlayManager != null)
      {
        localVideoPlayManager.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell.a.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.4
 * JD-Core Version:    0.7.0.1
 */