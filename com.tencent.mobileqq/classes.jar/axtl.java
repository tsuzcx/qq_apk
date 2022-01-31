import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class axtl
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private axtk jdField_a_of_type_Axtk = new axtk();
  private HashMap<axtk, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<axtk, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
  static String a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((paramString != null) && (paramString.contains(str))) {
        return str;
      }
    }
    return null;
  }
  
  private static List<String> a(String paramString)
  {
    paramString = paramString.split("/");
    ArrayList localArrayList = new ArrayList(paramString.length);
    localArrayList.addAll(Arrays.asList(paramString));
    return localArrayList;
  }
  
  private void a(axtk paramaxtk, String paramString)
  {
    if (paramaxtk == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(paramaxtk, localObject);
    }
    localObject = paramaxtk.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    axtk localaxtk;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localaxtk = (axtk)((Iterator)localObject).next();
    } while ((localaxtk == null) || (localaxtk.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!paramaxtk.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramaxtk, paramString);
        return;
      }
      localObject = paramaxtk.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localaxtk = (axtk)((Iterator)localObject).next();
        if (localaxtk != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (paramaxtk = paramString + "/" + localaxtk.jdField_a_of_type_JavaLangString;; paramaxtk = localaxtk.jdField_a_of_type_JavaLangString)
      {
        a(localaxtk, paramaxtk);
        break label117;
        break;
      }
    }
  }
  
  private void b(axtk paramaxtk, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramaxtk.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        paramaxtk = paramString;
      }
      else
      {
        paramString = new axtk(str);
        paramString.jdField_a_of_type_Int = 1;
        paramaxtk.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        paramaxtk = paramString;
      }
    }
  }
  
  public HashMap<axtk, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Axtk, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Axtk, paramString);
  }
  
  public HashMap<axtk, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axtl
 * JD-Core Version:    0.7.0.1
 */