import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public class bdsw
  extends Handler
{
  public bdsw(bdsv parambdsv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(bdsx parambdsx)
  {
    sendMessage(obtainMessage(0, parambdsx));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof bdsx))) {
      paramMessage = (bdsx)paramMessage.obj;
    }
    try
    {
      bdzn localbdzn = paramMessage.a();
      if ((localbdzn != null) && (localbdzn.jdField_a_of_type_Long != 0L) && (localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localbdzn.c, localbdzn.jdField_a_of_type_Int, localbdzn.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramMessage.aN_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdsw
 * JD-Core Version:    0.7.0.1
 */