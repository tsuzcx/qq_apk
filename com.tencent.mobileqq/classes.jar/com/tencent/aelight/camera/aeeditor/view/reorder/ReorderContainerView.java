package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "adapter", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "getAdapter", "()Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dragUUID", "dragViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemTouchHelper", "Lcom/tencent/widget/itemtouchhelper/ItemTouchHelper;", "linearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "reorderListener", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderListener;", "getReorderListener", "()Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderListener;", "setReorderListener", "(Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderListener;)V", "screenWidth", "getScreenWidth", "()I", "screenWidth$delegate", "targetIndex", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initial", "", "scrollToTarget", "uuid", "point", "Landroid/graphics/Point;", "startDrag", "index", "submitList", "data", "", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/CutModelKt;", "SpacingAdapter", "SpacingVH", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView
  extends RecyclerView
{
  private final String a = "ReorderContainerView";
  private final Lazy b = LazyKt.lazy((Function0)ReorderContainerView.adapter.2.INSTANCE);
  private final Lazy c;
  private final LinearLayoutManager d;
  @Nullable
  private ReorderListener e;
  private ItemTouchHelper f;
  private int g;
  private String h;
  private RecyclerView.ViewHolder i;
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = LazyKt.lazy((Function0)new ReorderContainerView.screenWidth.2(paramContext));
    this.d = new LinearLayoutManager(paramContext, 0, false);
    this.g = -1;
  }
  
  private final ReorderContainerView.SpacingAdapter getAdapter()
  {
    return (ReorderContainerView.SpacingAdapter)this.b.getValue();
  }
  
  private final int getScreenWidth()
  {
    return ((Number)this.c.getValue()).intValue();
  }
  
  public final int a(@NotNull String paramString, @NotNull Point paramPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Intrinsics.checkParameterIsNotNull(paramPoint, "point");
    this.h = paramString;
    int j = getAdapter().a(paramString);
    int k = paramPoint.x;
    int m = ViewUtils.dip2px(-45.0F);
    this.d.scrollToPositionWithOffset(j + 1, k + m);
    return j;
  }
  
  public final void a()
  {
    setLayoutManager((RecyclerView.LayoutManager)this.d);
    setAdapter((RecyclerView.Adapter)getAdapter());
    addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(getResources().getDimensionPixelSize(2063859756)));
    this.f = new ItemTouchHelper((ItemTouchHelper.Callback)new ReorderContainerView.initial.itemTouchCallback.1(this, 51, 0));
    ItemTouchHelper localItemTouchHelper = this.f;
    if (localItemTouchHelper != null) {
      localItemTouchHelper.attachToRecyclerView((RecyclerView)this);
    }
  }
  
  public final void a(int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startDrag() called with: index = [");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(']');
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = findViewHolderForLayoutPosition(paramInt + 1);
    if (localObject1 != null)
    {
      localObject2 = this.f;
      if (localObject2 != null) {
        ((ItemTouchHelper)localObject2).startDrag((RecyclerView.ViewHolder)localObject1);
      }
      AEQLog.b(this.a, "startDrag() called with: vh = [$]");
    }
  }
  
  public final void a(@NotNull List<CutModelKt> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    getAdapter().a(paramList);
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchTouchEvent: width: ");
    localStringBuilder.append(getWidth());
    localStringBuilder.append(", height: ");
    localStringBuilder.append(getHeight());
    AEQLog.a(str, localStringBuilder.toString());
    str = this.a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchTouchEvent() called with: ev = [");
    localStringBuilder.append(paramMotionEvent);
    localStringBuilder.append(']');
    AEQLog.b(str, localStringBuilder.toString());
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @Nullable
  public final ReorderListener getReorderListener()
  {
    return this.e;
  }
  
  public final void setReorderListener(@Nullable ReorderListener paramReorderListener)
  {
    this.e = paramReorderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView
 * JD-Core Version:    0.7.0.1
 */