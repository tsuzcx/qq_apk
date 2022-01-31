import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class bhxq
  extends Handler
{
  public bhxq(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      bcql.a(BaseApplicationImpl.getContext(), 2131697688, 0).a();
      return;
    case 1: 
      bcql.a(BaseApplicationImpl.getContext(), 2131697704, 0).a();
      return;
    case 3: 
      bcql.a(BaseApplicationImpl.getContext(), 2131697686, 0).a();
      return;
    }
    bcql.a(BaseApplicationImpl.getContext(), 2131697687, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhxq
 * JD-Core Version:    0.7.0.1
 */