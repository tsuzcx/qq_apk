package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupDynamicEntrancePicture;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopDynamicConfig;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.adapter.TroopMessageSettingSingleAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements GestureDetector.OnGestureListener, View.OnTouchListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  public static final String a = StoryApi.a("StoryGroupSvc.get_dynamic_entrance_info");
  protected TransProcessorHandler A = new TroopAssistantActivity.7(this);
  protected MessageObserver B = new TroopAssistantActivity.8(this);
  protected TroopCommonlyUsedObserver C = new TroopAssistantActivity.9(this);
  protected RoamSettingObserver D = new TroopAssistantActivity.10(this);
  protected FriendListObserver E = new TroopAssistantActivity.11(this);
  protected TroopMngObserver F = new TroopAssistantActivity.12(this);
  protected TroopOnlinePushObserver G = new TroopAssistantActivity.13(this);
  protected PopupMenuDialog H;
  MqqHandler I = new TroopAssistantActivity.18(this);
  ThreadExcutor.IThreadListener J = new TroopAssistantActivity.19(this);
  protected QQProgressNotifier K;
  Comparator<RecentBaseData> L = new TroopAssistantActivity.23(this);
  private float M;
  private boolean N = false;
  private AVObserver O = new TroopAssistantActivity.6(this);
  private boolean P = false;
  private boolean Q = true;
  private int R;
  XListView b;
  XListView c;
  boolean d;
  protected boolean e;
  boolean f = true;
  protected boolean g = false;
  protected String h;
  protected List<Long> i;
  protected IRoamSettingService j;
  protected RecentAdapter k;
  protected TroopMessageSettingSingleAdapter l;
  protected DragFrameLayout m;
  protected View n;
  protected View o;
  protected View p;
  protected View q;
  protected Button r;
  protected Button s;
  protected ImageView t;
  protected TextView u;
  protected boolean v;
  protected TroopUsingTimeReport w;
  GestureDetector x;
  protected long y = 0L;
  protected boolean z = true;
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.setMainTitle(localResources.getString(2131917048, new Object[] { paramString2 }));
    localActionSheet.addRadioButton(localResources.getString(2131895425), false);
    localActionSheet.addRadioButton(localResources.getString(2131895430), false);
    localActionSheet.addRadioButton(localResources.getString(2131895426), false);
    localActionSheet.addRadioButton(localResources.getString(2131895422), false);
    int i1 = this.app.getTroopMask(String.valueOf(paramString1));
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 == 4) {
            localActionSheet.setRadioButtonChecked(1);
          }
        }
        else {
          localActionSheet.setRadioButtonChecked(3);
        }
      }
      else {
        localActionSheet.setRadioButtonChecked(2);
      }
    }
    else {
      localActionSheet.setRadioButtonChecked(0);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new TroopAssistantActivity.22(this, i1, paramString1, localActionSheet));
    localActionSheet.show();
  }
  
  private void h()
  {
    QLog.e("TroopAssistantActivity", 2, "initContentView");
    if (TroopAssistantManager.a().j(this.app))
    {
      QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewSettingModal");
      j();
      ReportController.b(this.app, "dc00899", "Grp_msg", "", "helper-guide", "exp_guide", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewNormalModal");
    i();
  }
  
  private void i()
  {
    this.h = "normal";
    this.b = ((XListView)findViewById(2131448014));
    this.n = findViewById(2131447909);
    this.b.setVisibility(0);
    this.n.setVisibility(8);
    if (!this.N)
    {
      this.o = View.inflate(this, 2131629555, null);
      ViewCompat.setImportantForAccessibility(this.o, 2);
      this.q = this.o.findViewById(2131447906);
      this.p = this.o.findViewById(2131447905);
      this.t = ((ImageView)this.o.findViewById(2131444823));
      this.b.addHeaderView(this.o);
      View localView = View.inflate(this, 2131624518, null);
      this.b.addFooterView(localView);
      this.k = new RecentAdapter(this, this.app, this.b, this, 1);
      this.k.a(4);
      this.b.setAdapter(this.k);
      if (this.m == null)
      {
        this.m = DragFrameLayout.a(this);
        this.m.a(this, false);
      }
      this.k.a(this.m);
      this.N = true;
    }
    k();
  }
  
  private void j()
  {
    this.h = "batch_setting";
    this.b = ((XListView)findViewById(2131448014));
    this.n = findViewById(2131447909);
    this.b.setVisibility(8);
    this.n.setVisibility(0);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i1 = ((DisplayMetrics)localObject).heightPixels;
    int i2 = AIOUtils.b(154.0F, getBaseContext().getResources());
    int i3 = getTitleBarHeight();
    int i4 = ImmersiveUtils.getStatusBarHeight(getBaseContext());
    this.c = ((XListView)findViewById(2131447910));
    this.c.setMaxHeight(i1 - i2 - i3 - i4);
    this.o = this.n.findViewById(2131447904);
    this.p = this.o.findViewById(2131447905);
    this.q = this.n.findViewById(2131447906);
    this.t = ((ImageView)this.o.findViewById(2131444823));
    localObject = (TextView)this.q;
    ((TextView)localObject).setText(2131917387);
    ((TextView)localObject).setVisibility(0);
    this.r = ((Button)this.n.findViewById(2131447907));
    this.s = ((Button)this.n.findViewById(2131447903));
    this.r.setOnClickListener(new TroopAssistantActivity.2(this));
    this.s.setOnClickListener(new TroopAssistantActivity.3(this));
    this.l = new TroopMessageSettingSingleAdapter(this, this.app, null);
    this.c.setAdapter(this.l);
    TroopAssistantManager.a().a(this.app, new TroopAssistantActivity.TroopProtocolObserver(new WeakReference(this)));
    k();
  }
  
  private void k()
  {
    Object localObject = (TroopStoryManager)this.app.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
    if ((localObject != null) && (((TroopStoryManager)localObject).d != null) && (((TroopStoryManager)localObject).d.d))
    {
      this.p.setVisibility(0);
      this.p.setOnClickListener(new TroopAssistantActivity.4(this));
      localObject = this.t;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(8);
        localObject = new qqstory_group.ReqGetGroupDynamicEntrancePicture();
        ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
        ProtoUtils.a(this.app, new TroopAssistantActivity.5(this), ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).toByteArray(), a);
      }
      return;
    }
    this.p.setVisibility(8);
  }
  
  private void l()
  {
    i();
    this.rightViewImg.setVisibility(0);
    c();
  }
  
  private void m()
  {
    this.A.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPicTransFile)this.app.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass(), ForwardImageProcessor.class });
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).addHandle(this.A);
  }
  
  private void n()
  {
    QLog.e("TroopAssistantActivity", 2, "initTitleBar");
    setTitle(2131917401);
    Object localObject = this.rightViewImg;
    int i1;
    if (this.v)
    {
      ((TextView)findViewById(2131436227)).setTextColor(getResources().getColorStateList(2131167991));
      i1 = 2130844816;
    }
    else
    {
      i1 = 2130841087;
    }
    ((ImageView)localObject).setImageResource(i1);
    ((ImageView)localObject).setContentDescription(getString(2131917671));
    ((ImageView)localObject).setOnClickListener(new TroopAssistantActivity.14(this));
    this.u = ((TextView)findViewById(2131436218));
    b();
    if ("batch_setting".equals(this.h)) {
      ((ImageView)localObject).setVisibility(8);
    } else {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (RelativeLayout)findViewById(2131444897);
    if (this.v)
    {
      ((RelativeLayout)localObject).setBackgroundResource(2130852229);
      return;
    }
    ((RelativeLayout)localObject).setBackgroundResource(2130852228);
  }
  
  private void o()
  {
    this.g = TroopAssistantManager.a().c();
    int i1;
    if (this.g)
    {
      localObject = getString(2131917666);
      i1 = 2130843530;
    }
    else
    {
      localObject = getString(2131917667);
      i1 = 2130843531;
    }
    String str = getString(2131917672);
    ArrayList localArrayList = new ArrayList();
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 0;
    localMenuItem.title = ((String)localObject);
    localMenuItem.contentDescription = localMenuItem.title;
    localMenuItem.iconId = i1;
    localArrayList.add(localMenuItem);
    Object localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 1;
    ((PopupMenuDialog.MenuItem)localObject).title = str;
    ((PopupMenuDialog.MenuItem)localObject).contentDescription = ((PopupMenuDialog.MenuItem)localObject).title;
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130843528;
    localArrayList.add(localObject);
    this.H = PopupMenuDialog.build(this, localArrayList, new TroopAssistantActivity.15(this), new TroopAssistantActivity.16(this));
    localObject = super.getTitleBarView();
    this.H.showAsDropDown((View)localObject, ((View)localObject).getWidth() - getResources().getDimensionPixelSize(2131299624) - getResources().getDimensionPixelSize(2131299620), getResources().getDimensionPixelSize(2131299621));
    AccessibilityUtil.b(findViewById(2131447595), false);
  }
  
  private boolean p()
  {
    int i2 = this.b.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.b.getChildAt(i1);
      if (localView != null)
      {
        localView = localView.findViewById(2131449128);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.e = false;
          return this.e;
        }
      }
      i1 += 1;
    }
    this.e = true;
    return this.e;
  }
  
  public void a()
  {
    if (TroopAssistantManager.a().g(this.app) == true) {
      TroopAssistantManager.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.D);
    addObserver(this.E);
    addObserver(this.B);
    addObserver(this.G);
    addObserver(this.F);
    addObserver(this.C);
    this.app.setHandler(getClass(), this.I);
    this.app.getMessageFacade().addObserver(this);
    this.app.getAVNotifyCenter().addObserver(this.O);
    RecentAdapter localRecentAdapter = this.k;
    if (localRecentAdapter != null) {
      localRecentAdapter.a(this.app);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -1))
    {
      this.R = (paramInt | this.R & (paramInt ^ 0xFFFFFFFF));
      return;
    }
    this.R = paramInt;
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).v(paramRecentBaseData.getRecentUserUin());
    if (!TextUtils.isEmpty(str))
    {
      if (!((ITroopCommonlyUsedHandler)this.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(str, paramBoolean ^ true)) {
        return;
      }
      localObject = ((TroopManager)localObject).g(paramRecentBaseData.getRecentUserUin());
      if (localObject != null)
      {
        paramInt = ((TroopInfo)localObject).troopmask;
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            paramInt = 2;
            break label119;
          }
        }
        else
        {
          paramInt = 1;
          break label119;
        }
      }
      paramInt = 0;
      label119:
      localObject = new ReportTask(this.app).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
      str = paramRecentBaseData.getRecentUserUin();
      if (paramBoolean) {
        paramRecentBaseData = "0";
      } else {
        paramRecentBaseData = "1";
      }
      ((ReportTask)localObject).a(new String[] { str, String.valueOf(paramInt), paramRecentBaseData }).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAssistantActivity", 2, "TroopManage.getTroopCodeByTroopUin return null...");
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new TroopAssistantActivity.1(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  void a(String paramString)
  {
    TroopAssistantManager.a().b(paramString, this.app);
    c();
    RecentUtil.b(this.app, paramString, 1);
    this.app.getMessageFacade().a(paramString, 1);
    paramString = this.app.getHandler(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    TroopAssistantManager.a().a(this.app, paramString, paramInt);
    this.j.getMapRequest().put(paramString, Boolean.valueOf(true));
  }
  
  void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    if (paramInt == 1)
    {
      paramString1 = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString1);
      if ((paramString1 != null) && (paramString1.troopcode != null)) {
        localIntent.putExtra("troop_uin", paramString1.troopcode);
      }
    }
    else if (paramInt == 0)
    {
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("");
      paramString1 = localFriendsManager.m(localStringBuilder.toString());
      if (paramString1 != null)
      {
        localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
        if ((CrmUtils.a(paramString1.cSpecialFlag)) || (QidianManager.b(paramString1.cSpecialFlag)))
        {
          localIntent.setClass(this, ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
        }
      }
    }
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    this.w.c();
  }
  
  void b()
  {
    if ((this.leftView != null) && (this.mLeftBackText != null))
    {
      if (this.mLeftBackText == null) {
        return;
      }
      Object localObject1;
      if (this.v)
      {
        this.u.setVisibility(8);
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131901576));
        this.mLeftBackText.setVisibility(0);
        localObject1 = this.mLeftBackText;
        a((View)localObject1, 0, 0, 0, (int)(this.mDensity * 30.0F + 0.5F));
      }
      else
      {
        this.u.setVisibility(0);
        this.leftView.setVisibility(0);
        localObject1 = getResources().getColorStateList(2131167990);
        this.u.setTextColor((ColorStateList)localObject1);
        localObject2 = (GradientDrawable)this.u.getBackground();
        if (localObject2 != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            ((GradientDrawable)localObject2).setColor((ColorStateList)localObject1);
          } else {
            ((GradientDrawable)localObject2).setColor(((ColorStateList)localObject1).getDefaultColor());
          }
          ((GradientDrawable)localObject2).setAlpha(46);
        }
        if (!ThemeUtil.isNowThemeIsSimple(this.app, false, null))
        {
          localObject1 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(28.0F, getResources());
          this.u.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(5.0F, getResources());
          this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
        localObject1 = this.u;
      }
      Object localObject2 = this.app.getMessageFacade();
      if (localObject2 != null) {
        ThreadManager.post(new TroopAssistantActivity.17(this, (QQMessageFacade)localObject2, (TextView)localObject1), 8, null, true);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return (!g()) && ((this.R & paramInt) == paramInt);
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshTroopList:");
    localStringBuilder.append(new Exception("this is a log").getStackTrace());
    QLog.e("TroopAssistantActivity", 2, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsRefreshing:");
    localStringBuilder.append(this.P);
    QLog.e("TroopAssistantActivity", 2, localStringBuilder.toString());
    if (this.P) {
      return;
    }
    ThreadManager.excute(new TroopAssistantActivity.20(this), 32, this.J, true);
  }
  
  protected void d()
  {
    if (this.b != null)
    {
      RecentAdapter localRecentAdapter = this.k;
      if ((localRecentAdapter != null) && (this.q != null))
      {
        if (localRecentAdapter.d())
        {
          this.q.setVisibility(8);
          return;
        }
        if (this.q.getVisibility() != 0) {
          this.q.setVisibility(0);
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = EventCollector.getInstance();
    boolean bool = true;
    ((EventCollector)localObject).onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    localObject = this.x;
    if ((localObject == null) || (!((GestureDetector)localObject).onTouchEvent(paramMotionEvent))) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    QLog.e("TroopAssistantActivity", 2, "doOnCreate");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.M = (ViewConfiguration.get(this).getScaledTouchSlop() * 2);
    try
    {
      super.setContentView(2131629553);
      getWindow().setBackgroundDrawable(null);
      setStatusBarBlue();
      this.v = ThemeUtil.isDefaultOrDIYTheme(false);
      this.x = new GestureDetector(this);
      paramBundle = (LinearLayout)findViewById(2131448090);
      paramBundle.setOnTouchListener(this);
      paramBundle.setLongClickable(true);
      h();
      n();
      a();
      m();
      StoryReportor.a("grp_help", "exp", 0, 0, new String[] { "", "", "", "" });
      this.w = new TroopUsingTimeReport(this.app, null, "Grp_time", "helper", "visit_time");
      return true;
    }
    catch (Exception paramBundle)
    {
      QLog.e("TroopAssistantActivity", 1, "doOnCreateFailed", paramBundle);
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).c();
    }
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.A);
    this.app.getAVNotifyCenter().deleteObserver(this.O);
    removeObserver(this.D);
    removeObserver(this.E);
    removeObserver(this.G);
    removeObserver(this.F);
    removeObserver(this.B);
    removeObserver(this.C);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = this.m;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    localObject = this.k;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
    localObject = this.b;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    this.k = null;
    ((StoryManager)SuperManager.a(5)).c();
    ((UserManager)SuperManager.a(2)).e();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = this.m;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a();
    }
    if (this.app != null)
    {
      localObject = this.k;
      if (localObject != null)
      {
        localObject = ((RecentAdapter)localObject).getItem(0);
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          localObject = this.app.getMessageFacade().getLastMessage(((RecentBaseData)localObject).getRecentUserUin(), ((RecentBaseData)localObject).getRecentUserType());
          if (localObject != null)
          {
            TroopAssistantManager.a().a(this.app, ((Message)localObject).time);
            localObject = this.app.getHandler(Conversation.class);
            if (localObject != null) {
              ((MqqHandler)localObject).sendEmptyMessage(1009);
            }
          }
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    QLog.e("TroopAssistantActivity", 2, "doOnResume");
    super.doOnResume();
    c();
    this.w.b();
  }
  
  protected List<RecentBaseData> e()
  {
    QLog.e("TroopAssistantActivity", 2, "makeRecetBaseData");
    Object localObject1 = TroopAssistantManager.a().n(this.app);
    int i2 = 0;
    int i1;
    if (localObject1 == null) {
      i1 = 0;
    } else {
      i1 = ((List)localObject1).size();
    }
    ArrayList localArrayList = new ArrayList(i1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("makeRecetBaseData before, data.size:");
      ((StringBuilder)localObject2).append(i1);
      QLog.i("TroopAssistantActivity", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new HashSet();
    while (i2 < i1)
    {
      Object localObject3 = (TroopAssistantData)((List)localObject1).get(i2);
      if ((localObject3 != null) && (!((HashSet)localObject2).contains(((TroopAssistantData)localObject3).troopUin)))
      {
        ((HashSet)localObject2).add(((TroopAssistantData)localObject3).troopUin);
        localObject3 = new RecentTroopAssistantItem((TroopAssistantData)localObject3);
        ((RecentTroopAssistantItem)localObject3).a(this.app, BaseApplication.getContext());
        if (QLog.isColorLevel())
        {
          long l1 = System.currentTimeMillis();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(l1 - 0L);
          localStringBuilder.append(", ");
          localStringBuilder.append(((RecentTroopAssistantItem)localObject3).getRecentUserUin());
          localStringBuilder.append(",");
          localStringBuilder.append(localObject3.getClass().getName());
          localStringBuilder.append("]");
          QLog.i("Q.recent.cost", 2, localStringBuilder.toString());
          ((RecentTroopAssistantItem)localObject3).printDataItem();
        }
        localArrayList.add(localObject3);
      }
      i2 += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("makeRecetBaseData end, items.size:");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.i("TroopAssistantActivity", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public boolean f()
  {
    return this.R == 0;
  }
  
  public boolean g()
  {
    return this.R == -1;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (!this.d)
    {
      StatisticTroopAssist.e(this, this.app.getCurrentAccountUin());
    }
    else
    {
      p();
      if (this.e) {
        StatisticTroopAssist.c(this, this.app.getCurrentAccountUin());
      } else {
        StatisticTroopAssist.d(this, this.app.getCurrentAccountUin());
      }
    }
    return super.onBackEvent();
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
    }
    paramDragFrameLayout = this.m;
    if ((paramDragFrameLayout != null) && (paramDragFrameLayout.getMode() == -1)) {
      this.I.sendEmptyMessage(1);
    }
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    if (paramView == null) {
      return;
    }
    int i1 = paramView.getId();
    if (i1 == 2131447909)
    {
      this.f = false;
      paramView = this.k;
      if (paramView != null)
      {
        paramView.a(4);
        d();
        this.k.notifyDataSetChanged();
      }
      paramView = new Intent(this, TroopAssisSettingActivity.class);
      paramView.setFlags(67108864);
      startActivity(paramView);
      if (TroopAssistantManager.a().d()) {
        TroopAssistantManager.a().i(this.app);
      }
      ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "help_nav", "Clk_set", 0, 0, "", "", "", "");
      return;
    }
    if (i1 == 2131447908)
    {
      this.f = false;
      paramView = this.k;
      if (paramView != null)
      {
        paramView.a(4);
        d();
        this.k.notifyDataSetChanged();
        c();
      }
      TroopAssistantManager.a().i(this.app);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!f())
    {
      if (g()) {
        return false;
      }
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent2 == null) {
          return false;
        }
        paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
        paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
        if (b(1))
        {
          if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.5F))
          {
            a(-1);
            if (this.Q)
            {
              finish();
              return true;
            }
            this.Q = true;
            return false;
          }
        }
        else if ((b(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
        {
          a(-1);
          this.Q = false;
        }
      }
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    int i1 = paramRecentBaseData.getRecentUserType();
    if (i1 == 1)
    {
      if (Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[2])))
      {
        a(i1, paramRecentBaseData, false);
        return;
      }
      if (Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[3]))) {
        a(i1, paramRecentBaseData, true);
      }
    }
    else if ((paramRecentBaseData.getRecentUserType() == 1) && (Utils.a(paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[1]), paramString1)))
    {
      a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getTitleName());
    }
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.getUnreadNum() > 0) {
      this.d = true;
    }
    a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), paramString);
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData.getRecentUserUin());
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (g()) {
      return false;
    }
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f1 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
      if (f())
      {
        if (Math.abs(paramFloat2) > this.M)
        {
          if ((paramFloat1 < 0.0F) && (f1 < 0.5F))
          {
            a(1);
            return true;
          }
          if ((paramFloat1 > 0.0F) && (f1 < 0.5F))
          {
            a(2);
            return true;
          }
        }
      }
      else if (b(1))
      {
        if ((paramFloat1 > 0.0F) || (f1 >= 0.5F))
        {
          a(-1);
          return false;
        }
      }
      else if ((b(2)) && ((paramFloat1 < 0.0F) || (f1 >= 0.5F))) {
        a(-1);
      }
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a(-1);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.x;
    return (paramView != null) && (paramView.onTouchEvent(paramMotionEvent));
  }
  
  protected String setLastActivityName()
  {
    return "";
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new TroopAssistantActivity.21(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    this.I.removeMessages(1);
    this.I.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */