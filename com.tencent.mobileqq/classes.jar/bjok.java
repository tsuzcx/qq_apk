import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.YybHandleUtil.1;
import java.io.File;
import java.text.DecimalFormat;
import mqq.os.MqqHandler;

public class bjok
{
  public static String a = "YybHandleUtil";
  public static String b = "APK/MobileAssistant_main.apk";
  public static String c = "yyb.apk";
  public static final String d = anvx.a(2131716387);
  
  public static String a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    float f2 = paramInt;
    paramInt = 0;
    float f1;
    String str2;
    String str1;
    if (f2 / 1048576.0F > 1.0F)
    {
      f1 = f2 / 1048576.0F;
      paramInt = 2;
      str2 = new DecimalFormat("#.#").format(f1);
      if (paramInt != 2) {
        break label92;
      }
      str1 = "MB";
    }
    for (;;)
    {
      return str2 + str1;
      f1 = f2;
      if (f2 / 1024.0F <= 1.0F) {
        break;
      }
      f1 = f2 / 1024.0F;
      paramInt = 1;
      break;
      label92:
      if (paramInt == 1) {
        str1 = "KB";
      } else {
        str1 = "B";
      }
    }
  }
  
  public static void a()
  {
    bjko.c(a, "---deleteYYBApkPackage--");
    ThreadManager.getSubThreadHandler().post(new YybHandleUtil.1());
  }
  
  public static boolean a()
  {
    String str = bizw.a().a().getFilesDir().getAbsolutePath() + File.separator + c;
    return bjlo.a(bizw.a().a(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjok
 * JD-Core Version:    0.7.0.1
 */