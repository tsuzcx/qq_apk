package com.tencent.mobileqq.apollo;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ApolloProcessor
  extends BaseFriendProcessor
{
  public ApolloProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.ApolloProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    ApolloBaseInfoBatchUpdater localApolloBaseInfoBatchUpdater = new ApolloBaseInfoBatchUpdater((QQAppInterface)this.mApp, paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      localApolloBaseInfoBatchUpdater.a((Friends)localPair.first, (FriendInfo)localPair.second);
    }
    localApolloBaseInfoBatchUpdater.a();
  }
  
  public void onUpdateFriendInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.ApolloProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    new ApolloBaseInfoSingleUpdater((QQAppInterface)this.mApp).a(paramFriends, paramFriendInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloProcessor
 * JD-Core Version:    0.7.0.1
 */