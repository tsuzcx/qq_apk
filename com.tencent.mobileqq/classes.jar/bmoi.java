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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.util.TimeFormatUtil;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import dov.com.qq.im.aeeditor.view.reorder.SelectableThumbClipView;
import dov.com.qq.im.aeeditor.view.reorder.ThumbClipView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "()V", "data", "", "Lcom/tencent/weseevideo/camera/mvauto/redo/CutModelKt;", "getItemCount", "", "getItemViewType", "position", "indexOf", "uuid", "", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "screenWidth", "context", "Landroid/content/Context;", "submitList", "", "swapItem", "src", "dest", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmoi
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static final bmoj a;
  private List<CutModelKt> a;
  
  static
  {
    jdField_a_of_type_Bmoj = new bmoj(null);
  }
  
  public bmoi()
  {
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
  }
  
  private final int a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    return paramContext.getDisplayMetrics().widthPixels;
  }
  
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    CutModelKt localCutModelKt = (CutModelKt)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
    this.jdField_a_of_type_JavaUtilList.set(paramInt1, this.jdField_a_of_type_JavaUtilList.get(paramInt2));
    this.jdField_a_of_type_JavaUtilList.set(paramInt2, localCutModelKt);
  }
  
  public final void a(@NotNull List<CutModelKt> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_JavaUtilList.size() + 1)) {
      return 12;
    }
    return 11;
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    if ((paramViewHolder instanceof bmor))
    {
      CutModelKt localCutModelKt = (CutModelKt)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      ((bmor)paramViewHolder).a().setClipUrl(localCutModelKt.getUuid(), localCutModelKt.getResource().getPath(), localCutModelKt.getResource().getSelectTimeStart());
      int i = bmos.a.a(localCutModelKt.getUuid());
      if (i != -1) {
        ((bmor)paramViewHolder).a().setId(i);
      }
      ((bmor)paramViewHolder).a().setText((CharSequence)TimeFormatUtil.getDurationSecondsEnglish(localCutModelKt.getResource().getScaleDuration()));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  @RequiresApi(16)
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      return (RecyclerView.ViewHolder)new bmor(new SelectableThumbClipView(paramViewGroup, null, 0, 6, null));
    }
    View localView = new View(paramViewGroup.getContext());
    Context localContext = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "parent.context");
    paramInt = localContext.getResources().getDimensionPixelSize(2131296329);
    paramViewGroup = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
    localView.setLayoutParams(new ViewGroup.LayoutParams(a(paramViewGroup) / 2, paramInt));
    return (RecyclerView.ViewHolder)new bmok(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoi
 * JD-Core Version:    0.7.0.1
 */