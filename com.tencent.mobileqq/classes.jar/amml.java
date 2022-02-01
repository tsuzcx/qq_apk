import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class amml
  implements TianShuGetAdvCallback
{
  amml(amme paramamme) {}
  
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
    amme.a(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(364)));
    amme.b(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(367)));
    amme.c(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(366)));
    amme.d(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(365)));
    amme.e(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(393)));
    amme.f(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(433)));
    amme.a(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(501)), true);
    amme.a(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(502)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amml
 * JD-Core Version:    0.7.0.1
 */