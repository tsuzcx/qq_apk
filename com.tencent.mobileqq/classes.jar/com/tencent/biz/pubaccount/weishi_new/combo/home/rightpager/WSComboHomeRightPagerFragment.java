package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightPagerFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/WSBaseFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightPagerContainer$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightPagerContainer$Presenter;", "()V", "comboMainPageChangeReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightForMainChangeReceiver;", "viewPager", "Lcom/tencent/biz/pubaccount/weishi_new/view/WSViewPager;", "createPagerFragment", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "bundle", "Landroid/os/Bundle;", "createPresenter", "initEvent", "", "initView", "rootView", "Landroid/view/View;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "setCanScrollHorizontally", "canScrollHorizontally", "", "setupViewPager", "switchFragment", "position", "unRegisterEventReceiver", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomeRightPagerFragment
  extends WSBaseFragment<WSComboHomeRightPagerContainer.View, WSComboHomeRightPagerContainer.Presenter>
  implements WSComboHomeRightPagerContainer.View
{
  public static final WSComboHomeRightPagerFragment.Companion f = new WSComboHomeRightPagerFragment.Companion(null);
  private WSViewPager g;
  private WSComboHomeRightForMainChangeReceiver h;
  
  private final List<QBaseFragment> a(Bundle paramBundle)
  {
    return (List)((WSComboHomeRightPagerContainer.Presenter)aO_()).a().a(paramBundle);
  }
  
  private final void a(View paramView)
  {
    paramView = (WSViewPager)paramView.findViewById(1929707621);
    this.g = paramView;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "wsViewPager");
    a(paramView);
  }
  
  private final void a(WSViewPager paramWSViewPager)
  {
    paramWSViewPager.setAdapter((PagerAdapter)new WSFragmentAdapter(getChildFragmentManager(), a(getArguments())));
    paramWSViewPager.setCurrentItem(((WSComboHomeRightPagerContainer.Presenter)aO_()).c(), false);
    paramWSViewPager.setOffscreenPageLimit(((WSComboHomeRightPagerContainer.Presenter)aO_()).b());
    paramWSViewPager.setScrollable(false);
    paramWSViewPager.setCanScrollHorizontally(false);
  }
  
  private final void o()
  {
    WSComboHomeRightForMainChangeReceiver localWSComboHomeRightForMainChangeReceiver = new WSComboHomeRightForMainChangeReceiver(this);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)localWSComboHomeRightForMainChangeReceiver);
    this.h = localWSComboHomeRightForMainChangeReceiver;
  }
  
  private final void p()
  {
    WSSimpleEventBus localWSSimpleEventBus = WSSimpleEventBus.a();
    WSComboHomeRightForMainChangeReceiver localWSComboHomeRightForMainChangeReceiver = this.h;
    if (localWSComboHomeRightForMainChangeReceiver == null) {
      Intrinsics.throwUninitializedPropertyAccessException("comboMainPageChangeReceiver");
    }
    localWSSimpleEventBus.b((WSSimpleEventReceiver)localWSComboHomeRightForMainChangeReceiver);
  }
  
  public void a(int paramInt)
  {
    WSViewPager localWSViewPager = this.g;
    if (localWSViewPager != null) {
      localWSViewPager.setCurrentItem(paramInt, false);
    }
  }
  
  @NotNull
  public WSComboHomeRightPagerContainer.Presenter n()
  {
    return (WSComboHomeRightPagerContainer.Presenter)new WSComboHomeRightPresenter();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((WSViewPager)localObject).getAdapter();
      if (localObject != null)
      {
        localObject = (WSFragmentAdapter)localObject;
        int j = ((WSFragmentAdapter)localObject).getCount() - 1;
        int i = 0;
        if (j >= 0) {
          for (;;)
          {
            ((WSFragmentAdapter)localObject).a(i).onActivityResult(paramInt1, paramInt2, paramIntent);
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter");
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o();
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(1929773066, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…tainer, container, false)");
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboHomeRightPagerFragment
 * JD-Core Version:    0.7.0.1
 */