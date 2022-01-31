package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import rbk;
import rbl;

public abstract class DoraemonAPIManager
{
  public int a;
  public final Activity a;
  protected final Object a;
  public String a;
  protected List a;
  protected Map a;
  protected boolean a;
  protected int b;
  public String b;
  protected Map b;
  
  public DoraemonAPIManager(Activity arg1, int paramInt, String paramString)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = ???;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = (paramInt + "_" + paramString);
    this.jdField_a_of_type_JavaUtilMap = a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = 1;
      b();
      DoraemonFrequenceController.a().a(this.jdField_b_of_type_JavaLangString, paramInt, paramString);
      return;
    }
  }
  
  private void b(APIConfig paramAPIConfig, APIParam paramAPIParam, APICallback paramAPICallback)
  {
    DoraemonAPIModule localDoraemonAPIModule = a(paramAPIConfig.jdField_a_of_type_JavaLangClass, true);
    if (localDoraemonAPIModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "module load failed");
      }
      DoraemonUtil.a(paramAPICallback, 2);
    }
    do
    {
      return;
      DoraemonFrequenceController.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramAPIConfig.jdField_a_of_type_JavaLangString);
    } while (localDoraemonAPIModule.a(paramAPIConfig.jdField_a_of_type_Int, paramAPIConfig.jdField_a_of_type_JavaLangString, paramAPIParam, paramAPICallback));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "module not handled this api");
    }
    DoraemonUtil.a(paramAPICallback, 1);
  }
  
  public abstract AppInfo a();
  
  public DoraemonAPIModule a(Class paramClass, boolean paramBoolean)
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
  
  public abstract Map a();
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((DoraemonAPIModule)localIterator.next()).a();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, APIConfig paramAPIConfig, APIParam paramAPIParam, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "onHandleAPIAuthorize " + paramInt);
    }
    if (paramInt == 0)
    {
      b(paramAPIConfig, paramAPIParam, paramAPICallback);
      return;
    }
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "auth not pass " + paramInt);
    DoraemonUtil.a(paramAPICallback, paramInt);
  }
  
  public abstract void a(APIConfig paramAPIConfig, APIParam paramAPIParam, APICallback paramAPICallback);
  
  public final void a(String paramString, APIParam paramAPIParam, @NonNull APICallback paramAPICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "call api=" + paramString + ", param=" + paramAPIParam + ", cb=" + paramAPICallback);
    }
    if (this.jdField_b_of_type_Int != 2) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_Int != 2)
      {
        this.jdField_a_of_type_JavaUtilList.add(new Object[] { paramString, paramAPIParam, paramAPICallback });
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.apiMgr", 2, "permission not ready, add to queue api=" + paramString);
        }
        if (this.jdField_b_of_type_Int == 0)
        {
          this.jdField_b_of_type_Int = 1;
          QLog.i("DoraemonOpenAPI.apiMgr", 1, "retry loadAppInfo");
          b();
        }
        return;
      }
      if (a().jdField_b_of_type_Int != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.apiMgr", 2, "app not online");
        }
        DoraemonUtil.a(paramAPICallback, 9);
        return;
      }
    }
    if (!a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app has no permission");
      }
      DoraemonUtil.a(paramAPICallback, 3);
      return;
    }
    ??? = (APIConfig)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (??? == null)
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
    paramString = paramAPIParam;
    if (paramAPIParam == null) {
      paramString = new APIParam();
    }
    a((APIConfig)???, paramString, paramAPICallback);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ThreadManager.getUIHandler().post(new rbl(this, paramString1, paramString2, paramString4, paramString3, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener));
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo " + paramBoolean);
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {}
    for (int i = 2;; i = 0) {
      try
      {
        this.jdField_b_of_type_Int = i;
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_JavaUtilList.clear();
        if (localArrayList.size() > 0) {
          ThreadManager.getUIHandler().post(new rbk(this, paramBoolean, localArrayList));
        }
        return;
      }
      finally {}
    }
  }
  
  protected boolean a(String paramString)
  {
    return a().a.contains(paramString);
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */