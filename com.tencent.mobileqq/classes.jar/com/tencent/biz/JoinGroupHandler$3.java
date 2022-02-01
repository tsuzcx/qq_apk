package com.tencent.biz;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

class JoinGroupHandler$3
  extends TroopMngObserver
{
  JoinGroupHandler$3(JoinGroupHandler paramJoinGroupHandler) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramLong != this.a.d) {
      return;
    }
    JoinGroupHandler localJoinGroupHandler = this.a;
    localJoinGroupHandler.d = 0L;
    JoinGroupHandler.a(localJoinGroupHandler, false);
    if (paramBoolean)
    {
      JoinGroupHandler.a(this.a, paramTroopInfo);
      return;
    }
    JoinGroupHandler.a(this.a, 2131916242, 1);
    this.a.f.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.JoinGroupHandler.3
 * JD-Core Version:    0.7.0.1
 */