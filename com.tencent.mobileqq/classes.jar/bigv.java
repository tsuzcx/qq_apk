import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bigv
{
  private static volatile boolean a;
  private static boolean b;
  
  public static String a(String paramString)
  {
    if (!a) {}
    String str3;
    try
    {
      b = "mounted".equals(Environment.getExternalStorageState());
      a = true;
      String str1 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        if (b)
        {
          str3 = bigw.a().a();
          if ((!paramString.startsWith("/")) && (paramString.indexOf(":") <= 0)) {
            break label149;
          }
          str1 = paramString;
          if (str3 != null)
          {
            str1 = paramString;
            if (!paramString.startsWith(str3))
            {
              str1 = paramString;
              if (paramString.startsWith(bigw.a().b()))
              {
                String[] arrayOfString = paramString.split(bigw.a().b());
                str1 = paramString;
                if (arrayOfString.length >= 2) {
                  str1 = str3 + arrayOfString[1];
                }
              }
            }
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      label149:
      do
      {
        for (;;)
        {
          QLog.e("VFSAssistantUtils", 1, "getSDKPrivatePath is called!", localException);
        }
        String str2 = paramString;
      } while (str3 == null);
    }
    return str3 + File.separator + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigv
 * JD-Core Version:    0.7.0.1
 */