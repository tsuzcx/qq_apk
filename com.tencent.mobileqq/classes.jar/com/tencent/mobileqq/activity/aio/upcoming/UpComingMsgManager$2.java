package com.tencent.mobileqq.activity.aio.upcoming;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy.IColorNoteListener;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class UpComingMsgManager$2
  implements ColorNoteProxy.IColorNoteListener
{
  UpComingMsgManager$2(UpComingMsgManager paramUpComingMsgManager) {}
  
  public void a(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!ColorNoteUtils.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note add." + paramColorNote);
    }
    UpComingMsgManager.a(this.a, paramColorNote, 1001);
    ReportController.b(null, "dc00898", "", "", "0X800AE81", "0X800AE81", UpComingMsgUtil.a(paramColorNote).reportType, 0, "", "", "", "");
  }
  
  public void b(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!ColorNoteUtils.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note del." + paramColorNote);
    }
    UpComingMsgManager.a(this.a, paramColorNote, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager.2
 * JD-Core Version:    0.7.0.1
 */