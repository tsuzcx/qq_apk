package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.CmShowLauncher;
import com.tencent.mobileqq.apollo.aio.BubbleProducer;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloFavViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.App3DConfig;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloPanelRedDotUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.Apollo3DMainInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ApolloPanel
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener, OpenCallback, EmotionPanelListView.PullAndFastScrollListener
{
  public static int a;
  public static int b;
  public static boolean c;
  public static int d;
  private RelativeLayout A;
  private LinearLayout B;
  private TextView C;
  private TextView D;
  private ApolloSecondaryViewBinder E;
  private ApolloPanelExtendHelper F;
  private List<ApolloViewBinder> G = new CopyOnWriteArrayList();
  private List<Integer> H = new ArrayList();
  private List<Integer> I = new ArrayList();
  private int J = -1;
  private int K = -1;
  private int L = -1;
  private volatile boolean M;
  private boolean N;
  private boolean O;
  private boolean P = false;
  private boolean Q = false;
  private long R;
  private boolean S;
  private ApolloNewActionFloatViewController T = null;
  private ApolloExtensionObserver U;
  private ApolloManagerServiceImpl V;
  private ApolloDaoManagerServiceImpl W;
  private IApolloResManager Z;
  private ApolloPanelTips aa;
  private CmshowPanelDialog ab;
  private int ac = -1;
  private Runnable ad = new ApolloPanel.20(this);
  private boolean ae = true;
  private PanelStrategy af;
  private PanelStrategy ag;
  private boolean ah;
  private PanelStrategy ai;
  private ApolloStatusUpdateListener aj = new ApolloPanel.25(this);
  private ApolloPanelGuideView ak;
  private View al;
  private URLImageView am;
  private FrameLayout an;
  private BubbleProducer ao;
  private boolean ap;
  private boolean aq;
  private ApolloPanelGuideView.ClickCallback ar = new ApolloPanel.29(this);
  private int as = -1;
  public int e = 2;
  IResDownloadListener f = new ApolloPanel.4(this);
  public ApolloPanelManager.PanelClickCallback g = new ApolloPanel.19(this);
  public int h = 1;
  private BaseChatPie i;
  private SessionInfo j;
  private ApolloPanelManager k;
  private final MqqHandler l = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private QQViewPager m;
  private ApolloPanelAdapter n;
  private HorizontalListView o;
  private ApolloTabAdapter p;
  private LinearLayout q;
  private ImageView r;
  private URLImageView s;
  private RelativeLayout t;
  private RelativeLayout u;
  private RedTouch v;
  private StateListDrawable w;
  private Drawable x;
  private BusinessInfoCheckUpdate.AppInfo y;
  private DrawerPushItem z;
  
  public ApolloPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131624077, this);
    this.m = ((QQViewPager)findViewById(2131429040));
    this.s = ((URLImageView)findViewById(2131429933));
    this.t = ((RelativeLayout)findViewById(2131431292));
    this.u = ((RelativeLayout)findViewById(2131431291));
    this.am = ((URLImageView)findViewById(2131429908));
    this.am.setOnClickListener(this);
    this.al = findViewById(2131429794);
    this.al.setOnClickListener(this);
    this.an = ((FrameLayout)findViewById(2131429902));
    this.w = new StateListDrawable();
    paramAttributeSet = this.w;
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838616);
    paramAttributeSet.addState(new int[] { 16842919 }, localDrawable);
    paramAttributeSet = this.w;
    localDrawable = paramContext.getResources().getDrawable(2130838616);
    paramAttributeSet.addState(new int[] { -16842919 }, localDrawable);
    this.x = new ColorDrawable(0);
    this.s.setOnClickListener(this);
    this.q = ((LinearLayout)findViewById(2131428491));
    this.n = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.m.setAdapter(this.n);
    this.m.setOnPageChangeListener(this);
    this.o = ((HorizontalListView)findViewById(2131446730));
    this.p = new ApolloTabAdapter(super.getContext());
    this.o.setAdapter(this.p);
    this.o.setOnItemClickListener(this);
    findViewById(2131446725).setBackgroundColor(paramContext.getResources().getColor(2131166013));
    this.r = ((ImageView)findViewById(2131437664));
    this.r.setVisibility(8);
    this.A = ((RelativeLayout)findViewById(2131428485));
    this.B = ((LinearLayout)findViewById(2131428484));
    this.B.setOnClickListener(this);
    this.C = ((TextView)findViewById(2131428483));
    this.D = ((TextView)findViewById(2131428431));
    this.v = new RedTouch(paramContext, this.t).c(5).a();
    this.aa = new ApolloPanelTips();
  }
  
  private void A()
  {
    if (this.i != null)
    {
      if (this.p == null) {
        return;
      }
      int i1 = c(a);
      Object localObject = this.p.a();
      if ((localObject != null) && (((List)localObject).size() != 0) && (i1 >= 0))
      {
        if (i1 >= ((List)localObject).size()) {
          return;
        }
        localObject = (ApolloActionPackage)((List)localObject).get(i1);
        if (localObject != null) {
          i1 = ((ApolloActionPackage)localObject).packageId;
        } else {
          i1 = 0;
        }
        VipUtils.a(this.i.d, "cmshow", "Apollo", "tabexposure", this.j.b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.j.a), i1, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, ApolloViewBinder paramApolloViewBinder, List<ApolloInfo> paramList, int paramInt4)
  {
    int i1 = paramList.size();
    paramInt4 = 0;
    while (paramInt4 < i1)
    {
      ApolloInfo localApolloInfo = (ApolloInfo)paramList.get(paramInt4);
      if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramInt3))
      {
        paramApolloViewBinder.c(paramInt4);
        paramInt1 = paramApolloViewBinder.d(paramInt4) + paramInt1;
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found, jumpActionIndex=", Integer.valueOf(paramInt4), ", newViewPagerIndex=", Integer.valueOf(paramInt1) });
        return paramInt1;
      }
      paramInt4 += 1;
    }
    return paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 != -1)
    {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump to new index=", Integer.valueOf(paramInt3), ", current index=", Integer.valueOf(a) });
      int i1 = a;
      if (i1 != paramInt3)
      {
        this.m.setCurrentItem(paramInt3, false);
        setTabSelect(c(paramInt3));
        a = paramInt3;
      }
      if ((paramInt3 >= i1 - 1) && (paramInt3 <= i1 + 1))
      {
        QLog.d("[cmshow]ApolloPanel", 2, "[jumpToPkgOrAction] force refresh cache view");
        this.n.notifyDataSetChanged();
      }
    }
    if (paramInt4 == -1)
    {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.N) });
      if (!this.N)
      {
        ImageView localImageView = this.r;
        if (localImageView != null) {
          localImageView.setVisibility(0);
        }
        this.N = true;
        this.J = paramInt2;
        this.K = paramInt1;
        QLog.d("[cmshow]ApolloPanel", 2, "[jumpToPkgOrAction] no action found, try to update json");
        this.Z.j(1);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i4 = this.G.size();
    int i2 = paramInt2;
    paramInt2 = 0;
    for (int i1 = paramInt1; (paramInt2 < i4) && (i2 == -1); i1 = paramInt1)
    {
      ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.G.get(paramInt2);
      int i3;
      if (localApolloViewBinder == null)
      {
        i3 = i2;
        paramInt1 = i1;
      }
      else
      {
        List localList;
        if (localApolloViewBinder.n == paramInt4)
        {
          if (paramInt5 == -1)
          {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump for pkg, newViewPagerIndex=", Integer.valueOf(i1) });
            return;
          }
          localList = localApolloViewBinder.o;
          if ((localList != null) && (localList.size() > 0)) {
            paramInt1 = a(i1, i2, paramInt5, localApolloViewBinder, localList, paramInt3);
          } else {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction true, just jump pkg, newViewPagerIndex=", Integer.valueOf(i1) });
          }
        }
        else
        {
          localList = localApolloViewBinder.o;
          i3 = i2;
          paramInt1 = i1;
          if (localList == null) {
            break label241;
          }
          if (localList.size() == 0)
          {
            i3 = i2;
            paramInt1 = i1;
            break label241;
          }
          paramInt1 = a(i1, i2, paramInt5, localApolloViewBinder, localList, paramInt3);
        }
        i1 += localApolloViewBinder.c();
        i3 = paramInt1;
        paramInt1 = i1;
      }
      label241:
      paramInt2 += 1;
      i2 = i3;
    }
  }
  
  private void a(ApolloViewBinder paramApolloViewBinder, List<ApolloInfo> paramList, List<ApolloActionData> paramList1, List<ApolloFavActionData> paramList2)
  {
    Pair localPair = this.W.getFavPanelActionPairInfo();
    if (localPair.first != null) {
      paramList2.addAll((Collection)localPair.first);
    }
    if (localPair.second != null) {
      paramList1.addAll((Collection)localPair.second);
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramApolloViewBinder.b(5);
      paramApolloViewBinder = new ApolloInfo();
      paramApolloViewBinder.mType = 2;
      paramList1 = new ApolloActionData();
      paramList1.actionName = super.getResources().getString(2131886675);
      paramApolloViewBinder.mAction = paramList1;
      paramList.add(paramApolloViewBinder);
      return;
    }
    paramApolloViewBinder.b(4);
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    s();
    this.T = new ApolloNewActionFloatViewController(this.i, this.j, this);
    this.T.a(paramApolloActionData, paramInt1, paramInt2, paramInt3, paramBundle);
    this.ae = false;
  }
  
  private void a(ApolloActionPackage paramApolloActionPackage, ApolloViewBinder paramApolloViewBinder, ApolloPanelInitData paramApolloPanelInitData, List<ApolloActionData> paramList)
  {
    int i1;
    boolean bool1;
    if (CmShowAioMatcherImpl.judgeSupported(this.i.F(), 1))
    {
      i1 = 4021;
      bool1 = CmShowWnsUtils.m();
    }
    else if (CmShowAioMatcherImpl.judgeSupported(this.i.F(), 2))
    {
      i1 = 4022;
      bool1 = CmShowWnsUtils.n();
    }
    else
    {
      i1 = -1;
      bool1 = false;
    }
    boolean bool2 = StudyModeManager.h();
    if ((bool1) && (!bool2))
    {
      paramList = null;
      try
      {
        List localList = this.W.getBattleGameList(i1);
        paramList = localList;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("[cmshow]ApolloPanel", 1, "[initPanelData]   getBattleGameList error! exception = ", localThrowable);
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        if ((paramApolloViewBinder instanceof ApolloBattleGameViewBinder))
        {
          ((ApolloBattleGameViewBinder)paramApolloViewBinder).a(i1, paramList);
          int i2 = paramApolloActionPackage.packageId;
          i1 = 10;
          if (i2 != 10) {
            i1 = 11;
          }
          paramApolloViewBinder.b(i1);
          paramApolloPanelInitData.c().add(paramApolloViewBinder);
          paramApolloPanelInitData.d().add(paramApolloActionPackage);
          this.S = true;
          return;
        }
        QLog.e("[cmshow]ApolloPanel", 1, "[initPanelData] APOLLO_TAB_BATTLE_GAME packageViewBinder is not ApolloMiniGameViewBinder!");
        return;
      }
      QLog.w("[cmshow]ApolloPanel", 1, "[initPanelData] APOLLO_TAB_BATTLE_GAME miniGameInfoList is null!");
      return;
    }
    paramApolloActionPackage = new StringBuilder();
    paramApolloActionPackage.append("[initPanelData] APOLLO_TAB_BATTLE_GAME not show entrance.");
    paramApolloActionPackage.append("sceneId = ");
    paramApolloActionPackage.append(i1);
    paramApolloActionPackage.append(", wnsConfigShowEntrance = ");
    paramApolloActionPackage.append(bool1);
    paramApolloActionPackage.append(", studyModeSwitch = ");
    paramApolloActionPackage.append(bool2);
    QLog.d("[cmshow]ApolloPanel", 1, new Object[] { paramApolloActionPackage });
  }
  
  private void a(ApolloActionPackage paramApolloActionPackage, ApolloViewBinder paramApolloViewBinder, ApolloPanelInitData paramApolloPanelInitData, List<ApolloActionData> paramList, List<ApolloFavActionData> paramList1, List<ApolloActionPackageData> paramList2, List<ApolloInfo> paramList3)
  {
    if ((paramApolloActionPackage.packageId != 10) && (paramApolloActionPackage.packageId != 302))
    {
      if (paramApolloActionPackage.type == 2)
      {
        a(paramApolloViewBinder, paramList3, paramList, paramList1);
        return;
      }
      if (paramApolloActionPackage.packageId == 8)
      {
        paramApolloActionPackage = this.W.getRecommendActionList();
        if (paramApolloActionPackage.first != null) {
          paramList2.addAll((Collection)paramApolloActionPackage.first);
        }
        if (paramApolloActionPackage.second != null) {
          paramList.addAll((Collection)paramApolloActionPackage.second);
        }
        paramApolloViewBinder.b(0);
        return;
      }
      if ((CmShowWnsUtils.e()) || ((!CmShowWnsUtils.e()) && (paramApolloActionPackage.packageId != 9)))
      {
        paramList.addAll(this.W.getActionByPackageId(paramApolloActionPackage.packageId));
        paramList2.addAll(this.W.getPackageActionDataById(paramApolloActionPackage.packageId));
        paramApolloViewBinder.b(0);
      }
      if (paramApolloActionPackage.packageId == 6)
      {
        paramApolloViewBinder.b(9);
        this.W.rearrangeEnhanceAction(this.i, paramList);
        return;
      }
      if (paramApolloActionPackage.packageId == 7) {
        this.W.rearrangeEnhanceAction(this.i, paramList);
      }
    }
    else
    {
      a(paramApolloActionPackage, paramApolloViewBinder, paramApolloPanelInitData, paramList);
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.23(this, paramAppInfo, paramString));
  }
  
  private void a(String paramString1, ApolloPanelInitData paramApolloPanelInitData, ApolloActionPackage paramApolloActionPackage, String paramString2, ApolloViewBinder paramApolloViewBinder, List<ApolloActionData> paramList, List<ApolloFavActionData> paramList1, List<ApolloActionPackageData> paramList2, List<ApolloInfo> paramList3, StringBuilder paramStringBuilder)
  {
    if (paramList != null)
    {
      if (this.j == null) {
        return;
      }
      b(paramString1, paramApolloPanelInitData, paramApolloActionPackage, paramString2, paramApolloViewBinder, paramList, paramList1, paramList2, paramList3, paramStringBuilder);
      if (paramList3.size() > 0)
      {
        paramApolloViewBinder.a(paramList3);
        if (this.K == paramApolloActionPackage.packageId)
        {
          if (paramApolloPanelInitData.a() != -1)
          {
            paramApolloViewBinder.c(paramApolloPanelInitData.a());
            int i1 = paramApolloViewBinder.d(paramApolloPanelInitData.a());
            a = paramApolloPanelInitData.b() + i1;
          }
          else
          {
            a = paramApolloPanelInitData.b();
          }
          QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(a), ", jumpActionIndex=", Integer.valueOf(paramApolloPanelInitData.a()) });
        }
        paramApolloPanelInitData.c().add(paramApolloViewBinder);
        if (paramApolloActionPackage.packageId == 8)
        {
          paramString1 = this.i;
          if ((paramString1 != null) && (paramString1.d != null))
          {
            paramString1 = this.i.d.getApp();
            paramString2 = new StringBuilder();
            paramString2.append("apollo_sp");
            paramString2.append(this.i.d.getCurrentUin());
            paramApolloActionPackage.isRecommendTabClick = paramString1.getSharedPreferences(paramString2.toString(), 0).getBoolean("apollo_sp_key_recommend_tab_click", false);
            QLog.d("[cmshow]ApolloPanel", 1, new Object[] { "[initPanelData] isRecommendTabClick=", Boolean.valueOf(paramApolloActionPackage.isRecommendTabClick) });
          }
        }
        paramApolloPanelInitData.d().add(paramApolloActionPackage);
        paramApolloPanelInitData.b(paramApolloPanelInitData.b() + paramApolloViewBinder.c());
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    ApolloDtReportUtil.a("panel", paramString1, paramString2, getCommonStatisticsParams());
  }
  
  private void a(String paramString, List<ApolloActionPackage> paramList, ApolloPanelInitData paramApolloPanelInitData)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList.get(i1);
      if ((localApolloActionPackage != null) && (localApolloActionPackage.packageId != 4) && (this.ai.a(localApolloActionPackage.packageId)))
      {
        Object localObject = DeviceInfoUtil.e();
        if (!ApolloUtilImpl.verifyActionPackageVersion(localApolloActionPackage, (String)localObject))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("version not correct packageId=");
          ((StringBuilder)localObject).append(localApolloActionPackage.packageId);
          QLog.w("[cmshow]ApolloPanel", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          long l1 = System.currentTimeMillis();
          ApolloViewBinder localApolloViewBinder = a(localApolloActionPackage.type, localApolloActionPackage.packageId);
          if (localApolloViewBinder != null)
          {
            localApolloViewBinder.n = localApolloActionPackage.packageId;
            localApolloViewBinder.a(this);
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            ArrayList localArrayList3 = new ArrayList();
            ArrayList localArrayList4 = new ArrayList();
            a(localApolloActionPackage, localApolloViewBinder, paramApolloPanelInitData, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
            long l2 = System.currentTimeMillis();
            StringBuilder localStringBuilder = new StringBuilder();
            a(paramString, paramApolloPanelInitData, localApolloActionPackage, (String)localObject, localApolloViewBinder, localArrayList1, localArrayList2, localArrayList3, localArrayList4, localStringBuilder);
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(localApolloActionPackage.packageId), ",actionPackageDatas size:", Integer.valueOf(localArrayList1.size()), ",findTime:", Long.valueOf(l2 - l1), ",remove actions ", localStringBuilder.toString() });
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.i;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null) && (paramList != null))
    {
      if (paramList1 == null) {
        return;
      }
      this.ai.a(paramList, paramList1, paramBoolean, this.ae);
    }
  }
  
  private void a(boolean paramBoolean, List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1)
  {
    if ((this.J == -1) && (this.K == -1)) {
      a(paramList, paramList1, paramBoolean);
    }
  }
  
  private void b(int paramInt, View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof ApolloTabAdapter.ViewHolder))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updatePanelTabRedDot view tag is not an holder : ");
      ((StringBuilder)localObject1).append(paramView);
      QLog.e("[cmshow]ApolloPanel", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = (IRedTouchManager)this.i.d.getRuntimeService(IRedTouchManager.class, "");
    paramView = (ApolloTabAdapter.ViewHolder)paramView;
    if (paramView.c.getVisibility() == 0)
    {
      Object localObject2 = this.p;
      if (localObject2 != null)
      {
        localObject2 = (ApolloActionPackage)((ApolloTabAdapter)localObject2).a().get(paramInt);
        String str = ApolloPanelRedDotUtil.a(((ApolloActionPackage)localObject2).packageId);
        if ((str != null) && (ApolloPanelRedDotUtil.b(((ApolloActionPackage)localObject2).packageId))) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("level", 1);
            ((IRedTouchManager)localObject1).onRedTouchItemClick(((IRedTouchManager)localObject1).getAppInfoByPath(str), localJSONObject.toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onRedTouchItemClick ");
            ((StringBuilder)localObject1).append(((ApolloActionPackage)localObject2).packageId);
            QLog.d("ApolloPanelRedDotUtil", 1, ((StringBuilder)localObject1).toString());
          }
          catch (Throwable localThrowable)
          {
            QLog.e("[cmshow]ApolloPanel", 1, "Throwable : ", localThrowable);
          }
        }
      }
    }
    paramView.c.setVisibility(8);
  }
  
  private void b(String paramString1, ApolloPanelInitData paramApolloPanelInitData, ApolloActionPackage paramApolloActionPackage, String paramString2, ApolloViewBinder paramApolloViewBinder, List<ApolloActionData> paramList, List<ApolloFavActionData> paramList1, List<ApolloActionPackageData> paramList2, List<ApolloInfo> paramList3, StringBuilder paramStringBuilder)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      ApolloActionData localApolloActionData = (ApolloActionData)paramList.get(i1);
      if (localApolloActionData != null)
      {
        if (!ApolloUtilImpl.verifyActionVersion(localApolloActionData, paramString2))
        {
          paramStringBuilder.append(",version ");
          paramStringBuilder.append(localApolloActionData.actionId);
        }
        for (;;)
        {
          break;
          if ((CmShowAioMatcherImpl.judgeSupported(this.j.a, 1)) && (localApolloActionData.sessionType == 2))
          {
            paramStringBuilder.append(",special C2C ");
            paramStringBuilder.append(localApolloActionData.actionId);
          }
          else if ((CmShowAioMatcherImpl.judgeSupported(this.j.a, 2)) && (localApolloActionData.sessionType == 1))
          {
            paramStringBuilder.append(",special ");
            paramStringBuilder.append(localApolloActionData.actionId);
          }
          else
          {
            if (((ApolloActionData)paramList.get(i1)).isShow != 0) {
              break label203;
            }
            paramStringBuilder.append(",hide ");
            paramStringBuilder.append(localApolloActionData.actionId);
          }
        }
        label203:
        ApolloInfo localApolloInfo = paramApolloViewBinder.a(paramString1);
        if (localApolloInfo != null)
        {
          localApolloInfo.mAction = localApolloActionData;
          localApolloInfo.mPackageId = paramApolloActionPackage.packageId;
          if ((paramApolloActionPackage.type == 2) && (paramList1 != null) && (paramList1.size() > i1))
          {
            localApolloInfo.mActionText = ((ApolloFavActionData)paramList1.get(i1)).text;
            localApolloInfo.mTextType = ((ApolloFavActionData)paramList1.get(i1)).textType;
            localApolloInfo.mAudioId = ((ApolloFavActionData)paramList1.get(i1)).audioId;
            localApolloInfo.mAudioStartTime = ((ApolloFavActionData)paramList1.get(i1)).audioStartTime;
            localApolloInfo.mPlayOriginalAudio = ((ApolloFavActionData)paramList1.get(i1)).playOriginalAudio;
          }
          else if ((paramList2 != null) && (paramList2.size() > i1))
          {
            localApolloInfo.mActionText = ((ApolloActionPackageData)paramList2.get(i1)).text;
            localApolloInfo.mTextType = ((ApolloActionPackageData)paramList2.get(i1)).textType;
          }
          localApolloInfo.iconType = ApolloPanelUtil.a(this.i.d, localApolloInfo, localApolloInfo.mAction);
          paramList3.add(localApolloInfo);
        }
        if ((paramApolloPanelInitData.a() == -1) && (this.J == localApolloActionData.actionId))
        {
          if (this.K == -1)
          {
            this.K = paramApolloActionPackage.packageId;
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.K) });
          }
          if (this.K == paramApolloActionPackage.packageId) {
            paramApolloPanelInitData.a(paramList3.size() - 1);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.E = new ApolloSecondaryViewBinder(this.i.e, this.i.d, this.j);
    this.E.b(paramInt2);
    this.E.a(this);
    if (paramInt1 == 0) {
      this.E.a(true);
    }
    if ((this.n != null) && (this.q != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("func showApolloPanel begins. Thread id = ");
        localStringBuilder.append(Thread.currentThread().getId());
        QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
      this.n.notifyDataSetChanged();
      this.G.clear();
      this.G.add(this.E);
      r();
      this.n.a(this.G);
    }
  }
  
  private void c(List<ApolloActionPackage> paramList)
  {
    Object localObject1 = this.i.d.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("apollo_sp");
    ((StringBuilder)localObject2).append(this.i.d.getCurrentUin());
    localObject2 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    localObject1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList.next();
      if ((localApolloActionPackage.isUpdate) && (localApolloActionPackage.packageId != 100))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initPanelData] delete red dot after 24h:");
        localStringBuilder.append(((List)localObject1).size());
        QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
        long l1 = NetConnInfoCenter.getServerTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("action_red_tab_update_");
        localStringBuilder.append(localApolloActionPackage.packageId);
        if (l1 - ((SharedPreferences)localObject2).getLong(localStringBuilder.toString(), 0L) > localApolloActionPackage.redInterval)
        {
          localApolloActionPackage.isUpdate = false;
          ((List)localObject1).add(localApolloActionPackage);
        }
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      paramList = new StringBuilder();
      paramList.append("[initPanelData] delete red dot after 24h:");
      paramList.append(((List)localObject1).size());
      QLog.d("[cmshow]ApolloPanel", 2, paramList.toString());
      ThreadManager.post(new ApolloPanel.8(this, (List)localObject1), 5, null, true);
    }
  }
  
  private boolean c(String paramString)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).d == null) {
        return false;
      }
      localObject = this.i.d.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp");
      localStringBuilder.append(this.i.d.getCurrentUin());
      return ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getInt(paramString, 0) == 1;
    }
    return false;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] actionId=", Integer.valueOf(paramInt1), ", pkgId=", Integer.valueOf(paramInt2) });
    }
    Object localObject1 = this.i;
    if ((localObject1 != null) && (((BaseChatPie)localObject1).d != null))
    {
      localObject1 = this.W.findActionById(paramInt1);
      if (localObject1 == null)
      {
        QLog.w("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = this.W.isObtainActionById(paramInt1);
      boolean bool1;
      if ((!this.W.isLimitFreeActionById(paramInt1)) && (((ApolloActionData)localObject1).feeType != 1) && (((ApolloActionData)localObject1).feeType != 10)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] isObtained=", Boolean.valueOf(bool2), ", isFree=", Boolean.valueOf(bool1), ", feeType=", Integer.valueOf(((ApolloActionData)localObject1).feeType) });
      }
      if (bool1)
      {
        a((ApolloActionData)localObject1, 0, 20, paramInt2, null);
        return;
      }
      if (((ApolloActionData)localObject1).feeType == 6)
      {
        this.i.d.addObserver(new ApolloPanel.21(this, (ApolloActionData)localObject1, paramInt2));
        ((ApolloExtensionHandler)this.i.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(((ApolloActionData)localObject1).actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
        return;
      }
      Object localObject2;
      if (((ApolloActionData)localObject1).feeType == 2)
      {
        if (((ApolloActionData)localObject1).currencyType != 1)
        {
          QLog.w("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] currency type not gold, abort");
          return;
        }
        if (bool2)
        {
          a((ApolloActionData)localObject1, 0, 23, paramInt2, null);
          return;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("pkgId", paramInt2);
        a((ApolloActionData)localObject1, 2, 23, paramInt2, (Bundle)localObject2);
        return;
      }
      if (((ApolloActionData)localObject1).feeType == 9)
      {
        localObject2 = this.i.d.getCurrentUin();
        if (this.V.isSuperYellow((String)localObject2))
        {
          a((ApolloActionData)localObject1, 0, 28, paramInt2, null);
          return;
        }
        a((ApolloActionData)localObject1, 4, 27, paramInt2, null);
        return;
      }
      QLog.e("[cmshow]ApolloPanel", 1, new Object[] { "[showNewActionFloatView] not support yet, feeType=", Integer.valueOf(((ApolloActionData)localObject1).feeType) });
      return;
    }
    QLog.w("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] app null, abort");
  }
  
  private void e(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initPanelData] updateJSONIfNeed, mIsJsonUpdatedByJumpAction=");
    ((StringBuilder)localObject).append(this.N);
    QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
    if ((this.J != -1) && (paramInt == -1) && (!this.N))
    {
      QLog.d("[cmshow]ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
      localObject = this.r;
      if (localObject != null) {
        ((ImageView)localObject).post(new ApolloPanel.6(this));
      }
      this.N = true;
      this.Z.j(1);
      return;
    }
    if (!this.M)
    {
      this.K = -1;
      this.J = -1;
    }
  }
  
  private void f(int paramInt)
  {
    this.ai.b(paramInt, i(paramInt));
  }
  
  private void g(int paramInt)
  {
    if (this.G.size() > paramInt)
    {
      if (this.o == null) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick tab postion=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
      }
      setTabSelect(paramInt);
      int i1 = 0;
      int i2 = 0;
      while (i1 < paramInt)
      {
        i2 += ((ApolloViewBinder)this.G.get(i1)).c();
        i1 += 1;
      }
      try
      {
        this.m.setCurrentItem(i2, false);
        localObject = this.p.a();
        if (localObject != null)
        {
          if (((List)localObject).isEmpty()) {
            return;
          }
          localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
          VipUtils.a(this.i.d, "cmshow", "Apollo", "clciktabreddot", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.j.a), 0, new String[] { String.valueOf(((ApolloActionPackage)localObject).packageId) });
          if ((((ApolloActionPackage)localObject).packageId == 10) || (((ApolloActionPackage)localObject).packageId == 302))
          {
            if (CmShowAioMatcherImpl.judgeSupported(this.i.ah.a, 1))
            {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_c2c", "click", "", "", "", "");
              return;
            }
            if (CmShowAioMatcherImpl.judgeSupported(this.i.ah.a, 2)) {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_qun", "click", "", "", "", "");
            }
          }
        }
        else {}
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCurrentItem exception e=");
        localStringBuilder.append(localThrowable.toString());
        QLog.e("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
    }
  }
  
  private HashMap<String, String> getCommonStatisticsParams()
  {
    BaseChatPie localBaseChatPie = this.i;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null)) {
      return new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.i.d)).b(ApolloDtReportUtil.a(this.j.a)).c(this.j.b).a();
    }
    return null;
  }
  
  private int getCurCmshowPackageId()
  {
    if (this.V.getApolloUserStatus() == 2) {
      return 303;
    }
    if (this.V.getApolloUserStatus() == 1) {
      return 9;
    }
    return -1;
  }
  
  private int getCurrentApolloStatus()
  {
    BaseChatPie localBaseChatPie = this.i;
    if (localBaseChatPie != null) {
      return ApolloUtilImpl.getApolloUserStatus(localBaseChatPie.d);
    }
    return 0;
  }
  
  @NotNull
  private ApolloExtensionObserver getDressChangeObserver()
  {
    return new ApolloPanel.3(this);
  }
  
  private void h(int paramInt)
  {
    BaseChatPie localBaseChatPie = this.i;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.d == null) {
        return;
      }
      int i1 = getCurrentApolloStatus();
      if ((paramInt == 0) || (paramInt == i1)) {
        paramInt = i1;
      }
      i1 = paramInt;
      if (paramInt == 2)
      {
        i1 = paramInt;
        if (!v()) {
          i1 = 1;
        }
      }
      setCurrentPanelType(i1);
    }
  }
  
  private int i(int paramInt)
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((ApolloTabAdapter)localObject).a();
      if ((localObject != null) && (((List)localObject).size() > 0) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (localObject != null) {
          return ((ApolloActionPackage)localObject).packageId;
        }
      }
    }
    return -1;
  }
  
  private void m()
  {
    BaseChatPie localBaseChatPie = this.i;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.d == null) {
        return;
      }
      this.U = getDressChangeObserver();
      this.i.d.addObserver(this.U);
    }
  }
  
  private boolean n()
  {
    return ((CmShowWnsUtils.W()) && (CMShowPlatform.a.b(Scene.MEME_PLAYER))) || (this.V.getApolloUserStatus() != 2);
  }
  
  private void o()
  {
    Object localObject = this.W;
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloPanel", 4, "[handleGetAllActionCoverFrame] mApolloDaoManager is null.");
      return;
    }
    localObject = ((ApolloDaoManagerServiceImpl)localObject).getActionByPackageId(getCurCmshowPackageId());
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)((Iterator)localObject).next();
        if ((localApolloActionData != null) && (localApolloActionData.isForPlayerAction == 1)) {
          a(localApolloActionData);
        }
      }
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 4, "[handleGetAllActionCoverFrame] CMSDataList is empty.");
  }
  
  private void p()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        A();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]ApolloPanel", 1, "[reportTabExposure] failed, excetion1=", localThrowable);
        return;
      }
    }
    this.l.post(new ApolloPanel.7(this));
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "[initData]");
    }
    i();
  }
  
  private void r()
  {
    this.q.setVisibility(8);
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "[hideNewActionFloatView]");
    }
    ApolloNewActionFloatViewController localApolloNewActionFloatViewController = this.T;
    if (localApolloNewActionFloatViewController != null)
    {
      localApolloNewActionFloatViewController.a();
      this.T = null;
    }
  }
  
  private void setCurrentPanelType(int paramInt)
  {
    if ((this.h != paramInt) && (QLog.isColorLevel())) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "setCurrentPanelType targetPanelType=", Integer.valueOf(paramInt) });
    }
    this.h = paramInt;
    if (this.h == 2)
    {
      this.ai = this.ag;
      return;
    }
    this.ai = this.af;
  }
  
  private void setHasDoneOnce(String paramString)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).d == null) {
        return;
      }
      localObject = this.i.d.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp");
      localStringBuilder.append(this.i.d.getCurrentUin());
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(paramString, 1).apply();
    }
  }
  
  private void t()
  {
    this.l.removeMessages(2);
    this.l.sendEmptyMessageDelayed(2, 500L);
  }
  
  private void u()
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.24(this));
  }
  
  private boolean v()
  {
    BaseChatPie localBaseChatPie = this.i;
    if (localBaseChatPie != null) {
      return ((IApolloManagerService)localBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable();
    }
    return false;
  }
  
  private void w()
  {
    if (getVisibility() == 0)
    {
      if (this.ao.b())
      {
        QLog.d("[cmshow]ApolloPanel", 2, "showGuidePageFor3D for json");
        this.ap = true;
        this.ao.b(false);
        k();
        return;
      }
      if (this.ao.a())
      {
        QLog.d("[cmshow]ApolloPanel", 2, "showGuidePageFor3D for action");
        this.ap = true;
        this.ao.a(false);
        k();
      }
    }
  }
  
  private void x()
  {
    if (this.ak == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[checkInitGuidePage]");
      }
      this.ak = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131624172, null));
      this.ak.setCallback(this.i);
      this.ak.setSessionInfo(this.j);
      this.ak.setClickCallback(this.ar);
      addView(this.ak, -1, -1);
    }
    this.ak.bringToFront();
  }
  
  private void y()
  {
    ApolloPanelGuideView localApolloPanelGuideView = this.ak;
    if (localApolloPanelGuideView == null) {
      return;
    }
    if (localApolloPanelGuideView.getParent() == this)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[hideGuidePageFor3D] remove");
      }
      super.removeView(this.ak);
      this.ak = null;
      d = 0;
    }
  }
  
  private void z()
  {
    int i1 = this.G.size();
    int i2 = a;
    if ((i1 > i2) && ((this.G.get(i2) instanceof ApolloTagActionViewBinder))) {
      ((ApolloTagActionViewBinder)this.G.get(a)).h();
    }
  }
  
  public ApolloViewBinder a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getViewBinder type = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" packageId = ");
      localStringBuilder.append(paramInt2);
      QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    }
    return this.ai.a(paramInt1, paramInt2);
  }
  
  public void a()
  {
    ThreadManager.post(new ApolloPanel.9(this), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    this.L = paramInt;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt == 2) {}
      }
      else
      {
        if (!FileUtil.d("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"))
        {
          c(paramInt, 3);
          this.Z.a(this.f);
          return;
        }
        ApolloPanelAdapter localApolloPanelAdapter = this.n;
        if (localApolloPanelAdapter != null) {
          localApolloPanelAdapter.a(this.G);
        }
        b(this.i.d.getCurrentUin());
        return;
      }
    }
    c(paramInt, 1);
  }
  
  public void a(int paramInt1, int paramInt2, ApolloPanel paramApolloPanel)
  {
    if (paramApolloPanel == null) {
      return;
    }
    if ((paramInt1 != 21) && (paramInt2 != 21)) {
      return;
    }
    boolean bool2 = true;
    boolean bool1;
    if (paramInt2 == 21)
    {
      if ((this.G.size() > 0) && (((ApolloViewBinder)this.G.get(0)).k == 1) && (this.ak == null))
      {
        paramApolloPanel = this.i;
        if ((paramApolloPanel != null) && (paramApolloPanel.d != null))
        {
          paramInt1 = this.V.getApolloStatus(this.i.d.getCurrentUin());
          ApolloDtReportUtil.a("panel", "new_user_v2", "expose", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.i.d)).b(ApolloDtReportUtil.a(this.i.ah.a)).c(this.i.ah.b).f(paramInt1).a());
          bool1 = bool2;
          break label236;
        }
      }
      a(ApolloDtReportUtil.b(i(a)), "expose");
      paramApolloPanel = this.u;
      bool1 = bool2;
      if (paramApolloPanel != null)
      {
        bool1 = bool2;
        if (paramApolloPanel.getVisibility() == 0)
        {
          a("panel_store", "expose");
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    label236:
    ((ISpriteScriptManager)this.i.d.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext().b(bool1);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.p != null)
    {
      Object localObject1 = this.i;
      if (localObject1 != null)
      {
        if (((BaseChatPie)localObject1).d == null) {
          return;
        }
        localObject1 = this.p.a();
        if (paramInt >= ((List)localObject1).size()) {
          return;
        }
        localObject1 = (ApolloActionPackage)((List)localObject1).get(paramInt);
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject1).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject1).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.M) });
        Object localObject2;
        if ((((ApolloActionPackage)localObject1).packageId == 8) && (!((ApolloActionPackage)localObject1).isRecommendTabClick))
        {
          localObject2 = this.i.d.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("apollo_sp");
          localStringBuilder.append(this.i.d.getCurrentUin());
          ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("apollo_sp_key_recommend_tab_click", true).commit();
          ((ApolloActionPackage)localObject1).isRecommendTabClick = true;
          ((ApolloTabAdapter.ViewHolder)paramView.getTag()).c.setVisibility(4);
        }
        if (((ApolloActionPackage)localObject1).isUpdate)
        {
          if (NetConnInfoCenter.getServerTimeMillis() < ((ApolloActionPackage)localObject1).redStartTime) {
            return;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("clear tab red packageId=");
          ((StringBuilder)localObject2).append(((ApolloActionPackage)localObject1).packageId);
          ((StringBuilder)localObject2).append(" tabIndex = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject2).toString());
          ((ApolloTabAdapter.ViewHolder)paramView.getTag()).c.setVisibility(4);
          ((ApolloActionPackage)localObject1).isUpdate = false;
          paramInt = ((ApolloActionPackage)localObject1).redFlowId;
          QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject1).packageId), ", new action id=", Integer.valueOf(paramInt) });
          ThreadManager.post(new ApolloPanel.17(this, (ApolloActionPackage)localObject1), 5, null, true);
          QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkRedTab] mShouldShowActionFloatView=", Boolean.valueOf(this.ae), ", mIsTriggeredByClick=", Boolean.valueOf(this.O) });
          this.l.removeMessages(1);
          if ((this.ae) && (paramInt != 0))
          {
            paramView = this.l.obtainMessage(1);
            paramView.arg1 = paramInt;
            paramView.getData().putInt("pkgId", ((ApolloActionPackage)localObject1).packageId);
            this.l.sendMessageDelayed(paramView, 800L);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "auth_finish");
    }
    post(new ApolloPanel.15(this, paramString, paramInt));
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.i = paramBaseChatPie;
    this.j = paramSessionInfo;
    this.ab = new CmshowPanelDialog(this.i.d, this.i.f, this.j.a);
    this.W = ((ApolloDaoManagerServiceImpl)this.i.d.getRuntimeService(IApolloDaoManagerService.class, "all"));
    this.V = ((ApolloManagerServiceImpl)this.i.d.getRuntimeService(IApolloManagerService.class, "all"));
    this.Z = ApolloResManagerFacade.a.a(Scene.AIO);
    this.af = new Panel2DStrategy(this.i.d, this.i.e, this.j);
    this.af.a(new ApolloPanel.1(this));
    this.ag = new Panel3DStrategy(this.i.d, this.i.e, this.j);
    this.ag.a(new ApolloPanel.2(this));
    this.ai = this.af;
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    if (this.V.getApolloStatus(this.i.d.getCurrentUin()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.K = paramInt1;
      this.J = paramInt2;
    }
    this.L = paramInt3;
    this.V.addApolloStatusUpdateListener(this.aj);
    this.ao = this.V.getBubbleProducer();
    this.n.a(this.i);
    this.n.a(this.j);
    this.k = this.V.getApolloPanelManager();
    paramBaseChatPie = this.k;
    if (paramBaseChatPie != null) {
      this.D.setText(String.valueOf(paramBaseChatPie.c.get()));
    }
    this.y = ((IRedTouchManager)this.i.d.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103200.103250");
    ((IWebProcessManagerService)this.i.d.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(100, null);
    QZoneVipInfoManager.a(this.i.d);
    paramBaseChatPie = MobileQQ.getContext().getSharedPreferences(this.i.d.getCurrentAccountUin(), 0);
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("chat_tool_apollo_");
    paramSessionInfo.append(this.i.d.getCurrentAccountUin());
    if (paramBaseChatPie.getBoolean(paramSessionInfo.toString(), false))
    {
      paramBaseChatPie = paramBaseChatPie.edit();
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("chat_tool_apollo_");
      paramSessionInfo.append(this.i.d.getCurrentAccountUin());
      paramBaseChatPie.putBoolean(paramSessionInfo.toString(), false).commit();
      paramBaseChatPie = this.i.d.getHandler(ChatActivity.class);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.obtainMessage(51).sendToTarget();
      }
    }
    if (ApolloManagerServiceImpl.sFirstOpenPanel)
    {
      QLog.d("[cmshow]ApolloPanel", 1, "[initPanel] getUserApolloInfo");
      this.M = true;
      ((ApolloExtensionHandler)this.i.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.i.d.getCurrentUin(), 1082392704, "Open Panel");
      ApolloManagerServiceImpl.sFirstOpenPanel = false;
    }
    paramBaseChatPie = this.k;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.a(null);
    }
    this.F = new ApolloPanelExtendHelper(this, this.i.d, getCommonStatisticsParams());
    this.F.a();
    setBackgroundColor(super.getResources().getColor(2131166015));
    q();
    m();
    QLog.d("[cmshow]ApolloPanel", 2, "init panel done");
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloPanel handleMemeGetFrame : ");
    localStringBuilder.append(paramApolloActionData.toString());
    QLog.d("[cmshow]ApolloPanel", 4, localStringBuilder.toString());
    this.V.handleMemeGetFrame("apolloPanel", paramApolloActionData, new ApolloPanel.FrameCallback(this.G, paramApolloActionData), this.Z);
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    if (paramApolloInfo != null)
    {
      if (paramApolloInfo.mAction == null) {
        return;
      }
      int i3 = 0;
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= this.G.size()) {
          break;
        }
        Object localObject1 = (ApolloViewBinder)this.G.get(i1);
        if ((((ApolloViewBinder)localObject1).o != null) && (((ApolloViewBinder)localObject1).l == 2))
        {
          if (((ApolloViewBinder)localObject1).k != 5)
          {
            ((ApolloViewBinder)localObject1).b(5);
            localObject2 = new ApolloInfo();
            ((ApolloInfo)localObject2).mType = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131886675);
            ((ApolloInfo)localObject2).mAction = localApolloActionData;
            ((ApolloViewBinder)localObject1).o.add(0, localObject2);
          }
          localObject1 = ((ApolloViewBinder)localObject1).o;
          Object localObject2 = this.i;
          if ((localObject2 != null) && (((BaseChatPie)localObject2).d != null)) {
            paramApolloInfo.iconType = ApolloPanelUtil.a(this.i.d, paramApolloInfo, paramApolloInfo.mAction);
          }
          ((List)localObject1).add(1, paramApolloInfo);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("add action to fav action ");
            ((StringBuilder)localObject1).append(paramApolloInfo.toString());
            QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject1).toString());
          }
          i2 = 1;
          break;
        }
        i1 += 1;
      }
      paramApolloInfo = this.n;
      if ((paramApolloInfo != null) && (i2 != 0)) {
        paramApolloInfo.notifyDataSetChanged();
      }
      paramApolloInfo = this.i;
      if ((paramApolloInfo != null) && (paramApolloInfo.d != null) && (i2 == 0)) {
        a(this.i.d.getCurrentAccountUin());
      }
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloPanel.22(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
  }
  
  public void a(String paramString)
  {
    a(paramString, false, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initPanelData] refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    Object localObject = this.i;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      localObject = this.W.getPackageInfoBySession(this.j.a);
      if (localObject == null)
      {
        QLog.w("[cmshow]ApolloPanel", 1, "packageList is null.");
        return;
      }
      this.I.clear();
      this.S = false;
      ApolloPanelInitData localApolloPanelInitData = new ApolloPanelInitData();
      a(paramString, (List)localObject, localApolloPanelInitData);
      a(paramBoolean, localApolloPanelInitData.c(), localApolloPanelInitData.d());
      e(localApolloPanelInitData.a());
      if (localApolloPanelInitData.c().size() == 0)
      {
        QLog.e("[cmshow]ApolloPanel", 2, "packageBinderList size is 0, return.");
        return;
      }
      c(localApolloPanelInitData.d());
      a(localApolloPanelInitData.d());
      b(localApolloPanelInitData.c());
      this.ai.a();
      a(this.y, "103100.103200.103250", paramBoolean);
      p();
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[initPanelData] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[initBinderData] forceRefresh=", Boolean.valueOf(paramBoolean1), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean2) });
    }
    ThreadManager.post(new ApolloPanel.5(this, paramBoolean1, paramString, paramBoolean2), 5, null, true);
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    BaseChatPie localBaseChatPie = this.i;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.f == null) {
        return;
      }
      this.i.f.runOnUiThread(new ApolloPanel.11(this, paramList));
    }
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {
      return;
    }
    String str1 = (String)paramMap.get("APOLLO_POP_TYPE");
    if ("toast".equals(str1))
    {
      str1 = (String)paramMap.get("offset");
      paramMap = (String)paramMap.get("tips");
      a(Integer.parseInt(str1), paramMap);
      return;
    }
    if ("dialog".equals(str1))
    {
      str1 = (String)paramMap.get("feeType");
      String str2 = (String)paramMap.get("title");
      String str3 = (String)paramMap.get("content");
      String str4 = (String)paramMap.get("rightString");
      String str5 = (String)paramMap.get("url");
      String str6 = (String)paramMap.get("isActionBack");
      String str7 = (String)paramMap.get("actionId");
      String str8 = (String)paramMap.get("extendJson");
      paramMap = (String)paramMap.get("personNum");
      this.ab.a(str1, str2, str3, str4, str5, str6, str7, str8, paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = NetworkUtil.isNetworkAvailable();
    int i2 = 1;
    if (!bool)
    {
      QQToast.makeText(getContext(), 1, 2131886672, 0).show();
      return;
    }
    if (this.j != null)
    {
      Object localObject1 = this.i;
      if (localObject1 != null)
      {
        if (((BaseChatPie)localObject1).d == null) {
          return;
        }
        int i1 = 2131886740;
        int i3 = 2131886739;
        localObject1 = "change3d";
        String str;
        Object localObject2;
        if (paramBoolean)
        {
          i1 = 2131886742;
          i3 = 2131886741;
          str = "open_3d_cmshow";
          localObject2 = "change3d";
        }
        else
        {
          str = "open_2d_cmshow";
          localObject1 = "change2d";
          localObject2 = localObject1;
          i2 = 0;
        }
        VipUtils.a(this.i.d, "cmshow", "Apollo", (String)localObject2, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.i.F()), 0, new String[0]);
        a((String)localObject1, "click");
        ((ApolloExtensionHandler)this.i.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(str, i2, new ApolloPanel.30(this, i3, i1));
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).d == null) {
        return;
      }
      localObject = this.E;
      if (localObject != null) {
        ((ApolloSecondaryViewBinder)localObject).e();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("actionpanel onOpen response result:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
      if (paramBoolean)
      {
        if (paramObject == null) {
          return;
        }
        paramObject = (Pair)paramObject;
        localObject = (String)paramObject.first;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((String)localObject).equals(this.i.d.getCurrentUin())) {
            return;
          }
          if (2 == ((Integer)paramObject.second).intValue())
          {
            a = 0;
            this.m.setCurrentItem(a);
            i();
            return;
          }
          if (1 == ((Integer)paramObject.second).intValue())
          {
            this.Z.a(false, "panel open apollo", 1);
            paramObject = this.E;
            if (paramObject != null)
            {
              paramObject.b(0);
              a(this.i.d.getCurrentAccountUin(), true, false);
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "del fav action");
    }
    Object localObject1 = this.i;
    if (localObject1 != null)
    {
      if (((BaseChatPie)localObject1).d == null) {
        return;
      }
      int i4 = 0;
      int i2 = 0;
      int i3;
      for (;;)
      {
        int i5 = this.G.size();
        i3 = 1;
        int i1 = 1;
        if (i2 >= i5) {
          break;
        }
        localObject1 = (ApolloViewBinder)this.G.get(i2);
        if (((ApolloViewBinder)localObject1).l == 2)
        {
          List localList1 = ((ApolloViewBinder)localObject1).o;
          if ((localList1 != null) && (localList1.size() != 0))
          {
            if (this.W == null)
            {
              if (QLog.isColorLevel()) {
                QLog.e("[cmshow]ApolloPanel", 2, "apolloDaoManager null");
              }
              return;
            }
            localList1.clear();
            Object localObject2 = this.W.getFavPanelActionPairInfo();
            List localList2 = (List)((Pair)localObject2).first;
            localObject2 = (List)((Pair)localObject2).second;
            ApolloInfo localApolloInfo;
            if ((localList2 != null) && (localList2.size() > 0))
            {
              ((ApolloViewBinder)localObject1).b(5);
              localApolloInfo = new ApolloInfo();
              localApolloInfo.mType = 2;
              ApolloActionData localApolloActionData = new ApolloActionData();
              localApolloActionData.actionName = super.getResources().getString(2131886675);
              localApolloInfo.mAction = localApolloActionData;
              localList1.add(localApolloInfo);
            }
            else
            {
              ((ApolloViewBinder)localObject1).b(4);
              i1 = 0;
            }
            for (;;)
            {
              i3 = i1;
              if (i4 >= ((List)localObject2).size()) {
                break;
              }
              localApolloInfo = ((ApolloViewBinder)localObject1).a(this.i.d.getCurrentUin());
              if (localApolloInfo != null)
              {
                localApolloInfo.mAction = ((ApolloActionData)((List)localObject2).get(i4));
                localApolloInfo.mPackageId = ((ApolloViewBinder)localObject1).n;
                if ((localList2 != null) && (localList2.size() > i2))
                {
                  localApolloInfo.mActionText = ((ApolloFavActionData)localList2.get(i4)).text;
                  localApolloInfo.mTextType = ((ApolloFavActionData)localList2.get(i4)).textType;
                  localApolloInfo.iconType = ApolloPanelUtil.a(this.i.d, localApolloInfo, localApolloInfo.mAction);
                }
                localList1.add(localApolloInfo);
              }
              i4 += 1;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, "no fav action yet");
          }
          return;
        }
        i2 += 1;
      }
      localObject1 = this.n;
      if ((localObject1 != null) && (i3 != 0)) {
        ((ApolloPanelAdapter)localObject1).notifyDataSetChanged();
      }
      localObject1 = this.i;
      if ((localObject1 != null) && (((BaseChatPie)localObject1).d != null) && (i3 == 0)) {
        a(this.i.d.getCurrentAccountUin());
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    Object localObject = this.p;
    if (localObject == null) {
      return;
    }
    localObject = ((ApolloTabAdapter)localObject).a();
    if (localObject != null)
    {
      if (paramInt >= ((List)localObject).size()) {
        return;
      }
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      int i1 = ((ApolloActionPackage)localObject).type;
      if (!this.I.contains(Integer.valueOf(paramInt)))
      {
        localObject = this.i;
        if ((localObject != null) && (((BaseChatPie)localObject).d != null))
        {
          if (i1 == 2) {
            this.Z.a(paramInt, true);
          } else if ((i1 != 100) && (i1 != 9) && (this.V.getApolloStatus(this.i.d.getCurrentUin()) == 1)) {
            this.Z.a(paramInt, false);
          }
          this.I.add(Integer.valueOf(paramInt));
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
          }
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jumpPkgId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    Object localObject = this.i;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      if (this.V.getApolloStatus(this.i.d.getCurrentUin()) != 1)
      {
        QLog.d("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] status not open, abort jump");
        return;
      }
      localObject = this.G;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if ((paramInt1 == -1) && (paramInt2 == -1))
        {
          QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] abort finding action index");
          return;
        }
        if (this.n == null)
        {
          QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] failed, no view pager");
          return;
        }
        a(0, -1, -1, paramInt1, paramInt2);
        a(paramInt1, paramInt2, -1, -1);
        return;
      }
      QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] jump failed, no binder data");
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[jumpToPkgOrAction] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    long l1 = 0L;
    if (QLog.isColorLevel())
    {
      l1 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateItemStatus action= ");
      ((StringBuilder)localObject).append(paramApolloActionData.actionId);
      ((StringBuilder)localObject).append(" action name =");
      ((StringBuilder)localObject).append(paramApolloActionData.actionName);
      QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.i;
    int i1;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null)) {
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.m.getChildCount())
        {
          localObject = (ViewGroup)this.m.getChildAt(i1);
          if ((localObject instanceof ApolloLinearLayout))
          {
            if (((ApolloLinearLayout)localObject).d(paramApolloActionData) != null) {
              break label403;
            }
            continue;
            if (i2 < ((ViewGroup)localObject).getChildCount())
            {
              LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)localObject).getChildAt(i2);
              int i3 = 0;
              if (i3 < localLinearLayout.getChildCount())
              {
                ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)localLinearLayout.getChildAt(i3).getTag();
                if (localViewHolder != null)
                {
                  ApolloInfo localApolloInfo = localViewHolder.j;
                  if ((localApolloInfo != null) && (localApolloInfo.mAction != null) && (localApolloInfo.mAction.actionId == paramApolloActionData.actionId)) {
                    this.i.d.getHandler(ChatActivity.class).post(new ApolloPanel.16(this, localViewHolder));
                  }
                }
                i3 += 1;
                continue;
              }
              i2 += 1;
              continue;
            }
          }
          i1 += 1;
          continue;
        }
        long l2;
        if (!QLog.isColorLevel()) {
          break label402;
        }
      }
      catch (Exception paramApolloActionData)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateItemStatus error:");
        ((StringBuilder)localObject).append(paramApolloActionData.toString());
        QLog.e("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel())
        {
          l2 = System.currentTimeMillis();
          paramApolloActionData = new StringBuilder();
          paramApolloActionData.append("updateItemStatus cost time = ");
          paramApolloActionData.append(l2 - l1);
          QLog.d("[cmshow]ApolloPanel", 2, paramApolloActionData.toString());
        }
        return;
      }
      QLog.d("[cmshow]ApolloPanel", 2, "something=null ");
      label402:
      return;
      label403:
      int i2 = 0;
    }
  }
  
  public void b(String paramString)
  {
    h(0);
    a(paramString, false);
  }
  
  public void b(List<ApolloViewBinder> paramList)
  {
    this.l.post(new ApolloPanel.12(this, paramList));
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie localBaseChatPie = this.i;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.d == null) {
        return;
      }
      boolean bool2 = QLog.isColorLevel();
      boolean bool1 = true;
      if (bool2) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[onQueryUserApolloAction] result=", Boolean.valueOf(paramBoolean), ", mIsGettingUserInfo=", Boolean.valueOf(this.M) });
      }
      if ((this.M) && (!paramBoolean))
      {
        this.K = -1;
        this.J = -1;
      }
      bool2 = this.M;
      this.M = false;
      if (paramBoolean)
      {
        if (paramObject != null)
        {
          paramObject = (Bundle)paramObject;
          int i1 = paramObject.getInt("jumpPkdId", -1);
          int i2 = paramObject.getInt("jumpActionId", -1);
          if ((i1 != -1) && (i2 != -1))
          {
            this.K = i1;
            this.J = i2;
          }
        }
        if ((bool2) && (paramBoolean)) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
        a(this.i.d.getCurrentUin(), false, paramBoolean);
      }
    }
  }
  
  public int c(int paramInt)
  {
    if (paramInt > 0)
    {
      int i1 = 0;
      int i2 = 0;
      while (i1 < this.G.size())
      {
        i2 += ((ApolloViewBinder)this.G.get(i1)).c();
        if (paramInt < i2) {
          return i1;
        }
        i1 += 1;
      }
    }
    return 0;
  }
  
  public void c()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).d == null) {
        return;
      }
      localObject = (ApolloExtensionHandler)this.i.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      ((ApolloExtensionHandler)localObject).a(1, "actionPanel", null);
      int i1 = this.V.openType;
      ApolloPanel.10 local10 = new ApolloPanel.10(this, i1);
      if (2 == i1)
      {
        ((ApolloExtensionHandler)localObject).a("actionPanel", 1, local10);
        return;
      }
      if (1 == i1)
      {
        ((ApolloExtensionHandler)localObject).a("actionPanel", 0, local10);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanel", 2, "actionpanel onOpen");
        }
        this.L = -1;
      }
    }
  }
  
  public void d()
  {
    Object localObject = this.i;
    if ((localObject != null) && (((BaseChatPie)localObject).f != null))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.i.f, (Intent)localObject, "aio", ApolloConstant.H, null);
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject1 = this.i;
    if ((localObject1 != null) && (((BaseChatPie)localObject1).d != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showGuidePageForOpenCmshow dataType:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("[cmshow]ApolloPanel", 1, ((StringBuilder)localObject1).toString());
      ArrayList localArrayList = new ArrayList();
      localObject1 = this.W;
      if (localObject1 == null)
      {
        QLog.e("[cmshow]ApolloPanel", 1, "showGuidePageForOpenCmshow adm == null");
        ApolloUtilImpl.showDebugTipsToast("showGuidePageForOpenCmshow adm == null");
        return;
      }
      d = paramInt;
      if (paramInt == 1)
      {
        localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).getActionByPackageId(400);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((List)localObject2).size() > 4) {
              localObject1 = ((List)localObject2).subList(0, 4);
            }
          }
          paramInt = 0;
          while ((localObject1 != null) && (paramInt < ((List)localObject1).size()))
          {
            localObject2 = new Apollo3DMainInfo(this.i.d.getCurrentUin());
            ((Apollo3DMainInfo)localObject2).mAction = ((ApolloActionData)((List)localObject1).get(paramInt));
            localArrayList.add(localObject2);
            paramInt += 1;
          }
        }
        QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
        ApolloUtilImpl.showDebugTipsToast("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
        if (21 == this.i.aR())
        {
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            this.i.aQ();
            return;
          }
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.26(this));
        }
        return;
      }
      Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).getRecommendActionDataList();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((List)localObject2).size() > 4) {
            localObject1 = ((List)localObject2).subList(0, 4);
          }
        }
        paramInt = 0;
        while ((localObject1 != null) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = new ApolloMainInfo(this.i.d.getCurrentUin());
          ((ApolloMainInfo)localObject2).mAction = ((ApolloActionData)((List)localObject1).get(paramInt));
          localArrayList.add(localObject2);
          paramInt += 1;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          x();
          this.ak.setGuideType(1);
          this.ak.setActions(localArrayList);
        }
        else
        {
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.28(this, localArrayList));
        }
        if (this.j != null)
        {
          localObject1 = this.i;
          if (localObject1 != null)
          {
            VipUtils.a(((BaseChatPie)localObject1).d, "cmshow", "Apollo", "exp_panelnewuser_show", this.j.b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.i.F()), d, new String[] { String.valueOf(this.e), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
            a("new_user_panel", "expose");
          }
        }
        return;
      }
      QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      ApolloUtilImpl.showDebugTipsToast("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      if (21 == this.i.aR())
      {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          this.i.aQ();
          return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.27(this));
      }
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageForOpenCmshow] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      StartupTracker.a("apollo_panel_open", null);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "dispatchdraw is called");
      }
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchDraw, StackOverflowError, stack:");
      localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramCanvas));
      QLog.e("[cmshow]ApolloPanel", 1, localStringBuilder.toString());
    }
  }
  
  protected void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    super.dispatchVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      this.aa.a();
    }
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.Q = bool;
  }
  
  public void e()
  {
    BaseChatPie localBaseChatPie = this.i;
    if (localBaseChatPie != null)
    {
      if (localBaseChatPie.d == null) {
        return;
      }
      this.Z.a(this.f);
      int i1 = 0;
      if (!FileUtil.d("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
        i1 = 1;
      }
      this.Z.j(i1);
    }
  }
  
  public void f()
  {
    int i1 = 0;
    while (i1 < this.G.size())
    {
      ((ApolloViewBinder)this.G.get(i1)).b();
      i1 += 1;
    }
    Object localObject = this.i;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      this.Z.b(this.f);
      this.Z.b();
      localObject = this.k;
      if (localObject != null) {
        ((ApolloPanelManager)localObject).c();
      }
      if (this.U != null) {
        this.i.d.removeObserver(this.U);
      }
    }
    this.ab.a();
    ThreadManager.getUIHandler().removeCallbacks(this.ad);
    this.l.removeMessages(1);
    this.l.removeMessages(2);
    s();
    this.n = null;
    this.E = null;
    this.f = null;
    this.G.clear();
    this.aa.a();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[switch2RedTab] visibility=", Integer.valueOf(super.getVisibility()) });
    }
    if (super.getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "[switch2RedTab] visible now, abort");
      }
      return;
    }
    Object localObject = this.p;
    if (localObject == null) {
      return;
    }
    localObject = ((ApolloTabAdapter)localObject).a();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      int i2 = ((List)localObject).size();
      int i1 = 0;
      while (i1 < i2)
      {
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)((List)localObject).get(i1);
        if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[switch2RedTab] packageId=", Integer.valueOf(localApolloActionPackage.packageId) });
          }
          g(i1);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public int getApolloStatus()
  {
    return this.L;
  }
  
  public HorizontalListView getApolloTab()
  {
    return this.o;
  }
  
  public List<ApolloInfo> getCurrentTabData()
  {
    ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.G.get(a);
    if (localApolloViewBinder == null) {
      return null;
    }
    return localApolloViewBinder.j();
  }
  
  public void h()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).d == null) {
        return;
      }
      localObject = this.i.d.getHandler(ChatActivity.class);
      if (localObject == null) {
        return;
      }
      ((MqqHandler)localObject).post(new ApolloPanel.13(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return false;
      }
      paramMessage = this.i;
      if ((paramMessage != null) && (paramMessage.d != null) && (this.Q))
      {
        paramMessage = this.z;
        if ((paramMessage != null) && (!TextUtils.isEmpty(paramMessage.content)) && (this.z.life_Time > 0) && (this.z.show_sum < this.z.show_counts))
        {
          this.aa.a(this.t, 49, this.z.content, this.z.life_Time, null);
          paramMessage = this.z;
          paramMessage.show_sum += 1;
          this.V.updateDrawerItem(this.z);
          return false;
        }
      }
    }
    else
    {
      i1 = paramMessage.getData().getInt("pkgId");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[handleMessage] MSG_SHOW_NEW_ACTION_FLOAT_VIEW, actionId=", Integer.valueOf(paramMessage.arg1), ", pkgId=", Integer.valueOf(i1) });
      }
      d(paramMessage.arg1, i1);
    }
    return false;
  }
  
  public void i()
  {
    Object localObject = this.i;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      this.Z.a(this.f);
      localObject = this.k;
      if (localObject != null) {
        ((ApolloPanelManager)localObject).a(this.g);
      }
      a(this.V.getApolloStatus(this.i.d.getCurrentUin()));
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[initData] mBaseChatPie or mBaseChatPie.app is null");
  }
  
  public boolean isPanelOpen()
  {
    return this.F.d();
  }
  
  public void j()
  {
    Object localObject = this.i;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      localObject = this.i.d.getHandler(ChatActivity.class);
      if (localObject == null) {
        return;
      }
      ((MqqHandler)localObject).post(new ApolloPanel.18(this));
    }
  }
  
  public void k()
  {
    Object localObject = this.i;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      if ((App3DConfig.sShow) && (this.h != 2) && (v()))
      {
        x();
        this.ak.setGuideType(0);
        localObject = new ArrayList();
        List localList = this.W.getActionByPackageId(400);
        if ((localList != null) && (localList.size() > 0))
        {
          int i1 = 0;
          while (i1 < localList.size())
          {
            Apollo3DMainInfo localApollo3DMainInfo = new Apollo3DMainInfo(this.i.d.getCurrentUin());
            localApollo3DMainInfo.mAction = ((ApolloActionData)localList.get(i1));
            ((List)localObject).add(localApollo3DMainInfo);
            i1 += 1;
          }
        }
        this.ak.setActions((List)localObject);
        localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        ((TranslateAnimation)localObject).setDuration(500L);
        ((TranslateAnimation)localObject).setRepeatCount(0);
        ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        this.ak.startAnimation((Animation)localObject);
        if (!this.aq)
        {
          this.aq = true;
          this.Z.e();
        }
        return;
      }
      y();
      return;
    }
    QLog.e("[cmshow]ApolloPanel", 1, "[showGuidePageFor3D] mBaseChatPie or mGuidePageFor3D or mBaseChatPie.app is null");
  }
  
  public void l()
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    QQAppInterface localQQAppInterface = ((BaseChatPie)localObject).d;
    localObject = this.i.ah;
    if (localQQAppInterface != null)
    {
      if (localObject == null) {
        return;
      }
      int i1 = this.V.getCmShowStatusNoCareSelfStatus(localQQAppInterface, ((SessionInfo)localObject).b, false);
      int i2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(((SessionInfo)localObject).a);
      if (i1 == 2) {
        localObject = "3D";
      } else {
        localObject = "2D";
      }
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", i2, 0, new String[] { localObject });
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131429933: 
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, "click tab shop");
      }
      paramView = this.i;
      if ((paramView != null) && (paramView.d != null))
      {
        if (this.P)
        {
          paramView = this.z;
          if (paramView != null)
          {
            this.V.clickPushItem(paramView, this.i.d, this.i.e, "aio_shop");
            ((ApolloDaoManagerServiceImpl)this.i.d.getRuntimeService(IApolloDaoManagerService.class, "all")).removePushItem(this.z);
            ((IRedTouchManager)this.i.d.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103200.103250");
            this.v.g();
            this.P = false;
            u();
            VipUtils.a(this.i.d, "cmshow", "Apollo", "house_new_click", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.i.F()), 0, new String[] { this.z.msg_id });
            break label333;
          }
        }
        boolean bool = this.V.is3dAvailable();
        if (this.h == 2)
        {
          if (bool) {
            paramView = ApolloConstant.N;
          } else {
            paramView = ApolloConstant.O;
          }
          CmShowLauncher.a(BaseApplicationImpl.getContext(), paramView, null);
        }
        else
        {
          if (bool) {
            paramView = ApolloConstant.H;
          } else {
            paramView = ApolloConstant.I;
          }
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.i.f, null, "aio", paramView, null);
        }
        VipUtils.a(this.i.d, "cmshow", "Apollo", "house_click", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.i.F()), 0, new String[0]);
        a("panel_store", "click");
        return;
      }
      break;
    case 2131429908: 
      a(true);
      return;
    case 2131429794: 
      a(false);
      return;
    case 2131428484: 
      label333:
      paramView = this.i;
      if (paramView != null)
      {
        VipUtils.a(paramView.d, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.i.f, null, "aio", ApolloConstant.I, null, 14003);
        a("package_slave", "open");
      }
      break;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i1 == 1) || (i1 == 3)) {
      super.getParent().requestDisallowInterceptTouchEvent(false);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ApolloPanel event ");
      localStringBuilder.append(paramMotionEvent.toString());
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { localStringBuilder.toString(), " 是否拦截：", Boolean.valueOf(super.onInterceptTouchEvent(paramMotionEvent)) });
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.O = true;
    g(paramInt);
    this.O = false;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChange state=");
      localStringBuilder.append(paramInt);
      QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled i=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",il=");
      localStringBuilder.append(paramInt2);
      QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pager position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject1).toString());
    }
    int i2 = c(paramInt);
    if ((this.H.contains(Integer.valueOf(paramInt - 1))) || (this.H.contains(Integer.valueOf(paramInt))) || (this.ah))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("change tab index = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject1).toString());
      }
      setTabSelect(i2);
    }
    int i1;
    if (paramInt < a) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    a = paramInt;
    f(paramInt);
    if (this.i == null) {
      return;
    }
    Object localObject1 = this.p;
    if (localObject1 != null)
    {
      localObject1 = ((ApolloTabAdapter)localObject1).a();
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (i2 >= 0) && (i2 < ((List)localObject1).size()))
      {
        localObject1 = (ApolloActionPackage)((List)localObject1).get(i2);
        if (localObject1 != null)
        {
          i2 = ((ApolloActionPackage)localObject1).packageId;
          break label246;
        }
      }
    }
    i2 = 0;
    label246:
    if (i2 == 6) {
      this.A.setVisibility(0);
    } else {
      this.A.setVisibility(8);
    }
    localObject1 = this.j;
    if (localObject1 != null) {
      localObject1 = ((SessionInfo)localObject1).b;
    } else {
      localObject1 = "";
    }
    Object localObject3 = this.i.d;
    int i3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.j.a);
    Object localObject2;
    if (i1 != 0) {
      localObject2 = "0";
    } else {
      localObject2 = "1";
    }
    VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, i3, i2, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    if (this.G.size() > 0)
    {
      localObject2 = null;
      localObject3 = this.G.iterator();
      i1 = 0;
      ApolloViewBinder localApolloViewBinder;
      do
      {
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localApolloViewBinder = (ApolloViewBinder)((Iterator)localObject3).next();
        } while ((localApolloViewBinder == null) || (!(localApolloViewBinder instanceof ApolloViewBinder)));
        i3 = localApolloViewBinder.c();
        i2 = i1 + i3;
        i1 = i2;
      } while (paramInt + 1 > i2);
      if (!(localApolloViewBinder instanceof ApolloSecondaryViewBinder))
      {
        localObject1 = localObject2;
        if (!(localApolloViewBinder instanceof ApolloFavViewBinder)) {}
      }
      else
      {
        localObject1 = localApolloViewBinder.a(i3 - (i2 - paramInt));
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = new StringBuilder();
        i1 = ((ArrayList)localObject1).size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (ApolloInfo)((ArrayList)localObject1).get(paramInt);
          if (((ApolloInfo)localObject3).mAction != null) {
            ((StringBuilder)localObject2).append(((ApolloInfo)localObject3).mAction.actionId);
          } else {
            ((StringBuilder)localObject2).append("0");
          }
          if (paramInt != i1 - 1) {
            ((StringBuilder)localObject2).append("-");
          }
          paramInt += 1;
        }
        VipUtils.a(this.i.d, "cmshow", "Apollo", "actionexposure", this.j.b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.j.a), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
  }
  
  public void onPullDown()
  {
    this.F.c();
  }
  
  public void onPullUp()
  {
    this.F.b();
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.i == null) {
      return;
    }
    if ((paramInt == 0) && (this.h == 2))
    {
      int i1 = this.as;
      if ((i1 != -1) && (i1 != paramInt)) {
        this.ai.a();
      }
    }
    this.as = paramInt;
    if ((paramInt != 0) && (this.ak != null)) {
      y();
    }
    w();
    this.F.a(paramInt);
  }
  
  public void setTabSelect(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[setVisibility] visibility=", Integer.valueOf(paramInt) });
    }
    if (paramInt == 0)
    {
      this.R = System.currentTimeMillis();
      c = true;
      if (this.S)
      {
        SessionInfo localSessionInfo = this.j;
        if (localSessionInfo != null)
        {
          if (CmShowAioMatcherImpl.judgeSupported(localSessionInfo.a, 1))
          {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_c2c", "expo", "", "", "", "");
            return;
          }
          if (CmShowAioMatcherImpl.judgeSupported(this.j.a, 2)) {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio_cm", "cmgame_aio_cm_qun", "expo", "", "", "", "");
          }
        }
      }
    }
    else if (paramInt == 8)
    {
      this.l.removeMessages(1);
      s();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
      }
      this.ae = true;
      if (this.R != 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.R;
        if (this.j != null) {
          VipUtils.a(this.i.d, "cmshow", "Apollo", "panel_stay_time", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.j.a), 0, new String[] { "", "", "", String.valueOf(l1 - l2) });
        }
        this.R = 0L;
      }
      c = false;
      z();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */