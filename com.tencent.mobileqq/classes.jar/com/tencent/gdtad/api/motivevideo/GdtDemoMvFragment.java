package com.tencent.gdtad.api.motivevideo;

import abju;
import aing;
import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import bbmy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.jsbridge.GdtCanvasFragment4CmGame;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivityForQzone;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;
import yjm;
import yjo;
import yjp;
import yjs;
import yjt;
import ykd;
import yke;
import yle;
import ylf;
import ylr;
import ynv;
import yny;
import yof;

public class GdtDemoMvFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 15L;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private com.tencent.gdtad.api.GdtAd jdField_a_of_type_ComTencentGdtadApiGdtAd;
  private long b;
  
  private GdtMotiveVideoPageData a(int paramInt1, com.tencent.gdtad.api.GdtAd paramGdtAd, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = null;
    QLog.i("GdtMotiveVideoAd", 1, "mockMVPageData createSize " + paramInt1 + " portrait " + paramInt2 + " useRealData " + paramBoolean);
    if ((paramGdtAd == null) || (!paramGdtAd.isLoaded()) || (paramGdtAd.isInvalidated()) || (!(paramGdtAd instanceof GdtMotiveVideoAd)))
    {
      QLog.i("GdtMotiveVideoAd", 1, String.format("mockMVPageData null %d", new Object[] { Integer.valueOf(paramInt1) }) + paramInt2);
      bbmy.a(getActivity(), ajjy.a(2131639381), 0).a();
      return null;
    }
    Object localObject2 = (GdtMotiveVideoAd)paramGdtAd;
    com.tencent.gdtad.aditem.GdtAd localGdtAd = ((GdtMotiveVideoAd)localObject2).getAd();
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
      yny.d("GdtMotiveVideoAd", "VideoUrl " + localGdtMotiveVideoPageData.url);
      if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
        localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
      }
      if (localGdtAd.getImageData() == null)
      {
        paramGdtAd = "";
        localGdtMotiveVideoPageData.previewImgUrl = paramGdtAd;
        localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
        localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
        localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
        localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
        localGdtMotiveVideoPageData.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
        localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
        localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
        localObject2 = ((GdtMotiveVideoAd)localObject2).getGdtAdLoader();
        paramGdtAd = localObject1;
        if (localObject2 != null)
        {
          paramGdtAd = localObject1;
          if (((yjm)localObject2).a() != null)
          {
            paramGdtAd = localObject1;
            if (((yjm)localObject2).a().a != null) {
              paramGdtAd = ynv.a((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)((yjm)localObject2).a().a.pos_ads_info.get(0)).ads_info.get(0));
            }
          }
        }
        if (paramGdtAd != null) {
          break label491;
        }
      }
      label491:
      for (paramGdtAd = "";; paramGdtAd = paramGdtAd.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramGdtAd;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        return localGdtMotiveVideoPageData;
        paramGdtAd = localGdtAd.getImageData().a;
        break;
      }
    }
    return null;
  }
  
  public static qq_ad_get.QQAdGet a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    Object localObject1 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_rate.set(paramInt2);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_check.set(yjp.a(paramLong2, paramLong3, paramInt2));
    Object localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info.set((MessageMicro)localObject1);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(1);
    localObject1 = new qq_ad_get.QQAdGet.PositionInfo();
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_id.set(paramString);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).ad_count.set(1);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_ext.set((MessageMicro)localObject2);
    paramString = new qq_ad_get.QQAdGet.ContextInfo();
    paramString.public_id.set(paramLong2);
    paramString.article_id.set(paramLong3);
    paramString.source_from.set(paramInt1);
    localObject2 = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(paramLong1);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add((MessageMicro)localObject1);
    localQQAdGet.context_info.set(paramString);
    localQQAdGet.user_info.set((MessageMicro)localObject2);
    return localQQAdGet;
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo a()
  {
    Object localObject1 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
    if (localObject1 != null) {
      try
      {
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(((GdtMotiveVideoPageData)localObject1).adsContent)));
        Object localObject2 = this.jdField_a_of_type_ComTencentGdtadApiGdtAd.getAd();
        if ((localObject2 != null) && (localObject1 != null))
        {
          ArrayList localArrayList1 = new ArrayList();
          localArrayList1.add(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForClick());
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForImpression());
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add("http://tytx.m.cn.miaozhen.com/x/k=2137392&p=7Sm5F&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&tr=__REQUESTID__&mo=__OS__&m0=__OPENUDID__&m0a=__DUID__&m1=__ANDROIDID1__&m1a=__ANDROIDID__&m2=__IMEI__&m4=__AAID__&m5=__IDFA__&m6=__MAC1__&m6a=__MAC__&m11=__OAID__&txp=__TXP__&o=");
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
  
  public static yjs a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Activity paramActivity)
  {
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = paramGdtMotiveVideoPageData.processId;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    if (paramAdInfo != null) {
      localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new com.tencent.gdtad.aditem.GdtAd(paramAdInfo);
    }
    localyjs.jdField_a_of_type_Boolean = true;
    localyjs.jdField_b_of_type_Boolean = true;
    localyjs.jdField_a_of_type_JavaLangClass = null;
    localyjs.jdField_b_of_type_JavaLangClass = GdtCanvasFragment4CmGame.class;
    localyjs.jdField_a_of_type_AndroidOsBundle = new Bundle();
    paramGdtMotiveVideoPageData = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
    paramAdInfo = paramGdtMotiveVideoPageData;
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData))
    {
      QLog.i("GdtMotiveVideoAd", 1, "getClickParam refId is empty");
      paramAdInfo = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    }
    if (!TextUtils.isEmpty(paramAdInfo)) {
      localyjs.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramAdInfo);
    }
    return localyjs;
  }
  
  public static yjs a(boolean paramBoolean, Activity paramActivity)
  {
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = 1;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localyjs.jdField_a_of_type_Boolean = paramBoolean;
    return localyjs;
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      paramGdtMotiveVideoPageData.setVideoCountDown(paramInt1);
    }
  }
  
  private void b()
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
    ykd.a(getActivity()).a(new GdtAdBoxData(localArrayList)).a(new yle(this)).a().a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveVideoAd", 2, "[loadMotiveVideoAd]");
    }
    try
    {
      Object localObject = new ylr();
      ((ylr)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(aing.a().getCurrentAccountUin()), "3050948280108638", 3503183690L, 2011L, 208, 75);
      ((ylr)localObject).jdField_a_of_type_Yjs = a(true, getActivity());
      localObject = new GdtMotiveVideoAd((ylr)localObject);
      ((GdtMotiveVideoAd)localObject).setListener(new WeakReference(new ylf(this, getActivity())));
      ((GdtMotiveVideoAd)localObject).load(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtMotiveVideoAd", 1, localThrowable, new Object[0]);
    }
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
        yny.d("GdtMotiveVideoAd", "onActivityResult b==null ");
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
    int j = paramView.getId();
    if (SystemClock.uptimeMillis() - this.b < 600L) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          int i;
          try
          {
            paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            if (!TextUtils.isEmpty(paramView))
            {
              i = Integer.parseInt(paramView);
              this.b = SystemClock.uptimeMillis();
              switch (j)
              {
              default: 
                return;
              case 2131296425: 
                yof.a(1, 1, a());
                return;
              }
            }
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
              i = 0;
            }
            a();
            return;
          }
          b();
          return;
          paramView = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
          if (paramView != null)
          {
            a(paramView, i, -1);
            paramView.url = "http://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c";
            GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, paramView);
            return;
            paramView = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 0, false);
            if (paramView != null)
            {
              a(paramView, i, -1);
              paramView.url = "http://adsmind.apdcdn.tc.qq.com/vcloud.tc.qq.com/1050_000001004y2sk0zk0k00st9pojifv3rl.f32.mp4?vkey=6C7D1F5EF7D2D51C89580BA6DC924507BB741055A42116515BBB04E87D347AA30C4318F43ECFC6EA61C1BE66102F19F8821394588EC15EF9956B7DE79BF5E6C8C9E1F69AB1585D0DE547A44F554791AE81C1CFE023F7757F";
              GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, paramView);
              return;
              paramView = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 8, false);
              if (paramView != null)
              {
                a(paramView, i, -1);
                paramView.url = "http://adsmind.tc.qq.com/vcloud.tc.qq.com/1050_000001004vj2x0zk0k002bypexipm58g.f32.mp4?vkey=6764FB31E38EDE078A3BF8D07D7CE93EAF20A188675F62AC6BAD9E785AA3E5A029FBE7819922D4859A87BD5BE1BE90BB3C8F12B7BA3481BB0FB88A9BB9E3EF39D56C8B7201F6C189DF10BD6F502280468DE9F9E791A323DE";
                GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, paramView);
                return;
                paramView = a(585, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
                if (paramView != null)
                {
                  a(paramView, i, -1);
                  paramView.url = "http://adsmind.tc.qq.com/vcloud.tc.qq.com/1050_0000010001p1e0k00zk03ydpd32lm4rt.f20.mp4?vkey=0BA8604245D02BDE0CCBF1696E48A039A3F152B5C2D114AF7990C4043EA438218B0E693D2F7E005B38EC42CD36CF598352A6E88B3B16768D44C799AB256B9A84C6A8E4D40B5AB22F52691FAA957D4BCFC884DCA3EC432D99";
                  GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, paramView);
                  return;
                  paramView = a(185, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, false);
                  if (paramView != null)
                  {
                    paramView.containerType = 1;
                    paramView.resultReceiver = new GdtDemoMvFragment.1(this, new Handler(Looper.getMainLooper()));
                    a(paramView, i, -1);
                    paramView.url = "http://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c";
                    GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, paramView);
                    return;
                    paramView = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
                    if (paramView != null)
                    {
                      a(paramView, i, -1);
                      GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, paramView);
                      return;
                      paramView = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 0, true);
                      if (paramView != null)
                      {
                        a(paramView, i, -1);
                        GdtMotiveVideoFragment.a(getActivity(), GdtMotiveVideoFragment.class, paramView);
                        return;
                        yof.a(0, 0, a());
                        return;
                        yof.a(2, 1, a());
                        return;
                        try
                        {
                          paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
                          if (!TextUtils.isEmpty(paramView))
                          {
                            long l = Long.parseLong(paramView);
                            paramView = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=1&referer=2066&_sig=da2a4472ac1a98a2d4f5cc0d86428bc1fc05b69a936b919303c45fcd37947008&areaId=" + l;
                            MiniAppLauncher.startMiniApp(getActivity(), paramView, 2066, null);
                            return;
                          }
                        }
                        catch (Exception paramView)
                        {
                          paramView.printStackTrace();
                          return;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentGdtadApiGdtAd == null);
      paramView = this.jdField_a_of_type_ComTencentGdtadApiGdtAd.getAd();
    } while (paramView == null);
    Intent localIntent = new Intent();
    GdtImaxData localGdtImaxData = new GdtImaxData();
    localGdtImaxData.setAd(paramView);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setUrl(paramView.getVideoUrl());
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setDirectPlay(true);
    localGdtVideoData.setAd(paramView);
    localGdtVideoData.setVideoDefaultBackgroundColor(0);
    localGdtVideoData.setForceNotShowControllerView(true);
    localGdtVideoData.setCoverUrl(paramView.info.display_info.basic_info.img.get());
    localGdtImaxData.setVideoData(localGdtVideoData);
    localGdtImaxData.setWebUrl(paramView.getUrlForLandingPage());
    localIntent.putExtra("data", localGdtImaxData);
    abju.a(getActivity(), localIntent, PublicFragmentActivityForQzone.class, GdtMotiveVideoMockQzoneImaxFeedsFragment.class, 1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131493538, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131297907).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131298071).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311220).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311221).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311223).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311224).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311225).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311226).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311267).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131311246).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131296425).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131296495).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131313543).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131296446).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131300148));
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment
 * JD-Core Version:    0.7.0.1
 */