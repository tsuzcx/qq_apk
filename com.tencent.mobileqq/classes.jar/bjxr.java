import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class bjxr
  extends RecyclerView.AdapterDataObserver
{
  bjxr(bjxq parambjxq) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (bjxq.a(this.a) != null) {
      bjxq.a(this.a).a(bjxq.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(bjxq.a(this.a).size() + paramInt1, paramInt2);
    if (bjxq.a(this.a) != null) {
      bjxq.a(this.a).a(bjxq.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(bjxq.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (bjxq.a(this.a) != null) {
      bjxq.a(this.a).a(bjxq.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(bjxq.a(this.a).size() + paramInt1, paramInt2);
    if (bjxq.a(this.a) != null) {
      bjxq.a(this.a).a(bjxq.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(bjxq.a(this.a).size() + paramInt1, bjxq.a(this.a).size() + paramInt2);
    if (bjxq.a(this.a) != null) {
      bjxq.a(this.a).a(bjxq.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(bjxq.a(this.a).size() + paramInt1, paramInt2);
    if (bjxq.a(this.a) != null) {
      bjxq.a(this.a).a(bjxq.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxr
 * JD-Core Version:    0.7.0.1
 */