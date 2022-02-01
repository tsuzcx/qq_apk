package com.tencent.luggage.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaPreviewImageUI$onCreate$2", "Landroidx/viewpager/widget/PagerAdapter;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaPreviewImageUI$e
  extends PagerAdapter
{
  public void destroyItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    paramViewGroup.removeView((View)WxaPreviewImageUI.b(this.a).get(paramInt));
  }
  
  public int getCount()
  {
    ArrayList localArrayList = WxaPreviewImageUI.a(this.a);
    if (localArrayList == null) {
      Intrinsics.throwNpe();
    }
    return localArrayList.size();
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    paramViewGroup.addView((View)WxaPreviewImageUI.b(this.a).get(paramInt));
    paramViewGroup = WxaPreviewImageUI.b(this.a).get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mViews[position]");
    return paramViewGroup;
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    return Intrinsics.areEqual(paramObject, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.e
 * JD-Core Version:    0.7.0.1
 */