package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;

public class PromotionUtil
{
  static SubProcessPromotionMgr a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AREngine_ARPromotion";
    jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr = null;
  }
  
  public static PromotionMgr a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (PromotionMgr)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.ARPROMOTION_MANAGER);
    }
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(HardCodeUtil.a(2131708503));
    }
    return null;
  }
  
  public static SubProcessPromotionMgr a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (AudioHelper.d())) {
      throw new IllegalArgumentException(HardCodeUtil.a(2131708501));
    }
    if (jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr == null) {
        jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr = new SubProcessPromotionMgr(paramAppInterface);
      }
      return jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr;
    }
    finally {}
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      a(paramAppInterface).a(paramAppInterface);
      BusinessCommonConfig.getInstance(paramAppInterface).doOnReconnect();
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "doOnReconnect, 不是主进程");
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong < AudioHelper.a();
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.a();
    return (paramLong1 < l) && (paramLong2 > l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil
 * JD-Core Version:    0.7.0.1
 */