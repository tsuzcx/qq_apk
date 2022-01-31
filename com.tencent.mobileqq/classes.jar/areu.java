import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;

public class areu
{
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    String str = QzoneConfig.getInstance().getConfig("sweet_miniapp", "sweet_mainpage", "mqqapi://miniapp/open?_atype=0&_mappid=1108789561&_mvid=&_vt=3&referer=brandonlin&via=brandonlin&_sig=57b13f050e544ea7391452287c2f92c7ebf08e0d4bd1faef7d72c8c961ea80c9");
    if (!TextUtils.isEmpty(str))
    {
      if (!MiniAppLauncher.isMiniAppUrl(str)) {
        break label86;
      }
      MiniAppLauncher.startMiniApp(paramContext, str, paramInt, null);
    }
    for (;;)
    {
      LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", paramString, "2"));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("intimate_relationship", 2, String.format("goToLoverZone, url: %s", new Object[] { str }));
      return;
      label86:
      if ((str.startsWith("mqqapi://")) && (paramQQAppInterface != null))
      {
        paramQQAppInterface = bade.a(paramQQAppInterface, paramContext, str);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.c();
        }
      }
      else if (paramQQAppInterface != null)
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", str.replace("{hostuin}", paramQQAppInterface.getCurrentAccountUin()));
        localIntent.putExtra("injectrecommend", true);
        localIntent.putExtra("finish_animation_out_to_right", true);
        localIntent.putExtra("is_wrap_content", true);
        localIntent.putExtra("hide_left_button", false);
        paramContext.startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     areu
 * JD-Core Version:    0.7.0.1
 */