import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.WeiyunSaveTipsFactory.1;
import mqq.os.MqqHandler;

public class bnzt
{
  private static void a(Activity paramActivity, String paramString, int paramInt)
  {
    MiniAppLauncher.startMiniApp(paramActivity, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (paramQQAppInterface.a().a() == true)
    {
      paramQQAppInterface.a().c();
      return;
    }
    if (bhnv.d(BaseApplication.getContext()))
    {
      paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
      paramQQAppInterface.putExtra("tab_tab_type", 3);
      paramQQAppInterface.putExtra("from", "FileAssistant");
      paramActivity.startActivityForResult(paramQQAppInterface, 101);
      return;
    }
    auna.a(BaseApplication.getContext().getString(2131693963));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null)) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new WeiyunSaveTipsFactory.1(paramActivity, paramInt, paramQQAppInterface), 1000L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext)
  {
    int i = bhsi.aS(paramContext, paramQQAppInterface.getCurrentAccountUin());
    if (i == 1)
    {
      String str = bhsi.u(paramContext, paramQQAppInterface.getCurrentAccountUin());
      i = bhsi.aT(paramContext, paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(str)) {
        try
        {
          a(paramActivity, str, i);
          return;
        }
        catch (MiniAppException paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("WeiyunSaveTipsFactory", 2, "fail to open weiyun mini app!");
          }
          a(paramQQAppInterface, paramActivity);
          return;
        }
      }
      QLog.w("WeiyunSaveTipsFactory", 2, "can not to start WeiYun Mini app, apkgUrl = " + str + ", version = " + i);
      a(paramQQAppInterface, paramActivity);
      return;
    }
    QLog.w("WeiyunSaveTipsFactory", 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + i);
    a(paramQQAppInterface, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzt
 * JD-Core Version:    0.7.0.1
 */