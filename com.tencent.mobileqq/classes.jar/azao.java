import java.util.Calendar;

public class azao
{
  public static int a(int paramInt)
  {
    int i = 0;
    if (paramInt > 0) {
      i = Calendar.getInstance().get(1) - ((0xFFFF0000 & paramInt) >> 16);
    }
    return i;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return (0xFF00 & paramInt) >> 8;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return paramInt & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azao
 * JD-Core Version:    0.7.0.1
 */