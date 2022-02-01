package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import android.text.TextUtils;

class TRTCCloudImpl$129
  implements Runnable
{
  TRTCCloudImpl$129(TRTCCloudImpl paramTRTCCloudImpl, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.val$param;
    if (localObject == null) {
      return;
    }
    localObject = ((Bundle)localObject).getString("EVT_USERID", "");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase("18446744073709551615")) && (!((String)localObject).equalsIgnoreCase(this.this$0.mRoomInfo.getTinyId())))
    {
      TRTCCloudImpl.access$9000(this.this$0, (String)localObject, this.val$event, this.val$param);
      return;
    }
    localObject = this.this$0;
    ((TRTCCloudImpl)localObject).notifyEvent(((TRTCCloudImpl)localObject).mRoomInfo.getUserId(), this.val$event, this.val$param);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.129
 * JD-Core Version:    0.7.0.1
 */