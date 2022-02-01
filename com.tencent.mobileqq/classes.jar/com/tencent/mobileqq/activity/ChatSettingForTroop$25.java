package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;

class ChatSettingForTroop$25
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  ChatSettingForTroop$25(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    ThreadManager.post(new ChatSettingForTroop.ClearChatRecordTask(this.a), 5, null, false);
    TroopReportor.a("Grp_set_new", "grpData_admin", "confirm_delRecord", 0, 0, new String[] { this.a.a.troopUin, TroopReportor.a(this.a.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.25
 * JD-Core Version:    0.7.0.1
 */