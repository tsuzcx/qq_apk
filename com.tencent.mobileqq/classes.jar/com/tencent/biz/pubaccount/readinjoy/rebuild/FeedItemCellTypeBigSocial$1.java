package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnSubRegionClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class FeedItemCellTypeBigSocial$1
  implements View.OnClickListener
{
  FeedItemCellTypeBigSocial$1(FeedItemCellTypeBigSocial paramFeedItemCellTypeBigSocial, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyHelper.f(ReadInJoyUtils.a(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() + this.b.getTop() + this.c.getTop());
    OnSubRegionClickListener localOnSubRegionClickListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCellTypeBigSocial.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(null, ((IReadInJoyModel)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCellTypeBigSocial.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout top" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout width" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout top" + this.b.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout width" + this.b.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout top" + this.c.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout width" + this.c.getWidth() });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeBigSocial.1
 * JD-Core Version:    0.7.0.1
 */