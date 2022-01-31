import com.tencent.mobileqq.troop.utils.TroopUploadingThread;

public class bclt
{
  public static <T extends bclu> T a(Class<T> paramClass)
  {
    try
    {
      paramClass = (bclu)Class.forName(paramClass.getName()).newInstance();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclt
 * JD-Core Version:    0.7.0.1
 */