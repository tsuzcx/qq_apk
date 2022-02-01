public class bfwt
{
  public static long a(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwt
 * JD-Core Version:    0.7.0.1
 */