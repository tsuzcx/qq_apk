package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder;", "", "context", "Landroid/content/Context;", "container", "Landroid/view/ViewGroup;", "listener", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$ItemClickListener;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$ItemClickListener;)V", "adapter", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListAdapter;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "refreshList", "", "scrollToTarget", "", "scrollItemToCenter", "position", "", "scrollTo", "id", "", "smoothly", "scrollToSelect", "setData", "data", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "setSelectItem", "scrollTarget", "setSelectNone", "Companion", "ItemClickListener", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEEffectListHolder
{
  public static final DYAEEffectListHolder.Companion a = new DYAEEffectListHolder.Companion(null);
  private final RecyclerView b;
  private final DYAEEffectListAdapter c;
  private final RecyclerView.SmoothScroller d;
  private final Context e;
  private final ViewGroup f;
  private final DYAEEffectListHolder.ItemClickListener g;
  
  public DYAEEffectListHolder(@NotNull Context paramContext, @NotNull ViewGroup paramViewGroup, @NotNull DYAEEffectListHolder.ItemClickListener paramItemClickListener)
  {
    this.e = paramContext;
    this.f = paramViewGroup;
    this.g = paramItemClickListener;
    int i = DYAEEffectListHolder.Companion.a(a, 17.0F, this.e);
    int j = DYAEEffectListHolder.Companion.a(a, 0.0F, this.e);
    this.d = ((RecyclerView.SmoothScroller)new CenterSmoothScroller(this.e));
    this.b = new RecyclerView(this.e);
    this.b.setPadding(i, 0, i, 0);
    this.b.setClipToPadding(false);
    this.b.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.e, 0, false));
    paramViewGroup = this.b.getItemAnimator();
    paramContext = paramViewGroup;
    if (!(paramViewGroup instanceof SimpleItemAnimator)) {
      paramContext = null;
    }
    paramContext = (SimpleItemAnimator)paramContext;
    if (paramContext != null) {
      paramContext.setSupportsChangeAnimations(false);
    }
    this.c = new DYAEEffectListAdapter(this.e, (Function3)new DYAEEffectListHolder.1(this));
    this.b.setAdapter((RecyclerView.Adapter)this.c);
    this.b.addItemDecoration((RecyclerView.ItemDecoration)new MarginItemDecoration(DYAEEffectListHolder.Companion.a(a, 12.0F, this.e)));
    paramContext = new ViewGroup.MarginLayoutParams(-1, -2);
    paramContext.topMargin = j;
    this.f.addView((View)this.b, (ViewGroup.LayoutParams)paramContext);
  }
  
  private final void a(int paramInt)
  {
    this.b.post((Runnable)new DYAEEffectListHolder.scrollItemToCenter.1(this, paramInt));
  }
  
  public final void a()
  {
    if (((((Collection)this.c.b()).isEmpty() ^ true)) && (DYAEEffectItemExtKt.a(this.c.b().get(0))))
    {
      a(this, ((DYAEEffectItem)this.c.b().get(0)).a(), false, 2, null);
      return;
    }
    a(this, null, false, 2, null);
  }
  
  public final void a(@Nullable String paramString, boolean paramBoolean)
  {
    Object localObject = this.c.a();
    if (localObject != null) {
      localObject = ((DYAEEffectItem)localObject).a();
    } else {
      localObject = null;
    }
    if (Intrinsics.areEqual(paramString, localObject)) {
      return;
    }
    DYAEEffectListAdapter localDYAEEffectListAdapter = this.c;
    Iterator localIterator = ((Iterable)localDYAEEffectListAdapter.b()).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(((DYAEEffectItem)localObject).a(), paramString))
      {
        paramString = (String)localObject;
        break label91;
      }
    }
    paramString = null;
    label91:
    localDYAEEffectListAdapter.a((DYAEEffectItem)paramString);
    this.c.notifyDataSetChanged();
    if (paramBoolean)
    {
      paramString = this.c.a();
      if (paramString != null) {
        paramString = paramString.a();
      } else {
        paramString = null;
      }
      b(this, paramString, false, 2, null);
    }
  }
  
  public final void a(@NotNull List<? extends DYAEEffectItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    this.c.a(paramList);
    this.c.notifyDataSetChanged();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.notifyDataSetChanged();
    if (paramBoolean)
    {
      Object localObject = this.c.a();
      if (localObject != null) {
        localObject = ((DYAEEffectItem)localObject).a();
      } else {
        localObject = null;
      }
      b((String)localObject, false);
    }
  }
  
  public final void b()
  {
    Object localObject = this.c.a();
    if (localObject != null) {
      localObject = ((DYAEEffectItem)localObject).a();
    } else {
      localObject = null;
    }
    b(this, (String)localObject, false, 2, null);
  }
  
  public final void b(@Nullable String paramString, boolean paramBoolean)
  {
    int i;
    if (paramString == null)
    {
      i = 0;
    }
    else
    {
      Iterator localIterator = this.c.b().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        if (Intrinsics.areEqual(((DYAEEffectItem)localIterator.next()).a(), paramString)) {
          break label67;
        }
        i += 1;
      }
      i = -1;
    }
    label67:
    int j = i;
    if (i < 0) {
      j = 0;
    }
    if (paramBoolean)
    {
      a(j);
      return;
    }
    this.b.scrollToPosition(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder
 * JD-Core Version:    0.7.0.1
 */