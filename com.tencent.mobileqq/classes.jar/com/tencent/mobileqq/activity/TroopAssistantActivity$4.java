package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssistantActivity$4
  implements View.OnClickListener
{
  TroopAssistantActivity$4(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.a.jdField_a_of_type_Long >= 1500L) {}
    for (;;)
    {
      try
      {
        this.a.jdField_a_of_type_Long = System.currentTimeMillis();
        int i = paramView.getId();
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick:" + localException.toString());
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopStoryMainActivity.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick, url:https://qqweb.qq.com/m/qunfeeds/index.html?_wv=1031&_bid=200");
      }
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      StoryReportor.a("grp_help", "clk_video", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.4
 * JD-Core Version:    0.7.0.1
 */