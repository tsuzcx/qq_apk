package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class IntimateInfoProcessor
  extends BaseFriendProcessor
{
  public IntimateInfoProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.IntimateInfoProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    paramExtRspData = (QQAppInterface)this.mApp;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Pair)paramList.next();
      ExtensionInfo localExtensionInfo = (ExtensionInfo)((Pair)localObject).first;
      localObject = (FriendInfo)((Pair)localObject).second;
      int i;
      if (((FriendInfo)localObject).groupId >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        FriendIntimateRelationshipHelper.a(paramExtRspData, localExtensionInfo, ((FriendInfo)localObject).vecIntimateInfo);
      }
    }
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    boolean bool = this.mApp instanceof QQAppInterface;
    int i = 1;
    if (!bool)
    {
      QLog.e("IMCore.friend.IntimateInfoProcessor", 1, "onUpdateExtensionInfo| app is not QQAppInterface");
      return;
    }
    paramExtRspData = (QQAppInterface)this.mApp;
    if (paramFriendInfo.groupId < 0) {
      i = 0;
    }
    if (i != 0) {
      FriendIntimateRelationshipHelper.a(paramExtRspData, paramExtensionInfo, paramFriendInfo.vecIntimateInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.IntimateInfoProcessor
 * JD-Core Version:    0.7.0.1
 */