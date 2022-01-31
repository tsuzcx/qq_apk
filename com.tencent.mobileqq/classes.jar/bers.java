import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;

public class bers
  extends RecyclerView.RecycledViewPool
{
  public bers(RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter) {}
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = this.a.getAdapter();
    RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt);
    if ((localViewHolder != null) && ((localObject instanceof berm)))
    {
      localObject = (berm)localObject;
      if (((berm)localObject).d(paramInt))
      {
        if (!RecyclerViewWithHeaderFooter.a(this.a).contains(localViewHolder.itemView))
        {
          putRecycledView(localViewHolder);
          return null;
        }
      }
      else if ((((berm)localObject).c(paramInt)) && (!RecyclerViewWithHeaderFooter.b(this.a).contains(localViewHolder.itemView)))
      {
        putRecycledView(localViewHolder);
        return null;
      }
    }
    return localViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bers
 * JD-Core Version:    0.7.0.1
 */