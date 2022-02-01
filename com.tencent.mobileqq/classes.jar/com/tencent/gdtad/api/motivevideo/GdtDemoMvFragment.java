package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdSettings;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.basics.adbox.IGdtAdBox;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForQzone;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class GdtDemoMvFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private com.tencent.gdtad.api.GdtAd jdField_a_of_type_ComTencentGdtadApiGdtAd;
  private final int jdField_b_of_type_Int = 0;
  CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private final int jdField_c_of_type_Int = 1;
  CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private final int jdField_d_of_type_Int = 2;
  CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private int jdField_e_of_type_Int = 0;
  CheckBox jdField_e_of_type_AndroidWidgetCheckBox;
  CheckBox f;
  
  public static GdtHandler.Params a(boolean paramBoolean, Activity paramActivity)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_Boolean = paramBoolean;
    return localParams;
  }
  
  private GdtMotiveVideoPageData a(int paramInt1, com.tencent.gdtad.api.GdtAd paramGdtAd, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mockMVPageData createSize ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" portrait ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" useRealData ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.i("GdtDemoMvFragment", 1, ((StringBuilder)localObject1).toString());
    localObject1 = null;
    Object localObject2 = null;
    if ((paramGdtAd != null) && (paramGdtAd.isLoaded()) && (!paramGdtAd.isInvalidated()) && ((paramGdtAd instanceof com.tencent.gdtad.api.GdtAd)))
    {
      com.tencent.gdtad.aditem.GdtAd localGdtAd = paramGdtAd.getAd();
      if (localGdtAd != null)
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
        localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
        if (paramBoolean) {
          paramInt1 = localGdtAd.getCreativeSize();
        }
        localGdtMotiveVideoPageData.vSize = paramInt1;
        localGdtMotiveVideoPageData.screenOrientation = paramInt2;
        localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
        localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
        localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("VideoUrl ");
        ((StringBuilder)localObject1).append(localGdtMotiveVideoPageData.url);
        GdtLog.d("GdtDemoMvFragment", ((StringBuilder)localObject1).toString());
        localObject1 = localGdtAd.getImageData();
        String str = "";
        if (localObject1 == null) {
          localObject1 = "";
        } else {
          localObject1 = localGdtAd.getImageData().a;
        }
        localGdtMotiveVideoPageData.previewImgUrl = ((String)localObject1);
        localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
        localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
        localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
        localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
        localGdtMotiveVideoPageData.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
        localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
        localGdtMotiveVideoPageData.refId = "biz_src_miniapp";
        localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
        localGdtMotiveVideoPageData.endcardUrl = localGdtAd.getEndcardUrl();
        localGdtMotiveVideoPageData.endcardLoadTime = localGdtAd.getEndcardLoadTime();
        localGdtMotiveVideoPageData.bottomCardUrl = localGdtAd.getBottomCardUrl();
        localGdtMotiveVideoPageData.bottomCardLoadTime = localGdtAd.getBottomCardLoadTime();
        localGdtMotiveVideoPageData.traceId = localGdtAd.getTraceId();
        localObject1 = paramGdtAd.getGdtAdLoader();
        paramGdtAd = localObject2;
        if (localObject1 != null)
        {
          paramGdtAd = localObject2;
          if (((GdtAdLoader)localObject1).a() != null)
          {
            paramGdtAd = localObject2;
            if (((GdtAdLoader)localObject1).a().a != null) {
              paramGdtAd = GdtJsonPbUtil.a((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)((GdtAdLoader)localObject1).a().a.pos_ads_info.get(0)).ads_info.get(0));
            }
          }
        }
        if (paramGdtAd == null) {
          paramGdtAd = str;
        } else {
          paramGdtAd = paramGdtAd.toString();
        }
        localGdtMotiveVideoPageData.adsContent = paramGdtAd;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        localObject1 = localGdtMotiveVideoPageData;
      }
      return localObject1;
    }
    paramGdtAd = new StringBuilder();
    paramGdtAd.append(String.format("mockMVPageData null %d", new Object[] { Integer.valueOf(paramInt1) }));
    paramGdtAd.append(paramInt2);
    QLog.i("GdtDemoMvFragment", 1, paramGdtAd.toString());
    QQToast.a(getBaseActivity(), HardCodeUtil.a(2131705271), 0).a();
    return null;
  }
  
  private String a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    paramAdInfo = GdtJsonPbUtil.a(paramAdInfo);
    if ((paramAdInfo != null) && (!JSONObject.NULL.equals(paramAdInfo))) {
      return paramAdInfo.toString();
    }
    return "";
  }
  
  public static qq_ad_get.QQAdGet a(long paramLong, String paramString)
  {
    Object localObject = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject).deep_link_version.set(1);
    qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.pos_id.set(paramString);
    localPositionInfo.ad_count.set(1);
    localPositionInfo.pos_ext.set((MessageMicro)localObject);
    paramString = new qq_ad_get.QQAdGet.UserInfo();
    paramString.qq.set(paramLong);
    localObject = new qq_ad_get.QQAdGet();
    ((qq_ad_get.QQAdGet)localObject).position_info.add(localPositionInfo);
    ((qq_ad_get.QQAdGet)localObject).user_info.set(paramString);
    return localObject;
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo a()
  {
    Object localObject1 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
    if (localObject1 != null) {
      try
      {
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(((GdtMotiveVideoPageData)localObject1).adsContent)));
        Object localObject2 = this.jdField_a_of_type_ComTencentGdtadApiGdtAd.getAd();
        if ((localObject2 != null) && (localObject1 != null))
        {
          ArrayList localArrayList1 = new ArrayList();
          localArrayList1.add(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForClick());
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForImpression());
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add("https://tytx.m.cn.miaozhen.com/x/k=2137392&p=7Sm5F&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&tr=__REQUESTID__&mo=__OS__&m0=__OPENUDID__&m0a=__DUID__&m1=__ANDROIDID1__&m1a=__ANDROIDID__&m2=__IMEI__&m4=__AAID__&m5=__IDFA__&m6=__MAC1__&m6a=__MAC__&m11=__OAID__&txp=__TXP__&o=");
          String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!TextUtils.isEmpty(str)) {
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.aid.set(Long.parseLong(str));
          }
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(localArrayList1);
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(localArrayList2);
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.video_play_monitor_url.set((List)localObject2);
        }
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return null;
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if (paramGdtMotiveVideoPageData == null) {
      return;
    }
    try
    {
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent)));
      Object localObject1;
      if (localAdInfo.exp_info.has()) {
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localAdInfo.exp_info.get();
      } else {
        localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo();
      }
      int i = this.jdField_e_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            localObject1 = new ArrayList();
            if (localAdInfo.ext.exp_map.get().size() > 0)
            {
              localObject1 = localAdInfo.ext.exp_map.get();
            }
            else
            {
              boolean bool = TextUtils.isEmpty(localAdInfo.ext_json.get());
              if (!bool) {
                try
                {
                  Object localObject2 = new JSONObject(localAdInfo.ext_json.get());
                  localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject2));
                  if (localObject2 != null)
                  {
                    localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject2).exp_map.get();
                    localObject1 = localObject2;
                  }
                }
                catch (Throwable localThrowable)
                {
                  GdtLog.d("GdtDemoMvFragment", "getExpMap", localThrowable);
                }
              }
            }
            qq_ad_get.QQAdGetRsp.AdInfo.ExpParam localExpParam = new qq_ad_get.QQAdGetRsp.AdInfo.ExpParam();
            localExpParam.key.set(100329);
            localExpParam.value.set("2");
            ((List)localObject1).add(localExpParam);
          }
        }
        else {
          ((qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localObject1).video_countdown_style.set(1);
        }
      }
      else {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localObject1).video_countdown_style.set(0);
      }
      paramGdtMotiveVideoPageData.adsContent = a(localAdInfo);
      return;
    }
    catch (Throwable paramGdtMotiveVideoPageData)
    {
      GdtLog.d("GdtDemoMvFragment", "setPageDataUIParams", paramGdtMotiveVideoPageData);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt)
  {
    try
    {
      String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        paramGdtMotiveVideoPageData.setVideoCountDown(Integer.parseInt(str));
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    Object localObject = new GdtMotiveVideoModel(paramGdtMotiveVideoPageData);
    paramGdtMotiveVideoPageData.setRewardText(this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramGdtMotiveVideoPageData.adsContent = paramGdtMotiveVideoPageData.adsContent.replace("\"video_volume\":1", "\"video_volume\":0");
    }
    if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramGdtMotiveVideoPageData.adsContent = paramGdtMotiveVideoPageData.adsContent.replace("video_volume", "video_volume_error");
    }
    if (this.jdField_c_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramGdtMotiveVideoPageData.endcardUrl = URLUtil.b("https://test-h5.gdt.qq.com/union/res/union_site/page/xqMiniGameVideoEndCard/xqMiniGameVideoEndCard.html?debug=mock", "trace_id", ((GdtMotiveVideoModel)localObject).a().getTraceId());
    }
    if (this.jdField_d_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramGdtMotiveVideoPageData.endcardUrl = URLUtil.b("https://h5.gdt.qq.com/xjviewer/nemo/1001751?_wv=1&gdt_ad_id=945580&aidx=50726321&gdt_product_id=1101072624&gdt_media_id=60005012352827&gdt_subordinate_product_id=&via=YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE.yez3lkudc7rhk01NETLOGvdyib4p5ctmuq&versionCode=2987&packageName=com.achievo.vipshop&qz_gdt=yez3lkudc7rhk01&no_yyb=1&clklpp=__CLICK_LPP__&ist=1&click_ext=eyJkaWQiOiJiZWY3ZDBmMTI5MThlZGNhM2IxMzYwMGIyMWJkZjY1MCIsIm9zX3R5cGUiOjEsInNka19kb3dubG9hZCI6MSwic2hvcnRfcG9zX2lkIjozMDA2NDZ9&_wwv=4&xj_scene=5", "trace_id", ((GdtMotiveVideoModel)localObject).a().getTraceId());
    }
    if (this.jdField_e_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramGdtMotiveVideoPageData.bottomCardUrl = a("https://test-h5.gdt.qq.com//union/res/union_site/page/xqMiniGameVideoPlay/xqMiniGameVideoPlay.html", ((GdtMotiveVideoModel)localObject).a().getTraceId());
    }
    if (this.f.isChecked()) {
      try
      {
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent)));
        if (localObject != null) {
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).ext.is_app_preorder.set(true);
        }
        localObject = GdtJsonPbUtil.a((PBField)localObject);
        if (localObject != null) {
          paramGdtMotiveVideoPageData.adsContent = localObject.toString();
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if ((paramInt != 2131378488) && (paramInt != 2131378510)) {
      paramGdtMotiveVideoPageData.url = "https://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c";
    }
    paramGdtMotiveVideoPageData.antiSpamParams = "{\"lt\":2,\"ig\":0}";
    a(paramGdtMotiveVideoPageData);
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString)
  {
    try
    {
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent)));
      qq_ad_get.QQAdGetRsp.AdInfo.DestInfo localDestInfo;
      if (localAdInfo.dest_info.has()) {
        localDestInfo = (qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localAdInfo.dest_info.get();
      } else {
        localDestInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
      }
      localDestInfo.dest_type.set(1);
      localDestInfo.landing_page.set(paramString);
      localAdInfo.dest_info.set(localDestInfo);
      paramGdtMotiveVideoPageData.adsContent = a(localAdInfo);
      return;
    }
    catch (Throwable paramGdtMotiveVideoPageData)
    {
      GdtLog.d("GdtDemoMvFragment", "mockToCellingStyle", paramGdtMotiveVideoPageData);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiGdtAd == null) {
      return;
    }
    Object localObject = new qq_ad_get.QQAdGetRsp();
    int j = jdField_a_of_type_Int;
    jdField_a_of_type_Int = j + 1;
    qq_ad_get.QQAdGetRsp.PosAdInfo localPosAdInfo = new qq_ad_get.QQAdGetRsp.PosAdInfo();
    int i = 0;
    while (i < j % 10)
    {
      com.tencent.gdtad.aditem.GdtAd localGdtAd = this.jdField_a_of_type_ComTencentGdtadApiGdtAd.getAd();
      if (localGdtAd != null) {
        localPosAdInfo.ads_info.add(localGdtAd.info);
      }
      i += 1;
    }
    ((qq_ad_get.QQAdGetRsp)localObject).pos_ads_info.add(localPosAdInfo);
    localObject = GdtJsonPbUtil.a((PBField)localObject);
    if (localObject != null) {
      ((IGdtAPI)QRoute.api(IGdtAPI.class)).buildAdBox(getActivity(), localObject.toString(), "biz_src_miniapp", new GdtDemoMvFragment.2(this)).a();
    }
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "6020954314138204";
    }
    return str1;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = URLUtil.b(paramString1, "trace_id", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("encoded Url :");
    paramString2.append(paramString1);
    QLog.d("GdtDemoMvFragment", 1, paramString2.toString());
    return paramString1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtDemoMvFragment", 2, "[loadMotiveVideoAd]");
    }
    try
    {
      Object localObject = new GdtMotiveVideoParams();
      ((GdtMotiveVideoParams)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface().getCurrentAccountUin()), a());
      ((GdtMotiveVideoParams)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, getBaseActivity());
      localObject = new GdtDemoMvFragment.TestGdtAd(this, (GdtMotiveVideoParams)localObject);
      ((GdtDemoMvFragment.TestGdtAd)localObject).setListener(new WeakReference(new GdtDemoMvFragment.DemoGdtAdListener(this, getBaseActivity())));
      ((GdtDemoMvFragment.TestGdtAd)localObject).load(getBaseActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtDemoMvFragment", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.post(new GdtDemoMvFragment.3(this, paramActivity), 5, null, true);
  }
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", "2658655094");
    localBundle.putInt("uintype", 1008);
    localBundle.putString("uinname", "QQ天气");
    localIntent.putExtras(localBundle);
    localIntent.setFlags(67108864);
    localIntent.putExtra("isforceRequestDetail", false);
    localIntent.putExtra("jump_from", 4);
    paramContext.startActivity(localIntent);
  }
  
  public void a(View paramView)
  {
    if (((RadioButton)paramView).isChecked())
    {
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131375965: 
        this.jdField_e_of_type_Int = 0;
        return;
      case 2131375964: 
        this.jdField_e_of_type_Int = 1;
        return;
      }
      this.jdField_e_of_type_Int = 2;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    getBaseActivity().runOnUiThread(new GdtDemoMvFragment.4(this, paramCharSequence));
  }
  
  public void b()
  {
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setUrl("https://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c");
    localGdtVideoData.setLoop(false);
    GdtVideoCeilingData localGdtVideoCeilingData = new GdtVideoCeilingData();
    localGdtVideoCeilingData.setAd(new com.tencent.gdtad.aditem.GdtAd(a()));
    localGdtVideoCeilingData.setWebUrl("https://www.baidu.com/");
    localGdtVideoCeilingData.setVideoData(localGdtVideoData);
    localGdtVideoCeilingData.setStyle(1);
    GdtVideoCeilingFragment.a(getBaseActivity(), localGdtVideoCeilingData, null);
  }
  
  public void b(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", "{\"senderUin\":\"957048853\",\"pageUrl\":\"https:\\/\\/china.nba.com\\/?gr=www(NBA)\",\"adMsgId\":\"144115188112622096\",\"pushTime\":1593680881000,\"hasReport\":true,\"videoList\":[{\"index\":0,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/-20209911\\/e0200g1vffh.png\",\"src\":\"e0200g1vffh\"},{\"index\":1,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/17468686\\/c07114rjyet.png\",\"src\":\"c07114rjyet\"}],\"str_nick\":\" 1.跳H5_横屏_2段_banner+上滑 (自动跳转+控件隐藏  隐藏时间10秒)\",\"str_head_url\":\"https:\\/\\/sqimg.qq.com\\/qq_product_operations\\/imax\\/upload\\/avatar-1593680689236.jpg\",\"str_brief\":\" 1.跳H5_横屏_2段_banner+上滑 (自动跳转+控件隐藏  隐藏时间10秒)\",\"video_preload_state\":1,\"invalidTime\":1593767280000,\"msgTime\":0,\"shMsgSeq\":2496,\"msgUid\":144115188112622096,\"maxExposureTime\":0,\"realExposureTime\":0,\"msgCommonData\":\"{\\\"paUin\\\":\\\"957048853\\\",\\\"paName\\\":\\\" 1.跳H5_横屏_2段_banner+上滑 (自动跳转+控件隐藏  隐藏时间10秒)\\\",\\\"bannerShow\\\":true,\\\"bannertype\\\":1,\\\"jumpType\\\":2,\\\"jumpUrl\\\":\\\"https:\\\\\\/\\\\\\/china.nba.com\\\\\\/?gr=www(NBA)\\\",\\\"appId\\\":\\\"\\\",\\\"packagename\\\":\\\"\\\",\\\"androidDownloadUrl\\\":\\\"\\\",\\\"bannerImgUrl\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/banner-1593680737262.jpg\\\",\\\"bannerText\\\":\\\"测试\\\",\\\"bannerButtonText\\\":\\\"测试\\\",\\\"silentDownload\\\":false,\\\"adId\\\":\\\"6684381655727493120\\\",\\\"adPosId\\\":\\\"100001\\\",\\\"appName\\\":\\\"\\\",\\\"reportLink\\\":\\\"\\\",\\\"horizontalVideo\\\":true,\\\"audioFadeinDuration\\\":0,\\\"audioSwitchType\\\":0,\\\"preDownloadType\\\":1,\\\"str_openJumpUrlGuide\\\":\\\"\\\",\\\"str_myappDownloadUrl\\\":\\\"\\\",\\\"jumpTypeParams\\\":\\\"\\\",\\\"canScorll\\\":1,\\\"controlVariable\\\":1,\\\"uint32_control_plugin_time\\\":10,\\\"uint32_autoJump\\\":1,\\\"dDCategoryId\\\":0,\\\"dDCategoryName\\\":\\\"\\\",\\\"dDItemID\\\":0,\\\"str_clickLink\\\":\\\"\\\",\\\"uint32_monitorType\\\":1,\\\"str_share_nick\\\":\\\" 1.跳H5_横屏_2段_banner+\\\",\\\"str_share_ad_head_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/avatar-1593680559808.jpg\\\",\\\"str_share_ad_brief\\\":\\\"banner+上滑 (自动跳转+控件隐藏\\\",\\\"str_share_ad_txt\\\":\\\"(自动跳转+控件隐藏  隐藏时间10秒)\\\",\\\"str_share_ad_icon_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/avatar-1593680555967.jpg\\\",\\\"str_share_jump_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/transfer.html?_wv=7&ad_id=6684381655727493120\\\"}\"}");
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", RecentUtil.c);
    RecentUtil.c = false;
    paramActivity.startActivity(localIntent);
  }
  
  public void b(Context paramContext)
  {
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).product_type.set(46);
    qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo localWeChatAppInfo = new qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo();
    localWeChatAppInfo.pos_id.set(1L);
    localWeChatAppInfo.app_username.set("gh_09c368d75e71");
    localWeChatAppInfo.ad_trace_data.set("{\"click_id\":\"uszwth3ntripc01\"}");
    localWeChatAppInfo.app_token.set("AwLPokV6YJ5Ev1xOLsjdfhXdu27GcnGMF.za8x5lkWZ_WGiGE.Qs_RuYam4-pqDmzVR5oRlNvnXtR9zw71qMu-Ox-K_V_7Ablp58ZwFrXRB8uOt4DDnLJOIIpYS4h8cBPSYnHjz6I-j2SHINezn2sRU6quPPs7QNFf1p1iqGFgh4yjK697SpvjbAUE4m_YN2fK_99jxIvBOy8f28q9-tCmccc8pVRnheNueHW1baH5K1c0DYaL46Olqby7AzRdgaNh6hOns_M1Z1AMz9m-JKBTfmR71n7XnKqlkEWAhsMlJ6APQk1A6SX8lYg7mLQfPB27dAhAUedKRU6EHjPBT7-mABdGCwRJ7wCxSdy8w");
    paramContext = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).wechat_app_info.set(localWeChatAppInfo);
    localObject = new GdtHandler.Params();
    ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getBaseActivity());
    ((GdtHandler.Params)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramContext;
    ((GdtHandler.Params)localObject).jdField_a_of_type_Boolean = true;
    if (((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle == null) {
      ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "gdt_test");
    GdtHandler.a((GdtHandler.Params)localObject);
  }
  
  public void c(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", "{\"senderUin\":\"1245866049\",\"pageUrl\":\"\",\"adMsgId\":\"144115188117733904\",\"pushTime\":1593682321000,\"hasReport\":true,\"videoList\":[{\"index\":0,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/12879509\\/j00248up69y.png\",\"src\":\"j00248up69y\"},{\"index\":1,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/-16310573\\/t0024ue520h.png\",\"src\":\"t0024ue520h\"},{\"index\":2,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/12879509\\/j00248up69y.png\",\"src\":\"j00248up69y\"}],\"str_nick\":\"2.跳APP下载_竖屏_3段_上滑(自动跳转+控件不隐藏 )\",\"str_head_url\":\"https:\\/\\/sqimg.qq.com\\/qq_product_operations\\/imax\\/upload\\/avatar-1593681094906.jpg\",\"str_brief\":\"2.跳APP下载_竖屏_3段_上滑(自动跳转+控件不隐藏 )\",\"video_preload_state\":1,\"invalidTime\":1593768720000,\"msgTime\":0,\"shMsgSeq\":2497,\"msgUid\":144115188117733904,\"maxExposureTime\":0,\"realExposureTime\":0,\"msgCommonData\":\"{\\\"paUin\\\":\\\"1245866049\\\",\\\"paName\\\":\\\"2.跳APP下载_竖屏_3段_上滑(自动跳转+控件不隐藏 )\\\",\\\"bannerShow\\\":false,\\\"bannertype\\\":0,\\\"jumpType\\\":1,\\\"jumpUrl\\\":\\\"\\\",\\\"appId\\\":\\\"1105395880\\\",\\\"packagename\\\":\\\"com.tencent.now\\\",\\\"androidDownloadUrl\\\":\\\"\\\",\\\"bannerImgUrl\\\":\\\"\\\",\\\"bannerText\\\":\\\"\\\",\\\"bannerButtonText\\\":\\\"\\\",\\\"silentDownload\\\":false,\\\"adId\\\":\\\"6684387428762656768\\\",\\\"adPosId\\\":\\\"100001\\\",\\\"appName\\\":\\\"NOW 直播\\\",\\\"reportLink\\\":\\\"\\\",\\\"horizontalVideo\\\":false,\\\"audioFadeinDuration\\\":0,\\\"audioSwitchType\\\":0,\\\"preDownloadType\\\":1,\\\"str_openJumpUrlGuide\\\":\\\"\\\",\\\"str_myappDownloadUrl\\\":\\\"https:\\\\\\/\\\\\\/a.app.qq.com\\\\\\/o\\\\\\/simple.jsp?pkgname=com.tencent.now&ckey=CK1338999878761\\\",\\\"jumpTypeParams\\\":\\\"\\\",\\\"canScorll\\\":1,\\\"controlVariable\\\":2,\\\"uint32_control_plugin_time\\\":3,\\\"uint32_autoJump\\\":1,\\\"dDCategoryId\\\":0,\\\"dDCategoryName\\\":\\\"\\\",\\\"dDItemID\\\":0,\\\"str_clickLink\\\":\\\"\\\",\\\"uint32_monitorType\\\":1,\\\"str_share_nick\\\":\\\"2.跳APP下载_竖屏_3段_上滑(自动\\\",\\\"str_share_ad_head_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/avatar-1593681645256.jpg\\\",\\\"str_share_ad_brief\\\":\\\"_上滑(自动跳转+控件不隐藏 )\\\",\\\"str_share_ad_txt\\\":\\\"(自动跳转+控件不隐藏 )\\\",\\\"str_share_ad_icon_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/avatar-1593681649039.jpg\\\",\\\"str_share_jump_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/transfer.html?_wv=7&ad_id=6684387428762656768\\\"}\"}");
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", RecentUtil.c);
    RecentUtil.c = false;
    paramActivity.startActivity(localIntent);
  }
  
  public void d(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", "{\"senderUin\":\"3525261402\",\"pageUrl\":\"\",\"adMsgId\":\"144115188121010704\",\"pushTime\":1593682381000,\"hasReport\":true,\"videoList\":[{\"index\":0,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/12879509\\/j00248up69y.png\",\"src\":\"j00248up69y\"},{\"index\":1,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/-16310573\\/t0024ue520h.png\",\"src\":\"t0024ue520h\"},{\"index\":2,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/12879509\\/j00248up69y.png\",\"src\":\"j00248up69y\"},{\"index\":3,\"cover\":\"https:\\/\\/vpic.video.qq.com\\/-16310573\\/t0024ue520h.png\",\"src\":\"t0024ue520h\"}],\"str_nick\":\"3.跳高能舞室_竖屏_4段_banner (自动跳转+控件隐藏 不设置隐藏时间)\",\"str_head_url\":\"https:\\/\\/sqimg.qq.com\\/qq_product_operations\\/imax\\/upload\\/avatar-1593682201506.jpg\",\"str_brief\":\"3.跳高能舞室_竖屏_4段_banner (自动跳转+控件隐藏 不设置隐藏时间)\",\"video_preload_state\":1,\"invalidTime\":1593768780000,\"msgTime\":0,\"shMsgSeq\":2498,\"msgUid\":144115188121010704,\"maxExposureTime\":0,\"realExposureTime\":0,\"msgCommonData\":\"{\\\"paUin\\\":\\\"3525261402\\\",\\\"paName\\\":\\\"3.跳高能舞室_竖屏_4段_banner (自动跳转+控件隐藏 不设置隐藏时间)\\\",\\\"bannerShow\\\":true,\\\"bannertype\\\":1,\\\"jumpType\\\":5,\\\"jumpUrl\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/loading-page\\\\\\/loadingqq.html#params=%7B%22class_id%22%3A%2210%22%2C%22pendant_id%22%3A%22405%22%2C%22class_name%22%3A%22%E9%AB%98%E8%83%BD%E8%88%9E%E5%AE%A4%22%7D\\\",\\\"appId\\\":\\\"\\\",\\\"packagename\\\":\\\"\\\",\\\"androidDownloadUrl\\\":\\\"\\\",\\\"bannerImgUrl\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/banner-1593682241734.jpg\\\",\\\"bannerText\\\":\\\"测试\\\",\\\"bannerButtonText\\\":\\\"测试\\\",\\\"silentDownload\\\":false,\\\"adId\\\":\\\"6684388132880130048\\\",\\\"adPosId\\\":\\\"100001\\\",\\\"appName\\\":\\\"\\\",\\\"reportLink\\\":\\\"\\\",\\\"horizontalVideo\\\":false,\\\"audioFadeinDuration\\\":0,\\\"audioSwitchType\\\":0,\\\"preDownloadType\\\":1,\\\"str_openJumpUrlGuide\\\":\\\"\\\",\\\"str_myappDownloadUrl\\\":\\\"\\\",\\\"jumpTypeParams\\\":\\\"{\\\\\\\"class_id\\\\\\\":\\\\\\\"10\\\\\\\",\\\\\\\"pendant_id\\\\\\\":\\\\\\\"405\\\\\\\",\\\\\\\"class_name\\\\\\\":\\\\\\\"高能舞室\\\\\\\"}\\\",\\\"canScorll\\\":0,\\\"controlVariable\\\":1,\\\"uint32_control_plugin_time\\\":3,\\\"uint32_autoJump\\\":1,\\\"dDCategoryId\\\":10,\\\"dDCategoryName\\\":\\\"高能舞室\\\",\\\"dDItemID\\\":405,\\\"str_clickLink\\\":\\\"\\\",\\\"uint32_monitorType\\\":1,\\\"str_share_nick\\\":\\\"3.跳高能舞室_竖屏_4段_banner\\\",\\\"str_share_ad_head_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/avatar-1593682179282.jpg\\\",\\\"str_share_ad_brief\\\":\\\"anner (自动跳转+控件隐藏 不设置\\\",\\\"str_share_ad_txt\\\":\\\" (自动跳转+控件隐藏 不设置隐藏时间)\\\",\\\"str_share_ad_icon_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/upload\\\\\\/avatar-1593682183405.jpg\\\",\\\"str_share_jump_url\\\":\\\"https:\\\\\\/\\\\\\/sqimg.qq.com\\\\\\/qq_product_operations\\\\\\/imax\\\\\\/transfer.html?_wv=7&ad_id=6684388132880130048\\\"}\"}");
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", RecentUtil.c);
    RecentUtil.c = false;
    paramActivity.startActivity(localIntent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt2 == -1) && (paramInt1 == 101))
    {
      Object localObject = paramIntent.getExtras();
      if (localObject == null)
      {
        GdtLog.d("GdtDemoMvFragment", "onActivityResult b==null ");
        return;
      }
      long l1 = ((Bundle)localObject).getLong("duration_time");
      long l2 = ((Bundle)localObject).getLong("elapsed_time");
      boolean bool = ((Bundle)localObject).getBoolean("profitable_flag", false);
      localObject = getBaseActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(bool);
      localStringBuilder.append(" elaspedTime/duration ");
      localStringBuilder.append(l2);
      localStringBuilder.append("/");
      localStringBuilder.append(l1);
      Toast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 600L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      Object localObject2;
      Object localObject3;
      switch (i)
      {
      default: 
        break;
      case 2131381048: 
        try
        {
          Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            long l = Long.parseLong((String)localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=1&referer=2066&_sig=da2a4472ac1a98a2d4f5cc0d86428bc1fc05b69a936b919303c45fcd37947008&areaId=");
            ((StringBuilder)localObject1).append(l);
            localObject1 = ((StringBuilder)localObject1).toString();
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getBaseActivity(), (String)localObject1, 2066, null);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      case 2131378510: 
        localObject2 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2));
        }
        break;
      case 2131378488: 
        localObject2 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 0, true);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2));
        }
        break;
      case 2131378466: 
        localObject2 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject2 != null)
        {
          ((GdtMotiveVideoPageData)localObject2).containerType = 1;
          localObject3 = new GdtDemoMvFragment.1(this, new Handler(Looper.getMainLooper()));
          a((GdtMotiveVideoPageData)localObject2, i);
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2, (ResultReceiver)localObject3));
        }
        break;
      case 2131378465: 
        localObject2 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 8, false);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2));
        }
        break;
      case 2131378464: 
        localObject2 = a(585, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2));
        }
        break;
      case 2131378463: 
        localObject2 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 0, false);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2));
        }
        break;
      case 2131378461: 
        localObject2 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.b(getBaseActivity(), (GdtMotiveVideoPageData)localObject2, null));
        }
        break;
      case 2131378460: 
        a();
        break;
      case 2131378457: 
        b(getBaseActivity());
        break;
      case 2131378456: 
        d(getBaseActivity());
        break;
      case 2131378455: 
        b(getBaseActivity());
        break;
      case 2131378454: 
        c(getBaseActivity());
        break;
      case 2131378453: 
        a(getBaseActivity());
        break;
      case 2131375963: 
      case 2131375964: 
      case 2131375965: 
        a(paramView);
        break;
      case 2131371519: 
        localObject2 = a(65, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          ((GdtMotiveVideoPageData)localObject2).containerType = 1;
          a((GdtMotiveVideoPageData)localObject2, "https://h5.gdt.qq.com/xjviewer/nemo/1001751?_wv=1&gdt_ad_id=945580&aidx=50726321&gdt_product_id=1101072624&gdt_media_id=60005012352827&gdt_subordinate_product_id=&via=YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE.yez3lkudc7rhk01NETLOGvdyib4p5ctmuq&versionCode=2987&packageName=com.achievo.vipshop&qz_gdt=yez3lkudc7rhk01&no_yyb=1&clklpp=__CLICK_LPP__&ist=1&click_ext=eyJleHBfcGFyYW0iOiJhbmltYXRpb246Ym91bmNlIiwic2NlbmNlc190eXBlIjoxfQ==");
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2));
        }
        break;
      case 2131371518: 
        localObject2 = a(65, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i);
          a((GdtMotiveVideoPageData)localObject2, "https://h5.gdt.qq.com/xjviewer/nemo/1001751?_wv=1&gdt_ad_id=945580&aidx=50726321&gdt_product_id=1101072624&gdt_media_id=60005012352827&gdt_subordinate_product_id=&via=YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE.yez3lkudc7rhk01NETLOGvdyib4p5ctmuq&versionCode=2987&packageName=com.achievo.vipshop&qz_gdt=yez3lkudc7rhk01&no_yyb=1&clklpp=__CLICK_LPP__&ist=1&click_ext=eyJleHBfcGFyYW0iOiJhbmltYXRpb246Ym91bmNlIiwic2NlbmNlc190eXBlIjoxfQ==");
          ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(getBaseActivity(), (GdtMotiveVideoPageData)localObject2));
        }
        break;
      case 2131364079: 
        AdSettings.setTestMode(AdSettings.isTestMode() ^ true);
        localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
        if (AdSettings.isTestMode()) {
          i = 2131692855;
        } else {
          i = 2131692854;
        }
        ((Button)localObject2).setText(i);
        break;
      case 2131364024: 
        localObject2 = this.jdField_a_of_type_ComTencentGdtadApiGdtAd;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.gdtad.api.GdtAd)localObject2).getAd();
          if (localObject2 != null)
          {
            localObject3 = new Intent();
            GdtImaxData localGdtImaxData = new GdtImaxData();
            localGdtImaxData.setAd((com.tencent.gdtad.aditem.GdtAd)localObject2);
            GdtVideoData localGdtVideoData = new GdtVideoData();
            localGdtVideoData.setUrl(((com.tencent.gdtad.aditem.GdtAd)localObject2).getVideoUrl());
            localGdtVideoData.setStartPositionMillis(0L);
            localGdtVideoData.setLoop(true);
            localGdtVideoData.setDirectPlay(true);
            localGdtVideoData.setAd((Ad)localObject2);
            localGdtVideoData.setVideoDefaultBackgroundColor(0);
            localGdtVideoData.setForceNotShowControllerView(true);
            localGdtVideoData.setCoverUrl(((com.tencent.gdtad.aditem.GdtAd)localObject2).info.display_info.basic_info.img.get());
            localGdtImaxData.setVideoData(localGdtVideoData);
            localGdtImaxData.setWebUrl(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForLandingPage());
            ((Intent)localObject3).putExtra("data", localGdtImaxData);
            PublicFragmentActivity.Launcher.a(getBaseActivity(), (Intent)localObject3, PublicFragmentActivityForQzone.class, GdtMotiveVideoMockQzoneImaxFeedsFragment.class, 1);
          }
        }
        break;
      case 2131363842: 
        c();
        break;
      case 2131362155: 
        b();
        break;
      case 2131362110: 
        a(getBaseActivity());
        break;
      case 2131362080: 
        GdtC2SReporter.a(1, 1, a());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559192, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131363842).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131364024).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378460).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378461).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378463).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378464).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378465).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378466).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378510).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378488).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362080).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362155).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131381048).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362110).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371518).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371519).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378457).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378453).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378455).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378454).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131378456).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131375965).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131375964).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131375963).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131366319));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131366312));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131366330));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364385));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364383));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364380));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364381));
    this.jdField_e_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364384));
    this.f = ((CheckBox)paramLayoutInflater.findViewById(2131364378));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131364079));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    AdSettings.setTestMode(true);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment
 * JD-Core Version:    0.7.0.1
 */