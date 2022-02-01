package com.tencent.liteav.trtc.impl;

import android.text.TextUtils;
import com.tencent.trtc.TRTCCloudDef.TRTCSwitchRoomConfig;

class TRTCCloudImpl$17
  implements Runnable
{
  TRTCCloudImpl$17(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCSwitchRoomConfig paramTRTCSwitchRoomConfig) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    int k = this.val$config.roomId;
    int j = 0;
    int i = 0;
    ((StringBuilder)localObject).append(String.format("switchRoom roomId:%d, strRoomId:%s", new Object[] { Integer.valueOf(k), this.val$config.strRoomId }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.apiOnlineLog((String)localObject);
    if ((!TRTCCloudImpl.access$2000(this.this$0, this.val$config.roomId)) && (TextUtils.isEmpty(this.val$config.strRoomId)))
    {
      this.this$0.apiLog("Switch room failed with invalid room id");
      this.this$0.runOnListenerThread(new TRTCCloudImpl.17.1(this));
      return;
    }
    if (((TRTCCloudImpl.access$2000(this.this$0, this.val$config.roomId)) && (this.val$config.roomId == this.this$0.mRoomInfo.roomId)) || ((!TRTCCloudImpl.access$2000(this.this$0, this.val$config.roomId)) && (this.val$config.strRoomId == this.this$0.mRoomInfo.strRoomId)))
    {
      this.this$0.apiLog("Switch room to the same one");
      this.this$0.runOnListenerThread(new TRTCCloudImpl.17.2(this));
      return;
    }
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.17.3(this));
    this.this$0.mRoomInfo.clearUserList();
    boolean bool = TRTCCloudImpl.access$2000(this.this$0, this.val$config.roomId);
    String str2 = "";
    if (bool)
    {
      i = this.val$config.roomId;
      this.this$0.mRoomInfo.roomId = this.val$config.roomId;
      this.this$0.mRoomInfo.strRoomId = "";
    }
    else if (!TextUtils.isEmpty(this.val$config.strRoomId))
    {
      this.this$0.mRoomInfo.strRoomId = this.val$config.strRoomId;
      this.this$0.mRoomInfo.roomId = -1L;
      localObject = this.val$config.strRoomId;
      i = j;
      break label401;
    }
    localObject = "";
    label401:
    String str1;
    if (!TextUtils.isEmpty(this.val$config.userSig))
    {
      this.this$0.mRoomInfo.userSig = this.val$config.userSig;
      str1 = this.val$config.userSig;
    }
    else
    {
      str1 = "";
    }
    if (!TextUtils.isEmpty(this.val$config.privateMapKey))
    {
      this.this$0.mRoomInfo.privateMapKey = this.val$config.privateMapKey;
      str2 = this.val$config.privateMapKey;
    }
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    localTRTCCloudImpl.nativeSwitchRoom(localTRTCCloudImpl.mNativeRtcContext, i, (String)localObject, str1, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.17
 * JD-Core Version:    0.7.0.1
 */