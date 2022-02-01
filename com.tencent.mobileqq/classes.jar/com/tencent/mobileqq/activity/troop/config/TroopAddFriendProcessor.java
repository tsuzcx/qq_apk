package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.AbsTroopAddFriendHandlerProcessor;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.HashMap;
import java.util.List;

public class TroopAddFriendProcessor
  extends AbsTroopAddFriendHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface)
  {
    ((ITroopBatchAddFriendService)paramAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, HashMap<String, Integer> paramHashMap)
  {
    paramAppInterface = ((ITroopBatchAddFriendService)paramAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    if (paramAppInterface != null) {
      paramAppInterface.a(paramString, paramHashMap);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, HashMap<String, String> paramHashMap, List<String> paramList)
  {
    paramAppInterface = ((ITroopBatchAddFriendService)paramAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    if (paramAppInterface != null) {
      paramAppInterface.a(paramString, paramHashMap, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopAddFriendProcessor
 * JD-Core Version:    0.7.0.1
 */