package com.tencent.mobileqq.activity.aio.intimate.view;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.MemoryDayView;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

class IntimateContentItemOldDnaView$1
  extends ClickableSpan
{
  IntimateContentItemOldDnaView$1(IntimateContentItemOldDnaView paramIntimateContentItemOldDnaView, IntimateInfo.DNAInfo paramDNAInfo) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A20A ", "0X800A20A ", 0, 0, "", "", "", "");
    QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A20A");
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl))
    {
      QLog.e("intimate_relationship", 2, "linkUrl is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("click scheme: %s, scheme: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkWording, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl }));
    }
    paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl);
    if (paramView != null)
    {
      paramView.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl.toLowerCase().startsWith("mqzone://"))
    {
      QZoneHelper.onMQzoneSchema(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl);
      return;
    }
    MemoryDayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemOldDnaView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    try
    {
      int j = Color.parseColor("#4D94FF");
      paramTextPaint.setColor(j);
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkColor)) {
          i = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkColor);
        }
      }
      paramTextPaint.setColor(i);
      return;
    }
    catch (IllegalArgumentException paramTextPaint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("intimate_relationship", 1, " color parse err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemOldDnaView.1
 * JD-Core Version:    0.7.0.1
 */