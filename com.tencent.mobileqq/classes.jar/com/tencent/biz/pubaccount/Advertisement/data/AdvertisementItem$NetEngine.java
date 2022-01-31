package com.tencent.biz.pubaccount.Advertisement.data;

import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AdvertisementItem$NetEngine
  implements INetEngine.INetEngineListener
{
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AdvertisementRecentUserManager", 2, "exporsure " + bool);
      }
      paramNetResp = new HashMap();
      paramNetResp.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "imaxExporsureSucessRate", bool, 0L, 0L, paramNetResp, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem.NetEngine
 * JD-Core Version:    0.7.0.1
 */