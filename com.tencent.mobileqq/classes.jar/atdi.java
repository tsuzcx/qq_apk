import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog$SpacesItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "firstItemTopSpace", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class atdi
  extends RecyclerView.ItemDecoration
{
  private final int a;
  private final int b;
  
  public atdi(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "outRect");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    paramRect.bottom = this.a;
    if (paramRecyclerView.getChildPosition(paramView) == 0) {
      paramRect.top = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdi
 * JD-Core Version:    0.7.0.1
 */