package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.util.TXCTimeUtil;

class TRTCCloudImpl$2
  implements a
{
  TRTCCloudImpl$2(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.this$0.mTRTCListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_USERID", paramString1);
      localBundle.putInt("EVT_ID", paramInt);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        if (paramString3 != null) {
          localObject = paramString3;
        } else {
          localObject = "";
        }
        localStringBuilder.append((String)localObject);
        localBundle.putCharSequence("EVT_MSG", localStringBuilder.toString());
      }
      this.this$0.onNotifyEvent(paramInt, localBundle);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onError => msg:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" params:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" code:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" id:");
    ((StringBuilder)localObject).append(paramString1);
    Monitor.a(3, paramInt, ((StringBuilder)localObject).toString(), "", 0, 0);
    if ((paramInt == -1302) || (paramInt == -1317) || (paramInt == -1318) || (paramInt == -1319))
    {
      TXCKeyPointReportProxy.b(30002, paramInt);
      if (paramInt == -1317) {
        TXCEventRecorderProxy.a("18446744073709551615", 2002, 4L, -1L, "", 0);
      }
    }
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    onEventInternal(paramString1, paramInt, paramString2, paramString3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEvent => msg:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" params:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" id:");
    localStringBuilder.append(paramString1);
    Monitor.a(2, paramInt, localStringBuilder.toString(), "", 0, 0);
    if (paramInt == 2027) {
      TXCKeyPointReportProxy.b(30002, 0);
    }
  }
  
  void onEventInternal(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.this$0.mTRTCListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_USERID", paramString1);
      localBundle.putInt("EVT_ID", paramInt);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString2 != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        if (paramString3 == null) {
          paramString3 = "";
        }
        paramString1.append(paramString3);
        localBundle.putCharSequence("EVT_MSG", paramString1.toString());
      }
      this.this$0.onNotifyEvent(paramInt, localBundle);
    }
  }
  
  public void onWarning(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    onEventInternal(paramString1, paramInt, paramString2, paramString3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWarning => msg:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" params:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" id:");
    localStringBuilder.append(paramString1);
    Monitor.a(4, paramInt, localStringBuilder.toString(), "", 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.2
 * JD-Core Version:    0.7.0.1
 */