package com.tencent.mobileqq.activity.selectmember;

import andd;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import bcef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import muk;

class SelectMemberActivity$14
  extends andd
{
  SelectMemberActivity$14(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onGetInviteNoAuthLimitNum(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((paramBoolean) && (str.equals(this.this$0.mGroupCode)))
    {
      this.this$0.mInviteNoAuthLimitNum = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + str + " get inviteNoAuthLimitNum = " + paramLong2);
      }
      if ((this.this$0.mTroopMemberNum >= this.this$0.mInviteNoAuthLimitNum) && (this.this$0.mInviteNoAuthLimitNum > 0L))
      {
        this.this$0.mTooManyMembersTipsBar.setVisibility(0);
        bcef.b(this.this$0.app, "dc00899", "invite_friend", "", "friend_list", "exp_needagree", 0, 0, str, muk.a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), str) + "", "", "");
      }
    }
  }
  
  public void onGetInvitedUinList(boolean paramBoolean, Long paramLong, List<Long> paramList)
  {
    paramLong = String.valueOf(paramLong);
    if ((paramBoolean) && (paramLong.equals(this.this$0.mGroupCode)))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.this$0.mInvitedUinList.add(String.valueOf(localLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + paramLong + " get invitedUinList = " + paramList.toString());
      }
    }
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member fail");
      }
      SelectMemberActivity.access$200(this.this$0, paramInt2);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 8)
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "add troop member success");
        }
        this.this$0.mHandler.sendEmptyMessage(0);
        if (!this.this$0.mIsTroopAdmin)
        {
          paramInt1 = this.this$0.getNotAdminInviteMemberCount();
          this.this$0.setNotAdminInviteMemberCount(paramInt1 + 1);
          bcef.b(this.this$0.app, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
        }
        ArrayList localArrayList = this.this$0.getOutGroupMem();
        this.this$0.mIntent.putExtra("roomId", Long.parseLong(paramString));
        this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.mResultList);
        this.this$0.mIntent.putParcelableArrayListExtra("result_set_for_out_Member ", localArrayList);
        this.this$0.setResult(-1);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add troop member fail, troopUin: " + paramString + " result: " + paramInt2);
    }
    SelectMemberActivity.access$200(this.this$0, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.14
 * JD-Core Version:    0.7.0.1
 */