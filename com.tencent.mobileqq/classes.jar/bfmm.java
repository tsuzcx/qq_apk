import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class bfmm
{
  public static void a(Context paramContext)
  {
    String str = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.4.5", Integer.valueOf(0) });
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).overridePendingTransition(2130771992, 2130771993);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "enterTroopCreate");
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {}
    for (String str = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.4.5", Integer.valueOf(1) });; str = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.4.5", Integer.valueOf(0) }))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("troop_create_from", paramInt);
      ((BaseActivity)paramContext).startActivityForResult(localIntent, 51);
      ((Activity)paramContext).overridePendingTransition(2130771992, 2130771993);
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopCreate", 2, "enterTroopCreateForResult");
      }
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    if ((paramContext == null) || (paramBundle == null)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = String.format("https://admin.qun.qq.com/mcreatev3/index.html?_bid=206&ver=%s&clientversion=%s&fromlocation=%s&_wv=2097152", new Object[] { "1", "8.4.5", Integer.valueOf(0) });
    paramString = (String)localObject + String.format("&initgrouptype=%s", new Object[] { paramString });
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("isShowAd", false);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    paramContext.startActivity((Intent)localObject);
    ((Activity)paramContext).overridePendingTransition(2130771992, 2130771993);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "enterTroopCreateFromH5");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", false);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmm
 * JD-Core Version:    0.7.0.1
 */