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

public class becx
{
  public static volatile String a = "";
  
  public static TouchWebView a(Context paramContext)
  {
    becy localbecy = becy.a();
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.sApplication;
    }
    return localbecy.a((Context)localObject);
  }
  
  public static void a(String paramString)
  {
    QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preCreateWebViewNoWebProcess ");
    becy.a().a(paramString);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (!arof.a().a()) {}
    while ((paramActivity == null) || (TextUtils.isEmpty(paramString)) || ((!(paramActivity instanceof TeamWorkDocEditBrowserActivity)) && (!becr.c(paramString))) || (!becy.a().a()) || ((!paramString.contains(a)) && (a != null))) {
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
      if ((becr.c(paramString)) && (!becy.a().a(paramString)))
      {
        becy.a().a(paramString);
        becy.a().a(paramString);
      }
    }
    return;
    label61:
    new Handler(Looper.getMainLooper()).post(new TenDocWebPreLoadHelper.1(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becx
 * JD-Core Version:    0.7.0.1
 */