import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bdmr
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private bdmq jdField_a_of_type_Bdmq = new bdmq();
  private HashMap<bdmq, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<bdmq, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
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
  
  private void a(bdmq parambdmq, String paramString)
  {
    if (parambdmq == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(parambdmq, localObject);
    }
    localObject = parambdmq.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    bdmq localbdmq;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbdmq = (bdmq)((Iterator)localObject).next();
    } while ((localbdmq == null) || (localbdmq.a()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!parambdmq.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(parambdmq, paramString);
        return;
      }
      localObject = parambdmq.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localbdmq = (bdmq)((Iterator)localObject).next();
        if (localbdmq != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (parambdmq = paramString + "/" + localbdmq.jdField_a_of_type_JavaLangString;; parambdmq = localbdmq.jdField_a_of_type_JavaLangString)
      {
        a(localbdmq, parambdmq);
        break label117;
        break;
      }
    }
  }
  
  private void b(bdmq parambdmq, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = parambdmq.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        parambdmq = paramString;
      }
      else
      {
        paramString = new bdmq(str);
        paramString.jdField_a_of_type_Int = 1;
        parambdmq.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        parambdmq = paramString;
      }
    }
  }
  
  public HashMap<bdmq, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Bdmq, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_Bdmq, paramString);
  }
  
  public HashMap<bdmq, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmr
 * JD-Core Version:    0.7.0.1
 */