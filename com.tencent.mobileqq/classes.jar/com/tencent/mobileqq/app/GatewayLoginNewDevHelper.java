package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

public class GatewayLoginNewDevHelper
{
  protected static boolean a = false;
  protected static byte[] a;
  
  public static void a()
  {
    jdField_a_of_type_Boolean = true;
    QLog.i("gateway_login_new_dev", 1, "startGateWayFlow");
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cleanGateWayFlow from = ");
    localStringBuilder.append(paramInt);
    QLog.i("gateway_login_new_dev", 1, localStringBuilder.toString());
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stashGatewayLoginReq phoneToken=");
    localStringBuilder.append(paramArrayOfByte.length);
    QLog.i("gateway_login_new_dev", 1, localStringBuilder.toString());
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isGateWayFlow = ");
    localStringBuilder.append(jdField_a_of_type_Boolean);
    QLog.i("gateway_login_new_dev", 1, localStringBuilder.toString());
    return jdField_a_of_type_Boolean;
  }
  
  public static byte[] a()
  {
    return jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.GatewayLoginNewDevHelper
 * JD-Core Version:    0.7.0.1
 */