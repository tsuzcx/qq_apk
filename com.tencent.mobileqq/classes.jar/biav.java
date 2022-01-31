import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class biav
  extends RecyclerView.AdapterDataObserver
{
  biav(biau parambiau) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (biau.a(this.a) != null) {
      biau.a(this.a).a(biau.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(biau.a(this.a).size() + paramInt1, paramInt2);
    if (biau.a(this.a) != null) {
      biau.a(this.a).a(biau.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(biau.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (biau.a(this.a) != null) {
      biau.a(this.a).a(biau.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(biau.a(this.a).size() + paramInt1, paramInt2);
    if (biau.a(this.a) != null) {
      biau.a(this.a).a(biau.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(biau.a(this.a).size() + paramInt1, biau.a(this.a).size() + paramInt2);
    if (biau.a(this.a) != null) {
      biau.a(this.a).a(biau.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(biau.a(this.a).size() + paramInt1, paramInt2);
    if (biau.a(this.a) != null) {
      biau.a(this.a).a(biau.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biav
 * JD-Core Version:    0.7.0.1
 */