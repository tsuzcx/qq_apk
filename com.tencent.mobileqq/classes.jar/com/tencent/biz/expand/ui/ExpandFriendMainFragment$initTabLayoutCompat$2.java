package com.tencent.biz.expand.ui;

import com.tencent.biz.expand.widget.ExpandTabLayout.OnTabClickListener;
import com.tencent.biz.expand.widget.ExpandTabLayout.Tab;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandFriendMainFragment$initTabLayoutCompat$2", "Lcom/tencent/biz/expand/widget/ExpandTabLayout$OnTabClickListener;", "onTabClick", "", "tab", "Lcom/tencent/biz/expand/widget/ExpandTabLayout$Tab;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFriendMainFragment$initTabLayoutCompat$2
  implements ExpandTabLayout.OnTabClickListener
{
  public void a(@NotNull ExpandTabLayout.Tab paramTab)
  {
    Intrinsics.checkParameterIsNotNull(paramTab, "tab");
    ExpandFriendMainFragment.a(this.a).setCurrentItem(paramTab.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandFriendMainFragment.initTabLayoutCompat.2
 * JD-Core Version:    0.7.0.1
 */