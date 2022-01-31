import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class amm
  implements Runnable
{
  public amm(HapticManager paramHapticManager) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(HapticManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amm
 * JD-Core Version:    0.7.0.1
 */