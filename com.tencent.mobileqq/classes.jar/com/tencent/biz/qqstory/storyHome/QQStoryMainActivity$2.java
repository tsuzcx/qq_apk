package com.tencent.biz.qqstory.storyHome;

import axcz;
import com.tencent.qphone.base.util.QLog;

class QQStoryMainActivity$2
  implements Runnable
{
  QQStoryMainActivity$2(QQStoryMainActivity paramQQStoryMainActivity) {}
  
  public void run()
  {
    axcz.b = System.currentTimeMillis();
    QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(axcz.b) });
    this.this$0.a.a(false, true, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.2
 * JD-Core Version:    0.7.0.1
 */