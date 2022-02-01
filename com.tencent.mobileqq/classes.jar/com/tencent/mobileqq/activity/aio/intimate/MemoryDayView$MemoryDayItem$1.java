package com.tencent.mobileqq.activity.aio.intimate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
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
    Object localObject1;
    long l1;
    if (MemoryDayView.MemoryDayItem.a(this.a) != null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i = MemoryDayView.MemoryDayItem.a(this.a).jumpType;
      if (i != 1)
      {
        if (i == 2)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", MemoryDayView.MemoryDayItem.a(this.a).dateType, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
          if (MemoryDayView.a(this.a.a) != null) {
            MemoryDayView.a(this.a.a).a(MemoryDayView.MemoryDayItem.a(this.a));
          }
        }
      }
      else if ((MemoryDayView.MemoryDayItem.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", MemoryDayView.MemoryDayItem.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        Object localObject2 = JumpParser.a((BaseQQAppInterface)localObject1, this.a.a.a, MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
        if (localObject2 != null) {
          ((JumpAction)localObject2).a();
        } else if (MemoryDayView.MemoryDayItem.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
          QZoneHelper.onMQzoneSchema(this.a.a.a, MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
        } else {
          MemoryDayView.a(this.a.a.a, MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("click  scheme: ");
          ((StringBuilder)localObject2).append(MemoryDayView.MemoryDayItem.a(this.a).linkUrl);
          QLog.d("intimate_relationship", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      }
      if (localObject1 == null) {
        break label442;
      }
      localObject1 = (IntimateInfoHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.valueOf(MemoryDayView.a(this.a.a)).longValue();
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label407:
      break label407;
    }
    QLog.e("intimate_relationship", 2, "valueOf string err");
    ((IntimateInfoHandler)localObject1).a(l1, MemoryDayView.MemoryDayItem.a(this.a).dateType);
    break label442;
    QLog.e("intimate_relationship", 2, "click  mInfo is null");
    label442:
    if (MemoryDayView.MemoryDayItem.a(this.a) != null) {
      MemoryDayView.MemoryDayItem.a(this.a).a(paramView, MemoryDayView.MemoryDayItem.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.MemoryDayView.MemoryDayItem.1
 * JD-Core Version:    0.7.0.1
 */