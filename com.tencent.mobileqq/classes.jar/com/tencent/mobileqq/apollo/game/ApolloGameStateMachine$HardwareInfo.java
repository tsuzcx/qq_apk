package com.tencent.mobileqq.apollo.game;

import android.os.Process;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class ApolloGameStateMachine$HardwareInfo
{
  public static final int a;
  public static final long a;
  public static final String a;
  public static final String b;
  public static final String c;
  public long b;
  public long c;
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceInfoUtil.e();
    jdField_b_of_type_JavaLangString = DeviceInfoUtil.i();
    jdField_c_of_type_JavaLangString = DeviceInfoUtil.g();
    jdField_a_of_type_Int = DeviceInfoUtil.b();
    jdField_a_of_type_Long = DeviceInfoUtil.b();
  }
  
  public ApolloGameStateMachine$HardwareInfo()
  {
    this.jdField_b_of_type_Long = DeviceInfoUtil.a(Process.myPid());
    this.jdField_c_of_type_Long = DeviceInfoUtil.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.HardwareInfo
 * JD-Core Version:    0.7.0.1
 */