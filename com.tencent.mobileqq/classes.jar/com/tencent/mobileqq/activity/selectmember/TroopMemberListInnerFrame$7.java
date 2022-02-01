package com.tencent.mobileqq.activity.selectmember;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import java.util.List;

class TroopMemberListInnerFrame$7
  extends TroopObserver
{
  TroopMemberListInnerFrame$7(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.b)) && (!this.a.b.equals(paramString))) {
      return;
    }
    ThreadManager.post(new TroopMemberListInnerFrame.7.1(this, paramList), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.7
 * JD-Core Version:    0.7.0.1
 */