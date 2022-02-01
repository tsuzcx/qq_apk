package com.tencent.mm.websocket.libwcwss;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.HashMap;

@Keep
public class WcwssNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_WCWSS_ERROR = -1000;
  public static int REPEAT_INIT_ERROR = -1001;
  public static String TAG = "WcwssNative";
  private volatile boolean initCallBackFlag = false;
  private volatile long mNativeInst = 0L;
  private volatile String mStrNativeInst = "0";
  
  private native void destoryBindingWcwss(long paramLong);
  
  private native void doOnRunningStateWcwss(String paramString, long paramLong);
  
  private native long initBindingWcwss(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, WcwssNative.IWcWssWebSocketListener paramIWcWssWebSocketListener, WcwssNative.IWcWssReportListener paramIWcWssReportListener);
  
  private native void initConfigWcwss(String paramString, long paramLong, HashMap<String, String> paramHashMap);
  
  private native void initConfigWhiteBlackList(String paramString, long paramLong, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2);
  
  private native void testBindingWcwss(long paramLong);
  
  private native void updateNativeInterface(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  @Keep
  public void destoryWcwss()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WcwssNative MMWcWss destoryWcwss mNativeInst:");
    localStringBuilder.append(this.mNativeInst);
    Log.i(str, localStringBuilder.toString());
    if (this.mNativeInst <= 0L) {
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingWcwss(this.mNativeInst);
      this.mNativeInst = -1L;
    }
  }
  
  @Keep
  public void doOnRunningState()
  {
    doOnRunningStateWcwss(this.mStrNativeInst, this.mNativeInst);
  }
  
  @Keep
  public void initConfig(HashMap<String, String> paramHashMap)
  {
    initConfigWcwss(this.mStrNativeInst, this.mNativeInst, paramHashMap);
  }
  
  @Keep
  public void initConfigWhiteBlack(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    initConfigWhiteBlackList(this.mStrNativeInst, this.mNativeInst, paramArrayList1, paramArrayList2);
  }
  
  @Keep
  public String initWcwss(long paramLong1, long paramLong2, long paramLong3)
  {
    this.mNativeInst = initBindingWcwss(paramLong1, paramLong2, paramLong3);
    this.mStrNativeInst = String.valueOf(this.mNativeInst);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WcwssNative MMWcWss initWcwss str_contextId:");
    localStringBuilder.append(this.mStrNativeInst);
    Log.i(str, localStringBuilder.toString());
    return this.mStrNativeInst;
  }
  
  @Keep
  public int setCallback(WcwssNative.IWcWssWebSocketListener paramIWcWssWebSocketListener, WcwssNative.IWcWssReportListener paramIWcWssReportListener)
  {
    if (this.mNativeInst <= 0L) {
      return NEW_WCWSS_ERROR;
    }
    if (!this.initCallBackFlag)
    {
      int i = initCallBack(this.mNativeInst, paramIWcWssWebSocketListener, paramIWcWssReportListener);
      if (i == 0)
      {
        this.initCallBackFlag = true;
        return i;
      }
      return INIT_ERROR;
    }
    return REPEAT_INIT_ERROR;
  }
  
  public void testBindWcwss(String paramString)
  {
    long l = Long.parseLong(paramString);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WcwssNative MMWcWss destoryWcwss contextId:");
    localStringBuilder.append(paramString);
    Log.e((String)localObject, localStringBuilder.toString());
    paramString = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WcwssNative MMWcWss destoryWcwss lcontextId:");
    ((StringBuilder)localObject).append(l);
    Log.e(paramString, ((StringBuilder)localObject).toString());
    testBindingWcwss(l);
  }
  
  @Keep
  public void updateInterface(long paramLong, int paramInt)
  {
    updateNativeInterface(this.mStrNativeInst, this.mNativeInst, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.websocket.libwcwss.WcwssNative
 * JD-Core Version:    0.7.0.1
 */