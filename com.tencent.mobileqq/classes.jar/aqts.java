import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;

public class aqts
  extends Handler
{
  public aqts(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
      return;
    }
    QQGameFeedWebFragment.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqts
 * JD-Core Version:    0.7.0.1
 */