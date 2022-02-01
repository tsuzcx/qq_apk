package com.tencent.biz.troopgift;

import abkp;
import abkr;
import abkv;
import aboq;
import abrk;
import abrl;
import absw;
import adxr;
import ahgz;
import alvx;
import amtj;
import amxb;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcef;
import bczs;
import bfci;
import bfcs;
import bfur;
import bfvh;
import bfvo;
import bfzl;
import bhjm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import muk;
import nmy;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;
import zso;
import zsq;
import zsr;
import zsv;
import zsw;
import zsy;
import zsz;
import zta;
import ztb;
import ztc;
import zte;
import ztf;
import ztg;
import zth;
import zti;
import ztj;
import ztk;
import ztl;
import ztm;
import ztn;
import zto;
import ztp;
import ztq;
import ztr;
import zts;
import ztt;
import ztu;
import ztv;
import ztw;
import ztx;
import zty;
import ztz;
import zua;
import zuc;
import zuh;
import zui;
import zuj;

public class TroopGiftPanel
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, bhjm
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  private static boolean f;
  private long jdField_a_of_type_Long;
  public Context a;
  protected View.OnClickListener a;
  protected View a;
  public Button a;
  protected ImageView a;
  protected TextView a;
  private com.tencent.gdtad.api.GdtAd jdField_a_of_type_ComTencentGdtadApiGdtAd;
  private GdtMotiveVideoAd jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd;
  protected SessionInfo a;
  protected HorizontalListView a;
  public String a;
  public WeakReference<AppInterface> a;
  public zsv a;
  public zsy a;
  public zsz a;
  private zua jdField_a_of_type_Zua;
  public zuj a;
  protected boolean a;
  public View[] a;
  public GridListViewPager[] a;
  protected View b;
  protected ImageView b;
  public TextView b;
  protected String b;
  public WeakReference<BaseChatPie> b;
  protected boolean b;
  protected View c;
  public TextView c;
  public String c;
  public boolean c;
  protected View d;
  protected TextView d;
  protected String d;
  protected boolean d;
  public View e;
  protected TextView e;
  protected String e;
  private boolean e;
  protected View f;
  public String f;
  protected int g;
  protected View g;
  protected String g;
  public int h;
  protected View h;
  private String h;
  public int i;
  public View i;
  private String i;
  public int j;
  private View j;
  public int k;
  private View k;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
    jdField_e_of_type_Int = jdField_a_of_type_Int;
    jdField_f_of_type_Int = jdField_c_of_type_Int;
  }
  
  public TroopGiftPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = amtj.a(2131714430);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = amtj.a(2131714435);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ztz(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_k_of_type_Int = 1;
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this(paramContext, paramBaseChatPie, 1, 0);
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = amtj.a(2131714430);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = amtj.a(2131714435);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ztz(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_k_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = paramInt2;
    if ((paramInt2 == 2) || (paramInt2 == 7)) {
      this.jdField_a_of_type_JavaLangString = amtj.a(2131714412);
    }
  }
  
  public TroopGiftPanel(Context paramContext, zuj paramzuj, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = amtj.a(2131714430);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = amtj.a(2131714435);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ztz(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Zuj = paramzuj;
    this.jdField_a_of_type_JavaLangString = amtj.a(2131714420);
    this.jdField_k_of_type_Int = 1;
  }
  
  private Bitmap a(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    Object localObject2 = paramBitmap.getConfig();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Bitmap.Config.ARGB_8888;
    }
    paramBitmap = paramBitmap.copy((Bitmap.Config)localObject1, true);
    localObject1 = new Canvas(paramBitmap);
    localObject2 = new Paint(1);
    ((Paint)localObject2).setDither(true);
    ((Paint)localObject2).setFilterBitmap(true);
    ((Paint)localObject2).setColor(-1);
    ((Paint)localObject2).setFakeBoldText(true);
    if (paramString.length() <= 2) {}
    for (float f1 = 9.0F;; f1 = 7.5F)
    {
      ((Paint)localObject2).setTextSize(bfvh.a(paramContext, f1));
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setShadowLayer(0.5F, 0.4F, 0.0F, -12303292);
      if (paramString.length() <= 4) {
        break;
      }
      paramContext = paramString.substring(0, (paramString.length() + 1) / 2);
      paramString = paramString.substring((paramString.length() + 1) / 2);
      localRect1 = new Rect();
      Rect localRect2 = new Rect();
      ((Paint)localObject2).getTextBounds(paramContext, 0, paramContext.length(), localRect1);
      ((Paint)localObject2).getTextBounds(paramString, 0, paramString.length(), localRect2);
      f1 = (paramBitmap.getWidth() - localRect1.width()) / 2;
      f2 = (paramBitmap.getHeight() - localRect1.height() - localRect2.height() - 4.0F) / 2.0F;
      f2 = localRect1.height() + f2 - 1.0F;
      ((Canvas)localObject1).drawText(paramContext, f1 - 1.0F, f2, (Paint)localObject2);
      ((Canvas)localObject1).drawText(paramString, (paramBitmap.getWidth() - localRect2.width()) / 2 - 1.0F, 4.0F + (f2 + localRect2.height()) - 1.0F, (Paint)localObject2);
      return paramBitmap;
    }
    Rect localRect1 = new Rect();
    ((Paint)localObject2).getTextBounds(paramString, 0, paramString.length(), localRect1);
    f1 = bfvh.a(paramContext, 4.0F);
    float f2 = paramBitmap.getWidth() - localRect1.width();
    if (paramString.length() > 2) {}
    for (f1 = f2 / 2.0F;; f1 = f2 - f1)
    {
      int m = localRect1.height();
      ((Canvas)localObject1).drawText(paramString, f1, (paramBitmap.getHeight() - localRect1.height()) / 2 + m - 1.0F, (Paint)localObject2);
      return paramBitmap;
    }
  }
  
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
    Object localObject1 = null;
    if ((paramGdtAd == null) || (!paramGdtAd.isLoaded()) || (paramGdtAd.isInvalidated()) || (!(paramGdtAd instanceof GdtMotiveVideoAd)))
    {
      QLog.i("TroopGiftPanel", 1, String.format("mockMVPageData null %d", new Object[] { Integer.valueOf(paramInt1) }) + paramInt2);
      QQToast.a(a(), amtj.a(2131714418), 0).a();
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
      abrl.d("TroopGiftPanel", "VideoUrl " + localGdtMotiveVideoPageData.url);
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
        localGdtMotiveVideoPageData.endcardUrl = localGdtAd.getEndcardUrl();
        localGdtMotiveVideoPageData.endcardLoadTime = localGdtAd.getEndcardLoadTime();
        localObject2 = ((GdtMotiveVideoAd)localObject2).getGdtAdLoader();
        paramGdtAd = localObject1;
        if (localObject2 != null)
        {
          paramGdtAd = localObject1;
          if (((abkp)localObject2).a() != null)
          {
            paramGdtAd = localObject1;
            if (((abkp)localObject2).a().a != null)
            {
              localObject2 = ((abkp)localObject2).a().a.pos_ads_info.get();
              paramGdtAd = localObject1;
              if (localObject2 != null)
              {
                paramGdtAd = localObject1;
                if (((List)localObject2).size() > 0)
                {
                  localObject2 = (qq_ad_get.QQAdGetRsp.PosAdInfo)((List)localObject2).get(0);
                  paramGdtAd = localObject1;
                  if (localObject2 != null)
                  {
                    paramGdtAd = localObject1;
                    if (((qq_ad_get.QQAdGetRsp.PosAdInfo)localObject2).ads_info != null)
                    {
                      localObject2 = ((qq_ad_get.QQAdGetRsp.PosAdInfo)localObject2).ads_info.get();
                      paramGdtAd = localObject1;
                      if (localObject2 != null)
                      {
                        paramGdtAd = localObject1;
                        if (((List)localObject2).size() > 0) {
                          paramGdtAd = abrk.a((qq_ad_get.QQAdGetRsp.AdInfo)((List)localObject2).get(0));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        if (paramGdtAd != null) {
          break label566;
        }
      }
      label566:
      for (paramGdtAd = "";; paramGdtAd = paramGdtAd.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramGdtAd;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        localGdtMotiveVideoPageData.refId = "biz_src_hdsp_liwu";
        return localGdtMotiveVideoPageData;
        paramGdtAd = localGdtAd.getImageData().jdField_a_of_type_JavaLangString;
        break;
      }
    }
    return null;
  }
  
  private LottieImageAsset a(Map<String, LottieImageAsset> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      return null;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      LottieImageAsset localLottieImageAsset = (LottieImageAsset)paramMap.get((String)localIterator.next());
      if (TextUtils.equals(localLottieImageAsset.getFileName(), paramString)) {
        return localLottieImageAsset;
      }
    }
    return null;
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
  
  public static void a(int paramInt1, int paramInt2)
  {
    bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_pv", 0, 0, paramInt2 + "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "reportPlusPanelEntryExp, pageIdx=" + paramInt1 + ", aioType=" + paramInt2);
    }
  }
  
  private void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (!absw.a(paramGdtMotiveVideoPageData.vSize))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("data", paramGdtMotiveVideoPageData);
    localBundle.putString("big_brother_ref_source_key", paramGdtMotiveVideoPageData.refId);
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtras(localBundle);
    if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
    for (paramGdtMotiveVideoPageData = PublicFragmentActivityLandscape.class;; paramGdtMotiveVideoPageData = PublicFragmentActivity.class)
    {
      adxr.a(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 12008);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup, ztg paramztg)
  {
    SharePreferenceUtils.set(a(), "AIO_ACTIVITY_SHOW_TIME", String.valueOf(System.currentTimeMillis()));
    ztb localztb = paramztg.jdField_a_of_type_Ztb;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)bfvh.a(getContext(), localztb.jdField_a_of_type_Int), (int)bfvh.a(getContext(), localztb.jdField_b_of_type_Int));
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(a());
    paramViewGroup.addView(localDiniFlyAnimationView, localLayoutParams);
    localDiniFlyAnimationView.setAnimationFromUrl(localztb.jdField_a_of_type_JavaLangString);
    localDiniFlyAnimationView.addLottieOnCompositionLoadedListener(new ztx(this, localztb));
    localDiniFlyAnimationView.setOnClickListener(new zty(this, localztb, paramztg, localDiniFlyAnimationView));
    localDiniFlyAnimationView.playAnimation();
  }
  
  private void a(LottieComposition paramLottieComposition, ztb paramztb)
  {
    paramztb = paramztb.jdField_a_of_type_JavaUtilList.iterator();
    while (paramztb.hasNext())
    {
      zta localzta = (zta)paramztb.next();
      if ((localzta.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localzta.jdField_e_of_type_JavaLangString)))
      {
        LottieImageAsset localLottieImageAsset = a(paramLottieComposition.getImages(), localzta.jdField_e_of_type_JavaLangString);
        if (localLottieImageAsset != null)
        {
          Bitmap localBitmap = Bitmap.createBitmap(localLottieImageAsset.getWidth(), localLottieImageAsset.getHeight(), Bitmap.Config.ARGB_8888);
          localLottieImageAsset.setBitmap(a(a(), localBitmap, localzta.jdField_a_of_type_JavaLangString));
        }
      }
    }
  }
  
  private void a(ArrayList<ztg> paramArrayList)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131381035);
    localViewGroup.removeAllViews();
    localViewGroup.setBackgroundColor(0);
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    int m;
    ztg localztg;
    for (;;)
    {
      return;
      m = 0;
      while (m < paramArrayList.size())
      {
        localztg = (ztg)paramArrayList.get(m);
        if ((localztg != null) && (localztg.jdField_b_of_type_Int > 0) && (localztg.jdField_c_of_type_Int > 0) && (localztg.jdField_b_of_type_JavaLangString.length() != 0) && (localztg.jdField_c_of_type_JavaLangString.length() != 0)) {
          break label105;
        }
        m += 1;
      }
    }
    label105:
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject2 = getContext();
    float f1;
    label151:
    Object localObject3;
    if (m == paramArrayList.size() - 1)
    {
      f1 = 10.0F;
      localRelativeLayout.setPadding(0, 0, (int)bfvh.a((Context)localObject2, f1), 0);
      localViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
      localObject3 = new LinearLayout.LayoutParams((int)bfvh.a(getContext(), localztg.jdField_b_of_type_Int), (int)bfvh.a(getContext(), localztg.jdField_c_of_type_Int));
      localObject1 = new ztw(this, localztg);
      if (!a(localztg.jdField_a_of_type_Ztb)) {
        break label261;
      }
      a(localRelativeLayout, localztg);
    }
    for (;;)
    {
      localRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      break;
      f1 = 6.0F;
      break label151;
      label261:
      localObject2 = new ImageView(getContext());
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = new ColorDrawable(0);
      ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(localztg.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    }
  }
  
  private void a(zsy paramzsy)
  {
    if (paramzsy != null)
    {
      if (paramzsy.jdField_b_of_type_Int == 0)
      {
        c(0);
        if (this.jdField_k_of_type_Int >= 4)
        {
          amxb.a("gift_store", "exp_chose", a(), a() + "", "", "");
          return;
        }
        if (nmy.a().a(a())) {}
        for (int m = 2;; m = 1)
        {
          bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          return;
        }
      }
      c(8);
      return;
    }
    c(8);
  }
  
  private boolean a(ztb paramztb)
  {
    if ((paramztb == null) || (TextUtils.isEmpty(paramztb.jdField_a_of_type_JavaLangString)) || (paramztb.jdField_a_of_type_JavaUtilList == null) || (paramztb.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    try
    {
      l2 = Long.valueOf(SharePreferenceUtils.get(a(), "AIO_ACTIVITY_SHOW_TIME")).longValue();
      int m = paramztb.jdField_c_of_type_Int;
      if (l1 - l2 < m * 1000) {
        return false;
      }
    }
    catch (Exception localException)
    {
      long l2;
      QLog.e("TroopGiftPanel", 4, localException, new Object[0]);
      SharePreferenceUtils.set(a(), "AIO_ACTIVITY_SHOW_TIME", "0");
      paramztb = paramztb.jdField_a_of_type_JavaUtilList.iterator();
      while (paramztb.hasNext())
      {
        zta localzta = (zta)paramztb.next();
        l2 = bfzl.a(localzta.jdField_b_of_type_JavaLangString);
        long l3 = bfzl.a(localzta.jdField_c_of_type_JavaLangString);
        if ((l1 >= l2) && (l1 < l3)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_j_of_type_AndroidViewView == null) {
      return;
    }
    h();
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379646)).setText(amtj.a(2131714411));
    this.jdField_j_of_type_AndroidViewView.setContentDescription(amtj.a(2131714415));
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379646)).setTextColor(Color.parseColor("#ff878b99"));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379645)).setText(amtj.a(2131714426));
    this.jdField_k_of_type_AndroidViewView.setContentDescription(amtj.a(2131714422));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379645)).setTextColor(Color.parseColor("#ff878b99"));
    this.jdField_j_of_type_AndroidViewView.findViewById(2131380792).setVisibility(8);
    this.jdField_k_of_type_AndroidViewView.findViewById(2131380798).setVisibility(8);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(new zts(this));
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(new ztv(this));
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", amtj.a(2131714416));
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130771997, 2130772044);
    if (this.jdField_j_of_type_Int == 2) {
      bcef.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_opr", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "onJumpAction, url=" + paramString);
      }
      d(1);
      return;
      if (this.jdField_j_of_type_Int == 6)
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_opr", 0, 0, "", "", "", "");
      }
      else if (this.jdField_j_of_type_Int == 7)
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_opr", 0, 0, "", "", "", "");
      }
      else
      {
        if (this.jdField_k_of_type_Int < 4) {
          break;
        }
        amxb.a("clk_oper", "clk_oper", a(), a() + "", "", "");
      }
    }
    if (nmy.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      break;
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_Zsy != null) && (this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Zsz.jdField_b_of_type_AndroidUtilSparseArray.size() > 0) && (this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.size() > 0);
  }
  
  private void h()
  {
    if (this.jdField_j_of_type_AndroidViewView != null) {
      this.jdField_j_of_type_AndroidViewView.setSelected(false);
    }
    if (this.jdField_k_of_type_AndroidViewView != null) {
      this.jdField_k_of_type_AndroidViewView.setSelected(false);
    }
  }
  
  private void i()
  {
    d(this.jdField_e_of_type_JavaLangString);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Zsz == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Zsz.jdField_c_of_type_Int = 0;
      if ((this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) && (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < jdField_c_of_type_Int))
      {
        ztf localztf = (ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
        if (localztf.jdField_b_of_type_JavaUtilArrayList != null)
        {
          int m = 0;
          if (m < localztf.jdField_b_of_type_JavaUtilArrayList.size())
          {
            zsy localzsy = (zsy)localztf.jdField_b_of_type_JavaUtilArrayList.get(m);
            if (m == 0) {}
            for (boolean bool = true;; bool = false)
            {
              localzsy.jdField_a_of_type_Boolean = bool;
              m += 1;
              break;
            }
          }
        }
      }
    } while ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length) || (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.jdField_h_of_type_Int].getAdapter() == null));
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.jdField_h_of_type_Int].a();
  }
  
  private void k()
  {
    aboq localaboq = new aboq();
    localaboq.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(alvx.a().getCurrentAccountUin()), "4040385433442243");
    localaboq.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, a());
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd = new GdtMotiveVideoAd(localaboq);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd.setListener(new WeakReference(this.jdField_a_of_type_Zua));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd.load(a());
  }
  
  public int a()
  {
    switch (this.jdField_k_of_type_Int)
    {
    case 7: 
    default: 
      return this.jdField_k_of_type_Int;
    case 6: 
      return 504;
    case 4: 
      if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof ahgz))
      {
        ahgz localahgz = (ahgz)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if ((localahgz.a != null) && (localahgz.a.isBuLuoHotChat())) {
          return 507;
        }
        return 503;
      }
      return -1;
    case 5: 
      return 2;
    }
    return 508;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a()
  {
    if (this.jdField_j_of_type_Int == 2) {
      return null;
    }
    if (this.jdField_j_of_type_Int == 7) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    AppInterface localAppInterface;
    do
    {
      do
      {
        return paramString;
      } while ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7));
      localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localAppInterface == null);
    Object localObject = (TroopManager)localAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).c(a());
      if (localObject != null) {
        if (((TroopInfo)localObject).isTroopOwner(localAppInterface.getCurrentAccountUin())) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      return paramString.replace("$GCODE$", a()).replace("$CLIENTVER$", "android8.4.8").replace("$UIN$", localAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
      if (((TroopInfo)localObject).isAdmin())
      {
        localObject = "1";
      }
      else
      {
        localObject = "2";
        continue;
        localObject = "2";
      }
    }
  }
  
  public void a()
  {
    inflate(getContext(), 2131560626, this);
  }
  
  protected void a(int paramInt)
  {
    int m = 0;
    if (m < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      if (m != paramInt) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[m].setVisibility(8);
      }
      for (;;)
      {
        m += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidViewView[m].setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    QLog.i("TroopGiftPanel", 1, "watch gdt mv result, 广告总时长: " + paramLong1 + " 观看时长: " + paramLong2 + " 可以送免费礼物： " + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_h_of_type_JavaLangString);
      jdField_f_of_type_Boolean = true;
    }
    k();
  }
  
  protected void a(View paramView1, View paramView2, View paramView3)
  {
    if (d())
    {
      paramView1.findViewById(2131372207).setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramView2.findViewById(2131372207).setVisibility(0);
      paramView2.findViewById(2131373133).setVisibility(0);
      paramView3.findViewById(2131372207).setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      paramView1 = findViewById(2131363428);
      paramView2 = paramView1.getLayoutParams();
      paramView2.height = ((int)bfvh.a(getContext(), 400.0F));
      paramView1.setLayoutParams(paramView2);
      paramView1 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      paramView2 = a();
      paramView3 = zsz.b(paramView2);
      if ((paramView1 != null) && (!TextUtils.isEmpty(paramView3)) && (!TextUtils.isEmpty(paramView2)) && ((paramView1 instanceof QQAppInterface))) {
        ThreadManagerV2.excute(new TroopGiftPanel.8(this, paramView1, paramView2, paramView3, new Handler(Looper.getMainLooper())), 16, null, true);
      }
    }
  }
  
  protected void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "setLeftCoinDrawable param illegal");
      }
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    paramString.setDownloadListener(new zti(this, paramTextView));
    paramString.setBounds(0, 0, (int)bfvh.a(this.jdField_a_of_type_AndroidContentContext, 13.0F), (int)bfvh.a(this.jdField_a_of_type_AndroidContentContext, 14.0F));
    paramTextView.setCompoundDrawables(paramString, null, null, null);
    paramTextView.setCompoundDrawablePadding((int)bfvh.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
    paramString.startDownload();
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370267);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131365094);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131378108));
    this.jdField_a_of_type_Zsv = new zsv();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Zsv);
    this.jdField_j_of_type_AndroidViewView = findViewById(2131370163);
    this.jdField_k_of_type_AndroidViewView = findViewById(2131370165);
    c(paramBoolean);
    a(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363964));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131363965);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365929));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363657);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377797));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367621));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131376202).setOnClickListener(this);
    findViewById(2131363428).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new zth(this));
    h();
    this.jdField_a_of_type_Zsv.a(this.jdField_h_of_type_Int);
    a(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_Zua = new zua(this);
    k();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("x" + paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool = true;
    QLog.i("TroopGiftPanel", 1, "onSelectGiftReceiver, uin=" + paramString1 + ", displayName=" + paramString2);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!paramString1.equals(this.jdField_f_of_type_JavaLangString)) {
        zsz.b(a(), paramString1);
      }
      this.jdField_f_of_type_JavaLangString = paramString1;
      this.jdField_g_of_type_JavaLangString = paramString2;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new bczs(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new bczs(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString2);
      paramString2 = bfvo.a();
      AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppInterface != null)
      {
        paramString1 = FaceDrawable.getFaceDrawable(localAppInterface, 1, paramString1, 3, paramString2, paramString2);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        break label249;
      }
    }
    for (;;)
    {
      setSendGiftBtnEnabled(bool);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString2);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString2);
      break;
      label249:
      bool = false;
    }
  }
  
  public void a(zuh paramzuh)
  {
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, callback=" + paramzuh);
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (bfci)((AppInterface)localObject).getManager(113);
    String str1 = this.jdField_b_of_type_JavaLangString;
    int n = this.jdField_g_of_type_Int;
    int i1 = this.jdField_k_of_type_Int;
    String str2 = a();
    if (this.jdField_k_of_type_Int >= 4) {}
    for (int m = 2;; m = 0)
    {
      ((bfci)localObject).a(str1, n, i1, str2, 2, m, new ztj(this, paramzuh));
      return;
    }
  }
  
  public void a(zui paramzui)
  {
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, callback=" + paramzui);
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {
      return;
    }
    ((bfci)localAppInterface.getManager(113)).a(new ztu(this, paramzui));
  }
  
  protected void a(boolean paramBoolean)
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
    jdField_e_of_type_Int = jdField_a_of_type_Int;
    jdField_f_of_type_Int = jdField_c_of_type_Int;
    Object localObject1 = new zsw();
    ((zsw)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131697217);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    this.jdField_a_of_type_Zsv.a((List)localObject2);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    localObject1 = (RadioViewPager)findViewById(2131380768);
    localObject2 = (RadioViewPager)findViewById(2131380769);
    RadioViewPager localRadioViewPager = (RadioViewPager)findViewById(2131380770);
    ((RadioViewPager)localObject1).setGiftPanel(this);
    ((RadioViewPager)localObject2).setGiftPanel(this);
    localRadioViewPager.setGiftPanel(this);
    this.jdField_e_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131377037);
    this.jdField_f_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131376018);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RadioViewPager)localObject1).findViewById(2131376017));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((RadioViewPager)localObject1).findViewById(2131376019));
    View localView1 = ((RadioViewPager)localObject1).findViewById(2131364369);
    this.jdField_g_of_type_AndroidViewView = localRadioViewPager.findViewById(2131377037);
    this.jdField_h_of_type_AndroidViewView = localRadioViewPager.findViewById(2131376018);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localRadioViewPager.findViewById(2131376017));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localRadioViewPager.findViewById(2131376019));
    this.jdField_i_of_type_AndroidViewView = localRadioViewPager.findViewById(2131372207);
    View localView2 = localRadioViewPager.findViewById(2131364369);
    localRadioViewPager.setEmptyInfo(BaseApplication.getContext().getString(2131697015), BaseApplication.getContext().getString(2131697016));
    localRadioViewPager.setIsShowJumpInfo(false, "", this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a((View)localObject1, (View)localObject2, localRadioViewPager);
    this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_a_of_type_Int] = localObject1;
    this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_c_of_type_Int] = localObject2;
    this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int] = localRadioViewPager;
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_a_of_type_Int] = ((GridListViewPager)((RadioViewPager)localObject1).a());
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_a_of_type_Int].setOnItemClickListener(this);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int] = ((GridListViewPager)((RadioViewPager)localObject2).a());
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setOnItemClickListener(this);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int] = ((GridListViewPager)localRadioViewPager.a());
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].setOnItemClickListener(this);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected boolean a(int paramInt, bfcs parambfcs)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_i_of_type_Int < paramInt) {
      if (parambfcs != null)
      {
        bool1 = bool2;
        if (parambfcs.jdField_b_of_type_Int + parambfcs.jdField_c_of_type_Int != 0) {}
      }
      else
      {
        if (!nmy.a().a(a())) {
          break label122;
        }
      }
    }
    label122:
    for (paramInt = 2;; paramInt = 1)
    {
      parambfcs = this.jdField_a_of_type_AndroidContentContext.getResources();
      bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, parambfcs.getString(2131697219), parambfcs.getString(2131697218), parambfcs.getString(2131690620), parambfcs.getString(2131697221), new ztr(this, paramInt), new ztt(this)).show();
      g();
      bool1 = false;
      return bool1;
    }
  }
  
  public int b()
  {
    int n = 0;
    CharSequence localCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    int m = n;
    try
    {
      if (!TextUtils.isEmpty(localCharSequence)) {
        m = Integer.parseInt(localCharSequence.toString().substring(1));
      }
      return m;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        m = n;
      } while (!QLog.isColorLevel());
      QLog.d("TroopGiftPanel", 2, "error sendNum = " + localCharSequence);
    }
    return 0;
  }
  
  public void b()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str1 = a();
    String str2 = zsz.b(str1);
    if ((localAppInterface != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && ((localAppInterface instanceof QQAppInterface)))
    {
      ThreadManagerV2.excute(new TroopGiftPanel.7(this, localAppInterface, str1, str2, new Handler(Looper.getMainLooper())), 16, null, true);
      return;
    }
    QLog.e("TroopGiftPanel", 1, "NoSelectGiftReceiver! last receiver is not in troop, troopUin=" + str1 + ", memberUin=" + str2);
    zsz.b(str1, "");
    f();
  }
  
  public void b(int paramInt)
  {
    a("1");
    if ((this.jdField_a_of_type_Zsy != null) && (this.jdField_a_of_type_Zsy.jdField_b_of_type_Int == 0))
    {
      c(0);
      if (this.jdField_k_of_type_Int >= 4) {
        amxb.a("gift_store", "exp_chose", a(), a() + "", "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zsz != null) {
        this.jdField_a_of_type_Zsz.jdField_c_of_type_Int = 0;
      }
      this.jdField_h_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_Zsz == null) || (this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList == null)) {
        this.jdField_h_of_type_Int = jdField_a_of_type_Int;
      }
      h();
      if (this.jdField_a_of_type_Zsv != null) {
        this.jdField_a_of_type_Zsv.a(this.jdField_h_of_type_Int);
      }
      onTabSelected(0, this.jdField_h_of_type_Int);
      c(this.jdField_d_of_type_Boolean);
      return;
      if (nmy.a().a(a())) {}
      for (int m = 2;; m = 1)
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      c(8);
    }
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString).replace("http://", "https://");
    if (paramString.contains("?")) {}
    for (paramString = paramString + "&troop_uin=" + a();; paramString = paramString + "?troop_uin=" + a())
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("selfSet_leftViewText", amtj.a(2131714406));
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "onActionListItemClick, url=" + paramString);
      }
      return;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    for (;;)
    {
      return;
      String str = "";
      int i1 = 0;
      int i2 = 0;
      Object localObject = null;
      if (this.jdField_a_of_type_Zsz != null) {
        localObject = this.jdField_a_of_type_Zsz.jdField_a_of_type_Zso;
      }
      int n;
      if (localObject != null)
      {
        str = ((zso)localObject).jdField_a_of_type_JavaLangString;
        n = ((zso)localObject).jdField_b_of_type_Int;
        m = ((zso)localObject).jdField_a_of_type_Int;
        this.jdField_e_of_type_JavaLangString = ((zso)localObject).jdField_b_of_type_JavaLangString;
        bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "panelEntryItem", 0, 0, "", "", "", "");
        localObject = str;
      }
      while ((!TextUtils.isEmpty((CharSequence)localObject)) && (n > 0) && (m > 0))
      {
        if (this.jdField_j_of_type_Int != 2) {
          break label259;
        }
        bcef.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_opr", 0, 0, "", "", "", "");
        return;
        m = i2;
        n = i1;
        localObject = str;
        if (this.jdField_a_of_type_Zsz != null)
        {
          m = i2;
          n = i1;
          localObject = str;
          if (this.jdField_a_of_type_Zsz.jdField_a_of_type_Zte != null)
          {
            m = i2;
            n = i1;
            localObject = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Zsz.jdField_a_of_type_Zte.jdField_a_of_type_JavaLangString))
            {
              localObject = this.jdField_a_of_type_Zsz.jdField_a_of_type_Zte.jdField_a_of_type_JavaLangString;
              n = 36;
              m = 36;
              this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Zsz.jdField_a_of_type_Zte.jdField_b_of_type_JavaLangString;
            }
          }
        }
      }
    }
    label259:
    if (this.jdField_j_of_type_Int == 6)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      amxb.a("gift_store", "exp_oper", a(), a() + "", "", "");
      return;
    }
    if (nmy.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc.jdField_c_of_type_JavaLangString + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)
    {
      str = String.format((String)localObject, new Object[] { str });
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("selfSet_leftViewText", amtj.a(2131714427));
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("url", a(str));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130771997, 0);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "handlerSendGiftToPerson, uin=" + paramString);
    }
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    localObject = (bfci)((AppInterface)localObject).getManager(113);
    zsy localzsy = this.jdField_a_of_type_Zsy;
    int i1 = localzsy.jdField_b_of_type_Int;
    if (localzsy.jdField_b_of_type_Int == 0) {
      i1 = b();
    }
    int m = 0;
    int i2 = 0;
    int n;
    label140:
    int i4;
    String str;
    long l;
    int i5;
    if (nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
    {
      m = 6;
      n = i2;
      if (!nmy.a().a(a())) {
        break label340;
      }
      i2 = 2;
      i4 = this.jdField_k_of_type_Int;
      str = a();
      l = Long.parseLong(paramString);
      i5 = localzsy.jdField_c_of_type_Int;
      if (localzsy.jdField_b_of_type_Int != 0) {
        break label346;
      }
    }
    label340:
    label346:
    for (int i3 = 1;; i3 = 0)
    {
      ((bfci)localObject).a("OidbSvc.0x6b6", 1718, m, i4, str, 2, i1, l, i5, i3, localzsy.jdField_a_of_type_Int, n, new ztq(this, i2, localzsy), localzsy.jdField_e_of_type_Int);
      this.jdField_a_of_type_Zsy.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Zsy = null;
      return;
      if (this.jdField_j_of_type_Int == 2)
      {
        m = 9;
        n = 1;
        break;
      }
      if (this.jdField_j_of_type_Int == 6)
      {
        m = 10;
        n = i2;
        break;
      }
      n = i2;
      if (this.jdField_j_of_type_Int != 7) {
        break;
      }
      m = 11;
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)
      {
      default: 
        n = i2;
        break;
      case 1000: 
        n = 512;
        break;
      case 1004: 
        n = 513;
        break;
        i2 = 1;
        break label140;
      }
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)
    {
      bcef.b(null, "dc00899", "grp_lbs", str, "qq_gift", "button_click", 0, 0, paramInt + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "reportActionEntryClick, entryId=" + paramInt + ", toUin=" + str);
      }
      return;
    }
  }
  
  public boolean d()
  {
    return (this.jdField_j_of_type_Int != 2) && (this.jdField_j_of_type_Int != 7) && (this.jdField_j_of_type_Int != 3);
  }
  
  public void e()
  {
    Intent localIntent;
    if (this.jdField_j_of_type_Int == 6)
    {
      localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 16);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697210));
      localIntent.setFlags(603979776);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 12006);
    }
    do
    {
      return;
      localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), a(), 14);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697210));
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        localIntent.putExtra("troop_gift_from", ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin());
      }
    } while (this.jdField_c_of_type_Boolean);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 12006);
  }
  
  public void f()
  {
    if ((this.jdField_f_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView != null))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void g()
  {
    if (nmy.a().a(a())) {}
    for (int m = 2; this.jdField_j_of_type_Int == 2; m = 1)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 6)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      amxb.a("gift_store", "exp_tip", a(), a() + "", "", "");
      return;
    }
    bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
  }
  
  public void onClick(View paramView)
  {
    int n;
    if (nmy.a().a(a())) {
      n = 2;
    }
    label170:
    int m;
    switch (paramView.getId())
    {
    case 2131363657: 
    default: 
    case 2131363964: 
    case 2131376202: 
    case 2131363879: 
    case 2131369706: 
    case 2131365929: 
    case 2131365930: 
    case 2131377109: 
      label1282:
      label1548:
      label2318:
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        n = 1;
        break;
        label201:
        Object localObject4;
        Object localObject3;
        label300:
        int i2;
        Object localObject1;
        int i3;
        if (jdField_c_of_type_Int == this.jdField_h_of_type_Int) {
          if (this.jdField_k_of_type_Int >= 4)
          {
            amxb.a("gift_store", "clk_now", a(), a() + "", "", "");
            i1 = 0;
            m = i1;
            if (this.jdField_a_of_type_Zsy != null)
            {
              if (this.jdField_a_of_type_Zsy.jdField_e_of_type_Int <= 0) {
                break label849;
              }
              m = this.jdField_a_of_type_Zsy.jdField_e_of_type_Int;
            }
            bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
            localObject4 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if ((localObject4 == null) || (this.jdField_a_of_type_Zsy == null)) {
              continue;
            }
            localObject3 = this.jdField_a_of_type_Zsy;
            m = ((zsy)localObject3).jdField_b_of_type_Int;
            if (((zsy)localObject3).jdField_b_of_type_Int == 0) {
              m = b();
            }
            if ((this.jdField_h_of_type_Int != jdField_d_of_type_Int) || (!this.jdField_a_of_type_Zsy.jdField_d_of_type_Boolean)) {
              break label873;
            }
            if (jdField_c_of_type_Int != this.jdField_h_of_type_Int) {
              break label1065;
            }
            localObject4 = (bfci)((AppInterface)localObject4).getManager(113);
            if (!((zsy)localObject3).jdField_b_of_type_Boolean) {
              break label972;
            }
            i2 = this.jdField_k_of_type_Int;
            localObject1 = a();
            i3 = ((zsy)localObject3).jdField_c_of_type_Int;
            if (((zsy)localObject3).jdField_b_of_type_Int != 0) {
              break label966;
            }
          }
        }
        label966:
        for (int i1 = 1;; i1 = 0)
        {
          ((bfci)localObject4).a("OidbSvc.0x6b6", 1718, 8, i2, (String)localObject1, 2, m, 0L, i3, i1, ((zsy)localObject3).jdField_a_of_type_Int, 0, new ztm(this, n, (zsy)localObject3), ((zsy)localObject3).jdField_e_of_type_Int);
          if (this.jdField_a_of_type_Zuj == null) {
            break label1548;
          }
          this.jdField_a_of_type_Zuj.b();
          break;
          bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          break label170;
          if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int)) {
            break label170;
          }
          if (this.jdField_j_of_type_Int == 2)
          {
            bcef.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_send", 0, 0, "", "", "", "");
            break label170;
          }
          if (this.jdField_j_of_type_Int == 6)
          {
            bcef.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_send", 0, 0, "", "", "", "");
            break label170;
          }
          if (this.jdField_j_of_type_Int == 7)
          {
            bcef.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_send", 0, 0, "", "", "", "");
            break label170;
          }
          if (this.jdField_k_of_type_Int >= 4)
          {
            amxb.a("gift_store", "clk_send", a(), a() + "", "", "");
            break label170;
          }
          bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          bcef.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_addpage", n, 0, a(), "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()), "", "");
          break label170;
          label849:
          m = i1;
          if (this.jdField_a_of_type_Zsy.jdField_a_of_type_Int <= 0) {
            break label201;
          }
          m = this.jdField_a_of_type_Zsy.jdField_a_of_type_Int;
          break label201;
          label873:
          boolean bool = this.jdField_a_of_type_Zsz.a(this.jdField_h_of_type_Int);
          localObject1 = this.jdField_a_of_type_Zsz.jdField_a_of_type_AndroidUtilSparseArray;
          if (((zsy)localObject3).jdField_e_of_type_Int != 0) {}
          for (i1 = ((zsy)localObject3).jdField_e_of_type_Int;; i1 = ((zsy)localObject3).jdField_a_of_type_Int)
          {
            localObject1 = (bfcs)((SparseArray)localObject1).get(i1);
            if ((bool) || (a(m, (bfcs)localObject1))) {
              break label300;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TroopGiftPanel", 2, "isStorageEnough: false");
            break;
          }
        }
        label972:
        if (this.jdField_a_of_type_Boolean)
        {
          n = 3;
          label981:
          if (!this.jdField_a_of_type_Boolean) {
            break label1049;
          }
          localObject1 = "OidbSvc.0x7f6";
          label993:
          if (!this.jdField_a_of_type_Boolean) {
            break label1057;
          }
        }
        label1049:
        label1057:
        for (i1 = 2038;; i1 = 1718)
        {
          ((bfci)localObject4).a((String)localObject1, i1, n, this.jdField_k_of_type_Int, a(), 2, m, 1, ((zsy)localObject3).jdField_a_of_type_Int, new ztn(this, (zsy)localObject3));
          break;
          n = 1;
          break label981;
          localObject1 = "OidbSvc.0x6b6";
          break label993;
        }
        label1065:
        if ((this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < jdField_c_of_type_Int))
        {
          if (this.jdField_c_of_type_Boolean)
          {
            localObject1 = this.jdField_d_of_type_JavaLangString;
            continue;
          }
          if ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7)) {}
          for (localObject1 = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin;; localObject1 = this.jdField_f_of_type_JavaLangString)
          {
            long l1 = 0L;
            try
            {
              long l2 = Long.valueOf((String)localObject1).longValue();
              l1 = l2;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("TroopGiftPanel", 1, "toUinStr to uin err");
                continue;
                if (this.jdField_j_of_type_Int == 2) {
                  m = 7;
                } else if (this.jdField_j_of_type_Int == 6) {
                  m = 8;
                }
              }
              localObject2 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
              a(a(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject2);
            }
            m = 1;
            if (!nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
              break label1282;
            }
            m = 4;
            if ((this.jdField_a_of_type_Zsz == null) || (!this.jdField_a_of_type_Zsz.a(this.jdField_h_of_type_Int))) {
              break label1340;
            }
            if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
              break;
            }
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            if (!jdField_f_of_type_Boolean) {
              break label1311;
            }
            jdField_f_of_type_Boolean = false;
            ((bfci)((AppInterface)localObject4).getManager(113)).a(this.jdField_a_of_type_Zsy, m, a(), l1, new zto(this));
            break;
          }
          continue;
          label1340:
          if ((this.jdField_a_of_type_Zsy != null) && (this.jdField_a_of_type_Zsy.jdField_j_of_type_Int == 1) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof QQAppInterface)) && (!VipUtils.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get())))
          {
            localObject2 = new ztp(this);
            localObject2 = bfur.a(this.jdField_a_of_type_AndroidContentContext, 0, getResources().getString(2131697018), getResources().getString(2131697017), amtj.a(2131714432), amtj.a(2131714423), (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
            if (localObject2 != null) {
              ((QQCustomDialog)localObject2).show();
            }
            bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_window_view", 0, 0, "", "", "", "");
            continue;
          }
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_Zuj.b();
            c(this.jdField_d_of_type_JavaLangString);
            continue;
          }
          if ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7)) {
            c(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin);
          }
        }
        label1311:
        while (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
        {
          ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).hideGiftPanel();
          break;
          c(this.jdField_f_of_type_JavaLangString);
          continue;
          if (jdField_d_of_type_Int == this.jdField_h_of_type_Int)
          {
            if (this.jdField_c_of_type_Boolean)
            {
              this.jdField_a_of_type_Zuj.b();
              c(this.jdField_d_of_type_JavaLangString);
              break;
            }
            if ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7)) {
              c(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin);
            } else {
              c(this.jdField_f_of_type_JavaLangString);
            }
          }
        }
        if ((this.jdField_a_of_type_Zsz != null) && (this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc.jdField_c_of_type_JavaLangString)))
        {
          localObject3 = this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc.jdField_c_of_type_JavaLangString + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin == null) {
            break label1902;
          }
        }
        label1902:
        for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;; localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)
        {
          localObject2 = String.format((String)localObject3, new Object[] { localObject2 });
          localObject3 = new Intent(a(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("selfSet_leftViewText", amtj.a(2131714417));
          ((Intent)localObject3).putExtra("hide_more_button", true);
          ((Intent)localObject3).putExtra("hide_operation_bar", true);
          ((Intent)localObject3).putExtra("url", a((String)localObject2));
          a().startActivityForResult((Intent)localObject3, 12007);
          a().overridePendingTransition(2130771997, 2130772044);
          if (this.jdField_j_of_type_Int != 2) {
            break label1914;
          }
          bcef.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_pay", 0, 0, "", "", "", "");
          break;
        }
        label1914:
        if (this.jdField_j_of_type_Int == 6)
        {
          bcef.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_pay", 0, 0, "", "", "", "");
        }
        else if (this.jdField_j_of_type_Int == 7)
        {
          bcef.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_pay", 0, 0, "", "", "", "");
        }
        else if (this.jdField_k_of_type_Int >= 4)
        {
          amxb.a("gift_store", "clk_pay", a(), a() + "", "", "");
        }
        else
        {
          bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          continue;
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
          {
            i();
            continue;
            new zuc(this, a()).a();
            if (this.jdField_c_of_type_Boolean) {
              this.jdField_a_of_type_Zuj.b();
            }
            for (;;)
            {
              i1 = 1;
              m = i1;
              try
              {
                if (Build.VERSION.SDK_INT >= 23)
                {
                  m = i1;
                  if (!Settings.System.canWrite(a()))
                  {
                    m = 0;
                    QLog.i("TroopGiftPanel", 1, "can not write settings");
                  }
                }
                if (m != 0) {
                  Settings.System.putInt(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "accelerometer_rotation", 0);
                }
              }
              catch (SecurityException localSecurityException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopGiftPanel", 2, "SecurityException ");
                  }
                }
                bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
              }
              if (this.jdField_k_of_type_Int < 4) {
                break label2318;
              }
              amxb.a("gift_store", "clk_chose", a(), a() + "", "", "");
              break;
              ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).hideGiftPanel();
            }
            continue;
            e();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "sendGiftMaskBtn onClick");
    }
    if (this.jdField_a_of_type_Zsy != null) {
      if (this.jdField_a_of_type_Zsy.jdField_e_of_type_Int > 0) {
        m = this.jdField_a_of_type_Zsy.jdField_e_of_type_Int;
      }
    }
    for (;;)
    {
      bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
      if (((this.jdField_h_of_type_Int == jdField_d_of_type_Int) && (!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) && (!e())) || (!d()) || (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidWidgetButton.isEnabled())) {
        break;
      }
      QQToast.a(getContext(), 1, amtj.a(2131714434), 1).a();
      break;
      if (this.jdField_a_of_type_Zsy.jdField_a_of_type_Int > 0) {
        m = this.jdField_a_of_type_Zsy.jdField_a_of_type_Int;
      } else {
        m = 0;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((m == 1) || (m == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    zsy localzsy1;
    int m;
    if ((paramView.getTag() instanceof zsr))
    {
      localzsy1 = ((zsr)paramView.getTag()).jdField_a_of_type_Zsy;
      if ((!localzsy1.jdField_a_of_type_Boolean) && ((paramAdapterView.getAdapter() instanceof zsq)))
      {
        this.jdField_a_of_type_Zsy = localzsy1;
        localzsy1.jdField_a_of_type_Boolean = true;
        if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int)) {
          break label323;
        }
        if ((this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int))
        {
          ztf localztf = (ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
          if (localztf.jdField_b_of_type_JavaUtilArrayList != null)
          {
            m = 0;
            if (m < localztf.jdField_b_of_type_JavaUtilArrayList.size())
            {
              zsy localzsy2 = (zsy)localztf.jdField_b_of_type_JavaUtilArrayList.get(m);
              if (localzsy2.jdField_a_of_type_Int == localzsy1.jdField_a_of_type_Int) {
                this.jdField_a_of_type_Zsz.jdField_c_of_type_Int = m;
              }
              for (;;)
              {
                m += 1;
                break;
                localzsy2.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.jdField_h_of_type_Int].a();
        if (localzsy1.jdField_b_of_type_Int != 0) {
          break label607;
        }
        c(0);
        if (this.jdField_k_of_type_Int < 4) {
          break label503;
        }
        amxb.a("gift_store", "exp_chose", a(), a() + "", "", "");
      }
      label265:
      if (localzsy1.jdField_e_of_type_Int <= 0) {
        break label616;
      }
      m = localzsy1.jdField_e_of_type_Int;
    }
    for (;;)
    {
      bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_click", 0, 0, String.valueOf(m), "", "", "");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label323:
      if (this.jdField_h_of_type_Int == jdField_c_of_type_Int)
      {
        if ((this.jdField_a_of_type_Zsz.jdField_d_of_type_Int >= 0) && (this.jdField_a_of_type_Zsz.jdField_d_of_type_Int < this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList.size())) {
          ((zsy)this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Zsz.jdField_d_of_type_Int = localzsy1.jdField_g_of_type_Int;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].a();
        break;
      }
      if (this.jdField_h_of_type_Int != jdField_d_of_type_Int) {
        break;
      }
      if ((this.jdField_a_of_type_Zsz.jdField_e_of_type_Int >= 0) && (this.jdField_a_of_type_Zsz.jdField_e_of_type_Int < this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.size())) {
        ((zsy)this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_e_of_type_Int)).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Zsz.jdField_e_of_type_Int = localzsy1.jdField_g_of_type_Int;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].a();
      break;
      label503:
      if (nmy.a().a(a())) {}
      for (m = 2;; m = 1)
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      label607:
      c(8);
      break label265;
      label616:
      if (localzsy1.jdField_a_of_type_Int > 0) {
        m = localzsy1.jdField_a_of_type_Int;
      } else {
        m = 0;
      }
    }
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_h_of_type_Int = paramInt2;
    a(this.jdField_h_of_type_Int);
    Object localObject1;
    boolean bool;
    Object localObject2;
    if ((paramInt2 >= 0) && (paramInt2 < jdField_c_of_type_Int))
    {
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377037);
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376018);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376017));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376019));
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131364369);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b();
      h();
      this.jdField_a_of_type_Zsv.a(paramInt2);
      c(this.jdField_d_of_type_Boolean);
      j();
      bool = nmy.a().a(a());
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377065) instanceof TextView))
      {
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377065);
        if (!bool) {
          break label710;
        }
        localObject1 = "#878B99";
        label211:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377037) instanceof TextView))
      {
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377037);
        if (!bool) {
          break label718;
        }
        localObject1 = "#878B99";
        label265:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.jdField_a_of_type_Zsz == null) || (!this.jdField_a_of_type_Zsz.a(this.jdField_h_of_type_Int))) {
        break label740;
      }
      if (!jdField_f_of_type_Boolean) {
        break label726;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_h_of_type_JavaLangString);
      label313:
      if ((paramInt2 < 0) || (paramInt2 >= jdField_c_of_type_Int) || (this.jdField_a_of_type_Zsz == null) || (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int) || (this.jdField_a_of_type_Zsz.jdField_c_of_type_Int == -1)) {
        break label754;
      }
      if (((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.size() <= this.jdField_a_of_type_Zsz.jdField_c_of_type_Int) {
        break label1460;
      }
      localObject1 = (zsy)((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_c_of_type_Int);
    }
    for (;;)
    {
      label430:
      if (localObject1 != null) {
        if (((zsy)localObject1).jdField_b_of_type_Int == 0)
        {
          c(0);
          if (this.jdField_k_of_type_Int >= 4)
          {
            amxb.a("gift_store", "exp_chose", a(), a() + "", "", "");
            label495:
            this.jdField_a_of_type_Zsy = ((zsy)localObject1);
            if (!nmy.a().a(a())) {
              break label1009;
            }
            paramInt1 = 2;
            if ((paramInt2 < 0) || (paramInt2 >= jdField_c_of_type_Int)) {
              break label1108;
            }
            if (this.jdField_k_of_type_Int < 4) {
              break label1014;
            }
            amxb.a("gift_store", "exp_one", a(), a() + "", "", "");
            label574:
            if (!d()) {
              break label1100;
            }
            if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
              break label1095;
            }
            bool = true;
            label593:
            setSendGiftBtnEnabled(bool);
          }
        }
      }
      for (;;)
      {
        label516:
        localObject2 = "";
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Zsz != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) {
              localObject1 = ((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_a_of_type_JavaLangString;
            }
          }
        }
        bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_tab_click", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, (String)localObject1);
        return;
        this.jdField_a_of_type_Zsv.a(-1);
        break;
        label710:
        localObject1 = "#000000";
        break label211;
        label718:
        localObject1 = "#000000";
        break label265;
        label726:
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_i_of_type_JavaLangString);
        break label313;
        label740:
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
        break label313;
        label754:
        if ((paramInt2 == jdField_c_of_type_Int) && (this.jdField_a_of_type_Zsz != null) && (this.jdField_a_of_type_Zsz.jdField_d_of_type_Int != -1))
        {
          localObject1 = (zsy)this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_d_of_type_Int);
          break label430;
        }
        if ((paramInt2 != jdField_d_of_type_Int) || (this.jdField_a_of_type_Zsz == null) || (this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.size() <= 0) || (this.jdField_a_of_type_Zsz.jdField_b_of_type_AndroidUtilSparseArray.size() <= 0) || (this.jdField_a_of_type_Zsz.jdField_e_of_type_Int == -1)) {
          break label1460;
        }
        localObject1 = (zsy)this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_e_of_type_Int);
        break label430;
        if (nmy.a().a(a())) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          break;
        }
        c(8);
        break label495;
        c(8);
        break label495;
        label1009:
        paramInt1 = 1;
        break label516;
        label1014:
        bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break label574;
        label1095:
        bool = false;
        break label593;
        label1100:
        setSendGiftBtnEnabled(true);
      }
      label1108:
      if (paramInt2 == jdField_d_of_type_Int)
      {
        bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aiobag_view", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        a(new ztl(this));
        if (d())
        {
          if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (e())) {}
          for (bool = true;; bool = false)
          {
            setSendGiftBtnEnabled(bool);
            return;
          }
        }
        setSendGiftBtnEnabled(e());
        return;
      }
      if (this.jdField_k_of_type_Int >= 4)
      {
        amxb.a("gift_store", "exp_all", a(), a() + "", "", "");
        ((bfci)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(113)).a(true);
        ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379646)).a(false, false);
        setSendGiftBtnEnabled(true);
        return;
      }
      localObject2 = a();
      if (((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379646)).a()) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", paramInt1, 0, (String)localObject2, (String)localObject1, this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      label1460:
      localObject1 = null;
    }
  }
  
  public void setGiftData(zsz paramzsz, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramzsz == null) {
      return;
    }
    this.jdField_a_of_type_Zsz = paramzsz;
    Object localObject;
    int m;
    if (((!this.jdField_e_of_type_Boolean) && (paramzsz.jdField_b_of_type_JavaUtilArrayList != null) && (paramzsz.jdField_b_of_type_JavaUtilArrayList.size() > 0)) || ((paramzsz.jdField_b_of_type_JavaUtilArrayList != null) && (paramzsz.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int)))
    {
      int n = paramzsz.jdField_b_of_type_JavaUtilArrayList.size();
      this.jdField_e_of_type_Boolean = true;
      localObject = (GridListViewPager[])this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.clone();
      View[] arrayOfView = (View[])this.jdField_a_of_type_ArrayOfAndroidViewView.clone();
      if (localObject.length == jdField_d_of_type_Int + 1)
      {
        jdField_b_of_type_Int = n;
        jdField_c_of_type_Int = jdField_b_of_type_Int;
        jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
        jdField_f_of_type_Int = jdField_c_of_type_Int;
        ArrayList localArrayList = new ArrayList();
        m = 0;
        while (m < n)
        {
          zsw localzsw = new zsw();
          localzsw.jdField_a_of_type_JavaLangString = ((ztf)paramzsz.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString;
          localArrayList.add(localzsw);
          m += 1;
        }
        h();
        this.jdField_a_of_type_Zsv.a(localArrayList);
        this.jdField_a_of_type_Zsv.a(this.jdField_h_of_type_Int);
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[n + 2];
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[n + 2];
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).removeAllViews();
        m = 0;
        while (m < n)
        {
          paramzsz = new RadioViewPager(getContext());
          paramzsz.setGiftPanel(this);
          paramzsz.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(paramzsz, new RelativeLayout.LayoutParams(-1, -1));
          this.jdField_a_of_type_ArrayOfAndroidViewView[m] = paramzsz;
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m] = ((GridListViewPager)paramzsz.a());
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setOnItemClickListener(this);
          m += 1;
        }
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(arrayOfView[1], new RelativeLayout.LayoutParams(-1, -1));
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(arrayOfView[2], new RelativeLayout.LayoutParams(-1, -1));
        localObject[0].setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int] = localObject[1];
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int] = localObject[2];
        arrayOfView[0].setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_c_of_type_Int] = arrayOfView[1];
        this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int] = arrayOfView[2];
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131377037);
        this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376018);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376017));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376019));
        paramzsz = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364369);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramzsz.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131377037);
        this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131376018);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131376017));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131376019));
        this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131372207);
        paramzsz = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131364369);
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramzsz.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        m = 0;
        while (m < jdField_c_of_type_Int)
        {
          a(this.jdField_a_of_type_ArrayOfAndroidViewView[m], this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_c_of_type_Int], this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int]);
          m += 1;
        }
        onTabSelected(0, 0);
      }
    }
    a(this.jdField_a_of_type_Zsz.f);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Zsz.f != null))
    {
      paramzsz = this.jdField_a_of_type_Zsz.f.iterator();
      while (paramzsz.hasNext()) {
        if (((ztg)paramzsz.next()).jdField_a_of_type_Int == 1) {
          bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "activityTab", 0, 0, "", "", "", "");
        }
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc.jdField_b_of_type_JavaLangString))
    {
      paramzsz = this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length > jdField_c_of_type_Int)
      {
        m = 0;
        while (m < jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setGridGiftIcon(paramzsz);
          m += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setGridGiftIcon(paramzsz);
      }
    }
    if ((this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList.size() >= 1) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_Zsz.jdField_d_of_type_Int = this.jdField_a_of_type_Zsz.jdField_b_of_type_Int;
      ((zsy)this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setData(this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
      ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379646)).a(false, false);
      long l2 = System.currentTimeMillis();
      long l3 = this.jdField_a_of_type_Zsz.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Zsz.jdField_a_of_type_Boolean) && (l2 >= this.jdField_a_of_type_Zsz.jdField_a_of_type_Long) && (l2 <= l3 + 2592000000L) && (!((bfci)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(113)).a())) {
        ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379646)).a(true, false);
      }
      if ((this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc.jdField_a_of_type_JavaLangString))) {
        a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Zsz.jdField_a_of_type_Ztc.jdField_a_of_type_JavaLangString);
      }
      b(paramBoolean);
      if ((this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_Zsz.jdField_c_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList == null) {
        this.jdField_h_of_type_Int = jdField_a_of_type_Int;
      }
      if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int) || (this.jdField_a_of_type_Zsz.jdField_c_of_type_Int == -1)) {
        break label1570;
      }
      if ((this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size()))
      {
        paramzsz = ((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int)).jdField_b_of_type_JavaUtilArrayList;
        if ((paramzsz != null) && (this.jdField_a_of_type_Zsz.jdField_c_of_type_Int >= 0) && (this.jdField_a_of_type_Zsz.jdField_c_of_type_Int < paramzsz.size())) {
          this.jdField_a_of_type_Zsy = ((zsy)paramzsz.get(this.jdField_a_of_type_Zsz.jdField_c_of_type_Int));
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Zsy == null) && (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList != null) && (((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_Zsy = ((zsy)((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.get(0));
      }
      if ((this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int) || (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length <= jdField_c_of_type_Int)) {
        break label1666;
      }
      m = 0;
      while (m < jdField_c_of_type_Int)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setData(((ztf)this.jdField_a_of_type_Zsz.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_b_of_type_JavaUtilArrayList);
        m += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      break;
      label1570:
      if ((this.jdField_h_of_type_Int == jdField_c_of_type_Int) && (this.jdField_a_of_type_Zsz.jdField_d_of_type_Int != -1)) {
        this.jdField_a_of_type_Zsy = ((zsy)this.jdField_a_of_type_Zsz.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_d_of_type_Int));
      } else if ((this.jdField_h_of_type_Int == jdField_d_of_type_Int) && (this.jdField_a_of_type_Zsz.jdField_e_of_type_Int != -1)) {
        this.jdField_a_of_type_Zsy = ((zsy)this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Zsz.jdField_e_of_type_Int));
      }
    }
    label1666:
    if ((this.jdField_a_of_type_Zsy != null) && (this.jdField_a_of_type_Zsy.jdField_b_of_type_Int == 0))
    {
      c(0);
      if (this.jdField_k_of_type_Int >= 4)
      {
        amxb.a("gift_store", "exp_chose", a(), a() + "", "", "");
        if ((this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Zsz.jdField_b_of_type_AndroidUtilSparseArray.size() > 0)) {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].setData(this.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList);
        }
        a(new ztk(this, System.currentTimeMillis(), l1));
        paramBoolean = nmy.a().a(a());
        paramzsz = findViewById(2131380814);
        localObject = findViewById(2131380815);
        if (!paramBoolean) {
          break label1985;
        }
        paramzsz.setBackgroundResource(2130843793);
        ((View)localObject).setBackgroundResource(2130843795);
      }
    }
    for (;;)
    {
      h();
      if (this.jdField_a_of_type_Zsv != null) {
        this.jdField_a_of_type_Zsv.a(this.jdField_h_of_type_Int);
      }
      a(this.jdField_h_of_type_Int);
      j();
      return;
      if (nmy.a().a(a())) {}
      for (m = 2;; m = 1)
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      c(8);
      break;
      label1985:
      paramzsz.setBackgroundResource(2130843792);
      ((View)localObject).setBackgroundResource(2130843794);
    }
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_j_of_type_Int == 2) {
        bcef.b(null, "dc00899", "Grp_flower", "", "C2C", "half_mall_exp", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (this.jdField_j_of_type_Int == 6)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      amxb.a("gift_store", "exp_one", a(), a() + "", "", "");
      return;
    }
    if (nmy.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + muk.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      return;
    }
  }
  
  public void setMainAreaBackgroundColor(int paramInt)
  {
    View localView = findViewById(2131363428);
    if (localView != null) {
      localView.setBackgroundColor(paramInt);
    }
  }
  
  public void setSendGiftBtnEnabled(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "setSendGiftBtnEnabled, enabled=" + paramBoolean);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel
 * JD-Core Version:    0.7.0.1
 */