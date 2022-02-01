import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator.HttpCommunicatorHandler.1;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class bhuy
  extends Handler
{
  public int a;
  public bhva a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean();
  
  public bhuy(bhuw parambhuw, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bhva != null)
      {
        this.jdField_a_of_type_Bhuw.a(this.jdField_a_of_type_Bhva, "requeustInterupt", "msgId:" + this.jdField_a_of_type_Bhva.jdField_a_of_type_JavaLangString + " thread id:" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bhva.b.set(true);
        if (this.jdField_a_of_type_Bhva.jdField_a_of_type_JavaNetHttpURLConnection != null)
        {
          this.jdField_a_of_type_Bhva.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
          getLooper().getThread().interrupt();
        }
        this.jdField_a_of_type_Bhuw.a(this);
        this.jdField_a_of_type_Bhva.a(9361, 0, "preempted by higher msg");
        this.jdField_a_of_type_Bhva.a().b(this.jdField_a_of_type_Bhva, this.jdField_a_of_type_Bhva);
        this.jdField_a_of_type_Bhva = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(bhva parambhva)
  {
    sendMessage(obtainMessage(0, parambhva));
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what == 0)
    {
      if ((bhuw.a(this.jdField_a_of_type_Bhuw) != null) && (bhuw.a(this.jdField_a_of_type_Bhuw) != null)) {
        bhuw.a(this.jdField_a_of_type_Bhuw).removeCallbacks(bhuw.a(this.jdField_a_of_type_Bhuw));
      }
      if ((???.obj != null) && ((???.obj instanceof bhva)))
      {
        localbhva = (bhva)???.obj;
        if (localbhva.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label273;
        }
        this.jdField_a_of_type_Bhuw.a(localbhva, this);
        if (localbhva.jdField_a_of_type_JavaLangObject != null) {
          localbhva.c.set(true);
        }
      }
    }
    label273:
    while (???.what != 1)
    {
      synchronized (localbhva.jdField_a_of_type_JavaLangObject)
      {
        bhva localbhva;
        localbhva.jdField_a_of_type_JavaLangObject.notify();
        if (this.b.get())
        {
          getLooper().quit();
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_Bhva = null;
      for (???.obj = null;; ???.obj = null)
      {
        synchronized (bhuw.a(this.jdField_a_of_type_Bhuw))
        {
          bhuw.a(this.jdField_a_of_type_Bhuw);
          this.jdField_a_of_type_Bhuw.a("handleMsgFin thread index:" + this.jdField_a_of_type_Int);
          if ((!bhuw.c(this.jdField_a_of_type_Bhuw, false)) || (bhuw.a(this.jdField_a_of_type_Bhuw) == null)) {
            break;
          }
          bhuw.a(this.jdField_a_of_type_Bhuw, new HttpCommunicator.HttpCommunicatorHandler.1(this));
          bhuw.a(this.jdField_a_of_type_Bhuw).postDelayed(bhuw.a(this.jdField_a_of_type_Bhuw), 2000L);
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_Bhva = null;
      }
    }
    getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhuy
 * JD-Core Version:    0.7.0.1
 */