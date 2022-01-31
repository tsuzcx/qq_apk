import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.1;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2;
import java.util.List;

public class anfx
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private angj jdField_a_of_type_Angj;
  
  public anfx(angj paramangj)
  {
    this.jdField_a_of_type_Angj = paramangj;
  }
  
  private Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuMeasureThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new anhz());
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return this.jdField_a_of_type_AndroidOsHandler;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        anic.d("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
  }
  
  public static void a(angj paramangj, anga paramanga)
  {
    if (paramanga.b()) {
      return;
    }
    paramangj = paramangj.a(paramanga).a(paramanga);
    paramanga.d(paramangj.a() + angj.a().g() * 2);
    paramanga.e(paramangj.b() + angj.a().c() * 2);
    paramanga.g();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (ania.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(anga paramanga, anfy paramanfy)
  {
    Handler localHandler = a();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramanga, paramanfy));
    }
  }
  
  public void a(List<anga> paramList, anfy paramanfy)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Handler localHandler;
    do
    {
      return;
      localHandler = a();
    } while (localHandler == null);
    localHandler.post(new DanmakuMeasureManager.2(this, paramList, paramanfy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfx
 * JD-Core Version:    0.7.0.1
 */