package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_droplist_option;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stImgReplacement;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.PackageUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class GdtAdUtil
{
  public static stSimpleMetaGdtAdInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return null;
    }
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = new stSimpleMetaGdtAdInfo();
    localstSimpleMetaGdtAdInfo.floatingLayerCardStyle = new stFloatingLayerCardStyle();
    localstSimpleMetaGdtAdInfo.bottomButton = new s_button();
    localstSimpleMetaGdtAdInfo.bottomButton.stMapABTest = new HashMap();
    localstSimpleMetaGdtAdInfo.user = new stSimpleMetaPerson();
    localstSimpleMetaGdtAdInfo.pictureUrl = new stImgReplacement();
    localstSimpleMetaGdtAdInfo.left_top_button = new stNewIconStyle();
    Object localObject2 = a(paramstSimpleMetaFeed);
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localstSimpleMetaGdtAdInfo.isWeishiGdtTangramAdv = true;
        localstSimpleMetaGdtAdInfo.gdtTangramAdJson = paramstSimpleMetaFeed.gdt_ad_info;
        localstSimpleMetaGdtAdInfo.cellId = paramstSimpleMetaFeed.id;
        localstSimpleMetaGdtAdInfo.floatingLayerCardStyle.cardType = 1001;
        localObject1 = paramstSimpleMetaFeed.tags;
        if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).product_type.get() == 12)
        {
          localstSimpleMetaGdtAdInfo.cookie = new HashMap();
          localstSimpleMetaGdtAdInfo.cookie.put(Integer.valueOf(0), "app");
          if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info != null) {
            localstSimpleMetaGdtAdInfo.appid = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info.app_package_name.get();
          }
          localstSimpleMetaGdtAdInfo.bottomButton.text = HardCodeUtil.a(2131716177);
          localstSimpleMetaGdtAdInfo.bottomButton.button_background_img = "https://qzonestyle.gtimg.cn/aoi/sola/20180427113436_0gqVu4ZoCd.png";
          localstSimpleMetaGdtAdInfo.bottomButton.stMapABTest.put(Integer.valueOf(0), Integer.valueOf(1));
          localstSimpleMetaGdtAdInfo.playType = 2;
          localstSimpleMetaGdtAdInfo.videoType = 1001;
          localObject3 = paramstSimpleMetaFeed.video;
          if (localObject3 != null) {
            localstSimpleMetaGdtAdInfo.videoTime = ((stMetaUgcVideoSeg)localObject3).duration;
          }
          localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).exp_info;
          if (localObject3 != null) {
            ((qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localObject3).qq_game_video_ad_style.get();
          }
          localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info;
          if (localObject3 != null)
          {
            localObject4 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).advertiser_info;
            if (localObject4 != null)
            {
              localstSimpleMetaGdtAdInfo.user.nick = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject4).corporate_image_name.get();
              localstSimpleMetaGdtAdInfo.user.avatar = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject4).corporate_logo.get();
            }
            localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).video_info;
            if (localObject3 != null)
            {
              localstSimpleMetaGdtAdInfo.video_url = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).video_url.get();
              localstSimpleMetaGdtAdInfo.videoId = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).tencent_video_id.get();
              localstSimpleMetaGdtAdInfo.videoClickType = 1;
            }
            localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info.basic_info;
            if (localObject3 != null)
            {
              localstSimpleMetaGdtAdInfo.summary = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).txt.get();
              if (((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).img != null)
              {
                localstSimpleMetaGdtAdInfo.pictureUrl.img = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).img.get();
                localstSimpleMetaGdtAdInfo.pictureUrl.width = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).pic_width.get();
                localstSimpleMetaGdtAdInfo.pictureUrl.height = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject3).pic_height.get();
              }
            }
            localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).display_info.button_info.get();
            if ((localObject3 != null) && (((List)localObject3).size() > 0))
            {
              i = 0;
              if (i < ((List)localObject3).size())
              {
                localObject4 = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)((List)localObject3).get(i);
                if ((localObject4 == null) || (((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject4).pos == null) || (((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject4).pos.get() != 2)) {
                  break label907;
                }
                localstSimpleMetaGdtAdInfo.bottomButton.text = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject4).txt.get();
                break label907;
              }
            }
          }
        }
        else
        {
          localstSimpleMetaGdtAdInfo.bottomButton.text = HardCodeUtil.a(2131716179);
          continue;
        }
        localstSimpleMetaGdtAdInfo.customDroplist = new ArrayList();
      }
      catch (Exception paramstSimpleMetaFeed)
      {
        paramstSimpleMetaFeed.printStackTrace();
        return localstSimpleMetaGdtAdInfo;
      }
      Object localObject3 = new s_droplist_option();
      ((s_droplist_option)localObject3).actiontype = 40;
      ((s_droplist_option)localObject3).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
      ((s_droplist_option)localObject3).optext = HardCodeUtil.a(2131716182);
      ((s_droplist_option)localObject3).reportattach = "option_actiontype=3&";
      ((s_droplist_option)localObject3).reporttype = 2001;
      Object localObject4 = new s_droplist_option();
      ((s_droplist_option)localObject4).actiontype = 2;
      ((s_droplist_option)localObject4).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
      ((s_droplist_option)localObject4).jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
      ((s_droplist_option)localObject4).optext = HardCodeUtil.a(2131716180);
      ((s_droplist_option)localObject4).reportattach = "option_actiontype=6&";
      localstSimpleMetaGdtAdInfo.customDroplist.add(localObject3);
      localstSimpleMetaGdtAdInfo.customDroplist.add(localObject4);
      localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).dest_info;
      if (localObject3 != null)
      {
        localstSimpleMetaGdtAdInfo.canvasData = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).canvas_json.get();
        localstSimpleMetaGdtAdInfo.dest_url = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).landing_page.get();
        localstSimpleMetaGdtAdInfo.dest_type = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).dest_type.get();
      }
      localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info;
      if (localObject3 != null)
      {
        localstSimpleMetaGdtAdInfo.reportUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).negative_feedback_url.get();
        localstSimpleMetaGdtAdInfo.actionUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).click_url.get();
        localstSimpleMetaGdtAdInfo.impressionUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject3).exposure_url.get();
        localstSimpleMetaGdtAdInfo.isGdtAdImpressionReport = false;
        localstSimpleMetaGdtAdInfo.isGdtAdOriginalImpressionReport = false;
      }
      localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info;
      if (localObject2 != null)
      {
        localstSimpleMetaGdtAdInfo.rankCurrentWithHalfStar = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject2).app_score_num.get();
        localstSimpleMetaGdtAdInfo.schemaPageUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject2).customized_invoke_url.get();
        localstSimpleMetaGdtAdInfo.appid = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject2).app_package_name.get();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((stMetaTag)((ArrayList)localObject1).get(0)).toString();
        localstSimpleMetaGdtAdInfo.left_top_button.img_url = ((String)localObject1);
      }
      localstSimpleMetaGdtAdInfo.mapPassBack = paramstSimpleMetaFeed.map_pass_back;
      continue;
      label907:
      i += 1;
    }
  }
  
  static String a(stSimpleMetaGdtAdInfo paramstSimpleMetaGdtAdInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramstSimpleMetaGdtAdInfo != null)
    {
      str1 = str2;
      if (TextUtils.isEmpty(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson)) {}
    }
    try
    {
      str1 = new JSONObject(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optJSONObject("display_info").optJSONObject("basic_info").optString("marketing_pendant");
      return str1;
    }
    catch (Exception paramstSimpleMetaGdtAdInfo)
    {
      WSLog.d("GdtAdUtil", "getMarketingDendantUrl error: " + paramstSimpleMetaGdtAdInfo);
    }
    return "";
  }
  
  protected static String a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str = "";
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = a(paramstSimpleMetaFeed);
    paramstSimpleMetaFeed = str;
    if (localstSimpleMetaGdtAdInfo != null)
    {
      paramstSimpleMetaFeed = str;
      if (localstSimpleMetaGdtAdInfo.cookie != null) {
        paramstSimpleMetaFeed = (String)localstSimpleMetaGdtAdInfo.cookie.get(Integer.valueOf(0));
      }
    }
    if ((!TextUtils.isEmpty(paramstSimpleMetaFeed)) && ("app".equalsIgnoreCase(paramstSimpleMetaFeed))) {}
    for (int i = 1; (localstSimpleMetaGdtAdInfo != null) && (i != 0) && (PackageUtil.a(paramContext, localstSimpleMetaGdtAdInfo.appid)); i = 0) {
      return "打开";
    }
    if ((localstSimpleMetaGdtAdInfo != null) && (localstSimpleMetaGdtAdInfo.bottomButton != null) && (!TextUtils.isEmpty(localstSimpleMetaGdtAdInfo.bottomButton.text))) {
      return localstSimpleMetaGdtAdInfo.bottomButton.text;
    }
    if (i != 0) {
      return "立即下载";
    }
    return "了解详情";
  }
  
  private static String a(Context paramContext, WSVerticalItemData paramWSVerticalItemData)
  {
    String str2 = "";
    String str1 = str2;
    stSimpleMetaFeed localstSimpleMetaFeed;
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo;
    qq_ad_get.QQAdGetRsp.AdInfo.AppInfo localAppInfo;
    if (paramWSVerticalItemData != null)
    {
      str1 = str2;
      if ((paramWSVerticalItemData.a() instanceof stSimpleMetaFeed))
      {
        localstSimpleMetaFeed = paramWSVerticalItemData.a();
        localAdInfo = a(localstSimpleMetaFeed);
        str1 = str2;
        if (localAdInfo != null)
        {
          localAppInfo = localAdInfo.app_info;
          str1 = str2;
          if (localAdInfo.product_type != null)
          {
            str1 = str2;
            if (localAppInfo != null)
            {
              str1 = str2;
              if (localAppInfo.app_package_name != null) {
                paramWSVerticalItemData = str2;
              }
            }
          }
        }
      }
    }
    try
    {
      str2 = new JSONObject(localstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0).optJSONObject("report_info").optString("original_exposure_url");
      str1 = str2;
      paramWSVerticalItemData = str2;
      if (!TextUtils.isEmpty(str2))
      {
        paramWSVerticalItemData = str2;
        str1 = GdtOriginalExposureReporter.a(str2, localAdInfo.product_type.get(), paramContext, localAppInfo.app_package_name.get());
      }
      return str1;
    }
    catch (Throwable paramContext)
    {
      WSLog.d("GdtAdUtil", "getOriginalIExposureUrl error: " + paramContext);
    }
    return paramWSVerticalItemData;
  }
  
  static String a(String paramString, stSimpleMetaGdtAdInfo paramstSimpleMetaGdtAdInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramstSimpleMetaGdtAdInfo != null)
    {
      str1 = str2;
      if (TextUtils.isEmpty(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson)) {}
    }
    try
    {
      paramstSimpleMetaGdtAdInfo = new JSONObject(new JSONObject(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optString("ext_json"));
      str1 = str2;
      if (paramstSimpleMetaGdtAdInfo.has(paramString)) {
        str1 = paramstSimpleMetaGdtAdInfo.optString(paramString);
      }
      return str1;
    }
    catch (Exception paramstSimpleMetaGdtAdInfo)
    {
      WSLog.d("GdtAdUtil", "getValueFromExtJson errorKey: " + paramString + "\n" + paramstSimpleMetaGdtAdInfo);
    }
    return "";
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed == null) || (TextUtils.isEmpty(paramstSimpleMetaFeed.gdt_ad_info))) {
      return null;
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    try
    {
      paramstSimpleMetaFeed = new JSONObject(paramstSimpleMetaFeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0);
      paramstSimpleMetaFeed = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramstSimpleMetaFeed));
      return paramstSimpleMetaFeed;
    }
    catch (Throwable paramstSimpleMetaFeed)
    {
      paramstSimpleMetaFeed.printStackTrace();
    }
    return localAdInfo;
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {}
    try
    {
      paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
      if (paramstSimpleMetaFeed != null)
      {
        paramstSimpleMetaFeed = new GdtAd(paramstSimpleMetaFeed);
        GdtPreLoader.a().a(paramstSimpleMetaFeed);
      }
      return;
    }
    catch (Throwable paramstSimpleMetaFeed)
    {
      WSLog.d("GdtAdUtil", "adPreLoad error: " + paramstSimpleMetaFeed);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QZLog.w("GdtAdUtil", "[forwardToBrowser] invalid parameters, context=" + paramActivity + ", url=" + paramString);
      return;
    }
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.forwardToBrowser(((BasePluginActivity)paramActivity).getOutActivity(), paramString, paramInt, paramBundle, null);
      return;
    }
    QZoneHelper.forwardToBrowser(paramActivity, paramString, paramInt, paramBundle, null);
  }
  
  public static void a(Context paramContext, int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    WSLog.b("GdtAdUtil", 2, "[onItemClick] action=" + paramInt1);
    if (paramstSimpleMetaFeed.gdt_ad_info == null) {
      return;
    }
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = new stSimpleMetaGdtAdInfo();
    localstSimpleMetaGdtAdInfo.customDroplist = new ArrayList();
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
    for (;;)
    {
      s_droplist_option locals_droplist_option;
      try
      {
        paramstSimpleMetaFeed = paramstSimpleMetaFeed.display_info;
        if (paramstSimpleMetaFeed != null)
        {
          paramstSimpleMetaFeed = paramstSimpleMetaFeed.video_info;
          if (paramstSimpleMetaFeed != null)
          {
            localstSimpleMetaGdtAdInfo.video_url = paramstSimpleMetaFeed.video_url.get();
            localstSimpleMetaGdtAdInfo.videoId = paramstSimpleMetaFeed.tencent_video_id.get();
            localstSimpleMetaGdtAdInfo.videoClickType = 1;
          }
        }
        paramstSimpleMetaFeed = new s_droplist_option();
        paramstSimpleMetaFeed.actiontype = 40;
        paramstSimpleMetaFeed.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        paramstSimpleMetaFeed.optext = HardCodeUtil.a(2131716182);
        paramstSimpleMetaFeed.reportattach = "option_actiontype=3&";
        paramstSimpleMetaFeed.reporttype = 2001;
        locals_droplist_option = new s_droplist_option();
        locals_droplist_option.actiontype = 2;
        locals_droplist_option.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        locals_droplist_option.jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
        locals_droplist_option.optext = HardCodeUtil.a(2131716180);
        locals_droplist_option.reportattach = "option_actiontype=6&";
        localstSimpleMetaGdtAdInfo.customDroplist.add(paramstSimpleMetaFeed);
        localstSimpleMetaGdtAdInfo.customDroplist.add(locals_droplist_option);
        switch (paramInt1)
        {
        case 131072: 
          WSLog.b("GdtAdUtil", "invalid action, " + paramInt1);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      a(paramContext, locals_droplist_option);
      return;
    }
  }
  
  public static void a(Context paramContext, s_droplist_option params_droplist_option)
  {
    if (paramContext == null)
    {
      QZLog.w("GdtAdUtil", "[onOpenBrowser] no context");
      return;
    }
    if ((params_droplist_option == null) || (TextUtils.isEmpty(params_droplist_option.jumpurl)))
    {
      QZLog.w("GdtAdUtil", "[onOpenBrowser] no jumpUrl");
      return;
    }
    if ((paramContext instanceof BasePluginActivity)) {}
    for (paramContext = (BasePluginActivity)paramContext;; paramContext = (Activity)paramContext)
    {
      a(paramContext, params_droplist_option.jumpurl, null, -1);
      return;
    }
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramstSimpleMetaFeed);
      if (localObject1 != null)
      {
        paramstSimpleMetaFeed.poster = new stSimpleMetaPerson();
        paramstSimpleMetaFeed.imgReplacements = new ArrayList();
        paramstSimpleMetaFeed.new_icon = new stNewIconStyle();
        paramstSimpleMetaFeed.video = new stMetaUgcVideoSeg();
        try
        {
          paramstSimpleMetaFeed.floatingLayerCardStyle.cardType = 1002;
          paramstSimpleMetaFeed.video_type = 2;
          Object localObject2 = paramstSimpleMetaFeed.tags;
          if ((localObject1 != null) && (((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info != null) && (((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info != null) && (((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.aid != null)) {
            paramstSimpleMetaFeed.id = String.valueOf(((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.aid.get());
          }
          b(paramContext, paramstSimpleMetaFeed);
          paramContext = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).exp_info;
          if (paramContext != null) {
            paramContext.qq_game_video_ad_style.get();
          }
          paramContext = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info;
          if (paramContext != null)
          {
            localObject2 = paramContext.advertiser_info;
            if (localObject2 != null)
            {
              paramstSimpleMetaFeed.poster.nick = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject2).corporate_image_name.get();
              paramstSimpleMetaFeed.poster.avatar = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject2).corporate_logo.get();
            }
            paramContext = paramContext.video_info;
            if (paramContext != null)
            {
              paramstSimpleMetaFeed.video_url = paramContext.video_url.get();
              paramstSimpleMetaFeed.video.duration = (paramContext.media_duration.get() * 1000);
            }
            paramContext = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.basic_info;
            localObject1 = new stImgReplacement();
            if ((paramContext != null) && (localObject1 != null) && (paramstSimpleMetaFeed.imgReplacements != null) && (paramstSimpleMetaFeed.video != null))
            {
              paramstSimpleMetaFeed.feed_desc = paramContext.txt.get();
              ((stImgReplacement)localObject1).img = paramContext.img.get();
              ((stImgReplacement)localObject1).width = paramContext.pic_width.get();
              ((stImgReplacement)localObject1).height = paramContext.pic_height.get();
              paramstSimpleMetaFeed.imgReplacements.add(localObject1);
              paramstSimpleMetaFeed.video.width = paramContext.pic_width.get();
              paramstSimpleMetaFeed.video.height = paramContext.pic_height.get();
              return;
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, GdtAppReceiver paramGdtAppReceiver, WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
    try
    {
      paramWSPlayerParam = new GdtHandler.Params();
      paramWSPlayerParam.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
      paramWSPlayerParam.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramstSimpleMetaFeed);
      paramWSPlayerParam.jdField_a_of_type_Boolean = true;
      paramWSPlayerParam.jdField_a_of_type_Int = 8;
      paramWSPlayerParam.jdField_b_of_type_Int = 6;
      paramWSPlayerParam.jdField_b_of_type_Boolean = paramBoolean;
      paramWSPlayerParam.jdField_c_of_type_Int = 7;
      paramWSPlayerParam.jdField_c_of_type_Boolean = false;
      paramWSPlayerParam.d = false;
      paramWSPlayerParam.e = false;
      paramWSPlayerParam.f = true;
      paramWSPlayerParam.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramGdtAppReceiver);
      paramWSPlayerParam.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
      paramWSPlayerParam.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForArk.class;
      paramWSPlayerParam.jdField_a_of_type_AndroidOsBundle = new Bundle();
      paramWSPlayerParam.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_gzh_weishi");
      GdtHandler.a(paramWSPlayerParam);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramWSVerticalItemData != null) && ((paramWSVerticalItemData.a() instanceof stSimpleMetaFeed)))
    {
      paramContext = paramWSVerticalItemData.a();
      paramWSVerticalItemData = paramWSVerticalItemData.a();
      if ((paramContext != null) && (paramContext.gdt_ad_type == 1) && (paramContext.gdt_ad_info != null) && (paramWSVerticalItemData != null) && (!TextUtils.isEmpty(paramWSVerticalItemData.impressionUrl)) && (!paramWSVerticalItemData.isGdtAdImpressionReport))
      {
        GdtReporter.doCgiReport(paramWSVerticalItemData.impressionUrl);
        paramWSVerticalItemData.isGdtAdImpressionReport = true;
      }
    }
  }
  
  public static void b(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramContext == null) || (paramstSimpleMetaFeed == null)) {}
    do
    {
      return;
      paramContext = a(paramContext, paramstSimpleMetaFeed);
    } while (TextUtils.isEmpty(paramContext));
    paramstSimpleMetaFeed.new_icon.title = paramContext;
  }
  
  public static void b(Context paramContext, WSVerticalItemData paramWSVerticalItemData)
  {
    paramContext = a(paramContext, paramWSVerticalItemData);
    if (!TextUtils.isEmpty(paramContext))
    {
      GdtReporter.doCgiReport(paramContext);
      QZLog.i("GdtAdUtil", "GDT_CGI_REPORT" + paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil
 * JD-Core Version:    0.7.0.1
 */