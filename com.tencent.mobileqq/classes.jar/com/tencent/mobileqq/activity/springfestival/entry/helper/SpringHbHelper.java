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
  private static volatile SpringHbHelper jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper = null;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static SpringHbHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper = new SpringHbHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryHelperSpringHbHelper;
    }
    finally {}
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
    if (paramQQAppInterface == null) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - jdField_a_of_type_Long <= 60000L);
      QLog.e("springHb_SpringHbHelper", 1, "nowCallTime =" + l + "gLastLoadToolsProcessTime =" + jdField_a_of_type_Long);
      jdField_a_of_type_Long = l;
      QLog.i("springHb_SpringHbHelper", 1, "preloadToolsProcessImpl running");
      paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
    } while (paramQQAppInterface == null);
    paramQQAppInterface.startWebProcess(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper
 * JD-Core Version:    0.7.0.1
 */