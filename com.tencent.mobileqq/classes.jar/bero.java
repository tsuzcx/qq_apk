import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public class bero
  extends Handler
{
  public bero(bern parambern, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(berp paramberp)
  {
    sendMessage(obtainMessage(0, paramberp));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof berp))) {
      paramMessage = (berp)paramMessage.obj;
    }
    try
    {
      beyg localbeyg = paramMessage.a();
      if ((localbeyg != null) && (localbeyg.jdField_a_of_type_Long != 0L) && (localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localbeyg.c, localbeyg.jdField_a_of_type_Int, localbeyg.jdField_a_of_type_Long);
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
 * Qualified Name:     bero
 * JD-Core Version:    0.7.0.1
 */