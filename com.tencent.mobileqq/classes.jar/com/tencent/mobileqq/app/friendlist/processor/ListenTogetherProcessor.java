package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ListenTogetherProcessor
  extends BaseFriendProcessor
{
  public ListenTogetherProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.ListenTogetherProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    paramExtRspData = (QQAppInterface)this.mApp;
    paramList = paramList.iterator();
    label34:
    Object localObject;
    ExtensionInfo localExtensionInfo;
    if (paramList.hasNext())
    {
      localObject = (Pair)paramList.next();
      localExtensionInfo = (ExtensionInfo)((Pair)localObject).first;
      localObject = (FriendInfo)((Pair)localObject).second;
      if (((FriendInfo)localObject).groupId < 0) {
        break label113;
      }
    }
    label113:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ExtSnsFrdDataHandleHelper.a(paramExtRspData, paramBoolean, localExtensionInfo, String.valueOf(((FriendInfo)localObject).friendUin), parseExtSnsFrdData(((FriendInfo)localObject).vecExtSnsFrdData));
      break label34;
      break;
    }
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    boolean bool = true;
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.ListenTogetherProcessor", 1, "onUpdateExtensionInfo| app is not QQAppInterface");
      return;
    }
    paramExtRspData = (QQAppInterface)this.mApp;
    if (paramFriendInfo.groupId >= 0) {}
    for (;;)
    {
      ExtSnsFrdDataHandleHelper.a(paramExtRspData, bool, paramExtensionInfo, String.valueOf(paramFriendInfo.friendUin), parseExtSnsFrdData(paramFriendInfo.vecExtSnsFrdData));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.ListenTogetherProcessor
 * JD-Core Version:    0.7.0.1
 */