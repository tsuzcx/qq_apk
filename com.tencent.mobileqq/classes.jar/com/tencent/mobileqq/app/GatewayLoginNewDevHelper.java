package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

public class GatewayLoginNewDevHelper
{
  protected static boolean a;
  protected static byte[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = true;
    QLog.i("gateway_login_new_dev", 1, "startGateWayFlow");
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Boolean = false;
    QLog.i("gateway_login_new_dev", 1, "cleanGateWayFlow from = " + paramInt);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    QLog.i("gateway_login_new_dev", 1, "stashGatewayLoginReq phoneToken=" + paramArrayOfByte.length);
  }
  
  public static boolean a()
  {
    QLog.i("gateway_login_new_dev", 1, "isGateWayFlow = " + jdField_a_of_type_Boolean);
    return jdField_a_of_type_Boolean;
  }
  
  public static byte[] a()
  {
    return jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.GatewayLoginNewDevHelper
 * JD-Core Version:    0.7.0.1
 */