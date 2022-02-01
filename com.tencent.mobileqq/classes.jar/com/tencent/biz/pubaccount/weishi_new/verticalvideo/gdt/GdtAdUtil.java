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
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
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
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
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
      int i;
      try
      {
        localstSimpleMetaGdtAdInfo.isWeishiGdtTangramAdv = true;
        localstSimpleMetaGdtAdInfo.gdtTangramAdJson = paramstSimpleMetaFeed.gdt_ad_info;
        localstSimpleMetaGdtAdInfo.cellId = paramstSimpleMetaFeed.id;
        localstSimpleMetaGdtAdInfo.floatingLayerCardStyle.cardType = 1001;
        Object localObject1 = paramstSimpleMetaFeed.tags;
        if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).product_type.get() == 12)
        {
          localstSimpleMetaGdtAdInfo.cookie = new HashMap();
          localstSimpleMetaGdtAdInfo.cookie.put(Integer.valueOf(0), "app");
          if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info != null) {
            localstSimpleMetaGdtAdInfo.appid = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).app_info.app_package_name.get();
          }
          localstSimpleMetaGdtAdInfo.bottomButton.text = HardCodeUtil.a(2131716100);
        }
        else
        {
          localstSimpleMetaGdtAdInfo.bottomButton.text = HardCodeUtil.a(2131716102);
        }
        localstSimpleMetaGdtAdInfo.bottomButton.button_background_img = "https://qzonestyle.gtimg.cn/aoi/sola/20180427113436_0gqVu4ZoCd.png";
        localstSimpleMetaGdtAdInfo.bottomButton.stMapABTest.put(Integer.valueOf(0), Integer.valueOf(1));
        localstSimpleMetaGdtAdInfo.playType = 2;
        localstSimpleMetaGdtAdInfo.videoType = 1001;
        Object localObject3 = paramstSimpleMetaFeed.video;
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
                break label905;
              }
              localstSimpleMetaGdtAdInfo.bottomButton.text = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject4).txt.get();
              break label905;
            }
          }
        }
        localstSimpleMetaGdtAdInfo.customDroplist = new ArrayList();
        localObject3 = new s_droplist_option();
        ((s_droplist_option)localObject3).actiontype = 40;
        ((s_droplist_option)localObject3).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((s_droplist_option)localObject3).optext = HardCodeUtil.a(2131716105);
        ((s_droplist_option)localObject3).reportattach = "option_actiontype=3&";
        ((s_droplist_option)localObject3).reporttype = 2001;
        Object localObject4 = new s_droplist_option();
        ((s_droplist_option)localObject4).actiontype = 2;
        ((s_droplist_option)localObject4).iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        ((s_droplist_option)localObject4).jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
        ((s_droplist_option)localObject4).optext = HardCodeUtil.a(2131716103);
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
        return localstSimpleMetaGdtAdInfo;
      }
      catch (Exception paramstSimpleMetaFeed)
      {
        paramstSimpleMetaFeed.printStackTrace();
        return localstSimpleMetaGdtAdInfo;
      }
      label905:
      i += 1;
    }
  }
  
  static String a(stSimpleMetaGdtAdInfo paramstSimpleMetaGdtAdInfo)
  {
    if ((paramstSimpleMetaGdtAdInfo != null) && (!TextUtils.isEmpty(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson))) {
      try
      {
        paramstSimpleMetaGdtAdInfo = new JSONObject(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optJSONObject("display_info").optJSONObject("basic_info").optString("marketing_pendant");
        return paramstSimpleMetaGdtAdInfo;
      }
      catch (Exception paramstSimpleMetaGdtAdInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMarketingDendantUrl error: ");
        localStringBuilder.append(paramstSimpleMetaGdtAdInfo);
        WSLog.d("GdtAdUtil", localStringBuilder.toString());
      }
    }
    return "";
  }
  
  protected static String a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = a(paramstSimpleMetaFeed);
    int j = 0;
    if ((localstSimpleMetaGdtAdInfo != null) && (localstSimpleMetaGdtAdInfo.cookie != null)) {
      paramstSimpleMetaFeed = (String)localstSimpleMetaGdtAdInfo.cookie.get(Integer.valueOf(0));
    } else {
      paramstSimpleMetaFeed = "";
    }
    int i = j;
    if (!TextUtils.isEmpty(paramstSimpleMetaFeed))
    {
      i = j;
      if ("app".equalsIgnoreCase(paramstSimpleMetaFeed)) {
        i = 1;
      }
    }
    if ((localstSimpleMetaGdtAdInfo != null) && (i != 0) && (PackageUtil.a(paramContext, localstSimpleMetaGdtAdInfo.appid))) {
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
    String str = "";
    Object localObject = str;
    if (paramWSVerticalItemData != null)
    {
      localObject = str;
      if ((paramWSVerticalItemData.a() instanceof stSimpleMetaFeed))
      {
        paramWSVerticalItemData = paramWSVerticalItemData.a();
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = a(paramWSVerticalItemData);
        localObject = str;
        if (localAdInfo != null)
        {
          qq_ad_get.QQAdGetRsp.AdInfo.AppInfo localAppInfo = localAdInfo.app_info;
          localObject = str;
          if (localAdInfo.product_type != null)
          {
            localObject = str;
            if (localAppInfo != null)
            {
              localObject = str;
              if (localAppInfo.app_package_name != null)
              {
                try
                {
                  paramWSVerticalItemData = new JSONObject(paramWSVerticalItemData.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0).optJSONObject("report_info").optString("original_exposure_url");
                  try
                  {
                    if (!TextUtils.isEmpty(paramWSVerticalItemData))
                    {
                      paramContext = GdtOriginalExposureReporter.a(paramWSVerticalItemData, localAdInfo.product_type.get(), paramContext, localAppInfo.app_package_name.get());
                      return paramContext;
                    }
                    return paramWSVerticalItemData;
                  }
                  catch (Throwable localThrowable)
                  {
                    paramContext = paramWSVerticalItemData;
                    paramWSVerticalItemData = localThrowable;
                  }
                  localStringBuilder = new StringBuilder();
                }
                catch (Throwable paramWSVerticalItemData)
                {
                  paramContext = localThrowable;
                }
                StringBuilder localStringBuilder;
                localStringBuilder.append("getOriginalIExposureUrl error: ");
                localStringBuilder.append(paramWSVerticalItemData);
                WSLog.d("GdtAdUtil", localStringBuilder.toString());
                localObject = paramContext;
              }
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public static String a(String paramString, stSimpleMetaGdtAdInfo paramstSimpleMetaGdtAdInfo)
  {
    if ((paramstSimpleMetaGdtAdInfo != null) && (!TextUtils.isEmpty(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson))) {
      try
      {
        paramstSimpleMetaGdtAdInfo = new JSONObject(new JSONObject(paramstSimpleMetaGdtAdInfo.gdtTangramAdJson).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optString("ext_json"));
        if (paramstSimpleMetaGdtAdInfo.has(paramString))
        {
          paramstSimpleMetaGdtAdInfo = paramstSimpleMetaGdtAdInfo.optString(paramString);
          return paramstSimpleMetaGdtAdInfo;
        }
      }
      catch (Exception paramstSimpleMetaGdtAdInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getValueFromExtJson errorKey: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\n");
        localStringBuilder.append(paramstSimpleMetaGdtAdInfo);
        WSLog.d("GdtAdUtil", localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.gdt_ad_info)))
    {
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
        return localAdInfo;
      }
    }
    return null;
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {
      try
      {
        paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
        if (paramstSimpleMetaFeed != null)
        {
          paramstSimpleMetaFeed = new GdtAd(paramstSimpleMetaFeed);
          GdtPreLoader.a().a(paramstSimpleMetaFeed);
          return;
        }
      }
      catch (Throwable paramstSimpleMetaFeed)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("adPreLoad error: ");
        localStringBuilder.append(paramstSimpleMetaFeed);
        WSLog.d("GdtAdUtil", localStringBuilder.toString());
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramActivity instanceof BasePluginActivity))
      {
        QZoneHelper.forwardToBrowser(((BasePluginActivity)paramActivity).getOutActivity(), paramString, paramInt, paramBundle, null);
        return;
      }
      QZoneHelper.forwardToBrowser(paramActivity, paramString, paramInt, paramBundle, null);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("[forwardToBrowser] invalid parameters, context=");
    paramBundle.append(paramActivity);
    paramBundle.append(", url=");
    paramBundle.append(paramString);
    QZLog.w("GdtAdUtil", paramBundle.toString());
  }
  
  public static void a(Context paramContext, int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onItemClick] action=");
    ((StringBuilder)localObject).append(paramInt1);
    WSLog.b("GdtAdUtil", 2, ((StringBuilder)localObject).toString());
    if (paramstSimpleMetaFeed.gdt_ad_info == null) {
      return;
    }
    localObject = new stSimpleMetaGdtAdInfo();
    ((stSimpleMetaGdtAdInfo)localObject).customDroplist = new ArrayList();
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
    try
    {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.display_info;
      if (paramstSimpleMetaFeed != null)
      {
        paramstSimpleMetaFeed = paramstSimpleMetaFeed.video_info;
        if (paramstSimpleMetaFeed != null)
        {
          ((stSimpleMetaGdtAdInfo)localObject).video_url = paramstSimpleMetaFeed.video_url.get();
          ((stSimpleMetaGdtAdInfo)localObject).videoId = paramstSimpleMetaFeed.tencent_video_id.get();
          ((stSimpleMetaGdtAdInfo)localObject).videoClickType = 1;
        }
      }
      paramstSimpleMetaFeed = new s_droplist_option();
      paramstSimpleMetaFeed.actiontype = 40;
      paramstSimpleMetaFeed.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
      paramstSimpleMetaFeed.optext = HardCodeUtil.a(2131716105);
      paramstSimpleMetaFeed.reportattach = "option_actiontype=3&";
      paramstSimpleMetaFeed.reporttype = 2001;
      s_droplist_option locals_droplist_option = new s_droplist_option();
      locals_droplist_option.actiontype = 2;
      locals_droplist_option.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
      locals_droplist_option.jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
      locals_droplist_option.optext = HardCodeUtil.a(2131716103);
      locals_droplist_option.reportattach = "option_actiontype=6&";
      ((stSimpleMetaGdtAdInfo)localObject).customDroplist.add(paramstSimpleMetaFeed);
      ((stSimpleMetaGdtAdInfo)localObject).customDroplist.add(locals_droplist_option);
      if (paramInt1 != 131072)
      {
        paramContext = new StringBuilder();
        paramContext.append("invalid action, ");
        paramContext.append(paramInt1);
        WSLog.b("GdtAdUtil", paramContext.toString());
        return;
      }
      a(paramContext, locals_droplist_option);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, s_droplist_option params_droplist_option)
  {
    if (paramContext == null)
    {
      QZLog.w("GdtAdUtil", "[onOpenBrowser] no context");
      return;
    }
    if ((params_droplist_option != null) && (!TextUtils.isEmpty(params_droplist_option.jumpurl)))
    {
      if ((paramContext instanceof BasePluginActivity)) {
        paramContext = (BasePluginActivity)paramContext;
      } else {
        paramContext = (Activity)paramContext;
      }
      a(paramContext, params_droplist_option.jumpurl, null, -1);
      return;
    }
    QZLog.w("GdtAdUtil", "[onOpenBrowser] no jumpUrl");
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    Object localObject1 = a(paramstSimpleMetaFeed);
    if (localObject1 == null) {
      return;
    }
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
        paramstSimpleMetaFeed.id = String.valueOf(((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.traceid.get());
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
        if ((paramContext != null) && (paramstSimpleMetaFeed.imgReplacements != null) && (paramstSimpleMetaFeed.video != null))
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
  
  public static boolean a(GdtAd paramGdtAd, int paramInt)
  {
    if (paramGdtAd != null) {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        int i = 0;
        while (i < paramGdtAd.size())
        {
          if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).key.get() == paramInt)
          {
            boolean bool = ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).value.get().equals("1");
            if (bool) {
              return true;
            }
          }
          i += 1;
        }
        StringBuilder localStringBuilder;
        return false;
      }
      catch (Throwable paramGdtAd)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("exp_map error");
        localStringBuilder.append(paramGdtAd);
        QLog.e("GdtAdUtil", 1, localStringBuilder.toString());
      }
    }
  }
  
  public static void b(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramContext != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      paramContext = a(paramContext, paramstSimpleMetaFeed);
      if (!TextUtils.isEmpty(paramContext)) {
        paramstSimpleMetaFeed.new_icon.title = paramContext;
      }
    }
  }
  
  public static void b(Context paramContext, WSVerticalItemData paramWSVerticalItemData)
  {
    paramContext = a(paramContext, paramWSVerticalItemData);
    if (!TextUtils.isEmpty(paramContext))
    {
      GdtReporter.doCgiReport(paramContext);
      paramWSVerticalItemData = new StringBuilder();
      paramWSVerticalItemData.append("GDT_CGI_REPORT");
      paramWSVerticalItemData.append(paramContext);
      QZLog.i("GdtAdUtil", paramWSVerticalItemData.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil
 * JD-Core Version:    0.7.0.1
 */