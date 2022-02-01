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
  private static boolean af = false;
  public static int b = 1;
  public static int c = b;
  public static int d;
  public static int e;
  public static int f;
  protected TroopGiftAioItemData A;
  protected TroopGiftAioPanelData B;
  protected WeakReference<BaseChatPie> C;
  protected HorizontalListView D;
  protected TroopExclusiveGiftAdapter E;
  protected boolean F = false;
  protected TroopGiftPanel.OnShowOrHideListerner G;
  protected String H = "0";
  protected boolean I = true;
  protected int J = 0;
  protected String K;
  protected String L = "";
  protected View M;
  protected View N;
  protected ImageView O;
  protected TextView P;
  protected View Q;
  protected View R;
  protected ImageView S;
  protected TextView T;
  protected View U;
  protected int V;
  protected View.OnClickListener W = new TroopGiftPanel.9(this);
  protected String Z;
  protected String aa;
  private boolean ab = false;
  private View ac;
  private View ad;
  private com.tencent.gdtad.api.GdtAd ae;
  private TroopGiftPanel.FreeGiftGdtAdListener ag;
  private GdtMotiveVideoAd ah;
  private String ai = HardCodeUtil.a(2131912683);
  private String aj = "看广告0元送";
  private long ak = 0L;
  public String g = HardCodeUtil.a(2131912679);
  protected String h = "OidbSvc.0x6c3";
  protected int i = 1731;
  protected boolean j = false;
  protected int k = 0;
  protected WeakReference<AppInterface> l = null;
  protected Context m = null;
  protected SessionInfo n = null;
  protected boolean o = false;
  protected GridListViewPager[] p;
  protected View[] q;
  protected TextView r;
  protected TextView s;
  protected TextView t;
  protected View u;
  protected View v;
  protected View w;
  protected Button x;
  protected View y;
  protected int z;
  
  static
  {
    int i1 = c;
    d = i1 + 1;
    e = a;
    f = i1;
  }
  
  public TroopGiftPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m = paramContext;
    this.V = 1;
  }
  
  public TroopGiftPanel(Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner, boolean paramBoolean)
  {
    super(paramContext);
    this.m = paramContext;
    this.F = paramBoolean;
    this.G = paramOnShowOrHideListerner;
    this.g = HardCodeUtil.a(2131912670);
    this.V = 1;
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this(paramContext, paramBaseChatPie, 1, 0);
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.m = paramContext;
    this.C = new WeakReference(paramBaseChatPie);
    this.V = paramInt1;
    this.J = paramInt2;
    if ((paramInt2 == 2) || (paramInt2 == 7)) {
      this.g = HardCodeUtil.a(2131912664);
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
    localParams.q = 1;
    localParams.r = new WeakReference(paramActivity);
    localParams.b = paramBoolean;
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
          paramGdtAd = localGdtAd.getImageData().a;
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
            if (((GdtAdLoader)localObject2).a().b != null)
            {
              localObject2 = ((GdtAdLoader)localObject2).a().b.pos_ads_info.get();
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
    QQToast.makeText(getActivity(), HardCodeUtil.a(2131912668), 0).show();
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
    SharePreferenceUtils.a(getActivity(), "AIO_ACTIVITY_SHOW_TIME", String.valueOf(System.currentTimeMillis()));
    TroopGiftAioPanelData.AioActivityBubble localAioActivityBubble = paramWebPanelItemInfo.g;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)DisplayUtils.a(getContext(), localAioActivityBubble.a), (int)DisplayUtils.a(getContext(), localAioActivityBubble.b));
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(getActivity());
    paramViewGroup.addView(localDiniFlyAnimationView, localLayoutParams);
    localDiniFlyAnimationView.setAnimationFromUrl(localAioActivityBubble.c);
    localDiniFlyAnimationView.addLottieOnCompositionLoadedListener(new TroopGiftPanel.5(this, localAioActivityBubble));
    localDiniFlyAnimationView.setOnClickListener(new TroopGiftPanel.6(this, localAioActivityBubble, paramWebPanelItemInfo, localDiniFlyAnimationView));
    localDiniFlyAnimationView.playAnimation();
  }
  
  private void a(TroopGiftAioItemData paramTroopGiftAioItemData)
  {
    if (paramTroopGiftAioItemData != null)
    {
      if (paramTroopGiftAioItemData.e == 0)
      {
        c(0);
        if (this.V >= 4)
        {
          paramTroopGiftAioItemData = getTroopUin();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(getComeFrom());
          ((StringBuilder)localObject).append("");
          NearbyFlowerManager.a("gift_store", "exp_chose", paramTroopGiftAioItemData, ((StringBuilder)localObject).toString(), "", "");
          return;
        }
        int i1;
        if (AnonymousChatHelper.a().a(getTroopUin())) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        paramTroopGiftAioItemData = getTroopUin();
        Object localObject = this.H;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i1, 0, paramTroopGiftAioItemData, "", (String)localObject, localStringBuilder.toString());
        return;
      }
      c(8);
      return;
    }
    c(8);
  }
  
  private void a(LottieComposition paramLottieComposition, TroopGiftAioPanelData.AioActivityBubble paramAioActivityBubble)
  {
    paramAioActivityBubble = paramAioActivityBubble.f.iterator();
    while (paramAioActivityBubble.hasNext())
    {
      TroopGiftAioPanelData.AioActivity localAioActivity = (TroopGiftAioPanelData.AioActivity)paramAioActivityBubble.next();
      if ((localAioActivity.h) && (!TextUtils.isEmpty(localAioActivity.g)))
      {
        LottieImageAsset localLottieImageAsset = a(paramLottieComposition.getImages(), localAioActivity.g);
        if (localLottieImageAsset != null)
        {
          Bitmap localBitmap = Bitmap.createBitmap(localLottieImageAsset.getWidth(), localLottieImageAsset.getHeight(), Bitmap.Config.ARGB_8888);
          localLottieImageAsset.setBitmap(a(getActivity(), localBitmap, localAioActivity.a));
        }
      }
    }
  }
  
  private void a(ArrayList<TroopGiftAioPanelData.WebPanelItemInfo> paramArrayList)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131450080);
    localViewGroup.removeAllViews();
    localViewGroup.setBackgroundColor(0);
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        TroopGiftAioPanelData.WebPanelItemInfo localWebPanelItemInfo = (TroopGiftAioPanelData.WebPanelItemInfo)paramArrayList.get(i1);
        if ((localWebPanelItemInfo != null) && (localWebPanelItemInfo.e > 0) && (localWebPanelItemInfo.f > 0) && (localWebPanelItemInfo.c.length() != 0) && (localWebPanelItemInfo.d.length() != 0))
        {
          Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
          Object localObject2 = getContext();
          float f1;
          if (i1 == paramArrayList.size() - 1) {
            f1 = 10.0F;
          } else {
            f1 = 6.0F;
          }
          localRelativeLayout.setPadding(0, 0, (int)DisplayUtils.a((Context)localObject2, f1), 0);
          localViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
          Object localObject3 = new LinearLayout.LayoutParams((int)DisplayUtils.a(getContext(), localWebPanelItemInfo.e), (int)DisplayUtils.a(getContext(), localWebPanelItemInfo.f));
          localObject1 = new TroopGiftPanel.4(this, localWebPanelItemInfo);
          if (a(localWebPanelItemInfo.g))
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
            ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(localWebPanelItemInfo.c, (URLDrawable.URLDrawableOptions)localObject3));
            ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
          }
          localRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
        }
        i1 += 1;
      }
    }
  }
  
  private boolean a(TroopGiftAioPanelData.AioActivityBubble paramAioActivityBubble)
  {
    if ((paramAioActivityBubble != null) && (!TextUtils.isEmpty(paramAioActivityBubble.c)) && (paramAioActivityBubble.f != null))
    {
      if (paramAioActivityBubble.f.size() <= 0) {
        return false;
      }
      long l1 = System.currentTimeMillis();
      try
      {
        l2 = Long.valueOf(SharePreferenceUtils.a(getActivity(), "AIO_ACTIVITY_SHOW_TIME")).longValue();
        int i1 = paramAioActivityBubble.d;
        if (l1 - l2 < i1 * 1000) {
          return false;
        }
      }
      catch (Exception localException)
      {
        long l2;
        QLog.e("TroopGiftPanel", 4, localException, new Object[0]);
        SharePreferenceUtils.a(getActivity(), "AIO_ACTIVITY_SHOW_TIME", "0");
        paramAioActivityBubble = paramAioActivityBubble.f.iterator();
        while (paramAioActivityBubble.hasNext())
        {
          TroopGiftAioPanelData.AioActivity localAioActivity = (TroopGiftAioPanelData.AioActivity)paramAioActivityBubble.next();
          l2 = TimeFormatterUtils.a(localAioActivity.b);
          long l3 = TimeFormatterUtils.a(localAioActivity.c);
          if ((l1 >= l2) && (l1 < l3)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.ac == null) {
      return;
    }
    l();
    ((TextView)this.ac.findViewById(2131448499)).setText(HardCodeUtil.a(2131912663));
    this.ac.setContentDescription(HardCodeUtil.a(2131912667));
    ((TextView)this.ac.findViewById(2131448499)).setTextColor(Color.parseColor("#ff878b99"));
    ((TextView)this.ad.findViewById(2131448496)).setText(HardCodeUtil.a(2131912676));
    this.ad.setContentDescription(HardCodeUtil.a(2131912672));
    ((TextView)this.ad.findViewById(2131448496)).setTextColor(Color.parseColor("#ff878b99"));
    this.ac.findViewById(2131449821).setVisibility(8);
    this.ad.findViewById(2131449827).setVisibility(8);
    this.ac.setOnClickListener(new TroopGiftPanel.2(this));
    this.ad.setOnClickListener(new TroopGiftPanel.3(this));
  }
  
  private void e(String paramString)
  {
    paramString = c(paramString);
    Object localObject1 = new Intent(this.m, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    ((Intent)localObject1).putExtra("url", paramString);
    ((Intent)localObject1).putExtra("hide_more_button", true);
    ((Intent)localObject1).putExtra("hide_operation_bar", true);
    this.m.startActivity((Intent)localObject1);
    ((Activity)this.m).overridePendingTransition(2130772014, 2130772095);
    int i1 = this.J;
    if (i1 == 2)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_opr", 0, 0, "", "", "", "");
    }
    else if (i1 == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_opr", 0, 0, "", "", "", "");
    }
    else if (i1 == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_opr", 0, 0, "", "", "", "");
    }
    else
    {
      Object localObject2;
      if (this.V >= 4)
      {
        localObject1 = getTroopUin();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getComeFrom());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("clk_oper", "clk_oper", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      }
      else
      {
        if (AnonymousChatHelper.a().a(getTroopUin())) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        localObject1 = getTroopUin();
        localObject2 = this.H;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", i1, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
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
  
  private void l()
  {
    View localView = this.ac;
    if (localView != null) {
      localView.setSelected(false);
    }
    localView = this.ad;
    if (localView != null) {
      localView.setSelected(false);
    }
  }
  
  private void m()
  {
    e(this.L);
  }
  
  private void n()
  {
    Object localObject = this.B;
    if (localObject == null) {
      return;
    }
    ((TroopGiftAioPanelData)localObject).o = 0;
    if (((TroopGiftAioPanelData)localObject).g != null)
    {
      int i2 = this.B.g.size();
      i1 = c;
      if (i2 == i1)
      {
        i2 = this.k;
        if ((i2 >= 0) && (i2 < i1))
        {
          localObject = (TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(this.k);
          if (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).c != null)
          {
            i1 = 0;
            while (i1 < ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).c.size())
            {
              TroopGiftAioItemData localTroopGiftAioItemData = (TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).c.get(i1);
              boolean bool;
              if (i1 == 0) {
                bool = true;
              } else {
                bool = false;
              }
              localTroopGiftAioItemData.k = bool;
              i1 += 1;
            }
          }
        }
      }
    }
    int i1 = this.k;
    if (i1 >= 0)
    {
      localObject = this.p;
      if ((i1 < localObject.length) && (localObject[i1].getAdapter() != null)) {
        this.p[this.k].a();
      }
    }
  }
  
  private void o()
  {
    GdtMotiveVideoParams localGdtMotiveVideoParams = new GdtMotiveVideoParams();
    localGdtMotiveVideoParams.a = a(Long.parseLong(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface().getCurrentAccountUin()), "4040385433442243");
    localGdtMotiveVideoParams.b = a(true, getActivity());
    this.ah = new GdtMotiveVideoAd(localGdtMotiveVideoParams);
    this.ah.setListener(new WeakReference(this.ag));
    this.ah.load(getActivity());
  }
  
  private boolean p()
  {
    return (this.A != null) && (this.B.j != null) && (this.B.w.size() > 0) && (this.B.j.size() > 0);
  }
  
  public void a()
  {
    inflate(getContext(), 2131626702, this);
  }
  
  protected void a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      localObject = this.q;
      if (i1 >= localObject.length) {
        break;
      }
      if (i1 != paramInt) {
        localObject[i1].setVisibility(8);
      } else {
        localObject[i1].setVisibility(0);
      }
      i1 += 1;
    }
    Object localObject = this.u;
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
      this.x.setText(this.ai);
      af = true;
    }
    o();
  }
  
  protected void a(View paramView1, View paramView2, View paramView3)
  {
    if (j())
    {
      paramView1.findViewById(2131439797).setVisibility(0);
      this.M.setVisibility(0);
      paramView2.findViewById(2131439797).setVisibility(0);
      paramView2.findViewById(2131440842).setVisibility(0);
      paramView3.findViewById(2131439797).setVisibility(0);
      this.Q.setVisibility(0);
      paramView1 = findViewById(2131429409);
      paramView2 = paramView1.getLayoutParams();
      paramView2.height = ((int)DisplayUtils.a(getContext(), 400.0F));
      paramView1.setLayoutParams(paramView2);
      paramView1 = (AppInterface)this.l.get();
      paramView2 = getTroopUin();
      paramView3 = TroopGiftAioPanelData.c(paramView2);
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
      paramString.setBounds(0, 0, (int)DisplayUtils.a(this.m, 13.0F), (int)DisplayUtils.a(this.m, 14.0F));
      paramTextView.setCompoundDrawables(paramString, null, null, null);
      paramTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.m, 2.0F));
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
    localObject = (AppInterface)this.l.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    String str1 = this.h;
    int i2 = this.i;
    int i3 = this.V;
    String str2 = getTroopUin();
    int i1;
    if (this.V >= 4) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    ((TroopGiftManager)localObject).a(str1, i2, i3, str2, 2, i1, new TroopGiftPanel.11(this, paramOnGetGiveGiftCallback));
  }
  
  public void a(TroopGiftPanel.OnGetPackGiftCallback paramOnGetPackGiftCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPackGiftStorage, callback=");
    ((StringBuilder)localObject).append(paramOnGetPackGiftCallback);
    QLog.d("TroopGiftPanel", 1, ((StringBuilder)localObject).toString());
    localObject = (AppInterface)this.l.get();
    if (localObject == null) {
      return;
    }
    ((TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(new TroopGiftPanel.21(this, paramOnGetPackGiftCallback));
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a();
    this.l = new WeakReference(paramAppInterface);
    this.n = paramSessionInfo;
    this.v = findViewById(2131437622);
    this.w = findViewById(2131431353);
    this.D = ((HorizontalListView)findViewById(2131446731));
    this.E = new TroopExclusiveGiftAdapter();
    this.D.setAdapter(this.E);
    this.ac = findViewById(2131437462);
    this.ad = findViewById(2131437466);
    d(paramBoolean);
    a(paramBoolean);
    this.x = ((Button)findViewById(2131430018));
    this.y = findViewById(2131430019);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.x.setText(this.g);
    this.r = ((TextView)findViewById(2131432373));
    this.r.setOnClickListener(this);
    this.u = findViewById(2131429674);
    this.u.setOnClickListener(this);
    this.s = ((TextView)findViewById(2131446397));
    this.t = ((TextView)findViewById(2131434286));
    this.s.setOnClickListener(this);
    findViewById(2131444547).setOnClickListener(this);
    findViewById(2131429409).setOnClickListener(this);
    this.D.setOnItemClickListener(new TroopGiftPanel.1(this));
    l();
    this.E.a(this.k);
    a(this.k);
    this.ag = new TroopGiftPanel.FreeGiftGdtAdListener(this);
    o();
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.r;
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
      if (!paramString1.equals(this.Z)) {
        TroopGiftAioPanelData.b(getTroopUin(), paramString1);
      }
      this.Z = paramString1;
      this.aa = paramString2;
      this.N.setVisibility(0);
      this.M.setVisibility(8);
      paramString2 = new ColorNickText(this.aa, 16).b();
      this.P.setText(paramString2);
      this.R.setVisibility(0);
      this.Q.setVisibility(8);
      paramString2 = new ColorNickText(this.aa, 16).b();
      this.T.setText(paramString2);
      paramString2 = ImageUtil.m();
      localObject = (AppInterface)this.l.get();
      if (localObject != null)
      {
        paramString1 = FaceDrawable.getFaceDrawable((AppInterface)localObject, 1, paramString1, 3, paramString2, paramString2);
        this.O.setImageDrawable(paramString1);
        this.S.setImageDrawable(paramString1);
      }
      else
      {
        this.O.setImageDrawable(paramString2);
        this.S.setImageDrawable(paramString2);
      }
    }
    setSendGiftBtnEnabled(TextUtils.isEmpty(this.Z) ^ true);
  }
  
  protected void a(boolean paramBoolean)
  {
    a = 0;
    b = 1;
    c = b;
    int i1 = c;
    d = i1 + 1;
    e = a;
    f = i1;
    Object localObject1 = new TroopExclusiveGiftAdapter.TroopExclusiveGiftData();
    ((TroopExclusiveGiftAdapter.TroopExclusiveGiftData)localObject1).a = getResources().getString(2131895527);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    this.E.a((List)localObject2);
    this.p = new GridListViewPager[3];
    this.q = new View[3];
    localObject1 = (RadioViewPager)findViewById(2131449794);
    localObject2 = (RadioViewPager)findViewById(2131449795);
    RadioViewPager localRadioViewPager = (RadioViewPager)findViewById(2131449796);
    ((RadioViewPager)localObject1).setGiftPanel(this);
    ((RadioViewPager)localObject2).setGiftPanel(this);
    localRadioViewPager.setGiftPanel(this);
    this.M = ((RadioViewPager)localObject1).findViewById(2131445537);
    this.N = ((RadioViewPager)localObject1).findViewById(2131444367);
    this.O = ((ImageView)((RadioViewPager)localObject1).findViewById(2131444366));
    this.P = ((TextView)((RadioViewPager)localObject1).findViewById(2131444369));
    Object localObject3 = ((RadioViewPager)localObject1).findViewById(2131430479);
    this.Q = localRadioViewPager.findViewById(2131445537);
    this.R = localRadioViewPager.findViewById(2131444367);
    this.S = ((ImageView)localRadioViewPager.findViewById(2131444366));
    this.T = ((TextView)localRadioViewPager.findViewById(2131444369));
    this.U = localRadioViewPager.findViewById(2131439797);
    View localView = localRadioViewPager.findViewById(2131430479);
    localRadioViewPager.setEmptyInfo(BaseApplication.getContext().getString(2131895322), BaseApplication.getContext().getString(2131895323));
    localRadioViewPager.setIsShowJumpInfo(false, "", this.m);
    this.M.setOnClickListener(this.W);
    ((View)localObject3).setOnClickListener(this.W);
    this.Q.setOnClickListener(this.W);
    localView.setOnClickListener(this.W);
    a((View)localObject1, (View)localObject2, localRadioViewPager);
    localObject3 = this.q;
    i1 = a;
    localObject3[i1] = localObject1;
    localObject3[c] = localObject2;
    localObject3[d] = localRadioViewPager;
    this.I = paramBoolean;
    this.p[i1] = ((GridListViewPager)((RadioViewPager)localObject1).getViewPager());
    this.p[a].setOnItemClickListener(this);
    this.p[c] = ((GridListViewPager)((RadioViewPager)localObject2).getViewPager());
    this.p[c].setOnItemClickListener(this);
    this.p[d] = ((GridListViewPager)localRadioViewPager.getViewPager());
    this.p[d].setOnItemClickListener(this);
  }
  
  protected boolean a(int paramInt, TroopGiftManager.GiveGift paramGiveGift)
  {
    int i2 = this.z;
    int i1 = 1;
    if ((i2 < paramInt) && ((paramGiveGift == null) || (paramGiveGift.b + paramGiveGift.c == 0)))
    {
      paramInt = i1;
      if (AnonymousChatHelper.a().a(getTroopUin())) {
        paramInt = 2;
      }
      paramGiveGift = this.m.getResources();
      DialogUtil.a(this.m, 230, paramGiveGift.getString(2131895529), paramGiveGift.getString(2131895528), paramGiveGift.getString(2131887648), paramGiveGift.getString(2131895531), new TroopGiftPanel.19(this, paramInt), new TroopGiftPanel.20(this)).show();
      k();
      return false;
    }
    return true;
  }
  
  public void b()
  {
    Object localObject = (AppInterface)this.l.get();
    String str1 = getTroopUin();
    String str2 = TroopGiftAioPanelData.c(str1);
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
    g();
  }
  
  public void b(int paramInt)
  {
    a("1");
    Object localObject1 = this.A;
    if ((localObject1 != null) && (((TroopGiftAioItemData)localObject1).e == 0))
    {
      c(0);
      Object localObject2;
      if (this.V >= 4)
      {
        localObject1 = getTroopUin();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getComeFrom());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_store", "exp_chose", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      }
      else
      {
        int i1;
        if (AnonymousChatHelper.a().a(getTroopUin())) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        localObject1 = getTroopUin();
        localObject2 = this.H;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i1, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
      }
    }
    else
    {
      c(8);
    }
    localObject1 = this.B;
    if (localObject1 != null) {
      ((TroopGiftAioPanelData)localObject1).o = 0;
    }
    this.k = paramInt;
    localObject1 = this.B;
    if ((localObject1 == null) || (((TroopGiftAioPanelData)localObject1).i == null)) {
      this.k = a;
    }
    l();
    localObject1 = this.E;
    if (localObject1 != null) {
      ((TroopExclusiveGiftAdapter)localObject1).a(this.k);
    }
    onTabSelected(0, this.k);
    d(this.I);
  }
  
  public void b(String paramString)
  {
    paramString = c(paramString).replace("http://", "https://");
    if (paramString.contains("?"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&troop_uin=");
      ((StringBuilder)localObject).append(getTroopUin());
      paramString = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?troop_uin=");
      ((StringBuilder)localObject).append(getTroopUin());
      paramString = ((StringBuilder)localObject).toString();
    }
    Object localObject = new Intent(this.m, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    this.m.startActivity((Intent)localObject);
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
    if ((AppInterface)this.l.get() == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = this.B;
    if (localObject2 != null) {
      localObject1 = ((TroopGiftAioPanelData)localObject2).v;
    }
    int i1 = 36;
    int i2 = 0;
    if (localObject1 != null)
    {
      localObject2 = ((GiftConfigManager.ImgEntryItem)localObject1).a;
      i2 = ((GiftConfigManager.ImgEntryItem)localObject1).d;
      i1 = ((GiftConfigManager.ImgEntryItem)localObject1).c;
      this.L = ((GiftConfigManager.ImgEntryItem)localObject1).b;
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "panelEntryItem", 0, 0, "", "", "", "");
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = this.B;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).l != null) && (!TextUtils.isEmpty(this.B.l.a)))
      {
        localObject1 = this.B.l.a;
        this.L = this.B.l.b;
        i2 = 36;
      }
      else
      {
        localObject1 = "";
        i1 = 0;
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i2 > 0) && (i1 > 0))
    {
      i1 = this.J;
      if (i1 == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_opr", 0, 0, "", "", "", "");
        return;
      }
      if (i1 == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_opr", 0, 0, "", "", "", "");
        return;
      }
      if (i1 == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_opr", 0, 0, "", "", "", "");
        return;
      }
      if (this.V >= 4)
      {
        localObject1 = getTroopUin();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getComeFrom());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_store", "exp_oper", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
        return;
      }
      if (AnonymousChatHelper.a().a(getTroopUin())) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      localObject1 = getTroopUin();
      localObject2 = this.H;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", i1, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
    }
  }
  
  public String c(String paramString)
  {
    Object localObject1 = paramString;
    if (paramString != null)
    {
      Object localObject2 = this.l;
      localObject1 = paramString;
      if (localObject2 != null)
      {
        if (this.n == null) {
          return paramString;
        }
        int i1 = this.J;
        localObject1 = paramString;
        if (i1 != 2)
        {
          if (i1 == 7) {
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
            localObject3 = ((TroopManager)localObject3).g(getTroopUin());
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
          localObject1 = paramString.replace("$GCODE$", getTroopUin()).replace("$CLIENTVER$", "android8.8.17").replace("$UIN$", localAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public void c(int paramInt)
  {
    this.r.setVisibility(paramInt);
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public void d()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.B.m.c);
    ((StringBuilder)localObject1).append("?_bid=3913&_wvSb=1&from=7&troopUin=%s");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    if (this.n.c != null) {
      localObject1 = this.n.c;
    } else {
      localObject1 = this.n.b;
    }
    localObject1 = String.format((String)localObject2, new Object[] { localObject1 });
    localObject2 = new Intent(this.m, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("url", c((String)localObject1));
    this.m.startActivity((Intent)localObject2);
    ((Activity)this.m).overridePendingTransition(2130772014, 0);
  }
  
  protected void d(int paramInt)
  {
    String str;
    if (this.n.c != null) {
      str = this.n.c;
    } else {
      str = this.n.b;
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
  
  public void d(String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i4 = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerSendGiftToPerson, uin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopGiftPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AppInterface)this.l.get();
    if (localObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = (TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
      TroopGiftAioItemData localTroopGiftAioItemData = this.A;
      int i3 = localTroopGiftAioItemData.e;
      if (localTroopGiftAioItemData.e == 0) {
        i3 = getGiftNum();
      }
      bool = AnonymousChatHelper.a().a(this.n.b);
      int i1 = 6;
      if (bool) {}
      int i2;
      for (;;)
      {
        i2 = 0;
        break;
        i1 = this.J;
        if (i1 == 2)
        {
          i1 = 9;
          i2 = 1;
          break;
        }
        if (i1 == 6)
        {
          i1 = 10;
        }
        else if (i1 == 7)
        {
          i1 = this.n.a;
          if (i1 != 1000)
          {
            if (i1 != 1004)
            {
              i1 = 11;
            }
            else
            {
              i1 = 11;
              i2 = 513;
              break;
            }
          }
          else
          {
            i1 = 11;
            i2 = 512;
            break;
          }
        }
        else
        {
          i1 = 0;
        }
      }
      if (!AnonymousChatHelper.a().a(getTroopUin())) {
        i4 = 1;
      }
      int i6 = this.V;
      String str = getTroopUin();
      long l1 = Long.parseLong(paramString);
      int i7 = localTroopGiftAioItemData.f;
      int i5;
      if (localTroopGiftAioItemData.e == 0) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      ((TroopGiftManager)localObject).a("OidbSvc.0x6b6", 1718, i1, i6, str, 2, i3, l1, i7, i5, localTroopGiftAioItemData.d, i2, new TroopGiftPanel.18(this, i4, localTroopGiftAioItemData), localTroopGiftAioItemData.i);
      this.A.k = false;
      this.A = null;
    }
  }
  
  public void e()
  {
    View localView = this.w;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.v;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  protected void f()
  {
    if (this.J == 6)
    {
      localIntent = new Intent();
      localIntent.putExtra("troop_uin", this.n.b);
      localIntent.putExtra("param_from", 16);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131895520));
      localIntent.setFlags(603979776);
      RouteUtils.a(this.m, localIntent, "/troop/memberlist/TroopMemberList", 12006);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", getTroopUin());
    localIntent.putExtra("param_from", 14);
    localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131895520));
    if (this.l.get() != null) {
      localIntent.putExtra("troop_gift_from", ((AppInterface)this.l.get()).getCurrentAccountUin());
    }
    if (!this.F) {
      RouteUtils.a(this.m, localIntent, "/troop/memberlist/TroopMemberList", 12006);
    }
  }
  
  public void g()
  {
    View localView = this.N;
    if ((localView != null) && (this.M != null))
    {
      localView.setVisibility(8);
      this.M.setVisibility(0);
    }
  }
  
  public Activity getActivity()
  {
    return (Activity)this.m;
  }
  
  protected int getComeFrom()
  {
    int i1 = this.V;
    if (i1 != 4)
    {
      if (i1 != 5)
      {
        if (i1 != 6)
        {
          if (i1 != 8) {
            return i1;
          }
          return 508;
        }
        return 504;
      }
      return 2;
    }
    if ((this.C.get() instanceof HotChatPie))
    {
      HotChatPie localHotChatPie = (HotChatPie)this.C.get();
      if ((localHotChatPie.bR != null) && (localHotChatPie.bR.isBuLuoHotChat())) {
        return 507;
      }
      return 503;
    }
    return -1;
  }
  
  public int getGiftNum()
  {
    CharSequence localCharSequence = this.r.getText();
    try
    {
      if (TextUtils.isEmpty(localCharSequence)) {
        break label70;
      }
      int i1 = Integer.parseInt(localCharSequence.toString().substring(1));
      return i1;
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
  
  public int getRewardGiftCnt()
  {
    return 0;
  }
  
  public String getTroopUin()
  {
    int i1 = this.J;
    if (i1 == 2) {
      return null;
    }
    if (i1 == 7) {
      return this.n.c;
    }
    return this.n.b;
  }
  
  public boolean h()
  {
    return true;
  }
  
  public boolean i()
  {
    return true;
  }
  
  protected boolean j()
  {
    int i1 = this.J;
    return (i1 != 2) && (i1 != 7) && (i1 != 3);
  }
  
  public void k()
  {
    int i1;
    if (AnonymousChatHelper.a().a(getTroopUin())) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    int i2 = this.J;
    if (i2 == 2)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (i2 == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (i2 == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.V >= 4)
    {
      str = getTroopUin();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getComeFrom());
      ((StringBuilder)localObject).append("");
      NearbyFlowerManager.a("gift_store", "exp_tip", str, ((StringBuilder)localObject).toString(), "", "");
      return;
    }
    String str = getTroopUin();
    Object localObject = this.H;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", i1, 0, str, "", (String)localObject, localStringBuilder.toString());
  }
  
  public void onClick(View paramView)
  {
    boolean bool = AnonymousChatHelper.a().a(getTroopUin());
    int i3 = 1;
    int i2;
    if (bool) {
      i2 = 2;
    } else {
      i2 = 1;
    }
    int i1 = paramView.getId();
    int i4 = 0;
    Object localObject2;
    Object localObject3;
    switch (i1)
    {
    default: 
      break;
    case 2131445616: 
      f();
      break;
    case 2131444547: 
      localObject1 = this.B;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).m != null) && (!TextUtils.isEmpty(this.B.m.c)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.B.m.c);
        ((StringBuilder)localObject1).append("?_bid=3913&_wvSb=1&from=7&troopUin=%s");
        localObject2 = ((StringBuilder)localObject1).toString();
        if (this.n.c != null) {
          localObject1 = this.n.c;
        } else {
          localObject1 = this.n.b;
        }
        localObject1 = String.format((String)localObject2, new Object[] { localObject1 });
        localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("url", c((String)localObject1));
        getActivity().startActivityForResult((Intent)localObject2, 12007);
        getActivity().overridePendingTransition(2130772014, 2130772095);
      }
      i1 = this.J;
      if (i1 == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_pay", 0, 0, "", "", "", "");
      }
      else if (i1 == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_pay", 0, 0, "", "", "", "");
      }
      else if (i1 == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_pay", 0, 0, "", "", "", "");
      }
      else if (this.V >= 4)
      {
        localObject1 = getTroopUin();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getComeFrom());
        ((StringBuilder)localObject2).append("");
        NearbyFlowerManager.a("gift_store", "clk_pay", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      }
      else
      {
        localObject1 = getTroopUin();
        localObject2 = this.H;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", i2, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
      }
      break;
    case 2131432373: 
    case 2131432374: 
      new TroopGiftPanel.GiftNumInputDialog(this, getActivity()).a();
      if (this.F) {
        this.G.b();
      } else {
        ((GiftPanelHelper)((BaseChatPie)this.C.get()).q(136)).e();
      }
      i1 = i3;
    }
    label2728:
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        i1 = i3;
        if (!Settings.System.canWrite(getActivity()))
        {
          QLog.i("TroopGiftPanel", 1, "can not write settings");
          i1 = 0;
        }
      }
      if (i1 == 0) {
        break label752;
      }
      Settings.System.putInt(this.m.getContentResolver(), "accelerometer_rotation", 0);
    }
    catch (SecurityException localSecurityException)
    {
      label736:
      label752:
      int i5;
      label1705:
      long l1;
      label2227:
      label2777:
      break label736;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "SecurityException ");
    }
    if (this.V >= 4)
    {
      localObject1 = getTroopUin();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getComeFrom());
      ((StringBuilder)localObject2).append("");
      NearbyFlowerManager.a("gift_store", "clk_chose", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    }
    else
    {
      localObject1 = getTroopUin();
      localObject2 = this.H;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", i2, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
      break label2777;
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "sendGiftMaskBtn onClick");
      }
      localObject1 = this.A;
      i1 = i4;
      if (localObject1 != null) {
        if (((TroopGiftAioItemData)localObject1).i > 0)
        {
          i1 = this.A.i;
        }
        else
        {
          i1 = i4;
          if (this.A.d > 0) {
            i1 = this.A.d;
          }
        }
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(i1), "", "", "");
      if (((this.k != d) || (this.x.isEnabled()) || (p())) && (j()) && (TextUtils.isEmpty(this.Z)) && (!this.x.isEnabled()))
      {
        QQToast.makeText(getContext(), 1, HardCodeUtil.a(2131912682), 1).show();
        break label2777;
        i1 = c;
        i3 = this.k;
        if (i1 == i3)
        {
          if (this.V >= 4)
          {
            localObject1 = getTroopUin();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(getComeFrom());
            ((StringBuilder)localObject2).append("");
            NearbyFlowerManager.a("gift_store", "clk_now", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
          else
          {
            localObject1 = getTroopUin();
            localObject2 = this.H;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", i2, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
          }
        }
        else if ((i3 >= 0) && (i3 < i1))
        {
          i1 = this.J;
          if (i1 == 2)
          {
            ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_send", 0, 0, "", "", "", "");
          }
          else if (i1 == 6)
          {
            ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_send", 0, 0, "", "", "", "");
          }
          else if (i1 == 7)
          {
            ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_send", 0, 0, "", "", "", "");
          }
          else if (this.V >= 4)
          {
            localObject1 = getTroopUin();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(getComeFrom());
            ((StringBuilder)localObject2).append("");
            NearbyFlowerManager.a("gift_store", "clk_send", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
          else
          {
            localObject1 = getTroopUin();
            localObject2 = this.H;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", i2, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
            localObject1 = getTroopUin();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
            ReportController.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_addpage", i2, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
        }
        localObject1 = this.A;
        if (localObject1 != null)
        {
          if (((TroopGiftAioItemData)localObject1).i > 0)
          {
            i1 = this.A.i;
            break label1705;
          }
          if (this.A.d > 0)
          {
            i1 = this.A.d;
            break label1705;
          }
        }
        i1 = 0;
        ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(i1), "", "", "");
        localObject2 = (AppInterface)this.l.get();
        if (localObject2 != null)
        {
          localObject3 = this.A;
          if (localObject3 != null)
          {
            i1 = ((TroopGiftAioItemData)localObject3).e;
            if (((TroopGiftAioItemData)localObject3).e == 0) {
              i1 = getGiftNum();
            }
            if ((this.k != d) || (!this.A.q))
            {
              do
              {
                bool = this.B.a(this.k);
                localObject1 = this.B.s;
                if (((TroopGiftAioItemData)localObject3).i != 0) {
                  i3 = ((TroopGiftAioItemData)localObject3).i;
                } else {
                  i3 = ((TroopGiftAioItemData)localObject3).d;
                }
                localObject1 = (TroopGiftManager.GiveGift)((SparseArray)localObject1).get(i3);
              } while ((bool) || (a(i1, (TroopGiftManager.GiveGift)localObject1)));
              if (QLog.isColorLevel()) {
                QLog.d("TroopGiftPanel", 2, "isStorageEnough: false");
              }
            }
            else
            {
              i3 = c;
              i4 = this.k;
              if (i3 == i4)
              {
                localObject2 = (TroopGiftManager)((AppInterface)localObject2).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
                if (((TroopGiftAioItemData)localObject3).m)
                {
                  i4 = this.V;
                  localObject1 = getTroopUin();
                  i5 = ((TroopGiftAioItemData)localObject3).f;
                  if (((TroopGiftAioItemData)localObject3).e == 0) {
                    i3 = 1;
                  } else {
                    i3 = 0;
                  }
                  ((TroopGiftManager)localObject2).a("OidbSvc.0x6b6", 1718, 8, i4, (String)localObject1, 2, i1, 0L, i5, i3, ((TroopGiftAioItemData)localObject3).d, 0, new TroopGiftPanel.14(this, i2, (TroopGiftAioItemData)localObject3), ((TroopGiftAioItemData)localObject3).i);
                }
                else
                {
                  if (this.j) {
                    i2 = 3;
                  } else {
                    i2 = 1;
                  }
                  if (this.j) {
                    localObject1 = "OidbSvc.0x7f6";
                  } else {
                    localObject1 = "OidbSvc.0x6b6";
                  }
                  if (this.j) {
                    i3 = 2038;
                  } else {
                    i3 = 1718;
                  }
                  ((TroopGiftManager)localObject2).a((String)localObject1, i3, i2, this.V, getTroopUin(), 2, i1, 1, ((TroopGiftAioItemData)localObject3).d, new TroopGiftPanel.15(this, (TroopGiftAioItemData)localObject3));
                }
                localObject1 = this.G;
                if (localObject1 != null)
                {
                  ((TroopGiftPanel.OnShowOrHideListerner)localObject1).b();
                  break label2777;
                }
              }
              else if ((i4 >= 0) && (i4 < i3))
              {
                if (this.F)
                {
                  localObject1 = this.K;
                  break label2777;
                }
                i1 = this.J;
                if ((i1 != 2) && (i1 != 7)) {
                  localObject1 = this.Z;
                } else {
                  localObject1 = ((BaseChatPie)this.C.get()).ah.b;
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
    if (AnonymousChatHelper.a().a(this.n.b))
    {
      i1 = 4;
    }
    else
    {
      i1 = this.J;
      if (i1 == 2) {
        i1 = 7;
      } else if (i1 == 6) {
        i1 = 8;
      } else {
        i1 = 1;
      }
    }
    Object localObject1 = this.B;
    if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).a(this.k)))
    {
      if (System.currentTimeMillis() - this.ak >= 500L)
      {
        this.ak = System.currentTimeMillis();
        if (af)
        {
          af = false;
          ((TroopGiftManager)((AppInterface)localObject2).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(this.A, i1, getTroopUin(), l1, new TroopGiftPanel.16(this));
        }
        else
        {
          localObject1 = a(0, this.ae, 1, true);
          a(getActivity(), (GdtMotiveVideoPageData)localObject1);
        }
      }
    }
    else
    {
      localObject1 = this.A;
      if ((localObject1 != null) && (((TroopGiftAioItemData)localObject1).r == 1) && ((this.l.get() instanceof QQAppInterface)) && (!VasUtil.b((AppRuntime)this.l.get()).getVipStatus().isSVip()))
      {
        localObject1 = new TroopGiftPanel.17(this);
        localObject1 = DialogUtil.a(this.m, 0, getResources().getString(2131895325), getResources().getString(2131895324), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131912673), (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
        if (localObject1 != null) {
          ((QQCustomDialog)localObject1).show();
        }
        ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_window_view", 0, 0, "", "", "", "");
      }
      else if (this.F)
      {
        this.G.b();
        d(this.K);
      }
      else
      {
        i1 = this.J;
        if ((i1 != 2) && (i1 != 7))
        {
          d(this.Z);
        }
        else
        {
          d(((BaseChatPie)this.C.get()).ah.b);
          break label2728;
          if (d == this.k)
          {
            if (this.F)
            {
              this.G.b();
              d(this.K);
              break label2777;
            }
            i1 = this.J;
            if ((i1 != 2) && (i1 != 7)) {
              d(this.Z);
            } else {
              d(((BaseChatPie)this.C.get()).ah.b);
            }
          }
        }
        if (this.C.get() != null)
        {
          ((GiftPanelHelper)((BaseChatPie)this.C.get()).q(136)).e();
          break label2777;
          if (!TextUtils.isEmpty(this.L)) {
            m();
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i1 == 1) || (i1 == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getTag() instanceof GridListAdapter.Holder))
    {
      TroopGiftAioItemData localTroopGiftAioItemData = ((GridListAdapter.Holder)paramView.getTag()).l;
      boolean bool = localTroopGiftAioItemData.k;
      int i2 = 0;
      int i1;
      if ((!bool) && ((paramAdapterView.getAdapter() instanceof GridListAdapter)))
      {
        this.A = localTroopGiftAioItemData;
        localTroopGiftAioItemData.k = true;
        i1 = this.k;
        Object localObject1;
        Object localObject2;
        if ((i1 >= 0) && (i1 < c))
        {
          if ((this.B.g != null) && (this.B.g.size() == c))
          {
            localObject1 = (TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(this.k);
            if (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject1).c != null)
            {
              i1 = 0;
              while (i1 < ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject1).c.size())
              {
                localObject2 = (TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)localObject1).c.get(i1);
                if (((TroopGiftAioItemData)localObject2).d == localTroopGiftAioItemData.d) {
                  this.B.o = i1;
                } else {
                  ((TroopGiftAioItemData)localObject2).k = false;
                }
                i1 += 1;
              }
            }
          }
          this.p[this.k].a();
        }
        else
        {
          i1 = this.k;
          if (i1 == c)
          {
            if ((this.B.p >= 0) && (this.B.p < this.B.i.size())) {
              ((TroopGiftAioItemData)this.B.i.get(this.B.p)).k = false;
            }
            this.B.p = localTroopGiftAioItemData.l;
            this.p[c].a();
          }
          else if (i1 == d)
          {
            if ((this.B.q >= 0) && (this.B.q < this.B.j.size())) {
              ((TroopGiftAioItemData)this.B.j.get(this.B.q)).k = false;
            }
            this.B.q = localTroopGiftAioItemData.l;
            this.p[d].a();
          }
        }
        if (localTroopGiftAioItemData.e == 0)
        {
          c(0);
          if (this.V >= 4)
          {
            localObject1 = getTroopUin();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(getComeFrom());
            ((StringBuilder)localObject2).append("");
            NearbyFlowerManager.a("gift_store", "exp_chose", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          }
          else
          {
            if (AnonymousChatHelper.a().a(getTroopUin())) {
              i1 = 2;
            } else {
              i1 = 1;
            }
            localObject1 = getTroopUin();
            localObject2 = this.H;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i1, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString());
          }
        }
        else
        {
          c(8);
        }
      }
      if (localTroopGiftAioItemData.i > 0)
      {
        i1 = localTroopGiftAioItemData.i;
      }
      else
      {
        i1 = i2;
        if (localTroopGiftAioItemData.d > 0) {
          i1 = localTroopGiftAioItemData.d;
        }
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_click", 0, 0, String.valueOf(i1), "", "", "");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.k = paramInt2;
    a(this.k);
    if ((paramInt2 >= 0) && (paramInt2 < c))
    {
      this.M = this.q[paramInt2].findViewById(2131445537);
      this.N = this.q[paramInt2].findViewById(2131444367);
      this.O = ((ImageView)this.q[paramInt2].findViewById(2131444366));
      this.P = ((TextView)this.q[paramInt2].findViewById(2131444369));
      localObject1 = this.q[paramInt2].findViewById(2131430479);
      this.M.setOnClickListener(this.W);
      ((View)localObject1).setOnClickListener(this.W);
      b();
      l();
      this.E.a(paramInt2);
      d(this.I);
      n();
    }
    else
    {
      this.E.a(-1);
    }
    boolean bool1 = AnonymousChatHelper.a().a(getTroopUin());
    boolean bool2 = this.q[paramInt2].findViewById(2131445568) instanceof TextView;
    Object localObject2 = "#878B99";
    Object localObject3;
    if (bool2)
    {
      localObject3 = (TextView)this.q[paramInt2].findViewById(2131445568);
      if (bool1) {
        localObject1 = "#878B99";
      } else {
        localObject1 = "#000000";
      }
      ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject1));
    }
    if ((this.q[paramInt2].findViewById(2131445537) instanceof TextView))
    {
      localObject3 = (TextView)this.q[paramInt2].findViewById(2131445537);
      if (bool1) {
        localObject1 = localObject2;
      } else {
        localObject1 = "#000000";
      }
      ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject1));
    }
    Object localObject1 = this.B;
    if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).a(this.k)))
    {
      if (af) {
        this.x.setText(this.ai);
      } else {
        this.x.setText(this.aj);
      }
    }
    else {
      this.x.setText(this.g);
    }
    localObject2 = null;
    if ((paramInt2 >= 0) && (paramInt2 < c))
    {
      localObject1 = this.B;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).g != null) && (this.B.g.size() == c) && (this.B.o != -1))
      {
        localObject1 = localObject2;
        if (((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(paramInt2)).c.size() <= this.B.o) {
          break label671;
        }
        localObject1 = (TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(paramInt2)).c.get(this.B.o);
        break label671;
      }
    }
    if (paramInt2 == c)
    {
      localObject1 = this.B;
      if ((localObject1 != null) && (((TroopGiftAioPanelData)localObject1).p != -1))
      {
        localObject1 = (TroopGiftAioItemData)this.B.i.get(this.B.p);
        break label671;
      }
    }
    localObject1 = localObject2;
    if (paramInt2 == d)
    {
      localObject3 = this.B;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((TroopGiftAioPanelData)localObject3).j != null)
        {
          localObject1 = localObject2;
          if (this.B.j.size() > 0)
          {
            localObject1 = localObject2;
            if (this.B.w.size() > 0)
            {
              localObject1 = localObject2;
              if (this.B.q != -1) {
                localObject1 = (TroopGiftAioItemData)this.B.j.get(this.B.q);
              }
            }
          }
        }
      }
    }
    label671:
    int i1 = 2;
    bool2 = false;
    localObject2 = "";
    Object localObject4;
    if (localObject1 != null)
    {
      if (((TroopGiftAioItemData)localObject1).e == 0)
      {
        c(0);
        if (this.V >= 4)
        {
          localObject3 = getTroopUin();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(getComeFrom());
          ((StringBuilder)localObject4).append("");
          NearbyFlowerManager.a("gift_store", "exp_chose", (String)localObject3, ((StringBuilder)localObject4).toString(), "", "");
        }
        else
        {
          if (AnonymousChatHelper.a().a(getTroopUin())) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
          localObject3 = getTroopUin();
          localObject4 = this.H;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
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
    this.A = ((TroopGiftAioItemData)localObject1);
    if (AnonymousChatHelper.a().a(getTroopUin())) {
      paramInt1 = i1;
    } else {
      paramInt1 = 1;
    }
    if ((paramInt2 >= 0) && (paramInt2 < c))
    {
      if (this.V >= 4)
      {
        localObject1 = getTroopUin();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(getComeFrom());
        ((StringBuilder)localObject3).append("");
        NearbyFlowerManager.a("gift_store", "exp_one", (String)localObject1, ((StringBuilder)localObject3).toString(), "", "");
      }
      else
      {
        localObject1 = getTroopUin();
        localObject3 = this.H;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", paramInt1, 0, (String)localObject1, "", (String)localObject3, ((StringBuilder)localObject4).toString());
      }
      if (j()) {
        setSendGiftBtnEnabled(TextUtils.isEmpty(this.Z) ^ true);
      } else {
        setSendGiftBtnEnabled(true);
      }
      localObject3 = this.B;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((TroopGiftAioPanelData)localObject3).g != null)
        {
          localObject1 = localObject2;
          if (this.B.g.size() == c) {
            localObject1 = ((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(paramInt2)).a;
          }
        }
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_tab_click", paramInt1, 0, getTroopUin(), "", this.H, (String)localObject1);
      return;
    }
    if (paramInt2 == d)
    {
      localObject1 = getTroopUin();
      localObject2 = this.H;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aiobag_view", paramInt1, 0, (String)localObject1, "", (String)localObject2, ((StringBuilder)localObject3).toString());
      a(new TroopGiftPanel.13(this));
      if (j())
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.Z))
        {
          bool1 = bool2;
          if (p()) {
            bool1 = true;
          }
        }
        setSendGiftBtnEnabled(bool1);
        return;
      }
      setSendGiftBtnEnabled(p());
      return;
    }
    if (this.V >= 4)
    {
      localObject1 = getTroopUin();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getComeFrom());
      ((StringBuilder)localObject2).append("");
      NearbyFlowerManager.a("gift_store", "exp_all", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    }
    else
    {
      localObject2 = getTroopUin();
      if (((RedDotTextView)this.ac.findViewById(2131448499)).a()) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localObject3 = this.H;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", paramInt1, 0, (String)localObject2, (String)localObject1, (String)localObject3, ((StringBuilder)localObject4).toString());
    }
    ((TroopGiftManager)((AppInterface)this.l.get()).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(true);
    ((RedDotTextView)this.ac.findViewById(2131448499)).a(false, false);
    setSendGiftBtnEnabled(true);
  }
  
  public void setGiftData(TroopGiftAioPanelData paramTroopGiftAioPanelData, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramTroopGiftAioPanelData == null) {
      return;
    }
    this.B = paramTroopGiftAioPanelData;
    int i2;
    Object localObject2;
    if (((!this.ab) && (paramTroopGiftAioPanelData.g != null) && (paramTroopGiftAioPanelData.g.size() > 0)) || ((paramTroopGiftAioPanelData.g != null) && (paramTroopGiftAioPanelData.g.size() != c)))
    {
      i2 = paramTroopGiftAioPanelData.g.size();
      this.ab = true;
      localObject2 = (GridListViewPager[])this.p.clone();
      localObject1 = (View[])this.q.clone();
      if (localObject2.length == d + 1)
      {
        b = i2;
        c = b;
        i1 = c;
        d = i1 + 1;
        f = i1;
        ArrayList localArrayList = new ArrayList();
        i1 = 0;
        while (i1 < i2)
        {
          TroopExclusiveGiftAdapter.TroopExclusiveGiftData localTroopExclusiveGiftData = new TroopExclusiveGiftAdapter.TroopExclusiveGiftData();
          localTroopExclusiveGiftData.a = ((TroopGiftAioPanelData.PersonalTabItemInfo)paramTroopGiftAioPanelData.g.get(i1)).a;
          localArrayList.add(localTroopExclusiveGiftData);
          i1 += 1;
        }
        l();
        this.E.a(localArrayList);
        this.E.a(this.k);
        i1 = i2 + 2;
        this.p = new GridListViewPager[i1];
        this.q = new View[i1];
        ((ViewGroup)this.w).removeAllViews();
        i1 = 0;
        while (i1 < i2)
        {
          paramTroopGiftAioPanelData = new RadioViewPager(getContext());
          paramTroopGiftAioPanelData.setGiftPanel(this);
          paramTroopGiftAioPanelData.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          ((ViewGroup)this.w).addView(paramTroopGiftAioPanelData, new RelativeLayout.LayoutParams(-1, -1));
          this.q[i1] = paramTroopGiftAioPanelData;
          this.p[i1] = ((GridListViewPager)paramTroopGiftAioPanelData.getViewPager());
          this.p[i1].setOnItemClickListener(this);
          i1 += 1;
        }
        ((ViewGroup)this.w).addView(localObject1[1], new RelativeLayout.LayoutParams(-1, -1));
        ((ViewGroup)this.w).addView(localObject1[2], new RelativeLayout.LayoutParams(-1, -1));
        localObject2[0].setVisibility(8);
        paramTroopGiftAioPanelData = this.p;
        paramTroopGiftAioPanelData[c] = localObject2[1];
        paramTroopGiftAioPanelData[d] = localObject2[2];
        localObject1[0].setVisibility(8);
        paramTroopGiftAioPanelData = this.q;
        paramTroopGiftAioPanelData[c] = localObject1[1];
        paramTroopGiftAioPanelData[d] = localObject1[2];
        this.M = paramTroopGiftAioPanelData[0].findViewById(2131445537);
        this.N = this.q[0].findViewById(2131444367);
        this.O = ((ImageView)this.q[0].findViewById(2131444366));
        this.P = ((TextView)this.q[0].findViewById(2131444369));
        paramTroopGiftAioPanelData = this.q[0].findViewById(2131430479);
        this.M.setOnClickListener(this.W);
        paramTroopGiftAioPanelData.setOnClickListener(this.W);
        this.Q = this.q[d].findViewById(2131445537);
        this.R = this.q[d].findViewById(2131444367);
        this.S = ((ImageView)this.q[d].findViewById(2131444366));
        this.T = ((TextView)this.q[d].findViewById(2131444369));
        this.U = this.q[d].findViewById(2131439797);
        paramTroopGiftAioPanelData = this.q[d].findViewById(2131430479);
        this.Q.setOnClickListener(this.W);
        paramTroopGiftAioPanelData.setOnClickListener(this.W);
        i1 = 0;
        for (;;)
        {
          i2 = c;
          if (i1 >= i2) {
            break;
          }
          paramTroopGiftAioPanelData = this.q;
          a(paramTroopGiftAioPanelData[i1], paramTroopGiftAioPanelData[i2], paramTroopGiftAioPanelData[d]);
          i1 += 1;
        }
        onTabSelected(0, 0);
      }
    }
    a(this.B.k);
    this.w.setVisibility(0);
    this.v.setVisibility(8);
    if ((this.o) && (this.B.k != null))
    {
      paramTroopGiftAioPanelData = this.B.k.iterator();
      while (paramTroopGiftAioPanelData.hasNext()) {
        if (((TroopGiftAioPanelData.WebPanelItemInfo)paramTroopGiftAioPanelData.next()).b == 1) {
          ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "activityTab", 0, 0, "", "", "", "");
        }
      }
    }
    if (!TextUtils.isEmpty(this.B.m.b))
    {
      paramTroopGiftAioPanelData = this.B.m.b;
      if (this.p.length > c)
      {
        i1 = 0;
        for (;;)
        {
          i2 = c;
          if (i1 >= i2) {
            break;
          }
          this.p[i1].setGridGiftIcon(paramTroopGiftAioPanelData);
          i1 += 1;
        }
        this.p[i2].setGridGiftIcon(paramTroopGiftAioPanelData);
      }
    }
    if ((this.B.i != null) && (this.B.i.size() >= 1) && (this.I))
    {
      paramTroopGiftAioPanelData = this.B;
      paramTroopGiftAioPanelData.p = paramTroopGiftAioPanelData.d;
      ((TroopGiftAioItemData)this.B.i.get(this.B.p)).k = true;
      this.p[c].setData(this.B.i);
      this.p[c].setVisibility(0);
      this.ac.setVisibility(0);
    }
    else
    {
      this.p[c].setVisibility(8);
      this.ac.setVisibility(8);
    }
    ((RedDotTextView)this.ac.findViewById(2131448499)).a(false, false);
    long l2 = System.currentTimeMillis();
    long l3 = this.B.a;
    if ((this.B.n) && (l2 >= this.B.a) && (l2 <= l3 + 2592000000L) && (!((TroopGiftManager)((AppInterface)this.l.get()).getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a())) {
      ((RedDotTextView)this.ac.findViewById(2131448499)).a(true, false);
    }
    if ((this.B.m != null) && (!TextUtils.isEmpty(this.B.m.a))) {
      a(this.s, this.B.m.a);
    }
    b(paramBoolean);
    if ((this.B.g != null) && (this.B.g.size() > 0)) {
      this.B.o = 0;
    }
    if (this.B.i == null) {
      this.k = a;
    }
    int i1 = this.k;
    if ((i1 >= 0) && (i1 < c) && (this.B.o != -1))
    {
      if (this.B.g != null)
      {
        i1 = this.k;
        if ((i1 >= 0) && (i1 < this.B.g.size()))
        {
          paramTroopGiftAioPanelData = ((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(this.k)).c;
          if ((paramTroopGiftAioPanelData != null) && (this.B.o >= 0) && (this.B.o < paramTroopGiftAioPanelData.size())) {
            this.A = ((TroopGiftAioItemData)paramTroopGiftAioPanelData.get(this.B.o));
          }
        }
      }
    }
    else if ((this.k == c) && (this.B.p != -1)) {
      this.A = ((TroopGiftAioItemData)this.B.i.get(this.B.p));
    } else if ((this.k == d) && (this.B.q != -1)) {
      this.A = ((TroopGiftAioItemData)this.B.j.get(this.B.q));
    }
    if ((this.A == null) && (this.B.g != null) && (this.B.g.size() > 0) && (((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(0)).c != null) && (((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(0)).c.size() > 0)) {
      this.A = ((TroopGiftAioItemData)((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(0)).c.get(0));
    }
    if (this.B.g != null)
    {
      i1 = this.B.g.size();
      i2 = c;
      if ((i1 == i2) && (this.p.length > i2))
      {
        i1 = 0;
        while (i1 < c)
        {
          this.p[i1].setData(((TroopGiftAioPanelData.PersonalTabItemInfo)this.B.g.get(i1)).c);
          i1 += 1;
        }
      }
    }
    paramTroopGiftAioPanelData = this.A;
    if ((paramTroopGiftAioPanelData != null) && (paramTroopGiftAioPanelData.e == 0))
    {
      c(0);
      if (this.V >= 4)
      {
        paramTroopGiftAioPanelData = getTroopUin();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getComeFrom());
        ((StringBuilder)localObject1).append("");
        NearbyFlowerManager.a("gift_store", "exp_chose", paramTroopGiftAioPanelData, ((StringBuilder)localObject1).toString(), "", "");
      }
      else
      {
        if (AnonymousChatHelper.a().a(getTroopUin())) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        paramTroopGiftAioPanelData = getTroopUin();
        localObject1 = this.H;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i1, 0, paramTroopGiftAioPanelData, "", (String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      c(8);
    }
    if ((this.B.j != null) && (this.B.w.size() > 0)) {
      this.p[d].setData(this.B.j);
    }
    a(new TroopGiftPanel.12(this, System.currentTimeMillis(), l1));
    paramBoolean = AnonymousChatHelper.a().a(getTroopUin());
    paramTroopGiftAioPanelData = findViewById(2131449847);
    Object localObject1 = findViewById(2131449848);
    if (paramBoolean)
    {
      paramTroopGiftAioPanelData.setBackgroundResource(2130844877);
      ((View)localObject1).setBackgroundResource(2130844879);
    }
    else
    {
      paramTroopGiftAioPanelData.setBackgroundResource(2130844876);
      ((View)localObject1).setBackgroundResource(2130844878);
    }
    l();
    paramTroopGiftAioPanelData = this.E;
    if (paramTroopGiftAioPanelData != null) {
      paramTroopGiftAioPanelData.a(this.k);
    }
    a(this.k);
    n();
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (this.o)
    {
      int i1 = this.J;
      if (i1 == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "half_mall_exp", 0, 0, "", "", "", "");
        return;
      }
      if (i1 == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "half_mall_exp", 0, 0, "", "", "", "");
        return;
      }
      if (i1 == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "half_mall_exp", 0, 0, "", "", "", "");
        return;
      }
      if (this.V >= 4)
      {
        str = getTroopUin();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getComeFrom());
        ((StringBuilder)localObject).append("");
        NearbyFlowerManager.a("gift_store", "exp_one", str, ((StringBuilder)localObject).toString(), "", "");
        return;
      }
      if (AnonymousChatHelper.a().a(getTroopUin())) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      String str = getTroopUin();
      Object localObject = this.H;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.l.get(), ((AppInterface)this.l.get()).getCurrentAccountUin(), getTroopUin()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", i1, 0, str, "", (String)localObject, localStringBuilder.toString());
    }
  }
  
  public void setMainAreaBackgroundColor(int paramInt)
  {
    View localView = findViewById(2131429409);
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
    this.x.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.y.setVisibility(8);
      return;
    }
    this.y.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel
 * JD-Core Version:    0.7.0.1
 */