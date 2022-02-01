import dov.com.qq.im.capture.mode.CaptureModeController;

public class bmsu
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 4;
    case 3: 
      return 2;
    }
    return 10;
  }
  
  public static bmst a(int paramInt, CaptureModeController paramCaptureModeController)
  {
    switch (paramInt)
    {
    default: 
      return new bmsv(paramCaptureModeController);
    case 1: 
      return new bmsw(paramCaptureModeController);
    case 10: 
      return new bmsz(paramCaptureModeController);
    }
    return new bmsv(paramCaptureModeController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsu
 * JD-Core Version:    0.7.0.1
 */