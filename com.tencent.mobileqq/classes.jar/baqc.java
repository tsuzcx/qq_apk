import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class baqc
  implements Handler.Callback
{
  baqc(bapx parambapx) {}
  
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
      if ((this.a.b != null) && (this.a.b.size() > 3))
      {
        paramMessage = (String)this.a.b.get(3);
        Drawable localDrawable = bdhj.a(true);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localQQAppInterface != null) {
          bdbk.a(localQQAppInterface, 1, paramMessage, 4, localDrawable, localDrawable);
        }
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
      return false;
    }
    paramMessage = (ArrayList)paramMessage.obj;
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramMessage = Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 2, paramMessage);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 500L);
      return false;
    }
    bapx.a(this.a, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqc
 * JD-Core Version:    0.7.0.1
 */