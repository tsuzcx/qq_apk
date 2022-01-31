import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class bern
  extends RecyclerView.AdapterDataObserver
{
  bern(berm paramberm) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (berm.a(this.a) != null) {
      berm.a(this.a).a(berm.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(berm.a(this.a).size() + paramInt1, paramInt2);
    if (berm.a(this.a) != null) {
      berm.a(this.a).a(berm.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(berm.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (berm.a(this.a) != null) {
      berm.a(this.a).a(berm.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(berm.a(this.a).size() + paramInt1, paramInt2);
    if (berm.a(this.a) != null) {
      berm.a(this.a).a(berm.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(berm.a(this.a).size() + paramInt1, berm.a(this.a).size() + paramInt2);
    if (berm.a(this.a) != null) {
      berm.a(this.a).a(berm.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(berm.a(this.a).size() + paramInt1, paramInt2);
    if (berm.a(this.a) != null) {
      berm.a(this.a).a(berm.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bern
 * JD-Core Version:    0.7.0.1
 */