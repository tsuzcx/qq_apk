package com.tencent.biz.expand.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.expand.utils.ActivityExtUtils;
import com.tencent.biz.expand.widget.ExpandTabLayout;
import com.tencent.biz.expand.widget.ExpandTabLayout.OnTabClickListener;
import com.tencent.biz.expand.widget.ExpandTabLayout.Tab;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandFriendMainFragment;", "Lcom/tencent/mobileqq/extendfriend/fragment/ExtendFriendBaseFragment;", "()V", "TAG", "", "tabLayout", "Lcom/tencent/biz/expand/widget/ExpandTabLayout;", "tabs", "", "Lcom/tencent/biz/expand/widget/ExpandTabLayout$Tab;", "viewPager", "Lcom/tencent/biz/expand/ui/ExpandFragmentViewPager;", "getGestureLayout", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "initTabLayoutCompat", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFriendMainFragment
  extends ExtendFriendBaseFragment
{
  public static final ExpandFriendMainFragment.Companion a;
  private ExpandFragmentViewPager jdField_a_of_type_ComTencentBizExpandUiExpandFragmentViewPager;
  private ExpandTabLayout jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List<ExpandTabLayout.Tab> jdField_a_of_type_JavaUtilList;
  private final String d = "ExtendFriendFragment";
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandUiExpandFriendMainFragment$Companion = new ExpandFriendMainFragment.Companion(null);
  }
  
  private final TopGestureLayout a()
  {
    TopGestureLayout localTopGestureLayout = (TopGestureLayout)null;
    Object localObject1 = getActivity().getWindow().getDecorView();
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    Object localObject2 = (ViewGroup)localObject1;
    View localView = ((ViewGroup)localObject2).getChildAt(0);
    localObject1 = localObject2;
    if (localView != null)
    {
      localObject1 = localObject2;
      if ((localView instanceof DragFrameLayout)) {
        localObject1 = (ViewGroup)localView;
      }
    }
    localObject2 = ((ViewGroup)localObject1).getChildAt(0);
    localObject1 = localTopGestureLayout;
    if ((localObject2 instanceof TopGestureLayout)) {
      localObject1 = (TopGestureLayout)localObject2;
    }
    return localObject1;
  }
  
  private final void n()
  {
    Object localObject1 = (List)new ArrayList();
    Object localObject3 = (Iterable)new IntRange(0, 2);
    Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    int i;
    while (((Iterator)localObject3).hasNext())
    {
      i = ((IntIterator)localObject3).nextInt();
      ((Collection)localObject2).add("标签 " + i);
    }
    ((List)localObject1).addAll((Collection)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    ((ExpandTabLayout)localObject2).setTabClickListener((ExpandTabLayout.OnTabClickListener)new ExpandFriendMainFragment.initTabLayoutCompat.2(this));
    localObject2 = this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localObject1 = (Collection)localObject1;
    localObject3 = this.jdField_a_of_type_ComTencentBizExpandUiExpandFragmentViewPager;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    ((ExpandTabLayout)localObject2).a((Collection)localObject1, ((ExpandFragmentViewPager)localObject3).getCurrentItem());
    localObject1 = this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localObject2 = (Iterable)RangesKt.until(0, ((ExpandTabLayout)localObject1).a());
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      i = ((IntIterator)localObject2).nextInt();
      localObject3 = this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout;
      if (localObject3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
      }
      ((Collection)localObject1).add(((ExpandTabLayout)localObject3).a(i));
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @NotNull ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    paramBundle = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "activity");
    ActivityExtUtils.a((BaseActivity)paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561219, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131381672);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "rootView.findViewById(R.id.viewpager)");
    this.jdField_a_of_type_ComTencentBizExpandUiExpandFragmentViewPager = ((ExpandFragmentViewPager)paramViewGroup);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizExpandUiExpandFragmentViewPager;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    paramBundle = getActivity();
    if (paramBundle == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
    }
    paramBundle = (BaseActivity)paramBundle;
    FragmentManager localFragmentManager = getChildFragmentManager();
    Intrinsics.checkExpressionValueIsNotNull(localFragmentManager, "childFragmentManager");
    paramViewGroup.setAdapter((PagerAdapter)new ExpandPageAdapter(paramBundle, localFragmentManager));
    paramViewGroup = paramLayoutInflater.findViewById(2131382032);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "rootView.findViewById(R.id.ws_tab_layout_compat)");
    this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout = ((ExpandTabLayout)paramViewGroup);
    n();
    paramViewGroup = this.jdField_a_of_type_ComTencentBizExpandUiExpandFragmentViewPager;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    paramViewGroup.a((ViewPager.OnPageChangeListener)new ExpandFriendMainFragment.onCreateView.1(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onStart()
  {
    super.onStart();
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandFriendMainFragment
 * JD-Core Version:    0.7.0.1
 */