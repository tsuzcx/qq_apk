import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.1;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2;
import java.util.List;

public class artz
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private arul jdField_a_of_type_Arul;
  
  public artz(arul paramarul)
  {
    this.jdField_a_of_type_Arul = paramarul;
  }
  
  private Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuMeasureThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new arwb());
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return this.jdField_a_of_type_AndroidOsHandler;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        arwe.d("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
  }
  
  public static void a(arul paramarul, aruc paramaruc)
  {
    if (paramaruc.b()) {
      return;
    }
    paramarul = paramarul.a(paramaruc).a(paramaruc);
    paramaruc.d(paramarul.a() + arul.a().g() * 2);
    paramaruc.e(paramarul.b() + arul.a().c() * 2);
    paramaruc.g();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (arwc.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(aruc paramaruc, arua paramarua)
  {
    Handler localHandler = a();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramaruc, paramarua));
    }
  }
  
  public void a(List<aruc> paramList, arua paramarua)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Handler localHandler;
    do
    {
      return;
      localHandler = a();
    } while (localHandler == null);
    localHandler.post(new DanmakuMeasureManager.2(this, paramList, paramarua));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artz
 * JD-Core Version:    0.7.0.1
 */