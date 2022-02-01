package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController;
import com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class DoraemonAPIManager
{
  public int a;
  protected Dialog a;
  private SdkAuthDialog jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog;
  protected final Object a;
  public String a;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  protected List<Object[]> a;
  protected Map<String, APIConfig> a;
  protected boolean a;
  protected int b;
  public String b;
  protected Map<Class<? extends DoraemonAPIModule>, DoraemonAPIModule> b;
  private int c = -1;
  
  public DoraemonAPIManager(Activity paramActivity, int paramInt, String paramString)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = (paramInt + "_" + paramString);
  }
  
  @UiThread
  private void b(APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    DoraemonAPIModule localDoraemonAPIModule;
    do
    {
      return;
      localDoraemonAPIModule = a(paramAPIConfig.jdField_a_of_type_JavaLangClass, true);
      if (localDoraemonAPIModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.apiMgr", 2, "module load failed");
        }
        DoraemonUtil.a(paramAPICallback, 2);
        return;
      }
      DoraemonFrequenceController.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramAPIConfig.jdField_a_of_type_JavaLangString);
    } while (localDoraemonAPIModule.a(paramAPIConfig.jdField_a_of_type_Int, paramAPIConfig.jdField_a_of_type_JavaLangString, paramJSONObject, paramAPICallback));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "module not handled this api");
    }
    DoraemonUtil.a(paramAPICallback, 1);
  }
  
  @UiThread
  private void b(String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "call api=" + paramString + ", param=" + paramJSONObject + ", cb=" + paramAPICallback);
    }
    if (!a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app has no permission");
      }
      DoraemonUtil.a(paramAPICallback, 3);
      return;
    }
    APIConfig localAPIConfig = (APIConfig)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAPIConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "no such api");
      }
      DoraemonUtil.a(paramAPICallback, 1);
      return;
    }
    if (!DoraemonFrequenceController.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramString))
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
    a(localAPIConfig, paramString, paramAPICallback);
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((DoraemonAPIModule)localIterator.next()).b();
    }
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public <T extends DoraemonAPIModule> T a(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject = (DoraemonAPIModule)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
    if ((localObject == null) && (paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          DoraemonAPIModule localDoraemonAPIModule = (DoraemonAPIModule)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
          localObject = localDoraemonAPIModule;
          if (localDoraemonAPIModule == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "create module " + paramClass.getSimpleName());
            }
            localDoraemonAPIModule = DoraemonAPIModuleFactory.a(paramClass, this);
            localObject = localDoraemonAPIModule;
            if (localDoraemonAPIModule != null)
            {
              this.jdField_b_of_type_JavaUtilMap.put(paramClass, localDoraemonAPIModule);
              localObject = localDoraemonAPIModule;
            }
          }
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  public abstract MiniAppInfo a();
  
  protected abstract Map<String, APIConfig> a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = 1;
      c();
      DoraemonFrequenceController.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      if (BaseApplicationImpl.sProcessId != 1) {
        TroopMemberApiClient.a().a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo " + paramInt);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Int = paramInt;
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_JavaUtilList.clear();
        if (localArrayList.size() > 0)
        {
          if (paramInt == 2) {
            ThreadManager.getUIHandler().post(new DoraemonAPIManager.2(this, localArrayList));
          }
        }
        else {
          return;
        }
      }
      ??? = localObject2.iterator();
      while (((Iterator)???).hasNext())
      {
        Object[] arrayOfObject = (Object[])((Iterator)???).next();
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "load app info error, api=" + arrayOfObject[0]);
        DoraemonUtil.a((APICallback)arrayOfObject[2], DoraemonUtil.a(paramInt));
      }
    }
  }
  
  public void a(int paramInt, APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "onHandleAPIAuthorize " + paramInt);
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
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "auth not pass " + paramInt);
    DoraemonUtil.a(paramAPICallback, paramInt);
  }
  
  protected abstract void a(APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback);
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, String paramString6, View.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramString3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString3 == null) || (paramString3.isFinishing()))
    {
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "showDialog activity is not valid");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog = new SdkAuthDialog(paramString3);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.c(HardCodeUtil.a(2131703456));
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.b(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.d(paramString4);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.f(paramString6);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.e(paramString5);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.a(paramOnClickListener1);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.b(paramOnClickListener2);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.a(paramOnCancelListener);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.a(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.show();
    ReportController.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "", "", "", "");
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (this.jdField_b_of_type_Int != 2) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_Int != 2)
        {
          if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "appinfo error and can not retry");
            }
            DoraemonUtil.a(paramAPICallback, DoraemonUtil.a(this.jdField_b_of_type_Int));
            return;
          }
          this.jdField_a_of_type_JavaUtilList.add(new Object[] { paramString, paramJSONObject, paramAPICallback });
          if (QLog.isColorLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 2, "permission not ready, add to queue api=" + paramString);
          }
          if (this.jdField_b_of_type_Int != 1)
          {
            this.jdField_b_of_type_Int = 1;
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "retry loadAppInfo");
            c();
          }
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
  
  protected boolean a()
  {
    if (this.c == -1) {
      this.c = 0;
    }
    return this.c == 1;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = a().a.contains(paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (a())
      {
        Toast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131703448) + paramString + HardCodeUtil.a(2131703446), 0).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          e();
          if (BaseApplicationImpl.sProcessId != 1) {
            TroopMemberApiClient.a().b();
          }
          return;
        }
      }
      finally {}
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.1(this));
    }
  }
  
  protected abstract void c();
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */