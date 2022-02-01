import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;

public class auvm
  extends Handler
{
  public auvm(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
      return;
    case 100: 
      QQGameFeedWebFragment.a(this.a).setVisibility(8);
      return;
    }
    int i = paramMessage.arg1;
    try
    {
      QQGameFeedWebFragment.a(this.a, i);
      return;
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvm
 * JD-Core Version:    0.7.0.1
 */