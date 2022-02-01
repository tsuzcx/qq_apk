import android.os.AsyncTask;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bgfc
  extends AsyncTask<Long, Void, Void>
{
  long jdField_a_of_type_Long;
  Object jdField_a_of_type_JavaLangObject;
  
  public bgfc(PendantInfo paramPendantInfo, Object paramObject, long paramLong)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    try
    {
      long l1 = paramVarArgs[0].longValue();
      long l2 = paramVarArgs[1].longValue();
      long l3 = paramVarArgs[2].longValue();
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a((int)l3, this.jdField_a_of_type_JavaLangObject, (int)l2);
      if ((paramVarArgs != null) && (!isCancelled()))
      {
        l2 = SystemClock.uptimeMillis();
        Message localMessage = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(17);
        if (PendantInfo.a(localMessage, this.jdField_a_of_type_Long))
        {
          localMessage.obj = paramVarArgs;
          if (l2 < l1) {
            this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, l1 - l2);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
          }
        }
      }
    }
    catch (Throwable paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("PendantInfo", 4, "", paramVarArgs);
      }
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.b = true;
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Bgfc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfc
 * JD-Core Version:    0.7.0.1
 */