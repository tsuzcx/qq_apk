package com.tencent.mm.udp.libmmudp;

import androidx.annotation.Keep;

class UdpNative$1
  implements UdpNative.NativeCallBackInterface
{
  UdpNative$1(UdpNative paramUdpNative, UdpNative.NativeCallBackInterface paramNativeCallBackInterface) {}
  
  @Keep
  public void onCallBack(long paramLong, String paramString)
  {
    this.a.onCallBack(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.UdpNative.1
 * JD-Core Version:    0.7.0.1
 */