import dov.com.qq.im.capture.mode.CaptureModeController;

public class bjcn
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
  
  public static bjcl a(int paramInt, CaptureModeController paramCaptureModeController)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return new bjco(paramCaptureModeController);
    case 1: 
      return new bjcp(paramCaptureModeController);
    case 4: 
      return new bjcx(paramCaptureModeController);
    case 2: 
      return new bjct(paramCaptureModeController);
    case 5: 
      return new bjrh(paramCaptureModeController);
    case 10: 
      return new bjcw(paramCaptureModeController);
    }
    if ((paramCaptureModeController.a instanceof bihg)) {
      return new bjcp(paramCaptureModeController);
    }
    return new bjco(paramCaptureModeController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcn
 * JD-Core Version:    0.7.0.1
 */