import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nonnull;
import mqq.app.MobileQQ;

public class arkn
{
  private static volatile String a;
  
  public static int a(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    int i = 1;
    if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool")) {}
    do
    {
      try
      {
        paramContext = new Intent();
        paramContext.setAction("action_show_together_floating_windows");
        paramContext.setPackage(MobileQQ.getContext().getPackageName());
        paramContext.putExtra("com.tencent.mobileqq.webprocess.together.floating.data", paramWatchTogetherFloatingData);
        paramContext.setComponent(new ComponentName(MobileQQ.getContext(), "com.tencent.mobileqq.webprocess.WebProcessReceiver"));
        BaseApplicationImpl.getContext().sendBroadcast(paramContext, "com.tencent.msg.permission.pushnotify");
        if (QLog.isColorLevel()) {
          QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "showFloatingWindow main..., data=", paramWatchTogetherFloatingData.toString() });
        }
        i = 0;
        return i;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherWatchFloatingUtil", 2, "showFloatingWindow fail...", paramContext);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "showFloatingWindow tool..., data=", paramWatchTogetherFloatingData.toString() });
      }
    } while (arkt.a().a(paramContext, paramWatchTogetherFloatingData) == 0);
    return 2;
  }
  
  public static Dialog a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    bctm.b();
    paramContext = bbcv.a(paramContext, 230, null, "一起看将收起为小窗进行展示，请开启QQ悬浮窗权限以正常使用功能。", paramContext.getString(2131690596), paramContext.getString(2131694793), new arko(paramContext), null);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, Intent paramIntent)
  {
    paramContext = bfol.a(paramContext);
    paramContext.b(2131717267);
    paramContext.a(2131690838, 3);
    paramContext.c(2131690596);
    paramContext.a(new arkp(paramIntent, paramContext));
    return paramContext;
  }
  
  public static void a()
  {
    a = "";
    if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool"))
    {
      Bundle localBundle = new Bundle();
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WatchTogetherClientIPCModule", "ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS", localBundle, new arks());
      return;
    }
    arkt.a().b();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("key_dialog_type", paramInt);
    localIntent.putExtra("cur_uin", paramString);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool"))
    {
      boolean bool1 = b(2, paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType());
      boolean bool2 = a();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "closeFloatingWindow isSameFloatingInfo=", Boolean.valueOf(bool1), "isFloatingInfoEmpty=", Boolean.valueOf(bool2) });
      }
      if ((!bool1) && (!bool2)) {
        return;
      }
      a = "";
      paramContext = new Bundle();
      paramContext.putSerializable("BUNDLE_KEY_UI_DATA", paramWatchTogetherFloatingData);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WatchTogetherClientIPCModule", "ACTION_QUIT_WATCH_FLOATING_WINDOWS", paramContext, new arkr());
      return;
    }
    arkt.a().a(paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
  }
  
  public static void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "setIsWatchFloatingShow isShow=", Boolean.valueOf(paramBoolean1), " uin=", paramString, " sessionType=", Integer.valueOf(paramInt) });
    }
    if (!paramBoolean1) {}
    for (a = "";; a = "2_" + paramString + "_" + paramInt)
    {
      if (7 == BaseApplicationImpl.sProcessId)
      {
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("BUNDLE_SET_KEY_REFRESH_UI", paramBoolean2);
        localBundle.putBoolean("BUNDLE_SET_STATUS", paramBoolean1);
        localBundle.putString("BUNDLE_SET_KEY_UIN", paramString);
        localBundle.putInt("BUNDLE_SET_KEY_SESSION_TYPE", paramInt);
        QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_set_floating", localBundle, new arkq());
      }
      return;
    }
  }
  
  public static boolean a()
  {
    return TextUtils.isEmpty(a);
  }
  
  public static boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 2) {}
    do
    {
      do
      {
        return false;
        if (QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")) {
          break;
        }
        a = null;
      } while (!QLog.isColorLevel());
      QLog.d("TogetherWatchFloatingUtil", 2, "isWatchFloatingShow， tool process NOT EXIST");
      return false;
    } while ((1 != BaseApplicationImpl.sProcessId) && (7 != BaseApplicationImpl.sProcessId));
    paramString = paramInt1 + "_" + paramString + "_" + paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "key=", paramString, " info=", a });
    }
    return TextUtils.equals(paramString, a);
  }
  
  public static boolean b()
  {
    return a == null;
  }
  
  public static boolean b(int paramInt1, String paramString, int paramInt2)
  {
    return TextUtils.equals(paramInt1 + "_" + paramString + "_" + paramInt2, a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkn
 * JD-Core Version:    0.7.0.1
 */