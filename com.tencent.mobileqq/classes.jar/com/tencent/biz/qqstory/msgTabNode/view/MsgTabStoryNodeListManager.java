package com.tencent.biz.qqstory.msgTabNode.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemLongClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.ButtonConfig;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.StoryDebugUtils.StoryExceptionCallback;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.StoryTouchEventInterceptor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.QQStoryListViewListener;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class MsgTabStoryNodeListManager
  implements BaseAdapter.OnItemClickListener, BaseAdapter.OnItemLongClickListener, DrawerFrame.StoryTouchEventInterceptor, ARMapHongBaoListView.QQStoryListViewListener, ActionSheet.OnButtonClickListener
{
  public static boolean B = false;
  public static long C = 0L;
  private static String J;
  private static HashMap<Integer, String[]> K;
  public static String a = HardCodeUtil.a(2131904840);
  public static String b = HardCodeUtil.a(2131904844);
  public static String c = HardCodeUtil.a(2131904842);
  public static String d = HardCodeUtil.a(2131899712);
  public static String e = HardCodeUtil.a(2131904841);
  public static String f = HardCodeUtil.a(2131904845);
  public static String g = HardCodeUtil.a(2131904846);
  public static String h = HardCodeUtil.a(2131904848);
  public boolean A = false;
  protected GetRedPointExObserver D = new MsgTabStoryNodeListManager.2(this);
  public QQAppInterface E;
  public MsgNodeShotView F;
  boolean G = false;
  float H;
  Runnable I = new MsgTabStoryNodeListManager.11(this);
  private final int L = 30;
  private final int M = 70;
  private IPullRefreshHeaderControl N;
  private Conversation O;
  private DrawerFrame P;
  private BreathEffectView Q;
  private float R;
  private float S;
  private float T;
  private float U;
  private int V;
  private int W;
  private int X = 1;
  private int Y = 1;
  private View Z;
  private DotAnimationView aa;
  private Vibrator ab;
  private Runnable ac = new MsgTabStoryNodeListManager.1(this);
  private AutomatorObserver ad = new MsgTabStoryNodeListManager.3(this);
  private final QQStoryObserver ae = new MsgTabStoryNodeListManager.4(this);
  private long af;
  MsgTabStoryNodeAdapter i;
  ActionSheet j;
  MsgTabStoryNodeDelegate k;
  long l;
  Context m;
  ARMapHongBaoListView n;
  MsgTabStoryNodeView o;
  public MsgTabStoryNodeListManager.MsgTabShowCounter p;
  int q;
  boolean r = false;
  boolean s = false;
  DataSetObserver t;
  View u;
  CalloutPopupWindow v;
  boolean w = false;
  boolean x = false;
  boolean y = false;
  public boolean z = false;
  
  static
  {
    J = "Q.qqstory.msgTab.MsgTabStoryNodeListManager";
    K = new HashMap();
    K.put(Integer.valueOf(5), new String[] { a, b });
    K.put(Integer.valueOf(6), new String[] { a, c });
    K.put(Integer.valueOf(7), new String[] { a, e });
    K.put(Integer.valueOf(9), new String[] { a, d, g });
    K.put(Integer.valueOf(11), new String[] { g });
    K.put(Integer.valueOf(10), new String[] { g });
    K.put(Integer.valueOf(12), new String[] { a, g });
  }
  
  public MsgTabStoryNodeListManager(Context paramContext, Conversation paramConversation, ListView paramListView, IPullRefreshHeaderControl paramIPullRefreshHeaderControl, DrawerFrame paramDrawerFrame, BreathEffectView paramBreathEffectView)
  {
    AssertUtils.assertNotNull_DEBUG(paramIPullRefreshHeaderControl);
    this.E = paramConversation.s();
    this.l = System.currentTimeMillis();
    this.m = paramContext;
    this.O = paramConversation;
    this.n = ((ARMapHongBaoListView)paramListView);
    this.N = paramIPullRefreshHeaderControl;
    this.o = new MsgTabStoryNodeView(paramContext);
    this.P = paramDrawerFrame;
    this.Q = paramBreathEffectView;
    this.Z = this.o.findViewById(2131446408);
    this.aa = ((DotAnimationView)this.o.findViewById(2131432069));
    this.ab = ((Vibrator)this.m.getSystemService("vibrator"));
    this.i = new MsgTabStoryNodeAdapter(paramContext);
    this.F = new MsgNodeShotView(paramContext);
    this.u = this.F;
    y();
    this.F.setLayoutParams(new RecyclerView.LayoutParams(AIOUtils.b(67.0F, this.Z.getResources()), AIOUtils.b(102.0F, this.Z.getResources())));
    this.i.a(this.F);
    this.i.a(this);
    this.i.a(this);
    this.o.c.setAdapter(this.i);
    this.k = new MsgTabStoryNodeDelegate(this, this.i, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.o.c.setOnScrollListener(new MsgTabStoryNodeListManager.6(this));
    this.t = new MsgTabStoryNodeListManager.7(this);
    this.R = UIUtils.a(this.m, -50.0F);
    this.S = UIUtils.a(this.m, -50.0F);
    this.T = UIUtils.a(this.m, -120.0F);
    this.V = UIUtils.a(this.m, -80.0F);
    this.W = UIUtils.a(this.m, 12.0F);
    AbstractGifImage.resumeAll();
    if (QLog.isColorLevel()) {
      QLog.i(J, 2, "on create");
    }
  }
  
  private void a(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.Y != 3)) {
      this.aa.a(paramFloat);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(J, 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%f,offset_scroll_over:%f", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.S), Float.valueOf(this.U) }));
    }
    float f1 = this.S;
    float f2 = 0.0F;
    if (paramFloat <= f1)
    {
      float f3 = this.U;
      if (paramFloat > f3)
      {
        f2 = this.T;
        if (paramFloat <= f2)
        {
          f3 = (f2 - paramFloat) / (f2 - f3);
          f1 = this.V + (f1 - f2) * 1.0F;
          f1 -= f3 * f1 * 1.5F;
        }
        else
        {
          f1 = this.V + (f1 - paramFloat) * 1.0F;
        }
        f2 = this.Z.getTranslationY();
        this.Z.setTranslationY(f1);
        f1 = this.Z.getTranslationY();
        int i1 = this.V;
        if (f1 < i1) {
          this.Z.setTranslationY(i1);
        }
        if (this.Z.getTranslationY() > 0.0F) {
          this.Z.setTranslationY(0.0F);
        }
        f2 = this.Z.getTranslationY() - f2;
        a(1.0F - this.Z.getTranslationY() / this.V + 0.8F);
        f1 = f2;
        if (this.ab == null) {
          break label337;
        }
        f1 = f2;
        if (this.H <= this.S) {
          break label337;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.ac);
        ThreadManager.getSubThreadHandler().post(this.ac);
        f1 = f2;
        break label337;
      }
    }
    f1 = f2;
    if (paramFloat <= this.U)
    {
      a(true);
      f1 = f2;
    }
    label337:
    DotAnimationView localDotAnimationView;
    if (paramFloat > UIUtils.a(this.m, -75.0F))
    {
      localDotAnimationView = this.aa;
      localDotAnimationView.setTranslationY((localDotAnimationView.getHeight() + paramFloat) / 2.0F);
    }
    else
    {
      localDotAnimationView = this.aa;
      localDotAnimationView.setTranslationY(localDotAnimationView.getTranslationY() + f1);
    }
    this.H = paramFloat;
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new QQStoryMainActivity.ButtonConfig("mainHallConfig");
    String str;
    if ((!TextUtils.isEmpty(((QQStoryMainActivity.ButtonConfig)localObject).d)) && (HttpUtil.isValidUrl(((QQStoryMainActivity.ButtonConfig)localObject).d))) {
      str = ((QQStoryMainActivity.ButtonConfig)localObject).d;
    } else {
      str = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
    }
    if ((((QQStoryMainActivity.ButtonConfig)localObject).a != 0) && (((QQStoryMainActivity.ButtonConfig)localObject).a != 1))
    {
      if (((QQStoryMainActivity.ButtonConfig)localObject).a == 2) {
        return;
      }
      int i1 = ((QQStoryMainActivity.ButtonConfig)localObject).a;
      return;
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", str);
    paramContext.startActivity((Intent)localObject);
  }
  
  private void a(View paramView, Activity paramActivity, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo.b == 12)
    {
      paramMsgTabNodeInfo.x = "";
      paramMsgTabNodeInfo = new OpenPlayerBuilder(new MsgTabPlayInfo(paramMsgTabNodeInfo.d, 0, null, paramMsgTabNodeInfo.o, paramMsgTabNodeInfo.n), 106);
      paramMsgTabNodeInfo.a(n());
      paramMsgTabNodeInfo = paramMsgTabNodeInfo.f();
      paramMsgTabNodeInfo.mUIStyle.bottomWidgetShowFlag = 3;
      if ((paramView instanceof StoryMsgNodeFrameLayout))
      {
        StoryPlayerLauncher.a(paramActivity, paramMsgTabNodeInfo, ((StoryMsgNodeFrameLayout)paramView).a);
        return;
      }
      StoryPlayerLauncher.a(paramActivity, paramMsgTabNodeInfo, paramView);
      return;
    }
    MsgTabNodeVidListPullSegment localMsgTabNodeVidListPullSegment = new MsgTabNodeVidListPullSegment(J);
    localMsgTabNodeVidListPullSegment.e = true;
    Stream.of(paramMsgTabNodeInfo).map(new ThreadOffFunction(J, 2)).map(localMsgTabNodeVidListPullSegment).map(new MsgTabNodeInsertLocalVideoInfoSegment(paramMsgTabNodeInfo)).map(new UIThreadOffFunction(null)).subscribe(new MsgTabStoryNodeListManager.9(this, paramMsgTabNodeInfo, paramView, paramActivity));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.Z.getTranslationY() != 0.0F) {
        this.Z.setTranslationY(0.0F);
      }
      if (this.Z.getAlpha() != 1.0F) {
        a(1.0F);
      }
      localMessage = Message.obtain();
      localMessage.what = 2003;
      localMessage.getData().putBoolean("isStoryShow", true);
      localMessage.getData().putFloat("nodeOffset", this.S);
      BannerManager.a().b(PushBannerProcessor.a, localMessage);
      localMessage = Message.obtain();
      localMessage.what = 2002;
      localMessage.getData().putBoolean("visible", false);
      BannerManager.a().b(PushBannerProcessor.a, localMessage);
      return;
    }
    float f1 = this.Z.getTranslationY();
    int i1 = this.V;
    if (f1 != i1) {
      this.Z.setTranslationY(i1);
    }
    if (this.Z.getAlpha() != 0.0F) {
      a(0.0F);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    localMessage.getData().putBoolean("isStoryShow", false);
    localMessage.getData().putFloat("nodeOffset", this.S);
    BannerManager.a().b(PushBannerProcessor.a, localMessage);
    localMessage = Message.obtain();
    localMessage.what = 2002;
    localMessage.getData().putBoolean("visible", true);
    BannerManager.a().b(PushBannerProcessor.a, localMessage);
  }
  
  private void b(boolean paramBoolean)
  {
    IPullRefreshHeaderControl localIPullRefreshHeaderControl = this.N;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localIPullRefreshHeaderControl.a(4, Integer.valueOf(i1));
  }
  
  private void p()
  {
    SLog.a(J, "onNodeScrollOut(), is storyView attached? %b", Boolean.valueOf(this.o.g ^ true));
    StoryReportor.a("msg_tab", "show_story", 0, 0, new String[0]);
    q();
    this.k.a("exp_story", 6);
    C = SystemClock.uptimeMillis();
  }
  
  private void q()
  {
    if ((this.I != null) && (this.w)) {
      ThreadManager.getUIHandler().post(this.I);
    }
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext());
  }
  
  private void r()
  {
    StoryReportor.a("msg_tab", "hide_story", 0, 0, new String[0]);
  }
  
  private boolean s()
  {
    MsgTabStoryNodeView localMsgTabStoryNodeView = this.o;
    if (localMsgTabStoryNodeView != null)
    {
      if (this.n == null) {
        return false;
      }
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      localMsgTabStoryNodeView.getLocationInWindow(arrayOfInt1);
      this.n.getLocationInWindow(arrayOfInt2);
      return (arrayOfInt1[1] >= arrayOfInt2[1]) && (this.n.getScrollY() < 0) && (this.X == 3);
    }
    return false;
  }
  
  private boolean t()
  {
    if (!v())
    {
      SLog.b(J, "showTipWindowForShot() canShowTipsWindows() == false");
      return false;
    }
    if (!w())
    {
      SLog.b(J, "showTipWindowForShot() isShotViewVisible() == false");
      return false;
    }
    Object localObject;
    if (this.v == null)
    {
      SLog.b(J, "showTipWindowForShot() mTipWindow == null, so create it!");
      localObject = CalloutPopupWindow.a(this.m).a(true).a(HardCodeUtil.a(2131904847)).a(16.0F).b(5).a(-1);
      ((CalloutPopupWindow.Builder)localObject).c(50);
      this.v = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a().b(5).a();
      this.v.a(82);
      this.v.a(new MsgTabStoryNodeListManager.14(this));
    }
    if (!this.v.isShowing())
    {
      this.v.b(this.u, AIOUtils.b(7.0F, this.Z.getResources()), AIOUtils.b(-5.0F, this.Z.getResources()));
      localObject = new Rect();
      this.u.getGlobalVisibleRect((Rect)localObject);
      SLog.a(J, "showTipWindowForShot() is not showing, so show it!, %s", ((Rect)localObject).toShortString());
      this.k.a.a(PlayModeUtils.b().getCurrentAccountUin(), "8.8.17".replace(".", ""));
      StoryReportor.a("msg_tab", "exp_tips", 0, 0, new String[] { "1", "", "", "" });
      this.w = false;
      ((StoryConfigManager)SuperManager.a(10)).d("key_msg_tab_show_shot_tips_new", Boolean.valueOf(false));
      return true;
    }
    return false;
  }
  
  private void u()
  {
    CalloutPopupWindow localCalloutPopupWindow = this.v;
    if (localCalloutPopupWindow != null)
    {
      if (localCalloutPopupWindow.isShowing())
      {
        this.v.dismiss();
        SLog.b(J, "dismissTipWindows() dismiss");
      }
      else
      {
        SLog.b(J, "dismissTipWindows() not showing, not need dismiss()");
      }
      this.v = null;
      return;
    }
    SLog.b(J, "dismissTipWindows() but mTipWindow is null");
  }
  
  private boolean v()
  {
    String str = J;
    View localView = this.u;
    boolean bool2 = false;
    SLog.b(str, "canShowTipsWindows: mShotView %s, mIsNeedShowTip %b, mRunning %b, mIsDrawerOpened %b, mIsConversationTabShow %b, isMsgTabVisible %b, SplashShowing %s", new Object[] { localView, Boolean.valueOf(this.w), Boolean.valueOf(this.r), Boolean.valueOf(this.A), Boolean.valueOf(this.z), Boolean.valueOf(x()), Boolean.valueOf(false) });
    boolean bool1 = bool2;
    if (this.u != null)
    {
      bool1 = bool2;
      if (this.w)
      {
        bool1 = bool2;
        if (this.r)
        {
          bool1 = bool2;
          if (!this.A)
          {
            bool1 = bool2;
            if (this.z)
            {
              bool1 = bool2;
              if (x()) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean w()
  {
    Object localObject = this.o;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((MsgTabStoryNodeView)localObject).c;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (this.i != null)
        {
          bool1 = bool2;
          if (((LinearLayoutManager)((RecyclerView)localObject).getLayoutManager()).findFirstVisibleItemPosition() == 0) {
            bool1 = true;
          }
        }
      }
    }
    SLog.a(J, "isShotViewVisible result = %b", Boolean.valueOf(bool1));
    return bool1;
  }
  
  private boolean x()
  {
    MsgTabStoryNodeView localMsgTabStoryNodeView = this.o;
    if (localMsgTabStoryNodeView != null)
    {
      int i1 = localMsgTabStoryNodeView.getTop();
      SLog.a(J, "isMsgTabVisible top=%d isShown=%b detached=%b", Integer.valueOf(i1), Boolean.valueOf(this.o.isShown()), Boolean.valueOf(this.o.g));
      if ((i1 >= 0) && (!this.o.g))
      {
        bool = true;
        break label68;
      }
    }
    boolean bool = false;
    label68:
    SLog.a(J, "isMsgTabVisible %b", Boolean.valueOf(bool));
    return bool;
  }
  
  private void y()
  {
    QBaseActivity localQBaseActivity = this.O.P();
    if (localQBaseActivity != null)
    {
      this.y = localQBaseActivity.getIntent().getBooleanExtra("show_story_msg_tab", false);
      if (this.y) {
        localQBaseActivity.getIntent().putExtra("show_story_msg_tab", false);
      }
    }
  }
  
  private void z()
  {
    y();
    if (this.y)
    {
      this.y = false;
      this.n.setSelection(0);
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.16(this));
    }
  }
  
  protected void a()
  {
    if (QQStoryContext.j() == null) {
      return;
    }
    ((MsgTabStoryManager)this.E.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().e();
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.5(this));
  }
  
  void a(float paramFloat)
  {
    View localView = this.Z;
    if (localView != null) {
      localView.setAlpha(paramFloat);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel())
    {
      String str = J;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDrawerFrame);
      localStringBuilder.append(" initLater ");
      localStringBuilder.append(this.n.mEnableStory);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.P = paramDrawerFrame;
    paramDrawerFrame = this.P;
    if (paramDrawerFrame != null) {
      paramDrawerFrame.setStoryTouchEventInterceptor(this);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.F.d();
    this.k.a(paramQQAppInterface);
    this.E.removeObserver(this.D);
    this.E.removeObserver(this.ad);
    Object localObject = this.o;
    if ((localObject != null) && (((MsgTabStoryNodeView)localObject).c != null))
    {
      localObject = this.o.c;
      ((RecyclerView)localObject).setScrollX(0);
      ((LinearLayoutManager)((RecyclerView)localObject).getLayoutManager()).scrollToPosition(0);
      SLog.b(J, "onAccountChanged set Scroll to 0!");
    }
    if (this.r)
    {
      paramQQAppInterface.addObserver(this.D);
      paramQQAppInterface.addObserver(this.ad);
      localObject = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acc_info");
      localStringBuilder.append(this.E.getAccount());
      B = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("isFriendlistok", false);
    }
    this.E = paramQQAppInterface;
  }
  
  public void b()
  {
    SLog.c(J, "MsgTab launch()");
    this.p = new MsgTabStoryNodeListManager.MsgTabShowCounter();
    AssertUtils.checkNotNull(this.o);
    Object localObject1 = this.o;
    if (localObject1 != null)
    {
      localObject2 = this.N;
      if (localObject2 != null) {
        if (((Integer)((IPullRefreshHeaderControl)localObject2).b(8, localObject1)).intValue() < 0)
        {
          this.N.a(9, this.o);
          b(false);
          a(false);
          this.n.setMaxOverScrollTopDistance(70);
          this.n.setQQStoryListViewListener(this);
          localObject1 = this.n;
          ((ARMapHongBaoListView)localObject1).mEnableStory = true;
          ((ARMapHongBaoListView)localObject1).mForStory = false;
          this.X = 1;
          localObject1 = this.P;
          if (localObject1 != null) {
            ((DrawerFrame)localObject1).setStoryTouchEventInterceptor(this);
          }
          this.k.b();
          this.n.getAdapter().registerDataSetObserver(this.t);
          localObject1 = (StoryConfigManager)SuperManager.a(10);
          this.x = ((Boolean)((StoryConfigManager)localObject1).c("first_show_node", Boolean.valueOf(true))).booleanValue();
          this.o.addOnLayoutChangeListener(new MsgTabStoryNodeListManager.8(this, (StoryConfigManager)localObject1));
        }
        else if (QLog.isColorLevel())
        {
          localObject1 = J;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mChatTopRefresh already added msgNodeView ");
          ((StringBuilder)localObject2).append(this.o);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    this.E.addObserver(this.D);
    this.E.addObserver(this.ad);
    this.E.addObserver(this.ae);
    localObject1 = this.E.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("acc_info");
    ((StringBuilder)localObject2).append(this.E.getAccount());
    B = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getBoolean("isFriendlistok", false);
    a();
    this.r = true;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2003;
    ((Message)localObject1).getData().putBoolean("isStoryShow", true);
    ((Message)localObject1).getData().putFloat("nodeOffset", this.S);
    BannerManager.a().b(PushBannerProcessor.a, (Message)localObject1);
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2002;
    ((Message)localObject1).getData().putBoolean("visible", false);
    BannerManager.a().b(PushBannerProcessor.a, (Message)localObject1);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = J;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",mode:");
      localStringBuilder.append(this.X);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.q = paramInt;
  }
  
  public void b(View paramView, int paramInt)
  {
    int i1 = this.i.getItemViewType(paramInt);
    String[] arrayOfString = (String[])K.get(Integer.valueOf(i1));
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.i.b(paramInt);
    if (localMsgTabNodeInfo == null) {
      return;
    }
    paramView = this.j;
    if ((paramView != null) && (paramView.isShowing())) {
      this.j.dismiss();
    }
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.j = ActionSheet.create(this.m);
      int i2 = arrayOfString.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (!d.equals(str))
        {
          paramView = str;
          if (!e.equals(str)) {}
        }
        else
        {
          QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(localMsgTabNodeInfo.d);
          paramView = str;
          if (localQQUserUIItem != null) {
            if (localQQUserUIItem.isSubscribe()) {
              paramView = e;
            } else {
              paramView = d;
            }
          }
        }
        this.j.addButton(new ActionMenuItem(paramView, paramInt, 0), 5);
        i1 += 1;
      }
      this.j.addCancelButton(2131887648);
      this.j.setOnButtonClickListener(this);
      this.j.setOnDismissListener(new MsgTabStoryNodeListManager.10(this, localMsgTabNodeInfo));
      this.j.show();
      if (localMsgTabNodeInfo != null)
      {
        paramView = new StringBuilder();
        paramView.append(localMsgTabNodeInfo.b);
        paramView.append("");
        StoryReportor.a("msg_tab", "press_story", 0, 0, new String[] { paramView.toString(), "", "", localMsgTabNodeInfo.d });
      }
    }
  }
  
  public void c()
  {
    SLog.c(J, "MsgTab shutdown()");
    if (!this.r) {
      return;
    }
    try
    {
      this.N.a(10, this.o);
      b(true);
      this.n.setMaxOverScrollTopDistance(30);
      this.n.setQQStoryListViewListener(null);
      this.n.scrollTo(0, 0);
      this.n.mEnableStory = false;
      this.n.mForStory = false;
      this.X = 1;
      if (this.P != null) {
        this.P.setStoryTouchEventInterceptor(null);
      }
      this.k.c();
      this.n.getAdapter().unregisterDataSetObserver(this.t);
      u();
      this.E.removeObserver(this.D);
      this.E.removeObserver(this.ad);
      this.E.removeObserver(this.ae);
      Message localMessage = Message.obtain();
      localMessage.what = 2003;
      localMessage.getData().putBoolean("isStoryShow", false);
      localMessage.getData().putFloat("nodeOffset", this.S);
      BannerManager.a().b(PushBannerProcessor.a, localMessage);
      localMessage = Message.obtain();
      localMessage.what = 2002;
      localMessage.getData().putBoolean("visible", true);
      BannerManager.a().b(PushBannerProcessor.a, localMessage);
    }
    catch (NullPointerException localNullPointerException)
    {
      CaughtExceptionReport.a(StoryDebugUtils.StoryExceptionCallback.b("QQStoryMsgTabShutdown, Null", localNullPointerException), "QQStoryMsgTabShutdown NullPointerException");
    }
    this.r = false;
  }
  
  public void d()
  {
    if (this.k != null)
    {
      SLog.b(J, "updateAllFriendNodeItems()");
      this.k.a(6);
    }
  }
  
  public void e()
  {
    this.A = true;
    if (QLog.isColorLevel()) {
      QLog.d(J, 2, "onDrawerStartMoving");
    }
    u();
  }
  
  public void f()
  {
    this.A = true;
    if (QLog.isColorLevel()) {
      QLog.d(J, 2, "onDrawerOpened");
    }
    u();
  }
  
  public void g()
  {
    if ((this.n.mEnableStory) && (getMode() == 1))
    {
      SLog.b(J, "startBreath() show breathView");
      this.Q.c();
      StoryReportor.a("msg_tab", "exp_newpub", 0, 0, new String[0]);
      return;
    }
    SLog.a(J, "startBreath() not show enableStory=%b, mode=%d", Boolean.valueOf(this.n.mEnableStory), Integer.valueOf(getMode()));
  }
  
  public int getMode()
  {
    return this.X;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f1 = paramARMapHongBaoListView.getScrollY();
    int i1 = this.X;
    if (i1 == 1) {
      return 0;
    }
    if (i1 == 3) {}
    for (i1 = this.o.getHeight();; i1 = paramARMapHongBaoListView.getOverScrollHeight())
    {
      return -i1;
      if (i1 != 2) {
        break;
      }
    }
    return (int)f1;
  }
  
  public boolean h()
  {
    if ((this.n.mEnableStory) && (!this.n.mForStory) && (this.n.getListViewScrollY() == 0))
    {
      this.n.setScrollY(-this.o.getHeight());
      this.n.mForStory = true;
      this.X = 3;
      a(true);
      b(true);
      q();
      this.Q.f();
      this.aa.a();
      this.p.b();
      return true;
    }
    return false;
  }
  
  public void i()
  {
    if ((this.n.mEnableStory) && (this.n.mForStory))
    {
      this.n.setScrollY(0);
      this.n.mForStory = false;
      this.X = 1;
      a(false);
      b(false);
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    if (s()) {
      return this.o.a(paramView, paramMotionEvent);
    }
    paramMotionEvent = J;
    paramView = this.o;
    boolean bool2 = true;
    boolean bool1;
    if (paramView != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.n == null) {
      bool2 = false;
    }
    paramView = this.n;
    if (paramView == null) {
      paramView = "null";
    } else {
      paramView = Integer.valueOf(paramView.getScrollY());
    }
    SLog.a(paramMotionEvent, "interceptDrawer error. contentView:%s, listView:%s, scrollY:%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramView);
    return false;
  }
  
  public void j()
  {
    this.i.notifyDataSetChanged();
    this.o.b();
    this.F.c();
  }
  
  public void k()
  {
    this.A = false;
    if (QLog.isColorLevel()) {
      QLog.d(J, 2, "onDrawerClosed");
    }
  }
  
  public void l()
  {
    this.z = true;
    AbstractGifImage.resumeAll();
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.i;
    if ((localMsgTabStoryNodeAdapter != null) && (this.r)) {
      localMsgTabStoryNodeAdapter.notifyDataSetChanged();
    }
    if (QLog.isColorLevel()) {
      QLog.d(J, 2, "onResume");
    }
    z();
  }
  
  public void m()
  {
    this.z = false;
    if (QLog.isColorLevel()) {
      QLog.d(J, 2, "onPause");
    }
    u();
    AbstractGifImage.pauseAll();
    if (QLog.isColorLevel()) {
      QLog.d(J, 2, "onPause");
    }
  }
  
  public String n()
  {
    return String.valueOf(hashCode());
  }
  
  public void onClick(View paramView, int paramInt)
  {
    this.j.dismiss();
    Object localObject = this.j.getActionMenuItem(paramInt);
    if (localObject == null) {
      return;
    }
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.i.b(((ActionMenuItem)localObject).action);
    if (localMsgTabNodeInfo == null) {
      return;
    }
    paramView = this.m;
    localObject = ((ActionMenuItem)localObject).content;
    if (a.equals(localObject))
    {
      if ((6 != localMsgTabNodeInfo.b) && (7 != localMsgTabNodeInfo.b) && (9 != localMsgTabNodeInfo.b) && (5 != localMsgTabNodeInfo.b))
      {
        if (8 == localMsgTabNodeInfo.b) {
          QQStoryShareGroupProfileActivity.a(paramView, 2, localMsgTabNodeInfo.d, String.valueOf(localMsgTabNodeInfo.c), 17, 0);
        } else if (12 == localMsgTabNodeInfo.b) {
          a(paramView);
        }
      }
      else {
        QQStoryMemoriesActivity.a(paramView, 26, localMsgTabNodeInfo.d, false);
      }
      paramView = "1";
    }
    else if (b.equals(localObject))
    {
      localObject = new Intent(paramView, QQStoryFriendSettings.class);
      ((Intent)localObject).putExtra("from", -1);
      paramView.startActivity((Intent)localObject);
      paramView = "2";
    }
    else if (c.equals(localObject))
    {
      localObject = new Intent(paramView, QQStoryShieldActivity.class);
      ((Intent)localObject).putExtra("uin", String.valueOf(localMsgTabNodeInfo.c));
      ((Intent)localObject).putExtra("from", 3);
      paramView.startActivity((Intent)localObject);
      paramView = "3";
    }
    else if (g.equals(localObject))
    {
      this.k.b(localMsgTabNodeInfo);
      paramView = "7";
    }
    else if (d.equals(localObject))
    {
      this.k.a(localMsgTabNodeInfo, 0);
      paramView = "4";
    }
    else if (e.equals(localObject))
    {
      this.k.a(localMsgTabNodeInfo, 1);
      paramView = "5";
    }
    else
    {
      if ("debug info".equals(localObject)) {
        Toast.makeText(paramView, localMsgTabNodeInfo.toString(), 1).show();
      } else {
        h.equals(localObject);
      }
      paramView = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localMsgTabNodeInfo.b);
    ((StringBuilder)localObject).append("");
    StoryReportor.a("msg_tab", "clk_press", 0, 0, new String[] { ((StringBuilder)localObject).toString(), paramView, "", localMsgTabNodeInfo.d });
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if ((this.n.mEnableStory) && (this.o != null))
    {
      if (paramInt1 == 2) {
        a(paramInt2, false);
      }
      if (paramInt2 <= -this.o.getHeight())
      {
        a(true);
        this.aa.a();
        return;
      }
      StringBuilder localStringBuilder;
      if ((!this.G) && (paramInt2 >= 0))
      {
        if (QLog.isDevelopLevel())
        {
          localObject = J;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("fight...onFlingScrollHeader1..scrollY = ");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",flag = ");
          localStringBuilder.append(this.G);
          QLog.d((String)localObject, 4, localStringBuilder.toString());
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 2003;
        ((Message)localObject).getData().putBoolean("isStoryShow", false);
        ((Message)localObject).getData().putFloat("nodeOffset", this.S);
        BannerManager.a().b(PushBannerProcessor.a, (Message)localObject);
        localObject = Message.obtain();
        ((Message)localObject).what = 2002;
        ((Message)localObject).getData().putBoolean("visible", true);
        BannerManager.a().b(PushBannerProcessor.a, (Message)localObject);
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = J;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fight...onFlingScrollHeader2..scrollY = ");
        localStringBuilder.append(paramInt2);
        QLog.d((String)localObject, 4, localStringBuilder.toString());
      }
      Object localObject = Message.obtain();
      ((Message)localObject).what = 2001;
      ((Message)localObject).getData().putFloat("height", paramInt2);
      BannerManager.a().b(PushBannerProcessor.a, (Message)localObject);
    }
  }
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.U == 0.0F) {
      this.U = (-this.o.getHeight());
    }
    float f1 = paramARMapHongBaoListView.getScrollY();
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 == 3) {}
        }
        else
        {
          if ((!this.G) && (this.X == 1))
          {
            this.G = true;
            a(false);
            this.aa.a();
            paramARMapHongBaoListView = Message.obtain();
            paramARMapHongBaoListView.what = 2003;
            paramARMapHongBaoListView.getData().putBoolean("isStoryShow", false);
            paramARMapHongBaoListView.getData().putFloat("nodeOffset", this.S);
            BannerManager.a().b(PushBannerProcessor.a, paramARMapHongBaoListView);
          }
          if ((f1 <= 0.0F) && (this.X == 1))
          {
            a(f1, true);
            return;
          }
          if (f1 >= 0.0F) {
            return;
          }
          if (QLog.isDevelopLevel())
          {
            paramARMapHongBaoListView = J;
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("fight...onTouchMoving.onMove..scrollY = ");
            paramMotionEvent.append(f1);
            QLog.d(paramARMapHongBaoListView, 4, paramMotionEvent.toString());
          }
          paramARMapHongBaoListView = Message.obtain();
          paramARMapHongBaoListView.what = 2001;
          paramARMapHongBaoListView.getData().putFloat("height", f1);
          BannerManager.a().b(PushBannerProcessor.a, paramARMapHongBaoListView);
          return;
        }
      }
      this.G = false;
      this.Y = this.X;
      if (f1 >= 0.0F)
      {
        if (paramARMapHongBaoListView.mForStory) {
          r();
        }
        this.X = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
      else if (paramARMapHongBaoListView.mForStory)
      {
        if (f1 <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (String)this.N.b(11, null);
          if ((paramMotionEvent != null) && (paramMotionEvent.contains(HardCodeUtil.a(2131904837))))
          {
            this.X = 3;
          }
          else
          {
            SLog.b(J, "story node start refresh onTouchMoving");
            this.X = 2;
          }
          paramARMapHongBaoListView.mForStory = true;
        }
        else if (f1 <= -this.o.getHeight())
        {
          this.X = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
        else
        {
          this.X = 1;
          paramARMapHongBaoListView.mForStory = false;
          r();
        }
      }
      else if (f1 <= -this.o.getHeight())
      {
        if (this.X != 2)
        {
          this.X = 3;
          paramARMapHongBaoListView.mForStory = true;
          p();
        }
      }
      else if (f1 <= this.R)
      {
        if (this.X == 2)
        {
          a(false);
        }
        else
        {
          this.X = 3;
          paramARMapHongBaoListView.mForStory = true;
          p();
        }
      }
      else
      {
        this.X = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
      b(paramARMapHongBaoListView.mForStory);
      if (QLog.isDevelopLevel())
      {
        paramARMapHongBaoListView = J;
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("fight...onTouchMoving.onUp..scrollY = ");
        paramMotionEvent.append(f1);
        QLog.d(paramARMapHongBaoListView, 4, paramMotionEvent.toString());
      }
      if (f1 >= 0.0F)
      {
        paramARMapHongBaoListView = Message.obtain();
        paramARMapHongBaoListView.what = 2003;
        paramARMapHongBaoListView.getData().putBoolean("isStoryShow", false);
        paramARMapHongBaoListView.getData().putFloat("nodeOffset", this.S);
        BannerManager.a().b(PushBannerProcessor.a, paramARMapHongBaoListView);
      }
    }
    else if (this.X == 1)
    {
      this.G = true;
      a(false);
      this.aa.a();
      paramARMapHongBaoListView = Message.obtain();
      paramARMapHongBaoListView.what = 2003;
      paramARMapHongBaoListView.getData().putBoolean("isStoryShow", false);
      paramARMapHongBaoListView.getData().putFloat("nodeOffset", this.S);
      BannerManager.a().b(PushBannerProcessor.a, paramARMapHongBaoListView);
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      String str = J;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewCompleteAfterRefresh, mode:");
      localStringBuilder.append(this.X);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i1 = this.X;
    if (i1 == 2) {
      if (paramARMapHongBaoListView.mForStory) {
        this.X = 3;
      }
    }
    for (i1 = this.o.getHeight();; i1 = this.o.getHeight())
    {
      return -i1;
      this.X = 1;
      return 0;
      if (i1 != 3) {
        break;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager
 * JD-Core Version:    0.7.0.1
 */