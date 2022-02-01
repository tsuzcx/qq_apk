import com.tencent.mobileqq.app.AppConstants;

public class bhwc
{
  public static int a(int paramInt)
  {
    int i = 1;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 4)) {
      i = 2;
    }
    while (paramInt == 5) {
      return i;
    }
    return 3;
  }
  
  public static int a(int paramInt, String paramString)
  {
    int i = 1;
    if (paramInt == 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt == 3000) {
      return 2;
    }
    if (AppConstants.QZONE_UIN.equals(paramString)) {
      return 3;
    }
    if (AppConstants.FAVORITES_UIN.equals(paramString)) {
      return 4;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramString)) {
      return 5;
    }
    return -1;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwc
 * JD-Core Version:    0.7.0.1
 */