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
  private static final SearchWordHistoryManager jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager;
  public static final String a;
  private static final CopyOnWriteArrayList<SearchWordHistoryManager.OnSearchHistoryChangeListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = SearchWordHistoryManager.class.getSimpleName();
    jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager = new SearchWordHistoryManager();
    jdField_a_of_type_Boolean = false;
  }
  
  public SearchWordHistoryManager() {}
  
  public SearchWordHistoryManager(QQAppInterface paramQQAppInterface) {}
  
  @NonNull
  public static SearchWordHistoryManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager;
  }
  
  @NonNull
  private String a()
  {
    return (String)((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("search_keyword_list", "");
  }
  
  @NonNull
  private String a(List<TKDSearchHistoryBean> paramList)
  {
    try
    {
      paramList = new Gson().toJson(paramList, a());
      return paramList;
    }
    catch (Exception paramList)
    {
      label18:
      break label18;
    }
    return "";
  }
  
  @NonNull
  private Type a()
  {
    return new SearchWordHistoryManager.1(this).getType();
  }
  
  @NonNull
  private List<TKDSearchHistoryBean> a(String paramString)
  {
    try
    {
      List localList = (List)new Gson().fromJson(paramString, a());
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
  
  public static void a(@NonNull SearchWordHistoryManager.OnSearchHistoryChangeListener paramOnSearchHistoryChangeListener)
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramOnSearchHistoryChangeListener);
  }
  
  private void a(@NonNull List<TKDSearchHistoryBean> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > 30) {
      localObject = paramList.subList(0, 30);
    }
    jdField_a_of_type_Boolean = true;
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoySpValue("search_keyword_list", a((List)localObject));
    b();
  }
  
  private void b()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((SearchWordHistoryManager.OnSearchHistoryChangeListener)localIterator.next()).onHistoryChanged();
    }
  }
  
  public static void b(@NonNull SearchWordHistoryManager.OnSearchHistoryChangeListener paramOnSearchHistoryChangeListener)
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramOnSearchHistoryChangeListener);
  }
  
  @NonNull
  public ArrayList<String> a()
  {
    Object localObject = a();
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
  public List<TKDSearchHistoryBean> a()
  {
    return a(a());
  }
  
  public void a()
  {
    a(new ArrayList());
  }
  
  public void a(int paramInt)
  {
    List localList = a();
    if (paramInt < localList.size()) {
      localList.remove(paramInt);
    }
    a(localList);
  }
  
  public void a(@NonNull TKDSearchHistoryBean paramTKDSearchHistoryBean)
  {
    List localList = a();
    localList.remove(paramTKDSearchHistoryBean);
    localList.add(0, paramTKDSearchHistoryBean);
    a(localList);
  }
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "addSearchHistory key word is null");
      }
      return;
    }
    List localList = a();
    if ((!b) && (paramString == null)) {
      throw new AssertionError();
    }
    paramString = TKDSearchHistoryBean.createFromKeyword(paramString);
    localList.remove(paramString);
    localList.add(0, paramString);
    a(localList);
  }
  
  public void a(@Nullable JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "addAllSearchHistory key word is null");
      }
      return;
    }
    List localList = a();
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
    a(localArrayList);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchWordHistoryManager
 * JD-Core Version:    0.7.0.1
 */