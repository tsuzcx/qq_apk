import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aoda
  extends Handler
{
  public aoda(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.j == 1) || (this.a.j == 2)))
    {
      this.a.a();
      QQToast.a(this.a, 2131691081, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoda
 * JD-Core Version:    0.7.0.1
 */