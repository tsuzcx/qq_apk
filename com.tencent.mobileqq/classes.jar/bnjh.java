import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;

public class bnjh
{
  public static void a()
  {
    try
    {
      GLCapabilities.init(false);
      bnrh.b("AECMShowUtil", "init3DCapabilityChecker: init finish");
      return;
    }
    catch (Throwable localThrowable)
    {
      bnrh.a("AECMShowUtil", "[init3DCapabilityChecker], error=", localThrowable);
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = Ace3DEngineInitializer.supportAceEngine();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      bnrh.a("AECMShowUtil", "[isCMShowSupported], error=", localThrowable);
    }
    return false;
  }
  
  public static boolean b()
  {
    return (bnky.c(bnkt.b)) && (bnky.c(bnkt.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjh
 * JD-Core Version:    0.7.0.1
 */