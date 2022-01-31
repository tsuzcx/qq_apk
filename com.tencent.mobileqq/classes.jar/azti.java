import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class azti
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private azth jdField_a_of_type_Azth = new azth();
  private HashMap<azth, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<azth, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(azth paramazth, String paramString)
  {
    if (paramazth == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(paramazth, localObject);
    }
    localObject = paramazth.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    azth localazth;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localazth = (azth)((Iterator)localObject).next();
    } while ((localazth == null) || (localazth.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!paramazth.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramazth, paramString);
        return;
      }
      localObject = paramazth.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localazth = (azth)((Iterator)localObject).next();
        if (localazth != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (paramazth = paramString + "/" + localazth.jdField_a_of_type_JavaLangString;; paramazth = localazth.jdField_a_of_type_JavaLangString)
      {
        a(localazth, paramazth);
        break label117;
        break;
      }
    }
  }
  
  private void b(azth paramazth, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramazth.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        paramazth = paramString;
      }
      else
      {
        paramString = new azth(str);
        paramString.jdField_a_of_type_Int = 1;
        paramazth.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        paramazth = paramString;
      }
    }
  }
  
  public HashMap<azth, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Azth, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Azth, paramString);
  }
  
  public HashMap<azth, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azti
 * JD-Core Version:    0.7.0.1
 */