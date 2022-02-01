package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.gdtad.util.GdtDeviceUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.ResponseCallback;
import com.tencent.mobileqq.kandian.biz.fastweb.api.IItemDatasListUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AttachedAdData;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RecommendTitleData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class FastWebAdtUtil
{
  public static int a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    if (FastWeqAdUtils.b(paramProteusBannerBigPicItemData)) {
      return 28;
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramProteusBannerBigPicItemData)) {
      return 25;
    }
    if (paramProteusBannerBigPicItemData.a) {
      return 26;
    }
    return 10;
  }
  
  private static int a(List<BaseData> paramList, BaseData paramBaseData)
  {
    int i;
    if (paramBaseData.aP == 9) {
      i = ((RecommendAdData)paramBaseData).a;
    } else {
      i = 2;
    }
    int j = 0;
    for (int k = i; j < paramList.size(); k = i)
    {
      i = k;
      if (((BaseData)paramList.get(j)).aP == 6)
      {
        k -= 1;
        i = k;
        if (k == 1) {
          return j + 1;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  private static int a(JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.isNull("ad_pos_type");
    int i = 0;
    if (!bool) {
      i = paramJSONObject.optInt("ad_pos_type", 0);
    }
    return i;
  }
  
  private static AdData a(JSONObject paramJSONObject, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastWebAdRequestUtil", 1, "parseAdItem failed");
      }
      return null;
    }
    Object localObject;
    if (paramInt1 == 2)
    {
      localObject = new ProteusInnerData();
      ((AdData)localObject).aS = true;
    }
    else if (paramInt1 == 1)
    {
      localObject = b(paramJSONObject);
    }
    else
    {
      localObject = new RecommendAdData();
    }
    ((AdData)localObject).aN = paramJSONObject.toString();
    ((AdData)localObject).aT = paramInt1;
    ((AdData)localObject).aG = paramInt3;
    ((AdData)localObject).a(paramJSONObject, paramString);
    if (((AdData)localObject).a(paramJSONObject, paramInt2))
    {
      ((AdData)localObject).a();
      return localObject;
    }
    ((AdData)localObject).a();
    return null;
  }
  
  private static AdData a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AdData localAdData1 = a(paramJSONObject1, paramInt1, paramString2, paramInt2, paramInt3);
    if (localAdData1 == null) {
      return null;
    }
    paramJSONObject1 = localAdData1;
    Object localObject = localAdData1;
    for (;;)
    {
      try
      {
        if (localAdData1.aB == 32)
        {
          paramJSONObject1 = localAdData1;
          localObject = localAdData1;
          if (localAdData1.j != null)
          {
            paramJSONObject1 = localAdData1;
            AdData localAdData2 = AdExposeFreshManager.a().a("RIJAdRefreshSceneNativeArticle", localAdData1);
            localObject = localAdData1;
            if (localAdData2 != null)
            {
              paramJSONObject1 = localAdData1;
              localObject = localAdData1;
              if (!a(localAdData1, localAdData2))
              {
                paramJSONObject1 = localAdData1;
                localObject = new JSONObject(localAdData2.aN);
                paramJSONObject1 = localAdData1;
                ((JSONObject)localObject).put("rowkey", paramString1);
                paramJSONObject1 = localAdData1;
                paramString1 = a(ReadInJoyAdInnerUtils.a((JSONObject)localObject, paramJSONObject2), paramInt1, paramString2, paramInt2, paramInt3);
                paramJSONObject1 = paramString1;
                paramString2 = new StringBuilder();
                paramJSONObject1 = paramString1;
                paramString2.append("parseExposeFreshAdData，success, adId：");
                if (paramString1 == null) {
                  break label220;
                }
                paramJSONObject1 = paramString1;
                paramJSONObject2 = Integer.valueOf(paramString1.y);
                paramJSONObject1 = paramString1;
                paramString2.append(paramJSONObject2);
                paramJSONObject1 = paramString1;
                QLog.d("AdExposeFreshManager", 1, paramString2.toString());
                return paramString1;
              }
            }
          }
        }
      }
      catch (Throwable paramJSONObject2)
      {
        QLog.d("AdExposeFreshManager", 1, "parseExposeFreshAdData，fail, adId：", paramJSONObject2);
        localObject = paramJSONObject1;
      }
      return localObject;
      label220:
      paramJSONObject2 = "0";
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt1, long paramLong, ResponseCallback paramResponseCallback, int paramInt2)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebAdtUtil.1(paramString1, paramString2, paramString3, paramString4, paramString6, paramString7, paramBoolean, paramInt1, paramLong, paramString5, paramInt2, paramResponseCallback));
  }
  
  public static void a(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData.aP != 10) && (localBaseData.aP != 17))
      {
        if ((localBaseData.aP == 22) && (((ProteusInnerData)localBaseData).h())) {
          i = 1;
        }
      }
      else {
        localArrayList.add(localBaseData);
      }
    }
    if (i != 0) {
      paramList.removeAll(localArrayList);
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramList1 != null)
    {
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseData localBaseData = (BaseData)((Iterator)localObject2).next();
        if ((localBaseData.aP == 9) || (localBaseData.aP == 10) || (localBaseData.aP == 11) || (localBaseData.aP == 17)) {
          ((List)localObject1).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject1);
    }
    if ((paramList2 != null) && (paramList1 != null))
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        localObject1 = (BaseData)paramList2.next();
        if ((((BaseData)localObject1).aP != 10) && (((BaseData)localObject1).aP != 11) && (((BaseData)localObject1).aP != 17))
        {
          int i;
          if (((BaseData)localObject1).aP == 22) {
            i = b(paramList1, (BaseData)localObject1);
          } else {
            i = a(paramList1, (BaseData)localObject1);
          }
          if (i > 0)
          {
            if (i < paramList1.size())
            {
              localObject2 = (BaseData)paramList1.get(i);
              if (((localObject2 instanceof RecommendTitleData)) && ((localObject1 instanceof ProteusBannerBigPicItemData))) {
                ((RecommendTitleData)localObject2).b = ((ProteusBannerBigPicItemData)localObject1).a;
              }
            }
            paramList1.add(i, localObject1);
          }
        }
        else
        {
          ((IItemDatasListUtils)QRoute.api(IItemDatasListUtils.class)).insertForWeight(paramList1, (BaseData)localObject1);
        }
      }
    }
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private static int b(List<BaseData> paramList, BaseData paramBaseData)
  {
    int j = paramBaseData.aP;
    int i = -1;
    if (j == 22)
    {
      Object localObject = (ProteusInnerData)paramBaseData;
      paramBaseData = ((ProteusInnerData)localObject).i();
      boolean bool = ((ProteusInnerData)localObject).h();
      int i2 = ((ProteusInnerData)localObject).a;
      i = paramList.size() - 1;
      int k = 0;
      int n;
      for (j = 0; i > 0; j = n)
      {
        localObject = (BaseData)paramList.get(i);
        if ((!TextUtils.isEmpty(((BaseData)localObject).aZ)) && (!TextUtils.isEmpty(paramBaseData)) && (((BaseData)localObject).aZ.equals(paramBaseData)))
        {
          j = i;
          break label229;
        }
        int i1 = k;
        n = j;
        if (!bool)
        {
          i1 = k;
          n = j;
          if (i2 > 0)
          {
            int m = k;
            n = j;
            if (((IFastWebPTSUtils)QRoute.api(IFastWebPTSUtils.class)).isArticleContent((BaseData)localObject))
            {
              m = k;
              n = j;
              if (((BaseData)localObject).aP != 0)
              {
                k += 1;
                m = k;
                n = j;
                if (j == 0)
                {
                  n = i;
                  m = k;
                }
              }
            }
            i1 = m;
            if (m == i2)
            {
              j = i2;
              break label229;
            }
          }
        }
        i -= 1;
        k = i1;
      }
      i = -1;
      j = i2;
      label229:
      if ((i != -1) && (j > 0) && (j <= paramList.size())) {
        return i;
      }
      i = f(paramList);
    }
    return i;
  }
  
  @NotNull
  private static AdData b(JSONObject paramJSONObject)
  {
    if ((paramJSONObject.has("type")) && (paramJSONObject.optInt("type") == 100)) {
      return new AttachedAdData();
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString("video")))
    {
      localObject = new ProteusBannerVideoItemData();
      if (paramJSONObject.has("video_file_size")) {
        ((ProteusBannerVideoItemData)localObject).c = paramJSONObject.optLong("video_file_size");
      }
      return localObject;
    }
    Object localObject = new ProteusBannerBigPicItemData();
    if (paramJSONObject.has("local_info"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("local_info");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("has local info ->");
        localStringBuilder.append(paramJSONObject);
        QLog.d("FastWebAdRequestUtil", 2, localStringBuilder.toString());
      }
      if (paramJSONObject != null)
      {
        ((ProteusBannerBigPicItemData)localObject).b = paramJSONObject.optString("store_name");
        ((ProteusBannerBigPicItemData)localObject).c = paramJSONObject.optString("store_addr");
        ((ProteusBannerBigPicItemData)localObject).d = paramJSONObject.optString("store_url");
        ((ProteusBannerBigPicItemData)localObject).f = paramJSONObject.optString("store_long");
        ((ProteusBannerBigPicItemData)localObject).e = paramJSONObject.optString("store_lat");
        ((ProteusBannerBigPicItemData)localObject).g = paramJSONObject.optString("dist_desc");
        ((ProteusBannerBigPicItemData)localObject).h = paramJSONObject.optString("corporate_image_name");
        ((ProteusBannerBigPicItemData)localObject).i = paramJSONObject.optString("distance_limit");
        if ((!TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject).b)) && (!TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject).c)) && (!TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject).d)) && (!TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject).f)) && (!TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject).e)) && (!TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject).g)) && (!TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject).i))) {
          ((ProteusBannerBigPicItemData)localObject).a = true;
        }
      }
    }
    return localObject;
  }
  
  private static String b(Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("FastWebAdRequestUtil", "requestAdData start");
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder(((IFastWebRequestUtil)QRoute.api(IFastWebRequestUtil.class)).getWebAdLink());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("ext=");
      localStringBuilder2.append(URLEncoder.encode(paramJSONObject.toString(), "utf-8"));
      localStringBuilder1.append(localStringBuilder2.toString());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramJSONObject = (Map.Entry)paramMap.next();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("&");
        localStringBuilder2.append((String)paramJSONObject.getKey());
        localStringBuilder2.append("=");
        localStringBuilder2.append(URLEncoder.encode((String)paramJSONObject.getValue(), "utf-8"));
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      paramMap = ((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getAccount();
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("requestAdData:");
        paramJSONObject.append(localStringBuilder1);
        paramJSONObject.append("    uin : ");
        paramJSONObject.append(paramMap);
        QLog.d("Q.readinjoy.fast_web", 2, paramJSONObject.toString());
      }
      paramMap = new Bundle();
      HttpUtil.addCookie(paramMap);
      paramJSONObject = localStringBuilder1.toString();
      paramJSONObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), paramJSONObject, "GET", null, paramMap);
      if (paramJSONObject == null)
      {
        QLog.e("Q.readinjoy.fast_web", 2, "requestAdData bytes null");
        return null;
      }
      paramMap = "";
      if (paramJSONObject != null) {
        paramMap = new String(paramJSONObject);
      }
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("requestAdData result:");
        paramJSONObject.append(paramMap);
        QLog.d("Q.readinjoy.fast_web", 2, paramJSONObject.toString());
      }
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  private static Map<String, String> b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    paramString5 = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    paramString6 = paramString5.getAccount();
    paramString6 = ((TicketManager)paramString5.getManager(2)).getSkey(paramString6);
    paramString5 = new HashMap();
    if (paramBoolean) {
      paramString3 = "0";
    }
    paramString5.put("puin", paramString3);
    paramString5.put("id", paramString1);
    paramString5.put("tag", paramString4);
    if (paramString6 == null) {
      paramString1 = "";
    } else {
      paramString1 = ((IReadInJoyWebDataManager)QRoute.api(IReadInJoyWebDataManager.class)).getCSRFToken(paramString6);
    }
    paramString5.put("token", paramString1);
    paramString5.put("cookie", ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getAdCookie());
    paramString5.put("scene", String.valueOf(3));
    paramString5.put("rowkey", paramString2);
    paramString5.put("source_channel_id", String.valueOf(paramLong));
    if (paramInt2 > 0) {
      paramString5.put("contentCount", String.valueOf(paramInt2));
    }
    paramString1 = ((IFastWebRequestUtil)QRoute.api(IFastWebRequestUtil.class)).getArticleDisplayParams(BaseApplication.getContext());
    if (paramString1 != null) {
      try
      {
        paramString2 = new JSONObject();
        if (paramString1.containsKey("fontSize")) {
          paramString2.put("fontSize", paramString1.get("fontSize"));
        }
        if (paramString1.containsKey("lineHeight")) {
          paramString2.put("lineHeight", paramString1.get("lineHeight"));
        }
        if (paramString1.containsKey("paragraphSpace")) {
          paramString2.put("paragraphSpace", paramString1.get("paragraphSpace"));
        }
        if (paramString1.containsKey("screenWidth")) {
          paramString2.put("screenWidth", paramString1.get("screenWidth"));
        }
        if (paramString1.containsKey("screenHeight")) {
          paramString2.put("screenHeight", paramString1.get("screenHeight"));
        }
        if (paramString1.containsKey("contentPadding")) {
          paramString2.put("contentPadding", paramString1.get("contentPadding"));
        }
        paramString5.put("article_display_params", paramString2.toString());
        paramString5.put("noExposeList", AdReqFreshManager.a().d());
        return paramString5;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return paramString5;
  }
  
  private static JSONObject b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject1).a = "ce2d9f";
        localObject1 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
        if (localObject1 == null) {
          break label675;
        }
        localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
        localJSONObject.put("muidtype", 1);
        localObject3 = AdDeviceInfoUtil.b();
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label680;
        }
        localObject2 = "0000000000000000";
        localJSONObject.put("muid", localObject2);
        localJSONObject.put("carrier", GdtDeviceUtil.b(BaseApplicationImpl.getContext()));
        localJSONObject.put("carrier_code", AdDeviceInfoUtil.f());
        localJSONObject.put("c_os", "android");
        localJSONObject.put("appid", String.valueOf(AppSetting.d()));
        localJSONObject.put("app_version_id", AppSetting.d());
        localJSONObject.put("imei", localObject3);
        if (localObject1 != null)
        {
          localJSONObject.put("conn", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn.get());
          localJSONObject.put("hostver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qq_ver.get());
          localJSONObject.put("c_osver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver.get());
          localJSONObject.put("qadid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
          localJSONObject.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
          localJSONObject.put("taid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
          localJSONObject.put("androidid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
          localJSONObject.put("mac_addr", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
          if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
            localJSONObject.put("ipv4", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
          }
          localJSONObject.put("muid_from_gdt", "1");
          localJSONObject.put("muidtype", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type.get());
          if (TextUtils.isEmpty(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get())) {
            localObject2 = "";
          } else {
            localObject2 = ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get();
          }
          localJSONObject.put("muid", localObject2);
          localJSONObject.put("bytes_wx_ver", AdDeviceInfoUtil.a(BaseApplication.getContext()));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("makePhoneInfo0x6cf: deviceInfo: oa=");
            ((StringBuilder)localObject2).append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get());
            ((StringBuilder)localObject2).append(", ta=");
            ((StringBuilder)localObject2).append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            QLog.i("FastWebAdRequestUtil", 2, ((StringBuilder)localObject2).toString());
          }
        }
        localObject2 = Build.BRAND;
        localObject3 = Build.MODEL;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("c_mf", localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localJSONObject.put("c_device", localObject3);
        }
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONArray(paramString);
          localObject2 = new JSONArray();
          int i = 0;
          if (i < paramString.length())
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("qie_context", paramString.getJSONObject(i).toString());
            ((JSONArray)localObject2).put(localObject3);
            i += 1;
            continue;
          }
          if (((JSONArray)localObject2).length() > 0) {
            localJSONObject.put("pos", localObject2);
          }
        }
        localJSONObject.put("present_from", paramInt);
        if (StudyModeManager.h()) {
          localJSONObject.put("reqLearningPatternFlag", 1);
        }
        if (localObject1 != null)
        {
          localJSONObject.put("device_ext", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext.get());
          return localJSONObject;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return localJSONObject;
      label675:
      Object localObject1 = null;
      continue;
      label680:
      Object localObject2 = localObject3;
    }
  }
  
  public static void b(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.aP == 17) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void b(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    Object localObject = new ArrayList();
    if (paramList1 != null)
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData.aP == 22) {
          ((List)localObject).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject);
    }
    if (paramList2 != null)
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        localObject = (BaseData)paramList2.next();
        int i;
        if (((BaseData)localObject).aP == 22) {
          i = b(paramList1, (BaseData)localObject);
        } else {
          i = a(paramList1, (BaseData)localObject);
        }
        if (i > 0) {
          if (i <= paramList1.size() - 1) {
            paramList1.add(i, localObject);
          } else {
            paramList1.add(localObject);
          }
        }
      }
    }
  }
  
  private static boolean b(String paramString1, String paramString2, List<BaseData> paramList, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramList == null) {
        return false;
      }
      try
      {
        Object localObject = new JSONObject(paramString1);
        String str = ((JSONObject)localObject).optString("cookie");
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).saveAdCookie(str);
        str = ((JSONObject)localObject).optString("ad_switchs");
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("result");
        int j = ((JSONObject)localObject).optInt("req_type", 0);
        int i = 0;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          ((JSONObject)localObject).put("rowkey", paramString2);
          int k = a((JSONObject)localObject);
          if (k == 1)
          {
            localObject = a((JSONObject)localObject, paramJSONObject, paramString2, 1, str, -1, j);
            ReadInJoyAdUtils.a((AdData)localObject);
          }
          else if (k == 2)
          {
            localObject = a((JSONObject)localObject, paramJSONObject, paramString2, 2, str, -1, j);
          }
          else
          {
            localObject = a((JSONObject)localObject, paramJSONObject, paramString2, 0, str, ((JSONObject)localObject).getInt("ad_pos"), j);
            ReadInJoyAdUtils.a((AdData)localObject);
          }
          if (localObject != null) {
            paramList.add(localObject);
          }
          i += 1;
        }
        return true;
      }
      catch (Exception paramString2)
      {
        paramList = new StringBuilder();
        paramList.append("");
        paramList.append(paramString1);
        QLog.e("Q.readinjoy.fast_web", 2, paramString2, new Object[] { paramList.toString() });
      }
    }
    return false;
  }
  
  public static void c(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.aP == 22) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  private static void e(List<BaseData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      HashSet localHashSet1 = new HashSet(paramList.size());
      HashSet localHashSet2 = new HashSet();
      int i = 0;
      while (i < paramList.size())
      {
        AdData localAdData = (AdData)paramList.get(i);
        if ((localAdData != null) && (localAdData.j != null))
        {
          localAdData.j.scene = "RIJAdRefreshSceneNativeArticle";
          if (localAdData.aB == 32)
          {
            localHashSet1.add(Long.valueOf(localAdData.j.mAdAid));
            localHashSet2.add(localAdData);
          }
        }
        i += 1;
      }
      AdReqFreshManager.a().a("RIJAdRefreshSceneNativeArticle", localHashSet1);
      AdExposeFreshManager.a().b("RIJAdRefreshSceneNativeArticle", localHashSet2);
    }
  }
  
  private static int f(List<BaseData> paramList)
  {
    int i = paramList.size() - 1;
    while (i > 0)
    {
      BaseData localBaseData = (BaseData)paramList.get(i);
      if ((((IFastWebPTSUtils)QRoute.api(IFastWebPTSUtils.class)).isArticleContent(localBaseData)) && (localBaseData.aP != 0))
      {
        int j = i;
        if (i < paramList.size() - 1) {
          j = i + 1;
        }
        return j;
      }
      i -= 1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAdtUtil
 * JD-Core Version:    0.7.0.1
 */