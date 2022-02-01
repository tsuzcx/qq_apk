package com.tencent.biz.viewplugin;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.statistics.ReportController;

final class ViewPluginManager$1
  implements Runnable
{
  ViewPluginManager$1(Exception paramException) {}
  
  public void run()
  {
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_set_data", 0, 0, HtmlOffline.a("1002"), this.a.getClass().getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager.1
 * JD-Core Version:    0.7.0.1
 */