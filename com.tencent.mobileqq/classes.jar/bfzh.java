import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class bfzh
  extends RecyclerView.AdapterDataObserver
{
  bfzh(bfzg parambfzg) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (bfzg.a(this.a) != null) {
      bfzg.a(this.a).a(bfzg.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(bfzg.a(this.a).size() + paramInt1, paramInt2);
    if (bfzg.a(this.a) != null) {
      bfzg.a(this.a).a(bfzg.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(bfzg.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (bfzg.a(this.a) != null) {
      bfzg.a(this.a).a(bfzg.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(bfzg.a(this.a).size() + paramInt1, paramInt2);
    if (bfzg.a(this.a) != null) {
      bfzg.a(this.a).a(bfzg.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(bfzg.a(this.a).size() + paramInt1, bfzg.a(this.a).size() + paramInt2);
    if (bfzg.a(this.a) != null) {
      bfzg.a(this.a).a(bfzg.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(bfzg.a(this.a).size() + paramInt1, paramInt2);
    if (bfzg.a(this.a) != null) {
      bfzg.a(this.a).a(bfzg.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzh
 * JD-Core Version:    0.7.0.1
 */