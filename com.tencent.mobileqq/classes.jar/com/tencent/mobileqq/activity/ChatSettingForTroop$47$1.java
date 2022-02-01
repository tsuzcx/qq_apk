package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatSettingForTroop$47$1
  implements Runnable
{
  ChatSettingForTroop$47$1(ChatSettingForTroop.47 param47) {}
  
  public void run()
  {
    Object localObject = this.a.a.getExtras().getStringArrayList("deleted_members");
    if (localObject != null)
    {
      if (this.a.this$0.c != null) {
        this.a.this$0.c.setText(this.a.this$0.a.wMemberNum + HardCodeUtil.a(2131701795));
      }
      i = ((ArrayList)localObject).size() - 1;
      while (i >= 0)
      {
        if (this.a.this$0.e != null)
        {
          int j = this.a.this$0.e.size() - 1;
          if (j >= 0)
          {
            oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)this.a.this$0.e.get(j);
            if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
            while (!String.valueOf(localmemberlist.uint64_member_uin.get()).equals(((ArrayList)localObject).get(i)))
            {
              j -= 1;
              break;
            }
            this.a.this$0.e.remove(j);
          }
        }
        i -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("resultForTroopManage,memberListForCard.size = ");
      if (this.a.this$0.e == null) {
        break label299;
      }
    }
    label299:
    for (int i = this.a.this$0.e.size();; i = -1)
    {
      QLog.d("Q.chatopttroop", 2, i);
      this.a.this$0.a(this.a.this$0.e);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.47.1
 * JD-Core Version:    0.7.0.1
 */