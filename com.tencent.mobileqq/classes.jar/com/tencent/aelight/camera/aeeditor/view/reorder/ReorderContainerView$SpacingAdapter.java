package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.qcircle.tavcut.util.TimeFormatUtil;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "()V", "data", "", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/CutModelKt;", "getItemCount", "", "getItemViewType", "position", "indexOf", "uuid", "", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "screenWidth", "context", "Landroid/content/Context;", "submitList", "", "swapItem", "src", "dest", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView$SpacingAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static final ReorderContainerView.SpacingAdapter.Companion a = new ReorderContainerView.SpacingAdapter.Companion(null);
  private List<CutModelKt> b = (List)new ArrayList();
  
  private final int a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    return paramContext.getDisplayMetrics().widthPixels;
  }
  
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (Intrinsics.areEqual(((CutModelKt)localIterator.next()).getUuid(), paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    CutModelKt localCutModelKt = (CutModelKt)this.b.get(paramInt1);
    List localList = this.b;
    localList.set(paramInt1, localList.get(paramInt2));
    this.b.set(paramInt2, localCutModelKt);
  }
  
  public final void a(@NotNull List<CutModelKt> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    this.b.clear();
    this.b.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != this.b.size() + 1)) {
      return 11;
    }
    return 12;
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    if ((paramViewHolder instanceof ReorderVH))
    {
      CutModelKt localCutModelKt = (CutModelKt)this.b.get(paramInt - 1);
      paramViewHolder = (ReorderVH)paramViewHolder;
      paramViewHolder.a().setClipUrl(localCutModelKt.getUuid(), localCutModelKt.getResource().getPath(), localCutModelKt.getResource().getSelectTimeStart());
      paramInt = ReorderViewIdManager.a.a(localCutModelKt.getUuid());
      if (paramInt != -1) {
        paramViewHolder.a().setId(paramInt);
      }
      paramViewHolder.b().setText((CharSequence)TimeFormatUtil.getDurationSecondsEnglish(localCutModelKt.getResource().getScaleDuration()));
    }
  }
  
  @RequiresApi(16)
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    if (paramInt != 12)
    {
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      return (RecyclerView.ViewHolder)new ReorderVH(new SelectableThumbClipView(paramViewGroup, null, 0, 6, null));
    }
    View localView = new View(paramViewGroup.getContext());
    Context localContext = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "parent.context");
    paramInt = localContext.getResources().getDimensionPixelSize(2063859779);
    paramViewGroup = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
    localView.setLayoutParams(new ViewGroup.LayoutParams(a(paramViewGroup) / 2, paramInt));
    return (RecyclerView.ViewHolder)new ReorderContainerView.SpacingVH(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView.SpacingAdapter
 * JD-Core Version:    0.7.0.1
 */