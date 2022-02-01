package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$158
  implements Runnable
{
  TRTCCloudImpl$158(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.val$code == 0)
    {
      localObject = this.this$0;
      ((TRTCCloudImpl)localObject).mCurrentRole = ((TRTCCloudImpl)localObject).mTargetRole;
    }
    else
    {
      localObject = this.this$0;
      ((TRTCCloudImpl)localObject).mCurrentRole = 21;
      ((TRTCCloudImpl)localObject).mTargetRole = 21;
    }
    Object localObject = this.this$0.mTRTCListener;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onSwitchRole(this.val$code, this.val$msg);
    }
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.158.1(this));
    localObject = this.this$0;
    String str = ((TRTCCloudImpl)localObject).mRoomInfo.getUserId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangeRole:");
    localStringBuilder.append(this.val$code);
    TRTCCloudImpl.access$7600((TRTCCloudImpl)localObject, str, 0, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("onChangeRole err:%d, msg:%s", new Object[] { Integer.valueOf(this.val$code), this.val$msg }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.158
 * JD-Core Version:    0.7.0.1
 */