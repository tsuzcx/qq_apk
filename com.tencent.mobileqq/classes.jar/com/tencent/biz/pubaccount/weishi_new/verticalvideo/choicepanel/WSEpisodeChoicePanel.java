package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaOperationRecordManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeInfo;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalChoiceVideoPresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalCollectionBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout.TouchListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.immersive.SystemBarTintManager;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class WSEpisodeChoicePanel
  extends PopupWindow
  implements View.OnKeyListener, IWSEpisodeChoiceView, WSDragLayout.TouchListener
{
  private static final float a = WSFeedUtils.a(10.0F);
  private static final int b = WSFeedUtils.a(88.0F);
  private final WSVerticalPageFragment c;
  private WSDragLayout d;
  private WSXRecyclerView e;
  private RelativeLayout f;
  private TextView g;
  private TextView h;
  private View i;
  private TextView j;
  private TextView k;
  private WSChoiceVideoAdapter l;
  private AbsWSVerticalChoiceVideoPresenter m;
  private WSVerticalItemData n;
  private boolean o = false;
  private final RecyclerView.OnScrollListener p = new WSEpisodeChoicePanel.1(this);
  
  private WSEpisodeChoicePanel(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(LayoutInflater.from(paramWSVerticalPageFragment.getActivity()).inflate(1929773062, null, false), -1, -1);
    this.c = paramWSVerticalPageFragment;
    o();
    p();
    q();
    s();
  }
  
  private void A()
  {
    Map localMap = g().n();
    localMap.putAll(this.l.c());
    localMap.put("close_type", "2");
    WSVerticalCollectionBeaconReport.c(this.c.k(), this.c.l(), this.c.F(), localMap);
  }
  
  private GradientDrawable a(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(WeishiUIUtil.l);
    localGradientDrawable.setColor(Color.parseColor(paramString));
    return localGradientDrawable;
  }
  
  public static WSEpisodeChoicePanel a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    return new WSEpisodeChoicePanel(paramWSVerticalPageFragment);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Map localMap = g().n();
    localMap.put("btn_status", String.valueOf(paramInt1));
    WSVerticalCollectionBeaconReport.a(this.c.k(), this.c.l(), this.c.F(), paramInt2, localMap);
  }
  
  private void a(Window paramWindow)
  {
    Activity localActivity = m();
    if (localActivity == null) {
      return;
    }
    int i1;
    if ((SystemBarTintManager.hasNavBar(localActivity)) && (ScreenUtil.isNavigationBarExist(localActivity))) {
      i1 = SystemBarTintManager.getNavigationBarHeight(localActivity);
    } else {
      i1 = 0;
    }
    showAtLocation(paramWindow.getDecorView(), 80, 0, i1);
  }
  
  private void a(WSVerticalItemData paramWSVerticalItemData)
  {
    Map localMap = g().n();
    localMap.putAll(this.l.c());
    localMap.putAll(g().a(paramWSVerticalItemData));
    localMap.put("close_type", "1");
    WSVerticalCollectionBeaconReport.b(this.c.k(), this.c.l(), this.c.F(), localMap);
  }
  
  private void b(float paramFloat)
  {
    Object localObject = m();
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.alpha = paramFloat;
    ((Window)localObject).addFlags(2);
    ((Window)localObject).setAttributes(localLayoutParams);
  }
  
  private void b(int paramInt)
  {
    this.e.post(new WSEpisodeChoicePanel.7(this, paramInt));
  }
  
  private void c(int paramInt)
  {
    LoadingMoreHelper localLoadingMoreHelper = this.e.getLoadMoreLayoutHelper();
    if (localLoadingMoreHelper != null) {
      localLoadingMoreHelper.setPreLoaderCount(paramInt);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.k.setBackgroundDrawable(a("#7A46FF"));
      this.k.setTextColor(-1);
      this.k.setText(n().getResources().getString(1929838612));
      this.j.setText(n().getResources().getString(1929838611));
      return;
    }
    this.k.setBackgroundDrawable(a("#FFFFFF"));
    this.k.setTextColor(Color.parseColor("#7A46FF"));
    this.k.setText(n().getResources().getString(1929838609));
    this.j.setText(n().getResources().getString(1929838610));
  }
  
  private void d(int paramInt)
  {
    Map localMap = g().n();
    localMap.put("btn_status", String.valueOf(paramInt));
    WSVerticalCollectionBeaconReport.a(this.c.k(), this.c.l(), this.c.F(), localMap);
  }
  
  private void k()
  {
    if (!g().v())
    {
      if (!isShowing()) {
        return;
      }
      l();
      WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][addOnScrollListener]");
      this.e.getRecyclerView().addOnScrollListener(this.p);
    }
  }
  
  private void l()
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][removeOnScrollListener]");
    this.e.getRecyclerView().removeOnScrollListener(this.p);
  }
  
  private Activity m()
  {
    return this.c.getActivity();
  }
  
  private Context n()
  {
    return this.c.getContext();
  }
  
  private void o()
  {
    setAnimationStyle(2131952946);
    setFocusable(true);
    setInputMethodMode(1);
    setSoftInputMode(16);
    setClippingEnabled(false);
    setOutsideTouchable(true);
  }
  
  private void p()
  {
    View localView = getContentView();
    localView.setOnKeyListener(this);
    WSEpisodeChoicePanel.2 local2 = new WSEpisodeChoicePanel.2(this);
    localView.setOnClickListener(local2);
    localView.findViewById(1929707523).setOnClickListener(local2);
    this.f = ((RelativeLayout)localView.findViewById(1929707580));
    this.f.setBackgroundDrawable(WeishiUIUtil.a(a));
    this.g = ((TextView)localView.findViewById(1929707527));
    this.h = ((TextView)localView.findViewById(1929707526));
    this.d = ((WSDragLayout)localView.findViewById(1929707524));
    this.e = ((WSXRecyclerView)localView.findViewById(1929707530));
    this.d.setDisableMinScrollY(true);
    this.d.setControlLitTongue(false);
    this.e.setPullHeaderBgDrawable(new ColorDrawable(-16777216));
    this.d.setContentView(this.e.getRecyclerView());
    this.d.setTouchListener(this);
    this.d.setMode(1);
  }
  
  private void q()
  {
    c(10);
    this.e.setIsAutoScrolling(true);
    this.e.setRefreshCallback(r());
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.e.getRecyclerView();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(n());
    localRecyclerViewWithHeaderFooter.setItemAnimator(null);
    localRecyclerViewWithHeaderFooter.setLayoutManager(localLinearLayoutManager);
    this.l = new WSChoiceVideoAdapter(n(), localRecyclerViewWithHeaderFooter);
    this.l.a(new WSEpisodeChoicePanel.3(this));
    localRecyclerViewWithHeaderFooter.setAdapter(this.l);
  }
  
  @NotNull
  private XRecyclerView.RefreshCallback r()
  {
    return new WSEpisodeChoicePanel.4(this);
  }
  
  private void s()
  {
    this.i = getContentView().findViewById(1929707535);
    this.j = ((TextView)getContentView().findViewById(1929707586));
    this.k = ((TextView)getContentView().findViewById(1929707585));
    this.k.setOnClickListener(new WSEpisodeChoicePanel.5(this));
  }
  
  private void t()
  {
    int i1 = this.l.getDataList().size();
    int i2 = ((LinearLayoutManager)this.e.getRecyclerView().getLayoutManager()).findLastVisibleItemPosition();
    boolean bool1 = g().v();
    boolean bool2 = g().u();
    int i3 = this.l.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSEpisodeChoicePanel.java][preloadData] checkedPosition:");
    localStringBuilder.append(i3);
    localStringBuilder.append(", loadMoreUpFinish:");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", loadMoreDownFinish:");
    localStringBuilder.append(bool2);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if ((bool2) && (bool1)) {
      return;
    }
    if ((!bool2) && ((bool1) || (i3 != 1) || (i1 < 6)))
    {
      if (this.l.getDataList().size() - i2 <= 10)
      {
        WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][preloadData] loadDataDown");
        this.e.getLoadMoreLayoutHelper().setLoadMore(true);
      }
    }
    else
    {
      WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][preloadData] loadDataUp");
      this.e.startMachineRefresh();
    }
  }
  
  private void u()
  {
    v();
    this.g.setText(g().w());
    this.h.setText(g().x());
  }
  
  private void v()
  {
    Object localObject = g().z().b().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSEpisodeChoicePanel.java][scrollToPositionWhenShow] playingVideoHolder:");
    localStringBuilder.append(localObject);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (localObject != null)
    {
      int i1 = g().z().b().getDataList().indexOf(((WSVerticalVideoHolder)localObject).e);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSEpisodeChoicePanel.java][scrollToPositionWhenShow] position:");
      ((StringBuilder)localObject).append(i1);
      WSLog.e("WSEpisodeChoicePanel", ((StringBuilder)localObject).toString());
      ((LinearLayoutManager)this.e.getRecyclerView().getLayoutManager()).scrollToPositionWithOffset(i1, b);
      this.l.a(i1);
    }
    this.e.post(new WSEpisodeChoicePanel.6(this));
  }
  
  private int w()
  {
    this.n = x();
    if ((y()) && (WSExpABTestManager.a().t()))
    {
      this.i.setVisibility(0);
      boolean bool = this.n.g().d().dramaInfo.isFollowed;
      int i1;
      if (bool) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      c(bool);
      return i1;
    }
    this.i.setVisibility(8);
    return 0;
  }
  
  private WSVerticalItemData x()
  {
    if ((g() != null) && (g().z().b().getDataList().size() != 0)) {
      return (WSVerticalItemData)g().z().b().getDataList().get(0);
    }
    return null;
  }
  
  private boolean y()
  {
    WSVerticalItemData localWSVerticalItemData = this.n;
    return (localWSVerticalItemData != null) && (localWSVerticalItemData.g() != null) && (this.n.g().d() != null) && (this.n.g().d().dramaInfo != null);
  }
  
  private void z()
  {
    if (WeishiUtils.o()) {
      return;
    }
    if (!y()) {
      return;
    }
    WSDramaEpisodeInfo localWSDramaEpisodeInfo = this.n.g();
    boolean bool = localWSDramaEpisodeInfo.d().dramaInfo.isFollowed;
    int i1;
    int i2;
    if (bool)
    {
      i1 = 2;
      i2 = 1003038;
    }
    else
    {
      i1 = 1;
      i2 = 1003030;
    }
    a(i1, i2);
    WSDramaOperationRecordManager.a(localWSDramaEpisodeInfo.a(), i1, new WSEpisodeChoicePanel.8(this, bool));
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progress = ");
    localStringBuilder.append(paramFloat);
    WSLog.a("WSEpisodeChoicePanel", localStringBuilder.toString());
    double d1 = paramFloat;
    Double.isNaN(d1);
    b((float)(d1 * 0.3D + 0.7D));
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(AbsWSVerticalChoiceVideoPresenter paramAbsWSVerticalChoiceVideoPresenter)
  {
    this.m = paramAbsWSVerticalChoiceVideoPresenter;
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][fillData]");
    i().fillList(paramList);
    k();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    g().a(paramBoolean1, paramBoolean2, h());
  }
  
  public void b(List<WSVerticalItemData> paramList)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][setData]");
    i().a(paramList);
    k();
  }
  
  public void b(boolean paramBoolean)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][hideLoadMoreView]");
    this.e.loadMoreComplete(true, paramBoolean);
    if (g().v()) {
      this.e.setRefreshEnable(false);
    }
  }
  
  public boolean b()
  {
    return g().v() ^ true;
  }
  
  public void c()
  {
    Object localObject = m();
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setDimAmount(0.5F);
      a((Window)localObject);
      a(0.0F);
      u();
      this.c.a(0);
    }
    d(w());
  }
  
  public void c(List<WSVerticalItemData> paramList)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][insertDataToTop]");
    i().b(paramList);
    k();
  }
  
  public void d()
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][hideRefreshingView]");
    this.e.pullRefreshCompleted(true);
    if (g().v()) {
      this.e.setRefreshEnable(false);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.c.b(0);
    b(1.0F);
    WSDragLayout localWSDragLayout = this.d;
    if (localWSDragLayout != null) {
      localWSDragLayout.a(0);
    }
    if (!this.o)
    {
      A();
      this.o = false;
    }
  }
  
  public void e()
  {
    k();
  }
  
  public void f()
  {
    Object localObject = g().z().b().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSEpisodeChoicePanel.java][scrollToPosition] playingVideoHolder:");
    localStringBuilder.append(localObject);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (localObject == null) {
      return;
    }
    int i1 = g().z().b().getDataList().indexOf(((WSVerticalVideoHolder)localObject).e);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSEpisodeChoicePanel.java][scrollToPosition] position:");
    ((StringBuilder)localObject).append(i1);
    WSLog.e("WSEpisodeChoicePanel", ((StringBuilder)localObject).toString());
    b(i1);
    this.l.a(i1);
  }
  
  public AbsWSVerticalChoiceVideoPresenter g()
  {
    return this.m;
  }
  
  public String h()
  {
    return this.c.k();
  }
  
  public WSChoiceVideoAdapter i()
  {
    return this.l;
  }
  
  public void j()
  {
    g().a(h());
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel
 * JD-Core Version:    0.7.0.1
 */