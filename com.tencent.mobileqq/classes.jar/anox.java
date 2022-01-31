import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.1;

public class anox
{
  protected static boolean a = false;
  
  public static void a()
  {
    if (!a) {
      a = true;
    }
  }
  
  public static void a(anoz paramanoz)
  {
    ThreadManager.post(new ArkMessageServerLogic.1(paramanoz), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anox
 * JD-Core Version:    0.7.0.1
 */