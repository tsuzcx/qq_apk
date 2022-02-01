package com.tencent.ilink.network;

public class DeviceInterface
{
  private static DeviceInterface b;
  public c a;
  
  public static native void SetLonglinkIplist(byte[] paramArrayOfByte);
  
  public static native void SetProxyInfo(byte[] paramArrayOfByte);
  
  public static native void SetShortlinkIplist(byte[] paramArrayOfByte);
  
  public static native void Start(byte[] paramArrayOfByte);
  
  public static native void Stop();
  
  public static DeviceInterface a()
  {
    if (b == null) {
      b = new DeviceInterface();
    }
    return b;
  }
  
  public static native boolean isAlreadyGetStrategy();
  
  public void a(c paramc)
  {
    this.a = paramc;
  }
  
  public c b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceInterface
 * JD-Core Version:    0.7.0.1
 */