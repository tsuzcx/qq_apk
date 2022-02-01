package com.tencent.biz.pubaccount.weishi_new.combo.home.topbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.topnav.AbsWSTopBarController;
import com.tencent.biz.pubaccount.weishi_new.view.topnav.WSTopNavigationBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboHomeTopBarController;", "Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/AbsWSTopBarController;", "topNavigationBar", "Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;)V", "followTabHolder", "Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabItemViewHolder;", "getFollowTabHolder", "()Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabItemViewHolder;", "setFollowTabHolder", "(Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabItemViewHolder;)V", "recommendTabHolder", "getRecommendTabHolder", "setRecommendTabHolder", "tabLayout", "Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabLayout;", "topBarChangeListenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/IWSTopBarChangeListener;", "changeTextColorOnPagerScrolled", "", "bottomBarId", "positionOffset", "", "changeTextColorOnTabSelected", "tabIndex", "", "getTopBarData", "", "Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabInfo;", "initTextTabHolder", "setBackBtnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setDetailBtnClickListener", "setTopBarStyle", "barStyle", "isShowUnderLine", "", "setupTopBar", "Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabLayout$TabContentClickListener;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomeTopBarController
  extends AbsWSTopBarController
{
  private WSTabLayout a;
  @Nullable
  private WSTabItemViewHolder b;
  @Nullable
  private WSTabItemViewHolder c;
  private HashMap<String, IWSTopBarChangeListener> d;
  private final WSTopNavigationBar e;
  private final WSComboHomeFragment f;
  
  public WSComboHomeTopBarController(@NotNull WSTopNavigationBar paramWSTopNavigationBar, @NotNull WSComboHomeFragment paramWSComboHomeFragment)
  {
    super(paramWSTopNavigationBar, 1929773082);
    this.e = paramWSTopNavigationBar;
    this.f = paramWSComboHomeFragment;
    paramWSTopNavigationBar = c().findViewById(1929707626);
    Intrinsics.checkExpressionValueIsNotNull(paramWSTopNavigationBar, "centerContentView.findVi….id.ws_tab_layout_compat)");
    this.a = ((WSTabLayout)paramWSTopNavigationBar);
    this.d = new HashMap();
  }
  
  private final void a(WSTabLayout paramWSTabLayout)
  {
    TabLayoutCompat.Tab localTab2 = paramWSTabLayout.b(0);
    TabLayoutCompat.Tab localTab1 = paramWSTabLayout.b(1);
    Object localObject = null;
    if (localTab2 != null) {
      paramWSTabLayout = localTab2.a();
    } else {
      paramWSTabLayout = null;
    }
    this.b = ((WSTabItemViewHolder)paramWSTabLayout);
    paramWSTabLayout = localObject;
    if (localTab1 != null) {
      paramWSTabLayout = localTab1.a();
    }
    this.c = ((WSTabItemViewHolder)paramWSTabLayout);
  }
  
  private final List<WSTabInfo> d()
  {
    List localList = (List)new ArrayList();
    WSTabInfo localWSTabInfo = new WSTabInfo(BaseApplicationImpl.getContext().getString(1929838620)).a(true).a(18);
    Intrinsics.checkExpressionValueIsNotNull(localWSTabInfo, "WSTabInfo(BaseApplicatio…rue).setTitleTextSize(18)");
    localList.add(localWSTabInfo);
    localWSTabInfo = new WSTabInfo(BaseApplicationImpl.getContext().getString(1929838621)).a(true).a(18);
    Intrinsics.checkExpressionValueIsNotNull(localWSTabInfo, "WSTabInfo(BaseApplicatio…rue).setTitleTextSize(18)");
    localList.add(localWSTabInfo);
    return localList;
  }
  
  @Nullable
  public final WSTabItemViewHolder a()
  {
    return this.b;
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    this.e.setTopBarStyle(paramInt, paramBoolean);
  }
  
  public final void a(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.e.setBackBtnClickListener(paramOnClickListener);
  }
  
  public final void a(@NotNull String paramString, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bottomBarId");
    paramString = (IWSTopBarChangeListener)this.d.get(paramString);
    if (paramString != null) {
      paramString.a(paramFloat);
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bottomBarId");
    paramString = (IWSTopBarChangeListener)this.d.get(paramString);
    if (paramString != null) {
      paramString.a(paramInt);
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt, @NotNull WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bottomBarId");
    Intrinsics.checkParameterIsNotNull(paramTabContentClickListener, "listener");
    this.a.a(d(), paramTabContentClickListener);
    a(this.a);
    paramTabContentClickListener = this.d;
    paramTabContentClickListener.put("waterfall_tab", new WSComboTopBarChangeForDiscovery(this, this.f));
    paramTabContentClickListener.put("monofeed_tab", new WSComboTopBarChangeForEssence(this, this.f));
    a(paramString, paramInt);
  }
  
  @Nullable
  public final WSTabItemViewHolder b()
  {
    return this.c;
  }
  
  public final void b(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.e.setDetailBtnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.topbar.WSComboHomeTopBarController
 * JD-Core Version:    0.7.0.1
 */