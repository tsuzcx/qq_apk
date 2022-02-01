import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.qphone.base.util.QLog;

public class bghc
{
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    if ((paramContext == null) || (paramInt == 0)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?idol_id=%1$s&_wv=16777216&_wwv=128", new Object[] { Integer.valueOf(paramInt) }));
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&_wv=16777216&_wwv=128", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/bind?gc=%1$s&_wv=16777218&_wwv=129", new Object[] { paramString }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramInt == 0)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&show=1&_wv=16777216&_wwv=128", new Object[] { paramString, Integer.valueOf(paramInt) }));
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a()
  {
    bacq localbacq = (bacq)aqxe.a().a(701);
    if ((localbacq == null) || (!localbacq.a())) {
      return false;
    }
    return !bdvn.a();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramTroopInfoExt == null)) {
      return false;
    }
    int j = paramTroopInfoExt.star_id;
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    if (paramQQAppInterface != null) {}
    for (int i = paramQQAppInterface.getFansTroopStarId();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FansTroopUtils", 2, new Object[] { "isIdolBindStatusChanged oldId=", Integer.valueOf(j), ", newid=", Integer.valueOf(i) });
      }
      if (j == i) {
        break;
      }
      return true;
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/hot?gc=%1$s&_wv=16777218&_wwv=129", new Object[] { paramString }));
    paramContext.startActivity(localIntent);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramInt == 0)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&_wv=16777216&_wwv=128", new Object[] { paramString, Integer.valueOf(paramInt) }));
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghc
 * JD-Core Version:    0.7.0.1
 */