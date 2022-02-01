package com.tencent.biz.pubaccount.weishi_new.report;

import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stDevice;
import UserGrowth.stH5OpInfo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.ReportRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.utils.NumberUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;

public class UserActionReportPresenter
  implements IWeishiServiceListener
{
  private static WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  private static String jdField_a_of_type_JavaLangString;
  private static String b;
  private static String c = "";
  
  static
  {
    a();
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_a_of_type_AndroidNetWifiWifiManager == null) {
      jdField_a_of_type_AndroidNetWifiWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
    WSLog.b("wifiInfo", paramContext.toString());
    WSLog.b("SSID", "" + paramContext.getIpAddress());
    return paramContext.getIpAddress();
  }
  
  public static stReportItem a()
  {
    long l = 0L;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    stReportItem localstReportItem = new stReportItem();
    localstReportItem.imp_date = ((int)(System.currentTimeMillis() / 1000L));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localstReportItem.uin = l;
      localstReportItem.network_type = WSDeviceUtils.g().toLowerCase();
      localstReportItem.os = ("android" + WSDeviceUtils.c() + " - " + WSDeviceUtils.b());
      localstReportItem.city = a();
      localstReportItem.ip = WSDeviceUtils.a();
      localstReportItem.qua = QUA.getQUA3();
      localstReportItem.vendor = DeviceInfoUtil.h();
      localObject = new stDevice();
      ((stDevice)localObject).encrypted_deviceid = WSGlobalConfig.a().e();
      ((stDevice)localObject).imei = a(BaseApplicationImpl.getContext());
      ((stDevice)localObject).qimei = b(BaseApplicationImpl.getContext());
      localstReportItem.device = ((stDevice)localObject);
      if (!WeishiGuideUtils.a(BaseApplicationImpl.getContext())) {
        break label197;
      }
    }
    label197:
    for (int i = 2;; i = 1)
    {
      localstReportItem.exist_weishi = i;
      return localstReportItem;
      l = NumberUtils.a((String)localObject, 0L);
      break;
    }
  }
  
  public static stReportItem a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    stReportItem localstReportItem = a();
    localstReportItem.upos = (paramInt + 1);
    if (paramstSimpleMetaFeed == null)
    {
      WSLog.d("weishi-report", "convertFeedToReport feed == null");
      return localstReportItem;
    }
    localstReportItem.map_pass_back = paramstSimpleMetaFeed.map_pass_back;
    localstReportItem.authorid = paramstSimpleMetaFeed.poster_id;
    localstReportItem.feedid = paramstSimpleMetaFeed.id;
    localstReportItem.title = paramstSimpleMetaFeed.feed_desc;
    if (paramstSimpleMetaFeed.video != null) {
      localstReportItem.video_time = paramstSimpleMetaFeed.video.duration;
    }
    if (paramstSimpleMetaFeed.poster != null)
    {
      localstReportItem.authorid = paramstSimpleMetaFeed.poster.id;
      localstReportItem.authorname = paramstSimpleMetaFeed.poster.nick;
    }
    if ((paramstSimpleMetaFeed.bt_style != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.bt_style.title))) {
      localstReportItem.ext_map = a(paramstSimpleMetaFeed.bt_style.title);
    }
    if (paramstSimpleMetaFeed.video_type == 7) {
      localstReportItem.video_type = 7;
    }
    for (;;)
    {
      localstReportItem.traceId = paramstSimpleMetaFeed.traceId;
      localstReportItem.feed_map_ext = paramstSimpleMetaFeed.map_ext;
      a(localstReportItem, paramstSimpleMetaFeed.waterFallCardStyle);
      localstReportItem.pool_type = paramstSimpleMetaFeed.videoPoolType;
      return localstReportItem;
      if (paramstSimpleMetaFeed.video_type == 6) {
        localstReportItem.video_type = 6;
      } else if ((paramstSimpleMetaFeed.h5_op_info != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.h5_op_info.h5Url))) {
        localstReportItem.video_type = 1;
      } else if (paramstSimpleMetaFeed.video_type == 0) {
        localstReportItem.video_type = 0;
      } else {
        localstReportItem.video_type = paramstSimpleMetaFeed.video_type;
      }
    }
  }
  
  private static String a()
  {
    if (TextUtils.isEmpty(c)) {
      c = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCity();
    }
    if ((c.endsWith(HardCodeUtil.a(2131715818))) && (c.length() > 1)) {
      c = c.substring(0, c.length() - 1);
    }
    return c;
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return str;
        str = HardCodeUtil.a(2131715814);
        continue;
        str = HardCodeUtil.a(2131715791);
        continue;
        str = HardCodeUtil.a(2131715801);
        continue;
        str = HardCodeUtil.a(2131715808);
        continue;
        str = HardCodeUtil.a(2131715798);
        continue;
        str = HardCodeUtil.a(2131715802);
        continue;
        str = HardCodeUtil.a(2131715817);
        continue;
        str = HardCodeUtil.a(2131715785);
        continue;
        str = HardCodeUtil.a(2131715788);
        continue;
        str = HardCodeUtil.a(2131715793);
        continue;
        str = HardCodeUtil.a(2131715815);
        continue;
        str = HardCodeUtil.a(2131715810);
        continue;
        str = HardCodeUtil.a(2131715804);
        switch (paramInt2)
        {
        default: 
          break;
        case 12: 
          str = HardCodeUtil.a(2131715780);
          continue;
          str = HardCodeUtil.a(2131715812);
          continue;
          str = HardCodeUtil.a(2131715819);
          continue;
          str = HardCodeUtil.a(2131715792);
          continue;
          str = HardCodeUtil.a(2131715813);
          continue;
          str = HardCodeUtil.a(2131715787);
          continue;
          str = HardCodeUtil.a(2131715783);
          continue;
          str = HardCodeUtil.a(2131715803);
          continue;
          str = HardCodeUtil.a(2131715781);
          continue;
          str = HardCodeUtil.a(2131715807);
          switch (paramInt2)
          {
          default: 
            break;
          case 12: 
            str = HardCodeUtil.a(2131715795);
            continue;
            str = HardCodeUtil.a(2131715789);
            switch (paramInt2)
            {
            default: 
              break;
            case 12: 
              str = HardCodeUtil.a(2131715797);
              continue;
              str = HardCodeUtil.a(2131715784);
              continue;
              str = HardCodeUtil.a(2131715794);
              continue;
              str = HardCodeUtil.a(2131715799);
              switch (paramInt2)
              {
              default: 
                break;
              case 2: 
                str = HardCodeUtil.a(2131715816);
                break;
              case 6: 
                str = HardCodeUtil.a(2131715805);
                continue;
                str = HardCodeUtil.a(2131715806);
                switch (paramInt2)
                {
                default: 
                  break;
                case 2: 
                  str = HardCodeUtil.a(2131715809);
                  break;
                case 14: 
                  str = HardCodeUtil.a(2131715786);
                  break;
                case 12: 
                  str = HardCodeUtil.a(2131715782);
                  break;
                case 6: 
                  str = HardCodeUtil.a(2131715790);
                  continue;
                  str = HardCodeUtil.a(2131715796);
                  switch (paramInt2)
                  {
                  case 10: 
                  case 11: 
                  default: 
                    break;
                  case 9: 
                    str = "进入H5";
                    break;
                  case 12: 
                    str = HardCodeUtil.a(2131715811);
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    return HardCodeUtil.a(2131715800);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    try
    {
      jdField_a_of_type_JavaLangString = QQDeviceInfo.getIMEI("1d76c6");
      return jdField_a_of_type_JavaLangString;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        WSLog.d("weishi-810", "telephonyManager.getDeviceId encounter error:" + paramContext);
      }
    }
  }
  
  private static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qq_bt_text", paramString);
    return localHashMap;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, stReportItem paramstReportItem)
  {
    stReportItem localstReportItem = paramstReportItem;
    if (paramstReportItem == null) {
      localstReportItem = a();
    }
    localstReportItem.pagetype = paramInt2;
    localstReportItem.optype = paramInt1;
    localstReportItem.comment_loctaion = paramInt3;
    a(localstReportItem);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramInt3);
    paramstSimpleMetaFeed.optype = paramInt2;
    paramstSimpleMetaFeed.pagetype = paramInt1;
    if (!TextUtils.isEmpty(paramString)) {
      paramstSimpleMetaFeed.downloadscene = paramString;
    }
    a(paramInt2, paramstSimpleMetaFeed);
  }
  
  public static void a(int paramInt1, int paramInt2, stReportItem paramstReportItem)
  {
    stReportItem localstReportItem = paramstReportItem;
    if (paramstReportItem == null) {
      localstReportItem = a();
    }
    localstReportItem.pagetype = paramInt2;
    localstReportItem.optype = paramInt1;
    a(localstReportItem);
  }
  
  public static void a(int paramInt, stReportItem paramstReportItem)
  {
    paramstReportItem.optype = paramInt;
    a(paramstReportItem);
  }
  
  public static void a(stReportItem paramstReportItem)
  {
    if (paramstReportItem == null)
    {
      WSLog.d("weishi-report", "report error item = null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstReportItem);
    a(localArrayList);
  }
  
  private static void a(stReportItem paramstReportItem, stWaterFallCardStyle paramstWaterFallCardStyle)
  {
    if (paramstWaterFallCardStyle != null)
    {
      paramstReportItem.card_type = paramstWaterFallCardStyle.cardType;
      paramstReportItem.ratioW = paramstWaterFallCardStyle.ratioW;
      paramstReportItem.ratioH = paramstWaterFallCardStyle.ratioH;
      paramstReportItem.isFullSpan = paramstWaterFallCardStyle.isFullSpan;
    }
  }
  
  public static void a(ArrayList<stReportItem> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      WSLog.d("weishi-report", "report error items: " + paramArrayList);
      return;
    }
    String str = a(((stReportItem)paramArrayList.get(0)).optype, ((stReportItem)paramArrayList.get(0)).pagetype);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      stReportItem localstReportItem = (stReportItem)localIterator.next();
      WSLog.b("weishi-report", "report " + str + " stReportItem:" + localstReportItem.toString());
    }
    paramArrayList = new WeishiTask(new ReportRequest(paramArrayList), null, new UserActionReportPresenter.1(str), 2001);
    WeishiBusinessLooper.a().a(paramArrayList);
  }
  
  public static String b(Context paramContext)
  {
    if (TextUtils.isEmpty(b)) {}
    try
    {
      WSLog.b("weishi-810", "try get QIMei from UserAction.getQIMEI!");
      b = UserAction.getQIMEI();
      if (b == null)
      {
        WSLog.d("weishi-810", "getImei finally encounter error and return empty");
        b = "";
      }
      return b;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        WSLog.d("weishi-810", "UserAction.getQIMEI encounter error:" + paramContext);
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    if (jdField_a_of_type_AndroidNetWifiWifiManager == null) {
      jdField_a_of_type_AndroidNetWifiWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
    WSLog.b("wifiInfo", paramContext.toString());
    return paramContext.getSSID().replace("\"", "");
  }
  
  public void a(WeishiTask paramWeishiTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter
 * JD-Core Version:    0.7.0.1
 */