import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class amhk
  implements bmvh
{
  amhk(amhd paramamhd) {}
  
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
    amhd.a(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(364)));
    amhd.b(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(367)));
    amhd.c(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(366)));
    amhd.d(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(365)));
    amhd.e(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(393)));
    amhd.f(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(433)));
    amhd.a(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(501)), true);
    amhd.a(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(502)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhk
 * JD-Core Version:    0.7.0.1
 */