package com.tencent.biz.qqcircle.publish.account;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.publish.util.HexUtil;
import com.tencent.qphone.base.util.QLog;

public class LoginData
{
  private static volatile LoginData b;
  private static final Object c = new Object();
  private String a = "";
  
  public static LoginData a()
  {
    if (b == null) {
      synchronized (c)
      {
        if (b == null) {
          b = new LoginData();
        }
      }
    }
    return b;
  }
  
  public long b()
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (Exception localException)
      {
        QLog.w("[QcirclePublish]LoginData", 1, localException.getMessage());
      }
    }
    return 0L;
  }
  
  public String c()
  {
    return HostDataTransUtils.getAccount();
  }
  
  public String d()
  {
    return HostDataTransUtils.getA2(c());
  }
  
  public byte[] e()
  {
    String str = d();
    if (!TextUtils.isEmpty(str)) {
      return HexUtil.a(str);
    }
    QLog.e("[QcirclePublish]LoginData", 1, "getA2Bytes null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.account.LoginData
 * JD-Core Version:    0.7.0.1
 */