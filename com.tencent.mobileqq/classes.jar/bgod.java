import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class bgod
  extends Handler
{
  public bgod(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      bbmy.a(BaseApplicationImpl.getContext(), 2131631969, 0).a();
      return;
    case 1: 
      bbmy.a(BaseApplicationImpl.getContext(), 2131631981, 0).a();
      return;
    case 3: 
      bbmy.a(BaseApplicationImpl.getContext(), 2131631967, 0).a();
      return;
    }
    bbmy.a(BaseApplicationImpl.getContext(), 2131631968, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgod
 * JD-Core Version:    0.7.0.1
 */