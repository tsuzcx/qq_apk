package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class TopicShareHelper$2
  implements View.OnClickListener
{
  TopicShareHelper$2(TopicShareHelper paramTopicShareHelper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    if (TopicShareHelper.a(this.a).isShowing()) {
      TopicShareHelper.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.2
 * JD-Core Version:    0.7.0.1
 */