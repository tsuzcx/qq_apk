package com.tencent.biz.qqcircle.flutter.utils;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleFlutterNativeShareUtils$ShareActionSheetParam
{
  private QCircleExtraTypeInfo a;
  private int b;
  private QCircleReportBean c;
  private boolean d = true;
  
  public ShareActionSheetParam a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public ShareActionSheetParam a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.a = paramQCircleExtraTypeInfo;
    return this;
  }
  
  public ShareActionSheetParam a(QCircleReportBean paramQCircleReportBean)
  {
    this.c = paramQCircleReportBean;
    return this;
  }
  
  public ShareActionSheetParam a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public boolean a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativeShareUtils.ShareActionSheetParam
 * JD-Core Version:    0.7.0.1
 */