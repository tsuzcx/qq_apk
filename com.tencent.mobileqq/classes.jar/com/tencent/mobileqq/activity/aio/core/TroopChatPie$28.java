package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;

class TroopChatPie$28
  extends TeamWorkObserver
{
  TroopChatPie$28(TroopChatPie paramTroopChatPie) {}
  
  public void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).onGetGroupAuthDocsGrayTipsInfo(this.a.d, this.a.e, this.a.m, paramBoolean, paramArrayOfObject);
  }
  
  public void d(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).onSetGroupAuthDocsGrayTipsInfo(this.a.d, this.a.e, this.a.m, paramBoolean, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.28
 * JD-Core Version:    0.7.0.1
 */