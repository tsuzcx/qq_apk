package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.qz.ac;
import com.tencent.luggage.wxa.qz.o;

class ab$4
  extends ac<Boolean>
{
  ab$4(ab paramab, long paramLong, Boolean paramBoolean)
  {
    super(paramLong, paramBoolean);
  }
  
  protected Boolean a()
  {
    try
    {
      ab.c(this.a);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeAll error ");
      localStringBuilder.append(localException);
      o.b("MicroMsg.AppBrandWebViewCustomViewContainer", localStringBuilder.toString());
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab.4
 * JD-Core Version:    0.7.0.1
 */