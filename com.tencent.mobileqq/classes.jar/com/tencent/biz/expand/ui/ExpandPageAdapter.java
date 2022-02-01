package com.tencent.biz.expand.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandPageAdapter;", "Landroid/support/v4/app/FragmentPagerAdapter;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "fm", "Landroid/support/v4/app/FragmentManager;", "(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/support/v4/app/FragmentManager;)V", "getActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "getCount", "", "getItem", "Landroid/support/v4/app/Fragment;", "position", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandPageAdapter
  extends FragmentPagerAdapter
{
  @NotNull
  private final BaseActivity a;
  
  public ExpandPageAdapter(@NotNull BaseActivity paramBaseActivity, @NotNull FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.a = paramBaseActivity;
  }
  
  public int getCount()
  {
    return 5;
  }
  
  @NotNull
  public Fragment getItem(int paramInt)
  {
    if (paramInt == 0) {
      return (Fragment)ExpandDebugFragment.a.a(this.a);
    }
    if (1 > paramInt) {}
    while (3 < paramInt) {
      return (Fragment)ExpandFriendSubFragment.a.a(this.a, "LastTab [" + paramInt + ']');
    }
    return (Fragment)ExpandFriendSubFragment.a.a(this.a, String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPageAdapter
 * JD-Core Version:    0.7.0.1
 */