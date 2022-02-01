package com.tencent.mobileqq.activity.specialcare;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class QvipSpecialCareUtil
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static HashMap<String, String> a;
  private static boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString, AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("special_sound_type");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 1);
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("special_sound");
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      paramAppRuntime = SharedPreferencesHandler.a(localSharedPreferences, localStringBuilder.toString(), null);
      if (paramAppRuntime != null) {
        return paramAppRuntime.size();
      }
      return 0;
    }
  }
  
  public static Set<String> a(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("special_sound");
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      paramAppRuntime = SharedPreferencesHandler.a(localSharedPreferences, localStringBuilder.toString(), null);
      return paramAppRuntime;
    }
  }
  
  public static void a(int paramInt, AppRuntime paramAppRuntime)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("special_sound_quota");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString, int paramInt, AppRuntime paramAppRuntime)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("special_sound_type");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    if ((paramString2 != null) && (paramString2.length() != 0))
    {
      try
      {
        int i = Integer.parseInt(paramString2);
        if (!a(paramString1, paramAppRuntime)) {
          a(paramString1, paramAppRuntime);
        }
        a(paramString1, i, paramAppRuntime);
        return;
      }
      catch (Exception paramString1)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramString2 = new StringBuilder();
      paramString2.append("dealWithRespSound|exception = ");
      paramString2.append(paramString1.toString());
      QLog.i("SpecialCareManager", 2, paramString2.toString());
    }
    else
    {
      if (a(paramString1, paramAppRuntime)) {
        b(paramString1, paramAppRuntime);
      }
      if (b(paramString1, paramAppRuntime)) {
        c(paramString1, paramAppRuntime);
      }
    }
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject1 = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramAppRuntime.getCurrentAccountUin());
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
      jdField_a_of_type_JavaUtilHashMap.put(localObject2, paramString);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("special_sound");
      ((StringBuilder)localObject2).append(paramAppRuntime.getCurrentAccountUin());
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject1, ((StringBuilder)localObject2).toString(), null);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashSet();
      }
      if (((Set)localObject1).contains(paramString)) {
        return;
      }
      ((Set)localObject1).add(paramString);
      paramString = ((Set)localObject1).toArray();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("special_sound");
      ((StringBuilder)localObject1).append(paramAppRuntime.getCurrentAccountUin());
      SharedPreferencesHandler.a(localEditor, ((StringBuilder)localObject1).toString(), paramString).commit();
      return;
    }
  }
  
  public static void a(List<String> paramList1, int paramInt, List<String> paramList2, AppRuntime paramAppRuntime)
  {
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).sendSpecialCareEvent(paramList1, paramInt, paramList2, paramAppRuntime);
  }
  
  public static void a(List<String> paramList, AppRuntime paramAppRuntime)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject1 = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("special_sound");
        ((StringBuilder)localObject2).append(paramAppRuntime.getCurrentAccountUin());
        localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject1, ((StringBuilder)localObject2).toString(), null);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new HashSet();
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (String)paramList.next();
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramAppRuntime.getCurrentAccountUin());
          ((StringBuilder)localObject4).append((String)localObject2);
          localObject4 = ((StringBuilder)localObject4).toString();
          if (!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject4)) {
            jdField_a_of_type_JavaUtilHashMap.put(localObject4, localObject2);
          }
          if (!((Set)localObject1).contains(localObject2)) {
            ((Set)localObject1).add(localObject2);
          }
        }
        paramList = ((Set)localObject1).toArray();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("special_sound");
        ((StringBuilder)localObject1).append(paramAppRuntime.getCurrentAccountUin());
        SharedPreferencesHandler.a(localEditor, ((StringBuilder)localObject1).toString(), paramList).commit();
        return;
      }
    }
  }
  
  public static void a(Map<String, Integer> paramMap, AppRuntime paramAppRuntime)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return;
      }
      SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramMap.next();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSpecialCareSounds from FriendList: ");
          ((StringBuilder)localObject2).append(localObject1.toString());
          QLog.d("SpecialCareManager", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = (String)((Map.Entry)localObject1).getKey();
        int i = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("special_sound_type");
        ((StringBuilder)localObject1).append(paramAppRuntime.getCurrentAccountUin());
        ((StringBuilder)localObject1).append((String)localObject2);
        localEditor.putInt(((StringBuilder)localObject1).toString(), i);
      }
      localEditor.commit();
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    Object localObject1 = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("special_sound");
    ((StringBuilder)localObject2).append(paramAppRuntime.getCurrentAccountUin());
    localObject1 = SharedPreferencesHandler.a((SharedPreferences)localObject1, ((StringBuilder)localObject2).toString(), null);
    if (localObject1 != null)
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
        localStringBuilder.append((String)localObject2);
        localHashMap.put(localStringBuilder.toString(), localObject2);
      }
    }
    a(false);
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public static boolean a(String paramString, AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("special_sound");
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      paramAppRuntime = SharedPreferencesHandler.a(localSharedPreferences, localStringBuilder.toString(), null);
      return (paramAppRuntime != null) && (!paramAppRuntime.isEmpty()) && (paramAppRuntime.contains(paramString));
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    return a();
  }
  
  public static void b(int paramInt, AppRuntime paramAppRuntime)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("special_sound_svip_quota");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject2 = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramAppRuntime.getCurrentAccountUin());
    ((StringBuilder)???).append(paramString);
    ??? = ((StringBuilder)???).toString();
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(???)) {
      jdField_a_of_type_JavaUtilHashMap.remove(???);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("special_sound");
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, localStringBuilder.toString(), null);
      if (localObject2 != null)
      {
        if (!((Set)localObject2).contains(paramString)) {
          return;
        }
        ((Set)localObject2).remove(paramString);
        paramString = ((Set)localObject2).toArray();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("special_sound");
        ((StringBuilder)localObject2).append(paramAppRuntime.getCurrentAccountUin());
        SharedPreferencesHandler.a(localEditor, ((StringBuilder)localObject2).toString(), paramString).commit();
      }
      return;
    }
  }
  
  public static void b(List<String> paramList, AppRuntime paramAppRuntime)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject2 = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("special_sound");
        ((StringBuilder)localObject3).append(paramAppRuntime.getCurrentAccountUin());
        localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, ((StringBuilder)localObject3).toString(), null);
        if (localObject2 != null)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject3 = (String)paramList.next();
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramAppRuntime.getCurrentAccountUin());
            ((StringBuilder)localObject4).append((String)localObject3);
            localObject4 = ((StringBuilder)localObject4).toString();
            if (jdField_a_of_type_JavaUtilHashMap.containsKey(localObject4)) {
              jdField_a_of_type_JavaUtilHashMap.remove(localObject4);
            }
            if (((Set)localObject2).contains(localObject3)) {
              ((Set)localObject2).remove(localObject3);
            }
          }
          paramList = ((Set)localObject2).toArray();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("special_sound");
          ((StringBuilder)localObject2).append(paramAppRuntime.getCurrentAccountUin());
          SharedPreferencesHandler.a(localEditor, ((StringBuilder)localObject2).toString(), paramList).commit();
        }
        return;
      }
    }
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_get_special_sound_quota_time");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static boolean b(String paramString, AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("special_sound_type");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localStringBuilder.append(paramString);
    return localSharedPreferences.contains(localStringBuilder.toString());
  }
  
  public static void c(String paramString, AppRuntime paramAppRuntime)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("special_sound_type");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localStringBuilder.append(paramString);
    localEditor.remove(localStringBuilder.toString());
    localEditor.commit();
  }
  
  public static void c(List<String> paramList, AppRuntime paramAppRuntime)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("special_sound_type");
        localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
        localStringBuilder.append(str);
        localEditor.remove(localStringBuilder.toString());
      }
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil
 * JD-Core Version:    0.7.0.1
 */