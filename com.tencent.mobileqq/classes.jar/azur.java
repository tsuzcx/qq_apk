import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDecoder;

class azur
  extends RecyclerView.OnScrollListener
{
  azur(azuq paramazuq) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    azuq.a(this.a, paramInt);
    if (azuq.a(this.a) == 0)
    {
      if (azuq.a(this.a).isPausing()) {
        azuq.a(this.a).resume();
      }
      int i = azuq.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = azuq.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (azut)azuq.a(this.a).getChildViewHolder(paramRecyclerView);
        azut.a(paramRecyclerView).setImageBitmap(azuq.a(this.a, azut.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    azuq.a(this.a).cancelPendingRequests();
    azuq.a(this.a).pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azur
 * JD-Core Version:    0.7.0.1
 */