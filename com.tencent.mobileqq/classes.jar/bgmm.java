import com.tencent.mobileqq.troop.utils.TroopUploadingThread;

public class bgmm
{
  public static <T extends bgmn> T a(Class<T> paramClass)
  {
    try
    {
      paramClass = (bgmn)Class.forName(paramClass.getName()).newInstance();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgmm
 * JD-Core Version:    0.7.0.1
 */