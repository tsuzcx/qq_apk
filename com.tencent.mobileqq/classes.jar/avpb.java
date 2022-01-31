import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;

class avpb
  extends RecyclerView.OnScrollListener
{
  avpb(avpa paramavpa) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    avpa.a(this.a, paramInt);
    if (avpa.a(this.a) == 0)
    {
      if (avpa.a(this.a).a()) {
        avpa.a(this.a).b();
      }
      int i = avpa.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = avpa.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (avpd)avpa.a(this.a).getChildViewHolder(paramRecyclerView);
        avpd.a(paramRecyclerView).setImageBitmap(avpa.a(this.a, avpd.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    avpa.a(this.a).a();
    avpa.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avpb
 * JD-Core Version:    0.7.0.1
 */