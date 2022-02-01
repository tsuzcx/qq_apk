package com.tencent.avgame.gameroom.video;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.IToolProcStart;
import com.tencent.mobileqq.qrscan.api.IQRToolProcStartApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class AVGameLaunchWebHelper
{
  private Activity a;
  private Handler b;
  private IToolProcStart c;
  private boolean d;
  private QQProgressDialog e;
  private final Runnable f = new AVGameLaunchWebHelper.1(this);
  private Application.ActivityLifecycleCallbacks g = new AVGameLaunchWebHelper.2(this);
  
  public AVGameLaunchWebHelper(Activity paramActivity)
  {
    this.a = paramActivity;
    this.b = new Handler();
    b();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "executeCallable");
    }
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private void b()
  {
    ((Application)this.a.getApplicationContext()).registerActivityLifecycleCallbacks(this.g);
  }
  
  private void c()
  {
    ((Application)this.a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.g);
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showProgress mProgressShowing:");
      localStringBuilder.append(this.d);
      QLog.d("AVGameLaunchWebHelper", 2, localStringBuilder.toString());
    }
    if (this.d) {
      return;
    }
    try
    {
      if (this.e == null)
      {
        this.e = new QQProgressDialog(this.a, this.a.getResources().getDimensionPixelSize(2131299920));
        this.e.a(HardCodeUtil.a(2131906700));
        this.e.c(false);
      }
      this.d = true;
      this.e.show();
      return;
    }
    catch (Exception localException)
    {
      label115:
      break label115;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "");
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("hideProgress  mProgressShowing:");
      localStringBuilder1.append(this.d);
      QLog.d("AVGameLaunchWebHelper", 2, localStringBuilder1.toString());
    }
    try
    {
      if (this.b != null) {
        this.b.removeCallbacks(this.f);
      }
      if ((this.e != null) && (this.e.isShowing())) {
        this.e.dismiss();
      }
      this.d = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("hide init check progress:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("AVGameLaunchWebHelper", 2, localStringBuilder2.toString());
      }
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "release");
    }
    e();
    Object localObject = this.b;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((IToolProcStart)localObject).a();
      this.c = null;
    }
  }
  
  public void a(Activity paramActivity, Runnable paramRunnable)
  {
    QLog.d("AVGameLaunchWebHelper", 2, "preLoadToolProcAndExecuteCallable");
    if (UITools.e(this.a))
    {
      a(paramRunnable);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.c == null) {
      this.c = ((IQRToolProcStartApi)QRoute.api(IQRToolProcStartApi.class)).get();
    }
    paramActivity = this.b;
    if (paramActivity != null)
    {
      paramActivity.removeCallbacks(this.f);
      this.b.postDelayed(this.f, 1000L);
    }
    this.c.a("preLoadToolProc", 5000L, new AVGameLaunchWebHelper.3(this, paramRunnable, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameLaunchWebHelper
 * JD-Core Version:    0.7.0.1
 */