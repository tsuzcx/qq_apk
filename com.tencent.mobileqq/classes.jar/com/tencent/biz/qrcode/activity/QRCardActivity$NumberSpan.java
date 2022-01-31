package com.tencent.biz.qrcode.activity;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class QRCardActivity$NumberSpan
  extends URLSpan
{
  public QRCardActivity$NumberSpan(QRCardActivity paramQRCardActivity, String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    String str = getURL();
    if (!TextUtils.isEmpty(str))
    {
      if (!Pattern.compile("\\d{5,}").matcher(str).matches()) {
        break label42;
      }
      QRCardActivity.a(this.a, paramView.getContext(), 3, str, null);
    }
    label42:
    while (!Pattern.compile(QRCardActivity.o).matcher(str).matches()) {
      return;
    }
    this.a.a(str);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRCardActivity.NumberSpan
 * JD-Core Version:    0.7.0.1
 */