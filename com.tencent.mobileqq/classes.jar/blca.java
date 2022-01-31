import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.image.ApngImage;
import dov.com.qq.im.ae.play.AEPlayShowPageView;

public class blca
  extends RecyclerView.OnScrollListener
{
  public blca(AEPlayShowPageView paramAEPlayShowPageView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      ApngImage.resumeAll();
    }
    for (;;)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      return;
      ApngImage.pauseAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blca
 * JD-Core Version:    0.7.0.1
 */