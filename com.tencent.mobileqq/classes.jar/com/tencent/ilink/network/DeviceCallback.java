package com.tencent.ilink.network;

public class DeviceCallback
{
  public static void OnFinishGetStrategy()
  {
    if (DeviceInterface.a().b() != null) {
      DeviceInterface.a().b().e();
    }
  }
  
  public static void OnLonglinkConnected()
  {
    if (DeviceInterface.a().b() != null) {
      DeviceInterface.a().b().c();
    }
  }
  
  public static void OnLonglinkDisconnected()
  {
    if (DeviceInterface.a().b() != null) {
      DeviceInterface.a().b().d();
    }
  }
  
  public static void OnSessionTimeout()
  {
    if (DeviceInterface.a().b() != null) {
      DeviceInterface.a().b().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceCallback
 * JD-Core Version:    0.7.0.1
 */