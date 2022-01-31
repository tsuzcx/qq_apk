import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class bifc
  extends RecyclerView.AdapterDataObserver
{
  bifc(bifb parambifb) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (bifb.a(this.a) != null) {
      bifb.a(this.a).a(bifb.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(bifb.a(this.a).size() + paramInt1, paramInt2);
    if (bifb.a(this.a) != null) {
      bifb.a(this.a).a(bifb.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(bifb.a(this.a).size() + paramInt1, paramInt2, paramObject);
    if (bifb.a(this.a) != null) {
      bifb.a(this.a).a(bifb.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(bifb.a(this.a).size() + paramInt1, paramInt2);
    if (bifb.a(this.a) != null) {
      bifb.a(this.a).a(bifb.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(bifb.a(this.a).size() + paramInt1, bifb.a(this.a).size() + paramInt2);
    if (bifb.a(this.a) != null) {
      bifb.a(this.a).a(bifb.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(bifb.a(this.a).size() + paramInt1, paramInt2);
    if (bifb.a(this.a) != null) {
      bifb.a(this.a).a(bifb.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bifc
 * JD-Core Version:    0.7.0.1
 */