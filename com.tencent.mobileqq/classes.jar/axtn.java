import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class axtn
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private axtm jdField_a_of_type_Axtm = new axtm();
  private HashMap<axtm, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<axtm, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(axtm paramaxtm, String paramString)
  {
    if (paramaxtm == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(paramaxtm, localObject);
    }
    localObject = paramaxtm.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    axtm localaxtm;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localaxtm = (axtm)((Iterator)localObject).next();
    } while ((localaxtm == null) || (localaxtm.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!paramaxtm.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramaxtm, paramString);
        return;
      }
      localObject = paramaxtm.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localaxtm = (axtm)((Iterator)localObject).next();
        if (localaxtm != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (paramaxtm = paramString + "/" + localaxtm.jdField_a_of_type_JavaLangString;; paramaxtm = localaxtm.jdField_a_of_type_JavaLangString)
      {
        a(localaxtm, paramaxtm);
        break label117;
        break;
      }
    }
  }
  
  private void b(axtm paramaxtm, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramaxtm.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        paramaxtm = paramString;
      }
      else
      {
        paramString = new axtm(str);
        paramString.jdField_a_of_type_Int = 1;
        paramaxtm.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        paramaxtm = paramString;
      }
    }
  }
  
  public HashMap<axtm, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Axtm, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Axtm, paramString);
  }
  
  public HashMap<axtm, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axtn
 * JD-Core Version:    0.7.0.1
 */