import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.1;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2;
import java.util.List;

public class aoxe
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private aoxq jdField_a_of_type_Aoxq;
  
  public aoxe(aoxq paramaoxq)
  {
    this.jdField_a_of_type_Aoxq = paramaoxq;
  }
  
  private Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuMeasureThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new aozg());
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return this.jdField_a_of_type_AndroidOsHandler;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        aozj.d("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
  }
  
  public static void a(aoxq paramaoxq, aoxh paramaoxh)
  {
    if (paramaoxh.b()) {
      return;
    }
    paramaoxq = paramaoxq.a(paramaoxh).a(paramaoxh);
    paramaoxh.d(paramaoxq.a() + aoxq.a().g() * 2);
    paramaoxh.e(paramaoxq.b() + aoxq.a().c() * 2);
    paramaoxh.g();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (!this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {
      return;
    }
    if (aozh.a())
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(aoxh paramaoxh, aoxf paramaoxf)
  {
    Handler localHandler = a();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramaoxh, paramaoxf));
    }
  }
  
  public void a(List<aoxh> paramList, aoxf paramaoxf)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Handler localHandler;
    do
    {
      return;
      localHandler = a();
    } while (localHandler == null);
    localHandler.post(new DanmakuMeasureManager.2(this, paramList, paramaoxf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxe
 * JD-Core Version:    0.7.0.1
 */