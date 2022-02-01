package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

class TroopMemberListActivity$44
  extends TroopOnlineMemberObserver
{
  TroopMemberListActivity$44(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.mTroopUin)) && (this.a.mSortType == 1) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.44.1(this, paramList));
    }
  }
  
  protected void b(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.mTroopUin)) && (this.a.mSortType == 5) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.44.2(this, paramList));
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.mTroopUin)) && (this.a.mSortType == 8) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.44.3(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.44
 * JD-Core Version:    0.7.0.1
 */