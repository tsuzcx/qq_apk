import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;

class bbaf
  extends RecyclerView.OnScrollListener
{
  bbaf(bbae parambbae) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    bbae.a(this.a, paramInt);
    if (bbae.a(this.a) == 0)
    {
      if (bbae.a(this.a).a()) {
        bbae.a(this.a).b();
      }
      int i = bbae.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = bbae.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (bbah)bbae.a(this.a).getChildViewHolder(paramRecyclerView);
        bbah.a(paramRecyclerView).setImageBitmap(bbae.a(this.a, bbah.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    bbae.a(this.a).a();
    bbae.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaf
 * JD-Core Version:    0.7.0.1
 */