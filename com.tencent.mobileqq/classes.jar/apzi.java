import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.1;

public class apzi
{
  protected static boolean a = false;
  
  public static void a()
  {
    if (!a) {
      a = true;
    }
  }
  
  public static void a(apzk paramapzk)
  {
    ThreadManager.post(new ArkMessageServerLogic.1(paramapzk), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzi
 * JD-Core Version:    0.7.0.1
 */