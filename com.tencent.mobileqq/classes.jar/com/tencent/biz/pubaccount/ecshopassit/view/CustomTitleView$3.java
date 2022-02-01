package com.tencent.biz.pubaccount.ecshopassit.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.TabConfBean;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomTitleView$3
  implements View.OnClickListener
{
  CustomTitleView$3(CustomTitleView paramCustomTitleView, EcshopConfBean.TabConfBean paramTabConfBean, ImageView paramImageView, TextView paramTextView, RelativeLayout paramRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        ReportUtil.a(null, "gouwu.tab.click", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a);
        ReportUtil.b(null, "gouwu_tab_click", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a);
        if (this.jdField_a_of_type_AndroidWidgetImageView.getTag() != null) {
          continue;
        }
        i = 0;
        Integer localInteger = Integer.valueOf(i);
        if (localInteger.intValue() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          RedPointUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean.a, localInteger.intValue());
        }
        i = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean.a;
        int j = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a;
        if (i != j) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        QLog.e("CustomTitleView", 1, QLog.getStackTraceString(localThrowable));
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue();
      continue;
      CustomTitleView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView.3
 * JD-Core Version:    0.7.0.1
 */