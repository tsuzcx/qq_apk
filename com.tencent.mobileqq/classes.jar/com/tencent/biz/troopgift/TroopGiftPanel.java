package com.tencent.biz.troopgift;

import abtq;
import aeqb;
import ajac;
import ajya;
import akbj;
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
import axqy;
import ayjw;
import balh;
import balr;
import bayh;
import bbdj;
import bbdv;
import bbef;
import bbgu;
import bcql;
import bcsc;
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
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mua;
import myb;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;
import xbr;
import xbt;
import xbu;
import xby;
import xbz;
import xcb;
import xcc;
import xcd;
import xcf;
import xcg;
import xch;
import xci;
import xcj;
import xck;
import xcl;
import xcm;
import xcn;
import xco;
import xcp;
import xcq;
import xcr;
import xcs;
import xct;
import xcu;
import xcv;
import xcw;
import xcx;
import xcy;
import xcz;
import xdb;
import xdg;
import xdh;
import xdi;
import ysn;
import ysp;
import yst;
import yvf;
import yxo;
import yxp;
import yzb;

public class TroopGiftPanel
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, bcsc
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
  public xby a;
  public xcb a;
  public xcc a;
  private xcz jdField_a_of_type_Xcz;
  public xdi a;
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
    this.jdField_a_of_type_JavaLangString = ajya.a(2131715424);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = ajya.a(2131715429);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new xcw(this);
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
    this.jdField_a_of_type_JavaLangString = ajya.a(2131715424);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = ajya.a(2131715429);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new xcw(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_k_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = paramInt2;
    if ((paramInt2 == 2) || (paramInt2 == 7)) {
      this.jdField_a_of_type_JavaLangString = ajya.a(2131715406);
    }
  }
  
  public TroopGiftPanel(Context paramContext, xdi paramxdi, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = ajya.a(2131715424);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = ajya.a(2131715429);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new xcw(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Xdi = paramxdi;
    this.jdField_a_of_type_JavaLangString = ajya.a(2131715414);
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
      bcql.a(a(), ajya.a(2131715412), 0).a();
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
      yxp.d("TroopGiftPanel", "VideoUrl " + localGdtMotiveVideoPageData.url);
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
          if (((ysn)localObject2).a() != null)
          {
            paramGdtAd = localObject1;
            if (((ysn)localObject2).a().a != null)
            {
              localObject2 = ((ysn)localObject2).a().a.pos_ads_info.get();
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
                          paramGdtAd = yxo.a((qq_ad_get.QQAdGetRsp.AdInfo)((List)localObject2).get(0));
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
    axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_pv", 0, 0, paramInt2 + "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "reportPlusPanelEntryExp, pageIdx=" + paramInt1 + ", aioType=" + paramInt2);
    }
  }
  
  private void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (!yzb.a(paramGdtMotiveVideoPageData.vSize))) {
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
      abtq.a(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 12008);
      return;
    }
  }
  
  private void a(ArrayList<xch> paramArrayList)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131379397);
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
        localObject1 = (xch)paramArrayList.get(m);
        if ((localObject1 != null) && (((xch)localObject1).jdField_b_of_type_Int > 0) && (((xch)localObject1).jdField_c_of_type_Int > 0) && (((xch)localObject1).jdField_b_of_type_JavaLangString.length() != 0) && (((xch)localObject1).jdField_c_of_type_JavaLangString.length() != 0)) {
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
      localRelativeLayout.setPadding(0, 0, (int)bbdv.a((Context)localObject3, f1), 0);
      localViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
      localObject3 = new LinearLayout.LayoutParams((int)bbdv.a(getContext(), ((xch)localObject1).jdField_b_of_type_Int), (int)bbdv.a(getContext(), ((xch)localObject1).jdField_c_of_type_Int));
      localObject2 = new ImageView(getContext());
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)localObject2).setBackgroundDrawable(URLDrawable.getDrawable(((xch)localObject1).jdField_b_of_type_JavaLangString, URLDrawable.URLDrawableOptions.obtain()));
      localObject1 = new xcv(this, (xch)localObject1);
      localRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      break;
    }
  }
  
  private void a(xcb paramxcb)
  {
    if (paramxcb != null)
    {
      if (paramxcb.jdField_b_of_type_Int == 0)
      {
        c(0);
        if (this.jdField_k_of_type_Int >= 4)
        {
          akbj.a("gift_store", "exp_chose", a(), a() + "", "", "");
          return;
        }
        if (myb.a().a(a())) {}
        for (int m = 2;; m = 1)
        {
          axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378200)).setText(ajya.a(2131715405));
    this.jdField_j_of_type_AndroidViewView.setContentDescription(ajya.a(2131715409));
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378200)).setTextColor(Color.parseColor("#ff878b99"));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131378199)).setText(ajya.a(2131715420));
    this.jdField_k_of_type_AndroidViewView.setContentDescription(ajya.a(2131715416));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131378199)).setTextColor(Color.parseColor("#ff878b99"));
    this.jdField_j_of_type_AndroidViewView.findViewById(2131379173).setVisibility(8);
    this.jdField_k_of_type_AndroidViewView.findViewById(2131379180).setVisibility(8);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(new xct(this));
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(new xcu(this));
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", ajya.a(2131715410));
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130771997, 2130772041);
    if (this.jdField_j_of_type_Int == 2) {
      axqy.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_opr", 0, 0, "", "", "", "");
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
        axqy.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_opr", 0, 0, "", "", "", "");
      }
      else if (this.jdField_j_of_type_Int == 7)
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_opr", 0, 0, "", "", "", "");
      }
      else
      {
        if (this.jdField_k_of_type_Int < 4) {
          break;
        }
        akbj.a("clk_oper", "clk_oper", a(), a() + "", "", "");
      }
    }
    if (myb.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      break;
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_Xcb != null) && (this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Xcc.jdField_b_of_type_AndroidUtilSparseArray.size() > 0) && (this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.size() > 0);
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
    if (this.jdField_a_of_type_Xcc == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Xcc.jdField_c_of_type_Int = 0;
      if ((this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) && (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < jdField_c_of_type_Int))
      {
        xcg localxcg = (xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
        if (localxcg.jdField_b_of_type_JavaUtilArrayList != null)
        {
          int m = 0;
          if (m < localxcg.jdField_b_of_type_JavaUtilArrayList.size())
          {
            xcb localxcb = (xcb)localxcg.jdField_b_of_type_JavaUtilArrayList.get(m);
            if (m == 0) {}
            for (boolean bool = true;; bool = false)
            {
              localxcb.jdField_a_of_type_Boolean = bool;
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
    yvf localyvf = new yvf();
    localyvf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(ajac.a().getCurrentAccountUin()), "4040385433442243");
    localyvf.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, a());
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd = new GdtMotiveVideoAd(localyvf);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd.setListener(new WeakReference(this.jdField_a_of_type_Xcz));
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
      if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof aeqb))
      {
        aeqb localaeqb = (aeqb)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if ((localaeqb.a != null) && (localaeqb.a.isBuLuoHotChat())) {
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
      return paramString.replace("$GCODE$", a()).replace("$CLIENTVER$", "android8.3.0").replace("$UIN$", localAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
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
    inflate(getContext(), 2131560339, this);
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
      paramView1.findViewById(2131371226).setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramView2.findViewById(2131371226).setVisibility(0);
      paramView2.findViewById(2131372115).setVisibility(0);
      paramView3.findViewById(2131371226).setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      paramView1 = findViewById(2131363152);
      paramView2 = paramView1.getLayoutParams();
      paramView2.height = ((int)bbdv.a(getContext(), 400.0F));
      paramView1.setLayoutParams(paramView2);
      paramView1 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      paramView2 = a();
      paramView3 = xcc.b(paramView2);
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
    paramString.setDownloadListener(new xcx(this, paramTextView));
    paramString.setBounds(0, 0, (int)bbdv.a(this.jdField_a_of_type_AndroidContentContext, 13.0F), (int)bbdv.a(this.jdField_a_of_type_AndroidContentContext, 14.0F));
    paramTextView.setCompoundDrawables(paramString, null, null, null);
    paramTextView.setCompoundDrawablePadding((int)bbdv.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
    paramString.startDownload();
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369486);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364711);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131376791));
    this.jdField_a_of_type_Xby = new xby();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Xby);
    this.jdField_j_of_type_AndroidViewView = findViewById(2131369396);
    this.jdField_k_of_type_AndroidViewView = findViewById(2131369397);
    c(paramBoolean);
    a(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363655));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131363656);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365534));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363368);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376516));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367100));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131375046).setOnClickListener(this);
    findViewById(2131363152).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new xci(this));
    h();
    this.jdField_a_of_type_Xby.a(this.jdField_h_of_type_Int);
    a(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_Xcz = new xcz(this);
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
        xcc.b(a(), paramString1);
      }
      this.jdField_f_of_type_JavaLangString = paramString1;
      this.jdField_g_of_type_JavaLangString = paramString2;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new ayjw(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new ayjw(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString2);
      paramString2 = bbef.a();
      AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppInterface != null)
      {
        paramString1 = bayh.a(localAppInterface, 1, paramString1, 3, paramString2, paramString2);
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
  
  public void a(xdg paramxdg)
  {
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, callback=" + paramxdg);
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (balh)((AppInterface)localObject).getManager(113);
    String str1 = this.jdField_b_of_type_JavaLangString;
    int n = this.jdField_g_of_type_Int;
    int i1 = this.jdField_k_of_type_Int;
    String str2 = a();
    if (this.jdField_k_of_type_Int >= 4) {}
    for (int m = 2;; m = 0)
    {
      ((balh)localObject).a(str1, n, i1, str2, 2, m, new xcy(this, paramxdg));
      return;
    }
  }
  
  public void a(xdh paramxdh)
  {
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, callback=" + paramxdh);
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {
      return;
    }
    ((balh)localAppInterface.getManager(113)).a(new xcs(this, paramxdh));
  }
  
  protected void a(boolean paramBoolean)
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
    jdField_e_of_type_Int = jdField_a_of_type_Int;
    jdField_f_of_type_Int = jdField_c_of_type_Int;
    Object localObject1 = new xbz();
    ((xbz)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131697997);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    this.jdField_a_of_type_Xby.a((List)localObject2);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    localObject1 = (RadioViewPager)findViewById(2131379153);
    localObject2 = (RadioViewPager)findViewById(2131379154);
    RadioViewPager localRadioViewPager = (RadioViewPager)findViewById(2131379155);
    ((RadioViewPager)localObject1).setGiftPanel(this);
    ((RadioViewPager)localObject2).setGiftPanel(this);
    localRadioViewPager.setGiftPanel(this);
    this.jdField_e_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131375808);
    this.jdField_f_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131374865);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RadioViewPager)localObject1).findViewById(2131374864));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((RadioViewPager)localObject1).findViewById(2131374866));
    View localView1 = ((RadioViewPager)localObject1).findViewById(2131364036);
    this.jdField_g_of_type_AndroidViewView = localRadioViewPager.findViewById(2131375808);
    this.jdField_h_of_type_AndroidViewView = localRadioViewPager.findViewById(2131374865);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localRadioViewPager.findViewById(2131374864));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localRadioViewPager.findViewById(2131374866));
    this.jdField_i_of_type_AndroidViewView = localRadioViewPager.findViewById(2131371226);
    View localView2 = localRadioViewPager.findViewById(2131364036);
    localRadioViewPager.setEmptyInfo(BaseApplication.getContext().getString(2131697800), BaseApplication.getContext().getString(2131697801));
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
  
  protected boolean a(int paramInt, balr parambalr)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_i_of_type_Int < paramInt) {
      if (parambalr != null)
      {
        bool1 = bool2;
        if (parambalr.jdField_b_of_type_Int + parambalr.jdField_c_of_type_Int != 0) {}
      }
      else
      {
        if (!myb.a().a(a())) {
          break label122;
        }
      }
    }
    label122:
    for (paramInt = 2;; paramInt = 1)
    {
      parambalr = this.jdField_a_of_type_AndroidContentContext.getResources();
      bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, parambalr.getString(2131697999), parambalr.getString(2131697998), parambalr.getString(2131690596), parambalr.getString(2131698001), new xcq(this, paramInt), new xcr(this)).show();
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
    String str2 = xcc.b(str1);
    if ((localAppInterface != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && ((localAppInterface instanceof QQAppInterface)))
    {
      ThreadManagerV2.excute(new TroopGiftPanel.5(this, localAppInterface, str1, str2, new Handler(Looper.getMainLooper())), 16, null, true);
      return;
    }
    QLog.e("TroopGiftPanel", 1, "NoSelectGiftReceiver! last receiver is not in troop, troopUin=" + str1 + ", memberUin=" + str2);
    xcc.b(str1, "");
    f();
  }
  
  public void b(int paramInt)
  {
    a("1");
    if ((this.jdField_a_of_type_Xcb != null) && (this.jdField_a_of_type_Xcb.jdField_b_of_type_Int == 0))
    {
      c(0);
      if (this.jdField_k_of_type_Int >= 4) {
        akbj.a("gift_store", "exp_chose", a(), a() + "", "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Xcc != null) {
        this.jdField_a_of_type_Xcc.jdField_c_of_type_Int = 0;
      }
      this.jdField_h_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_Xcc == null) || (this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList == null)) {
        this.jdField_h_of_type_Int = jdField_a_of_type_Int;
      }
      h();
      if (this.jdField_a_of_type_Xby != null) {
        this.jdField_a_of_type_Xby.a(this.jdField_h_of_type_Int);
      }
      onTabSelected(0, this.jdField_h_of_type_Int);
      c(this.jdField_d_of_type_Boolean);
      return;
      if (myb.a().a(a())) {}
      for (int m = 2;; m = 1)
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
      localIntent.putExtra("selfSet_leftViewText", ajya.a(2131715400));
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
      if (this.jdField_a_of_type_Xcc != null) {
        localObject = this.jdField_a_of_type_Xcc.jdField_a_of_type_Xbr;
      }
      int n;
      if (localObject != null)
      {
        str = ((xbr)localObject).jdField_a_of_type_JavaLangString;
        n = ((xbr)localObject).jdField_b_of_type_Int;
        m = ((xbr)localObject).jdField_a_of_type_Int;
        this.jdField_e_of_type_JavaLangString = ((xbr)localObject).jdField_b_of_type_JavaLangString;
        axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "panelEntryItem", 0, 0, "", "", "", "");
        localObject = str;
      }
      while ((!TextUtils.isEmpty((CharSequence)localObject)) && (n > 0) && (m > 0))
      {
        if (this.jdField_j_of_type_Int != 2) {
          break label259;
        }
        axqy.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_opr", 0, 0, "", "", "", "");
        return;
        m = i2;
        n = i1;
        localObject = str;
        if (this.jdField_a_of_type_Xcc != null)
        {
          m = i2;
          n = i1;
          localObject = str;
          if (this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcf != null)
          {
            m = i2;
            n = i1;
            localObject = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcf.jdField_a_of_type_JavaLangString))
            {
              localObject = this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcf.jdField_a_of_type_JavaLangString;
              n = 36;
              m = 36;
              this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcf.jdField_b_of_type_JavaLangString;
            }
          }
        }
      }
    }
    label259:
    if (this.jdField_j_of_type_Int == 6)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      akbj.a("gift_store", "exp_oper", a(), a() + "", "", "");
      return;
    }
    if (myb.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
    Object localObject = this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd.jdField_c_of_type_JavaLangString + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      str = String.format((String)localObject, new Object[] { str });
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("selfSet_leftViewText", ajya.a(2131715421));
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
    localObject = (balh)((AppInterface)localObject).getManager(113);
    xcb localxcb = this.jdField_a_of_type_Xcb;
    int i1 = localxcb.jdField_b_of_type_Int;
    if (localxcb.jdField_b_of_type_Int == 0) {
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
    if (myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      m = 6;
      n = i2;
      if (!myb.a().a(a())) {
        break label340;
      }
      i2 = 2;
      i4 = this.jdField_k_of_type_Int;
      str = a();
      l = Long.parseLong(paramString);
      i5 = localxcb.jdField_c_of_type_Int;
      if (localxcb.jdField_b_of_type_Int != 0) {
        break label346;
      }
    }
    label340:
    label346:
    for (int i3 = 1;; i3 = 0)
    {
      ((balh)localObject).a("OidbSvc.0x6b6", 1718, m, i4, str, 2, i1, l, i5, i3, localxcb.jdField_a_of_type_Int, n, new xcp(this, i2, localxcb), localxcb.jdField_e_of_type_Int);
      this.jdField_a_of_type_Xcb.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Xcb = null;
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
      axqy.b(null, "dc00899", "grp_lbs", str, "qq_gift", "button_click", 0, 0, paramInt + "", "", "", "");
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
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697990));
      localIntent.setFlags(603979776);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 12006);
    }
    do
    {
      return;
      localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), a(), 14);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697990));
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
    if (myb.a().a(a())) {}
    for (int m = 2; this.jdField_j_of_type_Int == 2; m = 1)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 6)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      akbj.a("gift_store", "exp_tip", a(), a() + "", "", "");
      return;
    }
    axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
  }
  
  public void onClick(View paramView)
  {
    int n;
    if (myb.a().a(a())) {
      n = 2;
    }
    label163:
    int i1;
    int m;
    switch (paramView.getId())
    {
    case 2131363368: 
    default: 
    case 2131363655: 
    case 2131375046: 
    case 2131363582: 
    case 2131368985: 
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
              akbj.a("gift_store", "clk_now", a(), a() + "", "", "");
              i1 = 0;
              m = i1;
              if (this.jdField_a_of_type_Xcb != null)
              {
                if (this.jdField_a_of_type_Xcb.jdField_e_of_type_Int <= 0) {
                  break label838;
                }
                m = this.jdField_a_of_type_Xcb.jdField_e_of_type_Int;
              }
              axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
              localObject2 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              if ((localObject2 == null) || (this.jdField_a_of_type_Xcb == null)) {
                continue;
              }
              localObject1 = this.jdField_a_of_type_Xcb;
              m = ((xcb)localObject1).jdField_b_of_type_Int;
              if (((xcb)localObject1).jdField_b_of_type_Int == 0) {
                m = b();
              }
              if ((this.jdField_h_of_type_Int != jdField_d_of_type_Int) || (!this.jdField_a_of_type_Xcb.jdField_d_of_type_Boolean)) {
                break label862;
              }
              if (jdField_c_of_type_Int != this.jdField_h_of_type_Int) {
                break label1044;
              }
              localObject2 = (balh)((AppInterface)localObject2).getManager(113);
              if (!((xcb)localObject1).jdField_b_of_type_Boolean) {
                break label954;
              }
              i2 = this.jdField_k_of_type_Int;
              paramView = a();
              i3 = ((xcb)localObject1).jdField_c_of_type_Int;
              if (((xcb)localObject1).jdField_b_of_type_Int != 0) {
                break label948;
              }
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            ((balh)localObject2).a("OidbSvc.0x6b6", 1718, 8, i2, paramView, 2, m, 0L, i3, i1, ((xcb)localObject1).jdField_a_of_type_Int, 0, new xcl(this, n, (xcb)localObject1), ((xcb)localObject1).jdField_e_of_type_Int);
            if (this.jdField_a_of_type_Xdi == null) {
              break label1503;
            }
            this.jdField_a_of_type_Xdi.b();
            return;
            axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            break label163;
            if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int)) {
              break label163;
            }
            if (this.jdField_j_of_type_Int == 2)
            {
              axqy.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_send", 0, 0, "", "", "", "");
              break label163;
            }
            if (this.jdField_j_of_type_Int == 6)
            {
              axqy.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_send", 0, 0, "", "", "", "");
              break label163;
            }
            if (this.jdField_j_of_type_Int == 7)
            {
              axqy.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_send", 0, 0, "", "", "", "");
              break label163;
            }
            if (this.jdField_k_of_type_Int >= 4)
            {
              akbj.a("gift_store", "clk_send", a(), a() + "", "", "");
              break label163;
            }
            axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            axqy.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_addpage", n, 0, a(), "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()), "", "");
            break label163;
            m = i1;
            if (this.jdField_a_of_type_Xcb.jdField_a_of_type_Int <= 0) {
              break label194;
            }
            m = this.jdField_a_of_type_Xcb.jdField_a_of_type_Int;
            break label194;
            boolean bool = this.jdField_a_of_type_Xcc.a(this.jdField_h_of_type_Int);
            paramView = this.jdField_a_of_type_Xcc.jdField_a_of_type_AndroidUtilSparseArray;
            if (((xcb)localObject1).jdField_e_of_type_Int != 0) {}
            for (i1 = ((xcb)localObject1).jdField_e_of_type_Int;; i1 = ((xcb)localObject1).jdField_a_of_type_Int)
            {
              paramView = (balr)paramView.get(i1);
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
            ((balh)localObject2).a(paramView, i1, n, this.jdField_k_of_type_Int, a(), 2, m, 1, ((xcb)localObject1).jdField_a_of_type_Int, new xcm(this, (xcb)localObject1));
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
              if (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                break label1251;
              }
              m = 4;
              if ((this.jdField_a_of_type_Xcc == null) || (!this.jdField_a_of_type_Xcc.a(this.jdField_h_of_type_Int))) {
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
              ((balh)((AppInterface)localObject2).getManager(113)).a(this.jdField_a_of_type_Xcb, m, a(), l1, new xcn(this));
              return;
            }
            if ((this.jdField_a_of_type_Xcb != null) && (this.jdField_a_of_type_Xcb.jdField_j_of_type_Int == 1) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof QQAppInterface)) && (!VipUtils.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get())))
            {
              paramView = new xco(this);
              paramView = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 0, getResources().getString(2131697803), getResources().getString(2131697802), ajya.a(2131715426), ajya.a(2131715417), paramView, paramView);
              if (paramView != null) {
                paramView.show();
              }
              axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_window_view", 0, 0, "", "", "", "");
              return;
            }
            if (this.jdField_c_of_type_Boolean)
            {
              this.jdField_a_of_type_Xdi.b();
              c(this.jdField_d_of_type_JavaLangString);
              return;
            }
            if ((this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7)) {
              c(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
          }
          while (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
          {
            ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).aU();
            return;
            c(this.jdField_f_of_type_JavaLangString);
            continue;
            if (jdField_d_of_type_Int == this.jdField_h_of_type_Int)
            {
              if (this.jdField_c_of_type_Boolean)
              {
                this.jdField_a_of_type_Xdi.b();
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
        if ((this.jdField_a_of_type_Xcc != null) && (this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd.jdField_c_of_type_JavaLangString)))
        {
          localObject1 = this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd.jdField_c_of_type_JavaLangString + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString == null) {
            break label1847;
          }
        }
        for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
        {
          paramView = String.format((String)localObject1, new Object[] { paramView });
          localObject1 = new Intent(a(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("selfSet_leftViewText", ajya.a(2131715411));
          ((Intent)localObject1).putExtra("hide_more_button", true);
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("url", a(paramView));
          a().startActivityForResult((Intent)localObject1, 12007);
          a().overridePendingTransition(2130771997, 2130772041);
          if (this.jdField_j_of_type_Int != 2) {
            break;
          }
          axqy.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_j_of_type_Int == 6)
        {
          axqy.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_j_of_type_Int == 7)
        {
          axqy.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_k_of_type_Int >= 4)
        {
          akbj.a("gift_store", "clk_pay", a(), a() + "", "", "");
          return;
        }
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        return;
      } while (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString));
      i();
      return;
    case 2131365534: 
    case 2131365535: 
      label1029:
      label1036:
      label1044:
      label1305:
      label1847:
      new xdb(this, a()).a();
      label1280:
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Xdi.b();
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
          axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", n, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          return;
        }
        if (this.jdField_k_of_type_Int < 4) {
          break;
        }
        akbj.a("gift_store", "clk_chose", a(), a() + "", "", "");
        return;
        ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).aU();
      }
    case 2131375864: 
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
    if (this.jdField_a_of_type_Xcb != null) {
      if (this.jdField_a_of_type_Xcb.jdField_e_of_type_Int > 0) {
        m = this.jdField_a_of_type_Xcb.jdField_e_of_type_Int;
      }
    }
    for (;;)
    {
      axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
      if (((this.jdField_h_of_type_Int == jdField_d_of_type_Int) && (!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) && (!e())) || (!d()) || (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidWidgetButton.isEnabled())) {
        break;
      }
      bcql.a(getContext(), 1, ajya.a(2131715428), 1).a();
      return;
      if (this.jdField_a_of_type_Xcb.jdField_a_of_type_Int > 0) {
        m = this.jdField_a_of_type_Xcb.jdField_a_of_type_Int;
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
    if ((paramView.getTag() instanceof xbu))
    {
      paramView = ((xbu)paramView.getTag()).jdField_a_of_type_Xcb;
      if ((!paramView.jdField_a_of_type_Boolean) && ((paramAdapterView.getAdapter() instanceof xbt)))
      {
        this.jdField_a_of_type_Xcb = paramView;
        paramView.jdField_a_of_type_Boolean = true;
        if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int)) {
          break label292;
        }
        if ((this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int))
        {
          paramAdapterView = (xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
          if (paramAdapterView.jdField_b_of_type_JavaUtilArrayList != null)
          {
            paramInt = 0;
            if (paramInt < paramAdapterView.jdField_b_of_type_JavaUtilArrayList.size())
            {
              xcb localxcb = (xcb)paramAdapterView.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
              if (localxcb.jdField_a_of_type_Int == paramView.jdField_a_of_type_Int) {
                this.jdField_a_of_type_Xcc.jdField_c_of_type_Int = paramInt;
              }
              for (;;)
              {
                paramInt += 1;
                break;
                localxcb.jdField_a_of_type_Boolean = false;
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
        akbj.a("gift_store", "exp_chose", a(), a() + "", "", "");
      }
      label249:
      if (paramView.jdField_e_of_type_Int <= 0) {
        break label580;
      }
      paramInt = paramView.jdField_e_of_type_Int;
    }
    for (;;)
    {
      axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_click", 0, 0, String.valueOf(paramInt), "", "", "");
      return;
      label292:
      if (this.jdField_h_of_type_Int == jdField_c_of_type_Int)
      {
        if ((this.jdField_a_of_type_Xcc.jdField_d_of_type_Int >= 0) && (this.jdField_a_of_type_Xcc.jdField_d_of_type_Int < this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList.size())) {
          ((xcb)this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Xcc.jdField_d_of_type_Int = paramView.jdField_g_of_type_Int;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].a();
        break;
      }
      if (this.jdField_h_of_type_Int != jdField_d_of_type_Int) {
        break;
      }
      if ((this.jdField_a_of_type_Xcc.jdField_e_of_type_Int >= 0) && (this.jdField_a_of_type_Xcc.jdField_e_of_type_Int < this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.size())) {
        ((xcb)this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_e_of_type_Int)).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Xcc.jdField_e_of_type_Int = paramView.jdField_g_of_type_Int;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].a();
      break;
      label470:
      if (myb.a().a(a())) {}
      for (paramInt = 2;; paramInt = 1)
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375808);
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131374865);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131374864));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131374866));
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131364036);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b();
      h();
      this.jdField_a_of_type_Xby.a(paramInt2);
      c(this.jdField_d_of_type_Boolean);
      j();
      bool = myb.a().a(a());
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375832) instanceof TextView))
      {
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375832);
        if (!bool) {
          break label710;
        }
        localObject1 = "#878B99";
        label211:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375808) instanceof TextView))
      {
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131375808);
        if (!bool) {
          break label718;
        }
        localObject1 = "#878B99";
        label265:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.jdField_a_of_type_Xcc == null) || (!this.jdField_a_of_type_Xcc.a(this.jdField_h_of_type_Int))) {
        break label740;
      }
      if (!jdField_f_of_type_Boolean) {
        break label726;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_h_of_type_JavaLangString);
      label313:
      if ((paramInt2 < 0) || (paramInt2 >= jdField_c_of_type_Int) || (this.jdField_a_of_type_Xcc == null) || (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int) || (this.jdField_a_of_type_Xcc.jdField_c_of_type_Int == -1)) {
        break label754;
      }
      if (((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.size() <= this.jdField_a_of_type_Xcc.jdField_c_of_type_Int) {
        break label1460;
      }
      localObject1 = (xcb)((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_c_of_type_Int);
    }
    for (;;)
    {
      label430:
      if (localObject1 != null) {
        if (((xcb)localObject1).jdField_b_of_type_Int == 0)
        {
          c(0);
          if (this.jdField_k_of_type_Int >= 4)
          {
            akbj.a("gift_store", "exp_chose", a(), a() + "", "", "");
            label495:
            this.jdField_a_of_type_Xcb = ((xcb)localObject1);
            if (!myb.a().a(a())) {
              break label1009;
            }
            paramInt1 = 2;
            if ((paramInt2 < 0) || (paramInt2 >= jdField_c_of_type_Int)) {
              break label1108;
            }
            if (this.jdField_k_of_type_Int < 4) {
              break label1014;
            }
            akbj.a("gift_store", "exp_one", a(), a() + "", "", "");
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
        if (this.jdField_a_of_type_Xcc != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) {
              localObject1 = ((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_a_of_type_JavaLangString;
            }
          }
        }
        axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_tab_click", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, (String)localObject1);
        return;
        this.jdField_a_of_type_Xby.a(-1);
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
        if ((paramInt2 == jdField_c_of_type_Int) && (this.jdField_a_of_type_Xcc != null) && (this.jdField_a_of_type_Xcc.jdField_d_of_type_Int != -1))
        {
          localObject1 = (xcb)this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_d_of_type_Int);
          break label430;
        }
        if ((paramInt2 != jdField_d_of_type_Int) || (this.jdField_a_of_type_Xcc == null) || (this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.size() <= 0) || (this.jdField_a_of_type_Xcc.jdField_b_of_type_AndroidUtilSparseArray.size() <= 0) || (this.jdField_a_of_type_Xcc.jdField_e_of_type_Int == -1)) {
          break label1460;
        }
        localObject1 = (xcb)this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_e_of_type_Int);
        break label430;
        if (myb.a().a(a())) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
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
        axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aiobag_view", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        a(new xck(this));
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
        akbj.a("gift_store", "exp_all", a(), a() + "", "", "");
        ((balh)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(113)).a(true);
        ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378200)).a(false, false);
        setSendGiftBtnEnabled(true);
        return;
      }
      localObject2 = a();
      if (((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378200)).a()) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", paramInt1, 0, (String)localObject2, (String)localObject1, this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      label1460:
      localObject1 = null;
    }
  }
  
  public void setGiftData(xcc paramxcc, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramxcc == null) {
      return;
    }
    this.jdField_a_of_type_Xcc = paramxcc;
    Object localObject;
    int m;
    if (((!this.jdField_e_of_type_Boolean) && (paramxcc.jdField_b_of_type_JavaUtilArrayList != null) && (paramxcc.jdField_b_of_type_JavaUtilArrayList.size() > 0)) || ((paramxcc.jdField_b_of_type_JavaUtilArrayList != null) && (paramxcc.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int)))
    {
      int n = paramxcc.jdField_b_of_type_JavaUtilArrayList.size();
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
          xbz localxbz = new xbz();
          localxbz.jdField_a_of_type_JavaLangString = ((xcg)paramxcc.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString;
          localArrayList.add(localxbz);
          m += 1;
        }
        h();
        this.jdField_a_of_type_Xby.a(localArrayList);
        this.jdField_a_of_type_Xby.a(this.jdField_h_of_type_Int);
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[n + 2];
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[n + 2];
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).removeAllViews();
        m = 0;
        while (m < n)
        {
          paramxcc = new RadioViewPager(getContext());
          paramxcc.setGiftPanel(this);
          paramxcc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(paramxcc, new RelativeLayout.LayoutParams(-1, -1));
          this.jdField_a_of_type_ArrayOfAndroidViewView[m] = paramxcc;
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m] = ((GridListViewPager)paramxcc.a());
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
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131375808);
        this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131374865);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131374864));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131374866));
        paramxcc = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364036);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramxcc.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131375808);
        this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131374865);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131374864));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131374866));
        this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131371226);
        paramxcc = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131364036);
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramxcc.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        m = 0;
        while (m < jdField_c_of_type_Int)
        {
          a(this.jdField_a_of_type_ArrayOfAndroidViewView[m], this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_c_of_type_Int], this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int]);
          m += 1;
        }
        onTabSelected(0, 0);
      }
    }
    a(this.jdField_a_of_type_Xcc.f);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Xcc.f != null))
    {
      paramxcc = this.jdField_a_of_type_Xcc.f.iterator();
      while (paramxcc.hasNext()) {
        if (((xch)paramxcc.next()).jdField_a_of_type_Int == 1) {
          axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "activityTab", 0, 0, "", "", "", "");
        }
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd.jdField_b_of_type_JavaLangString))
    {
      paramxcc = this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length > jdField_c_of_type_Int)
      {
        m = 0;
        while (m < jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setGridGiftIcon(paramxcc);
          m += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setGridGiftIcon(paramxcc);
      }
    }
    if ((this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList.size() >= 1) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_Xcc.jdField_d_of_type_Int = this.jdField_a_of_type_Xcc.jdField_b_of_type_Int;
      ((xcb)this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setData(this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
      ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378200)).a(false, false);
      long l2 = System.currentTimeMillis();
      long l3 = this.jdField_a_of_type_Xcc.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Xcc.jdField_a_of_type_Boolean) && (l2 >= this.jdField_a_of_type_Xcc.jdField_a_of_type_Long) && (l2 <= l3 + 2592000000L) && (!((balh)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(113)).a())) {
        ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378200)).a(true, false);
      }
      if ((this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd.jdField_a_of_type_JavaLangString))) {
        a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Xcc.jdField_a_of_type_Xcd.jdField_a_of_type_JavaLangString);
      }
      b(paramBoolean);
      if ((this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_Xcc.jdField_c_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList == null) {
        this.jdField_h_of_type_Int = jdField_a_of_type_Int;
      }
      if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= jdField_c_of_type_Int) || (this.jdField_a_of_type_Xcc.jdField_c_of_type_Int == -1)) {
        break label1570;
      }
      if ((this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size()))
      {
        paramxcc = ((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int)).jdField_b_of_type_JavaUtilArrayList;
        if ((paramxcc != null) && (this.jdField_a_of_type_Xcc.jdField_c_of_type_Int >= 0) && (this.jdField_a_of_type_Xcc.jdField_c_of_type_Int < paramxcc.size())) {
          this.jdField_a_of_type_Xcb = ((xcb)paramxcc.get(this.jdField_a_of_type_Xcc.jdField_c_of_type_Int));
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Xcb == null) && (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList != null) && (((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_Xcb = ((xcb)((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.get(0));
      }
      if ((this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int) || (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length <= jdField_c_of_type_Int)) {
        break label1666;
      }
      m = 0;
      while (m < jdField_c_of_type_Int)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setData(((xcg)this.jdField_a_of_type_Xcc.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_b_of_type_JavaUtilArrayList);
        m += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      break;
      label1570:
      if ((this.jdField_h_of_type_Int == jdField_c_of_type_Int) && (this.jdField_a_of_type_Xcc.jdField_d_of_type_Int != -1)) {
        this.jdField_a_of_type_Xcb = ((xcb)this.jdField_a_of_type_Xcc.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_d_of_type_Int));
      } else if ((this.jdField_h_of_type_Int == jdField_d_of_type_Int) && (this.jdField_a_of_type_Xcc.jdField_e_of_type_Int != -1)) {
        this.jdField_a_of_type_Xcb = ((xcb)this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Xcc.jdField_e_of_type_Int));
      }
    }
    label1666:
    if ((this.jdField_a_of_type_Xcb != null) && (this.jdField_a_of_type_Xcb.jdField_b_of_type_Int == 0))
    {
      c(0);
      if (this.jdField_k_of_type_Int >= 4)
      {
        akbj.a("gift_store", "exp_chose", a(), a() + "", "", "");
        if ((this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Xcc.jdField_b_of_type_AndroidUtilSparseArray.size() > 0)) {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].setData(this.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList);
        }
        a(new xcj(this, System.currentTimeMillis(), l1));
        paramBoolean = myb.a().a(a());
        paramxcc = findViewById(2131379196);
        localObject = findViewById(2131379197);
        if (!paramBoolean) {
          break label1985;
        }
        paramxcc.setBackgroundResource(2130843155);
        ((View)localObject).setBackgroundResource(2130843157);
      }
    }
    for (;;)
    {
      h();
      if (this.jdField_a_of_type_Xby != null) {
        this.jdField_a_of_type_Xby.a(this.jdField_h_of_type_Int);
      }
      a(this.jdField_h_of_type_Int);
      j();
      return;
      if (myb.a().a(a())) {}
      for (m = 2;; m = 1)
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      c(8);
      break;
      label1985:
      paramxcc.setBackgroundResource(2130843154);
      ((View)localObject).setBackgroundResource(2130843156);
    }
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_j_of_type_Int == 2) {
        axqy.b(null, "dc00899", "Grp_flower", "", "C2C", "half_mall_exp", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (this.jdField_j_of_type_Int == 6)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_j_of_type_Int == 7)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      akbj.a("gift_store", "exp_one", a(), a() + "", "", "");
      return;
    }
    if (myb.a().a(a())) {}
    for (int m = 2;; m = 1)
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", m, 0, a(), "", this.jdField_c_of_type_JavaLangString, "" + mua.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      return;
    }
  }
  
  public void setMainAreaBackgroundColor(int paramInt)
  {
    View localView = findViewById(2131363152);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel
 * JD-Core Version:    0.7.0.1
 */