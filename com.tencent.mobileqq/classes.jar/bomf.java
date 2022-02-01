import dov.com.qq.im.capture.mode.CaptureModeController;

public class bomf
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
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
    case 4: 
      return 5;
    }
    return 10;
  }
  
  public static bomd a(int paramInt, CaptureModeController paramCaptureModeController)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return new bomg(paramCaptureModeController);
    case 1: 
      return new bomh(paramCaptureModeController);
    case 4: 
      return new bomp(paramCaptureModeController);
    case 2: 
      return new boml(paramCaptureModeController);
    case 5: 
      return new boza(paramCaptureModeController);
    case 10: 
      return new bomo(paramCaptureModeController);
    }
    if ((paramCaptureModeController.a instanceof bncn)) {
      return new bomh(paramCaptureModeController);
    }
    return new bomg(paramCaptureModeController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomf
 * JD-Core Version:    0.7.0.1
 */