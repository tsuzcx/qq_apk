package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.IGetMemberListObserver;
import java.util.ArrayList;

public class TroopFaceMemberListProcessor
  extends AbsTroopHandlerProcessor
  implements IGetMemberListObserver
{
  @NonNull
  public String a()
  {
    return "TroopFaceMemberListProcessor";
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if (paramTroopInfo != null)
    {
      paramTroopInfo.updateHeadMemberList(GroupIconHelper.a(GroupIconHelper.a(paramArrayList, paramTroopInfo), false));
      paramAppInterface = ((TroopHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
      if (paramAppInterface != null) {
        paramAppInterface.c(paramTroopInfo.troopuin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopFaceMemberListProcessor
 * JD-Core Version:    0.7.0.1
 */