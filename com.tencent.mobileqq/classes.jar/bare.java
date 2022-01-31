import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public class bare
  extends Handler
{
  public bare(bard parambard, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(barf parambarf)
  {
    sendMessage(obtainMessage(0, parambarf));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof barf))) {
      paramMessage = (barf)paramMessage.obj;
    }
    try
    {
      bayk localbayk = paramMessage.a();
      if ((localbayk != null) && (localbayk.jdField_a_of_type_Long != 0L) && (localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localbayk.c, localbayk.jdField_a_of_type_Int, localbayk.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramMessage.aP_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bare
 * JD-Core Version:    0.7.0.1
 */