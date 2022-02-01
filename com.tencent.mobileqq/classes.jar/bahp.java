import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;

class bahp
  extends RecyclerView.OnScrollListener
{
  bahp(baho parambaho) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    baho.a(this.a, paramInt);
    if (baho.a(this.a) == 0)
    {
      if (baho.a(this.a).a()) {
        baho.a(this.a).b();
      }
      int i = baho.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = baho.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (bahr)baho.a(this.a).getChildViewHolder(paramRecyclerView);
        bahr.a(paramRecyclerView).setImageBitmap(baho.a(this.a, bahr.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    baho.a(this.a).a();
    baho.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahp
 * JD-Core Version:    0.7.0.1
 */