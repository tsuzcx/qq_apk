package com.tencent.mobileqq.activity.bless;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.DateUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class BlessUinList
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static BlessUinList a(SharedPreferences paramSharedPreferences, int paramInt)
  {
    Object localObject;
    String str;
    if (paramInt == 2)
    {
      localObject = "web_uin_list";
      str = "web_uin_list_time_millis";
    }
    else
    {
      localObject = "bless_uin_list";
      str = "bless_uin_list_time_millis";
    }
    BlessUinList localBlessUinList = new BlessUinList();
    localBlessUinList.jdField_a_of_type_Long = paramSharedPreferences.getLong(str, 0L);
    if (DateUtils.isToday(localBlessUinList.jdField_a_of_type_Long)) {
      try
      {
        paramSharedPreferences = paramSharedPreferences.getString((String)localObject, "[]");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("read uin list from mode=");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" ,SP=");
          ((StringBuilder)localObject).append(paramSharedPreferences);
          QLog.d("BlessManager", 2, ((StringBuilder)localObject).toString());
        }
        paramSharedPreferences = new JSONArray(paramSharedPreferences);
        paramInt = 0;
        for (;;)
        {
          int i = paramInt + 1;
          if (i >= paramSharedPreferences.length()) {
            break;
          }
          localBlessUinList.a(paramSharedPreferences.getString(paramInt), paramSharedPreferences.getInt(i));
          paramInt += 2;
        }
        localBlessUinList.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      catch (Exception paramSharedPreferences)
      {
        paramSharedPreferences.printStackTrace();
        return null;
      }
    }
    return localBlessUinList;
  }
  
  public static void a(SharedPreferences paramSharedPreferences, BlessUinList paramBlessUinList, int paramInt)
  {
    paramBlessUinList.a();
    Object localObject1 = new JSONArray();
    Object localObject2 = paramBlessUinList.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((JSONArray)localObject1).put(localEntry.getKey());
      ((JSONArray)localObject1).put(localEntry.getValue());
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    localObject1 = ((JSONArray)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("save uin list to SP=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 2)
    {
      paramSharedPreferences.putString("web_uin_list", (String)localObject1);
      paramSharedPreferences.putLong("web_uin_list_time_millis", paramBlessUinList.jdField_a_of_type_Long);
    }
    else
    {
      paramSharedPreferences.putString("bless_uin_list", (String)localObject1);
      paramSharedPreferences.putLong("bless_uin_list_time_millis", paramBlessUinList.jdField_a_of_type_Long);
    }
    paramSharedPreferences.commit();
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int += paramInt;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.size();
  }
  
  public void a()
  {
    if (!DateUtils.isToday(this.jdField_a_of_type_Long)) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      localHashMap.put(paramString, Integer.valueOf(((Integer)localHashMap.get(paramString)).intValue() + 1));
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessUinList
 * JD-Core Version:    0.7.0.1
 */