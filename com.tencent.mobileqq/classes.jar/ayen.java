import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

public class ayen
{
  private static final String a = ayen.class.getSimpleName();
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      bisy.b(a, "enter now live room. mqqapi= " + paramString);
    }
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.putExtra("big_brother_source_key", "biz_src_now");
      paramActivity.startActivity(paramString);
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        bisy.b(a, "enter now live room error: " + paramActivity.getMessage());
      }
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramActivity != null) && (!bgnt.g(paramActivity.getApplication()))) {
      bljz.a(paramActivity, 2131693959, 1);
    }
    for (;;)
    {
      return false;
      if ((paramString != null) && (paramString.startsWith("mqqapi://"))) {
        return a(paramActivity, paramString);
      }
      if (paramInt1 > 0) {}
      for (paramString = "mqqapi://now/openroom?first=1&roomid=" + paramInt1 + "&roomtype=0&startsrc=" + paramInt2 + "&fromid=" + paramInt2; (paramString != null) && (paramString.length() > 0); paramString = null) {
        for (;;)
        {
          return a(paramActivity, paramString);
          if ((paramString != null) && (paramString.contains("roomid="))) {
            try
            {
              paramString = Uri.parse(paramString).getQueryParameter("roomid");
              paramString = "mqqapi://now/openroom?first=1&roomid=" + paramString + "&roomtype=0&startsrc=" + paramInt2 + "&fromid=" + paramInt2;
            }
            catch (Exception paramString)
            {
              QLog.e(a, 2, paramString, new Object[0]);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayen
 * JD-Core Version:    0.7.0.1
 */