import com.tencent.mobileqq.troop.utils.TroopUploadingThread;

public class azlo
{
  public static <T extends azlp> T a(Class<T> paramClass)
  {
    try
    {
      paramClass = (azlp)Class.forName(paramClass.getName()).newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static <T extends Thread> T a(Class<T> paramClass)
  {
    try
    {
      paramClass = (TroopUploadingThread)Class.forName(paramClass.getName()).newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlo
 * JD-Core Version:    0.7.0.1
 */