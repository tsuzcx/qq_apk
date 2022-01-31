package com.tencent.biz.troopgift;

import aaie;
import aaig;
import aaik;
import aaky;
import aano;
import aanp;
import aapa;
import adky;
import agmy;
import akro;
import alpo;
import alsy;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import azmj;
import bahs;
import bcju;
import bcke;
import bcxb;
import bdcd;
import bdcq;
import bdda;
import bdfq;
import berl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mwu;
import nav;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;
import yqk;
import yqm;
import yqn;
import yqr;
import yqs;
import yqu;
import yqv;
import yqw;
import yqy;
import yqz;
import yra;
import yrb;
import yrc;
import yrd;
import yre;
import yrf;
import yrg;
import yrh;
import yri;
import yrj;
import yrk;
import yrl;
import yrm;
import yrn;
import yro;
import yrp;
import yrq;
import yrr;
import yrs;
import yru;
import yrz;
import ysa;
import ysb;

public class TroopGiftPanel
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, berl
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
  public yqr a;
  public yqu a;
  public yqv a;
  private yrs jdField_a_of_type_Yrs;
  public ysb a;
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
    this.jdField_a_of_type_JavaLangString = alpo.a(2131715796);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = alpo.a(2131715801);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new yrp(this);
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
    this.jdField_a_of_type_JavaLangString = alpo.a(2131715796);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = alpo.a(2131715801);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new yrp(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_k_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = paramInt2;
    if ((paramInt2 == 2) || (paramInt2 == 7)) {
      this.jdField_a_of_type_JavaLangString = alpo.a(2131715778);
    }
  }
  
  public TroopGiftPanel(Context paramContext, ysb paramysb, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = alpo.a(2131715796);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = alpo.a(2131715801);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new yrp(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Ysb = paramysb;
    this.jdField_a_of_type_JavaLangString = alpo.a(2131715786);
    this.jdField_k_of_type_Int = 1;
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
      QQToast.a(a(), alpo.a(2131715784), 0).a();
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
      aanp.d("TroopGiftPanel", "VideoUrl " + localGdtMotiveVideoPageData.url);
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
          if (((aaie)localObject2).a() != null)
          {
            paramGdtAd = localObject1;
            if (((aaie)localObject2).a().a != null)
            {
              localObject2 = ((aaie)localObject2).a().a.pos_ads_info.get();
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
                          paramGdtAd = aano.a((qq_ad_get.QQAdGetRsp.AdInfo)((List)localObject2).get(0));
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
          break label541;
        }
      }
      label541:
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
    azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_pv", 0, 0, paramInt2 + "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "reportPlusPanelEntryExp, pageIdx=" + paramInt1 + ", aioType=" + paramInt2);
    }
  }
  
  private void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (!aapa.a(paramGdtMotiveVideoPageData.vSize))) {
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
      adky.a(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 12008);
      return;
    }
  }
  
  private void a(ArrayList<yra> paramArrayList)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131380112);
    localViewGroup.removeAllViews();
    localViewGroup.setBackgroundColor(0);
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    int m;
    Object localObject1;
    for (;;)
    {
      return;
      m = 0;
      while (m < paramArrayList.size())
      {
        localObject1 = (yra)paramArrayList.get(m);
        if ((localObject1 != null) && (((yra)localObject1).jdField_b_of_type_Int > 0) && (((yra)localObject1).jdField_c_of_type_Int > 0) && (((yra)localObject1).jdField_b_of_type_JavaLangString.length() != 0) && (((yra)localObject1).jdField_c_of_type_JavaLangString.length() != 0)) {
          break label105;
        }
        m += 1;
      }
    }
    label105:
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject3 = getContext();
    if (m == paramArrayList.size() - 1) {}
    for (float f1 = 10.0F;; f1 = 6.0F)
    {
      localRelativeLayout.setPadding(0, 0, (int)bdcq.a((Context)localObject3, f1), 0);
      localViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
      localObject3 = new LinearLayout.LayoutParams((int)bdcq.a(getContext(), ((yra)localObject1).jdField_b_of_type_Int), (int)bdcq.a(getContext(), ((yra)localObject1).jdField_c_of_type_Int));
      localObject2 = new ImageView(getContext());
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)localObject2).setBackgroundDrawable(URLDrawable.getDrawable(((yra)localObject1).jdField_b_of_type_JavaLangString, URLDrawable.URLDrawableOptions.obtain()));
      localObject1 = new yro(this, (yra)localObject1);
      localRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      break;
    }
  }
  
  private void a(yqu paramyqu)
  {
    if (paramyqu != null)
    {
      if (paramyqu.jdField_b_of_type_Int == 0)
      {
        c(0);
        if (this.jdField_k_of_type_Int >= 4)
        {
          alsy.a("gift_store", "exp_chose", a(), a() + "", "", "");
          return;
        }
        if (nav.a().a(a())) {}
        for (int m = 2;; m = 1)
        {
          azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          return;
        }
      }
      c(8);
      return;
    }
    c(8);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_j_of_type_AndroidViewView == null) {
      return;
    }
    h();
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378766)).setText(alpo.a(2131715777));
    this.jdField_j_of_type_AndroidViewView.setContentDescription(alpo.a(2131715781));
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378766)).setTextColor(Color.parseColor("#ff878b99"));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131378765)).setText(alpo.a(2131715792));
    this.jdField_k_of_type_AndroidViewView.setContentDescription(alpo.a(2131715788));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131378765)).setTextColor(Color.parseColor("#ff878b99"));
    this.jdField_j_of_type_AndroidViewView.findViewById(2131379871).setVisibility(8);
    this.jdField_k_of_type_AndroidViewView.findViewById(2131379880).setVisibility(8);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(new yrm(this));
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(new yrn(this));
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", alpo.a(2131715782));
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130771997, 2130772041);
    if (this.jdField_j_of_type_Int == 2) {
      azmj.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_opr", 0, 0, "", "", "", "");
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
        azmj.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_opr", 0, 0, "", "", "", "");
      }
      else if (this.jdField_j_of_type_Int == 7)
      {
        azmj.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_opr", 0, 0, "", "", "", "");
      }
      else
      {
        if (this.jdField_k_of_type_Int < 4) {
          break;
        }
        alsy.a("clk_oper", "clk_oper", a(), a() + "", "", "");
      }
    }
    if (nav.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      break;
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_Yqu != null) && (this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Yqv.jdField_b_of_type_AndroidUtilSparseArray.size() > 0) && (this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.size() > 0);
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
    if (this.jdField_a_of_type_Yqv == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Yqv.jdField_c_of_type_Int = 0;
      if ((this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) && (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < jdField_c_of_type_Int))
      {
        yqz localyqz = (yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
        if (localyqz.jdField_b_of_type_JavaUtilArrayList != null)
        {
          int m = 0;
          if (m < localyqz.jdField_b_of_type_JavaUtilArrayList.size())
          {
            yqu localyqu = (yqu)localyqz.jdField_b_of_type_JavaUtilArrayList.get(m);
            if (m == 0) {}
            for (boolean bool = true;; bool = false)
            {
              localyqu.jdField_a_of_type_Boolean = bool;
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
    aaky localaaky = new aaky();
    localaaky.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(akro.a().getCurrentAccountUin()), "4040385433442243");
    localaaky.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, a());
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd = new GdtMotiveVideoAd(localaaky);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd.setListener(new WeakReference(this.jdField_a_of_type_Yrs));
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
      if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof agmy))
      {
        agmy localagmy = (agmy)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if ((localagmy.a != null) && (localagmy.a.isBuLuoHotChat())) {
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
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
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
      return paramString.replace("$GCODE$", a()).replace("$CLIENTVER$", "android8.3.3").replace("$UIN$", localAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
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
    inflate(getContext(), 2131560447, this);
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
      paramView1.findViewById(2131371538).setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramView2.findViewById(2131371538).setVisibility(0);
      paramView2.findViewById(2131372433).setVisibility(0);
      paramView3.findViewById(2131371538).setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      paramView1 = findViewById(2131363189);
      paramView2 = paramView1.getLayoutParams();
      paramView2.height = ((int)bdcq.a(getContext(), 400.0F));
      paramView1.setLayoutParams(paramView2);
      paramView1 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      paramView2 = a();
      paramView3 = yqv.b(paramView2);
      if ((paramView1 != null) && (!TextUtils.isEmpty(paramView3)) && (!TextUtils.isEmpty(paramView2)) && ((paramView1 instanceof QQAppInterface))) {
        ThreadManagerV2.excute(new TroopGiftPanel.6(this, paramView1, paramView2, paramView3, new Handler(Looper.getMainLooper())), 16, null, true);
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
    paramString.setDownloadListener(new yrq(this, paramTextView));
    paramString.setBounds(0, 0, (int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 13.0F), (int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 14.0F));
    paramTextView.setCompoundDrawables(paramString, null, null, null);
    paramTextView.setCompoundDrawablePadding((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
    paramString.startDownload();
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369748);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364790);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131377304));
    this.jdField_a_of_type_Yqr = new yqr();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Yqr);
    this.jdField_j_of_type_AndroidViewView = findViewById(2131369645);
    this.jdField_k_of_type_AndroidViewView = findViewById(2131369646);
    c(paramBoolean);
    a(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363708));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131363709);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365619));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363407);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377016));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367227));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131375527).setOnClickListener(this);
    findViewById(2131363189).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new yrb(this));
    h();
    this.jdField_a_of_type_Yqr.a(this.jdField_h_of_type_Int);
    a(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_Yrs = new yrs(this);
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
        yqv.b(a(), paramString1);
      }
      this.jdField_f_of_type_JavaLangString = paramString1;
      this.jdField_g_of_type_JavaLangString = paramString2;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new bahs(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new bahs(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString2);
      paramString2 = bdda.a();
      AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppInterface != null)
      {
        paramString1 = bcxb.a(localAppInterface, 1, paramString1, 3, paramString2, paramString2);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        break label248;
      }
    }
    for (;;)
    {
      setSendGiftBtnEnabled(bool);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString2);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString2);
      break;
      label248:
      bool = false;
    }
  }
  
  public void a(yrz paramyrz)
  {
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, callback=" + paramyrz);
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (bcju)((AppInterface)localObject).getManager(113);
    String str1 = this.jdField_b_of_type_JavaLangString;
    int n = this.jdField_g_of_type_Int;
    int i1 = this.jdField_k_of_type_Int;
    String str2 = a();
    if (this.jdField_k_of_type_Int >= 4) {}
    for (int m = 2;; m = 0)
    {
      ((bcju)localObject).a(str1, n, i1, str2, 2, m, new yrr(this, paramyrz));
      return;
    }
  }
  
  public void a(ysa paramysa)
  {
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, callback=" + paramysa);
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {
      return;
    }
    ((bcju)localAppInterface.getManager(113)).a(new yrl(this, paramysa));
  }
  
  protected void a(boolean paramBoolean)
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
    jdField_e_of_type_Int = jdField_a_of_type_Int;
    jdField_f_of_type_Int = jdField_c_of_type_Int;
    Object localObject1 = new yqs();
    ((yqs)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131698174);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    this.jdField_a_of_type_Yqr.a((List)localObject2);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    localObject1 = (RadioViewPager)findViewById(2131379849);
    localObject2 = (RadioViewPager)findViewById(2131379850);
    RadioViewPager localRadioViewPager = (RadioViewPager)findViewById(2131379851);
    ((RadioViewPager)localObject1).setGiftPanel(this);
    ((RadioViewPager)localObject2).setGiftPanel(this);
    localRadioViewPager.setGiftPanel(this);
    this.jdField_e_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131376305);
    this.jdField_f_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131375333);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RadioViewPager)localObject1).findViewById(2131375332));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((RadioViewPager)localObject1).findViewById(2131375334));
    View localView1 = ((RadioViewPager)localObject1).findViewById(2131364097);
    this.jdField_g_of_type_AndroidViewView = localRadioViewPager.findViewById(2131376305);
    this.jdField_h_of_type_AndroidViewView = localRadioViewPager.findViewById(2131375333);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localRadioViewPager.findViewById(2131375332));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localRadioViewPager.findViewById(2131375334));
    this.jdField_i_of_type_AndroidViewView = localRadioViewPager.findViewById(2131371538);
    View localView2 = localRadioViewPager.findViewById(2131364097);
    localRadioViewPager.setEmptyInfo(BaseApplication.getContext().getString(2131697977), BaseApplication.getContext().getString(2131697978));
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
  
  protected boolean a(int paramInt, bcke parambcke)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_i_of_type_Int < paramInt) {
      if (parambcke != null)
      {
        bool1 = bool2;
        if (parambcke.jdField_b_of_type_Int + parambcke.jdField_c_of_type_Int != 0) {}
      }
      else
      {
        if (!nav.a().a(a())) {
          break label122;
        }
      }
    }
    label122:
    for (paramInt = 2;; paramInt = 1)
    {
      parambcke = this.jdField_a_of_type_AndroidContentContext.getResources();
      bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, parambcke.getString(2131698176), parambcke.getString(2131698175), parambcke.getString(2131690648), parambcke.getString(2131698178), new yrj(this, paramInt), new yrk(this)).show();
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
    String str2 = yqv.b(str1);
    if ((localAppInterface != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && ((localAppInterface instanceof QQAppInterface)))
    {
      ThreadManagerV2.excute(new TroopGiftPanel.5(this, localAppInterface, str1, str2, new Handler(Looper.getMainLooper())), 16, null, true);
      return;
    }
    QLog.e("TroopGiftPanel", 1, "NoSelectGiftReceiver! last receiver is not in troop, troopUin=" + str1 + ", memberUin=" + str2);
    yqv.b(str1, "");
    f();
  }
  
  public void b(int paramInt)
  {
    a("1");
    if ((this.jdField_a_of_type_Yqu != null) && (this.jdField_a_of_type_Yqu.jdField_b_of_type_Int == 0))
    {
      c(0);
      if (this.jdField_k_of_type_Int >= 4) {
        alsy.a("gift_store", "exp_chose", a(), a() + "", "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Yqv != null) {
        this.jdField_a_of_type_Yqv.jdField_c_of_type_Int = 0;
      }
      this.jdField_h_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_Yqv == null) || (this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList == null)) {
        this.jdField_h_of_type_Int = jdField_a_of_type_Int;
      }
      h();
      if (this.jdField_a_of_type_Yqr != null) {
        this.jdField_a_of_type_Yqr.a(this.jdField_h_of_type_Int);
      }
      onTabSelected(0, this.jdField_h_of_type_Int);
      c(this.jdField_d_of_type_Boolean);
      return;
      if (nav.a().a(a())) {}
      for (int m = 2;; m = 1)
      {
        azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      c(8);
    }
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString);
    if (paramString.contains("?")) {}
    for (paramString = paramString + "&troop_uin=" + a();; paramString = paramString + "?troop_uin=" + a())
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("selfSet_leftViewText", alpo.a(2131715772));
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
      if (this.jdField_a_of_type_Yqv != null) {
        localObject = this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqk;
      }
      int n;
      if (localObject != null)
      {
        str = ((yqk)localObject).jdField_a_of_type_JavaLangString;
        n = ((yqk)localObject).jdField_b_of_type_Int;
        m = ((yqk)localObject).jdField_a_of_type_Int;
        this.jdField_e_of_type_JavaLangString = ((yqk)localObject).jdField_b_of_type_JavaLangString;
        azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "panelEntryItem", 0, 0, "", "", "", "");
        localObject = str;
      }
      while ((!TextUtils.isEmpty((CharSequence)localObject)) && (n > 0) && (m > 0))
      {
        if (this.jdField_j_of_type_Int != 2) {
          break label259;
        }
        azmj.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_opr", 0, 0, "", "", "", "");
        return;
        m = i2;
        n = i1;
        localObject = str;
        if (this.jdField_a_of_type_Yqv != null)
        {
          m = i2;
          n = i1;
          localObject = str;
          if (this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqy != null)
          {
            m = i2;
            n = i1;
            localObject = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqy.jdField_a_of_type_JavaLangString))
            {
              localObject = this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqy.jdField_a_of_type_JavaLangString;
              n = 36;
              m = 36;
              this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqy.jdField_b_of_type_JavaLangString;
            }
          }
        }
      }
    }
    label259:
    if (this.jdField_j_of_type_Int == 6)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      alsy.a("gift_store", "exp_oper", a(), a() + "", "", "");
      return;
    }
    if (nav.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
    Object localObject = this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw.jdField_c_of_type_JavaLangString + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      str = String.format((String)localObject, new Object[] { str });
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("selfSet_leftViewText", alpo.a(2131715793));
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
    localObject = (bcju)((AppInterface)localObject).getManager(113);
    yqu localyqu = this.jdField_a_of_type_Yqu;
    int i1 = localyqu.jdField_b_of_type_Int;
    if (localyqu.jdField_b_of_type_Int == 0) {
      i1 = b();
    }
    int m = 0;
    int i2 = 0;
    int n;
    label139:
    int i4;
    String str;
    long l;
    int i5;
    if (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      m = 6;
      n = i2;
      if (!nav.a().a(a())) {
        break label340;
      }
      i2 = 2;
      i4 = this.jdField_k_of_type_Int;
      str = a();
      l = Long.parseLong(paramString);
      i5 = localyqu.jdField_c_of_type_Int;
      if (localyqu.jdField_b_of_type_Int != 0) {
        break label346;
      }
    }
    label340:
    label346:
    for (int i3 = 1;; i3 = 0)
    {
      ((bcju)localObject).a("OidbSvc.0x6b6", 1718, m, i4, str, 2, i1, l, i5, i3, localyqu.jdField_a_of_type_Int, n, new yri(this, i2, localyqu), localyqu.jdField_e_of_type_Int);
      this.jdField_a_of_type_Yqu.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Yqu = null;
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
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
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
        break label139;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      azmj.b(null, "dc00899", "grp_lbs", str, "qq_gift", "button_click", 0, 0, paramInt + "", "", "", "");
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
      localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 16);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131698167));
      localIntent.setFlags(603979776);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 12006);
    }
    do
    {
      return;
      localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), a(), 14);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131698167));
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
    if (nav.a().a(a())) {}
    for (int m = 2; this.jdField_j_of_type_Int == 2; m = 1)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 6)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      alsy.a("gift_store", "exp_tip", a(), a() + "", "", "");
      return;
    }
    azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
  }
  
  public void onClick(View paramView)
  {
    int n;
    if (nav.a().a(a())) {
      n = 2;
    }
    label163:
    int i1;
    int m;
    switch (paramView.getId())
    {
    case 2131363407: 
    default: 
    case 2131363708: 
    case 2131375527: 
    case 2131363627: 
    case 2131369215: 
      do
      {
        Object localObject1;
        for (;;)
        {
          return;
          n = 1;
          break;
          Object localObject2;
          int i2;
          int i3;
          if (jdField_c_of_type_Int == this.jdField_h_of_type_Int) {
            if (this.jdField_k_of_type_Int >= 4)
            {
              alsy.a("gift_store", "clk_now", a(), a() + "", "", "");
              i1 = 0;
              m = i1;
              if (this.jdField_a_of_type_Yqu != null)
              {
                if (this.jdField_a_of_type_Yqu.jdField_e_of_type_Int <= 0) {
                  break label838;
                }
                m = this.jdField_a_of_type_Yqu.jdField_e_of_type_Int;
              }
              azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
              localObject2 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              if ((localObject2 == null) || (this.jdField_a_of_type_Yqu == null)) {
                continue;
              }
              localObject1 = this.jdField_a_of_type_Yqu;
              m = ((yqu)localObject1).jdField_b_of_type_Int;
              if (((yqu)localObject1).jdField_b_of_type_Int == 0) {
                m = b();
              }
              if ((this.jdField_h_of_type_Int != jdField_d_of_type_Int) || (!this.jdField_a_of_type_Yqu.jdField_d_of_type_Boolean)) {
                break label862;
              }
              if (jdField_c_of_type_Int != this.jdField_h_of_type_Int) {
                break label1044;
              }
              localObject2 = (bcju)((AppInterface)localObject2).getManager(113);
              if (!((yqu)localObject1).jdField_b_of_type_Boolean) {
                break label954;
              }
              i2 = this.jdField_k_of_type_Int;
              paramView = a();
              i3 = ((yqu)localObject1).jdField_c_of_type_Int;
              if (((yqu)localObject1).jdField_b_of_type_Int != 0) {
                break label948;
              }
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            ((bcju)localObject2).a("OidbSvc.0x6b6", 1718, 8, i2, paramView, 2, m, 0L, i3, i1, ((yqu)localObject1).jdField_a_of_type_Int, 0, new yre(this, n, (yqu)localObject1), ((yqu)localObject1).jdField_e_of_type_Int);
            if (this.jdField_a_of_type_Ysb == null) {
              break label1503;
            }
            this.jdField_a_of_type_Ysb.b();
            return;
            azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            break label163;
            if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int)) {
              break label163;
            }
            if (this.jdField_j_of_type_Int == 2)
            {
              azmj.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_send", 0, 0, "", "", "", "");
              break label163;
            }
            if (this.jdField_j_of_type_Int == 6)
            {
              azmj.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_send", 0, 0, "", "", "", "");
              break label163;
            }
            if (this.jdField_j_of_type_Int == 7)
            {
              azmj.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_send", 0, 0, "", "", "", "");
              break label163;
            }
            if (this.jdField_k_of_type_Int >= 4)
            {
              alsy.a("gift_store", "clk_send", a(), a() + "", "", "");
              break label163;
            }
            azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            azmj.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_addpage", n, 0, a(), "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()), "", "");
            break label163;
            m = i1;
            if (this.jdField_a_of_type_Yqu.jdField_a_of_type_Int <= 0) {
              break label194;
            }
            m = this.jdField_a_of_type_Yqu.jdField_a_of_type_Int;
            break label194;
            boolean bool = this.jdField_a_of_type_Yqv.a(this.jdField_h_of_type_Int);
            paramView = this.jdField_a_of_type_Yqv.jdField_a_of_type_AndroidUtilSparseArray;
            if (((yqu)localObject1).jdField_e_of_type_Int != 0) {}
            for (i1 = ((yqu)localObject1).jdField_e_of_type_Int;; i1 = ((yqu)localObject1).jdField_a_of_type_Int)
            {
              paramView = (bcke)paramView.get(i1);
              if ((bool) || (a(m, paramView))) {
                break label293;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("TroopGiftPanel", 2, "isStorageEnough: false");
              return;
            }
          }
          if (this.jdField_a_of_type_Boolean)
          {
            n = 3;
            if (!this.jdField_a_of_type_Boolean) {
              break label1029;
            }
            paramView = "OidbSvc.0x7f6";
            if (!this.jdField_a_of_type_Boolean) {
              break label1036;
            }
          }
          for (i1 = 2038;; i1 = 1718)
          {
            ((bcju)localObject2).a(paramView, i1, n, this.jdField_k_of_type_Int, a(), 2, m, 1, ((yqu)localObject1).jdField_a_of_type_Int, new yrf(this, (yqu)localObject1));
            break;
            n = 1;
            break label963;
            paramView = "OidbSvc.0x6b6";
            break label974;
          }
          if ((this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < jdField_c_of_type_Int))
          {
            if (this.jdField_c_of_type_Boolean)
            {
              paramView = this.jdField_d_of_type_JavaLangString;
              return;
            }
            if ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7)) {}
            for (paramView = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramView = this.jdField_f_of_type_JavaLangString)
            {
              long l1 = 0L;
              try
              {
                long l2 = Long.valueOf(paramView).longValue();
                l1 = l2;
              }
              catch (Exception paramView)
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
                paramView = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
                a(a(), GdtMotiveVideoFragment.class, paramView);
                return;
              }
              m = 1;
              if (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                break label1251;
              }
              m = 4;
              if ((this.jdField_a_of_type_Yqv == null) || (!this.jdField_a_of_type_Yqv.a(this.jdField_h_of_type_Int))) {
                break label1305;
              }
              if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
                break;
              }
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              if (!jdField_f_of_type_Boolean) {
                break label1280;
              }
              jdField_f_of_type_Boolean = false;
              ((bcju)((AppInterface)localObject2).getManager(113)).a(this.jdField_a_of_type_Yqu, m, a(), l1, new yrg(this));
              return;
            }
            if ((this.jdField_a_of_type_Yqu != null) && (this.jdField_a_of_type_Yqu.jdField_j_of_type_Int == 1) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof QQAppInterface)) && (!VipUtils.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get())))
            {
              paramView = new yrh(this);
              paramView = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 0, getResources().getString(2131697980), getResources().getString(2131697979), alpo.a(2131715798), alpo.a(2131715789), paramView, paramView);
              if (paramView != null) {
                paramView.show();
              }
              azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_window_view", 0, 0, "", "", "", "");
              return;
            }
            if (this.jdField_c_of_type_Boolean)
            {
              this.jdField_a_of_type_Ysb.b();
              c(this.jdField_d_of_type_JavaLangString);
              return;
            }
            if ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7)) {
              c(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
          }
          while (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
          {
            ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).aW();
            return;
            c(this.jdField_f_of_type_JavaLangString);
            continue;
            if (jdField_d_of_type_Int == this.jdField_h_of_type_Int)
            {
              if (this.jdField_c_of_type_Boolean)
              {
                this.jdField_a_of_type_Ysb.b();
                c(this.jdField_d_of_type_JavaLangString);
                return;
              }
              if ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7)) {
                c(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              } else {
                c(this.jdField_f_of_type_JavaLangString);
              }
            }
          }
        }
        if ((this.jdField_a_of_type_Yqv != null) && (this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw.jdField_c_of_type_JavaLangString)))
        {
          localObject1 = this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw.jdField_c_of_type_JavaLangString + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString == null) {
            break label1847;
          }
        }
        for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
        {
          paramView = String.format((String)localObject1, new Object[] { paramView });
          localObject1 = new Intent(a(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("selfSet_leftViewText", alpo.a(2131715783));
          ((Intent)localObject1).putExtra("hide_more_button", true);
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("url", a(paramView));
          a().startActivityForResult((Intent)localObject1, 12007);
          a().overridePendingTransition(2130771997, 2130772041);
          if (this.jdField_j_of_type_Int != 2) {
            break;
          }
          azmj.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_j_of_type_Int == 6)
        {
          azmj.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_j_of_type_Int == 7)
        {
          azmj.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_k_of_type_Int >= 4)
        {
          alsy.a("gift_store", "clk_pay", a(), a() + "", "", "");
          return;
        }
        azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        return;
      } while (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString));
      i();
      return;
    case 2131365619: 
    case 2131365620: 
      label1029:
      label1036:
      label1044:
      label1305:
      label1847:
      new yru(this, a()).a();
      label1280:
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Ysb.b();
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
        catch (SecurityException paramView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopGiftPanel", 2, "SecurityException ");
            }
          }
          azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          return;
        }
        if (this.jdField_k_of_type_Int < 4) {
          break;
        }
        alsy.a("gift_store", "clk_chose", a(), a() + "", "", "");
        return;
        ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).aW();
      }
    case 2131376363: 
      label194:
      label838:
      label862:
      label1251:
      e();
      label293:
      label948:
      label954:
      label963:
      label974:
      label1503:
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "sendGiftMaskBtn onClick");
    }
    if (this.jdField_a_of_type_Yqu != null) {
      if (this.jdField_a_of_type_Yqu.jdField_e_of_type_Int > 0) {
        m = this.jdField_a_of_type_Yqu.jdField_e_of_type_Int;
      }
    }
    for (;;)
    {
      azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
      if (((this.jdField_h_of_type_Int == jdField_d_of_type_Int) && (!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) && (!e())) || (!d()) || (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidWidgetButton.isEnabled())) {
        break;
      }
      QQToast.a(getContext(), 1, alpo.a(2131715800), 1).a();
      return;
      if (this.jdField_a_of_type_Yqu.jdField_a_of_type_Int > 0) {
        m = this.jdField_a_of_type_Yqu.jdField_a_of_type_Int;
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
    if ((paramView.getTag() instanceof yqn))
    {
      paramView = ((yqn)paramView.getTag()).jdField_a_of_type_Yqu;
      if ((!paramView.jdField_a_of_type_Boolean) && ((paramAdapterView.getAdapter() instanceof yqm)))
      {
        this.jdField_a_of_type_Yqu = paramView;
        paramView.jdField_a_of_type_Boolean = true;
        if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int)) {
          break label292;
        }
        if ((this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int))
        {
          paramAdapterView = (yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
          if (paramAdapterView.jdField_b_of_type_JavaUtilArrayList != null)
          {
            paramInt = 0;
            if (paramInt < paramAdapterView.jdField_b_of_type_JavaUtilArrayList.size())
            {
              yqu localyqu = (yqu)paramAdapterView.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
              if (localyqu.jdField_a_of_type_Int == paramView.jdField_a_of_type_Int) {
                this.jdField_a_of_type_Yqv.jdField_c_of_type_Int = paramInt;
              }
              for (;;)
              {
                paramInt += 1;
                break;
                localyqu.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.jdField_h_of_type_Int].a();
        if (paramView.jdField_b_of_type_Int != 0) {
          break label571;
        }
        c(0);
        if (this.jdField_k_of_type_Int < 4) {
          break label470;
        }
        alsy.a("gift_store", "exp_chose", a(), a() + "", "", "");
      }
      label249:
      if (paramView.jdField_e_of_type_Int <= 0) {
        break label580;
      }
      paramInt = paramView.jdField_e_of_type_Int;
    }
    for (;;)
    {
      azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_click", 0, 0, String.valueOf(paramInt), "", "", "");
      return;
      label292:
      if (this.jdField_h_of_type_Int == jdField_c_of_type_Int)
      {
        if ((this.jdField_a_of_type_Yqv.jdField_d_of_type_Int >= 0) && (this.jdField_a_of_type_Yqv.jdField_d_of_type_Int < this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList.size())) {
          ((yqu)this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Yqv.jdField_d_of_type_Int = paramView.jdField_g_of_type_Int;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].a();
        break;
      }
      if (this.jdField_h_of_type_Int != jdField_d_of_type_Int) {
        break;
      }
      if ((this.jdField_a_of_type_Yqv.jdField_e_of_type_Int >= 0) && (this.jdField_a_of_type_Yqv.jdField_e_of_type_Int < this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.size())) {
        ((yqu)this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_e_of_type_Int)).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Yqv.jdField_e_of_type_Int = paramView.jdField_g_of_type_Int;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].a();
      break;
      label470:
      if (nav.a().a(a())) {}
      for (paramInt = 2;; paramInt = 1)
      {
        azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      label571:
      c(8);
      break label249;
      label580:
      if (paramView.jdField_a_of_type_Int > 0) {
        paramInt = paramView.jdField_a_of_type_Int;
      } else {
        paramInt = 0;
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
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376305);
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375333);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375332));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375334));
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131364097);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b();
      h();
      this.jdField_a_of_type_Yqr.a(paramInt2);
      c(this.jdField_d_of_type_Boolean);
      j();
      bool = nav.a().a(a());
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376331) instanceof TextView))
      {
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376331);
        if (!bool) {
          break label710;
        }
        localObject1 = "#878B99";
        label211:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376305) instanceof TextView))
      {
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376305);
        if (!bool) {
          break label718;
        }
        localObject1 = "#878B99";
        label265:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.jdField_a_of_type_Yqv == null) || (!this.jdField_a_of_type_Yqv.a(this.jdField_h_of_type_Int))) {
        break label740;
      }
      if (!jdField_f_of_type_Boolean) {
        break label726;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_h_of_type_JavaLangString);
      label313:
      if ((paramInt2 < 0) || (paramInt2 >= jdField_c_of_type_Int) || (this.jdField_a_of_type_Yqv == null) || (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int) || (this.jdField_a_of_type_Yqv.jdField_c_of_type_Int == -1)) {
        break label754;
      }
      if (((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.size() <= this.jdField_a_of_type_Yqv.jdField_c_of_type_Int) {
        break label1460;
      }
      localObject1 = (yqu)((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_c_of_type_Int);
    }
    for (;;)
    {
      label430:
      if (localObject1 != null) {
        if (((yqu)localObject1).jdField_b_of_type_Int == 0)
        {
          c(0);
          if (this.jdField_k_of_type_Int >= 4)
          {
            alsy.a("gift_store", "exp_chose", a(), a() + "", "", "");
            label495:
            this.jdField_a_of_type_Yqu = ((yqu)localObject1);
            if (!nav.a().a(a())) {
              break label1009;
            }
            paramInt1 = 2;
            if ((paramInt2 < 0) || (paramInt2 >= jdField_c_of_type_Int)) {
              break label1108;
            }
            if (this.jdField_k_of_type_Int < 4) {
              break label1014;
            }
            alsy.a("gift_store", "exp_one", a(), a() + "", "", "");
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
        if (this.jdField_a_of_type_Yqv != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) {
              localObject1 = ((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_a_of_type_JavaLangString;
            }
          }
        }
        azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_tab_click", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, (String)localObject1);
        return;
        this.jdField_a_of_type_Yqr.a(-1);
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
        if ((paramInt2 == jdField_c_of_type_Int) && (this.jdField_a_of_type_Yqv != null) && (this.jdField_a_of_type_Yqv.jdField_d_of_type_Int != -1))
        {
          localObject1 = (yqu)this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_d_of_type_Int);
          break label430;
        }
        if ((paramInt2 != jdField_d_of_type_Int) || (this.jdField_a_of_type_Yqv == null) || (this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.size() <= 0) || (this.jdField_a_of_type_Yqv.jdField_b_of_type_AndroidUtilSparseArray.size() <= 0) || (this.jdField_a_of_type_Yqv.jdField_e_of_type_Int == -1)) {
          break label1460;
        }
        localObject1 = (yqu)this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_e_of_type_Int);
        break label430;
        if (nav.a().a(a())) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
        azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
        azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aiobag_view", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        a(new yrd(this));
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
        alsy.a("gift_store", "exp_all", a(), a() + "", "", "");
        ((bcju)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(113)).a(true);
        ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378766)).a(false, false);
        setSendGiftBtnEnabled(true);
        return;
      }
      localObject2 = a();
      if (((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378766)).a()) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", paramInt1, 0, (String)localObject2, (String)localObject1, this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      label1460:
      localObject1 = null;
    }
  }
  
  public void setGiftData(yqv paramyqv, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramyqv == null) {
      return;
    }
    this.jdField_a_of_type_Yqv = paramyqv;
    Object localObject;
    int m;
    if (((!this.jdField_e_of_type_Boolean) && (paramyqv.jdField_b_of_type_JavaUtilArrayList != null) && (paramyqv.jdField_b_of_type_JavaUtilArrayList.size() > 0)) || ((paramyqv.jdField_b_of_type_JavaUtilArrayList != null) && (paramyqv.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int)))
    {
      int n = paramyqv.jdField_b_of_type_JavaUtilArrayList.size();
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
          yqs localyqs = new yqs();
          localyqs.jdField_a_of_type_JavaLangString = ((yqz)paramyqv.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString;
          localArrayList.add(localyqs);
          m += 1;
        }
        h();
        this.jdField_a_of_type_Yqr.a(localArrayList);
        this.jdField_a_of_type_Yqr.a(this.jdField_h_of_type_Int);
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[n + 2];
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[n + 2];
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).removeAllViews();
        m = 0;
        while (m < n)
        {
          paramyqv = new RadioViewPager(getContext());
          paramyqv.setGiftPanel(this);
          paramyqv.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(paramyqv, new RelativeLayout.LayoutParams(-1, -1));
          this.jdField_a_of_type_ArrayOfAndroidViewView[m] = paramyqv;
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m] = ((GridListViewPager)paramyqv.a());
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
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376305);
        this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131375333);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131375332));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131375334));
        paramyqv = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364097);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramyqv.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131376305);
        this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131375333);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131375332));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131375334));
        this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131371538);
        paramyqv = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131364097);
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramyqv.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        m = 0;
        while (m < jdField_c_of_type_Int)
        {
          a(this.jdField_a_of_type_ArrayOfAndroidViewView[m], this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_c_of_type_Int], this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int]);
          m += 1;
        }
        onTabSelected(0, 0);
      }
    }
    a(this.jdField_a_of_type_Yqv.f);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Yqv.f != null))
    {
      paramyqv = this.jdField_a_of_type_Yqv.f.iterator();
      while (paramyqv.hasNext()) {
        if (((yra)paramyqv.next()).jdField_a_of_type_Int == 1) {
          azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "activityTab", 0, 0, "", "", "", "");
        }
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw.jdField_b_of_type_JavaLangString))
    {
      paramyqv = this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length > jdField_c_of_type_Int)
      {
        m = 0;
        while (m < jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setGridGiftIcon(paramyqv);
          m += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setGridGiftIcon(paramyqv);
      }
    }
    if ((this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList.size() >= 1) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_Yqv.jdField_d_of_type_Int = this.jdField_a_of_type_Yqv.jdField_b_of_type_Int;
      ((yqu)this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setData(this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
      ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378766)).a(false, false);
      long l2 = System.currentTimeMillis();
      long l3 = this.jdField_a_of_type_Yqv.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Yqv.jdField_a_of_type_Boolean) && (l2 >= this.jdField_a_of_type_Yqv.jdField_a_of_type_Long) && (l2 <= l3 + 2592000000L) && (!((bcju)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(113)).a())) {
        ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378766)).a(true, false);
      }
      if ((this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw.jdField_a_of_type_JavaLangString))) {
        a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Yqv.jdField_a_of_type_Yqw.jdField_a_of_type_JavaLangString);
      }
      b(paramBoolean);
      if ((this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_Yqv.jdField_c_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList == null) {
        this.jdField_h_of_type_Int = jdField_a_of_type_Int;
      }
      if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int) || (this.jdField_a_of_type_Yqv.jdField_c_of_type_Int == -1)) {
        break label1570;
      }
      if ((this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size()))
      {
        paramyqv = ((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int)).jdField_b_of_type_JavaUtilArrayList;
        if ((paramyqv != null) && (this.jdField_a_of_type_Yqv.jdField_c_of_type_Int >= 0) && (this.jdField_a_of_type_Yqv.jdField_c_of_type_Int < paramyqv.size())) {
          this.jdField_a_of_type_Yqu = ((yqu)paramyqv.get(this.jdField_a_of_type_Yqv.jdField_c_of_type_Int));
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Yqu == null) && (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList != null) && (((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_Yqu = ((yqu)((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.get(0));
      }
      if ((this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int) || (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length <= jdField_c_of_type_Int)) {
        break label1666;
      }
      m = 0;
      while (m < jdField_c_of_type_Int)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setData(((yqz)this.jdField_a_of_type_Yqv.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_b_of_type_JavaUtilArrayList);
        m += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      break;
      label1570:
      if ((this.jdField_h_of_type_Int == jdField_c_of_type_Int) && (this.jdField_a_of_type_Yqv.jdField_d_of_type_Int != -1)) {
        this.jdField_a_of_type_Yqu = ((yqu)this.jdField_a_of_type_Yqv.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_d_of_type_Int));
      } else if ((this.jdField_h_of_type_Int == jdField_d_of_type_Int) && (this.jdField_a_of_type_Yqv.jdField_e_of_type_Int != -1)) {
        this.jdField_a_of_type_Yqu = ((yqu)this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Yqv.jdField_e_of_type_Int));
      }
    }
    label1666:
    if ((this.jdField_a_of_type_Yqu != null) && (this.jdField_a_of_type_Yqu.jdField_b_of_type_Int == 0))
    {
      c(0);
      if (this.jdField_k_of_type_Int >= 4)
      {
        alsy.a("gift_store", "exp_chose", a(), a() + "", "", "");
        if ((this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Yqv.jdField_b_of_type_AndroidUtilSparseArray.size() > 0)) {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].setData(this.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList);
        }
        a(new yrc(this, System.currentTimeMillis(), l1));
        paramBoolean = nav.a().a(a());
        paramyqv = findViewById(2131379896);
        localObject = findViewById(2131379897);
        if (!paramBoolean) {
          break label1985;
        }
        paramyqv.setBackgroundResource(2130843339);
        ((View)localObject).setBackgroundResource(2130843341);
      }
    }
    for (;;)
    {
      h();
      if (this.jdField_a_of_type_Yqr != null) {
        this.jdField_a_of_type_Yqr.a(this.jdField_h_of_type_Int);
      }
      a(this.jdField_h_of_type_Int);
      j();
      return;
      if (nav.a().a(a())) {}
      for (m = 2;; m = 1)
      {
        azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      c(8);
      break;
      label1985:
      paramyqv.setBackgroundResource(2130843338);
      ((View)localObject).setBackgroundResource(2130843340);
    }
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_j_of_type_Int == 2) {
        azmj.b(null, "dc00899", "Grp_flower", "", "C2C", "half_mall_exp", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (this.jdField_j_of_type_Int == 6)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      alsy.a("gift_store", "exp_one", a(), a() + "", "", "");
      return;
    }
    if (nav.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      return;
    }
  }
  
  public void setMainAreaBackgroundColor(int paramInt)
  {
    View localView = findViewById(2131363189);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel
 * JD-Core Version:    0.7.0.1
 */