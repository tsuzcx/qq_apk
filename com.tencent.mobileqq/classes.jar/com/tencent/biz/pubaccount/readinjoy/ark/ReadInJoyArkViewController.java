package com.tencent.biz.pubaccount.readinjoy.ark;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import lgk;
import lgl;
import lgm;
import lgn;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyArkViewController
{
  private static ReadInJoyArkViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyArkReadInJoyArkViewController;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  boolean jdField_b_of_type_Boolean = false;
  
  private ReadInJoyArkViewController()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      a(new lgk(this), 5);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static ReadInJoyArkViewController a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyArkReadInJoyArkViewController == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyArkReadInJoyArkViewController = new ReadInJoyArkViewController();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyArkReadInJoyArkViewController;
    }
    finally {}
  }
  
  public ReadInJoyArkViewController.ArkConfig a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramString2);
        String str2 = ((JSONObject)localObject1).optString("app", "");
        String str3 = ((JSONObject)localObject1).optString("view", "");
        String str4 = ((JSONObject)localObject1).optString("ver", "");
        localObject1 = ((JSONObject)localObject1).optString("meta", "");
        String str1 = a(paramString1, (String)localObject1);
        if (TextUtils.isEmpty(str1)) {
          paramString2 = new ReadInJoyArkViewController.ArkConfig(paramString2, str2, str4, str3, (String)localObject1);
        }
        Object localObject2 = str1;
      }
      catch (Exception paramString2)
      {
        try
        {
          if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
          }
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
          return paramString2;
        }
        catch (Exception localException)
        {
          paramString1 = paramString2;
          paramString2 = localException;
          continue;
        }
        paramString2 = paramString2;
        paramString1 = null;
        QLog.d("ReadInJoyArkViewController", 1, "makeUpArkMsg failed ", paramString2);
        return paramString1;
      }
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.equals(paramString, "0")) {
      return ReadInJoyHelper.b(ReadInJoyUtils.a());
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, "0")) {}
    try
    {
      new JSONObject(paramString2).getJSONObject("readinjoy");
      return paramString2;
    }
    catch (Exception paramString1)
    {
      QLog.d("ReadInJoyArkViewController", 1, "make config failed ", paramString1);
    }
    return paramString2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyArkView localReadInJoyArkView = (ReadInJoyArkView)((WeakReference)localIterator.next()).get();
        if (localReadInJoyArkView != null) {
          localReadInJoyArkView.a();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("currentcount", paramInt1);
      ((JSONObject)localObject).put("totalcount", paramInt2);
      label27:
      QLog.d("ReadInJoyArkViewController", 1, "notify ark app notify:" + paramString + ", current:" + paramInt1 + ", total:" + paramInt2);
      localObject = ((JSONObject)localObject).toString();
      ArkAppCenter.a().post(new lgn(this, paramString, (String)localObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      break label27;
    }
  }
  
  public void a(ReadInJoyListViewGroup paramReadInJoyListViewGroup, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      paramString = (ReadInJoyArkView)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).get();
      if (paramString != null) {
        paramString.a(paramReadInJoyListViewGroup);
      }
    }
  }
  
  public void a(Runnable paramRunnable, int paramInt)
  {
    ThreadManager.post(paramRunnable, paramInt, null, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ThreadManager.executeOnSubThread(new lgm(this, paramString3, paramString1, paramString2, paramInt));
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      paramString = (ReadInJoyArkView)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).get();
      if (paramString != null) {
        return paramString.a();
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = a(paramString1);
    }
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, "{}"))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = a(paramString1, str);
        if (paramString1 != null)
        {
          if (ReadInJoyUtils.a(paramString1.b, paramString1.c)) {
            return true;
          }
          paramString2 = paramString1.b;
          str = paramString1.c;
          ReadInJoyUtils.a(paramString1.b, paramString1.c, null, new lgl(this, paramString2, str));
          return false;
        }
      }
      catch (Exception paramString1)
      {
        QLog.d("ReadInJoyArkViewController", 1, "constructArkMsg failed ", paramString1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController
 * JD-Core Version:    0.7.0.1
 */