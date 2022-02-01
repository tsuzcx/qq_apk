public class bddq
{
  public static long a()
  {
    return b(1) - c(1);
  }
  
  public static long a(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory() - a() * 1024L;
    switch (paramInt)
    {
    case 0: 
    default: 
      return l;
    case 1: 
      return l / 1024L;
    }
    return l / 1048576L;
  }
  
  private static long b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().totalMemory();
    case 0: 
      return Runtime.getRuntime().totalMemory();
    case 1: 
      return Runtime.getRuntime().totalMemory() / 1024L;
    }
    return Runtime.getRuntime().totalMemory() / 1024L / 1024L;
  }
  
  private static long c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().freeMemory();
    case 0: 
      return Runtime.getRuntime().freeMemory();
    case 1: 
      return Runtime.getRuntime().freeMemory() / 1024L;
    }
    return Runtime.getRuntime().freeMemory() / 1024L / 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddq
 * JD-Core Version:    0.7.0.1
 */