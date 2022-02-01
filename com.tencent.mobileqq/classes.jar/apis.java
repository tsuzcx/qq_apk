import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class apis
  extends RecyclerView.OnScrollListener
{
  apis(apiq paramapiq) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      apiq.a(this.a, paramRecyclerView);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (apiq.a(this.a))
    {
      apiq.a(this.a, false);
      apiq.a(this.a, paramRecyclerView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apis
 * JD-Core Version:    0.7.0.1
 */