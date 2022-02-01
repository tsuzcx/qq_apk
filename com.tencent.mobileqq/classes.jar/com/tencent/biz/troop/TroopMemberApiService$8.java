package com.tencent.biz.troop;

import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.association.data.AllianceItem;

class TroopMemberApiService$8
  extends TroopAssociationObserver
{
  TroopMemberApiService$8(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = b;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, paramBoolean, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), paramAllianceItem }, str, "com.tencent.mobileqq:troopmanage");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.8
 * JD-Core Version:    0.7.0.1
 */