package com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mvvm.ResourcesExtKt;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/WSBottomBarNormalHolder;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/AbsWSBottomBarHolder;", "adapter", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;", "parent", "Landroid/view/ViewGroup;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;Landroid/view/ViewGroup;)V", "redDot", "Landroid/view/View;", "tvBarName", "Landroid/widget/TextView;", "getColorCompat", "Landroid/content/res/ColorStateList;", "color", "", "onBindData", "", "info", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "position", "updateUIByBarStyle", "barStyle", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomBarNormalHolder
  extends AbsWSBottomBarHolder
{
  public static final WSBottomBarNormalHolder.Companion c = new WSBottomBarNormalHolder.Companion(null);
  private TextView d = (TextView)c(1929707582);
  private View e = c(1929707548);
  
  public WSBottomBarNormalHolder(@NotNull WSBottomBarAdapter paramWSBottomBarAdapter, @NotNull ViewGroup paramViewGroup)
  {
    super(paramWSBottomBarAdapter, paramViewGroup, 1929773057);
  }
  
  private final void d(int paramInt)
  {
    TextView localTextView;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      localTextView = this.d;
      if (localTextView != null) {
        localTextView.setTextColor(e(1929510916));
      }
    }
    else
    {
      localTextView = this.d;
      if (localTextView != null) {
        localTextView.setTextColor(e(1929510915));
      }
    }
  }
  
  private final ColorStateList e(@ColorRes int paramInt)
  {
    Object localObject = BaseApplicationImpl.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getContext()");
    localObject = ((BaseApplication)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getContext().resources");
    return ResourcesExtKt.c((Resources)localObject, paramInt);
  }
  
  public void a(@NotNull WSBottomBarInfo paramWSBottomBarInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSBottomBarInfo, "info");
    d(paramWSBottomBarInfo.d());
    Object localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setSelected(paramWSBottomBarInfo.a());
    }
    localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramWSBottomBarInfo.h());
    }
    localObject = this.e;
    if (localObject != null)
    {
      if (paramWSBottomBarInfo.b() > 0) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      ((View)localObject).setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder.WSBottomBarNormalHolder
 * JD-Core Version:    0.7.0.1
 */