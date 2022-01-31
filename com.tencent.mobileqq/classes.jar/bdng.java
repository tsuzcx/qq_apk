import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

public abstract class bdng
  extends RecyclerView.OnScrollListener
{
  private boolean a;
  
  public abstract void a();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramInt == 0)
    {
      paramInt = localGridLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((((bdnd)paramRecyclerView.getAdapter()).a(paramInt).a == 4) && (this.a)) {
        a();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdng
 * JD-Core Version:    0.7.0.1
 */