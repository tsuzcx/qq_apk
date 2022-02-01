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
  private HashMap<String, Integer> a = new HashMap();
  private int b = 0;
  private long c;
  
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
    localBlessUinList.c = paramSharedPreferences.getLong(str, 0L);
    if (DateUtils.isToday(localBlessUinList.c)) {
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
        localBlessUinList.c = System.currentTimeMillis();
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
    Object localObject2 = paramBlessUinList.a.entrySet().iterator();
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
      paramSharedPreferences.putLong("web_uin_list_time_millis", paramBlessUinList.c);
    }
    else
    {
      paramSharedPreferences.putString("bless_uin_list", (String)localObject1);
      paramSharedPreferences.putLong("bless_uin_list_time_millis", paramBlessUinList.c);
    }
    paramSharedPreferences.commit();
  }
  
  private void a(String paramString, int paramInt)
  {
    this.b += paramInt;
    this.a.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    if (!DateUtils.isToday(this.c)) {
      d();
    }
  }
  
  public void a(String paramString)
  {
    this.b += 1;
    if (this.a.containsKey(paramString))
    {
      HashMap localHashMap = this.a;
      localHashMap.put(paramString, Integer.valueOf(((Integer)localHashMap.get(paramString)).intValue() + 1));
      return;
    }
    this.a.put(paramString, Integer.valueOf(1));
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public boolean b(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void d()
  {
    this.a.clear();
    this.b = 0;
    this.c = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessUinList
 * JD-Core Version:    0.7.0.1
 */