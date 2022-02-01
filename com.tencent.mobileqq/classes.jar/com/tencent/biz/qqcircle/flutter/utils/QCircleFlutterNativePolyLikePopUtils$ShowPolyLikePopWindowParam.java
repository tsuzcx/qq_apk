package com.tencent.biz.qqcircle.flutter.utils;

import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleFlutterNativePolyLikePopUtils$ShowPolyLikePopWindowParam
{
  private View a;
  private QCirclePolyLikeAniView b;
  private QCircleReportBean c;
  private QCircleExtraTypeInfo d;
  
  public static ShowPolyLikePopWindowParam e()
  {
    return new ShowPolyLikePopWindowParam();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public ShowPolyLikePopWindowParam a(View paramView)
  {
    this.a = paramView;
    return this;
  }
  
  public ShowPolyLikePopWindowParam a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.d = paramQCircleExtraTypeInfo;
    return this;
  }
  
  public ShowPolyLikePopWindowParam a(QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.b = paramQCirclePolyLikeAniView;
    return this;
  }
  
  public ShowPolyLikePopWindowParam a(QCircleReportBean paramQCircleReportBean)
  {
    this.c = paramQCircleReportBean;
    return this;
  }
  
  public QCirclePolyLikeAniView b()
  {
    return this.b;
  }
  
  public QCircleReportBean c()
  {
    return this.c;
  }
  
  public QCircleExtraTypeInfo d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.utils.QCircleFlutterNativePolyLikePopUtils.ShowPolyLikePopWindowParam
 * JD-Core Version:    0.7.0.1
 */