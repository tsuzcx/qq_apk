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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramContext.getIpAddress());
    WSLog.b("SSID", localStringBuilder.toString());
    return paramContext.getIpAddress();
  }
  
  public static stReportItem a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    stReportItem localstReportItem = new stReportItem();
    localstReportItem.imp_date = ((int)(System.currentTimeMillis() / 1000L));
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    long l = 0L;
    if (!bool) {
      l = NumberUtils.a((String)localObject, 0L);
    }
    localstReportItem.uin = l;
    localstReportItem.network_type = WSDeviceUtils.g().toLowerCase();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("android");
    ((StringBuilder)localObject).append(WSDeviceUtils.c());
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(WSDeviceUtils.b());
    localstReportItem.os = ((StringBuilder)localObject).toString();
    localstReportItem.city = a();
    localstReportItem.ip = WSDeviceUtils.a();
    localstReportItem.qua = QUA.getQUA3();
    localstReportItem.vendor = DeviceInfoUtil.h();
    localObject = new stDevice();
    ((stDevice)localObject).encrypted_deviceid = WSGlobalConfig.a().e();
    ((stDevice)localObject).imei = a(BaseApplicationImpl.getContext());
    ((stDevice)localObject).qimei = b(BaseApplicationImpl.getContext());
    localstReportItem.device = ((stDevice)localObject);
    int i;
    if (WeishiGuideUtils.a(BaseApplicationImpl.getContext())) {
      i = 2;
    } else {
      i = 1;
    }
    localstReportItem.exist_weishi = i;
    return localstReportItem;
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
    } else if (paramstSimpleMetaFeed.video_type == 6) {
      localstReportItem.video_type = 6;
    } else if ((paramstSimpleMetaFeed.h5_op_info != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.h5_op_info.h5Url))) {
      localstReportItem.video_type = 1;
    } else if (paramstSimpleMetaFeed.video_type == 0) {
      localstReportItem.video_type = 0;
    } else {
      localstReportItem.video_type = paramstSimpleMetaFeed.video_type;
    }
    localstReportItem.traceId = paramstSimpleMetaFeed.traceId;
    localstReportItem.feed_map_ext = paramstSimpleMetaFeed.map_ext;
    a(localstReportItem, paramstSimpleMetaFeed.waterFallCardStyle);
    localstReportItem.pool_type = paramstSimpleMetaFeed.videoPoolType;
    return localstReportItem;
  }
  
  private static String a()
  {
    if (TextUtils.isEmpty(c)) {
      c = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCity();
    }
    if ((c.endsWith(HardCodeUtil.a(2131715742))) && (c.length() > 1))
    {
      String str = c;
      c = str.substring(0, str.length() - 1);
    }
    return c;
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1001) {
        switch (paramInt1)
        {
        default: 
          switch (paramInt1)
          {
          default: 
            switch (paramInt1)
            {
            default: 
              switch (paramInt1)
              {
              default: 
                str = "";
                break;
              case 139: 
                str = HardCodeUtil.a(2131715715);
                break;
              case 138: 
                str = HardCodeUtil.a(2131715738);
                break;
              case 137: 
                str = HardCodeUtil.a(2131715725);
              }
              break;
            case 133: 
              str = HardCodeUtil.a(2131715717);
              break;
            case 132: 
              str = HardCodeUtil.a(2131715712);
              break;
            case 131: 
              str = HardCodeUtil.a(2131715709);
              break;
            case 130: 
              str = HardCodeUtil.a(2131715741);
              break;
            case 129: 
              str = HardCodeUtil.a(2131715726);
              break;
            case 128: 
              str = HardCodeUtil.a(2131715722);
              break;
            case 127: 
              str = HardCodeUtil.a(2131715732);
            }
            break;
          case 121: 
            str = HardCodeUtil.a(2131715718);
            break;
          case 120: 
            str = HardCodeUtil.a(2131715736);
            break;
          case 119: 
            str = HardCodeUtil.a(2131715734);
            break;
          case 118: 
            str = HardCodeUtil.a(2131715743);
            break;
          case 117: 
            str = HardCodeUtil.a(2131715728);
            if (paramInt2 != 12) {
              break;
            }
            str = HardCodeUtil.a(2131715704);
            break;
          case 116: 
            str = HardCodeUtil.a(2131715737);
            break;
          case 115: 
            str = HardCodeUtil.a(2131715713);
            if (paramInt2 != 12) {
              break;
            }
            str = HardCodeUtil.a(2131715721);
            break;
          case 114: 
            str = HardCodeUtil.a(2131715731);
            if (paramInt2 != 12) {
              break;
            }
            str = HardCodeUtil.a(2131715719);
            break;
          case 113: 
            str = HardCodeUtil.a(2131715711);
            break;
          case 112: 
            str = HardCodeUtil.a(2131715720);
            if (paramInt2 != 9)
            {
              if (paramInt2 == 12) {
                str = HardCodeUtil.a(2131715735);
              }
            }
            else {
              str = "进入H5";
            }
            break;
          }
          break;
        case 8: 
          str = HardCodeUtil.a(2131715716);
          break;
        case 7: 
          str = HardCodeUtil.a(2131715727);
          break;
        case 6: 
          str = HardCodeUtil.a(2131715730);
          if (paramInt2 != 2)
          {
            if (paramInt2 != 6)
            {
              if (paramInt2 != 12)
              {
                if (paramInt2 == 14) {
                  str = HardCodeUtil.a(2131715710);
                }
              }
              else {
                str = HardCodeUtil.a(2131715706);
              }
            }
            else {
              str = HardCodeUtil.a(2131715714);
            }
          }
          else {
            str = HardCodeUtil.a(2131715733);
          }
          break;
        case 5: 
          str = HardCodeUtil.a(2131715707);
          break;
        case 4: 
          str = HardCodeUtil.a(2131715723);
          if (paramInt2 != 2)
          {
            if (paramInt2 == 6) {
              str = HardCodeUtil.a(2131715729);
            }
          }
          else {
            str = HardCodeUtil.a(2131715740);
          }
          break;
        case 3: 
          str = HardCodeUtil.a(2131715705);
          break;
        }
      } else {
        str = HardCodeUtil.a(2131715708);
      }
    }
    else {
      str = HardCodeUtil.a(2131715739);
    }
    if (paramInt2 != 3) {
      return str;
    }
    return HardCodeUtil.a(2131715724);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      try
      {
        jdField_a_of_type_JavaLangString = QQDeviceInfo.getIMEI("1d76c6");
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("telephonyManager.getDeviceId encounter error:");
        localStringBuilder.append(paramContext);
        WSLog.d("weishi-810", localStringBuilder.toString());
      }
    }
    return jdField_a_of_type_JavaLangString;
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
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject = a(((stReportItem)paramArrayList.get(0)).optype, ((stReportItem)paramArrayList.get(0)).pagetype);
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        stReportItem localstReportItem = (stReportItem)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" stReportItem:");
        localStringBuilder.append(localstReportItem.toString());
        WSLog.b("weishi-report", localStringBuilder.toString());
      }
      paramArrayList = new WeishiTask(new ReportRequest(paramArrayList), null, new UserActionReportPresenter.1((String)localObject), 2001);
      WeishiBusinessLooper.a().a(paramArrayList);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report error items: ");
    ((StringBuilder)localObject).append(paramArrayList);
    WSLog.d("weishi-report", ((StringBuilder)localObject).toString());
  }
  
  public static String b(Context paramContext)
  {
    if (TextUtils.isEmpty(b)) {
      try
      {
        WSLog.b("weishi-810", "try get QIMei from UserAction.getQIMEI!");
        b = UserAction.getQIMEI();
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UserAction.getQIMEI encounter error:");
        localStringBuilder.append(paramContext);
        WSLog.d("weishi-810", localStringBuilder.toString());
      }
    }
    if (b == null)
    {
      WSLog.d("weishi-810", "getImei finally encounter error and return empty");
      b = "";
    }
    return b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter
 * JD-Core Version:    0.7.0.1
 */