package com.tencent.crossengine.net;

import android.util.Pair;
import androidx.annotation.Keep;
import java.util.List;

@Keep
public class NetworkManager$WebSocketDelegate
{
  private final long mNativeInstance;
  
  private NetworkManager$WebSocketDelegate(long paramLong)
  {
    this.mNativeInstance = paramLong;
  }
  
  private static native void nativeOnClose(long paramLong, int paramInt, String paramString);
  
  private static native void nativeOnError(long paramLong, String paramString);
  
  private static native void nativeOnMessage(long paramLong, String paramString);
  
  private static native void nativeOnMessageBinary(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private static native void nativeOnOpen(long paramLong, String[] paramArrayOfString);
  
  public void onClose(int paramInt, String paramString)
  {
    nativeOnClose(this.mNativeInstance, paramInt, paramString);
  }
  
  public void onError(String paramString)
  {
    nativeOnError(this.mNativeInstance, paramString);
  }
  
  public void onMessage(String paramString)
  {
    nativeOnMessage(this.mNativeInstance, paramString);
  }
  
  public void onMessage(byte[] paramArrayOfByte, int paramInt)
  {
    nativeOnMessageBinary(this.mNativeInstance, paramArrayOfByte, paramInt);
  }
  
  public void onOpen(List<Pair<String, String>> paramList)
  {
    nativeOnOpen(this.mNativeInstance, NetworkManager.access$100(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.NetworkManager.WebSocketDelegate
 * JD-Core Version:    0.7.0.1
 */