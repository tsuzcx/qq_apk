package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;

class RIJUserLevelRequestModule$1
  implements Runnable
{
  RIJUserLevelRequestModule$1(RIJUserLevelRequestModule paramRIJUserLevelRequestModule, oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new RIJUserLevelRequestModule.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.1
 * JD-Core Version:    0.7.0.1
 */