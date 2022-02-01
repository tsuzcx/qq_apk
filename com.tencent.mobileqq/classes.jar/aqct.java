import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.1;

public class aqct
{
  protected static boolean a = false;
  
  public static void a()
  {
    if (!a) {
      a = true;
    }
  }
  
  public static void a(aqcv paramaqcv)
  {
    ThreadManager.post(new ArkMessageServerLogic.1(paramaqcv), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqct
 * JD-Core Version:    0.7.0.1
 */