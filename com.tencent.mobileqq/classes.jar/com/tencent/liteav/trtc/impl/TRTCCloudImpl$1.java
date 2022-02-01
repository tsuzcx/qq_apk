package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import com.tencent.liteav.basic.b.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.TXCTimeUtil;

class TRTCCloudImpl$1
  implements a
{
  TRTCCloudImpl$1(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onError => id:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" code:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" params:");
    ((StringBuilder)localObject).append(paramString3);
    TXCLog.e("TRTCCloudImpl", ((StringBuilder)localObject).toString());
    if (this.this$0.mTRTCListener != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", paramString1);
      ((Bundle)localObject).putInt("EVT_ID", paramInt);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        if (paramString3 != null) {
          paramString1 = paramString3;
        } else {
          paramString1 = "";
        }
        localStringBuilder.append(paramString1);
        ((Bundle)localObject).putCharSequence("EVT_MSG", localStringBuilder.toString());
      }
      this.this$0.onNotifyEvent(paramInt, (Bundle)localObject);
    }
    Monitor.a(3, paramInt, paramString2, paramString3, 0, 0);
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEvent => id:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" code:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" params:");
    ((StringBuilder)localObject).append(paramString3);
    TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
    if (this.this$0.mTRTCListener != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", paramString1);
      ((Bundle)localObject).putInt("EVT_ID", paramInt);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        if (paramString3 != null) {
          paramString1 = paramString3;
        } else {
          paramString1 = "";
        }
        localStringBuilder.append(paramString1);
        ((Bundle)localObject).putCharSequence("EVT_MSG", localStringBuilder.toString());
      }
      this.this$0.onNotifyEvent(paramInt, (Bundle)localObject);
    }
    Monitor.a(2, paramInt, paramString2, paramString3, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.1
 * JD-Core Version:    0.7.0.1
 */