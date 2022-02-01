package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentJump$4
  implements View.OnClickListener
{
  ComponentJump$4(ComponentJump paramComponentJump, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyFooterPresenter.a(2, this.jdField_a_of_type_JavaLangString);
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump.4
 * JD-Core Version:    0.7.0.1
 */