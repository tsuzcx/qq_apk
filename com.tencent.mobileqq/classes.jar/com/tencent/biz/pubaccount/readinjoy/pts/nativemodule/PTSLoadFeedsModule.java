package com.tencent.biz.pubaccount.readinjoy.pts.nativemodule;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSEventDispatcher.PTSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.pts.nativemodule.IPTSLoadFeeds;
import com.tencent.qphone.base.util.QLog;

public class PTSLoadFeedsModule
  implements IPTSLoadFeeds
{
  private PTSEventDispatcher.PTSObserver a = new PTSLoadFeedsModule.1(this);
  
  public PTSLoadFeedsModule()
  {
    PTSEventDispatcher.a().a(this.a);
  }
  
  public void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)((QQAppInterface)ReadInJoyUtils.a()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    QLog.i("PTSLoadFeedsModule", 1, "[loadFeeds], channelID = " + paramLong1 + ", limitCount = " + paramInt);
    if (localReadInJoyLogicManager != null) {
      localReadInJoyLogicManager.a().a((int)paramLong1, paramInt, 9223372036854775807L, true, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSLoadFeedsModule
 * JD-Core Version:    0.7.0.1
 */