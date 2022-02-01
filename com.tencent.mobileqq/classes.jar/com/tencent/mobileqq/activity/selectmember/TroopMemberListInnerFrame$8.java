package com.tencent.mobileqq.activity.selectmember;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import java.util.List;

class TroopMemberListInnerFrame$8
  extends TroopBusinessObserver
{
  TroopMemberListInnerFrame$8(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void onGetAllOnlineMemberList(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((!TextUtils.equals(paramString, this.a.b)) || ((this.a.a != null) && (this.a.a.isFinishing()))) {}
    while (!QQGameTroopManager.b(this.a.a)) {
      return;
    }
    ((QQGameTroopManager)this.a.a.app.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.8
 * JD-Core Version:    0.7.0.1
 */