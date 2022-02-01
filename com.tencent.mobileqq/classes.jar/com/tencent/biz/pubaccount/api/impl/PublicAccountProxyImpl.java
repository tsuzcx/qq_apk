package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;

public class PublicAccountProxyImpl
  implements IPublicAccountProxy
{
  public Class getImplClass(Class paramClass)
  {
    try
    {
      paramClass = Class.forName(getImplName(paramClass));
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
  }
  
  public String getImplName(Class paramClass)
  {
    try
    {
      String str = paramClass.getPackage().getName();
      paramClass = paramClass.getSimpleName();
      paramClass = str + ".impl." + paramClass.substring(1) + "Impl";
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return "";
  }
  
  public boolean isPublicAccountBrowser(Activity paramActivity)
  {
    return paramActivity instanceof PublicAccountBrowserImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountProxyImpl
 * JD-Core Version:    0.7.0.1
 */