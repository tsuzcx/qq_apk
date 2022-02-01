import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class baar
  extends Handler
{
  public static boolean a;
  
  public void a(Message paramMessage)
  {
    View localView = (View)paramMessage.obj;
    int i = paramMessage.getData().getInt("iTipsTimes");
    long l = paramMessage.getData().getLong("iRemindTime");
    int j = paramMessage.what;
    paramMessage = ValueAnimator.ofFloat(new float[] { 3.0F });
    paramMessage.setEvaluator(new baau(this));
    paramMessage.setDuration(3000L);
    if (i >= 1) {
      paramMessage.setRepeatCount(i - 1);
    }
    paramMessage.addUpdateListener(new baas(this, localView));
    paramMessage.addListener(new baat(this, localView, l, j));
    paramMessage.start();
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.arg1) {
      a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baar
 * JD-Core Version:    0.7.0.1
 */