package com.tencent.biz.pubaccount.NativeAd.report.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportData;
import com.tencent.biz.pubaccount.NativeAd.report.bean.AMSReportObj;
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
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
      if ((localIReportObj != null) && (localIReportObj.a())) {
        localReportData.a(localIReportObj);
      }
    }
    return localReportData;
  }
  
  public static ActionEntity a(AdReportData paramAdReportData)
  {
    if (paramAdReportData.a() != null) {
      return paramAdReportData.a();
    }
    int i = paramAdReportData.b();
    if (i == 32) {
      return ActionEntity.PKMiddlePage;
    }
    if ((paramAdReportData.a() != null) && (ReadInJoyAdUtils.h(paramAdReportData.a())))
    {
      if (i == 37) {
        return ActionEntity.OutSuperMask;
      }
      return ActionEntity.InnerSuperMask;
    }
    return ActionEntity.Default;
  }
  
  public static ReportAction a(AdReportData paramAdReportData)
  {
    if (paramAdReportData.a() != null) {
      return paramAdReportData.a();
    }
    int i = paramAdReportData.a();
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
          if ((paramAdReportData.a() != null) && (paramAdReportData.a().adClickPos != null) && (paramAdReportData.a().adClickPos == AdClickPos.SoftAdClose)) {
            return ReportAction.CLOSE;
          }
          if (paramAdReportData.b() != null) {
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
          if (paramAdReportData.d() == 39) {
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
  
  public static Integer a(AdReportData paramAdReportData)
  {
    Integer localInteger = Integer.valueOf(0);
    if (paramAdReportData == null) {
      return localInteger;
    }
    if (paramAdReportData.b() != null)
    {
      if (paramAdReportData.b().intValue() == -1) {
        return localInteger;
      }
      return paramAdReportData.b();
    }
    return localInteger;
  }
  
  public static String a(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    if (paramAdReportData.a() == null) {
      return null;
    }
    return paramAdReportData.a().getLiujinReportUrl();
  }
  
  public static Map<String, IReportObj> a(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[9];
    int i = 0;
    arrayOfClass[0] = AdLoadReportObj.class;
    arrayOfClass[1] = AMSReportObj.class;
    arrayOfClass[2] = AppReportObj.class;
    arrayOfClass[3] = CommonReportObj.class;
    arrayOfClass[4] = ControlReportObj.class;
    arrayOfClass[5] = DeviceReportObj.class;
    arrayOfClass[6] = GameReportObj.class;
    arrayOfClass[7] = NFBReportObj.class;
    arrayOfClass[8] = VideoReportObj.class;
    HashMap localHashMap = new HashMap();
    int j = arrayOfClass.length;
    while (i < j)
    {
      IReportObj localIReportObj = a(paramAdReportData, arrayOfClass[i]);
      if ((localIReportObj != null) && (localIReportObj.a())) {
        localHashMap.put(localIReportObj.a(), localIReportObj);
      }
      i += 1;
    }
    return localHashMap;
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
  
  public static String b(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    if (paramAdReportData.a() == null) {
      return null;
    }
    return paramAdReportData.a().getTicket();
  }
  
  public static String c(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return null;
    }
    if (paramAdReportData.a() == null) {
      return null;
    }
    return paramAdReportData.a().getAmsNfbUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil
 * JD-Core Version:    0.7.0.1
 */