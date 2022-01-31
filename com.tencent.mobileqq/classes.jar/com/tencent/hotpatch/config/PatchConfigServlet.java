package com.tencent.hotpatch.config;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.utils.PatchSharedPreUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;

public class PatchConfigServlet
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ("doOnReconnect".equals(paramString2))
    {
      long l1 = PatchSharedPreUtil.a(BaseApplicationImpl.sApplication);
      long l2 = System.currentTimeMillis();
      if (Math.abs(l2 - l1) > 21600000L)
      {
        ConfigServlet.a(paramQQAppInterface, paramString1, paramInt, paramString2);
        PatchSharedPreUtil.a(BaseApplicationImpl.sApplication, l2);
      }
      return;
    }
    ConfigServlet.a(paramQQAppInterface, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.hotpatch.config.PatchConfigServlet
 * JD-Core Version:    0.7.0.1
 */