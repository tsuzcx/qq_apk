package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.OpenTKPublisherAction;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.OpenTKPublisherAction.Companion;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.JudgeTopicVideoNumRsp;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody;

class TroopMemberApiService$IncomingHandler$13
  extends ProtoUtils.TroopProtocolObserver
{
  TroopMemberApiService$IncomingHandler$13(TroopMemberApiService.IncomingHandler paramIncomingHandler, boolean paramBoolean, Bundle paramBundle)
  {
    super(paramBoolean);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
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
          TroopMemberApiService.IncomingHandler.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler, 161, this.jdField_a_of_type_AndroidOsBundle, 1, HardCodeUtil.a(2131707844));
          OpenTKPublisherAction.a.a(false);
          return;
        }
        OpenTKPublisherAction.a.a(true);
        TroopMemberApiService.IncomingHandler.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler, this.jdField_a_of_type_AndroidOsBundle);
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
      TroopMemberApiService.IncomingHandler.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler, 161, this.jdField_a_of_type_AndroidOsBundle, 1, HardCodeUtil.a(2131710781));
      OpenTKPublisherAction.a.a(false);
      QLog.e("TroopMemberApiService", 1, "oidb_0xe2a request failed: errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.13
 * JD-Core Version:    0.7.0.1
 */