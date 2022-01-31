import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class aypa
  extends Handler
{
  public aypa(ayoz paramayoz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(aypb paramaypb)
  {
    sendMessage(obtainMessage(0, paramaypb));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof aypb))) {
      paramMessage = (aypb)paramMessage.obj;
    }
    try
    {
      aywc localaywc = paramMessage.a();
      if ((localaywc != null) && (localaywc.jdField_a_of_type_Long != 0L) && (localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localaywc.c, localaywc.jdField_a_of_type_Int, localaywc.jdField_a_of_type_Long);
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
 * Qualified Name:     aypa
 * JD-Core Version:    0.7.0.1
 */