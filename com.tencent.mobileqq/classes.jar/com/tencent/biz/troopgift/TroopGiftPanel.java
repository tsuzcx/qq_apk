package com.tencent.biz.troopgift;

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
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
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
import mqq.app.AppRuntime;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class TroopGiftPanel
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, TabBarView.OnTabChangeListener
{
  public static int a = 0;
  public static int b = 1;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  private static boolean f;
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  protected View.OnClickListener a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected TroopExclusiveGiftAdapter a;
  protected TroopGiftAioItemData a;
  protected TroopGiftAioPanelData a;
  private TroopGiftPanel.FreeGiftGdtAdListener jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$FreeGiftGdtAdListener;
  protected TroopGiftPanel.OnShowOrHideListerner a;
  private com.tencent.gdtad.api.GdtAd jdField_a_of_type_ComTencentGdtadApiGdtAd;
  private GdtMotiveVideoAd jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoAd;
  protected SessionInfo a;
  protected HorizontalListView a;
  public String a;
  protected WeakReference<AppInterface> a;
  protected boolean a;
  protected View[] a;
  protected GridListViewPager[] a;
  protected View b;
  protected ImageView b;
  protected TextView b;
  protected String b;
  protected WeakReference<BaseChatPie> b;
  protected boolean b;
  protected View c;
  protected TextView c;
  protected String c;
  protected boolean c;
  protected View d;
  protected TextView d;
  protected String d;
  protected boolean d;
  protected View e;
  protected TextView e;
  protected String e;
  private boolean e;
  protected View f;
  protected String f;
  protected int g;
  protected View g;
  protected String g;
  protected int h;
  protected View h;
  private String h;
  protected int i;
  protected View i;
  private String i;
  protected int j;
  private View j;
  protected int k;
  private View k;
  
  static
  {
    jdField_c_of_type_Int = jdField_b_of_type_Int;
    int m = jdField_c_of_type_Int;
    jdField_d_of_type_Int = m + 1;
    jdField_e_of_type_Int = jdField_a_of_type_Int;
    jdField_f_of_type_Int = m;
    jdField_f_of_type_Boolean = false;
  }
  
  public TroopGiftPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715195);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131715200);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopGiftPanel.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_k_of_type_Int = 1;
  }
  
  public TroopGiftPanel(Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715195);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131715200);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopGiftPanel.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner = paramOnShowOrHideListerner;
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715185);
    this.jdField_k_of_type_Int = 1;
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this(paramContext, paramBaseChatPie, 1, 0);
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715195);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_g_of_type_Int = 1731;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131715200);
    this.jdField_i_of_type_JavaLangString = "看广告0元送";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopGiftPanel.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_k_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = paramInt2;
    if ((paramInt2 == 2) || (paramInt2 == 7)) {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715177);
    }
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
    if (paramString.length() <= 2) {
      f1 = 9.0F;
    } else {
      f1 = 7.5F;
    }
    ((Paint)localObject2).setTextSize(DisplayUtils.a(paramContext, f1));
    ((Paint)localObject2).setStrokeWidth(1.0F);
    ((Paint)localObject2).setShadowLayer(0.5F, 0.4F, 0.0F, -12303292);
    if (paramString.length() > 4)
    {
      paramContext = paramString.substring(0, (paramString.length() + 1) / 2);
      paramString = paramString.substring((paramString.length() + 1) / 2);
      localRect1 = new Rect();
      Rect localRect2 = new Rect();
      ((Paint)localObject2).getTextBounds(paramContext, 0, paramContext.length(), localRect1);
      ((Paint)localObject2).getTextBounds(paramString, 0, paramString.length(), localRect2);
      f1 = (paramBitmap.getWidth() - localRect1.width()) / 2;
      f2 = (paramBitmap.getHeight() - localRect1.height() - localRect2.height() - 4.0F) / 2.0F + localRect1.height() - 1.0F;
      ((Canvas)localObject1).drawText(paramContext, f1 - 1.0F, f2, (Paint)localObject2);
      ((Canvas)localObject1).drawText(paramString, (paramBitmap.getWidth() - localRect2.width()) / 2 - 1.0F, f2 + localRect2.height() + 4.0F - 1.0F, (Paint)localObject2);
      return paramBitmap;
    }
    Rect localRect1 = new Rect();
    ((Paint)localObject2).getTextBounds(paramString, 0, paramString.length(), localRect1);
    float f1 = DisplayUtils.a(paramContext, 4.0F);
    float f2 = paramBitmap.getWidth() - localRect1.width();
    if (paramString.length() > 2) {
      f1 = f2 / 2.0F;
    } else {
      f1 = f2 - f1;
    }
    ((Canvas)localObject1).drawText(paramString, f1, localRect1.height() + (paramBitmap.getHeight() - localRect1.height()) / 2 - 1.0F, (Paint)localObject2);
    return paramBitmap;
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
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = null;
    Object localObject1 = null;
    if ((paramGdtAd != null) && (paramGdtAd.isLoaded()) && (!paramGdtAd.isInvalidated()) && ((paramGdtAd instanceof GdtMotiveVideoAd)))
    {
      Object localObject2 = (GdtMotiveVideoAd)paramGdtAd;
      com.tencent.gdtad.aditem.GdtAd localGdtAd = ((GdtMotiveVideoAd)localObject2).getAd();
      paramGdtAd = localGdtMotiveVideoPageData;
      if (localGdtAd != null)
      {
        localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
        localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
        if (paramBoolean) {
          paramInt1 = localGdtAd.getCreativeSize();
        }
        localGdtMotiveVideoPageData.vSize = paramInt1;
        localGdtMotiveVideoPageData.screenOrientation = paramInt2;
        localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
        localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
        localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
        paramGdtAd = new StringBuilder();
        paramGdtAd.append("VideoUrl ");
        paramGdtAd.append(localGdtMotiveVideoPageData.url);
        GdtLog.d("TroopGiftPanel", paramGdtAd.toString());
        if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
          localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
        }
        paramGdtAd = localGdtAd.getImageData();
        String str = "";
        if (paramGdtAd == null) {
          paramGdtAd = "";
        } else {
          paramGdtAd = localGdtAd.getImageData().jdField_a_of_type_JavaLangString;
        }
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
        localGdtMotiveVideoPageData.bottomCardUrl = localGdtAd.getBottomCardUrl();
        localGdtMotiveVideoPageData.bottomCardLoadTime = localGdtAd.getBottomCardLoadTime();
        localObject2 = ((GdtMotiveVideoAd)localObject2).getGdtAdLoader();
        paramGdtAd = localObject1;
        if (localObject2 != null)
        {
          paramGdtAd = localObject1;
          if (((GdtAdLoader)localObject2).a() != null)
          {
            paramGdtAd = localObject1;
            if (((GdtAdLoader)localObject2).a().a != null)
            {
              localObject2 = ((GdtAdLoader)localObject2).a().a.pos_ads_info.get();
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
                          paramGdtAd = GdtJsonPbUtil.a((qq_ad_get.QQAdGetRsp.AdInfo)((List)localObject2).get(0));
                        }
                      }
                    }
                  }
                }
              }
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
        localGdtMotiveVideoPageData.refId = "biz_src_hdsp_liwu";
        paramGdtAd = localGdtMotiveVideoPageData;
      }
      return paramGdtAd;
    }
    paramGdtAd = new StringBuilder();
    paramGdtAd.append(String.format("mockMVPageData null %d", new Object[] { Integer.valueOf(paramInt1) }));
    paramGdtAd.append(paramInt2);
    QLog.i("TroopGiftPanel", 1, paramGdtAd.toString());
    QQToast.a(a(), HardCodeUtil.a(2131715183), 0).a();
    return null;
  }
  
  private LottieImageAsset a(Map<String, LottieImageAsset> paramMap, String paramString)
  {
    if (paramMap != null)
    {
      if (paramMap.size() <= 0) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_pv", 0, 0, localStringBuilder.toString(), "", "", "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportPlusPanelEntryExp, pageIdx=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", aioType=");
      localStringBuilder.append(paramInt2);
      QLog.d("TroopGiftPanel", 2, localStringBuilder.toString());
    }
  }
  
  private void a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramActivity != null) && (paramGdtMotiveVideoPageData != null))
    {
      if (!GdtUIUtils.a(paramGdtMotiveVideoPageData.vSize)) {
        return;
      }
      ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(paramActivity, paramGdtMotiveVideoPageData, 12008));
    }
  }
  
  private void a(ViewGroup paramViewGroup, TroopGiftAioPanelData.WebPanelItemInfo paramWebPanelItemInfo)
  {
    SharePreferenceUtils.a(a(), "AIO_ACTIVITY_SHOW_TIME", String.valueOf(System.currentTimeMillis()));
    TroopGiftAioPanelData.AioActivityBubble localAioActivityBubble = paramWebPanelItemInfo.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$AioActivityBubble;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)DisplayUtils.a(getContext(), localAioActivityBubble.jdField_a_of_type_Int), (int)DisplayUtils.a(getContext(), localAioActivityBubble.jdField_b_of_type_Int));
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(a());
    paramViewGroup.addView(localDiniFlyAnimationView, localLayoutParams);
    localDiniFlyAnimationView.setAnimationFromUrl(localAioActivityBubble.jdField_a_of_type_JavaLangString);
    localDiniFlyAnimationView.addLottieOnCompositionLoadedListener(new TroopGiftPanel.5(this, localAioActivityBubble));
    localDiniFlyAnimationView.setOnClickListener(new TroopGiftPanel.6(this, localAioActivityBubble, paramWebPanelItemInfo, localDiniFlyAnimationView));
    localDiniFlyAnimationView.playAnimation();
  }
  
  private void a(TroopGiftAioItemData paramTroopGiftAioItemData)
  {
    if (paramTroopGiftAioItemData != null)
    {
      if (paramTroopGiftAioItemData.jdField_b_of_type_Int == 0)
      {
        c(0);
        if (this.jdField_k_of_type_Int >= 4)
        {
          paramTroopGiftAioItemData = a();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(a());
          ((StringBuilder)localObject).append("");
          NearbyFlowerManager.a("gift_store", "exp_chose", paramTroopGiftAioItemData, ((StringBuilder)localObject).toString(), "", "");
          return;
        }
        int m;
        if (AnonymousChatHelper.a().a(a())) {
          m = 2;
        } else {
          m = 1;
        }
        paramTroopGiftAioItemData = a();
        Object localObject = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, paramTroopGiftAioItemData, "", (String)localObject, localStringBuilder.toString());
        return;
      }
      c(8);
      return;
    }
    c(8);
  }
  
  private void a(LottieComposition paramLottieComposition, TroopGiftAioPanelData.AioActivityBubble paramAioActivityBubble)
  {
    paramAioActivityBubble = paramAioActivityBubble.jdField_a_of_type_JavaUtilList.iterator();
    while (paramAioActivityBubble.hasNext())
    {
      TroopGiftAioPanelData.AioActivity localAioActivity = (TroopGiftAioPanelData.AioActivity)paramAioActivityBubble.next();
      if ((localAioActivity.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localAioActivity.jdField_e_of_type_JavaLangString)))
      {
        LottieImageAsset localLottieImageAsset = a(paramLottieComposition.getImages(), localAioActivity.jdField_e_of_type_JavaLangString);
        if (localLottieImageAsset != null)
        {
          Bitmap localBitmap = Bitmap.createBitmap(localLottieImageAsset.getWidth(), localLottieImageAsset.getHeight(), Bitmap.Config.ARGB_8888);
          localLottieImageAsset.setBitmap(a(a(), localBitmap, localAioActivity.jdField_a_of_type_JavaLangString));
        }
      }
    }
  }
  
  private void a(ArrayList<TroopGiftAioPanelData.WebPanelItemInfo> paramArrayList)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131381069);
    localViewGroup.removeAllViews();
    localViewGroup.setBackgroundColor(0);
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int m = 0;
      while (m < paramArrayList.size())
      {
        TroopGiftAioPanelData.WebPanelItemInfo localWebPanelItemInfo = (TroopGiftAioPanelData.WebPanelItemInfo)paramArrayList.get(m);
        if ((localWebPanelItemInfo != null) && (localWebPanelItemInfo.jdField_b_of_type_Int > 0) && (localWebPanelItemInfo.jdField_c_of_type_Int > 0) && (localWebPanelItemInfo.jdField_b_of_type_JavaLangString.length() != 0) && (localWebPanelItemInfo.jdField_c_of_type_JavaLangString.length() != 0))
        {
          Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
          Object localObject2 = getContext();
          float f1;
          if (m == paramArrayList.size() - 1) {
            f1 = 10.0F;
          } else {
            f1 = 6.0F;
          }
          localRelativeLayout.setPadding(0, 0, (int)DisplayUtils.a((Context)localObject2, f1), 0);
          localViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
          Object localObject3 = new LinearLayout.LayoutParams((int)DisplayUtils.a(getContext(), localWebPanelItemInfo.jdField_b_of_type_Int), (int)DisplayUtils.a(getContext(), localWebPanelItemInfo.jdField_c_of_type_Int));
          localObject1 = new TroopGiftPanel.4(this, localWebPanelItemInfo);
          if (a(localWebPanelItemInfo.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$AioActivityBubble))
          {
            a(localRelativeLayout, localWebPanelItemInfo);
          }
          else
          {
            localObject2 = new ImageView(getContext());
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = new ColorDrawable(0);
            ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(localWebPanelItemInfo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3));
            ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
          }
          localRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
        }
        m += 1;
      }
    }
  }
  
  private boolean a(TroopGiftAioPanelData.AioActivityBubble paramAioActivityBubble)
  {
    if ((paramAioActivityBubble != null) && (!TextUtils.isEmpty(paramAioActivityBubble.jdField_a_of_type_JavaLangString)) && (paramAioActivityBubble.jdField_a_of_type_JavaUtilList != null))
    {
      if (paramAioActivityBubble.jdField_a_of_type_JavaUtilList.size() <= 0) {
        return false;
      }
      long l1 = System.currentTimeMillis();
      try
      {
        l2 = Long.valueOf(SharePreferenceUtils.a(a(), "AIO_ACTIVITY_SHOW_TIME")).longValue();
        int m = paramAioActivityBubble.jdField_c_of_type_Int;
        if (l1 - l2 < m * 1000) {
          return false;
        }
      }
      catch (Exception localException)
      {
        long l2;
        QLog.e("TroopGiftPanel", 4, localException, new Object[0]);
        SharePreferenceUtils.a(a(), "AIO_ACTIVITY_SHOW_TIME", "0");
        paramAioActivityBubble = paramAioActivityBubble.jdField_a_of_type_JavaUtilList.iterator();
        while (paramAioActivityBubble.hasNext())
        {
          TroopGiftAioPanelData.AioActivity localAioActivity = (TroopGiftAioPanelData.AioActivity)paramAioActivityBubble.next();
          l2 = TimeFormatterUtils.a(localAioActivity.jdField_b_of_type_JavaLangString);
          long l3 = TimeFormatterUtils.a(localAioActivity.jdField_c_of_type_JavaLangString);
          if ((l1 >= l2) && (l1 < l3)) {
            return true;
          }
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
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379704)).setText(HardCodeUtil.a(2131715176));
    this.jdField_j_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131715180));
    ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379704)).setTextColor(Color.parseColor("#ff878b99"));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379703)).setText(HardCodeUtil.a(2131715191));
    this.jdField_k_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131715187));
    ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379703)).setTextColor(Color.parseColor("#ff878b99"));
    this.jdField_j_of_type_AndroidViewView.findViewById(2131380844).setVisibility(8);
    this.jdField_k_of_type_AndroidViewView.findViewById(2131380849).setVisibility(8);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(new TroopGiftPanel.2(this));
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(new TroopGiftPanel.3(this));
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715181));
    ((Intent)localObject1).putExtra("url", paramString);
    ((Intent)localObject1).putExtra("hide_more_button", true);
    ((Intent)localObject1).putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772011, 2130772070);
    int m = this.jdField_j_of_type_Int;
    if (m == 2)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_opr", 0, 0, "", "", "", "");
    }
    else if (m == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_opr", 0, 0, "", "", "", "");
    }
    else if (m == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_opr", 0, 0, "", "", "", "");
    }
    else
    {
      Object localObject2;
      if (this.jdField_k_of_type_Int >= 4)
      {
        localObject1 = a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("clk_oper", "clk_oper", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      }
      else
      {
        if (AnonymousChatHelper.a().a(a())) {
          m = 2;
        } else {
          m = 1;
        }
        localObject1 = a();
        localObject2 = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", m, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onJumpAction, url=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopGiftPanel", 2, ((StringBuilder)localObject1).toString());
    }
    d(1);
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_AndroidUtilSparseArray.size() > 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.size() > 0);
  }
  
  private void h()
  {
    View localView = this.jdField_j_of_type_AndroidViewView;
    if (localView != null) {
      localView.setSelected(false);
    }
    localView = this.jdField_k_of_type_AndroidViewView;
    if (localView != null) {
      localView.setSelected(false);
    }
  }
  
  private void i()
  {
    d(this.jdField_e_of_type_JavaLangString);
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
    if (localObject == null) {
      return;
    }
    ((TroopGiftAioPanelData)localObject).jdField_c_of_type_Int = 0;
    if (((TroopGiftAioPanelData)localObject).jdField_b_of_type_JavaUtilArrayList != null)
    {
      int n = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size();
      m = jdField_c_of_type_Int;
      if (n == m)
      {
        n = this.jdField_h_of_type_Int;
        if ((n >= 0) && (n < m))
        {
          localObject = (TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
          if (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).jdField_b_of_type_JavaUtilArrayList != null)
          {
            m = 0;
            while (m < ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).jdField_b_of_type_JavaUtilArrayList.size())
            {
              TroopGiftAioItemData localTroopGiftAioItemData = (TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).jdField_b_of_type_JavaUtilArrayList.get(m);
              boolean bool;
              if (m == 0) {
                bool = true;
              } else {
                bool = false;
              }
              localTroopGiftAioItemData.jdField_a_of_type_Boolean = bool;
              m += 1;
            }
          }
        }
      }
    }
    int m = this.jdField_h_of_type_Int;
    if (m >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager;
      if ((m < localObject.length) && (localObject[m].getAdapter() != null)) {
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.jdField_h_of_type_Int].a();
      }
    }
  }
  
  private void k()
  {
    GdtMotiveVideoParams localGdtMotiveVideoParams = new GdtMotiveVideoParams();
    localGdtMotiveVideoParams.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface().getCurrentAccountUin()), "4040385433442243");
    localGdtMotiveVideoParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, a());
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoAd = new GdtMotiveVideoAd(localGdtMotiveVideoParams);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoAd.setListener(new WeakReference(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$FreeGiftGdtAdListener));
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoAd.load(a());
  }
  
  protected int a()
  {
    int m = this.jdField_k_of_type_Int;
    if (m != 4)
    {
      if (m != 5)
      {
        if (m != 6)
        {
          if (m != 8) {
            return m;
          }
          return 508;
        }
        return 504;
      }
      return 2;
    }
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof HotChatPie))
    {
      HotChatPie localHotChatPie = (HotChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((localHotChatPie.a != null) && (localHotChatPie.a.isBuLuoHotChat())) {
        return 507;
      }
      return 503;
    }
    return -1;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a()
  {
    int m = this.jdField_j_of_type_Int;
    if (m == 2) {
      return null;
    }
    if (m == 7) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    Object localObject1 = paramString;
    if (paramString != null)
    {
      Object localObject2 = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject1 = paramString;
      if (localObject2 != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          return paramString;
        }
        int m = this.jdField_j_of_type_Int;
        localObject1 = paramString;
        if (m != 2)
        {
          if (m == 7) {
            return paramString;
          }
          AppInterface localAppInterface = (AppInterface)((WeakReference)localObject2).get();
          if (localAppInterface == null) {
            return paramString;
          }
          Object localObject3 = (TroopManager)localAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          localObject2 = "2";
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((TroopManager)localObject3).c(a());
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              if (((TroopInfo)localObject3).isTroopOwner(localAppInterface.getCurrentAccountUin())) {}
              for (localObject1 = "0";; localObject1 = "1")
              {
                break;
                localObject1 = localObject2;
                if (!((TroopInfo)localObject3).isAdmin()) {
                  break;
                }
              }
            }
          }
          localObject1 = paramString.replace("$GCODE$", a()).replace("$CLIENTVER$", "android8.7.0").replace("$UIN$", localAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    inflate(getContext(), 2131560657, this);
  }
  
  protected void a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
      if (m >= localObject.length) {
        break;
      }
      if (m != paramInt) {
        localObject[m].setVisibility(8);
      } else {
        localObject[m].setVisibility(0);
      }
      m += 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("watch gdt mv result, 广告总时长: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" 观看时长: ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" 可以送免费礼物： ");
    localStringBuilder.append(paramBoolean);
    QLog.i("TroopGiftPanel", 1, localStringBuilder.toString());
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
      paramView1.findViewById(2131372286).setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramView2.findViewById(2131372286).setVisibility(0);
      paramView2.findViewById(2131373233).setVisibility(0);
      paramView3.findViewById(2131372286).setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      paramView1 = findViewById(2131363507);
      paramView2 = paramView1.getLayoutParams();
      paramView2.height = ((int)DisplayUtils.a(getContext(), 400.0F));
      paramView1.setLayoutParams(paramView2);
      paramView1 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      paramView2 = a();
      paramView3 = TroopGiftAioPanelData.b(paramView2);
      if ((paramView1 != null) && (!TextUtils.isEmpty(paramView3)) && (!TextUtils.isEmpty(paramView2)) && ((paramView1 instanceof QQAppInterface))) {
        ThreadManagerV2.excute(new TroopGiftPanel.8(this, paramView1, paramView2, paramView3, new Handler(Looper.getMainLooper())), 16, null, true);
      }
    }
  }
  
  protected void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      paramString.setDownloadListener(new TroopGiftPanel.10(this, paramTextView));
      paramString.setBounds(0, 0, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F), (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 14.0F));
      paramTextView.setCompoundDrawables(paramString, null, null, null);
      paramTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
      paramString.startDownload();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopGiftPanel", 2, "setLeftCoinDrawable param illegal");
    }
  }
  
  public void a(TroopGiftPanel.OnGetGiveGiftCallback paramOnGetGiveGiftCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getGiftStorage, callback=");
    ((StringBuilder)localObject).append(paramOnGetGiveGiftCallback);
    QLog.d("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    String str1 = this.jdField_b_of_type_JavaLangString;
    int n = this.jdField_g_of_type_Int;
    int i1 = this.jdField_k_of_type_Int;
    String str2 = a();
    int m;
    if (this.jdField_k_of_type_Int >= 4) {
      m = 2;
    } else {
      m = 0;
    }
    ((TroopGiftManager)localObject).a(str1, n, i1, str2, 2, m, new TroopGiftPanel.11(this, paramOnGetGiveGiftCallback));
  }
  
  public void a(TroopGiftPanel.OnGetPackGiftCallback paramOnGetPackGiftCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPackGiftStorage, callback=");
    ((StringBuilder)localObject).append(paramOnGetPackGiftCallback);
    QLog.d("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    ((TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(new TroopGiftPanel.21(this, paramOnGetPackGiftCallback));
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370360);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131365191);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131378213));
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter = new TroopExclusiveGiftAdapter();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter);
    this.jdField_j_of_type_AndroidViewView = findViewById(2131370257);
    this.jdField_k_of_type_AndroidViewView = findViewById(2131370259);
    c(paramBoolean);
    a(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364060));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131364061);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366093));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363750);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377911));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367721));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131376334).setOnClickListener(this);
    findViewById(2131363507).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new TroopGiftPanel.1(this));
    h();
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter.a(this.jdField_h_of_type_Int);
    a(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$FreeGiftGdtAdListener = new TroopGiftPanel.FreeGiftGdtAdListener(this);
    k();
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x");
    localStringBuilder.append(paramString);
    localTextView.setText(localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSelectGiftReceiver, uin=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", displayName=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!paramString1.equals(this.jdField_f_of_type_JavaLangString)) {
        TroopGiftAioPanelData.b(a(), paramString1);
      }
      this.jdField_f_of_type_JavaLangString = paramString1;
      this.jdField_g_of_type_JavaLangString = paramString2;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new ColorNickText(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      paramString2 = new ColorNickText(this.jdField_g_of_type_JavaLangString, 16).a();
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString2);
      paramString2 = ImageUtil.f();
      localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        paramString1 = FaceDrawable.getFaceDrawable((AppInterface)localObject, 1, paramString1, 3, paramString2, paramString2);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString2);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString2);
      }
    }
    setSendGiftBtnEnabled(TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString) ^ true);
  }
  
  protected void a(boolean paramBoolean)
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
    int m = jdField_c_of_type_Int;
    jdField_d_of_type_Int = m + 1;
    jdField_e_of_type_Int = jdField_a_of_type_Int;
    jdField_f_of_type_Int = m;
    Object localObject1 = new TroopExclusiveGiftAdapter.TroopExclusiveGiftData();
    ((TroopExclusiveGiftAdapter.TroopExclusiveGiftData)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131697754);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter.a((List)localObject2);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    localObject1 = (RadioViewPager)findViewById(2131380823);
    localObject2 = (RadioViewPager)findViewById(2131380824);
    RadioViewPager localRadioViewPager = (RadioViewPager)findViewById(2131380825);
    ((RadioViewPager)localObject1).setGiftPanel(this);
    ((RadioViewPager)localObject2).setGiftPanel(this);
    localRadioViewPager.setGiftPanel(this);
    this.jdField_e_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131377159);
    this.jdField_f_of_type_AndroidViewView = ((RadioViewPager)localObject1).findViewById(2131376164);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RadioViewPager)localObject1).findViewById(2131376163));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((RadioViewPager)localObject1).findViewById(2131376165));
    Object localObject3 = ((RadioViewPager)localObject1).findViewById(2131364445);
    this.jdField_g_of_type_AndroidViewView = localRadioViewPager.findViewById(2131377159);
    this.jdField_h_of_type_AndroidViewView = localRadioViewPager.findViewById(2131376164);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localRadioViewPager.findViewById(2131376163));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localRadioViewPager.findViewById(2131376165));
    this.jdField_i_of_type_AndroidViewView = localRadioViewPager.findViewById(2131372286);
    View localView = localRadioViewPager.findViewById(2131364445);
    localRadioViewPager.setEmptyInfo(BaseApplication.getContext().getString(2131697549), BaseApplication.getContext().getString(2131697550));
    localRadioViewPager.setIsShowJumpInfo(false, "", this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((View)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a((View)localObject1, (View)localObject2, localRadioViewPager);
    localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView;
    m = jdField_a_of_type_Int;
    localObject3[m] = localObject1;
    localObject3[jdField_c_of_type_Int] = localObject2;
    localObject3[jdField_d_of_type_Int] = localRadioViewPager;
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m] = ((GridListViewPager)((RadioViewPager)localObject1).a());
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
  
  protected boolean a(int paramInt, TroopGiftManager.GiveGift paramGiveGift)
  {
    int n = this.jdField_i_of_type_Int;
    int m = 1;
    if ((n < paramInt) && ((paramGiveGift == null) || (paramGiveGift.jdField_b_of_type_Int + paramGiveGift.jdField_c_of_type_Int == 0)))
    {
      paramInt = m;
      if (AnonymousChatHelper.a().a(a())) {
        paramInt = 2;
      }
      paramGiveGift = this.jdField_a_of_type_AndroidContentContext.getResources();
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, paramGiveGift.getString(2131697756), paramGiveGift.getString(2131697755), paramGiveGift.getString(2131690728), paramGiveGift.getString(2131697758), new TroopGiftPanel.19(this, paramInt), new TroopGiftPanel.20(this)).show();
      g();
      return false;
    }
    return true;
  }
  
  public int b()
  {
    CharSequence localCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    try
    {
      if (TextUtils.isEmpty(localCharSequence)) {
        break label70;
      }
      int m = Integer.parseInt(localCharSequence.toString().substring(1));
      return m;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label31:
      StringBuilder localStringBuilder;
      label70:
      break label31;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("error sendNum = ");
      localStringBuilder.append(localCharSequence);
      QLog.d("TroopGiftPanel", 2, localStringBuilder.toString());
    }
    return 0;
  }
  
  public void b()
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str1 = a();
    String str2 = TroopGiftAioPanelData.b(str1);
    if ((localObject != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && ((localObject instanceof QQAppInterface)))
    {
      ThreadManagerV2.excute(new TroopGiftPanel.7(this, (AppInterface)localObject, str1, str2, new Handler(Looper.getMainLooper())), 16, null, true);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("NoSelectGiftReceiver! last receiver is not in troop, troopUin=");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(", memberUin=");
    ((StringBuilder)localObject).append(str2);
    QLog.e("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    TroopGiftAioPanelData.b(str1, "");
    f();
  }
  
  public void b(int paramInt)
  {
    a("1");
    Object localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
    if ((localObject1 != null) && (((TroopGiftAioItemData)localObject1).jdField_b_of_type_Int == 0))
    {
      c(0);
      Object localObject2;
      if (this.jdField_k_of_type_Int >= 4)
      {
        localObject1 = a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_store", "exp_chose", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      }
      else
      {
        int m;
        if (AnonymousChatHelper.a().a(a())) {
          m = 2;
        } else {
          m = 1;
        }
        localObject1 = a();
        localObject2 = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
      }
    }
    else
    {
      c(8);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
    if (localObject1 != null) {
      ((TroopGiftAioPanelData)localObject1).jdField_c_of_type_Int = 0;
    }
    this.jdField_h_of_type_Int = paramInt;
    localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
    if ((localObject1 == null) || (((TroopGiftAioPanelData)localObject1).jdField_d_of_type_JavaUtilArrayList == null)) {
      this.jdField_h_of_type_Int = jdField_a_of_type_Int;
    }
    h();
    localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter;
    if (localObject1 != null) {
      ((TroopExclusiveGiftAdapter)localObject1).a(this.jdField_h_of_type_Int);
    }
    onTabSelected(0, this.jdField_h_of_type_Int);
    c(this.jdField_d_of_type_Boolean);
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString).replace("http://", "https://");
    if (paramString.contains("?"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&troop_uin=");
      ((StringBuilder)localObject).append(a());
      paramString = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?troop_uin=");
      ((StringBuilder)localObject).append(a());
      paramString = ((StringBuilder)localObject).toString();
    }
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715171));
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActionListItemClick, url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopGiftPanel", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
    if (localObject2 != null) {
      localObject1 = ((TroopGiftAioPanelData)localObject2).jdField_a_of_type_ComTencentBizTroopgiftGiftConfigManager$ImgEntryItem;
    }
    int m = 36;
    int n = 0;
    if (localObject1 != null)
    {
      localObject2 = ((GiftConfigManager.ImgEntryItem)localObject1).jdField_a_of_type_JavaLangString;
      n = ((GiftConfigManager.ImgEntryItem)localObject1).jdField_b_of_type_Int;
      m = ((GiftConfigManager.ImgEntryItem)localObject1).jdField_a_of_type_Int;
      this.jdField_e_of_type_JavaLangString = ((GiftConfigManager.ImgEntryItem)localObject1).jdField_b_of_type_JavaLangString;
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "panelEntryItem", 0, 0, "", "", "", "");
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.jdField_a_of_type_JavaLangString)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.jdField_a_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.jdField_b_of_type_JavaLangString;
        n = 36;
      }
      else
      {
        localObject1 = "";
        m = 0;
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (n > 0) && (m > 0))
    {
      m = this.jdField_j_of_type_Int;
      if (m == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_opr", 0, 0, "", "", "", "");
        return;
      }
      if (m == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_opr", 0, 0, "", "", "", "");
        return;
      }
      if (m == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_opr", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_k_of_type_Int >= 4)
      {
        localObject1 = a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_store", "exp_oper", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
        return;
      }
      if (AnonymousChatHelper.a().a(a())) {
        m = 2;
      } else {
        m = 1;
      }
      localObject1 = a();
      localObject2 = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", m, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("?_bid=3913&_wvSb=1&from=7&troopUin=%s");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    localObject1 = String.format((String)localObject2, new Object[] { localObject1 });
    localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715192));
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("url", a((String)localObject1));
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772011, 0);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public void c(String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i2 = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerSendGiftToPerson, uin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopGiftPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = (TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
      TroopGiftAioItemData localTroopGiftAioItemData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
      int i1 = localTroopGiftAioItemData.jdField_b_of_type_Int;
      if (localTroopGiftAioItemData.jdField_b_of_type_Int == 0) {
        i1 = b();
      }
      bool = AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int m = 6;
      if (bool) {}
      int n;
      for (;;)
      {
        n = 0;
        break;
        m = this.jdField_j_of_type_Int;
        if (m == 2)
        {
          m = 9;
          n = 1;
          break;
        }
        if (m == 6)
        {
          m = 10;
        }
        else if (m == 7)
        {
          m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
          if (m != 1000)
          {
            if (m != 1004)
            {
              m = 11;
            }
            else
            {
              m = 11;
              n = 513;
              break;
            }
          }
          else
          {
            m = 11;
            n = 512;
            break;
          }
        }
        else
        {
          m = 0;
        }
      }
      if (!AnonymousChatHelper.a().a(a())) {
        i2 = 1;
      }
      int i4 = this.jdField_k_of_type_Int;
      String str = a();
      long l = Long.parseLong(paramString);
      int i5 = localTroopGiftAioItemData.jdField_c_of_type_Int;
      int i3;
      if (localTroopGiftAioItemData.jdField_b_of_type_Int == 0) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      ((TroopGiftManager)localObject).a("OidbSvc.0x6b6", 1718, m, i4, str, 2, i1, l, i5, i3, localTroopGiftAioItemData.jdField_a_of_type_Int, n, new TroopGiftPanel.18(this, i2, localTroopGiftAioItemData), localTroopGiftAioItemData.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = null;
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  protected void d(int paramInt)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    } else {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", "grp_lbs", str, "qq_gift", "button_click", 0, 0, localStringBuilder.toString(), "", "", "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportActionEntryClick, entryId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", toUin=");
      localStringBuilder.append(str);
      QLog.d("TroopGiftPanel", 2, localStringBuilder.toString());
    }
  }
  
  protected boolean d()
  {
    int m = this.jdField_j_of_type_Int;
    return (m != 2) && (m != 7) && (m != 3);
  }
  
  protected void e()
  {
    if (this.jdField_j_of_type_Int == 6)
    {
      localIntent = new Intent();
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("param_from", 16);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697747));
      localIntent.setFlags(603979776);
      RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/troop/memberlist/TroopMemberList", 12006);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", a());
    localIntent.putExtra("param_from", 14);
    localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697747));
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      localIntent.putExtra("troop_gift_from", ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin());
    }
    if (!this.jdField_c_of_type_Boolean) {
      RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/troop/memberlist/TroopMemberList", 12006);
    }
  }
  
  public void f()
  {
    View localView = this.jdField_f_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_e_of_type_AndroidViewView != null))
    {
      localView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void g()
  {
    int m;
    if (AnonymousChatHelper.a().a(a())) {
      m = 2;
    } else {
      m = 1;
    }
    int n = this.jdField_j_of_type_Int;
    if (n == 2)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (n == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (n == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      str = a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("");
      NearbyFlowerManager.a("gift_store", "exp_tip", str, ((StringBuilder)localObject).toString(), "", "");
      return;
    }
    String str = a();
    Object localObject = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", m, 0, str, "", (String)localObject, localStringBuilder.toString());
  }
  
  public void onClick(View paramView)
  {
    boolean bool = AnonymousChatHelper.a().a(a());
    int i1 = 1;
    int n;
    if (bool) {
      n = 2;
    } else {
      n = 1;
    }
    int m = paramView.getId();
    int i2 = 0;
    Object localObject2;
    Object localObject3;
    switch (m)
    {
    default: 
      break;
    case 2131377233: 
      e();
      break;
    case 2131376334: 
      localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_c_of_type_JavaLangString)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("?_bid=3913&_wvSb=1&from=7&troopUin=%s");
        localObject2 = ((StringBuilder)localObject1).toString();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        } else {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
        localObject1 = String.format((String)localObject2, new Object[] { localObject1 });
        localObject2 = new Intent(a(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715182));
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("url", a((String)localObject1));
        a().startActivityForResult((Intent)localObject2, 12007);
        a().overridePendingTransition(2130772011, 2130772070);
      }
      m = this.jdField_j_of_type_Int;
      if (m == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_pay", 0, 0, "", "", "", "");
      }
      else if (m == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_pay", 0, 0, "", "", "", "");
      }
      else if (m == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_pay", 0, 0, "", "", "", "");
      }
      else if (this.jdField_k_of_type_Int >= 4)
      {
        localObject1 = a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_store", "clk_pay", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      }
      else
      {
        localObject1 = a();
        localObject2 = this.jdField_c_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", n, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
      }
      break;
    case 2131366093: 
    case 2131366094: 
      new TroopGiftPanel.GiftNumInputDialog(this, a()).a();
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.b();
      } else {
        ((GiftPanelHelper)((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(136)).b();
      }
      m = i1;
    }
    label2728:
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        m = i1;
        if (!Settings.System.canWrite(a()))
        {
          QLog.i("TroopGiftPanel", 1, "can not write settings");
          m = 0;
        }
      }
      if (m == 0) {
        break label752;
      }
      Settings.System.putInt(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "accelerometer_rotation", 0);
    }
    catch (SecurityException localSecurityException)
    {
      label736:
      label752:
      int i3;
      label1705:
      long l1;
      label2227:
      label2777:
      break label736;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "SecurityException ");
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      localObject1 = a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append("");
      NearbyFlowerManager.a("gift_store", "clk_chose", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    }
    else
    {
      localObject1 = a();
      localObject2 = this.jdField_c_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", n, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
      break label2777;
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "sendGiftMaskBtn onClick");
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
      m = i2;
      if (localObject1 != null) {
        if (((TroopGiftAioItemData)localObject1).jdField_e_of_type_Int > 0)
        {
          m = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_e_of_type_Int;
        }
        else
        {
          m = i2;
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Int > 0) {
            m = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Int;
          }
        }
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
      if (((this.jdField_h_of_type_Int != jdField_d_of_type_Int) || (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()) || (e())) && (d()) && (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
      {
        QQToast.a(getContext(), 1, HardCodeUtil.a(2131715199), 1).a();
        break label2777;
        m = jdField_c_of_type_Int;
        i1 = this.jdField_h_of_type_Int;
        if (m == i1)
        {
          if (this.jdField_k_of_type_Int >= 4)
          {
            localObject1 = a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(a());
            ((StringBuilder)localObject2).append("");
            NearbyFlowerManager.a("gift_store", "clk_now", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
          else
          {
            localObject1 = a();
            localObject2 = this.jdField_c_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", n, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
          }
        }
        else if ((i1 >= 0) && (i1 < m))
        {
          m = this.jdField_j_of_type_Int;
          if (m == 2)
          {
            ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_send", 0, 0, "", "", "", "");
          }
          else if (m == 6)
          {
            ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_send", 0, 0, "", "", "", "");
          }
          else if (m == 7)
          {
            ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_send", 0, 0, "", "", "", "");
          }
          else if (this.jdField_k_of_type_Int >= 4)
          {
            localObject1 = a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(a());
            ((StringBuilder)localObject2).append("");
            NearbyFlowerManager.a("gift_store", "clk_send", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
          else
          {
            localObject1 = a();
            localObject2 = this.jdField_c_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", n, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
            localObject1 = a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            ReportController.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_addpage", n, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
        if (localObject1 != null)
        {
          if (((TroopGiftAioItemData)localObject1).jdField_e_of_type_Int > 0)
          {
            m = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_e_of_type_Int;
            break label1705;
          }
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Int > 0)
          {
            m = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Int;
            break label1705;
          }
        }
        m = 0;
        ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(m), "", "", "");
        localObject2 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 != null)
        {
          localObject3 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
          if (localObject3 != null)
          {
            m = ((TroopGiftAioItemData)localObject3).jdField_b_of_type_Int;
            if (((TroopGiftAioItemData)localObject3).jdField_b_of_type_Int == 0) {
              m = b();
            }
            if ((this.jdField_h_of_type_Int != jdField_d_of_type_Int) || (!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_d_of_type_Boolean))
            {
              do
              {
                bool = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(this.jdField_h_of_type_Int);
                localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_AndroidUtilSparseArray;
                if (((TroopGiftAioItemData)localObject3).jdField_e_of_type_Int != 0) {
                  i1 = ((TroopGiftAioItemData)localObject3).jdField_e_of_type_Int;
                } else {
                  i1 = ((TroopGiftAioItemData)localObject3).jdField_a_of_type_Int;
                }
                localObject1 = (TroopGiftManager.GiveGift)((SparseArray)localObject1).get(i1);
              } while ((bool) || (a(m, (TroopGiftManager.GiveGift)localObject1)));
              if (QLog.isColorLevel()) {
                QLog.d("TroopGiftPanel", 2, "isStorageEnough: false");
              }
            }
            else
            {
              i1 = jdField_c_of_type_Int;
              i2 = this.jdField_h_of_type_Int;
              if (i1 == i2)
              {
                localObject2 = (TroopGiftManager)((AppInterface)localObject2).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
                if (((TroopGiftAioItemData)localObject3).jdField_b_of_type_Boolean)
                {
                  i2 = this.jdField_k_of_type_Int;
                  localObject1 = a();
                  i3 = ((TroopGiftAioItemData)localObject3).jdField_c_of_type_Int;
                  if (((TroopGiftAioItemData)localObject3).jdField_b_of_type_Int == 0) {
                    i1 = 1;
                  } else {
                    i1 = 0;
                  }
                  ((TroopGiftManager)localObject2).a("OidbSvc.0x6b6", 1718, 8, i2, (String)localObject1, 2, m, 0L, i3, i1, ((TroopGiftAioItemData)localObject3).jdField_a_of_type_Int, 0, new TroopGiftPanel.14(this, n, (TroopGiftAioItemData)localObject3), ((TroopGiftAioItemData)localObject3).jdField_e_of_type_Int);
                }
                else
                {
                  if (this.jdField_a_of_type_Boolean) {
                    n = 3;
                  } else {
                    n = 1;
                  }
                  if (this.jdField_a_of_type_Boolean) {
                    localObject1 = "OidbSvc.0x7f6";
                  } else {
                    localObject1 = "OidbSvc.0x6b6";
                  }
                  if (this.jdField_a_of_type_Boolean) {
                    i1 = 2038;
                  } else {
                    i1 = 1718;
                  }
                  ((TroopGiftManager)localObject2).a((String)localObject1, i1, n, this.jdField_k_of_type_Int, a(), 2, m, 1, ((TroopGiftAioItemData)localObject3).jdField_a_of_type_Int, new TroopGiftPanel.15(this, (TroopGiftAioItemData)localObject3));
                }
                localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner;
                if (localObject1 != null)
                {
                  ((TroopGiftPanel.OnShowOrHideListerner)localObject1).b();
                  break label2777;
                }
              }
              else if ((i2 >= 0) && (i2 < i1))
              {
                if (this.jdField_c_of_type_Boolean)
                {
                  localObject1 = this.jdField_d_of_type_JavaLangString;
                  break label2777;
                }
                m = this.jdField_j_of_type_Int;
                if ((m != 2) && (m != 7)) {
                  localObject1 = this.jdField_f_of_type_JavaLangString;
                } else {
                  localObject1 = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                }
                l1 = 0L;
              }
            }
          }
        }
      }
    }
    try
    {
      long l2 = Long.valueOf((String)localObject1).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      break label2227;
    }
    QLog.e("TroopGiftPanel", 1, "toUinStr to uin err");
    if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      m = 4;
    }
    else
    {
      m = this.jdField_j_of_type_Int;
      if (m == 2) {
        m = 7;
      } else if (m == 6) {
        m = 8;
      } else {
        m = 1;
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
    if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).a(this.jdField_h_of_type_Int)))
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (jdField_f_of_type_Boolean)
        {
          jdField_f_of_type_Boolean = false;
          ((TroopGiftManager)((AppInterface)localObject2).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData, m, a(), l1, new TroopGiftPanel.16(this));
        }
        else
        {
          localObject1 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
          a(a(), (GdtMotiveVideoPageData)localObject1);
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
      if ((localObject1 != null) && (((TroopGiftAioItemData)localObject1).jdField_j_of_type_Int == 1) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof QQAppInterface)) && (!VasUtil.a((AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getVipStatus().isSVip()))
      {
        localObject1 = new TroopGiftPanel.17(this);
        localObject1 = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, getResources().getString(2131697552), getResources().getString(2131697551), HardCodeUtil.a(2131715197), HardCodeUtil.a(2131715188), (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
        if (localObject1 != null) {
          ((QQCustomDialog)localObject1).show();
        }
        ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_window_view", 0, 0, "", "", "", "");
      }
      else if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.b();
        c(this.jdField_d_of_type_JavaLangString);
      }
      else
      {
        m = this.jdField_j_of_type_Int;
        if ((m != 2) && (m != 7))
        {
          c(this.jdField_f_of_type_JavaLangString);
        }
        else
        {
          c(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          break label2728;
          if (jdField_d_of_type_Int == this.jdField_h_of_type_Int)
          {
            if (this.jdField_c_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.b();
              c(this.jdField_d_of_type_JavaLangString);
              break label2777;
            }
            m = this.jdField_j_of_type_Int;
            if ((m != 2) && (m != 7)) {
              c(this.jdField_f_of_type_JavaLangString);
            } else {
              c(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
          }
        }
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
        {
          ((GiftPanelHelper)((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(136)).b();
          break label2777;
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            i();
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((m == 1) || (m == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getTag() instanceof GridListAdapter.Holder))
    {
      TroopGiftAioItemData localTroopGiftAioItemData = ((GridListAdapter.Holder)paramView.getTag()).jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
      boolean bool = localTroopGiftAioItemData.jdField_a_of_type_Boolean;
      int n = 0;
      int m;
      if ((!bool) && ((paramAdapterView.getAdapter() instanceof GridListAdapter)))
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = localTroopGiftAioItemData;
        localTroopGiftAioItemData.jdField_a_of_type_Boolean = true;
        m = this.jdField_h_of_type_Int;
        Object localObject1;
        Object localObject2;
        if ((m >= 0) && (m < jdField_c_of_type_Int))
        {
          if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int))
          {
            localObject1 = (TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int);
            if (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject1).jdField_b_of_type_JavaUtilArrayList != null)
            {
              m = 0;
              while (m < ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject1).jdField_b_of_type_JavaUtilArrayList.size())
              {
                localObject2 = (TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)localObject1).jdField_b_of_type_JavaUtilArrayList.get(m);
                if (((TroopGiftAioItemData)localObject2).jdField_a_of_type_Int == localTroopGiftAioItemData.jdField_a_of_type_Int) {
                  this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int = m;
                } else {
                  ((TroopGiftAioItemData)localObject2).jdField_a_of_type_Boolean = false;
                }
                m += 1;
              }
            }
          }
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.jdField_h_of_type_Int].a();
        }
        else
        {
          m = this.jdField_h_of_type_Int;
          if (m == jdField_c_of_type_Int)
          {
            if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int < this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList.size())) {
              ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = false;
            }
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int = localTroopGiftAioItemData.jdField_g_of_type_Int;
            this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].a();
          }
          else if (m == jdField_d_of_type_Int)
          {
            if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int < this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.size())) {
              ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int)).jdField_a_of_type_Boolean = false;
            }
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int = localTroopGiftAioItemData.jdField_g_of_type_Int;
            this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].a();
          }
        }
        if (localTroopGiftAioItemData.jdField_b_of_type_Int == 0)
        {
          c(0);
          if (this.jdField_k_of_type_Int >= 4)
          {
            localObject1 = a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(a());
            ((StringBuilder)localObject2).append("");
            NearbyFlowerManager.a("gift_store", "exp_chose", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
          else
          {
            if (AnonymousChatHelper.a().a(a())) {
              m = 2;
            } else {
              m = 1;
            }
            localObject1 = a();
            localObject2 = this.jdField_c_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
          }
        }
        else
        {
          c(8);
        }
      }
      if (localTroopGiftAioItemData.jdField_e_of_type_Int > 0)
      {
        m = localTroopGiftAioItemData.jdField_e_of_type_Int;
      }
      else
      {
        m = n;
        if (localTroopGiftAioItemData.jdField_a_of_type_Int > 0) {
          m = localTroopGiftAioItemData.jdField_a_of_type_Int;
        }
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_click", 0, 0, String.valueOf(m), "", "", "");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_h_of_type_Int = paramInt2;
    a(this.jdField_h_of_type_Int);
    if ((paramInt2 >= 0) && (paramInt2 < jdField_c_of_type_Int))
    {
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377159);
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376164);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376163));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131376165));
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131364445);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b();
      h();
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter.a(paramInt2);
      c(this.jdField_d_of_type_Boolean);
      j();
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter.a(-1);
    }
    boolean bool1 = AnonymousChatHelper.a().a(a());
    boolean bool2 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377187) instanceof TextView;
    Object localObject2 = "#878B99";
    Object localObject3;
    if (bool2)
    {
      localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377187);
      if (bool1) {
        localObject1 = "#878B99";
      } else {
        localObject1 = "#000000";
      }
      ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject1));
    }
    if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377159) instanceof TextView))
    {
      localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt2].findViewById(2131377159);
      if (bool1) {
        localObject1 = localObject2;
      } else {
        localObject1 = "#000000";
      }
      ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject1));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
    if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).a(this.jdField_h_of_type_Int)))
    {
      if (jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_h_of_type_JavaLangString);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_i_of_type_JavaLangString);
      }
    }
    else {
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
    }
    localObject2 = null;
    if ((paramInt2 >= 0) && (paramInt2 < jdField_c_of_type_Int))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int != -1))
      {
        localObject1 = localObject2;
        if (((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.size() <= this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int) {
          break label671;
        }
        localObject1 = (TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int);
        break label671;
      }
    }
    if (paramInt2 == jdField_c_of_type_Int)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).jdField_d_of_type_Int != -1))
      {
        localObject1 = (TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int);
        break label671;
      }
    }
    localObject1 = localObject2;
    if (paramInt2 == jdField_d_of_type_Int)
    {
      localObject3 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((TroopGiftAioPanelData)localObject3).jdField_e_of_type_JavaUtilArrayList != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.size() > 0)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_AndroidUtilSparseArray.size() > 0)
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int != -1) {
                localObject1 = (TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int);
              }
            }
          }
        }
      }
    }
    label671:
    int m = 2;
    bool2 = false;
    localObject2 = "";
    Object localObject4;
    if (localObject1 != null)
    {
      if (((TroopGiftAioItemData)localObject1).jdField_b_of_type_Int == 0)
      {
        c(0);
        if (this.jdField_k_of_type_Int >= 4)
        {
          localObject3 = a();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(a());
          ((StringBuilder)localObject4).append("");
          NearbyFlowerManager.a("gift_store", "exp_chose", (String)localObject3, ((StringBuilder)localObject4).toString(), "", "");
        }
        else
        {
          if (AnonymousChatHelper.a().a(a())) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
          localObject3 = a();
          localObject4 = this.jdField_c_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt1, 0, (String)localObject3, "", (String)localObject4, localStringBuilder.toString());
        }
      }
      else
      {
        c(8);
      }
    }
    else {
      c(8);
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)localObject1);
    if (AnonymousChatHelper.a().a(a())) {
      paramInt1 = m;
    } else {
      paramInt1 = 1;
    }
    if ((paramInt2 >= 0) && (paramInt2 < jdField_c_of_type_Int))
    {
      if (this.jdField_k_of_type_Int >= 4)
      {
        localObject1 = a();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(a());
        ((StringBuilder)localObject3).append("");
        NearbyFlowerManager.a("gift_store", "exp_one", (String)localObject1, ((StringBuilder)localObject3).toString(), "", "");
      }
      else
      {
        localObject1 = a();
        localObject3 = this.jdField_c_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", paramInt1, 0, (String)localObject1, "", (String)localObject3, ((StringBuilder)localObject4).toString());
      }
      if (d()) {
        setSendGiftBtnEnabled(TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString) ^ true);
      } else {
        setSendGiftBtnEnabled(true);
      }
      localObject3 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((TroopGiftAioPanelData)localObject3).jdField_b_of_type_JavaUtilArrayList != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() == jdField_c_of_type_Int) {
            localObject1 = ((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(paramInt2)).jdField_a_of_type_JavaLangString;
          }
        }
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_tab_click", paramInt1, 0, a(), "", this.jdField_c_of_type_JavaLangString, (String)localObject1);
      return;
    }
    if (paramInt2 == jdField_d_of_type_Int)
    {
      localObject1 = a();
      localObject2 = this.jdField_c_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aiobag_view", paramInt1, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
      a(new TroopGiftPanel.13(this));
      if (d())
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (e()) {
            bool1 = true;
          }
        }
        setSendGiftBtnEnabled(bool1);
        return;
      }
      setSendGiftBtnEnabled(e());
      return;
    }
    if (this.jdField_k_of_type_Int >= 4)
    {
      localObject1 = a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append("");
      NearbyFlowerManager.a("gift_store", "exp_all", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    }
    else
    {
      localObject2 = a();
      if (((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379704)).a()) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localObject3 = this.jdField_c_of_type_JavaLangString;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", paramInt1, 0, (String)localObject2, (String)localObject1, (String)localObject3, ((StringBuilder)localObject4).toString());
    }
    ((TroopGiftManager)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(true);
    ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379704)).a(false, false);
    setSendGiftBtnEnabled(true);
  }
  
  public void setGiftData(TroopGiftAioPanelData paramTroopGiftAioPanelData, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramTroopGiftAioPanelData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = paramTroopGiftAioPanelData;
    int n;
    Object localObject2;
    if (((!this.jdField_e_of_type_Boolean) && (paramTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null) && (paramTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() > 0)) || ((paramTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null) && (paramTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() != jdField_c_of_type_Int)))
    {
      n = paramTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size();
      this.jdField_e_of_type_Boolean = true;
      localObject2 = (GridListViewPager[])this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.clone();
      localObject1 = (View[])this.jdField_a_of_type_ArrayOfAndroidViewView.clone();
      if (localObject2.length == jdField_d_of_type_Int + 1)
      {
        jdField_b_of_type_Int = n;
        jdField_c_of_type_Int = jdField_b_of_type_Int;
        m = jdField_c_of_type_Int;
        jdField_d_of_type_Int = m + 1;
        jdField_f_of_type_Int = m;
        ArrayList localArrayList = new ArrayList();
        m = 0;
        while (m < n)
        {
          TroopExclusiveGiftAdapter.TroopExclusiveGiftData localTroopExclusiveGiftData = new TroopExclusiveGiftAdapter.TroopExclusiveGiftData();
          localTroopExclusiveGiftData.jdField_a_of_type_JavaLangString = ((TroopGiftAioPanelData.PersonalTabItemInfo)paramTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString;
          localArrayList.add(localTroopExclusiveGiftData);
          m += 1;
        }
        h();
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter.a(localArrayList);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter.a(this.jdField_h_of_type_Int);
        m = n + 2;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[m];
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[m];
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).removeAllViews();
        m = 0;
        while (m < n)
        {
          paramTroopGiftAioPanelData = new RadioViewPager(getContext());
          paramTroopGiftAioPanelData.setGiftPanel(this);
          paramTroopGiftAioPanelData.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(paramTroopGiftAioPanelData, new RelativeLayout.LayoutParams(-1, -1));
          this.jdField_a_of_type_ArrayOfAndroidViewView[m] = paramTroopGiftAioPanelData;
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m] = ((GridListViewPager)paramTroopGiftAioPanelData.a());
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setOnItemClickListener(this);
          m += 1;
        }
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(localObject1[1], new RelativeLayout.LayoutParams(-1, -1));
        ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(localObject1[2], new RelativeLayout.LayoutParams(-1, -1));
        localObject2[0].setVisibility(8);
        paramTroopGiftAioPanelData = this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager;
        paramTroopGiftAioPanelData[jdField_c_of_type_Int] = localObject2[1];
        paramTroopGiftAioPanelData[jdField_d_of_type_Int] = localObject2[2];
        localObject1[0].setVisibility(8);
        paramTroopGiftAioPanelData = this.jdField_a_of_type_ArrayOfAndroidViewView;
        paramTroopGiftAioPanelData[jdField_c_of_type_Int] = localObject1[1];
        paramTroopGiftAioPanelData[jdField_d_of_type_Int] = localObject1[2];
        this.jdField_e_of_type_AndroidViewView = paramTroopGiftAioPanelData[0].findViewById(2131377159);
        this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376164);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376163));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131376165));
        paramTroopGiftAioPanelData = this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131364445);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramTroopGiftAioPanelData.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131377159);
        this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131376164);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131376163));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131376165));
        this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131372286);
        paramTroopGiftAioPanelData = this.jdField_a_of_type_ArrayOfAndroidViewView[jdField_d_of_type_Int].findViewById(2131364445);
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramTroopGiftAioPanelData.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        m = 0;
        for (;;)
        {
          n = jdField_c_of_type_Int;
          if (m >= n) {
            break;
          }
          paramTroopGiftAioPanelData = this.jdField_a_of_type_ArrayOfAndroidViewView;
          a(paramTroopGiftAioPanelData[m], paramTroopGiftAioPanelData[n], paramTroopGiftAioPanelData[jdField_d_of_type_Int]);
          m += 1;
        }
        onTabSelected(0, 0);
      }
    }
    a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.f);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.f != null))
    {
      paramTroopGiftAioPanelData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.f.iterator();
      while (paramTroopGiftAioPanelData.hasNext()) {
        if (((TroopGiftAioPanelData.WebPanelItemInfo)paramTroopGiftAioPanelData.next()).jdField_a_of_type_Int == 1) {
          ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "activityTab", 0, 0, "", "", "", "");
        }
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_b_of_type_JavaLangString))
    {
      paramTroopGiftAioPanelData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length > jdField_c_of_type_Int)
      {
        m = 0;
        for (;;)
        {
          n = jdField_c_of_type_Int;
          if (m >= n) {
            break;
          }
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setGridGiftIcon(paramTroopGiftAioPanelData);
          m += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[n].setGridGiftIcon(paramTroopGiftAioPanelData);
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList.size() >= 1) && (this.jdField_d_of_type_Boolean))
    {
      paramTroopGiftAioPanelData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData;
      paramTroopGiftAioPanelData.jdField_d_of_type_Int = paramTroopGiftAioPanelData.jdField_b_of_type_Int;
      ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_c_of_type_Int].setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
    }
    ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379704)).a(false, false);
    long l2 = System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Boolean) && (l2 >= this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long) && (l2 <= l3 + 2592000000L) && (!((TroopGiftManager)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a())) {
      ((RedDotTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379704)).a(true, false);
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_a_of_type_JavaLangString))) {
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_a_of_type_JavaLangString);
    }
    b(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList == null) {
      this.jdField_h_of_type_Int = jdField_a_of_type_Int;
    }
    int m = this.jdField_h_of_type_Int;
    if ((m >= 0) && (m < jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int != -1))
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null)
      {
        m = this.jdField_h_of_type_Int;
        if ((m >= 0) && (m < this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size()))
        {
          paramTroopGiftAioPanelData = ((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_h_of_type_Int)).jdField_b_of_type_JavaUtilArrayList;
          if ((paramTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int < paramTroopGiftAioPanelData.size())) {
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)paramTroopGiftAioPanelData.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int));
          }
        }
      }
    }
    else if ((this.jdField_h_of_type_Int == jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int != -1)) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int));
    } else if ((this.jdField_h_of_type_Int == jdField_d_of_type_Int) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int != -1)) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int));
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData == null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList != null) && (((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaUtilArrayList.get(0));
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null)
    {
      m = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size();
      n = jdField_c_of_type_Int;
      if ((m == n) && (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length > n))
      {
        m = 0;
        while (m < jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[m].setData(((TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_b_of_type_JavaUtilArrayList);
          m += 1;
        }
      }
    }
    paramTroopGiftAioPanelData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
    if ((paramTroopGiftAioPanelData != null) && (paramTroopGiftAioPanelData.jdField_b_of_type_Int == 0))
    {
      c(0);
      if (this.jdField_k_of_type_Int >= 4)
      {
        paramTroopGiftAioPanelData = a();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(a());
        ((StringBuilder)localObject1).append("");
        NearbyFlowerManager.a("gift_store", "exp_chose", paramTroopGiftAioPanelData, ((StringBuilder)localObject1).toString(), "", "");
      }
      else
      {
        if (AnonymousChatHelper.a().a(a())) {
          m = 2;
        } else {
          m = 1;
        }
        paramTroopGiftAioPanelData = a();
        localObject1 = this.jdField_c_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", m, 0, paramTroopGiftAioPanelData, "", (String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      c(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_AndroidUtilSparseArray.size() > 0)) {
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[jdField_d_of_type_Int].setData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList);
    }
    a(new TroopGiftPanel.12(this, System.currentTimeMillis(), l1));
    paramBoolean = AnonymousChatHelper.a().a(a());
    paramTroopGiftAioPanelData = findViewById(2131380865);
    Object localObject1 = findViewById(2131380866);
    if (paramBoolean)
    {
      paramTroopGiftAioPanelData.setBackgroundResource(2130843922);
      ((View)localObject1).setBackgroundResource(2130843924);
    }
    else
    {
      paramTroopGiftAioPanelData.setBackgroundResource(2130843921);
      ((View)localObject1).setBackgroundResource(2130843923);
    }
    h();
    paramTroopGiftAioPanelData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopExclusiveGiftAdapter;
    if (paramTroopGiftAioPanelData != null) {
      paramTroopGiftAioPanelData.a(this.jdField_h_of_type_Int);
    }
    a(this.jdField_h_of_type_Int);
    j();
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      int m = this.jdField_j_of_type_Int;
      if (m == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "half_mall_exp", 0, 0, "", "", "", "");
        return;
      }
      if (m == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "half_mall_exp", 0, 0, "", "", "", "");
        return;
      }
      if (m == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "half_mall_exp", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_k_of_type_Int >= 4)
      {
        str = a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append("");
        NearbyFlowerManager.a("gift_store", "exp_one", str, ((StringBuilder)localObject).toString(), "", "");
        return;
      }
      if (AnonymousChatHelper.a().a(a())) {
        m = 2;
      } else {
        m = 1;
      }
      String str = a();
      Object localObject = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", m, 0, str, "", (String)localObject, localStringBuilder.toString());
    }
  }
  
  public void setMainAreaBackgroundColor(int paramInt)
  {
    View localView = findViewById(2131363507);
    if (localView != null) {
      localView.setBackgroundColor(paramInt);
    }
  }
  
  public void setSendGiftBtnEnabled(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSendGiftBtnEnabled, enabled=");
      localStringBuilder.append(paramBoolean);
      QLog.d("TroopGiftPanel", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel
 * JD-Core Version:    0.7.0.1
 */