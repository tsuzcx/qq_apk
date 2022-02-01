package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface ITroopGagMgr
  extends IRuntimeService
{
  public abstract SelfGagInfo getSelfGagInfo(String paramString, boolean paramBoolean);
  
  public abstract boolean isTroopMemberGag(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.ITroopGagMgr
 * JD-Core Version:    0.7.0.1
 */