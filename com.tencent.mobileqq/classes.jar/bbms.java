import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator.HttpCommunicatorHandler.1;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class bbms
  extends Handler
{
  public int a;
  public bbmu a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean();
  
  public bbms(HttpCommunicator paramHttpCommunicator, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bbmu != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this.jdField_a_of_type_Bbmu, "requeustInterupt", "msgId:" + this.jdField_a_of_type_Bbmu.jdField_a_of_type_JavaLangString + " thread id:" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bbmu.b.set(true);
        if (this.jdField_a_of_type_Bbmu.jdField_a_of_type_JavaNetHttpURLConnection != null)
        {
          this.jdField_a_of_type_Bbmu.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
          getLooper().getThread().interrupt();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this);
        this.jdField_a_of_type_Bbmu.a(9361, 0, "preempted by higher msg");
        this.jdField_a_of_type_Bbmu.a().b(this.jdField_a_of_type_Bbmu, this.jdField_a_of_type_Bbmu);
        this.jdField_a_of_type_Bbmu = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(bbmu parambbmu)
  {
    sendMessage(obtainMessage(0, parambbmu));
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what == 0)
    {
      if ((HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator) != null) && (HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator) != null)) {
        HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator).removeCallbacks(HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator));
      }
      if ((???.obj != null) && ((???.obj instanceof bbmu)))
      {
        localbbmu = (bbmu)???.obj;
        if (localbbmu.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label274;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localbbmu, this, false);
        if (localbbmu.jdField_a_of_type_JavaLangObject != null) {
          localbbmu.c.set(true);
        }
      }
    }
    label274:
    while (???.what != 1)
    {
      synchronized (localbbmu.jdField_a_of_type_JavaLangObject)
      {
        bbmu localbbmu;
        localbbmu.jdField_a_of_type_JavaLangObject.notify();
        if (this.b.get())
        {
          getLooper().quit();
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_Bbmu = null;
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
        this.jdField_a_of_type_Bbmu = null;
      }
    }
    getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbms
 * JD-Core Version:    0.7.0.1
 */