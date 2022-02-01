package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel$PanelPageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel;)V", "pageCache", "", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEGridView;", "getPageCache", "()Ljava/util/Map;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getAdapterAt", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialAdapter;", "getCategoryAt", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "getCount", "getGridViewAt", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "preloadCurrentView", "refreshPageCache", "refreshPageCacheAt", "aelight_impl_release"}, k=1, mv={1, 1, 16})
final class AENewMaterialPanel$PanelPageAdapter
  extends PagerAdapter
{
  @NotNull
  private final Map<Integer, AEGridView> b = (Map)new LinkedHashMap();
  
  public final void a()
  {
    Iterator localIterator = ((Iterable)this.b.keySet()).iterator();
    while (localIterator.hasNext()) {
      a(((Number)localIterator.next()).intValue());
    }
  }
  
  public final void a(int paramInt)
  {
    AENewMaterialAdapter localAENewMaterialAdapter = d(paramInt);
    if (localAENewMaterialAdapter != null)
    {
      Object localObject = c(paramInt);
      localAENewMaterialAdapter.a((AEMaterialCategory)localObject);
      if (localObject != null)
      {
        localObject = ((AEMaterialCategory)localObject).a;
        if (localObject != null) {}
      }
      else
      {
        localObject = CollectionsKt.emptyList();
      }
      localAENewMaterialAdapter.a((List)localObject);
    }
  }
  
  @Nullable
  public final AEGridView b(int paramInt)
  {
    return (AEGridView)this.b.get(Integer.valueOf(paramInt));
  }
  
  @Nullable
  public final AEMaterialCategory c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < AENewMaterialPanel.a(this.a).size())) {
      return (AEMaterialCategory)AENewMaterialPanel.a(this.a).get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public final AENewMaterialAdapter d(int paramInt)
  {
    Object localObject1 = (AEGridView)this.b.get(Integer.valueOf(paramInt));
    if (localObject1 != null) {
      localObject1 = ((AEGridView)localObject1).getAdapter();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof AENewMaterialAdapter)) {
      localObject2 = null;
    }
    return (AENewMaterialAdapter)localObject2;
  }
  
  public void destroyItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public final void e(int paramInt)
  {
    if ((AEGridView)this.b.get(Integer.valueOf(paramInt)) == null)
    {
      AEGridView localAEGridView = new AEGridView(this.a.getContext());
      this.b.put(Integer.valueOf(paramInt), localAEGridView);
      Context localContext = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localAEGridView.setAdapter((RecyclerView.Adapter)new AENewMaterialAdapter(localContext, AENewMaterialPanel.b(this.a), AENewMaterialPanel.c(this.a)));
    }
  }
  
  public int getCount()
  {
    return AENewMaterialPanel.a(this.a).size();
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Object localObject2 = (AEGridView)this.b.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new AEGridView(this.a.getContext());
      this.b.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
      ((AEGridView)localObject1).setAdapter((RecyclerView.Adapter)new AENewMaterialAdapter((Context)localObject2, AENewMaterialPanel.b(this.a), AENewMaterialPanel.c(this.a)));
    }
    if ((((AEGridView)localObject1).getParent() instanceof ViewGroup))
    {
      localObject2 = ((AEGridView)localObject1).getParent();
      if (localObject2 != null) {
        ((ViewGroup)localObject2).removeView((View)localObject1);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    paramViewGroup.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
    return localObject1;
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    return Intrinsics.areEqual(paramView, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.PanelPageAdapter
 * JD-Core Version:    0.7.0.1
 */