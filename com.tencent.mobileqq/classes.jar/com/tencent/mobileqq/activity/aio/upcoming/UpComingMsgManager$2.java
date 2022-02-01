package com.tencent.mobileqq.activity.aio.upcoming;

import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteListener;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class UpComingMsgManager$2
  implements IColorNoteListener
{
  UpComingMsgManager$2(UpComingMsgManager paramUpComingMsgManager) {}
  
  public void a(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      if (!((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote(paramColorNote)) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("color note add.");
        localStringBuilder.append(paramColorNote);
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, localStringBuilder.toString());
      }
      UpComingMsgManager.a(this.a, paramColorNote, 1001);
      ReportController.b(null, "dc00898", "", "", "0X800AE81", "0X800AE81", UpComingMsgUtil.b(paramColorNote).reportType, 0, "", "", "", "");
    }
  }
  
  public void b(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      if (!((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote(paramColorNote)) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("color note del.");
        localStringBuilder.append(paramColorNote);
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, localStringBuilder.toString());
      }
      UpComingMsgManager.a(this.a, paramColorNote, 1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager.2
 * JD-Core Version:    0.7.0.1
 */