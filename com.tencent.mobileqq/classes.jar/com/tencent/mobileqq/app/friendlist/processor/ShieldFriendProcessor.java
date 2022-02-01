package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;

@KeepClassConstructor
public class ShieldFriendProcessor
  extends BaseFriendProcessor
{
  public ShieldFriendProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriendInfo = parseSnsUpdateBuffer(paramFriendInfo.vecRing);
    if ((paramFriendInfo != null) && (paramFriendInfo.rpt_uin32_idlist.has()))
    {
      paramFriendInfo = paramFriendInfo.rpt_uin32_idlist.get().iterator();
      while (paramFriendInfo.hasNext()) {
        if (((Integer)paramFriendInfo.next()).intValue() == 4051) {
          paramFriends.setShieldFlag(true);
        }
      }
    }
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      a((Friends)localPair.first, (FriendInfo)localPair.second);
    }
  }
  
  public void onUpdateFriendInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    a(paramFriends, paramFriendInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.ShieldFriendProcessor
 * JD-Core Version:    0.7.0.1
 */