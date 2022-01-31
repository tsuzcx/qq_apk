import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bghu
{
  private static final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private static final Map<String, String> jdField_a_of_type_JavaUtilMap;
  public static volatile boolean a;
  private static Map<String, bghv> b;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add("index");
    jdField_a_of_type_JavaUtilArrayList.add("fav");
    jdField_a_of_type_JavaUtilArrayList.add("category");
    jdField_a_of_type_JavaUtilArrayList.add("more");
    jdField_a_of_type_JavaUtilArrayList.add("group");
    jdField_a_of_type_JavaUtilMap = new HashMap(5);
    jdField_a_of_type_JavaUtilMap.put("NavConfig", "index");
    jdField_a_of_type_JavaUtilMap.put("FavNavConfig", "fav");
    jdField_a_of_type_JavaUtilMap.put("CateNavConfig", "category");
    jdField_a_of_type_JavaUtilMap.put("MoreNavConfig", "more");
    jdField_a_of_type_JavaUtilMap.put("GroupNavConfig", "group");
    jdField_a_of_type_Boolean = a();
  }
  
  public static File a()
  {
    return new File(BaseApplicationImpl.getApplication().getFilesDir(), "comic_config/");
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {
      return new File(c(), paramString).getAbsolutePath();
    }
    return null;
  }
  
  public static List<bghv> a()
  {
    Object localObject = a();
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bghv localbghv = (bghv)((Iterator)localObject).next();
        if (localbghv.jdField_a_of_type_Int >= 0) {
          localArrayList.add(localbghv);
        }
      }
      Collections.sort(localArrayList);
      return localArrayList;
    }
    return null;
  }
  
  public static Map<String, bghv> a()
  {
    if (b == null) {
      a();
    }
    return b;
  }
  
  public static JSONObject a()
  {
    String str = bbdx.a(new File(a(), "vipComic_nav_config.json"));
    if (!TextUtils.isEmpty(str)) {
      return new JSONObject(str);
    }
    return null;
  }
  
  public static void a()
  {
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = a();
        if (localJSONObject1 != null)
        {
          if (b != null) {
            b.clear();
          }
          b = new HashMap();
          Iterator localIterator = localJSONObject1.keys();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject = localJSONObject1.optJSONArray(str);
            if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
              continue;
            }
            i = ((JSONArray)localObject).length() - 1;
            if (i < 0) {
              continue;
            }
            JSONObject localJSONObject2 = ((JSONArray)localObject).optJSONObject(i);
            if ((localJSONObject2 == null) || (!bcgq.a(localJSONObject2, str))) {
              break label247;
            }
            localObject = new bghv();
            ((bghv)localObject).jdField_a_of_type_JavaLangString = localJSONObject2.optString("tabKey");
            if ((TextUtils.isEmpty(((bghv)localObject).jdField_a_of_type_JavaLangString)) && (jdField_a_of_type_JavaUtilMap.containsKey(str))) {
              ((bghv)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_JavaUtilMap.get(str));
            }
            ((bghv)localObject).jdField_a_of_type_Int = localJSONObject2.optInt("sequence");
            ((bghv)localObject).b = localJSONObject2.optString("tabName");
            ((bghv)localObject).c = localJSONObject2.optString("tabUrl");
            ((bghv)localObject).d = localJSONObject2.optString("tabIcon");
            b.put(str, localObject);
            continue;
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("VipComicNavConfigHelper", 1, localJSONException, new Object[0]);
      }
      label247:
      i -= 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (a()) {
      a();
    }
    for (;;)
    {
      if (!b()) {
        ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(100L, "vipComic_nav_tabIcon.zip", "helper");
      }
      return;
      ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(100L, "vipComic_nav_config.json", "helper");
    }
  }
  
  public static boolean a()
  {
    return b().exists();
  }
  
  public static File b()
  {
    return new File(a(), "vipComic_nav_config.json");
  }
  
  public static boolean b()
  {
    jdField_a_of_type_Boolean = c();
    return jdField_a_of_type_Boolean;
  }
  
  public static File c()
  {
    return new File(a(), "tab_icons/");
  }
  
  private static boolean c()
  {
    Object localObject1 = a();
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      Object localObject2 = c().list();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject2 = Arrays.asList((Object[])localObject2);
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (!((List)localObject2).contains(((bghv)((Iterator)localObject1).next()).d)) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghu
 * JD-Core Version:    0.7.0.1
 */