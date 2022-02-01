package com.tencent.mobileqq.app.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

final class NicknameAppendNetStateUtil$1
  extends ClickableSpan
{
  NicknameAppendNetStateUtil$1(AppRuntime paramAppRuntime) {}
  
  public void onClick(@NonNull View paramView)
  {
    ReportController.a(this.a, "dc00898", "", "", "0X800BC3B", "0X800BC3B", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.NicknameAppendNetStateUtil.1
 * JD-Core Version:    0.7.0.1
 */