package com.tencent.mobileqq.activity.aio.item;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;

class GrayTipsItemBuilder$4
  extends ClickableSpan
{
  GrayTipsItemBuilder$4(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.a));
    ReportController.b(this.b.a, "CliOper", "", this.b.d.b, "0X800491B", "0X800491B", 0, 0, "", "", "", "");
    try
    {
      this.b.c.startActivity(paramView);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16732929);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */