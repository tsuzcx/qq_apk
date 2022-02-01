package com.tencent.mobileqq.activity.springfestival.entry.helper;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;

public class SpringHbHelper
{
  public static volatile boolean a = false;
  private static volatile long b;
  private static volatile SpringHbHelper c;
  
  public static SpringHbHelper a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new SpringHbHelper();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static String a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (IPreloadRes)((QQAppInterface)localObject).getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (localObject != null) {
        return ((IPreloadRes)localObject).b(paramString);
      }
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - b > 60000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nowCallTime =");
      localStringBuilder.append(l);
      localStringBuilder.append("gLastLoadToolsProcessTime =");
      localStringBuilder.append(b);
      QLog.e("springHb_SpringHbHelper", 1, localStringBuilder.toString());
      b = l;
      QLog.i("springHb_SpringHbHelper", 1, "preloadToolsProcessImpl running");
      paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.startWebProcess(-1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper
 * JD-Core Version:    0.7.0.1
 */