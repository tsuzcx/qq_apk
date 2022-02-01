package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

public class GatewayLoginNewDevHelper
{
  protected static byte[] a;
  protected static boolean b = false;
  
  public static void a()
  {
    b = true;
    QLog.i("gateway_login_new_dev", 1, "startGateWayFlow");
  }
  
  public static void a(int paramInt)
  {
    b = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cleanGateWayFlow from = ");
    localStringBuilder.append(paramInt);
    QLog.i("gateway_login_new_dev", 1, localStringBuilder.toString());
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    a = paramArrayOfByte;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stashGatewayLoginReq phoneToken=");
    localStringBuilder.append(paramArrayOfByte.length);
    QLog.i("gateway_login_new_dev", 1, localStringBuilder.toString());
  }
  
  public static boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isGateWayFlow = ");
    localStringBuilder.append(b);
    QLog.i("gateway_login_new_dev", 1, localStringBuilder.toString());
    return b;
  }
  
  public static byte[] c()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.GatewayLoginNewDevHelper
 * JD-Core Version:    0.7.0.1
 */