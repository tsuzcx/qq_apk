package com.tencent.mobileqq.app.friendlist.processor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MutualMarkProcessor
  extends BaseFriendProcessor
{
  public MutualMarkProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int i = 1;
    if (i < 19)
    {
      if ((!paramBoolean2) && (i == 16)) {}
      for (;;)
      {
        i += 1;
        break;
        if (((paramBoolean1) || (i != 18)) && (i != 13)) {
          paramQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i, paramLong).commit();
        }
      }
    }
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
    }
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)this.mApp;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Pair)paramList.next();
        ExtensionInfo localExtensionInfo = (ExtensionInfo)((Pair)localObject).first;
        localObject = (FriendInfo)((Pair)localObject).second;
        paramLong = ((FriendInfo)localObject).friendUin;
        if (paramExtRspData.b == 0) {
          MutualMarkDataS2CHandleHelper.a(localQQAppInterface, localExtensionInfo, String.valueOf(paramLong), ((FriendInfo)localObject).vecMutualMarkData);
        }
      }
    }
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
    }
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)this.mApp;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Pair)paramList.next();
        Friends localFriends = (Friends)((Pair)localObject).first;
        localObject = (FriendInfo)((Pair)localObject).second;
        ExtSnsFrdDataHandleHelper.a(localQQAppInterface, localFriends, localFriends.uin, parseExtSnsFrdData(((FriendInfo)localObject).vecExtSnsFrdData));
      }
    }
  }
  
  public void onGetFriendListFinish(boolean paramBoolean, ArrayList<String> paramArrayList, ExtRspData paramExtRspData)
  {
    boolean bool = true;
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetFriendListComplete| app is not QQAppInterface");
      return;
    }
    paramArrayList = (QQAppInterface)this.mApp;
    QQProfileItem.a(paramArrayList, "775_hot_friend_new_boat_clear_version");
    QQProfileItem.a(paramArrayList, "top_position_and_disturb_clear_version");
    QQProfileItem.a(paramArrayList, "check_message_preview_version_clear");
    if (paramExtRspData.c == 0)
    {
      paramBoolean = true;
      if (paramExtRspData.b != 0) {
        break label81;
      }
    }
    for (;;)
    {
      a(paramArrayList, paramBoolean, bool, paramExtRspData.a);
      return;
      paramBoolean = false;
      break;
      label81:
      bool = false;
    }
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onUpdateExtensionInfo| app is not QQAppInterface");
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.mApp;
      FriendIntimateRelationshipHelper.a(localQQAppInterface, paramExtensionInfo, paramFriendInfo.vecIntimateInfo);
    } while (paramExtRspData.b != 0);
    MutualMarkDataS2CHandleHelper.a(localQQAppInterface, paramExtensionInfo, paramExtensionInfo.uin, paramFriendInfo.vecMutualMarkData);
  }
  
  public void onUpdateFriendInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.MutualMarkProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    ExtSnsFrdDataHandleHelper.a((QQAppInterface)this.mApp, paramFriends, paramFriends.uin, parseExtSnsFrdData(paramFriendInfo.vecExtSnsFrdData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.MutualMarkProcessor
 * JD-Core Version:    0.7.0.1
 */