import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bcft
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private bcfs jdField_a_of_type_Bcfs = new bcfs();
  private HashMap<bcfs, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<bcfs, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(bcfs parambcfs, String paramString)
  {
    if (parambcfs == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(parambcfs, localObject);
    }
    localObject = parambcfs.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    bcfs localbcfs;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbcfs = (bcfs)((Iterator)localObject).next();
    } while ((localbcfs == null) || (localbcfs.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!parambcfs.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(parambcfs, paramString);
        return;
      }
      localObject = parambcfs.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localbcfs = (bcfs)((Iterator)localObject).next();
        if (localbcfs != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (parambcfs = paramString + "/" + localbcfs.jdField_a_of_type_JavaLangString;; parambcfs = localbcfs.jdField_a_of_type_JavaLangString)
      {
        a(localbcfs, parambcfs);
        break label117;
        break;
      }
    }
  }
  
  private void b(bcfs parambcfs, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = parambcfs.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        parambcfs = paramString;
      }
      else
      {
        paramString = new bcfs(str);
        paramString.jdField_a_of_type_Int = 1;
        parambcfs.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        parambcfs = paramString;
      }
    }
  }
  
  public HashMap<bcfs, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Bcfs, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Bcfs, paramString);
  }
  
  public HashMap<bcfs, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcft
 * JD-Core Version:    0.7.0.1
 */