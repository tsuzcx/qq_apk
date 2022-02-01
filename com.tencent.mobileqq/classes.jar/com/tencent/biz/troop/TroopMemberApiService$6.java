package com.tencent.biz.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

class TroopMemberApiService$6
  extends TroopMngObserver
{
  TroopMemberApiService$6(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = d;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, false, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, str, "");
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = d;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, true, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }, str, "");
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    TroopMemberApiService localTroopMemberApiService = this.a;
    int i = g;
    String str = getClass().getSuperclass().getName();
    TroopMemberApiService.a(localTroopMemberApiService, i, paramBoolean, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramTroopInfo }, str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.6
 * JD-Core Version:    0.7.0.1
 */