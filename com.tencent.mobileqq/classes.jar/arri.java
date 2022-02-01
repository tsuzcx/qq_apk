import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.1;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2;
import java.util.List;

public class arri
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private arru jdField_a_of_type_Arru;
  
  public arri(arru paramarru)
  {
    this.jdField_a_of_type_Arru = paramarru;
  }
  
  private Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuMeasureThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new artk());
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return this.jdField_a_of_type_AndroidOsHandler;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        artm.d("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
  }
  
  public static void a(arru paramarru, arrl paramarrl)
  {
    if (paramarrl.b()) {
      return;
    }
    paramarru = paramarru.a(paramarrl).a(paramarrl);
    paramarrl.d(paramarru.a() + arru.a().g() * 2);
    paramarrl.e(paramarru.b() + arru.a().c() * 2);
    paramarrl.g();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (artl.b())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(arrl paramarrl, arrj paramarrj)
  {
    Handler localHandler = a();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramarrl, paramarrj));
    }
  }
  
  public void a(List<arrl> paramList, arrj paramarrj)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Handler localHandler;
    do
    {
      return;
      localHandler = a();
    } while (localHandler == null);
    localHandler.post(new DanmakuMeasureManager.2(this, paramList, paramarrj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arri
 * JD-Core Version:    0.7.0.1
 */