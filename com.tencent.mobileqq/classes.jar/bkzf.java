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

public class bkzf
{
  private QQAppInterface a;
  
  public bkzf(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static azie a(TianShuAccess.AdItem paramAdItem, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramAdItem == null) || (paramQQAppInterface == null)) {
      return null;
    }
    bbzy.a(paramQQAppInterface.getApp(), bkzh.a(paramString));
    Object localObject1 = new HashMap();
    paramQQAppInterface = paramAdItem.argList.get().iterator();
    Object localObject2;
    while (paramQQAppInterface.hasNext())
    {
      localObject2 = (TianShuAccess.MapEntry)paramQQAppInterface.next();
      ((HashMap)localObject1).put(((TianShuAccess.MapEntry)localObject2).key.get(), ((TianShuAccess.MapEntry)localObject2).value.get());
    }
    azif localazif = new azif();
    String str1 = (String)((HashMap)localObject1).get("showStartTime");
    String str2 = (String)((HashMap)localObject1).get("showEndTime");
    paramQQAppInterface = (String)((HashMap)localObject1).get("resourceType");
    String str3 = paramAdItem.traceinfo.get();
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
      k = bkzh.a((String)((HashMap)localObject1).get("androidMinimumMemorySize"));
      m = bkzh.a((String)((HashMap)localObject1).get("androidMinimumOSVersion"));
      n = bkzh.a((String)((HashMap)localObject1).get("linkType"));
      i1 = bkzh.a((String)((HashMap)localObject1).get("thirdPartyReportPlatform"));
      i2 = bkzh.a((String)((HashMap)localObject1).get("showPriority"));
      str4 = (String)((HashMap)localObject1).get("thirdPartyReportURLForExposure");
      str5 = (String)((HashMap)localObject1).get("bannertype");
      i3 = bkzh.a((String)((HashMap)localObject1).get("shouldShowAdMark"));
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
      boolean bool = bkzh.a(j, k, m);
      localazif.h(paramString).b(paramAdItem.iAdId.get() + "").c(str1).d(str2).c(i).e(paramQQAppInterface).d(n).f((String)localObject1).b(bool).g(str4).b(i2).e(i1).i(str3).j("").a(i3).a(str5);
      return localazif.a();
      paramQQAppInterface = (String)((HashMap)localObject1).get("imageURL");
      break;
      paramQQAppInterface = (String)((HashMap)localObject1).get("gifURL");
      break;
      paramQQAppInterface = (String)((HashMap)localObject1).get("videoURL");
      break;
    }
  }
  
  public static List<blbu> a()
  {
    ArrayList localArrayList = new ArrayList();
    blbu localblbu = new blbu();
    localblbu.b = 5;
    localblbu.a = 510;
    localArrayList.add(localblbu);
    return localArrayList;
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp, String paramString)
  {
    if (this.a == null) {}
    do
    {
      HashMap localHashMap;
      for (;;)
      {
        return;
        if (paramGetAdsRsp.mapAds.has()) {}
        for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp != null; paramGetAdsRsp = null)
        {
          localHashMap = new HashMap();
          paramGetAdsRsp = paramGetAdsRsp.iterator();
          while (paramGetAdsRsp.hasNext())
          {
            TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
            if ((localRspEntry != null) && (localRspEntry.key.has())) {
              localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
            }
          }
        }
      }
      paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(510));
      if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() > 0)) {
        a(paramGetAdsRsp.value.lst.get());
      }
    } while ((!azii.a(this.a)) || (!"tianshu_req_splash_type_pull_down".equals(paramString)));
    akkg.a().a(this.a, null, false);
  }
  
  private void a(List<TianShuAccess.AdItem> paramList)
  {
    if (this.a == null) {
      return;
    }
    azhz.a(new ArrayList(), this.a, this.a.getCurrentUin(), "tianshu", paramList);
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    blbw.a().a(a(), new bkzg(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzf
 * JD-Core Version:    0.7.0.1
 */