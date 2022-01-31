import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class beqi
{
  public static final String a = bepk.a().a().getFilesDir().getPath() + "/mini/";
  public static final String b = a + ".baseLib";
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return b + File.separator + bfgc.c(paramString1) + "_" + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqi
 * JD-Core Version:    0.7.0.1
 */