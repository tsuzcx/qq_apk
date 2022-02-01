import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class bmjn
  extends Handler
{
  public bmjn(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131697173, 0).a();
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131697191, 0).a();
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131697171, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131697172, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjn
 * JD-Core Version:    0.7.0.1
 */