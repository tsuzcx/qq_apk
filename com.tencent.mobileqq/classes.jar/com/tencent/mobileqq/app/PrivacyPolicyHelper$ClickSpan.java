package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class PrivacyPolicyHelper$ClickSpan
  extends ClickableSpan
{
  String a;
  Context b;
  String c;
  
  public PrivacyPolicyHelper$ClickSpan(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.b = paramContext;
    this.c = paramString1;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.a));
      this.b.startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
      QLog.d("PrivacyPolicyHelper", 1, "no system browser exp=", paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrivacyPolicyHelper.ClickSpan
 * JD-Core Version:    0.7.0.1
 */