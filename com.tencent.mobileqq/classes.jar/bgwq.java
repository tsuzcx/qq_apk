import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bgwq
{
  private static volatile long jdField_a_of_type_Long;
  private static bafb jdField_a_of_type_Bafb;
  private static bgwu jdField_a_of_type_Bgwu = new bgwu(Looper.getMainLooper());
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "TroopFileDetailBrowserActivity", "FMActivity", "FileBrowserActivity", "ChatHistoryFileActivity", "FileAssistantActivity" };
  
  public static void a()
  {
    Message localMessage = jdField_a_of_type_Bgwu.obtainMessage();
    localMessage.what = 3001;
    jdField_a_of_type_Bgwu.sendMessage(localMessage);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (a(paramInt)) {
      b(paramActivity, paramInt);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer("https://jump.weiyun.com?from=3092");
    if (paramString != null) {
      localStringBuffer.append("&aid=").append(paramString);
    }
    paramString = new Intent();
    paramString.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
    paramString.putExtra("url", localStringBuffer.toString());
    if (paramBoolean)
    {
      paramActivity.startActivityForResult(paramString, 2000);
      return;
    }
    paramActivity.startActivity(paramString);
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_Long == 0L) {}
    long l;
    do
    {
      return true;
      l = SystemClock.uptimeMillis();
    } while (jdField_a_of_type_Long + 4000L < l);
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    return (c(paramInt)) || (b(paramInt));
  }
  
  private static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getClass().getName();
      arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((!TextUtils.isEmpty(paramActivity)) && (paramActivity.contains(str))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void b(Activity paramActivity, int paramInt)
  {
    QLog.d("OpenWeiyunVipHelper", 2, "showLimitDialog");
    jdField_a_of_type_Bgwu.removeMessages(3000);
    Message localMessage = jdField_a_of_type_Bgwu.obtainMessage();
    localMessage.what = 3000;
    localMessage.obj = paramActivity;
    localMessage.arg1 = paramInt;
    jdField_a_of_type_Bgwu.sendMessageDelayed(localMessage, 1000L);
  }
  
  public static void b(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    paramString = String.format("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    if (paramBoolean)
    {
      paramActivity.startActivityForResult(localIntent, 2000);
      return;
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1053) || (paramInt == 22081);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 1127) || (paramInt == 22000);
  }
  
  private static void d(Activity paramActivity, int paramInt)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramActivity != BaseActivity.sTopActivity))
    {
      paramActivity = BaseActivity.sTopActivity;
      if ((paramActivity != null) && (!paramActivity.isFinishing()) && (a(paramActivity))) {
        break label44;
      }
    }
    label44:
    while (((jdField_a_of_type_Bafb != null) && (jdField_a_of_type_Bafb.isShowing())) || (!a()))
    {
      return;
      break;
    }
    String str1;
    if (b(paramInt))
    {
      str1 = BaseApplicationImpl.getContext().getString(2131627076);
      if (!b(paramInt)) {
        break label161;
      }
    }
    label161:
    for (String str2 = BaseApplicationImpl.getContext().getString(2131627071);; str2 = BaseApplicationImpl.getContext().getString(2131627073))
    {
      jdField_a_of_type_Bafb = babr.a(paramActivity, 230, str1, str2, 2131627074, 2131627075, new bgwr(paramInt, paramActivity), new bgws());
      jdField_a_of_type_Bafb.setOnDismissListener(new bgwt());
      jdField_a_of_type_Bafb.show();
      return;
      str1 = BaseApplicationImpl.getContext().getString(2131627077);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwq
 * JD-Core Version:    0.7.0.1
 */