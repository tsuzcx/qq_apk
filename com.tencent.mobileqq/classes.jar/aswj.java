import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aswj
{
  public static String a = "";
  
  public static Intent a(Context paramContext, AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext();
        localObject = new Intent((Context)localObject, QQBrowserActivity.class);
        paramContext = "http://y.qq.com/m/personal_music/index.html?_wv=3&_bid=2032";
        if (paramAppInterface != null) {}
        try
        {
          paramContext = "http://y.qq.com/m/personal_music/index.html?_wv=3&_bid=2032" + "&uin=" + paramAppInterface.getCurrentAccountUin();
          paramAppInterface = paramContext;
          if (!TextUtils.isEmpty(paramString)) {
            paramAppInterface = paramContext + "&guestuin=" + paramString;
          }
          if (!paramBoolean) {
            continue;
          }
          paramContext = paramAppInterface + "&ADTAG=GXYY_GUAJIAN";
          ((Intent)localObject).putExtra("url", paramContext);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          return localObject;
        }
        catch (Exception paramAppInterface)
        {
          paramContext = (Context)localObject;
        }
        QLog.e("MusicPendantUtil", 1, "openMusicPendantSettingPage() app is null.");
        continue;
      }
      catch (Exception paramAppInterface)
      {
        paramContext = null;
        continue;
      }
      QLog.e("MusicPendantUtil", 1, "getPlayBarIntent() exception", paramAppInterface);
      return paramContext;
      paramContext = paramAppInterface + "&ADTAG=GXYY_TOPCELL";
    }
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(a)) {}
    try
    {
      a = QQPlayerService.a(6, "MusicPendantUtil");
      return a;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPendantUtil", 1, "MusicPendantManager() exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswj
 * JD-Core Version:    0.7.0.1
 */