import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class bltr
  extends RecyclerView.AdapterDataObserver
{
  bltr(bltq parambltq) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (bltq.a(this.a) != null) {
      bltq.a(this.a).a(bltq.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(bltq.a(this.a).size() + paramInt1, paramInt2);
    if (bltq.a(this.a) != null) {
      bltq.a(this.a).a(bltq.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(bltq.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (bltq.a(this.a) != null) {
      bltq.a(this.a).a(bltq.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(bltq.a(this.a).size() + paramInt1, paramInt2);
    if (bltq.a(this.a) != null) {
      bltq.a(this.a).a(bltq.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(bltq.a(this.a).size() + paramInt1, bltq.a(this.a).size() + paramInt2);
    if (bltq.a(this.a) != null) {
      bltq.a(this.a).a(bltq.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(bltq.a(this.a).size() + paramInt1, paramInt2);
    if (bltq.a(this.a) != null) {
      bltq.a(this.a).a(bltq.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltr
 * JD-Core Version:    0.7.0.1
 */