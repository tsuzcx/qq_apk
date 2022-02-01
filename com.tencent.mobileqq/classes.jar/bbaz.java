import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDecoder;

class bbaz
  extends RecyclerView.OnScrollListener
{
  bbaz(bbay parambbay) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    bbay.a(this.a, paramInt);
    if (bbay.a(this.a) == 0)
    {
      if (bbay.a(this.a).isPausing()) {
        bbay.a(this.a).resume();
      }
      int i = bbay.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = bbay.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (bbbb)bbay.a(this.a).getChildViewHolder(paramRecyclerView);
        bbbb.a(paramRecyclerView).setImageBitmap(bbay.a(this.a, bbbb.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    bbay.a(this.a).cancelPendingRequests();
    bbay.a(this.a).pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaz
 * JD-Core Version:    0.7.0.1
 */