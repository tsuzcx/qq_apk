import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.image.ApngImage;
import dov.com.qq.im.ae.play.AEPlayShowPageView;

public class bixg
  extends RecyclerView.OnScrollListener
{
  public bixg(AEPlayShowPageView paramAEPlayShowPageView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixg
 * JD-Core Version:    0.7.0.1
 */