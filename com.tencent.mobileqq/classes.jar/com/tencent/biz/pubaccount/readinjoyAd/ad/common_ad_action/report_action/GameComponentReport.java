package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class GameComponentReport
{
  public static long a(AdvertisementInfo paramAdvertisementInfo)
  {
    Long localLong = Long.valueOf(0L);
    if ("RIJAdRefreshSceneNativeArticle".equals(paramAdvertisementInfo.scene)) {
      localLong = Long.valueOf(301L);
    }
    if ("RIJAdRefreshSceneFloatVideo".equals(paramAdvertisementInfo.scene)) {
      localLong = Long.valueOf(305L);
    }
    return localLong.longValue();
  }
  
  private static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "";
          }
          return "3";
        }
        return "2";
      }
      return "1";
    }
    return "0";
  }
  
  private static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ("RIJAdRefreshSceneNativeArticle".equals(paramAdvertisementInfo.scene)) {
      return paramAdvertisementInfo.getExtraParam("game_adtag");
    }
    return "";
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 9)
          {
            if ((paramInt != 10) || (!paramBoolean2)) {
              break label64;
            }
            return "2";
          }
          return "9";
        }
        if (paramBoolean1) {
          return "2";
        }
        if (!paramBoolean2) {
          break label64;
        }
      }
      else
      {
        return "8";
      }
    }
    else {
      if (!paramBoolean1) {
        break label64;
      }
    }
    return "1";
    label64:
    return "0";
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    return a(paramAdvertisementInfo, paramLong1, paramLong2, paramString1, null, paramString2);
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    if (paramAdvertisementInfo == null) {
      return null;
    }
    int i = ReadInJoyCommonSoftAdUtils.a(paramAdvertisementInfo);
    String str = "";
    if (i >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("page_id", Long.valueOf(a(paramAdvertisementInfo)));
    localHashMap.put("oper_module", Long.valueOf(b(paramAdvertisementInfo)));
    localHashMap.put("oper_id", Long.valueOf(paramLong1));
    localHashMap.put("oper_type", Long.valueOf(paramLong2));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((String)localObject);
    localHashMap.put("obj_id", localStringBuilder.toString());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    if ("RIJAdRefreshSceneNativeArticle".equals(paramAdvertisementInfo.scene)) {
      i = 0;
    } else {
      i = 2;
    }
    ((StringBuilder)localObject).append(i);
    localHashMap.put("loc_id", ((StringBuilder)localObject).toString());
    if (paramAdvertisementInfo.gameAdComData != null) {
      localObject = paramAdvertisementInfo.gameAdComData.g;
    } else {
      localObject = "";
    }
    localHashMap.put("app_id", localObject);
    if (paramAdvertisementInfo.gameAdComData != null) {
      localObject = paramAdvertisementInfo.gameAdComData.d;
    } else {
      localObject = "";
    }
    localHashMap.put("game_pkg", localObject);
    localHashMap.put("ex1", paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = a(paramAdvertisementInfo);
    }
    localHashMap.put("ex2", paramString1);
    localHashMap.put("ex3", paramAdvertisementInfo.mRowKey);
    if ((FastWeqAdUtils.e(paramAdvertisementInfo)) && (paramAdvertisementInfo.gameAdComData != null))
    {
      if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.q)) {
        paramString1 = paramAdvertisementInfo.gameAdComData.p;
      } else {
        paramString1 = paramAdvertisementInfo.gameAdComData.q;
      }
    }
    else {
      paramString1 = String.valueOf(paramAdvertisementInfo.mArticleID);
    }
    localHashMap.put("ex4", paramString1);
    localHashMap.put("ex5", paramString3);
    paramString1 = str;
    if (paramAdvertisementInfo.gameAdComData != null) {
      paramString1 = paramAdvertisementInfo.gameAdComData.B;
    }
    localHashMap.put("ex7", paramString1);
    localHashMap.put("browser_version", DeviceInfoUtil.c());
    if (((paramAdvertisementInfo.gameAdComData != null) && (paramAdvertisementInfo.gameAdComData.D.equals("2"))) || (paramAdvertisementInfo.isKolGame)) {
      localHashMap.put("obj_type", "2");
    } else {
      localHashMap.put("obj_type", "1");
    }
    paramAdvertisementInfo = new JSONObject();
    paramString1 = localHashMap.keySet();
    try
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        paramAdvertisementInfo.put(paramString2, localHashMap.get(paramString2));
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("game_gift_report", paramAdvertisementInfo.toString());
        return paramString1;
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
  }
  
  public static JSONObject a(AdData paramAdData, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if ((paramAdData != null) && (paramAdData.a != null))
    {
      AdvertisementInfo localAdvertisementInfo = paramAdData.a;
      if (localAdvertisementInfo.mRowKey == null) {
        localAdvertisementInfo.mRowKey = paramAdData.N;
      }
      return a(localAdvertisementInfo, paramLong1, paramLong2, paramString1, paramString2);
    }
    return null;
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString)
  {
    if (paramAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameComponentReport", 2, "advertisementInfo is null");
      }
      return;
    }
    long l2 = 3010305L;
    long l1 = l2;
    if (paramAdvertisementInfo.mChannelID == 3L)
    {
      l1 = l2;
      if (paramInt == 3) {
        l1 = 3050305L;
      }
    }
    String str = a(paramInt);
    paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
    a(paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), a(paramAdvertisementInfo, l1, 10L, str, paramString), ReportAction.CLICK, ActionEntity.GamePopWindow, Integer.valueOf(20));
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2, ReportAction paramReportAction, ActionEntity paramActionEntity, Integer paramInteger)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(paramAdvertisementInfo);
    QQAppInterface localQQAppInterface = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(localQQAppInterface).a(BaseApplication.getContext()).a(119).b(39).a(paramReportAction).b(paramInteger).a(paramActionEntity).e(paramJSONObject2).a(paramAdvertisementInfo).d(paramJSONObject1));
  }
  
  public static void a(Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString)
  {
    if (paramAdvertisementInfo == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("GameComponentReport", "doGameDownloadStateReport:advertisementInfo is null");
      return;
    }
    boolean bool1 = FastWeqAdUtils.d(paramAdvertisementInfo);
    boolean bool2 = FastWeqAdUtils.b(paramAdvertisementInfo);
    if ((!bool1) && (!bool2)) {
      return;
    }
    String str = a(bool1, bool2, paramInt);
    long l;
    if ((!bool1) && (bool2)) {
      l = 3010307L;
    } else {
      l = 3010205L;
    }
    paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
    a(paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), a(paramAdvertisementInfo, l, 9L, str, paramString), ReportAction.CLICK, ActionEntity.GamePopWindow, paramInteger);
  }
  
  public static void a(Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
    a(paramAdvertisementInfo, paramJSONObject1, paramJSONObject2, ReportAction.CLICK, ActionEntity.Default, paramInteger);
  }
  
  private static long b(AdvertisementInfo paramAdvertisementInfo)
  {
    if ("RIJAdRefreshSceneNativeArticle".equals(paramAdvertisementInfo.scene))
    {
      if (FastWeqAdUtils.c(paramAdvertisementInfo)) {
        return 30101L;
      }
      if (FastWeqAdUtils.d(paramAdvertisementInfo)) {
        return 30102L;
      }
      if (FastWeqAdUtils.b(paramAdvertisementInfo)) {
        return 30103L;
      }
      if (FastWeqAdUtils.f(paramAdvertisementInfo)) {
        return 30104L;
      }
      if (FastWeqAdUtils.e(paramAdvertisementInfo)) {
        return 30105L;
      }
    }
    if ("RIJAdRefreshSceneFloatVideo".equals(paramAdvertisementInfo.scene))
    {
      if (FastWeqAdUtils.d(paramAdvertisementInfo)) {
        return 30501L;
      }
      if (FastWeqAdUtils.c(paramAdvertisementInfo)) {
        return 30502L;
      }
      if (FastWeqAdUtils.b(paramAdvertisementInfo)) {
        return 30503L;
      }
      if (FastWeqAdUtils.f(paramAdvertisementInfo)) {
        return 30504L;
      }
      if (FastWeqAdUtils.e(paramAdvertisementInfo)) {
        return 30505L;
      }
    }
    return 0L;
  }
  
  public static void b(Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClose;
    a(paramAdvertisementInfo, paramJSONObject1, paramJSONObject2, ReportAction.CLOSE, ActionEntity.Default, paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport
 * JD-Core Version:    0.7.0.1
 */