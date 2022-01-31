import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class arbm
  extends RecyclerView.AdapterDataObserver
{
  arbm(arbl paramarbl) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    super.onItemRangeChanged(paramInt1, paramInt2);
    this.a.notifyItemRangeChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    super.onItemRangeInserted(paramInt1, paramInt2);
    this.a.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    this.a.notifyItemRangeChanged(paramInt1, paramInt2 + paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    super.onItemRangeRemoved(paramInt1, paramInt2);
    this.a.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbm
 * JD-Core Version:    0.7.0.1
 */