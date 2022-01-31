public class awnc
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "STATE_UNKNOW";
    case 0: 
      return "STATE_IDLE";
    case 1: 
      return "STATE_SDK_INITING";
    case 2: 
      return "STATE_PREPARING";
    case 3: 
      return "STATE_PLAYING";
    case 4: 
      return "STATE_BUFFERING";
    case 5: 
      return "STATE_PAUSE";
    case 6: 
      return "STATE_ERROR";
    case 7: 
      return "STATE_COMPLETE";
    }
    return "STATE_RELEASED";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awnc
 * JD-Core Version:    0.7.0.1
 */