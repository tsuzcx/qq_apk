package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.QIMShortVideoUtils;

class ReadinjoyTabFrame$4
  implements View.OnClickListener
{
  ReadinjoyTabFrame$4(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    RIJTabFrameDeliverPopupUtil.a(this.a, ReadinjoyTabFrame.a(this.a), false);
    if (BaseApplicationImpl.sProcessId != 9) {
      QIMShortVideoUtils.a(BaseApplicationImpl.getContext());
    }
    RIJFrameworkReportManager.a("1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.4
 * JD-Core Version:    0.7.0.1
 */