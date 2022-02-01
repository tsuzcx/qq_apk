package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QidianProcessor
  extends BaseFriendProcessor
{
  public QidianProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.d("IMCore.friend.QidianProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mApp;
    int j = paramList.size();
    Friends[] arrayOfFriends = new Friends[j];
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramList.get(i);
      Friends localFriends = (Friends)localPair.first;
      localFriends.strMasterUin = ((FriendInfo)localPair.second).strMasterUin;
      arrayOfFriends[i] = localFriends;
      i += 1;
    }
    QidianManager.a(localQQAppInterface, arrayOfFriends);
  }
  
  public void onUpdateFriendInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.QidianProcessor", 1, "onUpdateFriendInfo| app is not QQAppInterface");
      return;
    }
    QidianManager.a((QQAppInterface)this.mApp, paramFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.QidianProcessor
 * JD-Core Version:    0.7.0.1
 */