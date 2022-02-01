package com.tencent.mobileqq.app;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.TKDSearchHistoryBean;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import org.json.JSONArray;

public class SearchWordHistoryManager
  implements Manager
{
  public static final String a;
  public static boolean b = false;
  private static final SearchWordHistoryManager d;
  private static final CopyOnWriteArrayList<SearchWordHistoryManager.OnSearchHistoryChangeListener> e = new CopyOnWriteArrayList();
  
  static
  {
    a = SearchWordHistoryManager.class.getSimpleName();
    d = new SearchWordHistoryManager();
  }
  
  public SearchWordHistoryManager() {}
  
  public SearchWordHistoryManager(QQAppInterface paramQQAppInterface) {}
  
  @NonNull
  public static SearchWordHistoryManager a()
  {
    return d;
  }
  
  @NonNull
  private String a(List<TKDSearchHistoryBean> paramList)
  {
    try
    {
      paramList = new Gson().toJson(paramList, e());
      return paramList;
    }
    catch (Exception paramList)
    {
      label18:
      break label18;
    }
    return "";
  }
  
  public static void a(@NonNull SearchWordHistoryManager.OnSearchHistoryChangeListener paramOnSearchHistoryChangeListener)
  {
    e.add(paramOnSearchHistoryChangeListener);
  }
  
  @NonNull
  private List<TKDSearchHistoryBean> b(String paramString)
  {
    try
    {
      List localList = (List)new Gson().fromJson(paramString, e());
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      label35:
      break label35;
    }
    return new ArrayList();
  }
  
  public static void b(@NonNull SearchWordHistoryManager.OnSearchHistoryChangeListener paramOnSearchHistoryChangeListener)
  {
    e.remove(paramOnSearchHistoryChangeListener);
  }
  
  private void b(@NonNull List<TKDSearchHistoryBean> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > 30) {
      localObject = paramList.subList(0, 30);
    }
    b = true;
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoySpValue("search_keyword_list", a((List)localObject));
    g();
  }
  
  @NonNull
  private Type e()
  {
    return new SearchWordHistoryManager.1(this).getType();
  }
  
  @NonNull
  private String f()
  {
    return (String)((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("search_keyword_list", "");
  }
  
  private void g()
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((SearchWordHistoryManager.OnSearchHistoryChangeListener)localIterator.next()).onHistoryChanged();
    }
  }
  
  public void a(int paramInt)
  {
    List localList = c();
    if (paramInt < localList.size()) {
      localList.remove(paramInt);
    }
    b(localList);
  }
  
  public void a(@NonNull TKDSearchHistoryBean paramTKDSearchHistoryBean)
  {
    List localList = c();
    localList.remove(paramTKDSearchHistoryBean);
    localList.add(0, paramTKDSearchHistoryBean);
    b(localList);
  }
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "addSearchHistory key word is null");
      }
      return;
    }
    List localList = c();
    if ((!c) && (paramString == null)) {
      throw new AssertionError();
    }
    paramString = TKDSearchHistoryBean.createFromKeyword(paramString);
    localList.remove(paramString);
    localList.add(0, paramString);
    b(localList);
  }
  
  public void a(@Nullable JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "addAllSearchHistory key word is null");
      }
      return;
    }
    List localList = c();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = TKDSearchHistoryBean.createFromKeyword((String)localObject);
        localArrayList.add(localObject);
        localList.remove(localObject);
      }
      i += 1;
    }
    localArrayList.addAll(localList);
    b(localArrayList);
  }
  
  @NonNull
  public ArrayList<String> b()
  {
    Object localObject = c();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TKDSearchHistoryBean localTKDSearchHistoryBean = (TKDSearchHistoryBean)((Iterator)localObject).next();
      if (localTKDSearchHistoryBean != null) {
        localArrayList.add(localTKDSearchHistoryBean.getTitle());
      }
    }
    return localArrayList;
  }
  
  @NonNull
  public List<TKDSearchHistoryBean> c()
  {
    return b(f());
  }
  
  public void d()
  {
    b(new ArrayList());
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchWordHistoryManager
 * JD-Core Version:    0.7.0.1
 */