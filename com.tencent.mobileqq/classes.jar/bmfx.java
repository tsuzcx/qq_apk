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

public class bmfx
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
    biaq.a("anchor_enter_count", null, 0L);
  }
  
  public static void a(bmfm parambmfm)
  {
    if (parambmfm == null) {
      return;
    }
    if (!TextUtils.isEmpty(parambmfm.c)) {}
    try
    {
      parambmfm.c = Uri.decode(parambmfm.c);
      if (TextUtils.isEmpty(parambmfm.e)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        parambmfm.e = Uri.decode(parambmfm.e);
        QLog.e("IliveEntranceUtil", 1, "liveWatchEntranceJump source = " + parambmfm.jdField_a_of_type_JavaLangString + " roomID = " + parambmfm.b + " retain = " + parambmfm.jdField_a_of_type_Boolean + " sIsAnchorIsLive = " + jdField_a_of_type_Boolean + " sIsAudienceIsLive = " + jdField_b_of_type_Boolean);
        if (QLog.isColorLevel()) {
          QLog.i("IliveEntranceUtil", 2, " rtmp = " + parambmfm.c + " closeJump = " + parambmfm.e);
        }
        if (TextUtils.isEmpty(parambmfm.b)) {
          parambmfm.b = "-1";
        }
        if ((jdField_a_of_type_Boolean) && (b(parambmfm.jdField_a_of_type_AndroidContentContext)))
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
        biaq.a("watch_enter_count", null, 0L);
        Intent localIntent = new Intent();
        Bundle localBundle = new Bundle();
        localBundle.putInt("page_type", 3);
        localBundle.putString("source", parambmfm.jdField_a_of_type_JavaLangString);
        localBundle.putString("room_id", parambmfm.b);
        localBundle.putString("rtmp_Url", parambmfm.c);
        localBundle.putString("cover_url", parambmfm.d);
        localBundle.putLong("start_time", System.currentTimeMillis());
        localBundle.putStringArrayList("playlist", parambmfm.jdField_a_of_type_JavaUtilArrayList);
        localBundle.putInt("from", parambmfm.jdField_a_of_type_Int);
        localBundle.putBoolean("retaion", parambmfm.jdField_a_of_type_Boolean);
        localBundle.putString("close_jump", parambmfm.e);
        localBundle.putBoolean("isDebugVersion", false);
        localBundle.putString("qqVersion", AppSetting.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("KEY_EXTRAS", localBundle);
        localIntent.putExtra("KEY_IS_START_LIVE", false);
        IliveLaunchFragment.startSelf(parambmfm.jdField_a_of_type_AndroidContentContext, localIntent);
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
    try
    {
      bmfw.a("IliveEntranceUtilisServiceExisted");
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
      if ((paramContext == null) || (paramContext.size() > 0)) {
        break label97;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Object localObject;
        paramContext.printStackTrace();
        continue;
        label97:
        int i = 0;
        continue;
        i += 1;
      }
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
      bmfw.b("IliveEntranceUtilisServiceExisted");
      return false;
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (mxc)localQQAppInterface.getManager(373);
      if ((localObject != null) && (((mxc)localObject).a()))
      {
        b(localQQAppInterface.getApp().getBaseContext(), "进入直播间失败");
        return false;
      }
      if (paramBoolean) {}
      for (localObject = "通话中，不可发起直播"; localQQAppInterface.a().a(); localObject = "通话中，不可进入直播间")
      {
        b(localQQAppInterface.getApp().getBaseContext(), (String)localObject);
        QLog.e("IliveEntranceUtil", 2, "isBusinessEnableEnterLive isPhoneCalling");
        return false;
      }
      if (localQQAppInterface.a().b())
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
    return Build.VERSION.SDK_INT >= aroa.c().a();
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = a(paramContext, "com.tencent.proxyinner.plugin.loader.PluginToolProcessService");
    QLog.e("IliveEntranceUtil", 1, "isIlivePluginsServiceExisted : " + bool);
    return bool;
  }
  
  public static boolean c()
  {
    return bmfq.a(1) == 1;
  }
  
  public static boolean d()
  {
    return bmfq.a(2) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfx
 * JD-Core Version:    0.7.0.1
 */