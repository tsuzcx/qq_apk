package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.RspBody;

class TroopMemberListActivity$20$1
  extends ProtoUtils.TroopProtocolObserver
{
  TroopMemberListActivity$20$1(TroopMemberListActivity.20 param20) {}
  
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
      TroopMemberListActivity.access$702(this.a.this$0, paramBundle.range.get());
      TroopMemberListActivity.access$800(this.a.this$0);
      TroopMemberListActivity.access$902(this.a.this$0, paramBundle.uint64_next_pull_time.get());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label90:
      label104:
      break label90;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "initListView, get0x74f：failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.20.1
 * JD-Core Version:    0.7.0.1
 */