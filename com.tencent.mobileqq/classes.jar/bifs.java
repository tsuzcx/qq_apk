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

public class bifs
{
  private static volatile long jdField_a_of_type_Long;
  private static bbgg jdField_a_of_type_Bbgg;
  private static bifw jdField_a_of_type_Bifw = new bifw(Looper.getMainLooper());
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "TroopFileDetailBrowserActivity", "FMActivity", "FileBrowserActivity", "ChatHistoryFileActivity", "FileAssistantActivity" };
  
  public static void a()
  {
    Message localMessage = jdField_a_of_type_Bifw.obtainMessage();
    localMessage.what = 3001;
    jdField_a_of_type_Bifw.sendMessage(localMessage);
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
    jdField_a_of_type_Bifw.removeMessages(3000);
    Message localMessage = jdField_a_of_type_Bifw.obtainMessage();
    localMessage.what = 3000;
    localMessage.obj = paramActivity;
    localMessage.arg1 = paramInt;
    jdField_a_of_type_Bifw.sendMessageDelayed(localMessage, 1000L);
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
    while (((jdField_a_of_type_Bbgg != null) && (jdField_a_of_type_Bbgg.isShowing())) || (!a()))
    {
      return;
      break;
    }
    String str1;
    if (b(paramInt))
    {
      str1 = BaseApplicationImpl.getContext().getString(2131692714);
      if (!b(paramInt)) {
        break label161;
      }
    }
    label161:
    for (String str2 = BaseApplicationImpl.getContext().getString(2131692709);; str2 = BaseApplicationImpl.getContext().getString(2131692711))
    {
      jdField_a_of_type_Bbgg = bbcv.a(paramActivity, 230, str1, str2, 2131692712, 2131692713, new bift(paramInt, paramActivity), new bifu());
      jdField_a_of_type_Bbgg.setOnDismissListener(new bifv());
      jdField_a_of_type_Bbgg.show();
      return;
      str1 = BaseApplicationImpl.getContext().getString(2131692715);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifs
 * JD-Core Version:    0.7.0.1
 */