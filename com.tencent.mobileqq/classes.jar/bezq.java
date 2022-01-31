import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.open.agent.DeviceFriendListOpenFrame;

public class bezq
  extends Handler
{
  public bezq(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 40, 0);
      return;
    case 2: 
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
      return;
    }
    this.a.jdField_a_of_type_Bezr.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezq
 * JD-Core Version:    0.7.0.1
 */