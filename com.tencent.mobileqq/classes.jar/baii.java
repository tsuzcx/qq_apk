import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.teamwork.TenDocWebPreLoadHelper.1;
import com.tencent.qphone.base.util.QLog;

public class baii
{
  public static volatile String a = "";
  
  public static TouchWebView a(Context paramContext)
  {
    baij localbaij = baij.a();
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.sApplication;
    }
    return localbaij.a((Context)localObject);
  }
  
  public static void a(String paramString)
  {
    QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preCreateWebViewNoWebProcess ");
    baij.a().a(paramString);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (!aoyh.a().a()) {}
    while ((paramActivity == null) || (TextUtils.isEmpty(paramString)) || ((!(paramActivity instanceof TeamWorkDocEditBrowserActivity)) && (!baic.c(paramString))) || (!baij.a().a()) || ((!paramString.contains(a)) && (a != null))) {
      return false;
    }
    return true;
  }
  
  public static void b(String paramString)
  {
    QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preloadTenDocUrl ");
    if (!TextUtils.isEmpty(paramString))
    {
      a = paramString;
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label61;
      }
      if ((baic.c(paramString)) && (!baij.a().a(paramString)))
      {
        baij.a().a(paramString);
        baij.a().a(paramString);
      }
    }
    return;
    label61:
    new Handler(Looper.getMainLooper()).post(new TenDocWebPreLoadHelper.1(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baii
 * JD-Core Version:    0.7.0.1
 */