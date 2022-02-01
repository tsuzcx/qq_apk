package com.tencent.biz.qqstory.shareGroup.infocard.model;

import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class GetUserGroupMemberListHandler$GetMemberListBusinessObserver
  extends TroopObserver
{
  GetUserGroupMemberListHandler a;
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    paramString = String.valueOf(paramLong1);
    if ((this.a.a.equals(paramString)) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      Bosses.get().postJob(new GetUserGroupMemberListHandler.GetMemberListBusinessObserver.1(this, "Q.qqstory.shareGroup.GetMemberListBusinessObserver", paramString, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.GetUserGroupMemberListHandler.GetMemberListBusinessObserver
 * JD-Core Version:    0.7.0.1
 */