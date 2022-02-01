import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class bnsx
  extends Handler
{
  public bnsx(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131696758, 0).a();
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131696776, 0).a();
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131696756, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131696757, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsx
 * JD-Core Version:    0.7.0.1
 */