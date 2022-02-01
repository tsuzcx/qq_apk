package com.tencent.biz;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;

class JoinGroupHandler$3
  extends TroopBusinessObserver
{
  JoinGroupHandler$3(JoinGroupHandler paramJoinGroupHandler) {}
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.jdField_a_of_type_Long = 0L;
    JoinGroupHandler.a(this.a, false);
    if (paramBoolean)
    {
      JoinGroupHandler.a(this.a, paramTroopInfo);
      return;
    }
    JoinGroupHandler.a(this.a, 2131719023, 1);
    this.a.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.JoinGroupHandler.3
 * JD-Core Version:    0.7.0.1
 */