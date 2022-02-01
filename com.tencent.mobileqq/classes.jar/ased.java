import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.StringUtil;

public class ased
{
  public static int a = 300;
  
  public static String a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("_");
    if (paramString.length > 2) {
      return paramString[1];
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2))) {
      return "";
    }
    paramString2 = bjkp.a(paramString2);
    return AppConstants.SDCARD_IMG_CAMERA_EMO + paramString2 + paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ased
 * JD-Core Version:    0.7.0.1
 */