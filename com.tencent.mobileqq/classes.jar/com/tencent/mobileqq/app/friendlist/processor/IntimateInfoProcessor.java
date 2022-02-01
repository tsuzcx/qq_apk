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
    label34:
    label105:
    label109:
    for (;;)
    {
      Object localObject;
      ExtensionInfo localExtensionInfo;
      if (paramList.hasNext())
      {
        localObject = (Pair)paramList.next();
        localExtensionInfo = (ExtensionInfo)((Pair)localObject).first;
        localObject = (FriendInfo)((Pair)localObject).second;
        if (((FriendInfo)localObject).groupId < 0) {
          break label105;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label109;
        }
        FriendIntimateRelationshipHelper.a(paramExtRspData, localExtensionInfo, ((FriendInfo)localObject).vecIntimateInfo);
        break label34;
        break;
      }
    }
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    int i = 1;
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.e("IMCore.friend.IntimateInfoProcessor", 1, "onUpdateExtensionInfo| app is not QQAppInterface");
    }
    for (;;)
    {
      return;
      paramExtRspData = (QQAppInterface)this.mApp;
      if (paramFriendInfo.groupId >= 0) {}
      while (i != 0)
      {
        FriendIntimateRelationshipHelper.a(paramExtRspData, paramExtensionInfo, paramFriendInfo.vecIntimateInfo);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.IntimateInfoProcessor
 * JD-Core Version:    0.7.0.1
 */