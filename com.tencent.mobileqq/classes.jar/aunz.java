import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;

public class aunz
  extends RecyclerView.OnScrollListener
{
  public aunz(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (MultiCardRecommendFragment.a(this.a) != null)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        break label38;
      }
      MultiCardRecommendFragment.a(this.a);
    }
    for (;;)
    {
      if (paramInt == 0) {
        MultiCardRecommendFragment.d(this.a);
      }
      return;
      label38:
      MultiCardRecommendFragment.b(this.a);
      MultiCardRecommendFragment.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aunz
 * JD-Core Version:    0.7.0.1
 */