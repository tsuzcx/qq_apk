package com.tencent.biz.pubaccount.weishi_new.main;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.app.QBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/main/WSRightContainerFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "()V", "mProfileFragment", "Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileFragment;", "mRootView", "Landroid/view/View;", "getProfileBundle", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onPageSelected", "", "isSelectedByClickAvatar", "", "onPageUnselected", "onParentPageSelected", "isNotAdType", "data", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "onViewCreated", "view", "replaceFragment", "fragment", "setUserVisibleHint", "isVisibleToUser", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRightContainerFragment
  extends QBaseFragment
{
  public static final WSRightContainerFragment.Companion a = new WSRightContainerFragment.Companion(null);
  private View b;
  private WSProfileFragment c;
  
  private final void a(QBaseFragment paramQBaseFragment)
  {
    getChildFragmentManager().beginTransaction().replace(1929707536, (Fragment)paramQBaseFragment).commitNowAllowingStateLoss();
  }
  
  @JvmStatic
  @NotNull
  public static final WSRightContainerFragment b()
  {
    return a.a();
  }
  
  private final Bundle c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("page_type", 3);
    localBundle.putString("from", "main");
    return localBundle;
  }
  
  public final void a()
  {
    WSProfileFragment localWSProfileFragment = this.c;
    if (localWSProfileFragment != null) {
      localWSProfileFragment.n();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    WSProfileFragment localWSProfileFragment = this.c;
    if (localWSProfileFragment != null) {
      localWSProfileFragment.e(paramBoolean);
    }
  }
  
  public final void a(boolean paramBoolean, @NotNull WSVerticalItemData paramWSVerticalItemData)
  {
    Intrinsics.checkParameterIsNotNull(paramWSVerticalItemData, "data");
    WSProfileFragment localWSProfileFragment = this.c;
    if (localWSProfileFragment != null)
    {
      a((QBaseFragment)localWSProfileFragment);
      localWSProfileFragment.a(paramWSVerticalItemData.b().poster, paramWSVerticalItemData.b().id);
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(1929773073, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…agment, container, false)");
    this.b = paramLayoutInflater;
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    return paramLayoutInflater;
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = WSProfileFragment.a(c());
    Intrinsics.checkExpressionValueIsNotNull(paramView, "WSProfileFragment.create(getProfileBundle())");
    this.c = paramView;
    a((QBaseFragment)paramView);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    WSProfileFragment localWSProfileFragment = this.c;
    if (localWSProfileFragment != null) {
      localWSProfileFragment.setUserVisibleHint(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSRightContainerFragment
 * JD-Core Version:    0.7.0.1
 */