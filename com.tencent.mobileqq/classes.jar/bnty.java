import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class bnty
{
  private bnwp jdField_a_of_type_Bnwp = new bntz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bnty(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static banw a(TianShuAccess.AdItem paramAdItem, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramAdItem == null) {
      return null;
    }
    bdhj.a(paramQQAppInterface.getApp(), bnua.a(paramString));
    Object localObject1 = new HashMap();
    paramQQAppInterface = paramAdItem.argList.get().iterator();
    Object localObject2;
    while (paramQQAppInterface.hasNext())
    {
      localObject2 = (TianShuAccess.MapEntry)paramQQAppInterface.next();
      ((HashMap)localObject1).put(((TianShuAccess.MapEntry)localObject2).key.get(), ((TianShuAccess.MapEntry)localObject2).value.get());
    }
    banx localbanx = new banx();
    String str1 = (String)((HashMap)localObject1).get("showStartTime");
    String str2 = (String)((HashMap)localObject1).get("showEndTime");
    paramQQAppInterface = (String)((HashMap)localObject1).get("resourceType");
    String str3 = paramAdItem.traceinfo.toString();
    int i = -1;
    if (paramQQAppInterface != null) {
      i = Integer.parseInt(paramQQAppInterface);
    }
    int k;
    int m;
    int n;
    int i1;
    int i2;
    String str4;
    String str5;
    int i3;
    switch (i)
    {
    default: 
      paramQQAppInterface = "";
      k = bnua.a((String)((HashMap)localObject1).get("androidMinimumMemorySize"));
      m = bnua.a((String)((HashMap)localObject1).get("androidMinimumOSVersion"));
      n = bnua.a((String)((HashMap)localObject1).get("linkType"));
      i1 = bnua.a((String)((HashMap)localObject1).get("thirdPartyReportPlatform"));
      i2 = bnua.a((String)((HashMap)localObject1).get("showPriority"));
      str4 = (String)((HashMap)localObject1).get("thirdPartyReportURLForExposure");
      str5 = (String)((HashMap)localObject1).get("bannertype");
      i3 = bnua.a((String)((HashMap)localObject1).get("shouldShowAdMark"));
      if ((m != 0) || (k != 0)) {
        break;
      }
    }
    for (int j = 0;; j = 1)
    {
      localObject2 = (String)((HashMap)localObject1).get("linkURL");
      localObject1 = localObject2;
      if (n == 1)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("http")) {
            localObject1 = "https://" + (String)localObject2;
          }
        }
      }
      boolean bool = bnua.a(j, k, m);
      localbanx.h(paramString).b(paramAdItem.iAdId.get() + "").c(str1).d(str2).c(i).e(paramQQAppInterface).d(n).f((String)localObject1).b(bool).g(str4).b(i2).e(i1).i(str3).j("").a(i3).a(str5);
      return localbanx.a();
      paramQQAppInterface = (String)((HashMap)localObject1).get("imageURL");
      break;
      paramQQAppInterface = (String)((HashMap)localObject1).get("gifURL");
      break;
      paramQQAppInterface = (String)((HashMap)localObject1).get("videoURL");
      break;
    }
  }
  
  public static List<bnwo> a()
  {
    ArrayList localArrayList = new ArrayList();
    bnwo localbnwo = new bnwo();
    localbnwo.b = 5;
    localbnwo.a = 510;
    localArrayList.add(localbnwo);
    return localArrayList;
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (paramGetAdsRsp.mapAds.has())
    {
      paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
      if (paramGetAdsRsp != null) {
        break label28;
      }
    }
    label28:
    do
    {
      return;
      paramGetAdsRsp = null;
      break;
      HashMap localHashMap = new HashMap();
      paramGetAdsRsp = paramGetAdsRsp.iterator();
      while (paramGetAdsRsp.hasNext())
      {
        TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
        if ((localRspEntry != null) && (localRspEntry.key.has())) {
          localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
        }
      }
      paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(510));
    } while ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst.size() <= 0));
    a(paramGetAdsRsp.value.lst.get());
  }
  
  private void a(List<TianShuAccess.AdItem> paramList)
  {
    banr.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "tianshu", paramList);
  }
  
  public void a()
  {
    bnwq.a().a(a(), this.jdField_a_of_type_Bnwp);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnty
 * JD-Core Version:    0.7.0.1
 */