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
      if (URLDrawable.depImp != null) {
        localObject1 = URLDrawable.depImp.mLog;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        ((ILog)localObject1).e("initURLStreamHandlerFactory", 1, "setURLStreamHandlerFactory fail", localThrowable2);
      }
      try
      {
        Object localObject2 = URL.class.getDeclaredField("factory");
        ((Field)localObject2).setAccessible(true);
        localObject2 = (URLStreamHandlerFactory)((Field)localObject2).get(null);
        if (localObject1 != null)
        {
          ((ILog)localObject1).e("initURLStreamHandlerFactory", 1, localObject2.toString(), localThrowable2);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
    }
  }
  
  public abstract boolean loadSoByName(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.api.ITool
 * JD-Core Version:    0.7.0.1
 */