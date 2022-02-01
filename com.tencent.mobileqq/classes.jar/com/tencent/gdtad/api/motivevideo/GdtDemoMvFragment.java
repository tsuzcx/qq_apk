package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdSettings;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.adbox.GdtAdBox;
import com.tencent.gdtad.api.adbox.GdtAdBoxBuilder;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForQzone;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.MessageMicro;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.URLUtil;
import java.io.Serializable;
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
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private com.tencent.gdtad.api.GdtAd jdField_a_of_type_ComTencentGdtadApiGdtAd;
  CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  CheckBox d;
  CheckBox e;
  CheckBox f;
  
  public static GdtHandler.Params a(boolean paramBoolean, Activity paramActivity)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.c = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_Boolean = paramBoolean;
    return localParams;
  }
  
  private GdtMotiveVideoPageData a(int paramInt1, com.tencent.gdtad.api.GdtAd paramGdtAd, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = null;
    QLog.i("GdtDemoMvFragment", 1, "mockMVPageData createSize " + paramInt1 + " portrait " + paramInt2 + " useRealData " + paramBoolean);
    if ((paramGdtAd == null) || (!paramGdtAd.isLoaded()) || (paramGdtAd.isInvalidated()) || (!(paramGdtAd instanceof com.tencent.gdtad.api.GdtAd)))
    {
      QLog.i("GdtDemoMvFragment", 1, String.format("mockMVPageData null %d", new Object[] { Integer.valueOf(paramInt1) }) + paramInt2);
      QQToast.a(getActivity(), HardCodeUtil.a(2131705194), 0).a();
      return null;
    }
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
      GdtLog.d("GdtDemoMvFragment", "VideoUrl " + localGdtMotiveVideoPageData.url);
      Object localObject1;
      if (localGdtAd.getImageData() == null)
      {
        localObject1 = "";
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
        if (paramGdtAd != null) {
          break label502;
        }
      }
      label502:
      for (paramGdtAd = "";; paramGdtAd = paramGdtAd.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramGdtAd;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        return localGdtMotiveVideoPageData;
        localObject1 = localGdtAd.getImageData().a;
        break;
      }
    }
    return null;
  }
  
  private String a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    paramAdInfo = GdtJsonPbUtil.a(paramAdInfo);
    if ((paramAdInfo == null) || (JSONObject.NULL.equals(paramAdInfo))) {
      return "";
    }
    return paramAdInfo.toString();
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
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt)
  {
    try
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramGdtMotiveVideoPageData.setVideoCountDown(Integer.parseInt((String)localObject));
      }
      paramGdtMotiveVideoPageData.setRewardText(this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        paramGdtMotiveVideoPageData.adsContent = paramGdtMotiveVideoPageData.adsContent.replace("\"video_volume\":1", "\"video_volume\":0");
      }
      if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {
        paramGdtMotiveVideoPageData.adsContent = paramGdtMotiveVideoPageData.adsContent.replace("video_volume", "video_volume_error");
      }
      if (this.jdField_c_of_type_AndroidWidgetCheckBox.isChecked()) {
        paramGdtMotiveVideoPageData.endcardUrl = URLUtil.b("https://test-h5.gdt.qq.com/union/res/union_site/page/xqMiniGameVideoEndCard/xqMiniGameVideoEndCard.html?debug=mock", "trace_id", new GdtMotiveVideoModel(paramGdtMotiveVideoPageData).a().getTraceId());
      }
      if (this.d.isChecked()) {
        paramGdtMotiveVideoPageData.endcardUrl = URLUtil.b("https://h5.gdt.qq.com/xjviewer/nemo/1001751?_wv=1&gdt_ad_id=945580&aidx=50726321&gdt_product_id=1101072624&gdt_media_id=60005012352827&gdt_subordinate_product_id=&via=YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE.yez3lkudc7rhk01NETLOGvdyib4p5ctmuq&versionCode=2987&packageName=com.achievo.vipshop&qz_gdt=yez3lkudc7rhk01&no_yyb=1&clklpp=__CLICK_LPP__&ist=1&click_ext=eyJkaWQiOiJiZWY3ZDBmMTI5MThlZGNhM2IxMzYwMGIyMWJkZjY1MCIsIm9zX3R5cGUiOjEsInNka19kb3dubG9hZCI6MSwic2hvcnRfcG9zX2lkIjozMDA2NDZ9&_wwv=4&xj_scene=5", "trace_id", new GdtMotiveVideoModel(paramGdtMotiveVideoPageData).a().getTraceId());
      }
      if (this.e.isChecked()) {}
      try
      {
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent)));
        if (!localAdInfo.exp_info.has()) {
          break label323;
        }
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localAdInfo.exp_info.get();
        ((qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo)localObject).video_countdown_style.set(1);
        paramGdtMotiveVideoPageData.adsContent = a(localAdInfo);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo localExpInfo;
          GdtLog.d("GdtDemoMvFragment", "setPageDataUIParams", localThrowable);
        }
      }
      if (this.f.isChecked()) {
        paramGdtMotiveVideoPageData.bottomCardUrl = a("https://test-h5.gdt.qq.com//union/res/union_site/page/xqMiniGameVideoPlay/xqMiniGameVideoPlay.html", new GdtMotiveVideoModel(paramGdtMotiveVideoPageData).a().getTraceId());
      }
      if ((paramInt != 2131379118) && (paramInt != 2131379141)) {
        paramGdtMotiveVideoPageData.url = "https://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c";
      }
      paramGdtMotiveVideoPageData.antiSpamParams = "{\"lt\":2,\"ig\":0}";
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        label323:
        localExpInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo();
      }
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString)
  {
    try
    {
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent)));
      if (localAdInfo.dest_info.has()) {}
      for (qq_ad_get.QQAdGetRsp.AdInfo.DestInfo localDestInfo = (qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localAdInfo.dest_info.get();; localDestInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo())
      {
        localDestInfo.dest_type.set(1);
        localDestInfo.landing_page.set(paramString);
        localAdInfo.dest_info.set(localDestInfo);
        paramGdtMotiveVideoPageData.adsContent = a(localAdInfo);
        return;
      }
      return;
    }
    catch (Throwable paramGdtMotiveVideoPageData)
    {
      GdtLog.d("GdtDemoMvFragment", "mockToCellingStyle", paramGdtMotiveVideoPageData);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramGdtMotiveVideoPageData.url = "https://adsmind.gdtimg.com/ads_svp_video__0b6b4qabeaaaceagicvg2npbvzaeclsaaesa.f40.mp4?dis_k=9ab17271945d93f487be29dbad0f74b9&dis_t=1587967852";
    }
    try
    {
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent)));
      Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.Ext();
      ArrayList localArrayList = new ArrayList();
      qq_ad_get.QQAdGetRsp.AdInfo.ExpParam localExpParam = new qq_ad_get.QQAdGetRsp.AdInfo.ExpParam();
      localExpParam.key.set(100329);
      localExpParam.value.set("1");
      localArrayList.add(localExpParam);
      ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).exp_map.set(localArrayList);
      localAdInfo.ext.set((MessageMicro)localObject);
      if (localAdInfo.dest_info.has()) {}
      for (localObject = (qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localAdInfo.dest_info.get();; localObject = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo())
      {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject).dest_type.set(1);
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject).landing_page.set("https://h5.gdt.qq.com/xjviewer/nemo/1001751?_wv=1&gdt_ad_id=945580&aidx=50726321&gdt_product_id=1101072624&gdt_media_id=60005012352827&gdt_subordinate_product_id=&via=YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE.yez3lkudc7rhk01NETLOGvdyib4p5ctmuq&versionCode=2987&packageName=com.achievo.vipshop&qz_gdt=yez3lkudc7rhk01&no_yyb=1&clklpp=__CLICK_LPP__&ist=1&click_ext=eyJkaWQiOiJiZWY3ZDBmMTI5MThlZGNhM2IxMzYwMGIyMWJkZjY1MCIsIm9zX3R5cGUiOjEsInNka19kb3dubG9hZCI6MSwic2hvcnRfcG9zX2lkIjozMDA2NDZ9&_wwv=4");
        localAdInfo.dest_info.set((MessageMicro)localObject);
        paramGdtMotiveVideoPageData.adsContent = a(localAdInfo);
        return;
        paramGdtMotiveVideoPageData.url = "https://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c";
        break;
      }
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
    ArrayList localArrayList = new ArrayList();
    int j = jdField_a_of_type_Int;
    jdField_a_of_type_Int = j + 1;
    int i = 0;
    while (i < j % 10)
    {
      localArrayList.add(this.jdField_a_of_type_ComTencentGdtadApiGdtAd.getAd());
      i += 1;
    }
    GdtAdBox.a(getActivity()).a(new GdtAdBoxData(localArrayList)).a(new GdtDemoMvFragment.2(this)).a().a();
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
    QLog.d("GdtDemoMvFragment", 1, "encoded Url :" + paramString1);
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
      ((GdtMotiveVideoParams)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(CmGameUtil.a().getCurrentAccountUin()), a());
      ((GdtMotiveVideoParams)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, getActivity());
      localObject = new GdtDemoMvFragment.TestGdtAd(this, (GdtMotiveVideoParams)localObject);
      ((GdtDemoMvFragment.TestGdtAd)localObject).setListener(new WeakReference(new GdtDemoMvFragment.DemoGdtAdListener(this, getActivity())));
      ((GdtDemoMvFragment.TestGdtAd)localObject).load(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtDemoMvFragment", 1, localThrowable, new Object[0]);
    }
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
    GdtBaseVideoCeilingFragment.a(getActivity(), GdtVideoCeilingFragmentForJS.class, localGdtVideoCeilingData);
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
    ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
    ((GdtHandler.Params)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramContext;
    ((GdtHandler.Params)localObject).jdField_a_of_type_Boolean = true;
    if (((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle == null) {
      ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "gdt_test");
    GdtHandler.a((GdtHandler.Params)localObject);
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
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle == null)
      {
        GdtLog.d("GdtDemoMvFragment", "onActivityResult b==null ");
        return;
      }
      long l1 = localBundle.getLong("duration_time");
      long l2 = localBundle.getLong("elapsed_time");
      boolean bool = localBundle.getBoolean("profitable_flag", false);
      Toast.makeText(getActivity(), bool + " elaspedTime/duration " + l2 + "/" + l1, 0).show();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i = paramView.getId();
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 600L) {}
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1;
      Object localObject3;
      Object localObject4;
      switch (i)
      {
      default: 
        break;
      case 2131362054: 
        GdtC2SReporter.a(1, 1, a());
        break;
      case 2131379091: 
        a();
        break;
      case 2131363914: 
        c();
        break;
      case 2131379092: 
        localObject1 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131364058: 
        localObject1 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          a((GdtMotiveVideoPageData)localObject1, false);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131364059: 
        localObject1 = a(585, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject1 != null)
        {
          ((GdtMotiveVideoPageData)localObject1).containerType = 1;
          a((GdtMotiveVideoPageData)localObject1, i);
          a((GdtMotiveVideoPageData)localObject1, true);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131371897: 
        localObject3 = a(65, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject3 != null)
        {
          a((GdtMotiveVideoPageData)localObject3, i);
          localObject4 = new Bundle();
          ((Bundle)localObject4).putSerializable("data", (Serializable)localObject3);
          ((Bundle)localObject4).putString("big_brother_ref_source_key", ((GdtMotiveVideoPageData)localObject3).refId);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
          ((Intent)localObject1).putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
          ((Intent)localObject1).putExtras((Bundle)localObject4);
          if (TextUtils.isEmpty(((Intent)localObject1).getStringExtra("big_brother_ref_source_key"))) {
            GdtLog.d("GdtDemoMvFragment", "start gdt empty refId");
          }
          localObject3 = new GdtMotiveVideoModel((GdtMotiveVideoPageData)localObject3);
          ((Intent)localObject1).setClass(getActivity(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("fragment_class", GdtMotiveBrowsingFragment.class.getCanonicalName());
          ((Intent)localObject1).putExtra("url", "https://h5.gdt.qq.com/xjviewer/nemo/1001751?_wv=1&gdt_ad_id=945580&aidx=50726321&gdt_product_id=1101072624&gdt_media_id=60005012352827&gdt_subordinate_product_id=&via=YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE.yez3lkudc7rhk01NETLOGvdyib4p5ctmuq&versionCode=2987&packageName=com.achievo.vipshop&qz_gdt=yez3lkudc7rhk01&no_yyb=1&clklpp=__CLICK_LPP__&ist=1&click_ext=eyJleHBfcGFyYW0iOiJhbmltYXRpb246Ym91bmNlIiwic2NlbmNlc190eXBlIjoxfQ==");
          ((Intent)localObject1).putExtra("isTransparentTitle", true);
          ((Intent)localObject1).putExtra("GdtWebReportQQ_TRACE_ID", ((GdtMotiveVideoModel)localObject3).a().getTraceId());
          ((Intent)localObject1).putExtra("GdtWebReportQQ_ACTION_URL", ((GdtMotiveVideoModel)localObject3).a().getUrlForAction());
          getActivity().startActivity((Intent)localObject1);
        }
        break;
      case 2131371898: 
        localObject1 = a(65, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          ((GdtMotiveVideoPageData)localObject1).containerType = 1;
          a((GdtMotiveVideoPageData)localObject1, "https://h5.gdt.qq.com/xjviewer/nemo/1001751?_wv=1&gdt_ad_id=945580&aidx=50726321&gdt_product_id=1101072624&gdt_media_id=60005012352827&gdt_subordinate_product_id=&via=YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE.yez3lkudc7rhk01NETLOGvdyib4p5ctmuq&versionCode=2987&packageName=com.achievo.vipshop&qz_gdt=yez3lkudc7rhk01&no_yyb=1&clklpp=__CLICK_LPP__&ist=1&click_ext=eyJleHBfcGFyYW0iOiJhbmltYXRpb246Ym91bmNlIiwic2NlbmNlc190eXBlIjoxfQ==");
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131379088: 
        b(getActivity());
        break;
      case 2131379094: 
        localObject1 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 0, false);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131379096: 
        localObject1 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 8, false);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131379095: 
        localObject1 = a(585, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131379097: 
        localObject1 = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
        if (localObject1 != null)
        {
          ((GdtMotiveVideoPageData)localObject1).containerType = 1;
          localObject3 = new GdtDemoMvFragment.1(this, new Handler(Looper.getMainLooper()));
          a((GdtMotiveVideoPageData)localObject1, i);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1, (ResultReceiver)localObject3);
        }
        break;
      case 2131379141: 
        localObject1 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131379118: 
        localObject1 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 0, true);
        if (localObject1 != null)
        {
          a((GdtMotiveVideoPageData)localObject1, i);
          GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        }
        break;
      case 2131362082: 
        a(getActivity());
        break;
      case 2131362125: 
        b();
        break;
      case 2131381831: 
        try
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            long l = Long.parseLong((String)localObject1);
            localObject1 = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=1&referer=2066&_sig=da2a4472ac1a98a2d4f5cc0d86428bc1fc05b69a936b919303c45fcd37947008&areaId=" + l;
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getActivity(), (String)localObject1, 2066, null);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        break;
      case 2131364102: 
        if (this.jdField_a_of_type_ComTencentGdtadApiGdtAd != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentGdtadApiGdtAd.getAd();
          if (localObject2 != null)
          {
            localObject3 = new Intent();
            localObject4 = new GdtImaxData();
            ((GdtImaxData)localObject4).setAd((com.tencent.gdtad.aditem.GdtAd)localObject2);
            GdtVideoData localGdtVideoData = new GdtVideoData();
            localGdtVideoData.setUrl(((com.tencent.gdtad.aditem.GdtAd)localObject2).getVideoUrl());
            localGdtVideoData.setStartPositionMillis(0L);
            localGdtVideoData.setLoop(true);
            localGdtVideoData.setDirectPlay(true);
            localGdtVideoData.setAd((Ad)localObject2);
            localGdtVideoData.setVideoDefaultBackgroundColor(0);
            localGdtVideoData.setForceNotShowControllerView(true);
            localGdtVideoData.setCoverUrl(((com.tencent.gdtad.aditem.GdtAd)localObject2).info.display_info.basic_info.img.get());
            ((GdtImaxData)localObject4).setVideoData(localGdtVideoData);
            ((GdtImaxData)localObject4).setWebUrl(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForLandingPage());
            ((Intent)localObject3).putExtra("data", (Serializable)localObject4);
            PublicFragmentActivity.Launcher.a(getActivity(), (Intent)localObject3, PublicFragmentActivityForQzone.class, GdtMotiveVideoMockQzoneImaxFeedsFragment.class, 1);
          }
        }
        break;
      }
    }
    if (!AdSettings.isTestMode())
    {
      label1234:
      AdSettings.setTestMode(bool);
      localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
      if (!AdSettings.isTestMode()) {
        break label1268;
      }
    }
    label1268:
    for (i = 2131692899;; i = 2131692898)
    {
      ((Button)localObject2).setText(i);
      break;
      bool = false;
      break label1234;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559315, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131363914).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131364102).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379091).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379092).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379094).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379095).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379096).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379097).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379141).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379118).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362054).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362125).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131381831).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362082).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131364058).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131364059).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371897).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371898).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379088).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131366438));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131366431));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131366450));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364495));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364492));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)paramLayoutInflater.findViewById(2131364489));
    this.d = ((CheckBox)paramLayoutInflater.findViewById(2131364490));
    this.e = ((CheckBox)paramLayoutInflater.findViewById(2131364493));
    this.f = ((CheckBox)paramLayoutInflater.findViewById(2131364494));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131364158));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    AdSettings.setTestMode(true);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment
 * JD-Core Version:    0.7.0.1
 */