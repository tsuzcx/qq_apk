package com.tencent.crossengine.net;

import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

@Keep
public class NetworkManager$Callback
{
  public static final int HTTP_VERSION_1 = 1;
  public static final int HTTP_VERSION_1_1 = 2;
  public static final int HTTP_VERSION_2 = 3;
  public static final int HTTP_VERSION_3 = 4;
  private final long mNativeInstance;
  
  private NetworkManager$Callback(long paramLong)
  {
    this.mNativeInstance = paramLong;
  }
  
  private static native void nativeFinalize(long paramLong);
  
  private static native void nativeOnCancel(long paramLong);
  
  private static native void nativeOnError(long paramLong, String paramString);
  
  private static native void nativeOnHeader(long paramLong, String[] paramArrayOfString);
  
  private static native void nativeOnProgress(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
  
  private static native void nativeOnResponse(long paramLong, @NonNull String paramString, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  private static native long nativeWriteResponse(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize(this.mNativeInstance);
  }
  
  public void onCancel()
  {
    nativeOnCancel(this.mNativeInstance);
  }
  
  public void onError(@Nullable String paramString)
  {
    nativeOnError(this.mNativeInstance, paramString);
  }
  
  public void onHeader(List<Pair<String, String>> paramList)
  {
    nativeOnHeader(this.mNativeInstance, NetworkManager.access$100(paramList));
  }
  
  public void onProgress(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    nativeOnProgress(this.mNativeInstance, paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  public void onResponse(@NonNull String paramString, int paramInt1, List<Pair<String, String>> paramList, int paramInt2)
  {
    nativeOnResponse(this.mNativeInstance, paramString, paramInt1, NetworkManager.access$100(paramList), paramInt2);
  }
  
  public long writeResponseContent(@Nullable byte[] paramArrayOfByte, int paramInt)
  {
    return nativeWriteResponse(this.mNativeInstance, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.net.NetworkManager.Callback
 * JD-Core Version:    0.7.0.1
 */