import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class bkso
  extends RecyclerView.AdapterDataObserver
{
  bkso(bksn parambksn) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (bksn.a(this.a) != null) {
      bksn.a(this.a).a(bksn.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(bksn.a(this.a).size() + paramInt1, paramInt2);
    if (bksn.a(this.a) != null) {
      bksn.a(this.a).a(bksn.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(bksn.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (bksn.a(this.a) != null) {
      bksn.a(this.a).a(bksn.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(bksn.a(this.a).size() + paramInt1, paramInt2);
    if (bksn.a(this.a) != null) {
      bksn.a(this.a).a(bksn.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(bksn.a(this.a).size() + paramInt1, bksn.a(this.a).size() + paramInt2);
    if (bksn.a(this.a) != null) {
      bksn.a(this.a).a(bksn.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(bksn.a(this.a).size() + paramInt1, paramInt2);
    if (bksn.a(this.a) != null) {
      bksn.a(this.a).a(bksn.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkso
 * JD-Core Version:    0.7.0.1
 */