package com.tencent.biz.qqcircle.share;

import android.app.Activity;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.IRichMediaListener;
import com.tencent.biz.qqcircle.share.interfaces.IDialogListener;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleBaseShareOperation$Builder
{
  private QCircleShareInfo a;
  private int b;
  private int c;
  private Activity d;
  private QCircleReportBean e;
  private String f;
  private byte[] g = null;
  private String h;
  private int i;
  private boolean j;
  private QCircleRichMediaDownLoadManager.IRichMediaListener k;
  private IDialogListener l;
  private boolean m;
  private int n;
  private boolean o;
  
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
    this.k = paramIRichMediaListener;
    return this;
  }
  
  public Builder a(IDialogListener paramIDialogListener)
  {
    this.l = paramIDialogListener;
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
  
  public Builder a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
    return this;
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.n = paramInt;
    return this;
  }
  
  public QCircleBaseShareOperation e(int paramInt)
  {
    return QCircleShareOperationProvider.a(this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder
 * JD-Core Version:    0.7.0.1
 */