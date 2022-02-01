package com.tencent.image.api;

import android.content.Context;
import com.tencent.image.URLDrawable;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLStreamHandlerFactory;

public abstract class ITool
{
  URLStreamHandlerFactory defaultHandlerFactory = new ITool.1(this);
  
  public abstract Context getContext();
  
  public abstract URLStreamHandlerFactory getFactory();
  
  public void initURLStreamHandlerFactory()
  {
    URLStreamHandlerFactory localURLStreamHandlerFactory = getFactory();
    Object localObject1 = localURLStreamHandlerFactory;
    if (localURLStreamHandlerFactory == null) {
      localObject1 = this.defaultHandlerFactory;
    }
    try
    {
      URL.setURLStreamHandlerFactory((URLStreamHandlerFactory)localObject1);
      return;
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
      if (URLDrawable.depImp == null) {}
    }
    Object localObject2;
    for (localObject1 = URLDrawable.depImp.mLog;; localObject2 = null) {
      for (;;)
      {
        if (localObject1 != null) {
          ((ILog)localObject1).e("initURLStreamHandlerFactory", 1, "setURLStreamHandlerFactory fail", localThrowable2);
        }
        try
        {
          Object localObject3 = URL.class.getDeclaredField("factory");
          ((Field)localObject3).setAccessible(true);
          localObject3 = (URLStreamHandlerFactory)((Field)localObject3).get(null);
          if (localObject1 == null) {
            break;
          }
          ((ILog)localObject1).e("initURLStreamHandlerFactory", 1, localObject3.toString(), localThrowable2);
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          return;
        }
      }
    }
  }
  
  public abstract boolean loadSoByName(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.api.ITool
 * JD-Core Version:    0.7.0.1
 */