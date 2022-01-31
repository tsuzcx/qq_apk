import android.os.Message;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import mqq.os.MqqHandler;

public class auod
  extends MqqHandler
{
  public auod(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      MultiCardRecommendFragment.e(this.a);
      sendEmptyMessageDelayed(3, 500L);
      return;
      MultiCardRecommendFragment.a(this.a, MultiCardRecommendFragment.b(this.a));
      MultiCardRecommendFragment.e(this.a);
      return;
      MultiCardRecommendFragment.d(this.a);
      return;
    } while (MultiCardRecommendFragment.a(this.a) == null);
    MultiCardRecommendFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auod
 * JD-Core Version:    0.7.0.1
 */