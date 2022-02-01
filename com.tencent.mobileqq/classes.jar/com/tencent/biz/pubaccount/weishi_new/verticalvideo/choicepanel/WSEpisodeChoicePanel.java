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
  private static final float jdField_a_of_type_Float = WSFeedUtils.a(10.0F);
  private static final int jdField_a_of_type_Int = WSFeedUtils.a(88.0F);
  private final RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new WSEpisodeChoicePanel.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSChoiceVideoAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter;
  private WSVerticalItemData jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
  private AbsWSVerticalChoiceVideoPresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoPresenterAbsWSVerticalChoiceVideoPresenter;
  private WSDragLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout;
  private WSXRecyclerView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  private TextView c;
  private TextView d;
  
  private WSEpisodeChoicePanel(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(LayoutInflater.from(paramWSVerticalPageFragment.getActivity()).inflate(1929641986, null, false), -1, -1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    i();
    j();
    k();
    l();
  }
  
  private int a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData = a();
    if ((b()) && (WSExpABTestManager.a().h()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a().a().dramaInfo.isFollowed;
      int i;
      if (bool) {
        i = 2;
      } else {
        i = 1;
      }
      c(bool);
      return i;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return 0;
  }
  
  private Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity();
  }
  
  private Context a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getContext();
  }
  
  private GradientDrawable a(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(WeishiUIUtil.j);
    localGradientDrawable.setColor(Color.parseColor(paramString));
    return localGradientDrawable;
  }
  
  public static WSEpisodeChoicePanel a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    return new WSEpisodeChoicePanel(paramWSVerticalPageFragment);
  }
  
  private WSVerticalItemData a()
  {
    if ((a() != null) && (a().a().a().getDataList().size() != 0)) {
      return (WSVerticalItemData)a().a().a().getDataList().get(0);
    }
    return null;
  }
  
  @NotNull
  private XRecyclerView.RefreshCallback a()
  {
    return new WSEpisodeChoicePanel.4(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Map localMap = a().b();
    localMap.put("btn_status", String.valueOf(paramInt1));
    WSVerticalCollectionBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), paramInt2, localMap);
  }
  
  private void a(Window paramWindow)
  {
    int i;
    if ((SystemBarTintManager.hasNavBar(a())) && (ScreenUtil.isNavigationBarExist(a()))) {
      i = SystemBarTintManager.getNavigationBarHeight(a());
    } else {
      i = 0;
    }
    showAtLocation(paramWindow.getDecorView(), 80, 0, i);
  }
  
  private void a(WSVerticalItemData paramWSVerticalItemData)
  {
    Map localMap = a().b();
    localMap.putAll(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.a());
    localMap.putAll(a().a(paramWSVerticalItemData));
    localMap.put("close_type", "1");
    WSVerticalCollectionBeaconReport.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), localMap);
  }
  
  private void b(float paramFloat)
  {
    Window localWindow = a().getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.alpha = paramFloat;
    localWindow.addFlags(2);
    localWindow.setAttributes(localLayoutParams);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.post(new WSEpisodeChoicePanel.7(this, paramInt));
  }
  
  private boolean b()
  {
    WSVerticalItemData localWSVerticalItemData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData;
    return (localWSVerticalItemData != null) && (localWSVerticalItemData.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a().a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a().a().dramaInfo != null);
  }
  
  private void c(int paramInt)
  {
    LoadingMoreHelper localLoadingMoreHelper = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getLoadMoreLayoutHelper();
    if (localLoadingMoreHelper != null) {
      localLoadingMoreHelper.setPreLoaderCount(paramInt);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.d.setBackgroundDrawable(a("#7A46FF"));
      this.d.setTextColor(-1);
      this.d.setText(a().getResources().getString(1929707530));
      this.c.setText(a().getResources().getString(1929707529));
      return;
    }
    this.d.setBackgroundDrawable(a("#FFFFFF"));
    this.d.setTextColor(Color.parseColor("#7A46FF"));
    this.d.setText(a().getResources().getString(1929707527));
    this.c.setText(a().getResources().getString(1929707528));
  }
  
  private void d(int paramInt)
  {
    Map localMap = a().b();
    localMap.put("btn_status", String.valueOf(paramInt));
    WSVerticalCollectionBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), localMap);
  }
  
  private void g()
  {
    if (!a().f())
    {
      if (!isShowing()) {
        return;
      }
      h();
      WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][addOnScrollListener]");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    }
  }
  
  private void h()
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][removeOnScrollListener]");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
  }
  
  private void i()
  {
    setAnimationStyle(2131755835);
    setFocusable(true);
    setInputMethodMode(1);
    setSoftInputMode(16);
    setClippingEnabled(false);
    setOutsideTouchable(true);
  }
  
  private void j()
  {
    View localView = getContentView();
    localView.setOnKeyListener(this);
    WSEpisodeChoicePanel.2 local2 = new WSEpisodeChoicePanel.2(this);
    localView.setOnClickListener(local2);
    localView.findViewById(1929576448).setOnClickListener(local2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(1929576465));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(WeishiUIUtil.a(jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(1929576452));
    this.b = ((TextView)localView.findViewById(1929576451));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout = ((WSDragLayout)localView.findViewById(1929576449));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView = ((WSXRecyclerView)localView.findViewById(1929576455));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setControlLitTongue(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setPullHeaderBgDrawable(new ColorDrawable(-16777216));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setContentView(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setTouchListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setMode(1);
  }
  
  private void k()
  {
    c(10);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setIsAutoScrolling(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setRefreshCallback(a());
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(a());
    localRecyclerViewWithHeaderFooter.setItemAnimator(null);
    localRecyclerViewWithHeaderFooter.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter = new WSChoiceVideoAdapter(a(), localRecyclerViewWithHeaderFooter);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.a(new WSEpisodeChoicePanel.3(this));
    localRecyclerViewWithHeaderFooter.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidViewView = getContentView().findViewById(1929576456);
    this.c = ((TextView)getContentView().findViewById(1929576467));
    this.d = ((TextView)getContentView().findViewById(1929576466));
    this.d.setOnClickListener(new WSEpisodeChoicePanel.5(this));
  }
  
  private void m()
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.getDataList().size();
    int j = ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().getLayoutManager()).findLastVisibleItemPosition();
    boolean bool1 = a().f();
    boolean bool2 = a().e();
    int k = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSEpisodeChoicePanel.java][preloadData] checkedPosition:");
    localStringBuilder.append(k);
    localStringBuilder.append(", loadMoreUpFinish:");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", loadMoreDownFinish:");
    localStringBuilder.append(bool2);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if ((bool2) && (bool1)) {
      return;
    }
    if ((!bool2) && ((bool1) || (k != 1) || (i < 6)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.getDataList().size() - j <= 10)
      {
        WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][preloadData] loadDataDown");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getLoadMoreLayoutHelper().setLoadMore(true);
      }
    }
    else
    {
      WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][preloadData] loadDataUp");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.startMachineRefresh();
    }
  }
  
  private void n()
  {
    o();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a().a());
    this.b.setText(a().b());
  }
  
  private void o()
  {
    Object localObject = a().a().a().a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSEpisodeChoicePanel.java][scrollToPositionWhenShow] playingVideoHolder:");
    localStringBuilder.append(localObject);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (localObject != null)
    {
      int i = a().a().a().getDataList().indexOf(((WSVerticalVideoHolder)localObject).a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSEpisodeChoicePanel.java][scrollToPositionWhenShow] position:");
      ((StringBuilder)localObject).append(i);
      WSLog.e("WSEpisodeChoicePanel", ((StringBuilder)localObject).toString());
      ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().getLayoutManager()).scrollToPositionWithOffset(i, jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.a(i);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.post(new WSEpisodeChoicePanel.6(this));
  }
  
  private void p()
  {
    if (WeishiUtils.c()) {
      return;
    }
    if (!b()) {
      return;
    }
    WSDramaEpisodeInfo localWSDramaEpisodeInfo = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalItemData.a();
    boolean bool = localWSDramaEpisodeInfo.a().dramaInfo.isFollowed;
    int i;
    int j;
    if (bool)
    {
      i = 2;
      j = 1003038;
    }
    else
    {
      i = 1;
      j = 1003030;
    }
    a(i, j);
    WSDramaOperationRecordManager.a(localWSDramaEpisodeInfo.a(), i, new WSEpisodeChoicePanel.8(this, bool));
  }
  
  private void q()
  {
    Map localMap = a().b();
    localMap.putAll(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.a());
    localMap.put("close_type", "2");
    WSVerticalCollectionBeaconReport.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), localMap);
  }
  
  public WSChoiceVideoAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter;
  }
  
  public AbsWSVerticalChoiceVideoPresenter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoPresenterAbsWSVerticalChoiceVideoPresenter;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
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
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoPresenterAbsWSVerticalChoiceVideoPresenter = paramAbsWSVerticalChoiceVideoPresenter;
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][fillData]");
    a().fillList(paramList);
    g();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a().a(paramBoolean1, paramBoolean2, a());
  }
  
  public boolean a()
  {
    return a().f() ^ true;
  }
  
  public void b()
  {
    Window localWindow = a().getWindow();
    if (localWindow != null)
    {
      localWindow.setDimAmount(0.5F);
      a(localWindow);
      a(0.0F);
      n();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(0);
    }
    d(a());
  }
  
  public void b(List<WSVerticalItemData> paramList)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][setData]");
    a().a(paramList);
    g();
  }
  
  public void b(boolean paramBoolean)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][hideLoadMoreView]");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.loadMoreComplete(true, paramBoolean);
    if (a().f()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setRefreshEnable(false);
    }
  }
  
  public void c()
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][hideRefreshingView]");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.pullRefreshCompleted(true);
    if (a().f()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setRefreshEnable(false);
    }
  }
  
  public void c(List<WSVerticalItemData> paramList)
  {
    WSLog.e("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][insertDataToTop]");
    a().b(paramList);
    g();
  }
  
  public void d()
  {
    g();
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(0);
    b(1.0F);
    WSDragLayout localWSDragLayout = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout;
    if (localWSDragLayout != null) {
      localWSDragLayout.a(0);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      q();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void e()
  {
    Object localObject = a().a().a().a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSEpisodeChoicePanel.java][scrollToPosition] playingVideoHolder:");
    localStringBuilder.append(localObject);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (localObject == null) {
      return;
    }
    int i = a().a().a().getDataList().indexOf(((WSVerticalVideoHolder)localObject).a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSEpisodeChoicePanel.java][scrollToPosition] position:");
    ((StringBuilder)localObject).append(i);
    WSLog.e("WSEpisodeChoicePanel", ((StringBuilder)localObject).toString());
    b(i);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSChoiceVideoAdapter.a(i);
  }
  
  public void f()
  {
    a().a(a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel
 * JD-Core Version:    0.7.0.1
 */