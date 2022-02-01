package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import android.view.View;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import java.util.Map;

public abstract class QCircleBaseReportReqInterceptor<T>
  implements ReqInterceptor<T, BaseSenderChain>
{
  protected String a;
  protected View b;
  protected Map<String, Object> c;
  private QCircleLpReportDc05501.DataBuilder d;
  private QCircleLpReportDc05507.DataBuilder e;
  
  public QCircleLpReportDc05501.DataBuilder a()
  {
    return this.d;
  }
  
  public void a(QCircleLpReportDc05501.DataBuilder paramDataBuilder)
  {
    this.d = paramDataBuilder;
  }
  
  public void a(QCircleLpReportDc05507.DataBuilder paramDataBuilder)
  {
    this.e = paramDataBuilder;
  }
  
  public void a(String paramString, View paramView, Map<String, Object> paramMap)
  {
    this.a = paramString;
    this.b = paramView;
    this.c = paramMap;
  }
  
  public QCircleLpReportDc05507.DataBuilder b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleBaseReportReqInterceptor
 * JD-Core Version:    0.7.0.1
 */