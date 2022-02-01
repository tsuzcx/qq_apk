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
  public static String a = "AREngine_ARPromotion";
  static SubProcessPromotionMgr b;
  
  public static SubProcessPromotionMgr a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (QQAudioHelper.b())) {
      throw new IllegalArgumentException(HardCodeUtil.a(2131906292));
    }
    if (b == null) {
      try
      {
        if (b == null) {
          b = new SubProcessPromotionMgr(paramAppInterface);
        }
      }
      finally {}
    }
    return b;
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong < QQAudioHelper.c();
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    long l = QQAudioHelper.c();
    return (paramLong1 < l) && (paramLong2 > l);
  }
  
  public static PromotionMgr b(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (PromotionMgr)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.ARPROMOTION_MANAGER);
    }
    if (!QQAudioHelper.b()) {
      return null;
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131906294));
  }
  
  public static void c(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      b(paramAppInterface).a(paramAppInterface);
      BusinessCommonConfig.getInstance(paramAppInterface).doOnReconnect();
      return;
    }
    QLog.w(a, 1, "doOnReconnect, 不是主进程");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil
 * JD-Core Version:    0.7.0.1
 */