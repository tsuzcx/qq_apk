package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import java.util.Map;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.RspBody;

class BaseMessageProcessorForTroopAndDisc$1
  extends ProtoUtils.TroopProtocolObserver
{
  BaseMessageProcessorForTroopAndDisc$1(BaseMessageProcessorForTroopAndDisc paramBaseMessageProcessorForTroopAndDisc, boolean paramBoolean, MessageInfo paramMessageInfo, long paramLong1, long paramLong2, RecentUser paramRecentUser, String paramString, MessageRecord paramMessageRecord, Map paramMap)
  {
    super(paramBoolean);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    for (;;)
    {
      return;
      try
      {
        paramBundle = new oidb_cmd0x6ef.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.is_create.get() == 1) || (paramBundle.is_join.get() == 1))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo.a.a(21, this.jdField_a_of_type_Long, this.b);
          if (21 >= this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msgType)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msgType = 21;
            this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a(this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, true);
            this.jdField_a_of_type_JavaUtilMap.put(UinTypeUtil.a(this.jdField_a_of_type_JavaLangString, 1), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.1
 * JD-Core Version:    0.7.0.1
 */