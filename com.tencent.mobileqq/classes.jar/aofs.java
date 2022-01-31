import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class aofs
  implements Handler.Callback
{
  aofs(aofr paramaofr) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (this.a.b.size() == 0)
      {
        QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty!");
        return false;
      }
      this.a.b();
      if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      paramMessage = (String)this.a.b.get(this.a.b.size() - 1);
      Drawable localDrawable = bbdr.a(true);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        baxt.a(localQQAppInterface, 1, paramMessage, 4, localDrawable, localDrawable);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return false;
    }
    paramMessage = (aofo)paramMessage.obj;
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramMessage = Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 2, paramMessage);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 500L);
      return false;
    }
    this.a.a(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofs
 * JD-Core Version:    0.7.0.1
 */