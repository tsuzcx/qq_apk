import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class ayoy
  extends Handler
{
  public ayoy(ayox paramayox, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(ayoz paramayoz)
  {
    sendMessage(obtainMessage(0, paramayoz));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof ayoz))) {
      paramMessage = (ayoz)paramMessage.obj;
    }
    try
    {
      aywa localaywa = paramMessage.a();
      if ((localaywa != null) && (localaywa.jdField_a_of_type_Long != 0L) && (localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localaywa.c, localaywa.jdField_a_of_type_Int, localaywa.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramMessage.aR_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayoy
 * JD-Core Version:    0.7.0.1
 */