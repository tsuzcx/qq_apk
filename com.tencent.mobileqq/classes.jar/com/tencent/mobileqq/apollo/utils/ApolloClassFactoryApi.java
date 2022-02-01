package com.tencent.mobileqq.apollo.utils;

import android.util.Log;
import com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory;
import com.tencent.mobileqq.qroute.QRoute;

public class ApolloClassFactoryApi
{
  public static Class a()
  {
    try
    {
      Class localClass = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloContentUpdateStatusClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloContentUpdateStatusClass]", localThrowable);
    }
    return null;
  }
  
  public static Class b()
  {
    try
    {
      Class localClass = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloExtensionServletClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloExtensionServletClass]", localThrowable);
    }
    return null;
  }
  
  public static Class c()
  {
    try
    {
      Class localClass = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloElemDecoderClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloElemDecoderClass]", localThrowable);
    }
    return null;
  }
  
  public static Class d()
  {
    try
    {
      Class localClass = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloRecentManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloRecentManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class e()
  {
    try
    {
      Class localClass = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getMessageForApolloClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloRecentManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static Class f()
  {
    try
    {
      Class localClass = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloResponseManagerClass();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloResponseManagerClass]", localThrowable);
    }
    return null;
  }
  
  public static String g()
  {
    try
    {
      String str = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloContentUpdateHandlerClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloContentUpdateHandlerClassName]", localThrowable);
    }
    return null;
  }
  
  public static String h()
  {
    try
    {
      String str = ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloExtensionHandlerClassName();
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApolloClassFactoryApi", "[getApolloExtensionHandlerClassName]", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi
 * JD-Core Version:    0.7.0.1
 */