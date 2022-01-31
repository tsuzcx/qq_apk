import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class azoz
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private azoy jdField_a_of_type_Azoy = new azoy();
  private HashMap<azoy, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<azoy, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(azoy paramazoy, String paramString)
  {
    if (paramazoy == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(paramazoy, localObject);
    }
    localObject = paramazoy.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    azoy localazoy;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localazoy = (azoy)((Iterator)localObject).next();
    } while ((localazoy == null) || (localazoy.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!paramazoy.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramazoy, paramString);
        return;
      }
      localObject = paramazoy.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localazoy = (azoy)((Iterator)localObject).next();
        if (localazoy != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (paramazoy = paramString + "/" + localazoy.jdField_a_of_type_JavaLangString;; paramazoy = localazoy.jdField_a_of_type_JavaLangString)
      {
        a(localazoy, paramazoy);
        break label117;
        break;
      }
    }
  }
  
  private void b(azoy paramazoy, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramazoy.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        paramazoy = paramString;
      }
      else
      {
        paramString = new azoy(str);
        paramString.jdField_a_of_type_Int = 1;
        paramazoy.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        paramazoy = paramString;
      }
    }
  }
  
  public HashMap<azoy, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Azoy, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Azoy, paramString);
  }
  
  public HashMap<azoy, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azoz
 * JD-Core Version:    0.7.0.1
 */