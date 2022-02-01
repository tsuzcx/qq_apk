package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import anvx;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatSettingForTroop$52$1
  implements Runnable
{
  ChatSettingForTroop$52$1(ChatSettingForTroop.52 param52) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a.a.getExtras().getStringArrayList("deleted_members");
    if (localArrayList != null)
    {
      if (this.a.this$0.c != null) {
        this.a.this$0.c.setText(this.a.this$0.a.wMemberNum + anvx.a(2131701220));
      }
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        int j = this.a.this$0.e.size() - 1;
        if (j >= 0)
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)this.a.this$0.e.get(j);
          if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
          while (!String.valueOf(localmemberlist.uint64_member_uin.get()).equals(localArrayList.get(i)))
          {
            j -= 1;
            break;
          }
          this.a.this$0.e.remove(j);
        }
        i -= 1;
      }
    }
    if (QLog.isColorLevel()) {
      if ("resultForTroopManage,memberListForCard.size = " + this.a.this$0.e == null) {
        break label294;
      }
    }
    label294:
    for (int i = this.a.this$0.e.size();; i = -1)
    {
      QLog.d("Q.chatopttroop", 2, new Object[] { Integer.valueOf(i) });
      this.a.this$0.a(this.a.this$0.e);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.52.1
 * JD-Core Version:    0.7.0.1
 */