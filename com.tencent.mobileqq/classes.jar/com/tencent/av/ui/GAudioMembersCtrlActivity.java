package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class GAudioMembersCtrlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  VideoAppInterface a;
  VideoController b;
  GAudioMemberListCtrl c;
  long d = 0L;
  private TextView e;
  private View f;
  private TextView g;
  private PinnedDividerListView h;
  private ArrayList<VideoController.GAudioFriends> i;
  private Dialog j;
  private Runnable k = null;
  private boolean l = true;
  private boolean m = false;
  private View.OnTouchListener n = new GAudioMembersCtrlActivity.1(this);
  private InviteMemberObserver o = new GAudioMembersCtrlActivity.2(this);
  private GAudioUIObserver p = new GAudioMembersCtrlActivity.7(this);
  private BroadcastReceiver q = null;
  
  private void a(int paramInt)
  {
    if (this.e != null)
    {
      int i1;
      if (this.l) {
        i1 = 2131903137;
      } else {
        i1 = 2131903136;
      }
      String str = HardCodeUtil.a(i1);
      this.e.setText(String.format(str, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    GAudioMemberListCtrl localGAudioMemberListCtrl = this.c;
    if (localGAudioMemberListCtrl != null) {
      localGAudioMemberListCtrl.a(paramLong, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  @TargetApi(14)
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131445137);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      localRelativeLayout.setFitsSystemWindows(true);
    }
    boolean bool1 = ThemeUtil.isInNightMode(this.a);
    this.e = ((TextView)super.findViewById(2131436227));
    this.f = super.findViewById(2131436187);
    this.h = ((PinnedDividerListView)super.findViewById(2131448034));
    this.g = ((TextView)super.findViewById(2131441187));
    this.g.setOnClickListener(this);
    this.g.setOnTouchListener(this.n);
    if (bool1)
    {
      localRelativeLayout.setBackgroundColor(Color.parseColor("#000000"));
      super.findViewById(2131447484).setBackgroundColor(-16777216);
      super.findViewById(2131440354).setBackgroundColor(Color.parseColor("#000000"));
      ((TextView)super.findViewById(2131436180)).setBackgroundDrawable(getResources().getDrawable(2130852237));
      this.e.setTextColor(Color.parseColor("#A8A8A8"));
      this.g.setTextColor(Color.parseColor("#A8A8A8"));
    }
    boolean bool2 = this.l;
    Object localObject = "#080808";
    if (bool2)
    {
      localObject = super.getLayoutInflater().inflate(2131625743, this.h, false);
      if (bool1)
      {
        ((View)localObject).findViewById(2131445137).setBackgroundColor(Color.parseColor("#080808"));
        ((TextView)((View)localObject).findViewById(2131447090)).setTextColor(Color.parseColor("#757575"));
      }
    }
    else
    {
      View localView = new View(localRelativeLayout.getContext());
      if (!bool1) {
        localObject = "#F5F6FA";
      }
      localView.setBackgroundColor(Color.parseColor((String)localObject));
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(12.0F, localRelativeLayout.getResources())));
      localObject = localView;
    }
    this.h.addHeaderView((View)localObject);
    if (!this.l)
    {
      this.g.setClickable(false);
      this.g.setVisibility(8);
    }
    this.f.setVisibility(0);
    this.f.setOnTouchListener(new GAudioMembersCtrlActivity.3(this));
    this.f.setOnClickListener(new GAudioMembersCtrlActivity.4(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "showMenuMuteAll");
    }
    b();
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this);
    View localView = super.getLayoutInflater().inflate(2131625739, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131441071);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localActionSheet.addView(localView);
    localView = new View(this);
    localView.setBackgroundColor(Color.parseColor("#E5E6E7"));
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, AIOUtils.b(1.0F, getResources())));
    localActionSheet.addView(localView);
    localView = super.getLayoutInflater().inflate(2131624006, null);
    TextView localTextView2 = (TextView)localView.findViewById(2131427549);
    localView.setId(0);
    localView.setBackgroundDrawable(super.getResources().getDrawable(2130837681));
    boolean bool = QAVConfigUtils.q();
    int i1;
    if (this.b.k().aU)
    {
      localTextView2.setText(super.getString(2131893283));
      localTextView2.setTextColor(super.getResources().getColor(2131165410));
      if (bool) {
        i1 = 2131893284;
      } else {
        i1 = 2131893285;
      }
      localTextView1.setText(super.getString(i1));
    }
    else
    {
      localTextView2.setText(super.getString(2131893286));
      localTextView2.setTextColor(super.getResources().getColor(2131165406));
      if (bool) {
        i1 = 2131893287;
      } else {
        i1 = 2131893288;
      }
      localTextView1.setText(super.getString(i1));
    }
    localActionSheet.addView(localView);
    localActionSheet.addCancelButton(super.getResources().getString(2131887626));
    localView.setOnClickListener(new GAudioMembersCtrlActivity.5(this, localActionSheet));
    localActionSheet.setOnDismissListener(new GAudioMembersCtrlActivity.6(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    this.j = localActionSheet;
    try
    {
      this.j.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshGAFList");
    }
    VideoController localVideoController = this.b;
    if (localVideoController != null)
    {
      if (this.m)
      {
        int i1 = localVideoController.U().size();
        localVideoController = this.b;
        this.i = localVideoController.a(i1, localVideoController.P());
      }
      else
      {
        this.i = ((ArrayList)localVideoController.W().clone());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "refreshGAFList-->mVideoContrl is null");
    }
    a(this.i.size());
  }
  
  void a()
  {
    SessionInfo localSessionInfo = this.b.k();
    if (localSessionInfo != null)
    {
      if (localSessionInfo.aU)
      {
        this.g.setText(super.getString(2131893283));
        return;
      }
      this.g.setText(super.getString(2131893286));
    }
  }
  
  @TargetApi(11)
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("drawUI-->type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" fresh=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" originalType=");
      localStringBuilder.append(paramInt2);
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
    if (this.b == null) {
      return;
    }
    if ((paramInt1 == 0) || (paramInt1 == 1)) {
      c();
    }
    if (paramInt2 == 42)
    {
      a(paramLong, true);
      return;
    }
    if (paramInt2 == 43) {
      a(paramLong, false);
    }
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshUI-->uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" isRefreshTitle=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" originalType=");
      localStringBuilder.append(paramInt2);
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "refreshUI-->uin == 0");
      }
      return;
    }
    super.runOnUiThread(new GAudioMembersCtrlActivity.RefreshUIRunnable(this, paramInt1, paramLong, paramBoolean, paramInt2));
  }
  
  void b()
  {
    Dialog localDialog = this.j;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.j.dismiss();
      label23:
      this.j = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  void c()
  {
    f();
    GAudioMemberListCtrl localGAudioMemberListCtrl = this.c;
    if (localGAudioMemberListCtrl != null) {
      localGAudioMemberListCtrl.a(this.i);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
    }
    super.setTheme(2131952010);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131625741);
    paramBundle = super.getIntent().getStringExtra("discussUin");
    this.l = super.getIntent().getBooleanExtra("Owner", true);
    this.m = super.getIntent().getBooleanExtra("isInRoom", true);
    if (!this.m) {
      this.l = false;
    }
    if (TextUtils.isEmpty(paramBundle))
    {
      finish();
      return false;
    }
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(ThemeUtil.isInNightMode(this.a) ^ true, getWindow());
    d();
    this.a = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = this.a;
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.b = paramBundle.b();
    this.d = this.b.k().aN;
    f();
    this.c = new GAudioMemberListCtrl(this, this.a, this.h, this.b.k().aN, this.b.k().aQ, this.l);
    this.c.a(this.i);
    a();
    this.a.a(this.p);
    if (this.m) {
      this.a.a(this.o);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.q = new GAudioMembersCtrlActivity.VideoMsgReceiver(this);
    super.registerReceiver(this.q, paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("GAudioMembersCtrlActivity doOnCreate end , cost time : ");
      paramBundle.append(System.currentTimeMillis() - l1);
      paramBundle.append("ms");
      QLog.i("GAudioMembersCtrlActivity", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.b(this.p);
    if (this.m) {
      this.a.b(this.o);
    }
    if (this.k != null) {
      this.a.a().removeCallbacks(this.k);
    }
    this.k = null;
    this.c.b();
    this.c = null;
    ArrayList localArrayList = this.i;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.i = null;
    this.a = null;
    this.b = null;
    try
    {
      if (this.q != null)
      {
        super.unregisterReceiver(this.q);
        this.q = null;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "", localException);
      }
    }
    this.h = null;
    this.e = null;
    this.f = null;
    this.g = null;
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "doOnDestroy");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    a(false);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.k == null)
    {
      this.k = new GAudioMembersCtrlActivity.RefreshFaceRunnable(this, null);
      this.a.a().postDelayed(this.k, 2000L);
    }
    a();
    a(true);
  }
  
  public void finish()
  {
    super.finish();
    super.overridePendingTransition(0, 2130771995);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441187) {
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity
 * JD-Core Version:    0.7.0.1
 */