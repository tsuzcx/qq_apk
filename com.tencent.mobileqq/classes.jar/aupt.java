import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;

class aupt
  extends RecyclerView.OnScrollListener
{
  aupt(aups paramaups) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    aups.a(this.a, paramInt);
    if (aups.a(this.a) == 0)
    {
      if (aups.a(this.a).a()) {
        aups.a(this.a).b();
      }
      int i = aups.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = aups.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (aupv)aups.a(this.a).getChildViewHolder(paramRecyclerView);
        aupv.a(paramRecyclerView).setImageBitmap(aups.a(this.a, aupv.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    aups.a(this.a).a();
    aups.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aupt
 * JD-Core Version:    0.7.0.1
 */