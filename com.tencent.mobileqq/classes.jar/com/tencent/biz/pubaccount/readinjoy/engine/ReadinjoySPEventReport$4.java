package com.tencent.biz.pubaccount.readinjoy.engine;

import bgnt;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;
import com.tencent.common.app.BaseApplicationImpl;

public final class ReadinjoySPEventReport$4
  implements Runnable
{
  public void run()
  {
    int i = bgnt.a(BaseApplicationImpl.getContext());
    String str;
    if ((i == 2) || (i == 3) || (i == 4)) {
      str = "WWAN";
    }
    for (;;)
    {
      str = TaskManager.getWifiStateJson(str);
      TaskManager.getInstance().accept(str);
      return;
      if (i == 1) {
        str = "WIFI";
      } else {
        str = "NONE";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.4
 * JD-Core Version:    0.7.0.1
 */