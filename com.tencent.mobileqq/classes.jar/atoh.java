public class atoh
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " Unknow playState ";
    case 0: 
      return " IDLE ";
    case 1: 
      return " BUFFERING ";
    case 2: 
      return " PLAYING ";
    case 3: 
      return " PAUSE ";
    case 4: 
      return " STOP ";
    case 5: 
      return " ERROR_INTERNAL ";
    case 7: 
      return " ERROR_FOCUS ";
    case 6: 
      return " NETWORK_INTERRUPT ";
    }
    return " COMPLETION ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atoh
 * JD-Core Version:    0.7.0.1
 */