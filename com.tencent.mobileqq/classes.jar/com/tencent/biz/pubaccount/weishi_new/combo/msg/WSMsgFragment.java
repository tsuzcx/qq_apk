package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import UserGrowth.stMsgContent;
import UserGrowth.stMsgRedDotCount;
import UserGrowth.stNotifyMsg;
import UserGrowth.stSchema;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.combo.WSFrameBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgPageData;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData.SectionInfo;
import com.tencent.biz.pubaccount.weishi_new.jump.IJumpListener;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout.OnInterceptTouchEventListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.view.topnav.WSTopNavigationBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.pull2refresh.BaseAdapter.OnItemClickListener;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/WSBaseFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragmentPresenter;", "Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroid/view/View$OnClickListener;", "()V", "mAdapter", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgAdapter;", "mEmptyView", "Landroid/widget/TextView;", "mRlFans", "Landroid/widget/LinearLayout;", "mRlLike", "mRlMsgPrivate", "mSwipeRefreshView", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/view/WSSwipeRefreshLayout;", "mTopBarController", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgTopBarController;", "mTopNavigationBar", "Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;", "mTvFansNum", "mTvLikeNum", "mTvMsgPrivateNum", "mXRecyclerView", "Lcom/tencent/biz/pubaccount/weishi_new/view/WSXRecyclerView;", "addFooterContent", "", "addHeaderView", "createPresenter", "doJumpAction", "data", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgSectionData;", "getHeaderView", "Landroid/view/View;", "getHeaderViewAdapter", "Lcom/tencent/widget/pull2refresh/RecyclerViewHeaderViewAdapter;", "hideLoadingView", "initData", "initRecyclerView", "initSwipeRefreshLayout", "initTopBar", "rootView", "initView", "itemClick", "position", "", "view", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onLoadDataFailed", "code", "msg", "", "isFirst", "", "onLoadDataSuccess", "pageData", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgPageData;", "isRefresh", "canLoadMore", "onRefresh", "onVisibleToUserChanged", "isVisibleToUser", "invokeInResumeOrPause", "schemeJumpAction", "scheme", "LUserGrowth/stSchema;", "jumpListener", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$SchemeJumpListener;", "setHeaderData", "setUserVisibleHint", "setupTopBarController", "topBarController", "showRefreshView", "startPublicAccountDetailActivity", "SchemeJumpListener", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragment
  extends WSBaseFragment<WSMsgContract.View, WSMsgFragmentPresenter>
  implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, WSMsgContract.View
{
  private WSSwipeRefreshLayout f;
  private WSXRecyclerView g;
  private WSMsgAdapter h;
  private TextView i;
  private LinearLayout j;
  private LinearLayout k;
  private LinearLayout l;
  private TextView m;
  private TextView n;
  private TextView o;
  private WSTopNavigationBar p;
  private WSMsgTopBarController q;
  
  private final void a(int paramInt, View paramView)
  {
    Object localObject1 = t();
    Object localObject3 = null;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((RecyclerViewHeaderViewAdapter)localObject1).getHeaderCount());
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Integer.valueOf(1);
    }
    localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    }
    localObject1 = (WSMsgSectionData)((WSMsgAdapter)localObject1).getItem(paramInt - ((Integer)localObject2).intValue());
    if (localObject1 != null)
    {
      if (((WSMsgSectionData)localObject1).a() == 0)
      {
        if (paramView != null) {
          paramView = (TextView)paramView.findViewById(1929707596);
        } else {
          paramView = null;
        }
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = ((WSMsgSectionData)localObject1).c();
        if (paramView != null) {
          paramView.a(0);
        }
        localObject2 = ((WSMsgSectionData)localObject1).c();
        paramView = localObject3;
        if (localObject2 != null) {
          paramView = ((WSMsgSectionData.SectionInfo)localObject2).d();
        }
        a(paramView, (WSMsgFragment.SchemeJumpListener)new WSMsgFragment.itemClick.1((WSMsgSectionData)localObject1));
        return;
      }
      a((WSMsgSectionData)localObject1);
    }
  }
  
  private final void a(stSchema paramstSchema, WSMsgFragment.SchemeJumpListener paramSchemeJumpListener)
  {
    if (paramstSchema == null) {
      return;
    }
    if (WeishiUtils.o()) {
      return;
    }
    new WSStSchemaJumpManager(this.a).a(paramstSchema).b(true).a((OuterInterceptManager.OnInterceptDialogClickListener)new WSMsgFragment.schemeJumpAction.1(this)).a((IJumpListener)new WSMsgFragment.schemeJumpAction.2(paramSchemeJumpListener)).j();
  }
  
  private final void a(View paramView)
  {
    View localView = paramView.findViewById(1929707575);
    Intrinsics.checkExpressionValueIsNotNull(localView, "rootView.findViewById(R.id.srl_msg)");
    this.f = ((WSSwipeRefreshLayout)localView);
    localView = paramView.findViewById(1929707573);
    Intrinsics.checkExpressionValueIsNotNull(localView, "rootView.findViewById(R.id.rv_msg)");
    this.g = ((WSXRecyclerView)localView);
    localView = paramView.findViewById(1929707590);
    Intrinsics.checkExpressionValueIsNotNull(localView, "rootView.findViewById(R.id.tv_msg_empty)");
    this.i = ((TextView)localView);
    b(paramView);
    p();
    u();
  }
  
  private final void a(WSMsgTopBarController paramWSMsgTopBarController)
  {
    paramWSMsgTopBarController.a((View.OnClickListener)new WSMsgFragment.setupTopBarController..inlined.apply.lambda.1(this));
    paramWSMsgTopBarController.b((View.OnClickListener)new WSMsgFragment.setupTopBarController..inlined.apply.lambda.2(this));
  }
  
  private final void a(WSMsgPageData paramWSMsgPageData)
  {
    stMsgRedDotCount localstMsgRedDotCount1 = paramWSMsgPageData.f();
    stMsgRedDotCount localstMsgRedDotCount2 = paramWSMsgPageData.g();
    paramWSMsgPageData = paramWSMsgPageData.h();
    int i1;
    if (localstMsgRedDotCount1 != null) {
      i1 = localstMsgRedDotCount1.count;
    } else {
      i1 = 0;
    }
    int i2;
    if (localstMsgRedDotCount2 != null) {
      i2 = localstMsgRedDotCount2.count;
    } else {
      i2 = 0;
    }
    int i3;
    if (paramWSMsgPageData != null) {
      i3 = paramWSMsgPageData.count;
    } else {
      i3 = 0;
    }
    if (i1 > 0)
    {
      paramWSMsgPageData = this.m;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
      }
      paramWSMsgPageData.setVisibility(0);
      paramWSMsgPageData = this.m;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
      }
      paramWSMsgPageData.setText((CharSequence)String.valueOf(i1));
    }
    else
    {
      paramWSMsgPageData = this.m;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
      }
      paramWSMsgPageData.setVisibility(8);
    }
    if (i2 > 0)
    {
      paramWSMsgPageData = this.n;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
      }
      paramWSMsgPageData.setVisibility(0);
      paramWSMsgPageData = this.n;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
      }
      paramWSMsgPageData.setText((CharSequence)String.valueOf(i2));
    }
    else
    {
      paramWSMsgPageData = this.n;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
      }
      paramWSMsgPageData.setVisibility(8);
    }
    if (i3 > 0)
    {
      paramWSMsgPageData = this.o;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
      }
      paramWSMsgPageData.setVisibility(0);
      paramWSMsgPageData = this.o;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
      }
      paramWSMsgPageData.setText((CharSequence)String.valueOf(i3));
    }
    else
    {
      paramWSMsgPageData = this.o;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
      }
      paramWSMsgPageData.setVisibility(8);
    }
    WSMsgBeaconReport.a(i1, i2, i3);
  }
  
  private final void a(WSMsgSectionData paramWSMsgSectionData)
  {
    Object localObject1 = paramWSMsgSectionData.d();
    if ((localObject1 != null) && (((stNotifyMsg)localObject1).delFlag == 1))
    {
      QQToast.makeText(this.a, 1, 1929838630, 0).show();
      return;
    }
    localObject1 = paramWSMsgSectionData.d();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((stNotifyMsg)localObject1).flag);
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 1))
    {
      QQToast.makeText(this.a, 1, 1929838625, 0).show();
      return;
    }
    if (((localObject1 != null) && (((Integer)localObject1).intValue() == 2)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 8)))
    {
      QQToast.makeText(this.a, 1, 1929838628, 0).show();
      return;
    }
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 4))
    {
      QQToast.makeText(this.a, 1, 1929838629, 0).show();
      return;
    }
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 32))
    {
      QQToast.makeText(this.a, 1, 1929838630, 0).show();
      return;
    }
    Object localObject3 = paramWSMsgSectionData.d();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((stNotifyMsg)localObject3).content;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((stMsgContent)localObject3).schema;
      }
    }
    a((stSchema)localObject1, (WSMsgFragment.SchemeJumpListener)new WSMsgFragment.doJumpAction.1(paramWSMsgSectionData));
  }
  
  private final void b(View paramView)
  {
    paramView = paramView.findViewById(1929707581);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "rootView.findViewById(R.id.top_navigation_bar)");
    this.p = ((WSTopNavigationBar)paramView);
    paramView = this.p;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopNavigationBar");
    }
    this.q = new WSMsgTopBarController(paramView, this);
    paramView = this.q;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopBarController");
    }
    a(paramView);
  }
  
  private final void o()
  {
    WSMsgFragmentPresenter localWSMsgFragmentPresenter = (WSMsgFragmentPresenter)aO_();
    if (localWSMsgFragmentPresenter != null) {
      localWSMsgFragmentPresenter.a(true, true);
    }
  }
  
  private final void p()
  {
    Object localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
    }
    localObject1 = ((WSXRecyclerView)localObject1).getLoadMoreLayoutHelper();
    if (localObject1 != null) {
      ((LoadingMoreHelper)localObject1).setPreLoaderCount(12);
    }
    localObject1 = new LinearLayoutManager(this.a, 1, false);
    Object localObject2 = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext");
    this.h = new WSMsgAdapter((Context)localObject2);
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
    }
    ((WSXRecyclerView)localObject2).setRefreshEnable(false);
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
    }
    ((WSXRecyclerView)localObject2).setIsAutoScrolling(true);
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
    }
    localObject2 = ((WSXRecyclerView)localObject2).getRecyclerView();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "recyclerView");
    WSMsgAdapter localWSMsgAdapter = this.h;
    if (localWSMsgAdapter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    }
    ((RecyclerViewWithHeaderFooter)localObject2).setAdapter((RecyclerView.Adapter)localWSMsgAdapter);
    ((RecyclerViewWithHeaderFooter)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    ((RecyclerViewWithHeaderFooter)localObject2).setItemAnimator((RecyclerView.ItemAnimator)null);
    localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
    }
    ((WSXRecyclerView)localObject1).setRefreshCallback((XRecyclerView.RefreshCallback)new WSMsgFragment.initRecyclerView.1(this));
    localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    }
    ((WSMsgAdapter)localObject1).setOnItemClickListener((BaseAdapter.OnItemClickListener)new WSMsgFragment.initRecyclerView.2(this));
    r();
  }
  
  private final void q()
  {
    WSFrameBeaconReport.a("message");
    WeishiUtils.a((Context)getBaseActivity());
  }
  
  private final void r()
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = t();
    if (localRecyclerViewHeaderViewAdapter != null) {
      localRecyclerViewHeaderViewAdapter.addHeader(s());
    }
  }
  
  private final View s()
  {
    View localView = LayoutInflater.from(this.a).inflate(1929773077, null);
    Intrinsics.checkExpressionValueIsNotNull(localView, "LayoutInflater.from(mCon…shi_message_header, null)");
    Object localObject = localView.findViewById(1929707570);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headerView.findViewById(R.id.rl_msg_like)");
    this.j = ((LinearLayout)localObject);
    localObject = localView.findViewById(1929707569);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headerView.findViewById(R.id.rl_msg_fans)");
    this.k = ((LinearLayout)localObject);
    localObject = localView.findViewById(1929707571);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headerView.findViewById(R.id.rl_msg_private)");
    this.l = ((LinearLayout)localObject);
    localObject = localView.findViewById(1929707592);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headerView.findViewById(R.id.tv_msg_like_num)");
    this.m = ((TextView)localObject);
    localObject = localView.findViewById(1929707591);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headerView.findViewById(R.id.tv_msg_fans_num)");
    this.n = ((TextView)localObject);
    localObject = localView.findViewById(1929707594);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headerView.findViewById(R.id.tv_msg_private_num)");
    this.o = ((TextView)localObject);
    LinearLayout localLinearLayout = this.j;
    if (localLinearLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRlLike");
    }
    localObject = (View.OnClickListener)this;
    localLinearLayout.setOnClickListener((View.OnClickListener)localObject);
    localLinearLayout = this.k;
    if (localLinearLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRlFans");
    }
    localLinearLayout.setOnClickListener((View.OnClickListener)localObject);
    localLinearLayout = this.l;
    if (localLinearLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRlMsgPrivate");
    }
    localLinearLayout.setOnClickListener((View.OnClickListener)localObject);
    return localView;
  }
  
  private final RecyclerViewHeaderViewAdapter<?> t()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
    }
    localObject = ((WSXRecyclerView)localObject).getRecyclerView();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mXRecyclerView.recyclerView");
    localObject = ((RecyclerViewWithHeaderFooter)localObject).getAdapter();
    if (localObject != null) {
      return (RecyclerViewHeaderViewAdapter)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter<*>");
  }
  
  private final void u()
  {
    WSSwipeRefreshLayout localWSSwipeRefreshLayout = this.f;
    if (localWSSwipeRefreshLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSwipeRefreshView");
    }
    localWSSwipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)this);
    localWSSwipeRefreshLayout = this.f;
    if (localWSSwipeRefreshLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSwipeRefreshView");
    }
    localWSSwipeRefreshLayout.setOnInterceptTouchEventListener((WSSwipeRefreshLayout.OnInterceptTouchEventListener)new WSMsgFragment.initSwipeRefreshLayout.1(this));
  }
  
  private final void v()
  {
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    }
    if (((WSMsgAdapter)localObject).getFooterExtraViewCount() > 0) {
      return;
    }
    localObject = LayoutInflater.from(this.a).inflate(2131626456, null);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "footerView");
    ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((TextView)((View)localObject).findViewById(2131436034)).setText(1929838631);
    WSMsgAdapter localWSMsgAdapter = this.h;
    if (localWSMsgAdapter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    }
    localWSMsgAdapter.addFooterView((View)localObject);
  }
  
  public void a(int paramInt, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    if (paramBoolean)
    {
      paramString = this.h;
      if (paramString == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
      }
      if (paramString.getDataList().size() == 0)
      {
        paramString = this.i;
        if (paramString == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        }
        paramString.setVisibility(0);
        paramString = this.g;
        if (paramString == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
        }
        paramString.loadMoreComplete(false, false);
      }
    }
  }
  
  public void a(@NotNull WSMsgPageData paramWSMsgPageData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intrinsics.checkParameterIsNotNull(paramWSMsgPageData, "pageData");
    Object localObject;
    if (((paramBoolean2) || (paramBoolean1)) && (paramWSMsgPageData.e().size() == 0))
    {
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
      }
      ((TextView)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
      }
      ((TextView)localObject).setVisibility(8);
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
      }
      ((WSMsgAdapter)localObject).appendList(paramWSMsgPageData.e());
    }
    else
    {
      a(paramWSMsgPageData);
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
      }
      ((WSMsgAdapter)localObject).fillList(paramWSMsgPageData.e());
      paramWSMsgPageData = this.g;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
      }
      paramWSMsgPageData.backToTopAtOnce();
    }
    paramWSMsgPageData = this.g;
    if (paramWSMsgPageData == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
    }
    paramWSMsgPageData.loadMoreComplete(true, paramBoolean3);
    if (!paramBoolean3)
    {
      paramWSMsgPageData = this.h;
      if (paramWSMsgPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
      }
      if (paramWSMsgPageData.getDataList().size() > 0) {
        v();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      WSPublicAccReport.getInstance().reportPageVisitEnter("message");
      return;
    }
    WSPublicAccReport.getInstance().reportPageVisitExit("message");
  }
  
  public void aJ_()
  {
    WSSwipeRefreshLayout localWSSwipeRefreshLayout = this.f;
    if (localWSSwipeRefreshLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSwipeRefreshView");
    }
    localWSSwipeRefreshLayout.setRefreshing(false);
  }
  
  @NotNull
  public WSMsgFragmentPresenter n()
  {
    return new WSMsgFragmentPresenter();
  }
  
  public void onClick(@Nullable View paramView)
  {
    WSMsgPageData localWSMsgPageData = ((WSMsgFragmentPresenter)aO_()).a();
    TextView localTextView = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 1929707570))
    {
      if (localWSMsgPageData != null) {
        paramView = localWSMsgPageData.f();
      } else {
        paramView = null;
      }
      localTextView = this.m;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
      }
      localTextView.setVisibility(8);
      if (paramView != null) {
        localObject1 = paramView.schema;
      }
      a((stSchema)localObject1, (WSMsgFragment.SchemeJumpListener)new WSMsgFragment.onClick.1(paramView));
      return;
    }
    if ((paramView != null) && (paramView.intValue() == 1929707569))
    {
      if (localWSMsgPageData != null) {
        paramView = localWSMsgPageData.g();
      } else {
        paramView = null;
      }
      localObject1 = this.n;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = localTextView;
      if (paramView != null) {
        localObject1 = paramView.schema;
      }
      a((stSchema)localObject1, (WSMsgFragment.SchemeJumpListener)new WSMsgFragment.onClick.2(paramView));
      return;
    }
    if (paramView == null) {
      return;
    }
    if (paramView.intValue() == 1929707571)
    {
      if (localWSMsgPageData != null) {
        paramView = localWSMsgPageData.h();
      } else {
        paramView = null;
      }
      localObject1 = this.o;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = localObject2;
      if (paramView != null) {
        localObject1 = paramView.schema;
      }
      a((stSchema)localObject1, (WSMsgFragment.SchemeJumpListener)new WSMsgFragment.onClick.3(paramView));
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(1929773068, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…essage, container, false)");
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onRefresh()
  {
    ((WSMsgFragmentPresenter)aO_()).a(false, true);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      a(true);
      o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment
 * JD-Core Version:    0.7.0.1
 */