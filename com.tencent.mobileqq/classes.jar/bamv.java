import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public class bamv
  extends Handler
{
  public bamv(bamu parambamu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(bamw parambamw)
  {
    sendMessage(obtainMessage(0, parambamw));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof bamw))) {
      paramMessage = (bamw)paramMessage.obj;
    }
    try
    {
      baub localbaub = paramMessage.a();
      if ((localbaub != null) && (localbaub.jdField_a_of_type_Long != 0L) && (localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localbaub.c, localbaub.jdField_a_of_type_Int, localbaub.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramMessage.aS_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bamv
 * JD-Core Version:    0.7.0.1
 */