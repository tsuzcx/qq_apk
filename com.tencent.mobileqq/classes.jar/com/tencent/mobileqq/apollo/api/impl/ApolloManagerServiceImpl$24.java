package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ApolloManagerServiceImpl$24
  implements TianShuGetAdvCallback
{
  ApolloManagerServiceImpl$24(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "onGetAdvs isSucc:", Boolean.valueOf(paramBoolean) });
    }
    if ((!paramBoolean) || (paramGetAdsRsp == null)) {
      return;
    }
    if (paramGetAdsRsp.mapAds.has()) {}
    for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null)
    {
      QLog.w("ApolloManager", 1, "rspEntries == null");
      return;
    }
    HashMap localHashMap = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    while (paramGetAdsRsp.hasNext())
    {
      TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localRspEntry != null) && (localRspEntry.key.has())) {
        localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
      }
    }
    ApolloManagerServiceImpl.access$1600(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(364)));
    ApolloManagerServiceImpl.access$1700(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(367)));
    ApolloManagerServiceImpl.access$1800(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(366)));
    ApolloManagerServiceImpl.access$1900(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(365)));
    ApolloManagerServiceImpl.access$2000(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(393)));
    ApolloManagerServiceImpl.access$2100(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(433)));
    ApolloManagerServiceImpl.access$2200(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(501)), true);
    ApolloManagerServiceImpl.access$2200(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(502)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.24
 * JD-Core Version:    0.7.0.1
 */