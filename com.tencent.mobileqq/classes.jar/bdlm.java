import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator.HttpCommunicatorHandler.1;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class bdlm
  extends Handler
{
  public int a;
  public bdlo a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean();
  
  public bdlm(HttpCommunicator paramHttpCommunicator, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bdlo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this.jdField_a_of_type_Bdlo, "requeustInterupt", "msgId:" + this.jdField_a_of_type_Bdlo.jdField_a_of_type_JavaLangString + " thread id:" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bdlo.b.set(true);
        if (this.jdField_a_of_type_Bdlo.jdField_a_of_type_JavaNetHttpURLConnection != null)
        {
          this.jdField_a_of_type_Bdlo.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
          getLooper().getThread().interrupt();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this);
        this.jdField_a_of_type_Bdlo.a(9361, 0, "preempted by higher msg");
        this.jdField_a_of_type_Bdlo.a().b(this.jdField_a_of_type_Bdlo, this.jdField_a_of_type_Bdlo);
        this.jdField_a_of_type_Bdlo = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(bdlo parambdlo)
  {
    sendMessage(obtainMessage(0, parambdlo));
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what == 0)
    {
      if ((HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator) != null) && (HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator) != null)) {
        HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator).removeCallbacks(HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator));
      }
      if ((???.obj != null) && ((???.obj instanceof bdlo)))
      {
        localbdlo = (bdlo)???.obj;
        if (localbdlo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label274;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localbdlo, this, false);
        if (localbdlo.jdField_a_of_type_JavaLangObject != null) {
          localbdlo.c.set(true);
        }
      }
    }
    label274:
    while (???.what != 1)
    {
      synchronized (localbdlo.jdField_a_of_type_JavaLangObject)
      {
        bdlo localbdlo;
        localbdlo.jdField_a_of_type_JavaLangObject.notify();
        if (this.b.get())
        {
          getLooper().quit();
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_Bdlo = null;
      for (???.obj = null;; ???.obj = null)
      {
        synchronized (HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator))
        {
          HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a("handleMsgFin thread index:" + this.jdField_a_of_type_Int);
          if ((!HttpCommunicator.c(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator, false)) || (HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator) == null)) {
            break;
          }
          HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator, new HttpCommunicator.HttpCommunicatorHandler.1(this));
          HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator).postDelayed(HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator), 2000L);
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_Bdlo = null;
      }
    }
    getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlm
 * JD-Core Version:    0.7.0.1
 */