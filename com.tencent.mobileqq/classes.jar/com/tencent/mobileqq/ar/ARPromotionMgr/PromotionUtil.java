package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;

public class PromotionUtil
{
  static SubProcessPromotionMgr a;
  public static String a = "AREngine_ARPromotion";
  
  public static PromotionMgr a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (PromotionMgr)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.ARPROMOTION_MANAGER);
    }
    if (!QQAudioHelper.b()) {
      return null;
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131708509));
  }
  
  public static SubProcessPromotionMgr a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (QQAudioHelper.b())) {
      throw new IllegalArgumentException(HardCodeUtil.a(2131708507));
    }
    if (jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr == null) {
          jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr = new SubProcessPromotionMgr(paramAppInterface);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqArARPromotionMgrSubProcessPromotionMgr;
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
    return paramLong < QQAudioHelper.a();
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    long l = QQAudioHelper.a();
    return (paramLong1 < l) && (paramLong2 > l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil
 * JD-Core Version:    0.7.0.1
 */