package com.tencent.biz.pubaccount.readinjoy;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class ReadInJoyChannelViewPagerController$1
  implements View.OnClickListener
{
  ReadInJoyChannelViewPagerController$1(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController) {}
  
  public void onClick(View paramView)
  {
    if (ChannelModeConfigHandler.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("currentIndex", ReadInJoyChannelViewPagerController.a(this.a).getCurrentItem());
      PublicTransFragmentActivity.b(ReadInJoyChannelViewPagerController.a(this.a), localIntent, ReadInJoyChannelPanelFragment.class);
      try
      {
        RIJChannelReporter.a("0X8009497", new RIJTransMergeKanDianReport.ReportR5Builder().b().c(this.a.a()).a());
        ReadInJoyChannelViewPagerController.a(this.a, false);
        ReadInJoyChannelViewPagerController.a(this.a).setVisibility(8);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadInJoyChannelViewPagerController", 1, QLog.getStackTraceString(localJSONException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.1
 * JD-Core Version:    0.7.0.1
 */