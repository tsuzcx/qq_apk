package com.tencent.biz.pubaccount.NativeAd.report.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportData;
import com.tencent.biz.pubaccount.NativeAd.report.bean.AMSReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.AdInfoObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.AdLoadReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.AppReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.CommonReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.ControlReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.DeviceReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.GameReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.NFBReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.bean.VideoReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class AdReportUtil
{
  private static <T extends IReportObj> T a(AdReportData paramAdReportData, Class<T> paramClass)
  {
    int i;
    if (paramAdReportData == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramClass == null) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i | j) != 0) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      paramClass.setAccessible(true);
      paramClass = (IReportObj)paramClass.newInstance(new Object[0]);
      paramClass.a(paramAdReportData);
      return paramClass;
    }
    catch (Exception paramAdReportData)
    {
      QLog.e("AdReportUtil", 1, "parseReportObj error ", paramAdReportData);
    }
    return null;
  }
  
  public static ReportData a(Map<String, IReportObj> paramMap)
  {
    ReportData localReportData = new ReportData();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      IReportObj localIReportObj = (IReportObj)paramMap.next();
      if ((localIReportObj != null) && (localIReportObj.c())) {
        localReportData.a(localIReportObj);
      }
    }
    return localReportData;
  }
  
  public static ReportAction a(AdReportData paramAdReportData)
  {
    if (paramAdReportData.x() != null) {
      return paramAdReportData.x();
    }
    int i = paramAdReportData.c();
    if ((i != 17) && (i != 23))
    {
      if (i != 26)
      {
        if (i != 42) {
          if (i != 80)
          {
            if (i == 116) {
              break label186;
            }
            if (i != 19) {
              if (i == 20) {
                break label190;
              }
            }
          }
        }
        switch (i)
        {
        default: 
          if ((paramAdReportData.g() != null) && (paramAdReportData.g().adClickPos != null) && (paramAdReportData.g().adClickPos == AdClickPos.SoftAdClose)) {
            return ReportAction.CLOSE;
          }
          if (paramAdReportData.w() != null) {
            return ReportAction.CLICK;
          }
          return ReportAction.EXPOSE;
        case 6: 
          return ReportAction.VIDEO_SEE_TIME;
        case 3: 
          return ReportAction.NFB;
        case 2: 
          return ReportAction.EXPOSE;
        case 1: 
          if (paramAdReportData.m() == 39) {
            return ReportAction.CLOSE;
          }
          return ReportAction.CLICK;
          return ReportAction.RECEIVE;
        case 5: 
          label186:
          return ReportAction.CLICK;
        }
      }
      label190:
      return ReportAction.CLOSE;
    }
    return ReportAction.SLIDE;
  }
  
  public static String a()
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount();
    String str = ((TicketManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(2)).getSkey((String)localObject);
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 1024);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
    return false;
  }
  
  public static ActionEntity b(AdReportData paramAdReportData)
  {
    if (paramAdReportData.v() != null) {
      return paramAdReportData.v();
    }
    int i = paramAdReportData.d();
    if (i == 32) {
      return ActionEntity.PKMiddlePage;
    }
    if ((paramAdReportData.g() != null) && (ReadInJoyAdUtils.l(paramAdReportData.g())))
    {
      if (i == 37) {
        return ActionEntity.OutSuperMask;
      }
      return ActionEntity.InnerSuperMask;
    }
    return ActionEntity.Default;
  }
  
  public static Map<String, IReportObj> c(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[10];
    int i = 0;
    arrayOfClass[0] = AdInfoObj.class;
    arrayOfClass[1] = AdLoadReportObj.class;
    arrayOfClass[2] = AMSReportObj.class;
    arrayOfClass[3] = AppReportObj.class;
    arrayOfClass[4] = CommonReportObj.class;
    arrayOfClass[5] = ControlReportObj.class;
    arrayOfClass[6] = DeviceReportObj.class;
    arrayOfClass[7] = GameReportObj.class;
    arrayOfClass[8] = NFBReportObj.class;
    arrayOfClass[9] = VideoReportObj.class;
    HashMap localHashMap = new HashMap();
    int j = arrayOfClass.length;
    while (i < j)
    {
      IReportObj localIReportObj = a(paramAdReportData, arrayOfClass[i]);
      if ((localIReportObj != null) && (localIReportObj.c())) {
        localHashMap.put(localIReportObj.a(), localIReportObj);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static String d(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    if (paramAdReportData.g() == null) {
      return null;
    }
    return paramAdReportData.g().getLiujinReportUrl();
  }
  
  public static String e(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    if (paramAdReportData.g() == null) {
      return null;
    }
    return paramAdReportData.g().getTicket();
  }
  
  public static String f(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    if (paramAdReportData.g() == null) {
      return null;
    }
    return paramAdReportData.g().getAmsNfbUrl();
  }
  
  public static Integer g(AdReportData paramAdReportData)
  {
    Integer localInteger = Integer.valueOf(0);
    if (paramAdReportData == null) {
      return localInteger;
    }
    if (paramAdReportData.w() != null)
    {
      if (paramAdReportData.w().intValue() == -1) {
        return localInteger;
      }
      return paramAdReportData.w();
    }
    return localInteger;
  }
  
  public static String h(AdReportData paramAdReportData)
  {
    if (paramAdReportData != null)
    {
      if (paramAdReportData.g() == null) {
        return "";
      }
      if (TextUtils.isEmpty(paramAdReportData.g().mAdExtInfo)) {
        return "";
      }
      try
      {
        paramAdReportData = new JSONObject(paramAdReportData.g().mAdExtInfo);
        if (paramAdReportData.has("aindex"))
        {
          paramAdReportData = String.valueOf(paramAdReportData.opt("aindex"));
          return paramAdReportData;
        }
      }
      catch (JSONException paramAdReportData)
      {
        paramAdReportData.printStackTrace();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil
 * JD-Core Version:    0.7.0.1
 */