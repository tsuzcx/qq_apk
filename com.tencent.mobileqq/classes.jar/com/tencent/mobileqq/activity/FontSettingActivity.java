package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FontSettingManager.FontLevel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class FontSettingActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, FontSettingManager.FontLevel, RangeButtonView.OnChangeListener
{
  ViewPager a;
  CirclePageIndicator b;
  FontSettingActivity.FontPageAdapter c;
  ArrayList<View> d = new ArrayList();
  ListView e;
  ListView f;
  ViewGroup g;
  ViewGroup h;
  RangeButtonView i;
  ViewGroup j;
  FontSettingActivity.MyItemBuilder k;
  IFaceDecoder l;
  FontSettingActivity.AioListAdapter m;
  FontSettingActivity.TabListAdapter n;
  List<ChatMessage> o;
  SessionInfo p;
  ArrayList<FontSettingActivity.RecentData> q = new ArrayList();
  boolean r = false;
  boolean s = false;
  ThemeBackground t = null;
  boolean u = false;
  private boolean v = false;
  private float w = 16.0F;
  private TopGestureLayout x;
  private Dialog y = null;
  private MqqHandler z = new FontSettingActivity.4(this);
  
  private void a(View paramView)
  {
    ((TextView)paramView.findViewById(2131436180)).setOnClickListener(new FontSettingActivity.1(this));
    ((TextView)paramView.findViewById(2131436227)).setText(HardCodeUtil.a(2131902688));
    ((TextView)paramView.findViewById(2131436180)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void d()
  {
    f();
    this.a = ((ViewPager)findViewById(2131433561));
    this.c = new FontSettingActivity.FontPageAdapter(this);
    this.a.setAdapter(this.c);
    this.b = ((CirclePageIndicator)findViewById(2131433551));
    this.b.setViewPager(this.a);
    this.b.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.e = h();
    i();
    this.d.add(this.e);
    this.m = new FontSettingActivity.AioListAdapter(this);
    this.e.setAdapter(this.m);
    this.k = new FontSettingActivity.MyItemBuilder(this, this.app, this.m, this, this.p, null);
    this.l = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.k.a(this.l);
    j();
    this.f = h();
    b();
    this.n = new FontSettingActivity.TabListAdapter(this, this, this.app, this.f);
    this.d.add(this.f);
    this.f.setAdapter(this.n);
    this.c.notifyDataSetChanged();
    this.i = ((RangeButtonView)findViewById(2131433554));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131902696), TypedValue.applyDimension(1, 13.92F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131902695), TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131902694), TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics)));
    this.i.setTitleData(localArrayList);
    this.i.setOnChangerListener(this);
    this.i.setThumbPosition(e());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131888065));
    localArrayList.add(getString(2131888066));
    localArrayList.add(getString(2131888067));
    localArrayList.add(getString(2131888068));
    localArrayList.add(getString(2131888069));
    this.i.setContentDescList(localArrayList);
  }
  
  private int e()
  {
    this.w = FontSettingManager.getFontLevel();
    float f1 = this.w;
    if (f1 == 13.92F) {
      return 0;
    }
    if (f1 == 15.0F) {
      return 1;
    }
    if (f1 == 16.0F) {
      return 2;
    }
    if (f1 == 17.0F) {
      return 3;
    }
    if (f1 == 18.0F) {
      return 4;
    }
    return 2;
  }
  
  private void f()
  {
    this.h = ((ViewGroup)findViewById(2131447506));
    this.g = new NavBarCommon(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131299920));
    a(this.g);
    this.h.addView(this.g, 0, localLayoutParams);
  }
  
  private void g()
  {
    this.h.removeViewAt(0);
    f();
  }
  
  private ListView h()
  {
    ListView localListView = new ListView(this);
    ViewPager.LayoutParams localLayoutParams = new ViewPager.LayoutParams();
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localListView.setDivider(null);
    localListView.setDividerHeight(0);
    return localListView;
  }
  
  private void i()
  {
    if (this.o == null)
    {
      this.o = new ArrayList();
      Object localObject1 = new MessageForText();
      ((MessageForText)localObject1).frienduin = "2720152058";
      ((MessageForText)localObject1).senderuin = "2720152058";
      ((MessageForText)localObject1).issend = 1000;
      Object localObject2 = HardCodeUtil.a(2131902697);
      ((MessageForText)localObject1).msg = ((String)localObject2);
      ((MessageForText)localObject1).sb = ((CharSequence)localObject2);
      localObject2 = new MessageForText();
      Object localObject3 = this.app.getCurrentAccountUin();
      ((MessageForText)localObject2).frienduin = ((String)localObject3);
      ((MessageForText)localObject2).selfuin = ((String)localObject3);
      ((MessageForText)localObject2).senderuin = ((String)localObject3);
      ((MessageForText)localObject2).issend = 1;
      localObject3 = HardCodeUtil.a(2131902687);
      ((MessageForText)localObject2).msg = ((String)localObject3);
      ((MessageForText)localObject2).sb = ((CharSequence)localObject3);
      ((MessageForText)localObject2).vipBubbleID = ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).d();
      localObject3 = new MessageForText();
      ((MessageForText)localObject3).frienduin = "2720152058";
      ((MessageForText)localObject3).senderuin = "2720152058";
      ((MessageForText)localObject3).issend = 1000;
      String str = HardCodeUtil.a(2131902690);
      ((MessageForText)localObject3).msg = str;
      ((MessageForText)localObject3).sb = str;
      this.o.add(localObject1);
      this.o.add(localObject2);
      this.o.add(localObject3);
      this.p = new SessionInfo();
      localObject1 = this.p;
      ((SessionInfo)localObject1).a = 0;
      ((SessionInfo)localObject1).r = ChatTextSizeSettingActivity.a(this);
      this.p.H = new ChatBackground();
      if (ChatBackground.a(this, this.app.getCurrentAccountUin(), this.p.b, true, 7, this.p.H)) {
        this.e.setBackgroundDrawable(this.p.H.c);
      }
    }
  }
  
  private void j()
  {
    FontSettingActivity.RecentData localRecentData1 = new FontSettingActivity.RecentData(this, 0, HardCodeUtil.a(2131897419), HardCodeUtil.a(2131902691), "3:28PM", "2720152058", 0);
    FontSettingActivity.RecentData localRecentData2 = new FontSettingActivity.RecentData(this, 2130841183, HardCodeUtil.a(2131887615), HardCodeUtil.a(2131902686), "3:28PM", AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
    FontSettingActivity.RecentData localRecentData3 = new FontSettingActivity.RecentData(this, 2130841185, HardCodeUtil.a(2131886080), HardCodeUtil.a(2131902692), "3:28PM", AppConstants.TROOP_ASSISTANT_UIN, 5000);
    FontSettingActivity.RecentData localRecentData4 = new FontSettingActivity.RecentData(this, 2130845599, HardCodeUtil.a(2131892059), HardCodeUtil.a(2131902693), "3:28PM", AppConstants.DATALINE_PC_UIN, 6000);
    FontSettingActivity.RecentData localRecentData5 = new FontSettingActivity.RecentData(this, 0, HardCodeUtil.a(2131902698), HardCodeUtil.a(2131902689), "3:28PM", "2632129500", 0);
    this.q.add(localRecentData1);
    this.q.add(localRecentData2);
    this.q.add(localRecentData3);
    this.q.add(localRecentData4);
    this.q.add(localRecentData5);
  }
  
  private void k()
  {
    if (this.x == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof ViewGroup)) {
          localObject = (ViewGroup)localView;
        }
      }
      if ((localObject instanceof TopGestureLayout)) {
        this.x = ((TopGestureLayout)localObject);
      }
      localObject = this.x;
      if (localObject != null) {
        ((TopGestureLayout)localObject).setInterceptTouchFlag(false);
      }
    }
  }
  
  public void a()
  {
    if ((this.v) && (this.r) && (this.s))
    {
      this.s = false;
      this.r = false;
      this.v = false;
      FontSettingManager.revertToLsatDendisy(this);
    }
  }
  
  void b()
  {
    if (this.f == null) {
      return;
    }
    if (!ThemeBackground.a())
    {
      this.f.setContentBackground(2130838959);
      this.t = null;
      return;
    }
    if (this.t == null) {
      this.t = new ThemeBackground();
    }
    if (ThemeBackground.a(this.f.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), this.t)) {
      if ((!"null".equals(this.t.a)) && (this.t.b != null))
      {
        if (this.t.b != null) {
          this.f.setContentBackground(this.t.b);
        }
      }
      else
      {
        this.f.setContentBackground(2130838959);
        this.t = null;
      }
    }
  }
  
  void c()
  {
    if (this.w == FontSettingManager.getFontLevel())
    {
      finish();
      return;
    }
    this.y = CustomDialogFactory.a(this, 2131889651, 2131889649, 2131889648, 2131889650, new FontSettingActivity.2(this), new FontSettingActivity.3(this));
    if (!isFinishing()) {
      this.y.show();
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
  
  public void doOnBackPressed()
  {
    c();
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627453);
    this.j = ((ViewGroup)findViewById(2131445137));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.j.setFitsSystemWindows(true);
      this.j.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.app.setHandler(FontSettingActivity.class, this.z);
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.n.a();
    this.app.removeHandler(FontSettingActivity.class);
    IFaceDecoder localIFaceDecoder = this.l;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    k();
  }
  
  public void onChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 == 4) {
              this.w = 18.0F;
            }
          }
          else {
            this.w = 17.0F;
          }
        }
        else {
          this.w = 16.0F;
        }
      }
      else {
        this.w = 15.0F;
      }
    }
    else {
      this.w = 13.92F;
    }
    QQAppInterface localQQAppInterface = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((int)this.w);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, localStringBuilder.toString(), "", "", "");
    this.v = (true ^ FontSettingManager.setCustomDensity(this, this.w, false));
    this.p.r = ChatTextSizeSettingActivity.a(this);
    this.f.removeAllViewsInLayout();
    this.e.removeAllViewsInLayout();
    this.m.notifyDataSetChanged();
    this.n.notifyDataSetChanged();
    g();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity
 * JD-Core Version:    0.7.0.1
 */