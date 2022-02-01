package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.JudgeTopicVideoNumRsp;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody;

class TroopMemberApiService$IncomingHandler$14
  extends ProtoUtils.TroopProtocolObserver
{
  TroopMemberApiService$IncomingHandler$14(TroopMemberApiService.IncomingHandler paramIncomingHandler, boolean paramBoolean, Bundle paramBundle)
  {
    super(paramBoolean);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xe2a.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.msg_judge_topic_video_num_rsp.has()) {
          return;
        }
        if ((paramBundle.msg_judge_topic_video_num_rsp.uint32_is_overtimes.has()) && (paramBundle.msg_judge_topic_video_num_rsp.uint32_is_overtimes.get() > 0))
        {
          TroopMemberApiService.IncomingHandler.a(this.b, 161, this.a, 1, HardCodeUtil.a(2131905681));
          TroopMemberApiService.a(false);
          return;
        }
        TroopMemberApiService.a(true);
        TroopMemberApiService.IncomingHandler.a(this.b, this.a);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("TroopMemberApiService", 1, paramArrayOfByte.getMessage());
        return;
      }
    }
    else
    {
      TroopMemberApiService.IncomingHandler.a(this.b, 161, this.a, 1, HardCodeUtil.a(2131908438));
      TroopMemberApiService.a(false);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("oidb_0xe2a request failed: errorCode = ");
      paramArrayOfByte.append(paramInt);
      QLog.e("TroopMemberApiService", 1, paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.14
 * JD-Core Version:    0.7.0.1
 */