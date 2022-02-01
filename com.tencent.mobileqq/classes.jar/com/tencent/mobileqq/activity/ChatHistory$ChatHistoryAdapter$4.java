package com.tencent.mobileqq.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;

class ChatHistory$ChatHistoryAdapter$4
  extends ClickableSpan
{
  ChatHistory$ChatHistoryAdapter$4(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.a));
    ReportController.b(this.c.f.app, "CliOper", "", this.b, "0X8004937", "0X8004937", 0, 0, "", "", "", "");
    try
    {
      this.c.c.startActivity(paramView);
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
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.4
 * JD-Core Version:    0.7.0.1
 */