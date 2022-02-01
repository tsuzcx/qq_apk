import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract class blia
  extends blhu
{
  private int a;
  private int b;
  
  public blia(int paramInt1, int paramInt2)
  {
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return this.a;
  }
  
  public int b(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return this.b;
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return makeMovementFlags(b(paramRecyclerView, paramViewHolder), a(paramRecyclerView, paramViewHolder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blia
 * JD-Core Version:    0.7.0.1
 */