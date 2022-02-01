import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame;

public class amdl
  extends Handler
{
  public amdl(FriendListInnerFrame paramFriendListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a.setPadding(0, 0, 40, 0);
      return;
    }
    this.a.a.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdl
 * JD-Core Version:    0.7.0.1
 */