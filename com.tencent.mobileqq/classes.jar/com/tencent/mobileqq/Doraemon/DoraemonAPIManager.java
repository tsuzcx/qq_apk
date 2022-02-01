package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController;
import com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class DoraemonAPIManager
{
  public int a;
  public String b;
  public String c;
  protected Map<String, APIConfig> d;
  protected Map<Class<? extends DoraemonAPIModule>, DoraemonAPIModule> e = new HashMap();
  protected int f = 0;
  protected final Object g = new Object();
  protected List<Object[]> h = new ArrayList();
  protected boolean i = false;
  protected Dialog j = null;
  protected IDoraemonApi k;
  private WeakReference<Activity> l;
  private int m = -1;
  private SdkAuthDialog n;
  
  public DoraemonAPIManager(Activity paramActivity, int paramInt, String paramString)
  {
    this.l = new WeakReference(paramActivity);
    this.a = paramInt;
    this.b = paramString;
    paramActivity = new StringBuilder();
    paramActivity.append(paramInt);
    paramActivity.append("_");
    paramActivity.append(paramString);
    this.c = paramActivity.toString();
    this.k = ((IDoraemonApi)QRoute.api(IDoraemonApi.class));
  }
  
  @UiThread
  private void b(APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      return;
    }
    DoraemonAPIModule localDoraemonAPIModule = a(paramAPIConfig.d, true);
    if (localDoraemonAPIModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "module load failed");
      }
      DoraemonUtil.a(paramAPICallback, 2);
      return;
    }
    DoraemonFrequenceController.a().b(this.c, this.a, this.b, paramAPIConfig.a);
    if (!localDoraemonAPIModule.a(paramAPIConfig.b, paramAPIConfig.a, paramJSONObject, paramAPICallback))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "module not handled this api");
      }
      DoraemonUtil.a(paramAPICallback, 1);
    }
  }
  
  @UiThread
  private void b(String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      return;
    }
    if (this.f != 2) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call api=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", param=");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(", cb=");
      ((StringBuilder)localObject).append(paramAPICallback);
      QLog.i("DoraemonOpenAPI.apiMgr", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app has no permission");
      }
      DoraemonUtil.a(paramAPICallback, 3);
      return;
    }
    Object localObject = (APIConfig)this.d.get(paramString);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "no such api");
      }
      DoraemonUtil.a(paramAPICallback, 1);
      return;
    }
    if (!DoraemonFrequenceController.a().a(this.c, this.a, this.b, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "frequence restricted");
      }
      DoraemonUtil.a(paramAPICallback, 8);
      return;
    }
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    a((APIConfig)localObject, paramString, paramAPICallback);
  }
  
  private void i()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext()) {
      ((DoraemonAPIModule)localIterator.next()).b();
    }
  }
  
  public <T extends DoraemonAPIModule> T a(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject = (DoraemonAPIModule)this.e.get(paramClass);
    if ((localObject == null) && (paramBoolean) && (!this.i)) {}
    label146:
    for (;;)
    {
      try
      {
        if (!this.i)
        {
          DoraemonAPIModule localDoraemonAPIModule = (DoraemonAPIModule)this.e.get(paramClass);
          localObject = localDoraemonAPIModule;
          if (localDoraemonAPIModule != null) {
            break label146;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("create module ");
            ((StringBuilder)localObject).append(paramClass.getSimpleName());
            QLog.i("DoraemonOpenAPI.apiMgr", 2, ((StringBuilder)localObject).toString());
          }
          localDoraemonAPIModule = DoraemonAPIModuleFactory.a(paramClass, this);
          localObject = localDoraemonAPIModule;
          if (localDoraemonAPIModule == null) {
            break label146;
          }
          this.e.put(paramClass, localDoraemonAPIModule);
          localObject = localDoraemonAPIModule;
          break label146;
        }
        return localObject;
      }
      finally {}
      return localObject;
    }
  }
  
  public void a()
  {
    this.d = d();
    synchronized (this.g)
    {
      this.f = 1;
      e();
      DoraemonFrequenceController.a().a(this.c, this.a, this.b);
      if (MobileQQ.sProcessId != 1) {
        this.k.bindService();
      }
      return;
    }
  }
  
  protected void a(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onLoadAppInfo ");
    ((StringBuilder)???).append(paramInt);
    QLog.i("DoraemonOpenAPI.apiMgr", 1, ((StringBuilder)???).toString());
    synchronized (this.g)
    {
      this.f = paramInt;
      Object localObject2 = new ArrayList(this.h);
      this.h.clear();
      if (((List)localObject2).size() > 0)
      {
        if (paramInt == 2)
        {
          ThreadManager.getUIHandler().post(new DoraemonAPIManager.2(this, (List)localObject2));
          return;
        }
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Object[])((Iterator)???).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("load app info error, api=");
          localStringBuilder.append(localObject2[0]);
          QLog.i("DoraemonOpenAPI.apiMgr", 1, localStringBuilder.toString());
          DoraemonUtil.a((APICallback)localObject2[2], DoraemonUtil.b(paramInt));
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  protected void a(int paramInt, APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandleAPIAuthorize ");
      localStringBuilder.append(paramInt);
      QLog.i("DoraemonOpenAPI.apiMgr", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b(paramAPIConfig, paramJSONObject, paramAPICallback);
        return;
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.4(this, paramAPIConfig, paramJSONObject, paramAPICallback));
      return;
    }
    paramAPIConfig = new StringBuilder();
    paramAPIConfig.append("auth not pass ");
    paramAPIConfig.append(paramInt);
    QLog.i("DoraemonOpenAPI.apiMgr", 1, paramAPIConfig.toString());
    DoraemonUtil.a(paramAPICallback, paramInt);
  }
  
  protected abstract void a(APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback);
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, String paramString6, View.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramString3 = (Activity)this.l.get();
    if ((paramString3 != null) && (!paramString3.isFinishing()))
    {
      this.n = new SdkAuthDialog(paramString3);
      this.n.c(HardCodeUtil.a(2131901538));
      this.n.b(paramString1);
      this.n.d(paramString4);
      this.n.f(paramString6);
      this.n.e(paramString5);
      this.n.a(paramOnClickListener1);
      this.n.b(paramOnClickListener2);
      this.n.a(paramOnCancelListener);
      this.n.a(paramString2);
      this.n.show();
      ReportController.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "", "", "", "");
      return;
    }
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "showDialog activity is not valid");
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (this.f != 2) {
      synchronized (this.g)
      {
        if (this.f != 2)
        {
          if ((this.f != 3) && (this.f != 4))
          {
            this.h.add(new Object[] { paramString, paramJSONObject, paramAPICallback });
            if (QLog.isColorLevel())
            {
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("permission not ready, add to queue api=");
              paramJSONObject.append(paramString);
              QLog.i("DoraemonOpenAPI.apiMgr", 2, paramJSONObject.toString());
            }
            if (this.f != 1)
            {
              this.f = 1;
              QLog.i("DoraemonOpenAPI.apiMgr", 1, "retry loadAppInfo");
              e();
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 2, "appinfo error and can not retry");
          }
          DoraemonUtil.a(paramAPICallback, DoraemonUtil.b(this.f));
          return;
        }
      }
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramString, paramJSONObject, paramAPICallback);
      return;
    }
    ThreadManager.getUIHandler().post(new DoraemonAPIManager.3(this, paramString, paramJSONObject, paramAPICallback));
  }
  
  protected boolean a(String paramString)
  {
    boolean bool = f().o.contains(paramString);
    if ((!bool) && (c()))
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131901530));
      localStringBuilder.append(paramString);
      localStringBuilder.append(HardCodeUtil.a(2131901528));
      Toast.makeText(localBaseApplication, localStringBuilder.toString(), 0).show();
      return true;
    }
    return bool;
  }
  
  public void b()
  {
    try
    {
      this.i = true;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        i();
      } else {
        ThreadManager.getUIHandler().post(new DoraemonAPIManager.1(this));
      }
      if (MobileQQ.sProcessId != 1) {
        this.k.unbindService();
      }
      return;
    }
    finally {}
  }
  
  protected boolean c()
  {
    int i1 = this.m;
    boolean bool = false;
    if (i1 == -1) {
      this.m = 0;
    }
    if (this.m == 1) {
      bool = true;
    }
    return bool;
  }
  
  protected abstract Map<String, APIConfig> d();
  
  protected abstract void e();
  
  public abstract MiniAppInfo f();
  
  public void g()
  {
    this.n.a();
  }
  
  public Activity h()
  {
    return (Activity)this.l.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */