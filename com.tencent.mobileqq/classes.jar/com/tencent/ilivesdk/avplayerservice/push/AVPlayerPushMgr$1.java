package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.falco.base.libapi.channel.PushCallback;
import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;

class AVPlayerPushMgr$1
  implements PushCallback
{
  AVPlayerPushMgr$1(AVPlayerPushMgr paramAVPlayerPushMgr) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, MsgExtInfo paramMsgExtInfo)
  {
    paramMsgExtInfo = AVPlayerPushMgr.access$000(this.this$0).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPushListener0x4a,onPush,data:");
    localStringBuilder.append(paramArrayOfByte);
    paramMsgExtInfo.i("AVPlayerPushMgr", localStringBuilder.toString(), new Object[0]);
    if (paramArrayOfByte != null) {
      AVPlayerPushMgr.access$100(this.this$0, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.AVPlayerPushMgr.1
 * JD-Core Version:    0.7.0.1
 */