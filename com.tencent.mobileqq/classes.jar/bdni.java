import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bdni
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private bdnh jdField_a_of_type_Bdnh = new bdnh();
  private HashMap<bdnh, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<bdnh, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(bdnh parambdnh, String paramString)
  {
    if (parambdnh == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(parambdnh, localObject);
    }
    localObject = parambdnh.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    bdnh localbdnh;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbdnh = (bdnh)((Iterator)localObject).next();
    } while ((localbdnh == null) || (localbdnh.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!parambdnh.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(parambdnh, paramString);
        return;
      }
      localObject = parambdnh.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localbdnh = (bdnh)((Iterator)localObject).next();
        if (localbdnh != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (parambdnh = paramString + "/" + localbdnh.jdField_a_of_type_JavaLangString;; parambdnh = localbdnh.jdField_a_of_type_JavaLangString)
      {
        a(localbdnh, parambdnh);
        break label117;
        break;
      }
    }
  }
  
  private void b(bdnh parambdnh, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = parambdnh.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        parambdnh = paramString;
      }
      else
      {
        paramString = new bdnh(str);
        paramString.jdField_a_of_type_Int = 1;
        parambdnh.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        parambdnh = paramString;
      }
    }
  }
  
  public HashMap<bdnh, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Bdnh, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Bdnh, paramString);
  }
  
  public HashMap<bdnh, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdni
 * JD-Core Version:    0.7.0.1
 */