import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class bhwz
  extends Handler
{
  public bhwz(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      bcpw.a(BaseApplicationImpl.getContext(), 2131697683, 0).a();
      return;
    case 1: 
      bcpw.a(BaseApplicationImpl.getContext(), 2131697699, 0).a();
      return;
    case 3: 
      bcpw.a(BaseApplicationImpl.getContext(), 2131697681, 0).a();
      return;
    }
    bcpw.a(BaseApplicationImpl.getContext(), 2131697682, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhwz
 * JD-Core Version:    0.7.0.1
 */