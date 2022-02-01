import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;
import java.util.TreeMap;

public class anzr
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!SystemUtil.isExistSDCard()) {
        break label56;
      }
    }
    label56:
    for (String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(anzl paramanzl)
  {
    if (paramanzl == null) {
      return null;
    }
    paramanzl = (anzm)paramanzl.a().get(Integer.valueOf(0));
    if (paramanzl == null) {
      return null;
    }
    return a(paramanzl);
  }
  
  public static String a(anzm paramanzm)
  {
    return paramanzm.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(anzl paramanzl)
  {
    paramanzl = (anzm)paramanzl.a().get(Integer.valueOf(0));
    if (paramanzl == null) {
      return null;
    }
    return b(paramanzl);
  }
  
  public static String b(anzm paramanzm)
  {
    return paramanzm.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzr
 * JD-Core Version:    0.7.0.1
 */