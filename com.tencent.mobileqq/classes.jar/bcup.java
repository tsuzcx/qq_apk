import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bcup
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private bcuo jdField_a_of_type_Bcuo = new bcuo();
  private HashMap<bcuo, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<bcuo, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(bcuo parambcuo, String paramString)
  {
    if (parambcuo == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(parambcuo, localObject);
    }
    localObject = parambcuo.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    bcuo localbcuo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbcuo = (bcuo)((Iterator)localObject).next();
    } while ((localbcuo == null) || (localbcuo.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!parambcuo.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(parambcuo, paramString);
        return;
      }
      localObject = parambcuo.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localbcuo = (bcuo)((Iterator)localObject).next();
        if (localbcuo != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (parambcuo = paramString + "/" + localbcuo.jdField_a_of_type_JavaLangString;; parambcuo = localbcuo.jdField_a_of_type_JavaLangString)
      {
        a(localbcuo, parambcuo);
        break label117;
        break;
      }
    }
  }
  
  private void b(bcuo parambcuo, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = parambcuo.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        parambcuo = paramString;
      }
      else
      {
        paramString = new bcuo(str);
        paramString.jdField_a_of_type_Int = 1;
        parambcuo.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        parambcuo = paramString;
      }
    }
  }
  
  public HashMap<bcuo, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Bcuo, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Bcuo, paramString);
  }
  
  public HashMap<bcuo, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcup
 * JD-Core Version:    0.7.0.1
 */