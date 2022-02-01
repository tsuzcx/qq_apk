package com.tencent.falco.base.floatwindow.widget.activityfloat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/activityfloat/FloatingView;", "Lcom/tencent/falco/base/floatwindow/widget/activityfloat/AbstractDragFloatingView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getLayoutId", "", "()Ljava/lang/Integer;", "renderView", "", "view", "Landroid/view/View;", "setFloatConfig", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FloatingView
  extends AbstractDragFloatingView
{
  private HashMap _$_findViewCache;
  
  public FloatingView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this._$_findViewCache;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @Nullable
  public Integer getLayoutId()
  {
    return Integer.valueOf(getConfig().layoutId);
  }
  
  public void renderView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public final void setFloatConfig(@NotNull FloatWindowConfig paramFloatWindowConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatWindowConfig, "config");
    setConfig(paramFloatWindowConfig);
    paramFloatWindowConfig = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramFloatWindowConfig, "context");
    initView(paramFloatWindowConfig);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.activityfloat.FloatingView
 * JD-Core Version:    0.7.0.1
 */