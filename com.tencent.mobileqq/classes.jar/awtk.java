import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class awtk
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private awtj jdField_a_of_type_Awtj = new awtj();
  private HashMap<awtj, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<awtj, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(awtj paramawtj, String paramString)
  {
    if (paramawtj == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(paramawtj, localObject);
    }
    localObject = paramawtj.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    awtj localawtj;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localawtj = (awtj)((Iterator)localObject).next();
    } while ((localawtj == null) || (localawtj.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!paramawtj.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramawtj, paramString);
        return;
      }
      localObject = paramawtj.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localawtj = (awtj)((Iterator)localObject).next();
        if (localawtj != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (paramawtj = paramString + "/" + localawtj.jdField_a_of_type_JavaLangString;; paramawtj = localawtj.jdField_a_of_type_JavaLangString)
      {
        a(localawtj, paramawtj);
        break label117;
        break;
      }
    }
  }
  
  private void b(awtj paramawtj, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramawtj.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        paramawtj = paramString;
      }
      else
      {
        paramString = new awtj(str);
        paramString.jdField_a_of_type_Int = 1;
        paramawtj.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        paramawtj = paramString;
      }
    }
  }
  
  public HashMap<awtj, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Awtj, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Awtj, paramString);
  }
  
  public HashMap<awtj, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awtk
 * JD-Core Version:    0.7.0.1
 */