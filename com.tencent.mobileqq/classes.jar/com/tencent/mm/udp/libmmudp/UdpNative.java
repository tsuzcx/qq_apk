package com.tencent.mm.udp.libmmudp;

import android.util.Log;
import androidx.annotation.Keep;

@Keep
public class UdpNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_UDP_ERROR = -1000;
  public static int REPEAT_INIT_ERROR = -1001;
  public static int SEND_BUFFER_ERROR = -1003;
  public static String TAG = "UdpNative";
  private boolean initCallBackFlag = false;
  volatile long mNativeInst = 0L;
  
  @Keep
  public UdpNative(long paramLong1, long paramLong2, long paramLong3)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UdpNative isolate_ptr:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",context_ptr:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",uvloop_ptr:");
    localStringBuilder.append(paramLong3);
    Log.i(str, localStringBuilder.toString());
    this.mNativeInst = initBindingUdp(paramLong1, paramLong2, paramLong3);
  }
  
  private native void destoryBindingUdp(long paramLong);
  
  private native long initBindingUdp(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, UdpNative.NativeCallBackInterface paramNativeCallBackInterface);
  
  private native void serviceReceive(String paramString1, int paramInt, String paramString2);
  
  private native void testBindingUdp(long paramLong);
  
  private native void testBindingUdp2(long paramLong);
  
  private native void updateNativeInterface(long paramLong1, long paramLong2);
  
  @Keep
  public int InitCallBack(UdpNative.NativeCallBackInterface paramNativeCallBackInterface)
  {
    if (this.mNativeInst == -1L) {
      return NEW_UDP_ERROR;
    }
    if (!this.initCallBackFlag)
    {
      int i = initCallBack(this.mNativeInst, new UdpNative.1(this, paramNativeCallBackInterface));
      if (i == 0)
      {
        this.initCallBackFlag = true;
        return i;
      }
      return INIT_ERROR;
    }
    return REPEAT_INIT_ERROR;
  }
  
  @Keep
  public void destoryUdp()
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingUdp(this.mNativeInst);
      this.mNativeInst = -1L;
    }
  }
  
  public void testBind()
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    testBindingUdp(this.mNativeInst);
  }
  
  public void testBind2()
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    testBindingUdp2(this.mNativeInst);
  }
  
  public void testServiceReceive(String paramString1, int paramInt, String paramString2)
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    serviceReceive(paramString1, paramInt, paramString2);
  }
  
  @Keep
  public void update(long paramLong)
  {
    if (this.mNativeInst == -1L) {
      return;
    }
    updateNativeInterface(this.mNativeInst, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.UdpNative
 * JD-Core Version:    0.7.0.1
 */