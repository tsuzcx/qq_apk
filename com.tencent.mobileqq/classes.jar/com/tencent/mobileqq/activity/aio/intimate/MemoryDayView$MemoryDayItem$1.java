package com.tencent.mobileqq.activity.aio.intimate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;

class MemoryDayView$MemoryDayItem$1
  implements View.OnClickListener
{
  MemoryDayView$MemoryDayItem$1(MemoryDayView.MemoryDayItem paramMemoryDayItem) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (MemoryDayView.MemoryDayItem.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (MemoryDayView.MemoryDayItem.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (IntimateInfoHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(MemoryDayView.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((IntimateInfoHandler)localObject).a(l1, MemoryDayView.MemoryDayItem.a(this.a).dateType);
    }
    for (;;)
    {
      if (MemoryDayView.MemoryDayItem.a(this.a) != null) {
        MemoryDayView.MemoryDayItem.a(this.a).a(paramView, MemoryDayView.MemoryDayItem.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((MemoryDayView.MemoryDayItem.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", MemoryDayView.MemoryDayItem.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        JumpAction localJumpAction = JumpParser.a((QQAppInterface)localObject, this.a.a.a, MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
        if (localJumpAction != null) {
          localJumpAction.a();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
          break;
          if (MemoryDayView.MemoryDayItem.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            QZoneHelper.onMQzoneSchema(this.a.a.a, MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
          } else {
            MemoryDayView.a(this.a.a.a, MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      ReportController.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", MemoryDayView.MemoryDayItem.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (MemoryDayView.a(this.a.a) == null) {
        break;
      }
      MemoryDayView.a(this.a.a).a(MemoryDayView.MemoryDayItem.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.MemoryDayView.MemoryDayItem.1
 * JD-Core Version:    0.7.0.1
 */