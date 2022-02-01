package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;

class PromoteWidgetController$2
  implements WebProcessStartListener
{
  PromoteWidgetController$2(PromoteWidgetController paramPromoteWidgetController) {}
  
  public void onResult(boolean paramBoolean)
  {
    SLog.a("PromoteWidgetController", "preloadSonicSession() doStartProcess=%b", Boolean.valueOf(paramBoolean));
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController.2
 * JD-Core Version:    0.7.0.1
 */