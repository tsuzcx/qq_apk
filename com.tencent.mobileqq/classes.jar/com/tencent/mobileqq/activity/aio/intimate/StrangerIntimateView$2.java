package com.tencent.mobileqq.activity.aio.intimate;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

class StrangerIntimateView$2
  extends ClickableSpan
{
  StrangerIntimateView$2(StrangerIntimateView paramStrangerIntimateView, IntimateInfo.DNAInfo paramDNAInfo) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A20A ", "0X800A20A ", 0, 0, "", "", "", "");
    QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A20A");
    if (TextUtils.isEmpty(this.a.linkUrl))
    {
      QLog.e("intimate_relationship", 2, "linkUrl is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("click scheme: %s, scheme: %s", new Object[] { this.a.linkWording, this.a.linkUrl }));
    }
    paramView = JumpParser.a(this.b.a, this.b.c, this.a.linkUrl);
    if (paramView != null)
    {
      paramView.a();
      return;
    }
    if (this.a.linkUrl.toLowerCase().startsWith("mqzone://"))
    {
      QZoneHelper.onMQzoneSchema(this.b.c, this.a.linkUrl);
      return;
    }
    MemoryDayView.a(this.b.c, this.a.linkUrl);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    try
    {
      int j = Color.parseColor("#4D94FF");
      paramTextPaint.setColor(j);
      int i = j;
      if (this.a != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.a.linkColor)) {
          i = Color.parseColor(this.a.linkColor);
        }
      }
      paramTextPaint.setColor(i);
      return;
    }
    catch (IllegalArgumentException paramTextPaint)
    {
      label57:
      break label57;
    }
    QLog.e("intimate_relationship", 2, " color parse err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.2
 * JD-Core Version:    0.7.0.1
 */