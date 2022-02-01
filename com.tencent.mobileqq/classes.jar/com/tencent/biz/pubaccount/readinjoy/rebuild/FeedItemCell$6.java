package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.widget.KandianNegativeWindow;

class FeedItemCell$6
  implements PopupWindow.OnDismissListener
{
  FeedItemCell$6(FeedItemCell paramFeedItemCell, KandianNegativeWindow paramKandianNegativeWindow) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.a(1.0F);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.6
 * JD-Core Version:    0.7.0.1
 */