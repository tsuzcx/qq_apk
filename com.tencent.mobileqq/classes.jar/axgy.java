import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;

class axgy
  extends RecyclerView.OnScrollListener
{
  axgy(axgx paramaxgx) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    axgx.a(this.a, paramInt);
    if (axgx.a(this.a) == 0)
    {
      if (axgx.a(this.a).a()) {
        axgx.a(this.a).b();
      }
      int i = axgx.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = axgx.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (axha)axgx.a(this.a).getChildViewHolder(paramRecyclerView);
        axha.a(paramRecyclerView).setImageBitmap(axgx.a(this.a, axha.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    axgx.a(this.a).a();
    axgx.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axgy
 * JD-Core Version:    0.7.0.1
 */