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
import java.util.Map;
import mqq.app.AppRuntime;

public class UserActionReportPresenter
  implements IWeishiServiceListener
{
  private static String a;
  private static String b;
  private static String c = "";
  private static WifiManager d;
  
  static
  {
    b();
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
    localstReportItem.network_type = WSDeviceUtils.k().toLowerCase();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("android");
    ((StringBuilder)localObject).append(WSDeviceUtils.d());
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(WSDeviceUtils.c());
    localstReportItem.os = ((StringBuilder)localObject).toString();
    localstReportItem.city = b();
    localstReportItem.ip = WSDeviceUtils.b();
    localstReportItem.qua = QUA.getQUA3();
    localstReportItem.vendor = DeviceInfoUtil.t();
    localObject = new stDevice();
    ((stDevice)localObject).encrypted_deviceid = WSGlobalConfig.a().o();
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
                str = HardCodeUtil.a(2131913178);
                break;
              case 138: 
                str = HardCodeUtil.a(2131913201);
                break;
              case 137: 
                str = HardCodeUtil.a(2131913188);
              }
              break;
            case 133: 
              str = HardCodeUtil.a(2131913180);
              break;
            case 132: 
              str = HardCodeUtil.a(2131913175);
              break;
            case 131: 
              str = HardCodeUtil.a(2131913172);
              break;
            case 130: 
              str = HardCodeUtil.a(2131913204);
              break;
            case 129: 
              str = HardCodeUtil.a(2131913189);
              break;
            case 128: 
              str = HardCodeUtil.a(2131913185);
              break;
            case 127: 
              str = HardCodeUtil.a(2131913195);
            }
            break;
          case 121: 
            str = HardCodeUtil.a(2131913181);
            break;
          case 120: 
            str = HardCodeUtil.a(2131913199);
            break;
          case 119: 
            str = HardCodeUtil.a(2131913197);
            break;
          case 118: 
            str = HardCodeUtil.a(2131913206);
            break;
          case 117: 
            str = HardCodeUtil.a(2131913191);
            if (paramInt2 != 12) {
              break;
            }
            str = HardCodeUtil.a(2131913168);
            break;
          case 116: 
            str = HardCodeUtil.a(2131913200);
            break;
          case 115: 
            str = HardCodeUtil.a(2131913176);
            if (paramInt2 != 12) {
              break;
            }
            str = HardCodeUtil.a(2131913184);
            break;
          case 114: 
            str = HardCodeUtil.a(2131913194);
            if (paramInt2 != 12) {
              break;
            }
            str = HardCodeUtil.a(2131913182);
            break;
          case 113: 
            str = HardCodeUtil.a(2131913174);
            break;
          case 112: 
            str = HardCodeUtil.a(2131913183);
            if (paramInt2 != 9)
            {
              if (paramInt2 == 12) {
                str = HardCodeUtil.a(2131913198);
              }
            }
            else {
              str = "进入H5";
            }
            break;
          }
          break;
        case 8: 
          str = HardCodeUtil.a(2131913179);
          break;
        case 7: 
          str = HardCodeUtil.a(2131913190);
          break;
        case 6: 
          str = HardCodeUtil.a(2131913193);
          if (paramInt2 != 2)
          {
            if (paramInt2 != 6)
            {
              if (paramInt2 != 12)
              {
                if (paramInt2 == 14) {
                  str = HardCodeUtil.a(2131913173);
                }
              }
              else {
                str = HardCodeUtil.a(2131913170);
              }
            }
            else {
              str = HardCodeUtil.a(2131913177);
            }
          }
          else {
            str = HardCodeUtil.a(2131913196);
          }
          break;
        case 5: 
          str = HardCodeUtil.a(2131899712);
          break;
        case 4: 
          str = HardCodeUtil.a(2131913186);
          if (paramInt2 != 2)
          {
            if (paramInt2 == 6) {
              str = HardCodeUtil.a(2131913192);
            }
          }
          else {
            str = HardCodeUtil.a(2131913203);
          }
          break;
        case 3: 
          str = HardCodeUtil.a(2131913169);
          break;
        }
      } else {
        str = HardCodeUtil.a(2131913171);
      }
    }
    else {
      str = HardCodeUtil.a(2131913202);
    }
    if (paramInt2 != 3) {
      return str;
    }
    return HardCodeUtil.a(2131913187);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(a)) {
      try
      {
        a = QQDeviceInfo.getIMEI("1d76c6");
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("telephonyManager.getDeviceId encounter error:");
        localStringBuilder.append(paramContext);
        WSLog.d("weishi-810", localStringBuilder.toString());
      }
    }
    return a;
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
      String str = a(((stReportItem)paramArrayList.get(0)).optype, ((stReportItem)paramArrayList.get(0)).pagetype);
      paramArrayList = new WeishiTask(new ReportRequest(paramArrayList), null, new UserActionReportPresenter.1(str), 2001);
      WeishiBusinessLooper.a().a(paramArrayList);
      return;
    }
    WSLog.d("weishi-report", "[UserActionReportPresenter.java][doReport] report error items!");
  }
  
  private static String b()
  {
    if (TextUtils.isEmpty(c)) {
      c = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCity();
    }
    if ((c.endsWith(HardCodeUtil.a(2131913205))) && (c.length() > 1))
    {
      String str = c;
      c = str.substring(0, str.length() - 1);
    }
    return c;
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
    if (d == null) {
      d = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = d.getConnectionInfo();
    WSLog.b("wifiInfo", paramContext.toString());
    return paramContext.getSSID().replace("\"", "");
  }
  
  public static int d(Context paramContext)
  {
    if (d == null) {
      d = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = d.getConnectionInfo();
    WSLog.b("wifiInfo", paramContext.toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramContext.getIpAddress());
    WSLog.b("SSID", localStringBuilder.toString());
    return paramContext.getIpAddress();
  }
  
  public void a(WeishiTask paramWeishiTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter
 * JD-Core Version:    0.7.0.1
 */