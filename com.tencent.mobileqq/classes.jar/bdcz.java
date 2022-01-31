public class bdcz
{
  public static int a = 40000;
  public static int b = 30000;
  public static int c = 20000;
  public static int d = 20000;
  public static int e = 15000;
  public static int f = 10000;
  public static int g;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return a;
    case 1: 
    case 4: 
    case 5: 
      return c;
    }
    return b;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return d + g;
    case 1: 
    case 4: 
    case 5: 
      return f + g;
    }
    return e + g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcz
 * JD-Core Version:    0.7.0.1
 */