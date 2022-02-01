package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GroupSearchHistoryManager
{
  public static GroupSearchHistoryManager a()
  {
    return GroupSearchHistoryManager.GroupSearchHistoryManagerHolder.a();
  }
  
  private ArrayList<GroupSearchHistoryManager.GroupSearchHistoryBean> b(String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("group_search_local_history_");
    ((StringBuilder)localObject2).append(paramString);
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getAll();
    paramString = new ArrayList();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramString.add(new GroupSearchHistoryManager.GroupSearchHistoryBean(this, (String)((Map.Entry)localObject2).getKey(), (Long)((Map.Entry)localObject2).getValue()));
    }
    Collections.sort(paramString);
    return paramString;
  }
  
  ArrayList<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = b(paramString).iterator();
    while (paramString.hasNext()) {
      localArrayList.add(((GroupSearchHistoryManager.GroupSearchHistoryBean)paramString.next()).a());
    }
    return localArrayList;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString2.trim())) {
        return;
      }
      Object localObject1 = BaseApplicationImpl.getApplication();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("group_search_local_history_");
      ((StringBuilder)localObject2).append(paramString1);
      localObject2 = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      localObject1 = ((SharedPreferences)localObject2).edit();
      if (((SharedPreferences)localObject2).getLong(paramString2, -1L) == -1L)
      {
        paramString1 = b(paramString1);
        if ((paramString1 != null) && (paramString1.size() >= 3))
        {
          int i = 2;
          while (i < paramString1.size())
          {
            ((SharedPreferences.Editor)localObject1).remove(((GroupSearchHistoryManager.GroupSearchHistoryBean)paramString1.get(i)).a());
            i += 1;
          }
        }
      }
      ((SharedPreferences.Editor)localObject1).putLong(paramString2, System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  void b(String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_search_local_history_");
    localStringBuilder.append(paramString1);
    paramString1 = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramString1.remove(paramString2);
    paramString1.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */