import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import dov.com.qq.im.aeeditor.view.reorder.SelectableThumbClipView;
import dov.com.qq.im.aeeditor.view.reorder.ThumbClipView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/view/reorder/ReorderVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "selectableView", "Ldov/com/qq/im/aeeditor/view/reorder/SelectableThumbClipView;", "(Ldov/com/qq/im/aeeditor/view/reorder/SelectableThumbClipView;)V", "contentView", "Ldov/com/qq/im/aeeditor/view/reorder/ThumbClipView;", "getContentView", "()Ldov/com/qq/im/aeeditor/view/reorder/ThumbClipView;", "durationView", "Landroid/widget/TextView;", "getDurationView", "()Landroid/widget/TextView;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class boej
  extends RecyclerView.ViewHolder
{
  private final SelectableThumbClipView a;
  
  public boej(@NotNull SelectableThumbClipView paramSelectableThumbClipView)
  {
    super((View)paramSelectableThumbClipView);
    this.a = paramSelectableThumbClipView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.a.a();
  }
  
  @NotNull
  public final ThumbClipView a()
  {
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boej
 * JD-Core Version:    0.7.0.1
 */