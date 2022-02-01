package com.tencent.biz.qrcode.activity;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQBrowserLinkSpan;

public class QRLoginAuthActivity$MyQQBrowserLinkSpan
  extends QQBrowserLinkSpan
{
  public QRLoginAuthActivity$MyQQBrowserLinkSpan(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext, paramString, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    ReportController.b(null, "dc00898", "", "", "0X800B5AC", "0X800B5AC", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity.MyQQBrowserLinkSpan
 * JD-Core Version:    0.7.0.1
 */