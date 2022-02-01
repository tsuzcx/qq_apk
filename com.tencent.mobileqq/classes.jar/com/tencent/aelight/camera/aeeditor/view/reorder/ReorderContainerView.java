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
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "adapter", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "getAdapter", "()Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dragUUID", "dragViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemTouchHelper", "Lcom/tencent/widget/itemtouchhelper/ItemTouchHelper;", "linearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "reorderListener", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderListener;", "getReorderListener", "()Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderListener;", "setReorderListener", "(Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderListener;)V", "screenWidth", "getScreenWidth", "()I", "screenWidth$delegate", "targetIndex", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initial", "", "scrollToTarget", "uuid", "point", "Landroid/graphics/Point;", "startDrag", "index", "submitList", "data", "", "Lcom/tencent/weseevideo/camera/mvauto/redo/CutModelKt;", "SpacingAdapter", "SpacingVH", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private final LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  @Nullable
  private ReorderListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderListener;
  private ItemTouchHelper jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
  private final String jdField_a_of_type_JavaLangString = "ReorderContainerView";
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)ReorderContainerView.adapter.2.INSTANCE);
  private String jdField_b_of_type_JavaLangString;
  private final Lazy jdField_b_of_type_KotlinLazy;
  
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
    this.jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new ReorderContainerView.screenWidth.2(paramContext));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_Int = -1;
  }
  
  private final ReorderContainerView.SpacingAdapter a()
  {
    return (ReorderContainerView.SpacingAdapter)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  public final int a(@NotNull String paramString, @NotNull Point paramPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Intrinsics.checkParameterIsNotNull(paramPoint, "point");
    this.jdField_b_of_type_JavaLangString = paramString;
    int i = a().a(paramString);
    int j = paramPoint.x;
    int k = ViewUtils.dip2px(-45.0F);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPositionWithOffset(i + 1, j + k);
    return i;
  }
  
  @Nullable
  public final ReorderListener a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderListener;
  }
  
  public final void a()
  {
    setLayoutManager((RecyclerView.LayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setAdapter((RecyclerView.Adapter)a());
    addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(getResources().getDimensionPixelSize(2063990829)));
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper = new ItemTouchHelper((ItemTouchHelper.Callback)new ReorderContainerView.initial.itemTouchCallback.1(this, 51, 0));
    ItemTouchHelper localItemTouchHelper = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
    if (localItemTouchHelper != null) {
      localItemTouchHelper.attachToRecyclerView((RecyclerView)this);
    }
  }
  
  public final void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startDrag() called with: index = [");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(']');
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = findViewHolderForLayoutPosition(paramInt + 1);
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
      if (localObject2 != null) {
        ((ItemTouchHelper)localObject2).startDrag((RecyclerView.ViewHolder)localObject1);
      }
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "startDrag() called with: vh = [$]");
    }
  }
  
  public final void a(@NotNull List<CutModelKt> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    a().a(paramList);
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchTouchEvent: width: ");
    localStringBuilder.append(getWidth());
    localStringBuilder.append(", height: ");
    localStringBuilder.append(getHeight());
    AEQLog.a(str, localStringBuilder.toString());
    str = this.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchTouchEvent() called with: ev = [");
    localStringBuilder.append(paramMotionEvent);
    localStringBuilder.append(']');
    AEQLog.b(str, localStringBuilder.toString());
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void setReorderListener(@Nullable ReorderListener paramReorderListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderListener = paramReorderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView
 * JD-Core Version:    0.7.0.1
 */