package com.tencent.gdtad.inject;

import com.tencent.gdtad.impl.GdtWebViewImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GdtWebViewProxy
{
  @ConfigInject(configPath="Business/qqad-api/src/main/resources/Inject_AdInject.yml", version=1)
  public static ArrayList<Class<? extends IGdtWebView>> a = new ArrayList();
  
  static
  {
    a.add(GdtWebViewImpl.class);
  }
  
  public IGdtWebView a()
  {
    if (!a.isEmpty()) {
      try
      {
        IGdtWebView localIGdtWebView = (IGdtWebView)((Class)a.get(0)).newInstance();
        return localIGdtWebView;
      }
      catch (Exception localException)
      {
        QLog.e("GdtWebViewProxy", 1, localException, new Object[0]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createGdtWebView size = ");
        localStringBuilder.append(a.size());
        QLog.i("GdtWebViewProxy", 1, localStringBuilder.toString());
      }
    } else {
      QLog.i("GdtWebViewProxy", 1, "createGdtWebView is empty ");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.inject.GdtWebViewProxy
 * JD-Core Version:    0.7.0.1
 */