package com.tencent.av.screenshare;

import com.tencent.av.utils.PopupDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;

class ScreenShareHandler$1
  implements Runnable
{
  ScreenShareHandler$1(ScreenShareHandler paramScreenShareHandler, String paramString) {}
  
  public void run()
  {
    PopupDialog.a(BaseApplicationImpl.getContext(), 230, null, this.a, 2131718561, 2131718561, new ScreenShareHandler.1.1(this), null);
    ReportController.b(null, "dc00898", "", "", "0X800B8AB", "0X800B8AB", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareHandler.1
 * JD-Core Version:    0.7.0.1
 */