import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveLaunchFragment;
import cooperation.ilive.util.IliveEntranceUtil.1;
import java.util.List;

public class bkke
{
  private static long a;
  public static boolean a;
  private static long b;
  public static boolean b;
  
  public static void a(Context paramContext, String paramString)
  {
    QLog.e("IliveEntranceUtil", 1, "liveAnchorEntranceJump source = " + paramString);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("page_type", 1);
    localBundle.putString("source", paramString);
    localBundle.putBoolean("isDebugVersion", false);
    localBundle.putString("qqVersion", AppSetting.jdField_a_of_type_JavaLangString);
    localBundle.putLong("start_time", System.currentTimeMillis());
    localIntent.putExtra("KEY_EXTRAS", localBundle);
    localIntent.putExtra("KEY_IS_START_LIVE", true);
    IliveLaunchFragment.startSelf(paramContext, localIntent);
    bgha.a("anchor_enter_count", null, 0L);
  }
  
  public static void a(bkjl parambkjl)
  {
    if (parambkjl == null) {
      return;
    }
    if (!TextUtils.isEmpty(parambkjl.c)) {}
    try
    {
      parambkjl.c = Uri.decode(parambkjl.c);
      if (TextUtils.isEmpty(parambkjl.e)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        parambkjl.e = Uri.decode(parambkjl.e);
        QLog.e("IliveEntranceUtil", 1, "liveWatchEntranceJump source = " + parambkjl.jdField_a_of_type_JavaLangString + " roomID = " + parambkjl.b + " retain = " + parambkjl.jdField_a_of_type_Boolean + " sIsAnchorIsLive = " + jdField_a_of_type_Boolean + " sIsAudienceIsLive = " + jdField_b_of_type_Boolean);
        if (QLog.isColorLevel()) {
          QLog.i("IliveEntranceUtil", 2, " rtmp = " + parambkjl.c + " closeJump = " + parambkjl.e);
        }
        if (TextUtils.isEmpty(parambkjl.b)) {
          parambkjl.b = "-1";
        }
        if ((jdField_a_of_type_Boolean) && (b(parambkjl.jdField_a_of_type_AndroidContentContext)))
        {
          QLog.e("IliveEntranceUtil", 1, "sIsAnchorIsLive current anchor is live stop jump");
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
        jdField_a_of_type_Boolean = false;
        bgha.a("watch_enter_count", null, 0L);
        Intent localIntent = new Intent();
        Bundle localBundle = new Bundle();
        localBundle.putInt("page_type", 3);
        localBundle.putString("source", parambkjl.jdField_a_of_type_JavaLangString);
        localBundle.putString("room_id", parambkjl.b);
        localBundle.putString("rtmp_Url", parambkjl.c);
        localBundle.putString("cover_url", parambkjl.d);
        localBundle.putLong("start_time", System.currentTimeMillis());
        localBundle.putStringArrayList("playlist", parambkjl.jdField_a_of_type_JavaUtilArrayList);
        localBundle.putInt("from", parambkjl.jdField_a_of_type_Int);
        localBundle.putBoolean("retaion", parambkjl.jdField_a_of_type_Boolean);
        localBundle.putString("close_jump", parambkjl.e);
        localBundle.putBoolean("isDebugVersion", false);
        localBundle.putString("qqVersion", AppSetting.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("KEY_EXTRAS", localBundle);
        localIntent.putExtra("KEY_IS_START_LIVE", false);
        IliveLaunchFragment.startSelf(parambkjl.jdField_a_of_type_AndroidContentContext, localIntent);
      }
    }
  }
  
  public static boolean a()
  {
    return (b(BaseApplicationImpl.getContext())) && ((jdField_a_of_type_Boolean) || (jdField_b_of_type_Boolean));
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    jdField_b_of_type_Long = System.currentTimeMillis();
    QLog.i("IliveEntranceUtil", 1, " offest = " + (jdField_b_of_type_Long - jdField_a_of_type_Long));
    if (jdField_b_of_type_Long - jdField_a_of_type_Long > paramInt) {}
    for (;;)
    {
      jdField_a_of_type_Long = jdField_b_of_type_Long;
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (c())
    {
      a(paramContext, "qzone");
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        bkkd.a("IliveEntranceUtilisServiceExisted");
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
        if (paramContext == null) {
          break label98;
        }
        if (paramContext.size() != 0) {
          break label100;
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        paramContext.printStackTrace();
        continue;
      }
      if (i < paramContext.size())
      {
        localObject = (ActivityManager.RunningServiceInfo)paramContext.get(i);
        if (localObject != null)
        {
          localObject = ((ActivityManager.RunningServiceInfo)localObject).service;
          if ((localObject != null) && (((ComponentName)localObject).getClassName().equals(paramString))) {
            return true;
          }
        }
      }
      else
      {
        bkkd.b("IliveEntranceUtilisServiceExisted");
        return false;
        label98:
        return false;
        label100:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (mxn)localQQAppInterface.getManager(373);
      if ((localObject != null) && (((mxn)localObject).a()))
      {
        b(localQQAppInterface.getApp().getBaseContext(), "进入直播间失败");
        return false;
      }
      if (paramBoolean) {}
      for (localObject = "通话中，不可发起直播"; localQQAppInterface.getAVNotifyCenter().a(); localObject = "通话中，不可进入直播间")
      {
        b(localQQAppInterface.getApp().getBaseContext(), (String)localObject);
        QLog.e("IliveEntranceUtil", 2, "isBusinessEnableEnterLive isPhoneCalling");
        return false;
      }
      if (localQQAppInterface.getAVNotifyCenter().b())
      {
        b(localQQAppInterface.getApp().getBaseContext(), (String)localObject);
        QLog.e("IliveEntranceUtil", 2, "isBusinessEnableEnterLive isAvChating");
        return false;
      }
    }
    return true;
  }
  
  private static void b(Context paramContext, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new IliveEntranceUtil.1(paramContext, paramString));
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= aqhy.c().a();
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = a(paramContext, "com.tencent.proxyinner.plugin.loader.PluginToolProcessService");
    QLog.e("IliveEntranceUtil", 1, "isIlivePluginsServiceExisted : " + bool);
    return bool;
  }
  
  public static boolean c()
  {
    return bkjx.a(1) == 1;
  }
  
  public static boolean d()
  {
    return bkjx.a(2) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkke
 * JD-Core Version:    0.7.0.1
 */