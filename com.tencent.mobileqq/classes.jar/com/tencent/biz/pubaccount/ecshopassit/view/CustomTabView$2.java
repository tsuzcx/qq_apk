package com.tencent.biz.pubaccount.ecshopassit.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.TabConfBean;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomTabView$2
  implements View.OnClickListener
{
  CustomTabView$2(CustomTabView paramCustomTabView, EcshopConfBean.TabConfBean paramTabConfBean, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        ReportUtil.a(null, "gouwu.tab.click", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a);
        ReportUtil.b(null, "gouwu_tab_click", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean.a + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a);
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
        int j = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a;
        if (i != j) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localThrowable));
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue();
      continue;
      CustomTabView.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean, this.jdField_a_of_type_AndroidWidgetTextView, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView.2
 * JD-Core Version:    0.7.0.1
 */