package com.tencent.biz.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;

class TroopMemberApiService$4
  extends TroopModifyObserver
{
  TroopMemberApiService$4(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    TroopMemberApiService localTroopMemberApiService = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
    int i = jdField_a_of_type_Int;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, paramBoolean, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramTroopInfo }, str, "com.tencent.mobileqq:troopmanage");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.4
 * JD-Core Version:    0.7.0.1
 */