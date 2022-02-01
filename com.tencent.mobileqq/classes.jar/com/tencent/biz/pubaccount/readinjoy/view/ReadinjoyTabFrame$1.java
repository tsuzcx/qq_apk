package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class ReadinjoyTabFrame$1
  implements View.OnClickListener
{
  ReadinjoyTabFrame$1(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a).setText("");
    ReadinjoyTabFrame.a(this.a).setVisibility(8);
    ReadinjoyReportUtils.a(this.a.a(), true);
    ((KandianMergeManager)this.a.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).d(true);
    RIJMsgBoxUtils.a(this.a.a(), 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.1
 * JD-Core Version:    0.7.0.1
 */