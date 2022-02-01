package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class AIOPreLoadEngine
  implements Handler.Callback
{
  public static boolean a = true;
  public static int b = 0;
  public static long c = -1L;
  private static boolean d = false;
  private static AIOPreLoadEngine f = new AIOPreLoadEngine();
  private Handler e = new WeakReferenceHandler(Looper.getMainLooper(), this);
  
  static
  {
    b();
  }
  
  public static AIOPreLoadEngine a()
  {
    try
    {
      AIOPreLoadEngine localAIOPreLoadEngine = f;
      return localAIOPreLoadEngine;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @TargetApi(17)
  private void a(Activity paramActivity)
  {
    if ((paramActivity != null) && ((paramActivity instanceof SplashActivity)))
    {
      if ((b != 1) && (!ChatFragment.a))
      {
        SplashActivity localSplashActivity = (SplashActivity)paramActivity;
        if ((localSplashActivity.app != null) && (localSplashActivity.app.isRunning()) && (localSplashActivity.app.isLogin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.AIOPreLoadEngine", 2, "doRealPreLoadAIO");
          }
          FragmentManager localFragmentManager = localSplashActivity.getSupportFragmentManager();
          Fragment localFragment = localFragmentManager.findFragmentByTag(ChatFragment.class.getName());
          boolean bool;
          if (((Build.VERSION.SDK_INT > 16) && (paramActivity.isDestroyed())) || (paramActivity.isFinishing())) {
            bool = false;
          } else {
            bool = true;
          }
          if ((localFragment == null) && (bool))
          {
            c = SystemClock.uptimeMillis();
            StartupTracker.a(null, "AIO_preLoad_Cost");
            try
            {
              paramActivity = localFragmentManager.beginTransaction();
              paramActivity.add(16908290, ChatFragment.a(), ChatFragment.class.getName());
              localSplashActivity.setIntent(new Intent());
              paramActivity.commitAllowingStateLoss();
              b = 1;
              com.tencent.qqperf.tools.PerformanceReportUtils.b = 1;
              return;
            }
            catch (Exception paramActivity)
            {
              QLog.e("Q.aio.AIOPreLoadEngine", 1, "AIO preLoad:", paramActivity);
              return;
            }
          }
          if (QLog.isColorLevel())
          {
            paramActivity = new StringBuilder();
            paramActivity.append("AIO cannot peload:");
            paramActivity.append(bool);
            QLog.i("Q.aio.AIOPreLoadEngine", 2, paramActivity.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.aio.AIOPreLoadEngine", 2, "app is not valid");
        }
      }
      else if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("sPreloadedAIOType:");
        paramActivity.append(b);
        paramActivity.append("|AIO_HAD_OPEN:");
        paramActivity.append(ChatFragment.a);
        QLog.e("Q.aio.AIOPreLoadEngine", 2, paramActivity.toString());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("Q.aio.AIOPreLoadEngine", 2, "activity is not splashActivity");
    }
  }
  
  public static void b()
  {
    Object localObject1;
    label103:
    try
    {
      bool = d;
      if (bool) {
        return;
      }
    }
    finally {}
    try
    {
      localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initAIOPreloadFlagByDpc thumbConfig:");
        localStringBuilder.append((String)localObject1);
        QLog.i("Q.aio.AIOPreLoadEngine", 2, localStringBuilder.toString());
      }
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length <= 2) {
        break label153;
      }
      if (!"1".equals(localObject1[2])) {
        break label210;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      break label110;
      bool = false;
      break label103;
    }
    a = bool;
    break label153;
    label110:
    a = false;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initAIOPreloadFlagByDpc error|");
      ((StringBuilder)localObject1).append(a);
      QLog.d("Q.aio.AIOPreLoadEngine", 2, ((StringBuilder)localObject1).toString());
    }
    label153:
    d = true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initAIOPreloadFlagByDpc|");
      ((StringBuilder)localObject1).append(a);
      QLog.i("Q.aio.AIOPreLoadEngine", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (!a)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.AIOPreLoadEngine", 2, "startPreLoadAIO return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.AIOPreLoadEngine", 2, "startPreLoadAIO");
    }
    if (paramBaseActivity != null)
    {
      Message localMessage = this.e.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramBaseActivity;
      this.e.sendMessage(localMessage);
    }
  }
  
  public void c()
  {
    if (this.e.hasMessages(1)) {
      this.e.removeMessages(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (paramMessage.obj != null)) {
      a((Activity)paramMessage.obj);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOPreLoadEngine
 * JD-Core Version:    0.7.0.1
 */