package com.tencent.biz.pubaccount.ecshopassit.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.RedPointInfo;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.TabConfBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CustomTitleView$5
  implements View.OnClickListener
{
  CustomTitleView$5(CustomTitleView paramCustomTitleView, List paramList) {}
  
  public void onClick(View paramView)
  {
    EcshopConfBean.TabConfBean localTabConfBean;
    RedPointInfo localRedPointInfo;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      localTabConfBean = (EcshopConfBean.TabConfBean)this.jdField_a_of_type_JavaUtilList.get(0);
      if (CustomTitleView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView) == null) {
        break label119;
      }
      Iterator localIterator = CustomTitleView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localRedPointInfo = (RedPointInfo)localIterator.next();
      } while (localRedPointInfo.b != localTabConfBean.a);
    }
    for (;;)
    {
      CustomTitleView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView, localTabConfBean, localRedPointInfo);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        CustomTitleView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView, this.jdField_a_of_type_JavaUtilList, CustomTitleView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView));
      }
      label119:
      localRedPointInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView.5
 * JD-Core Version:    0.7.0.1
 */