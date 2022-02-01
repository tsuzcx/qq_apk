package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.MultiLineLayout;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.OnTroopListClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.showexternal.api.ITroopShowExternalHandler;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.AppRuntime;

public class ShowExternalTroopListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ShowExternalTroopListAdapter.OnTroopListClickListener, OverScrollViewListener
{
  protected TextView a;
  protected RedDotTextView b;
  protected XListView c;
  protected ShowExternalTroopListAdapter d;
  protected RelativeLayout e;
  protected TextView f;
  protected TextView g;
  protected Button h;
  protected PullRefreshHeader i;
  protected View j;
  Activity k;
  protected boolean l = false;
  protected TroopManager m;
  String n = null;
  String o = null;
  protected int p = 0;
  protected boolean q = false;
  protected TroopShowExternalObserver r = new ShowExternalTroopListActivity.1(this);
  public View.OnClickListener s = new ShowExternalTroopListActivity.5(this);
  protected boolean t = false;
  protected Handler u = new ShowExternalTroopListActivity.6(this);
  
  private void b()
  {
    setContentViewNoTitle(2131626748);
    Object localObject1 = (LinearLayout)findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((LinearLayout)localObject1).setFitsSystemWindows(true);
    }
    setTitle(2131893930);
    this.a = ((TextView)findViewById(2131436180));
    Intent localIntent = getIntent();
    this.l = localIntent.getExtras().getBoolean("isHost");
    Object localObject2 = localIntent.getExtras().getString("leftViewText");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getString(2131887625);
    }
    this.a.setText((CharSequence)localObject1);
    this.a.setOnClickListener(this);
    this.b = ((RedDotTextView)findViewById(2131436211));
    this.b.setContentDescription(getString(2131893933));
    this.b.setText(2131893932);
    this.b.setOnClickListener(this);
    if (!this.l) {
      this.b.setVisibility(8);
    } else {
      this.b.setVisibility(0);
    }
    IphoneTitleBarActivity.setLayerType(this.b);
    this.e = ((RelativeLayout)findViewById(2131441549));
    localObject1 = LayoutInflater.from(this).inflate(2131626747, null);
    this.g = ((TextView)((View)localObject1).findViewById(2131448101));
    this.g.setText(getString(2131893981));
    this.f = ((TextView)findViewById(2131439350));
    this.h = ((Button)findViewById(2131445686));
    this.h.setOnClickListener(this);
    if (!this.l) {
      this.h.setVisibility(8);
    }
    this.c = ((XListView)findViewById(2131441432));
    this.c.setContentBackground(2130853344);
    this.j = LayoutInflater.from(this).inflate(2131626686, this.c, false);
    this.c.addHeaderView(this.j);
    if (this.l) {
      this.c.addHeaderView((View)localObject1);
    }
    this.n = localIntent.getExtras().getString("dest_uin_str");
    this.o = localIntent.getExtras().getString("from_troop_uin");
    this.d = new ShowExternalTroopListAdapter(getActivity(), this.app, this, this.c, this.l, this.n);
    this.c.setAdapter(this.d);
    this.d.notifyDataSetChanged();
    this.i = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131625671, this.c, false));
    this.c.setOverScrollHeader(this.i);
    this.c.setOverScrollListener(this);
    this.c.setContentBackground(2130838959);
    localObject2 = this.app;
    String str = this.n;
    if (this.l) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localIntent.getIntExtra("from", 0));
    ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_join", "", "person_data", "exp_grp", 0, 0, str, (String)localObject1, localStringBuilder.toString(), "");
  }
  
  private void c()
  {
    ImageView localImageView = (ImageView)this.j.findViewById(2131435503);
    Object localObject = ImageUtil.m();
    localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.n, 3, (Drawable)localObject, (Drawable)localObject));
    this.j.findViewById(2131431322).bringToFront();
    ThreadManager.post(new ShowExternalTroopListActivity.2(this), 8, null, true);
    localObject = (TextView)this.j.findViewById(2131436839);
    ThreadManager.post(new ShowExternalTroopListActivity.3(this, (TextView)this.j.findViewById(2131439295), (TextView)localObject), 8, null, true);
    localImageView.setOnClickListener(new ShowExternalTroopListActivity.4(this, localImageView));
  }
  
  private boolean d()
  {
    if (NetworkUtil.isNetworkAvailable(getActivity()))
    {
      ((ITroopShowExternalHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SHOW_EXTERNAL_HANDLER)).a(this.n, 0, 0);
      this.q = true;
      return true;
    }
    QQToast.makeText(this, 2130840055, getString(2131895389), 0).show(getResources().getDimensionPixelSize(2131299920));
    return false;
  }
  
  private long e()
  {
    return getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).getLong("rec_last_ext_show_troop_list_refresh_time", 0L);
  }
  
  private void f()
  {
    long l1 = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).edit().putLong("rec_last_ext_show_troop_list_refresh_time", l1).commit();
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i3 = getResources().getDisplayMetrics().widthPixels;
    int i5 = (int)(this.mDensity * 120.0F);
    int i2 = paramBitmap.getHeight();
    int i1 = paramBitmap.getWidth();
    int i6 = i1 * i5;
    int i7 = i2 * i3;
    int i4 = 0;
    if (i6 > i7)
    {
      i5 = i7 / i5;
      i3 = (i1 - i5) / 2;
      i1 = i5;
    }
    else
    {
      i5 = i6 / i3;
      i4 = (i2 - i5) / 2;
      i3 = 0;
      i2 = i5;
    }
    if ((i2 != 0) && (i1 != 0))
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, i3, i4, i1, i2);
      if (paramBitmap.isMutable()) {
        return paramBitmap;
      }
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, true);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localBitmap;
    }
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getMidBitmap error! height = ");
      paramBitmap.append(i2);
      paramBitmap.append(" ;width = ");
      paramBitmap.append(i1);
      QLog.d("IphoneTitleBarActivity", 2, paramBitmap.toString());
    }
    return null;
  }
  
  public void a()
  {
    if (this.q) {
      return;
    }
    this.g.setVisibility(8);
    this.e.setVisibility(0);
    this.c.setAdapter(null);
    if (this.l)
    {
      this.f.setCompoundDrawablesWithIntrinsicBounds(0, 2130844961, 0, 0);
      this.f.setText(2131893939);
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "exp_blank", 0, 0, "", "", "", "");
    }
    else
    {
      this.f.setCompoundDrawablesWithIntrinsicBounds(0, 2130844865, 0, 0);
      this.f.setText(2131893942);
      QQToast.makeText(this, 1, getString(2131893941), 0).show(getTitleBarHeight());
    }
    this.c.setEmptyView(this.e);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = TroopInfoUIUtil.a(paramString, 18);
    Activity localActivity = getActivity();
    int i1;
    if (this.l) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    TroopUtils.a(localActivity, localBundle, i1);
    if (this.l)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "1", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "0", "", "");
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    MultiLineLayout localMultiLineLayout = (MultiLineLayout)this.j.findViewById(2131446796);
    localMultiLineLayout.setShowLine(2);
    localMultiLineLayout.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int i1 = 0;
      while (i1 < paramList.size())
      {
        TextView localTextView = new TextView(this);
        localTextView.setBackgroundResource(2130845005);
        localTextView.setTextSize(2, 14.0F);
        if (paramBoolean) {
          localTextView.setMaxWidth((int)(this.mDensity * 77.0F));
        }
        localTextView.setSingleLine();
        localTextView.setTextColor(-1);
        localTextView.setShadowLayer(0.0F, 0.0F, 2.0F, Color.parseColor("#000000"));
        localTextView.setGravity(17);
        localTextView.setText((CharSequence)paramList.get(i1));
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localMultiLineLayout.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        localTextView.setOnClickListener(this.s);
        i1 += 1;
      }
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null)) {
      this.t = paramIntent.getBooleanExtra("isDataChanged", false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.k = this;
    this.m = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER));
    addObserver(this.r);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.r);
    ShowExternalTroopListAdapter localShowExternalTroopListAdapter = this.d;
    if (localShowExternalTroopListAdapter != null) {
      localShowExternalTroopListAdapter.c();
    }
    super.doOnDestroy();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isDataChanged", this.t);
      setResult(-1, localIntent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    removeObserver(this.r);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.l)
    {
      TroopManager localTroopManager = this.m;
      if ((localTroopManager != null) && (localTroopManager.e().size() == 0))
      {
        a();
        return;
      }
      this.e.setVisibility(8);
      this.c.setAdapter(this.d);
    }
    d();
    c();
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    addObserver(this.r);
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Intent localIntent;
    if (i1 != 2131436180)
    {
      if ((i1 == 2131436211) || (i1 == 2131445686))
      {
        localIntent = new Intent();
        localIntent.putExtra("onlyOneSegement", true);
        localIntent.putExtra("_key_mode", 0);
        localIntent.putExtra("key_tab_mode", 1);
        localIntent.putExtra("is_from_show_ext_troop_list", true);
        localIntent.setClass(this, TroopActivity.class);
        startActivityForResult(localIntent, 1);
        if (i1 == 2131436211) {
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_mana", 0, 0, "", "", "", "");
        } else if (i1 == 2131445686) {
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_set", 0, 0, "", "", "", "");
        }
      }
    }
    else
    {
      localIntent = new Intent();
      localIntent.putExtra("isDataChanged", this.t);
      setResult(-1, localIntent);
      onBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.i.c(e());
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.i.b(e());
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.i.a(e());
    if (!d())
    {
      paramView = this.u;
      if (paramView != null) {
        paramView.sendEmptyMessageDelayed(101, 1000L);
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity
 * JD-Core Version:    0.7.0.1
 */