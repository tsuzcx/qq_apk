import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.qphone.base.util.QLog;

public class beih
  extends behq
{
  final behr b;
  
  public beih(behr parambehr)
  {
    this.b = parambehr;
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = Uri.parse(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("_wwv");
        bool1 = bool2;
        if (paramString == null) {}
      }
    }
    try
    {
      long l = Long.parseLong(paramString.trim());
      bool1 = bool2;
      if (0L != (0x800 & l)) {
        bool1 = true;
      }
    }
    catch (NumberFormatException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isDevelopLevel());
      QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
    }
    return bool1;
    return false;
  }
  
  public boolean a(Intent paramIntent)
  {
    Activity localActivity = this.b.a();
    String str = paramIntent.getStringExtra("url");
    if ((!TextUtils.isEmpty(str)) && (syb.c(str)) && (!(localActivity instanceof PublicAccountBrowser)) && (!(localActivity instanceof ReadInJoyArticleDetailActivity)) && (!(localActivity instanceof PublicAccountAdvertisementActivity)))
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setComponent(new ComponentName(localActivity, PublicAccountBrowser.class));
      localActivity.startActivity(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserNavigator", 1, "shouldNavigate to  PublicAccountBrowser, url: " + ndq.b(str, new String[0]));
      }
    }
    do
    {
      do
      {
        return false;
        if ((!syb.e(str)) || ((localActivity instanceof PublicAccountBrowser)) || ((localActivity instanceof ReadInJoyArticleDetailActivity)) || ((localActivity instanceof PublicAccountAdvertisementActivity))) {
          break;
        }
        paramIntent = new Intent(paramIntent);
        paramIntent.setComponent(new ComponentName(localActivity, PublicAccountBrowser.class));
        localActivity.startActivity(paramIntent);
      } while (!QLog.isColorLevel());
      QLog.d("SwiftBrowserNavigator", 1, "shouldNavigate to  PublicAccountBrowser, url: " + ndq.b(str, new String[0]));
      return false;
      if ((TextUtils.isEmpty(str)) || (!syb.f(str)) || ((localActivity instanceof PublicAccountBrowser)) || ((localActivity instanceof ReadInJoyArticleDetailActivity)) || ((localActivity instanceof PublicAccountAdvertisementActivity))) {
        break;
      }
      paramIntent = new Intent(paramIntent);
      paramIntent.setComponent(new ComponentName(localActivity, PublicAccountBrowser.class));
      localActivity.startActivity(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserNavigator", 1, "KanDian URL shouldNavigate to  PublicAccountBrowser, url: " + ndq.b(str, new String[0]));
    return false;
    if ((!TextUtils.isEmpty(str)) && (localActivity.getClass() != SingleTaskQQBrowser.class) && (a(str)))
    {
      if (myl.a().j(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserNavigator", 1, "WebViewSwitchAio canSwitchAIO  url " + str);
        }
        paramIntent = new Intent(paramIntent);
        paramIntent.setComponent(new ComponentName(localActivity, SingleTaskQQBrowser.class));
        paramIntent.setFlags(402653184);
        localActivity.startActivity(paramIntent);
        return false;
      }
      QLog.e("SwiftBrowserNavigator", 1, "WebViewSwitchAio want to switchToAIO, but don't have command right. url : " + str);
    }
    return true;
  }
  
  public boolean b(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beih
 * JD-Core Version:    0.7.0.1
 */