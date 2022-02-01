import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator.HttpCommunicatorHandler.1;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class bguv
  extends Handler
{
  public int a;
  public bgux a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean();
  
  public bguv(bgut parambgut, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bgux != null)
      {
        this.jdField_a_of_type_Bgut.a(this.jdField_a_of_type_Bgux, "requeustInterupt", "msgId:" + this.jdField_a_of_type_Bgux.jdField_a_of_type_JavaLangString + " thread id:" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bgux.b.set(true);
        if (this.jdField_a_of_type_Bgux.jdField_a_of_type_JavaNetHttpURLConnection != null)
        {
          this.jdField_a_of_type_Bgux.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
          getLooper().getThread().interrupt();
        }
        this.jdField_a_of_type_Bgut.a(this);
        this.jdField_a_of_type_Bgux.a(9361, 0, "preempted by higher msg");
        this.jdField_a_of_type_Bgux.a().b(this.jdField_a_of_type_Bgux, this.jdField_a_of_type_Bgux);
        this.jdField_a_of_type_Bgux = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(bgux parambgux)
  {
    sendMessage(obtainMessage(0, parambgux));
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what == 0)
    {
      if ((bgut.a(this.jdField_a_of_type_Bgut) != null) && (bgut.a(this.jdField_a_of_type_Bgut) != null)) {
        bgut.a(this.jdField_a_of_type_Bgut).removeCallbacks(bgut.a(this.jdField_a_of_type_Bgut));
      }
      if ((???.obj != null) && ((???.obj instanceof bgux)))
      {
        localbgux = (bgux)???.obj;
        if (localbgux.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label273;
        }
        this.jdField_a_of_type_Bgut.a(localbgux, this);
        if (localbgux.jdField_a_of_type_JavaLangObject != null) {
          localbgux.c.set(true);
        }
      }
    }
    label273:
    while (???.what != 1)
    {
      synchronized (localbgux.jdField_a_of_type_JavaLangObject)
      {
        bgux localbgux;
        localbgux.jdField_a_of_type_JavaLangObject.notify();
        if (this.b.get())
        {
          getLooper().quit();
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_Bgux = null;
      for (???.obj = null;; ???.obj = null)
      {
        synchronized (bgut.a(this.jdField_a_of_type_Bgut))
        {
          bgut.a(this.jdField_a_of_type_Bgut);
          this.jdField_a_of_type_Bgut.a("handleMsgFin thread index:" + this.jdField_a_of_type_Int);
          if ((!bgut.c(this.jdField_a_of_type_Bgut, false)) || (bgut.a(this.jdField_a_of_type_Bgut) == null)) {
            break;
          }
          bgut.a(this.jdField_a_of_type_Bgut, new HttpCommunicator.HttpCommunicatorHandler.1(this));
          bgut.a(this.jdField_a_of_type_Bgut).postDelayed(bgut.a(this.jdField_a_of_type_Bgut), 2000L);
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_Bgux = null;
      }
    }
    getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bguv
 * JD-Core Version:    0.7.0.1
 */