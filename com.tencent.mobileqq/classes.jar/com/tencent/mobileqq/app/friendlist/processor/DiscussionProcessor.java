package com.tencent.mobileqq.app.friendlist.processor;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class DiscussionProcessor
  extends BaseFriendProcessor
{
  public DiscussionProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.e("IMCore.friend.DiscussionProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
    }
    for (;;)
    {
      return;
      Object localObject3 = (QQAppInterface)this.mApp;
      IFriendDataService localIFriendDataService = (IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all");
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject4 = (Pair)paramList.next();
        Friends localFriends1 = (Friends)((Pair)localObject4).first;
        Friends localFriends2 = localIFriendDataService.getFriend(localFriends1.uin);
        localObject4 = (FriendInfo)((Pair)localObject4).second;
        if ((localFriends2 != null) && (QQProfileItem.a(localFriends1.name, localFriends2.name)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend Name changed.oldName " + localFriends2.name + ",newName " + localFriends1.name + ",oldRemark " + localFriends2.remark + ",newRemark =" + localFriends1.remark);
          }
          ((ArrayList)localObject2).add(new Pair(Long.valueOf(((FriendInfo)localObject4).friendUin), localFriends1.name));
        }
        if ((localFriends2 != null) && (!TextUtils.isEmpty(((FriendInfo)localObject4).nick)) && (!((FriendInfo)localObject4).nick.equals(((FriendInfo)localObject4).remark)) && (QQProfileItem.b(localFriends1.remark, localFriends2.remark)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend remark changed.oldName " + localFriends2.name + ",newName " + localFriends1.name + ",oldRemark " + localFriends2.remark + ",newRemark =" + localFriends1.remark);
          }
          ((ArrayList)localObject1).add(new Pair(Long.valueOf(((FriendInfo)localObject4).friendUin), localFriends1.remark));
        }
      }
      paramList = (DiscussionManager)((QQAppInterface)localObject3).getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Pair)((Iterator)localObject2).next();
          QQProfileItem.a(((Long)((Pair)localObject3).first).longValue(), (String)((Pair)localObject3).second, paramList);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Pair)((Iterator)localObject1).next();
          QQProfileItem.b(((Long)((Pair)localObject2).first).longValue(), (String)((Pair)localObject2).second, paramList);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.DiscussionProcessor
 * JD-Core Version:    0.7.0.1
 */