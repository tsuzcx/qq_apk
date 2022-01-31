import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;

class avpd
  extends RecyclerView.OnScrollListener
{
  avpd(avpc paramavpc) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    avpc.a(this.a, paramInt);
    if (avpc.a(this.a) == 0)
    {
      if (avpc.a(this.a).a()) {
        avpc.a(this.a).b();
      }
      int i = avpc.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = avpc.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (avpf)avpc.a(this.a).getChildViewHolder(paramRecyclerView);
        avpf.a(paramRecyclerView).setImageBitmap(avpc.a(this.a, avpf.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    avpc.a(this.a).a();
    avpc.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avpd
 * JD-Core Version:    0.7.0.1
 */