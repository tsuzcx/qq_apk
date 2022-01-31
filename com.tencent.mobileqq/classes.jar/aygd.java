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

public class aygd
{
  public static volatile String a = "";
  
  public static TouchWebView a(Context paramContext)
  {
    ayge localayge = ayge.a();
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.sApplication;
    }
    return localayge.a((Context)localObject);
  }
  
  public static void a(String paramString)
  {
    QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preCreateWebViewNoWebProcess ");
    ayge.a().a(paramString);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (!ancr.a().a()) {}
    while ((paramActivity == null) || (TextUtils.isEmpty(paramString)) || ((!(paramActivity instanceof TeamWorkDocEditBrowserActivity)) && (!ayfx.c(paramString))) || (!ayge.a().a()) || ((!paramString.contains(a)) && (a != null))) {
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
      if ((ayfx.c(paramString)) && (!ayge.a().a(paramString)))
      {
        ayge.a().a(paramString);
        ayge.a().a(paramString);
      }
    }
    return;
    label61:
    new Handler(Looper.getMainLooper()).post(new TenDocWebPreLoadHelper.1(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aygd
 * JD-Core Version:    0.7.0.1
 */