package com.tencent.biz.qqstory.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QQStoryFeedManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map jdField_a_of_type_JavaUtilMap;
  
  public QQStoryFeedManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo("com.tencent.qim", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryFeedManager", 2, "(isQimInstalled:16) Failed. info: exception: ", paramContext);
      }
    }
    return false;
  }
  
  public int a(String paramString)
  {
    return SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  public long a(String paramString)
  {
    return SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  public long b(String paramString)
  {
    return SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  public long c(String paramString)
  {
    return SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "onDestroy invoked. info: TAG: QQStoryFeedManager");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryFeedManager
 * JD-Core Version:    0.7.0.1
 */