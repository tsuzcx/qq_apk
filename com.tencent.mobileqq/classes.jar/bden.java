import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class bden
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private bdeo jdField_a_of_type_Bdeo = new bdeo(0);
  private bdeo b = new bdeo(1);
  
  public bdeo a()
  {
    if (bdeo.a(this.jdField_a_of_type_Bdeo).getAndSet(1) == 0) {
      return this.jdField_a_of_type_Bdeo;
    }
    if (bdeo.a(this.b).getAndSet(1) == 0) {
      return this.b;
    }
    return null;
  }
  
  public void a()
  {
    bdeo.a(this.jdField_a_of_type_Bdeo).getAndSet(0);
    bdeo.a(this.b).getAndSet(0);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bdeo.a(this.jdField_a_of_type_Bdeo).getAndAdd(0) == 0)
    {
      bool1 = bool2;
      if (bdeo.a(this.b).getAndAdd(0) == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("SharedMemoryCacheProcessor");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      PtvFilterUtils.a(this.jdField_a_of_type_AndroidOsHandlerThread);
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bden
 * JD-Core Version:    0.7.0.1
 */