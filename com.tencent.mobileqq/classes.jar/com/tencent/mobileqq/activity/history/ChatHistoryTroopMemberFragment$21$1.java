package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.RspBody;

class ChatHistoryTroopMemberFragment$21$1
  extends ProtoUtils.TroopProtocolObserver
{
  ChatHistoryTroopMemberFragment$21$1(ChatHistoryTroopMemberFragment.21 param21) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      if (paramArrayOfByte == null) {
        return;
      }
    }
    try
    {
      paramBundle = new oidb_cmd0x74f.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if ((paramBundle.uint32_ret_code.get() != 0) || (!paramBundle.bool_display_entrance.get())) {
        break label104;
      }
      ChatHistoryTroopMemberFragment.a(this.a.this$0, paramBundle.range.get());
      ChatHistoryTroopMemberFragment.h(this.a.this$0);
      ChatHistoryTroopMemberFragment.a(this.a.this$0, paramBundle.uint64_next_pull_time.get());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label90:
      label104:
      break label90;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "initListView, get0x74f：failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.21.1
 * JD-Core Version:    0.7.0.1
 */