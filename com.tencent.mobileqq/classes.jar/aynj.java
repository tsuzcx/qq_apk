import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aynj
{
  public TianShuAccess.AdItem a;
  public String a;
  public String b;
  public String c;
  
  public static aynj a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((!paramBoolean) || (paramGetAdsRsp == null)) {
      return null;
    }
    if (paramGetAdsRsp.mapAds.has()) {}
    for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    while (paramGetAdsRsp.hasNext())
    {
      localObject1 = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localObject1 != null) && (((TianShuAccess.RspEntry)localObject1).key.has())) {
        localHashMap.put(Integer.valueOf(((TianShuAccess.RspEntry)localObject1).key.get()), localObject1);
      }
    }
    paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(236));
    if ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst.size() == 0) || (paramGetAdsRsp.value.lst.get(0) == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get() == null)) {
      return null;
    }
    Object localObject1 = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get();
    localHashMap = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
      String str = ((TianShuAccess.MapEntry)localObject2).key.get();
      localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        localHashMap.put(str, localObject2);
      }
    }
    localObject1 = new aynj();
    ((aynj)localObject1).jdField_a_of_type_JavaLangString = ((String)localHashMap.get("type"));
    ((aynj)localObject1).c = ((String)localHashMap.get("pic"));
    ((aynj)localObject1).b = ((String)localHashMap.get("url"));
    ((aynj)localObject1).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
    if (TextUtils.isEmpty(((aynj)localObject1).c)) {
      return null;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aynj
 * JD-Core Version:    0.7.0.1
 */