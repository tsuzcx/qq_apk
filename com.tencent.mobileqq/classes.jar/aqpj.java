import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class aqpj
  extends RecyclerView.OnScrollListener
{
  aqpj(aqph paramaqph) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      aqph.a(this.a, paramRecyclerView);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (aqph.a(this.a))
    {
      aqph.a(this.a, false);
      aqph.a(this.a, paramRecyclerView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpj
 * JD-Core Version:    0.7.0.1
 */