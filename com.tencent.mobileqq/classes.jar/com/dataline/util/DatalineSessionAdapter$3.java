package com.dataline.util;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;

class DatalineSessionAdapter$3
  extends ClickableSpan
{
  DatalineSessionAdapter$3(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), HardCodeUtil.a(2131694415), HardCodeUtil.a(2131694415));
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#00a5e0"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter.3
 * JD-Core Version:    0.7.0.1
 */