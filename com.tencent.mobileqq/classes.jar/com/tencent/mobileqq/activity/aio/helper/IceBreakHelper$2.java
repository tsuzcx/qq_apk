package com.tencent.mobileqq.activity.aio.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.limitchat.LimitChatMatchInfoHelper;
import com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler.ICallback;
import com.tencent.mobileqq.extendfriend.network.ExpandReqInfo;
import com.tencent.mobileqq.extendfriend.network.ExpandResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.qphone.base.util.QLog;
import expand.common.GetMatchSrcRsp;
import expand.common.MatchedInfo;
import java.util.List;

class IceBreakHelper$2
  implements ExpandCmdHandler.ICallback
{
  IceBreakHelper$2(IceBreakHelper paramIceBreakHelper, IceBreakingMng paramIceBreakingMng, String paramString) {}
  
  public void a(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    if ((paramExpandResponse.a() != 0) || (paramExpandResponse.a() == null))
    {
      QLog.w("IceBreakHelperexpand.chat.", 1, "getMatchInfo. error " + paramExpandResponse.a());
      return;
    }
    paramExpandReqInfo = new GetMatchSrcRsp();
    try
    {
      paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
      if ((paramExpandReqInfo.MatchedInfoList.has()) && (paramExpandReqInfo.MatchedInfoList.get() != null) && (paramExpandReqInfo.MatchedInfoList.get().get(0) != null))
      {
        QLog.d("IceBreakHelperexpand.chat.", 4, "getMatchInfo succ. id=" + ((MatchedInfo)((MatchedInfo)paramExpandReqInfo.MatchedInfoList.get().get(0)).get()).MatchSrcId.get());
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperIceBreakHelper.a.getCurrentUin(), 3, LimitChatMatchInfoHelper.a((MatchedInfo)paramExpandReqInfo.MatchedInfoList.get().get(0)), this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
    {
      QLog.w("IceBreakHelperexpand.chat.", 1, paramExpandReqInfo.toString());
      paramExpandReqInfo.printStackTrace();
      return;
    }
    QLog.w("IceBreakHelperexpand.chat.", 1, "getMatchInfo. error ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.2
 * JD-Core Version:    0.7.0.1
 */