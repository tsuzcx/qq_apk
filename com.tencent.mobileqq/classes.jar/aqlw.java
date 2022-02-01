import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class aqlw
  extends RecyclerView.OnScrollListener
{
  aqlw(aqlu paramaqlu) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      aqlu.a(this.a, paramRecyclerView);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (aqlu.a(this.a))
    {
      aqlu.a(this.a, false);
      aqlu.a(this.a, paramRecyclerView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlw
 * JD-Core Version:    0.7.0.1
 */