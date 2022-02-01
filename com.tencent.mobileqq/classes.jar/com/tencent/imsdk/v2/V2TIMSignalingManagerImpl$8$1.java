package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;

class V2TIMSignalingManagerImpl$8$1
  implements V2TIMCallback
{
  V2TIMSignalingManagerImpl$8$1(V2TIMSignalingManagerImpl.8 param8) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onError(paramInt, paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("signaling reject failed, inviteID:");
    localStringBuilder.append(this.this$1.val$inviteID);
    localStringBuilder.append(", code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", desc:");
    localStringBuilder.append(paramString);
    IMLog.e("V2TIMSigMgrImpl", localStringBuilder.toString());
  }
  
  public void onSuccess()
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.8.1
 * JD-Core Version:    0.7.0.1
 */