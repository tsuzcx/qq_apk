import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class axot
  extends Handler
{
  public axot(axos paramaxos, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(axou paramaxou)
  {
    sendMessage(obtainMessage(0, paramaxou));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof axou))) {
      paramMessage = (axou)paramMessage.obj;
    }
    try
    {
      axvt localaxvt = paramMessage.a();
      if ((localaxvt != null) && (localaxvt.jdField_a_of_type_Long != 0L) && (localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localaxvt.c, localaxvt.jdField_a_of_type_Int, localaxvt.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramMessage.aU_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axot
 * JD-Core Version:    0.7.0.1
 */