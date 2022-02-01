package com.tencent.gdtad.web;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.smtt.sdk.ValueCallback;

class GdtLandingPageReport$2$1
  implements ValueCallback<String>
{
  GdtLandingPageReport$2$1(GdtLandingPageReport.2 param2) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" injectScript scene: ");
    localStringBuilder.append(this.a.jdField_a_of_type_Int);
    localStringBuilder.append(" 回调耗时: ");
    localStringBuilder.append(System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
    localStringBuilder.append(" 回调. resp: ");
    localStringBuilder.append(paramString);
    GdtLog.a("GdtLandingPageReport", localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentGdtadWebGdtLandingPageReport$WebviewEvaluateListener != null) {
      this.a.jdField_a_of_type_ComTencentGdtadWebGdtLandingPageReport$WebviewEvaluateListener.a(paramString);
    }
    if (paramString.equals("true"))
    {
      this.a.this$0.a(1501001);
      return;
    }
    this.a.this$0.a(1501002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport.2.1
 * JD-Core Version:    0.7.0.1
 */