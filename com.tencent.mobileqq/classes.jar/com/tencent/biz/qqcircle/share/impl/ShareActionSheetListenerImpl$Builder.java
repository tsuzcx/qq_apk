package com.tencent.biz.qqcircle.share.impl;

import android.app.Activity;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.IRichMediaListener;
import com.tencent.biz.qqcircle.share.interfaces.IDialogListener;
import cooperation.qqcircle.report.QCircleReportBean;

public class ShareActionSheetListenerImpl$Builder
{
  private QCircleShareInfo a;
  private int b;
  private int c;
  private Activity d;
  private QCircleReportBean e;
  private String f;
  private byte[] g = null;
  private QCircleRichMediaDownLoadManager.IRichMediaListener h;
  private IDialogListener i;
  
  public Builder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder a(Activity paramActivity)
  {
    this.d = paramActivity;
    return this;
  }
  
  public Builder a(QCircleShareInfo paramQCircleShareInfo)
  {
    this.a = paramQCircleShareInfo;
    return this;
  }
  
  public Builder a(QCircleRichMediaDownLoadManager.IRichMediaListener paramIRichMediaListener)
  {
    this.h = paramIRichMediaListener;
    return this;
  }
  
  public Builder a(IDialogListener paramIDialogListener)
  {
    this.i = paramIDialogListener;
    return this;
  }
  
  public Builder a(QCircleReportBean paramQCircleReportBean)
  {
    this.e = paramQCircleReportBean;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
    return this;
  }
  
  public ShareActionSheetListenerImpl a()
  {
    return new ShareActionSheetListenerImpl(this);
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.impl.ShareActionSheetListenerImpl.Builder
 * JD-Core Version:    0.7.0.1
 */