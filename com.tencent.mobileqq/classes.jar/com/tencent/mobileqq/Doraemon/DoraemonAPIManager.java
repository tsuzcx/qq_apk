package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
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
import ris;
import rit;
import riu;

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
      if (BaseApplicationImpl.sProcessId != 1) {
        TroopMemberApiClient.a().a();
      }
      return;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "android";
    case 2: 
      return "ark";
    case 5: 
      return "limi";
    case 3: 
      return "mini_game";
    }
    return "mini_app";
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
  
  @UiThread
  private void b(String paramString, APIParam paramAPIParam, @NonNull APICallback paramAPICallback)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "call api=" + paramString + ", param=" + paramAPIParam + ", cb=" + paramAPICallback);
    }
    if (a().jdField_b_of_type_Int != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app not online");
      }
      DoraemonUtil.a(paramAPICallback, 9);
      return;
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
    paramString = paramAPIParam;
    if (paramAPIParam == null) {
      paramString = new APIParam();
    }
    a(localAPIConfig, paramString, paramAPICallback);
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
      if (BaseApplicationImpl.sProcessId == 1) {
        return;
      }
    }
    finally {}
    TroopMemberApiClient.a().b();
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
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b(paramString, paramAPIParam, paramAPICallback);
        return;
      }
    }
    ThreadManager.getUIHandler().post(new rit(this, paramString, paramAPIParam, paramAPICallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ThreadManager.getUIHandler().post(new riu(this, paramString1, paramString2, paramString4, paramString3, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener));
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo " + paramBoolean);
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i;
    if (paramBoolean) {
      i = 2;
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Int = i;
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_JavaUtilList.clear();
        if (localArrayList.size() > 0)
        {
          if (!paramBoolean) {
            break label195;
          }
          if (a().jdField_b_of_type_Int != 1) {
            break label123;
          }
          ThreadManager.getUIHandler().post(new ris(this, localArrayList));
        }
        return;
      }
      finally {}
      i = 0;
      continue;
      label123:
      localObject1 = localObject2.iterator();
      Object[] arrayOfObject;
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfObject = (Object[])((Iterator)localObject1).next();
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "app not online, api=" + arrayOfObject[0]);
        DoraemonUtil.a((APICallback)arrayOfObject[2], 9);
      }
      continue;
      label195:
      localObject1 = arrayOfObject.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfObject = (Object[])((Iterator)localObject1).next();
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "network error, api=" + arrayOfObject[0]);
        DoraemonUtil.a((APICallback)arrayOfObject[2], 7);
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    return a().a.contains(paramString);
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIManager
 * JD-Core Version:    0.7.0.1
 */