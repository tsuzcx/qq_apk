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
    catch (Throwable paramClass)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public String getImplName(Class paramClass)
  {
    try
    {
      String str = paramClass.getPackage().getName();
      paramClass = paramClass.getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(".impl.");
      localStringBuilder.append(paramClass.substring(1));
      localStringBuilder.append("Impl");
      paramClass = localStringBuilder.toString();
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      label58:
      break label58;
    }
    return "";
  }
  
  public boolean isPublicAccountBrowser(Activity paramActivity)
  {
    return paramActivity instanceof PublicAccountBrowserImpl;
  }
  
  public void setDataManagerAfterMsgSync() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountProxyImpl
 * JD-Core Version:    0.7.0.1
 */