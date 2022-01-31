import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;

public class aqfi
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public aqfi(Fragment paramFragment)
  {
    this.a = aepi.a(11.0F, paramFragment.getResources());
    this.b = aepi.a(11.0F, paramFragment.getResources());
    this.c = aepi.a(8.0F, paramFragment.getResources());
    this.d = aepi.a(8.0F, paramFragment.getResources());
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    int i = paramRecyclerView.getAdapter().getItemCount();
    if (paramRecyclerView.getAdapter().getItemViewType(paramInt) == 6)
    {
      paramRect.set(0, this.a, 0, 0);
      return;
    }
    if (paramInt == i - 1)
    {
      paramRect.set(this.c, this.a, this.d, this.b);
      return;
    }
    paramRect.set(this.c, this.a, this.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfi
 * JD-Core Version:    0.7.0.1
 */