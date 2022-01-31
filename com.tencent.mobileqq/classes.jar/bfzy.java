import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class bfzy
  extends RecyclerView.AdapterDataObserver
{
  bfzy(bfzx parambfzx) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (bfzx.a(this.a) != null) {
      bfzx.a(this.a).a(bfzx.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(bfzx.a(this.a).size() + paramInt1, paramInt2);
    if (bfzx.a(this.a) != null) {
      bfzx.a(this.a).a(bfzx.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(bfzx.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (bfzx.a(this.a) != null) {
      bfzx.a(this.a).a(bfzx.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(bfzx.a(this.a).size() + paramInt1, paramInt2);
    if (bfzx.a(this.a) != null) {
      bfzx.a(this.a).a(bfzx.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(bfzx.a(this.a).size() + paramInt1, bfzx.a(this.a).size() + paramInt2);
    if (bfzx.a(this.a) != null) {
      bfzx.a(this.a).a(bfzx.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(bfzx.a(this.a).size() + paramInt1, paramInt2);
    if (bfzx.a(this.a) != null) {
      bfzx.a(this.a).a(bfzx.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzy
 * JD-Core Version:    0.7.0.1
 */