package com.tencent.mobileqq.activity.contact.troop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.stranger.data.Stranger;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

public class TroopActivity
  extends BaseForwardSelectionActivity
  implements Handler.Callback, Observer
{
  protected static final int[] E = { 2131917673, 2131886302, 2131917674, 2131888224 };
  protected static final int[] F = { 2130843527, 2130843533, 2130843528, 2130839725 };
  protected BaseTroopView A;
  boolean B;
  StrangerObserver C = new TroopActivity.6(this);
  protected PopupMenuDialog D;
  protected View.OnClickListener G = new TroopActivity.8(this);
  public int e = 0;
  public int f = 0;
  public int g = 2;
  public boolean h = false;
  public int i;
  protected BaseTroopView.ITroopContext j;
  protected TabBarView k;
  protected FrameLayout l;
  ImageView m;
  TextView n;
  protected MqqWeakReferenceHandler o;
  ArrayList<BaseTroopView> p = new ArrayList();
  protected List<Stranger> q = new ArrayList();
  protected boolean r = false;
  protected boolean s = false;
  protected String t = "DEFAULT";
  protected HashMap<String, Boolean> u;
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack v;
  boolean w;
  boolean x;
  protected boolean y = false;
  protected TabBarView.OnTabChangeListener z = new TroopActivity.5(this);
  
  private void a(int paramInt, String paramString)
  {
    ITroopCreateService localITroopCreateService = (ITroopCreateService)this.app.getRuntimeService(ITroopCreateService.class, "");
    if (localITroopCreateService != null) {
      localITroopCreateService.startCreateTroopSession(this, paramInt, paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.y) {
      return;
    }
    this.y = true;
    Object localObject;
    if (this.f == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("noti_and_rec_last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    ((SharedPreferences)localObject).edit().putInt("last_tab_mode", paramInt).commit();
  }
  
  private void c(int paramInt)
  {
    if (AppSetting.e)
    {
      int i1 = this.k.getChildCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        RedDotTextView localRedDotTextView = this.k.b(paramInt);
        StringBuilder localStringBuilder = new StringBuilder(24);
        localStringBuilder.append(localRedDotTextView.getText());
        localRedDotTextView.setContentDescription(localStringBuilder);
        paramInt += 1;
      }
    }
  }
  
  private BaseTroopView d(int paramInt)
  {
    if (paramInt >= 4) {
      return null;
    }
    Object localObject = (BaseTroopView)this.p.get(paramInt);
    if (localObject != null) {
      return localObject;
    }
    if (this.f != 2) {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          localObject = new TroopView(this, this.r, this.v);
        } else {
          localObject = new DiscussionView(this);
        }
      }
      else {
        localObject = new TroopView(this, this.r, this.v);
      }
    }
    this.p.set(paramInt, localObject);
    ((BaseTroopView)localObject).a(null, this.j);
    return localObject;
  }
  
  private void d()
  {
    this.j = new TroopActivity.2(this);
  }
  
  @TargetApi(14)
  private void e()
  {
    this.x = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = findViewById(2131445137);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((View)localObject1).setFitsSystemWindows(true);
      ((View)localObject1).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    TextView localTextView = (TextView)findViewById(2131436180);
    localObject1 = getIntent();
    int i1;
    Object localObject3;
    if (((Intent)localObject1).getIntExtra("forward_type", 2147483647) == 23)
    {
      localObject1 = HardCodeUtil.a(2131912422);
      localTextView.setMaxWidth(AIOUtils.b(120.0F, getResources()));
    }
    else
    {
      localObject2 = ((Intent)localObject1).getExtras().getString("leftViewText");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getString(2131887625);
      }
      if (this.x)
      {
        this.app.getMessageFacade().addObserver(this);
        i1 = this.app.getMessageFacade().w();
        localTextView.setVisibility(8);
        localObject3 = (TextView)findViewById(2131448219);
        localObject2 = (ImageView)findViewById(2131436666);
        ((TextView)localObject3).setVisibility(0);
        ((ImageView)localObject2).setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i1);
        ((TextView)localObject3).setText(localStringBuilder.toString());
        if (i1 <= 0) {
          ((TextView)localObject3).setVisibility(4);
        }
        a((View)localObject3, 0, 0, 0, AIOUtils.b(30.5F, getResources()));
        ((TextView)localObject3).setOnClickListener(this.G);
        ((ImageView)localObject2).setOnClickListener(this.G);
        if (AppSetting.e)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131912426));
          localStringBuilder.append(i1);
          localStringBuilder.append(HardCodeUtil.a(2131912420));
          ((TextView)localObject3).setContentDescription(localStringBuilder.toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912425));
          ((StringBuilder)localObject3).append(i1);
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912424));
          ((ImageView)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
        }
        findViewById(2131445043).setBackgroundResource(2130852229);
        ((TextView)findViewById(2131436227)).setTextColor(-1);
        this.w = true;
      }
    }
    localTextView.setText("");
    localTextView.setOnClickListener(this.G);
    this.n = ((TextView)findViewById(2131436211));
    this.m = ((ImageView)findViewById(2131436194));
    this.k = ((TabBarView)findViewById(2131444764));
    if (this.f != 2)
    {
      if ((!this.c) && (!this.b))
      {
        this.m.setBackgroundResource(2130853306);
        this.m.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localObject2 = this.m.getLayoutParams();
        localObject3 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
        ((ViewGroup.LayoutParams)localObject2).width = (((DisplayMetrics)localObject3).densityDpi * 36 / 160);
        ((ViewGroup.LayoutParams)localObject2).height = -2;
        this.m.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i1 = ((DisplayMetrics)localObject3).densityDpi * 100 / 160;
        this.m.setMaxWidth(i1);
        this.m.setVisibility(0);
        this.m.setOnClickListener(this.G);
      }
      else
      {
        this.m.setVisibility(8);
      }
    }
    else if ((!this.c) && (!this.b))
    {
      this.n.setVisibility(0);
      this.m.setVisibility(8);
      this.n.setText(2131897409);
    }
    else
    {
      this.m.setVisibility(8);
    }
    Object localObject2 = (TextView)findViewById(2131436227);
    if (getIntent().getBooleanExtra("onlyOneSegement", false))
    {
      findViewById(2131445033).setVisibility(8);
      if (this.i == 3)
      {
        ((TextView)localObject2).setText(2131888046);
      }
      else
      {
        i1 = this.e;
        if (i1 == 0) {
          ((TextView)localObject2).setText(2131888045);
        } else if (1 == i1) {
          ((TextView)localObject2).setText(2131888044);
        }
      }
    }
    if (this.f != 2)
    {
      this.m.setImageResource(2130841074);
      this.k.a(0, getString(2131888045));
      findViewById(2131445033).setVisibility(8);
    }
    else
    {
      this.m.setImageResource(2130841087);
      if (this.w) {
        this.m.setImageResource(2130844816);
      }
      if (this.g == 2) {
        ((TextView)localObject2).setText(2131888047);
      } else {
        ((TextView)localObject2).setText(HardCodeUtil.a(2131912423));
      }
      this.k.a(0, getString(2131888049));
      this.k.setVisibility(8);
    }
    if (this.r)
    {
      this.m.setVisibility(8);
      ((TextView)localObject2).setText(2131893978);
    }
    this.k.setOnTabChangeListener(this.z);
    this.l = ((FrameLayout)findViewById(2131435800));
    h();
    g();
    if (AppSetting.e)
    {
      if (this.c)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((TextView)localObject2).getText());
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912419));
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912421));
        localTextView.setContentDescription(((StringBuilder)localObject3).toString());
        localTextView.postDelayed(new TroopActivity.4(this, localTextView), 1000L);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131912417));
        localTextView.setContentDescription(((StringBuilder)localObject2).toString());
      }
      if (this.m.getVisibility() == 0) {
        this.m.setContentDescription(HardCodeUtil.a(2131912418));
      }
    }
    localObject1 = (IStrangerService)this.app.getRuntimeService(IStrangerService.class, "all");
    if (localObject1 != null)
    {
      ((IStrangerService)localObject1).getLocalList();
      ((IStrangerService)localObject1).getRemoteList(false);
    }
  }
  
  private int f()
  {
    Object localObject;
    if (this.f == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("noti_and_rec_last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_tab_mode_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    }
    return ((SharedPreferences)localObject).getInt("last_tab_mode", 0);
  }
  
  private void g()
  {
    if (this.f != 2)
    {
      i1 = this.e;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          this.k.setSelectedTab(0, true);
          return;
        }
        this.k.setSelectedTab(1, true);
        return;
      }
      this.k.setSelectedTab(0, true);
      return;
    }
    int i1 = this.e;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        this.k.setSelectedTab(1, true);
        return;
      }
      this.k.setSelectedTab(1, true);
      return;
    }
    this.k.setSelectedTab(0, true);
  }
  
  private void h()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < E.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = i1;
      localMenuItem.title = getString(E[i1]);
      localMenuItem.contentDescription = localMenuItem.title;
      localMenuItem.iconId = F[i1];
      localArrayList.add(localMenuItem);
      i1 += 1;
    }
    this.D = PopupMenuDialog.build(this, localArrayList, new TroopActivity.7(this));
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_title", getString(2131888224));
    localIntent.putExtra("param_done_button_wording", getString(2131916211));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131916212));
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 99);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, localIntent, 1300);
    ReportController.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  void a()
  {
    this.D.showAsDropDown(this.j.e(), this.j.e().getWidth() - getResources().getDimensionPixelSize(2131299624) - getResources().getDimensionPixelSize(2131299620), getResources().getDimensionPixelSize(2131299621));
  }
  
  void a(int paramInt)
  {
    BaseTroopView localBaseTroopView1 = d(paramInt);
    if (localBaseTroopView1 == null) {
      return;
    }
    BaseTroopView localBaseTroopView2 = this.A;
    if (localBaseTroopView2 != localBaseTroopView1)
    {
      if (localBaseTroopView2 != null)
      {
        if (isResume()) {
          this.A.e();
        }
        this.A.f();
      }
      this.A = localBaseTroopView1;
      localBaseTroopView1 = this.A;
      if (localBaseTroopView1 != null)
      {
        localBaseTroopView1.c();
        if (isResume()) {
          this.A.d();
        }
        this.l.removeAllViews();
        this.l.addView(this.A);
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new TroopActivity.3(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void b()
  {
    if (c()) {
      this.D.dismiss();
    }
  }
  
  public boolean c()
  {
    PopupMenuDialog localPopupMenuDialog = this.D;
    return (localPopupMenuDialog != null) && (localPopupMenuDialog.isShowing());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    BaseTroopView localBaseTroopView = this.A;
    if (localBaseTroopView != null) {
      localBaseTroopView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131625915);
    super.getWindow().setBackgroundDrawable(null);
    this.o = new MqqWeakReferenceHandler(this);
    this.p.add(null);
    this.p.add(null);
    this.p.add(null);
    this.p.add(null);
    this.i = getIntent().getIntExtra("key_from", 0);
    this.r = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    if (this.r)
    {
      this.u = new HashMap();
      this.v = new TroopActivity.1(this);
    }
    this.s = getIntent().getBooleanExtra("fromH5", false);
    this.t = getIntent().getStringExtra("troopType");
    this.f = getIntent().getIntExtra("key_tab_mode", 0);
    this.e = getIntent().getIntExtra("_key_mode", f());
    this.g = getIntent().getIntExtra("show_mode", 2);
    this.b = getIntent().getBooleanExtra("is_select_troop", false);
    if (this.e == 4) {
      this.e = f();
    }
    if (this.f == 2)
    {
      if (GroupSystemMsgController.a().b(this.app) > 0) {
        this.e = 1;
      } else if (RecommendTroopUtils.b(this.app) > 0) {
        this.e = 0;
      }
      int i1 = this.e;
      if (i1 == 0) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
      } else if (i1 == 1) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
    this.f = getIntent().getIntExtra("key_tab_mode", 0);
    d();
    e();
    this.app.addObserver(this.C);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.getMessageFacade().deleteObserver(this);
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.g();
      }
    }
    if (!this.c) {
      b(this.e);
    }
    super.doOnDestroy();
    this.a = null;
    this.app.removeObserver(this.C);
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.u != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isDataChanged", this.u.isEmpty() ^ true);
      setResult(-1, localIntent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    Object localObject = this.A;
    if (localObject != null) {
      ((BaseTroopView)localObject).e();
    }
    localObject = this.D;
    if (localObject != null) {
      ((PopupMenuDialog)localObject).onPause();
    }
    this.B = false;
    if (!this.c) {
      b(this.e);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    BaseTroopView localBaseTroopView = this.A;
    if (localBaseTroopView != null) {
      localBaseTroopView.d();
    }
    this.B = true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    BaseTroopView localBaseTroopView = this.A;
    if (localBaseTroopView != null) {
      localBaseTroopView.c();
    }
    if (this.s)
    {
      a(4, this.t);
      this.s = false;
      this.t = "DEFAULT";
    }
  }
  
  protected void doOnStop()
  {
    BaseTroopView localBaseTroopView = this.A;
    if (localBaseTroopView != null) {
      localBaseTroopView.f();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772005, 2130772006);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234)
    {
      runOnUiThread(new TroopActivity.9(this));
      return true;
    }
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.a(paramMessage);
      }
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.e = 1;
      g();
      if (paramIntent != null) {
        TroopUtils.a(this, paramIntent.getStringExtra("roomId"), true);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.x))
      {
        paramObject = (TextView)findViewById(2131448219);
        ImageView localImageView = (ImageView)findViewById(2131436666);
        if ((paramObject != null) && (localImageView != null)) {
          ThreadManager.postImmediately(new TroopActivity.GetUnReadNumRunnable(this.app, new WeakReference(this), paramObject, localImageView), null, false);
        }
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */