package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class PublicAccountListActivity
  extends BaseActivity
  implements ThreadExcutor.IThreadListener, IndexView.OnIndexChangedListener
{
  List<PublicAccountListActivity.InnerPAInfo> A = new ArrayList();
  PublicAccountListActivity.ListAdapter B = null;
  IPublicAccountDataManager C;
  Handler.Callback D = new PublicAccountListActivity.2(this);
  Runnable E = new PublicAccountListActivity.3(this);
  View.OnClickListener F = new PublicAccountListActivity.15(this);
  private RedTouch G;
  private MqqHandler H;
  private FriendListObserver I = new PublicAccountListActivity.12(this);
  private IPublicAccountObserver J;
  private boolean K = false;
  private GameCenterObserver L = new PublicAccountListActivity.13(this);
  private AdapterView.OnItemClickListener M = new PublicAccountListActivity.14(this);
  private Comparator<PublicAccountListActivity.InnerPAInfo> N = new PublicAccountListActivity.16(this);
  Drawable a;
  LinearLayout b;
  View c;
  TextView d;
  TextView e;
  TextView f;
  RelativeLayout g;
  View h;
  View i;
  TextView j;
  RelativeLayout k;
  XListView l;
  View m;
  EditText n;
  ImageButton o;
  PublicAccountListActivity.SearchResultComparator p = new PublicAccountListActivity.SearchResultComparator(this);
  List<PublicAccountListActivity.InnerPAInfo> q = new ArrayList();
  PublicAccountListActivity.SearchResultAdapter r;
  boolean s = false;
  Dialog t;
  PinnedDividerListView u;
  IndexView v;
  View w;
  View x;
  View y;
  LayoutInflater z;
  
  private PublicAccountListActivity.InnerPAInfo a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountListActivity.InnerPAInfo localInnerPAInfo = new PublicAccountListActivity.InnerPAInfo(paramPublicAccountInfo);
    localInnerPAInfo.a(ChnToSpell.b(paramPublicAccountInfo.name, 2));
    localInnerPAInfo.b(ChnToSpell.b(paramPublicAccountInfo.name, 1));
    return localInnerPAInfo;
  }
  
  private boolean a(PublicAccountListActivity.InnerPAInfo paramInnerPAInfo)
  {
    if ((paramInnerPAInfo != null) && (paramInnerPAInfo.a == null)) {}
    return false;
  }
  
  @TargetApi(14)
  private void d()
  {
    this.b = ((LinearLayout)super.findViewById(2131440830));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.b.setFitsSystemWindows(true);
    }
    this.c = super.findViewById(2131447484);
    this.d = ((TextView)super.findViewById(2131436227));
    this.e = ((TextView)super.findViewById(2131436180));
    this.f = ((TextView)super.findViewById(2131436211));
    this.f.setVisibility(0);
    this.w = super.findViewById(2131431368);
    this.u = ((PinnedDividerListView)super.findViewById(2131440827));
    this.v = ((IndexView)super.findViewById(2131435678));
    this.x = super.findViewById(2131440769);
    this.u.setOnItemClickListener(this.M);
  }
  
  private void e()
  {
    this.d.setText(2131892898);
    this.e.setText(2131892912);
    this.f.setText(2131886199);
    this.G = new RedTouch(this, this.f);
    this.G.c(53).c(5.0F).b(5.0F).a();
    this.e.setOnClickListener(this.F);
    this.f.setOnClickListener(this.F);
    if (AppSetting.e)
    {
      TextView localTextView = this.d;
      localTextView.setContentDescription(localTextView.getText());
      localTextView = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getText());
      localStringBuilder.append(HardCodeUtil.a(2131906536));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  private void f()
  {
    View localView = super.getLayoutInflater().inflate(2131625642, this.u, false);
    this.g = ((RelativeLayout)localView.findViewById(2131445383));
    ((EditText)this.g.findViewById(2131432634)).setOnTouchListener(new PublicAccountListActivity.5(this));
    ((Button)this.g.findViewById(2131429816)).setVisibility(8);
    this.u.addHeaderView(localView);
    this.B = new PublicAccountListActivity.ListAdapter(this);
    this.u.setAdapter(this.B);
    this.v.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.v.setOnIndexChangedListener(this);
    g();
  }
  
  private void g()
  {
    this.t = new ReportDialog(this);
    this.t.setCanceledOnTouchOutside(true);
    this.t.requestWindowFeature(1);
    this.t.getWindow().setSoftInputMode(36);
    this.t.setContentView(2131625649);
    Object localObject = this.t.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.t.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.l = ((XListView)this.t.findViewById(2131445380));
    this.l.setBackgroundDrawable(getResources().getDrawable(2130838958));
    this.l.setDividerHeight(0);
    this.m = this.z.inflate(2131625648, this.l, false);
    this.m.setOnClickListener(this.F);
    this.l.addFooterView(this.m);
    this.m.setTag("");
    this.q.clear();
    this.r = new PublicAccountListActivity.SearchResultAdapter(this, this.q);
    this.l.setAdapter(this.r);
    this.l.setOnItemClickListener(this.M);
    this.l.setOnTouchListener(new PublicAccountListActivity.9(this, (InputMethodManager)localObject));
    this.h = this.t.findViewById(2131445137);
    this.n = ((EditText)this.t.findViewById(2131432634));
    this.n.addTextChangedListener(new PublicAccountListActivity.SearchTextWatcher(this));
    this.o = ((ImageButton)this.t.findViewById(2131435215));
    this.o.setOnClickListener(new PublicAccountListActivity.10(this));
    this.k = ((RelativeLayout)this.t.findViewById(2131444724));
    this.k.setOnClickListener(new PublicAccountListActivity.11(this));
    this.i = this.t.findViewById(2131435048);
    this.j = ((TextView)this.t.findViewById(2131431757));
    ((Button)this.i.findViewById(2131445441)).setOnClickListener(this.F);
  }
  
  private void h()
  {
    if (this.y == null)
    {
      ViewStub localViewStub = (ViewStub)super.findViewById(2131432530);
      if (localViewStub == null) {
        return;
      }
      this.y = localViewStub.inflate();
      this.y.findViewById(2131445441).setOnClickListener(this.F);
    }
    this.y.setVisibility(0);
    this.w.setVisibility(8);
  }
  
  private void i()
  {
    View localView = this.y;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.w.setVisibility(0);
  }
  
  private void j()
  {
    if (this.G != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "", false);
      }
      this.G.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  protected void a()
  {
    Object localObject = (InputMethodManager)super.getSystemService("input_method");
    int i1 = this.c.getHeight();
    float f1 = -i1;
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.b.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localTranslateAnimation1.setAnimationListener(new PublicAccountListActivity.6(this, localTranslateAnimation1, localTranslateAnimation2, i1));
    this.t.setOnDismissListener(new PublicAccountListActivity.7(this, i1, localTranslateAnimation2, (InputMethodManager)localObject));
    this.n.setText("");
    this.n.setSelection(0);
    this.n.requestFocus();
    localObject = (Button)this.t.findViewById(2131429816);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new PublicAccountListActivity.8(this));
    this.q.clear();
    this.r.notifyDataSetChanged();
    this.s = true;
  }
  
  protected void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.q.clear();
    this.h.getLayoutParams().height = -1;
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      this.o.setVisibility(0);
      this.l.setVisibility(0);
      paramString = paramString.toLowerCase();
      Object localObject = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.A.iterator();
      while (localIterator.hasNext())
      {
        PublicAccountListActivity.InnerPAInfo localInnerPAInfo = (PublicAccountListActivity.InnerPAInfo)localIterator.next();
        String str = localInnerPAInfo.a.displayNumber;
        if ((str != null) && (str.equalsIgnoreCase(paramString)))
        {
          localArrayList3.add(localInnerPAInfo);
        }
        else
        {
          str = localInnerPAInfo.a.name.toLowerCase();
          if ((!str.equals(paramString)) && (!localInnerPAInfo.c.equals(paramString)) && (!localInnerPAInfo.b.equals(paramString)))
          {
            if ((str.indexOf(paramString) != 0) && (localInnerPAInfo.c.indexOf(paramString) != 0) && (localInnerPAInfo.b.indexOf(paramString) != 0))
            {
              if ((str.indexOf(paramString) > 0) || (localInnerPAInfo.c.indexOf(paramString) > 0) || (localInnerPAInfo.b.indexOf(paramString) > 0)) {
                localArrayList2.add(localInnerPAInfo);
              }
            }
            else {
              localArrayList1.add(localInnerPAInfo);
            }
          }
          else {
            ((List)localObject).add(localInnerPAInfo);
          }
        }
      }
      Collections.sort(localArrayList3, this.p);
      Collections.sort((List)localObject, this.p);
      Collections.sort(localArrayList1, this.p);
      Collections.sort(localArrayList2, this.p);
      this.q.addAll(localArrayList3);
      this.q.addAll((Collection)localObject);
      this.q.addAll(localArrayList1);
      this.q.addAll(localArrayList2);
      if (this.q.isEmpty())
      {
        this.j.setText(getString(2131892921, new Object[] { paramString }));
        this.i.setVisibility(0);
        this.l.setVisibility(8);
      }
      else
      {
        this.i.setVisibility(8);
        this.l.setVisibility(0);
      }
      this.m.setTag(paramString);
      this.r.notifyDataSetChanged();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshSearchResultList:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.q.size());
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.A.size());
        QLog.i("PublicAccountListActivity", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.o.setVisibility(8);
    this.l.setVisibility(8);
    this.i.setVisibility(8);
    this.r.notifyDataSetChanged();
  }
  
  protected void b()
  {
    Object localObject = (ViewGroup)super.findViewById(2131444897);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = super.findViewById(2131447484);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)super.findViewById(2131436180);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  void c()
  {
    this.A.clear();
    ArrayList localArrayList = this.C.getPublicAccountListNotIVR();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      i();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        this.A.add(a((PublicAccountInfo)localIterator.next()));
      }
      if (localArrayList.size() < 15) {
        this.v.setVisibility(8);
      } else {
        this.v.setVisibility(0);
      }
    }
    else
    {
      h();
    }
    this.B.b();
    if (this.s) {
      this.t.dismiss();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.C = ((IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all"));
    super.setContentView(2131625641);
    this.z = super.getLayoutInflater();
    d();
    e();
    f();
    if (this.C.isCached()) {
      c();
    } else {
      ThreadManager.post(this.E, 5, this, true);
    }
    b();
    this.J = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.J.setOnCallback(new PublicAccountListActivity.1(this));
    super.addObserver(this.J.getBusinessObserver());
    super.addObserver(this.I);
    this.app.registObserver(this.L);
    this.H = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.D);
    this.app.setHandler(getClass(), this.H);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.removeObserver(this.J.getBusinessObserver());
    super.removeObserver(this.I);
    Object localObject = this.B;
    if (localObject != null) {
      ((PublicAccountListActivity.ListAdapter)localObject).d();
    }
    localObject = this.r;
    if (localObject != null) {
      ((PublicAccountListActivity.SearchResultAdapter)localObject).c();
    }
    super.doOnDestroy();
    this.app.unRegistObserver(this.L);
    this.app.removeHandler(getClass());
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.K = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.K = true;
    try
    {
      getWindow().setSoftInputMode(48);
      label18:
      View localView = this.c;
      if (localView != null)
      {
        localView.destroyDrawingCache();
        this.c.requestLayout();
        this.c.invalidate();
      }
      j();
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  public void onAdded() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.u.setSelection(0);
      return;
    }
    int i1 = this.B.f_(paramString);
    if (i1 != -1)
    {
      paramString = this.u;
      paramString.setSelection(i1 + paramString.getHeaderViewsCount());
    }
  }
  
  public void onPostRun()
  {
    runOnUiThread(new PublicAccountListActivity.4(this));
  }
  
  public void onPreRun() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      PAStartupTracker.a("pubAcc_follow_list_display", null, "");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity
 * JD-Core Version:    0.7.0.1
 */