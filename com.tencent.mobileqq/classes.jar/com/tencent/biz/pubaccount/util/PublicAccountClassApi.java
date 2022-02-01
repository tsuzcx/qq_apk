package com.tencent.biz.pubaccount.util;

import android.util.Log;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.qroute.QRoute;

public class PublicAccountClassApi
{
  public static String a()
  {
    try
    {
      String str = ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountHandler.class);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.w("PublicAccountClassApi", "getPublicAccountHandlerClassName", localThrowable);
    }
    return "";
  }
  
  public static String b()
  {
    try
    {
      String str = ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountArticleHandler.class);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.w("PublicAccountClassApi", "getPublicAccountArticleHandlerClassName", localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountClassApi
 * JD-Core Version:    0.7.0.1
 */