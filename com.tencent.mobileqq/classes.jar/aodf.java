import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.TKDSearchHistoryBean;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;

public class aodf
  implements Manager
{
  private static final aodf jdField_a_of_type_Aodf;
  public static final String a;
  private static final CopyOnWriteArrayList<aodh> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static boolean a;
  
  static
  {
    if (!aodf.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      jdField_a_of_type_JavaLangString = aodf.class.getSimpleName();
      jdField_a_of_type_Aodf = new aodf();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(((Boolean)bmhv.a("SearchWordHistoryManager.spkey_has_migrate_from_old_version", Boolean.valueOf(true))).booleanValue());
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
      return;
    }
  }
  
  public aodf() {}
  
  public aodf(QQAppInterface paramQQAppInterface) {}
  
  @NonNull
  public static aodf a()
  {
    return jdField_a_of_type_Aodf;
  }
  
  @NonNull
  private String a()
  {
    return (String)bmhv.a("search_keyword_list", "");
  }
  
  @NonNull
  private String a(List<TKDSearchHistoryBean> paramList)
  {
    try
    {
      paramList = new Gson().toJson(paramList, a());
      return paramList;
    }
    catch (Exception paramList) {}
    return "";
  }
  
  @NonNull
  private Type a()
  {
    return new aodg(this).getType();
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
    catch (Exception paramString) {}
    return new ArrayList();
  }
  
  public static void a(@NonNull aodh paramaodh)
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaodh);
  }
  
  private void a(@NonNull List<TKDSearchHistoryBean> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > 30) {
      localObject = paramList.subList(0, 30);
    }
    jdField_a_of_type_Boolean = true;
    bmhv.a("search_keyword_list", a((List)localObject));
    c();
  }
  
  @NonNull
  private ArrayList<String> b()
  {
    localArrayList = new ArrayList();
    Object localObject = a();
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(((JSONArray)localObject).optString(i));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void b()
  {
    Object localObject = b();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(TKDSearchHistoryBean.createFromKeyword((String)((Iterator)localObject).next()));
    }
    a(localArrayList);
  }
  
  public static void b(@NonNull aodh paramaodh)
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaodh);
  }
  
  private void c()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aodh)localIterator.next()).onHistoryChanged();
    }
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
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      b();
      bmhv.a("SearchWordHistoryManager.spkey_has_migrate_from_old_version", Boolean.valueOf(false));
    }
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
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optString(i);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = TKDSearchHistoryBean.createFromKeyword((String)localObject);
        localArrayList.add(localObject);
        localList.remove(localObject);
      }
    }
    localArrayList.addAll(localList);
    a(localArrayList);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodf
 * JD-Core Version:    0.7.0.1
 */