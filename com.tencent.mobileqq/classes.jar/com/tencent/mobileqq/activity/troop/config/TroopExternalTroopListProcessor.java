package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor;
import friendlist.GetTroopListRespV2;
import friendlist.stFavoriteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TroopExternalTroopListProcessor
  extends AbsTroopListHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface)
  {
    paramAppInterface = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramAppInterface != null) {
      paramAppInterface.b();
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, GetTroopListRespV2 paramGetTroopListRespV2)
  {
    HashMap localHashMap = new HashMap();
    paramGetTroopListRespV2 = paramGetTroopListRespV2.vecFavGroup.iterator();
    while (paramGetTroopListRespV2.hasNext())
    {
      stFavoriteGroup localstFavoriteGroup = (stFavoriteGroup)paramGetTroopListRespV2.next();
      if ((localstFavoriteGroup.dwSnsFlag & 0x2) == 2L) {
        localHashMap.put(new Long(localstFavoriteGroup.dwGroupCode).toString(), Long.valueOf(localstFavoriteGroup.dwOpenTimestamp));
      }
    }
    paramAppInterface = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramAppInterface != null) {
      paramAppInterface.a(localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopExternalTroopListProcessor
 * JD-Core Version:    0.7.0.1
 */