import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class beke
{
  public TianShuAccess.AdItem a;
  public String a;
  public String b;
  public String c;
  
  public static beke a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
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
    localObject1 = new beke();
    ((beke)localObject1).jdField_a_of_type_JavaLangString = ((String)localHashMap.get("type"));
    ((beke)localObject1).c = ((String)localHashMap.get("pic"));
    ((beke)localObject1).b = ((String)localHashMap.get("url"));
    ((beke)localObject1).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
    if (TextUtils.isEmpty(((beke)localObject1).c)) {
      return null;
    }
    return localObject1;
  }
  
  public static List<beke> a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp, int paramInt)
  {
    int i = 0;
    if ((!paramBoolean) || (paramGetAdsRsp == null)) {
      return null;
    }
    if (paramGetAdsRsp.mapAds.has()) {}
    for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null) {
      return null;
    }
    Object localObject1 = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    Object localObject2;
    while (paramGetAdsRsp.hasNext())
    {
      localObject2 = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localObject2 != null) && (((TianShuAccess.RspEntry)localObject2).key.has())) {
        ((Map)localObject1).put(Integer.valueOf(((TianShuAccess.RspEntry)localObject2).key.get()), localObject2);
      }
    }
    paramGetAdsRsp = (TianShuAccess.RspEntry)((Map)localObject1).get(Integer.valueOf(paramInt));
    if ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst.size() == 0) || (paramGetAdsRsp.value.lst.get(0) == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get() == null)) {
      return null;
    }
    localObject1 = new ArrayList();
    paramInt = i;
    for (;;)
    {
      Object localObject3;
      if (paramInt < paramGetAdsRsp.value.lst.size())
      {
        localObject3 = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(paramInt)).argList.get();
        localObject2 = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject3).next();
          String str = ((TianShuAccess.MapEntry)localObject4).key.get();
          localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
            ((Map)localObject2).put(str, localObject4);
          }
        }
        localObject3 = new beke();
        ((beke)localObject3).jdField_a_of_type_JavaLangString = ((String)((Map)localObject2).get("type"));
        ((beke)localObject3).c = ((String)((Map)localObject2).get("pic"));
        ((beke)localObject3).b = ((String)((Map)localObject2).get("url"));
        ((beke)localObject3).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(paramInt));
        if (!TextUtils.isEmpty(((beke)localObject3).c)) {}
      }
      else
      {
        return localObject1;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable.getDrawable(((beke)localObject3).c, (URLDrawable.URLDrawableOptions)localObject2).startDownload();
      bnwq.a().a(((beke)localObject3).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem);
      ((List)localObject1).add(localObject3);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beke
 * JD-Core Version:    0.7.0.1
 */