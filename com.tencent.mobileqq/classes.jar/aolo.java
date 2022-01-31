import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView.1;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView.1.1.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aolo
  implements OnCompositionLoadedListener
{
  public aolo(MatchingView.1 param1) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("MatchingView", 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    MatchingView.a(this.a.this$0, localLottieDrawable);
    ThreadManager.getUIHandler().post(new MatchingView.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aolo
 * JD-Core Version:    0.7.0.1
 */