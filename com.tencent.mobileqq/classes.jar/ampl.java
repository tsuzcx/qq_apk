import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.1;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2;
import java.util.List;

public class ampl
{
  private ampx jdField_a_of_type_Ampx;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  
  public ampl(ampx paramampx)
  {
    this.jdField_a_of_type_Ampx = paramampx;
  }
  
  private Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuMeasureThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new amrn());
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return this.jdField_a_of_type_AndroidOsHandler;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        amrq.d("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
  }
  
  public static void a(ampx paramampx, ampo paramampo)
  {
    if (paramampo.b()) {
      return;
    }
    paramampx = paramampx.a(paramampo).a(paramampo);
    paramampo.d(paramampx.a() + ampx.a().g() * 2);
    paramampo.e(paramampx.b() + ampx.a().c() * 2);
    paramampo.g();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (amro.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(ampo paramampo, ampm paramampm)
  {
    Handler localHandler = a();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramampo, paramampm));
    }
  }
  
  public void a(List<ampo> paramList, ampm paramampm)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Handler localHandler;
    do
    {
      return;
      localHandler = a();
    } while (localHandler == null);
    localHandler.post(new DanmakuMeasureManager.2(this, paramList, paramampm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampl
 * JD-Core Version:    0.7.0.1
 */