package com.tencent.biz.pubaccount.weishi_new.report.dc898;

import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public abstract class IWSDCParam
{
  private int a;
  
  public IWSDCParam(int paramInt)
  {
    this.a = paramInt;
  }
  
  abstract String a();
  
  abstract String b();
  
  public String c()
  {
    return WSReportUtils.a(WeishiUtils.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.dc898.IWSDCParam
 * JD-Core Version:    0.7.0.1
 */