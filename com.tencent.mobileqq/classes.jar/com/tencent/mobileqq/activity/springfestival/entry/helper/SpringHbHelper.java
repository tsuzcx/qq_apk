package com.tencent.mobileqq.activity.springfestival.entry.helper;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;

public class SpringHbHelper
{
  private static volatile long jdField_a_of_type_Long = 0L;
  private static volatile SpringHbHelper jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper;
  public static volatile boolean a = false;
  
  public static SpringHbHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper == null) {
          jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper = new SpringHbHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper;
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
    if (l - jdField_a_of_type_Long > 60000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nowCallTime =");
      localStringBuilder.append(l);
      localStringBuilder.append("gLastLoadToolsProcessTime =");
      localStringBuilder.append(jdField_a_of_type_Long);
      QLog.e("springHb_SpringHbHelper", 1, localStringBuilder.toString());
      jdField_a_of_type_Long = l;
      QLog.i("springHb_SpringHbHelper", 1, "preloadToolsProcessImpl running");
      paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.startWebProcess(-1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper
 * JD-Core Version:    0.7.0.1
 */