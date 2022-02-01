package com.tencent.biz.pubaccount.weishi_new.report.dc898;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSPublicAccParamFactory
{
  public static IWSDCParam a(String paramString)
  {
    int i = WSVerticalUtils.a(paramString);
    if (TextUtils.equals(paramString, "trends")) {
      return new WSTrendsParam(i);
    }
    return new WSPublicAccParam(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.dc898.WSPublicAccParamFactory
 * JD-Core Version:    0.7.0.1
 */