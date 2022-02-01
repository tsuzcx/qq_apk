import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class bdmp
{
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private TreeMap<bdmq, String> jdField_a_of_type_JavaUtilTreeMap;
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nBusiness\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeMap.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (i < 20) {}
    }
    else
    {
      return localStringBuilder.toString();
    }
    localStringBuilder.append("fd: ").append((String)((Map.Entry)localObject).getValue()).append(" ").append("(").append("count: ").append(((bdmq)((Map.Entry)localObject).getKey()).jdField_a_of_type_Int).append(")").append("\n");
    Object localObject = new ArrayList(((bdmq)((Map.Entry)localObject).getKey()).jdField_a_of_type_JavaUtilHashMap.values());
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    int j = 0;
    for (;;)
    {
      bdmq localbdmq;
      if (((Iterator)localObject).hasNext())
      {
        localbdmq = (bdmq)((Iterator)localObject).next();
        if (j >= 5) {
          localStringBuilder.append("\t\t").append("…").append("\n");
        }
      }
      else
      {
        i += 1;
        break;
      }
      j += 1;
      localStringBuilder.append("\t\t").append(localbdmq.jdField_a_of_type_JavaLangString).append("(").append("count: ").append(localbdmq.jdField_a_of_type_Int).append(")").append("\n");
    }
  }
  
  private void a(bdmr parambdmr)
  {
    parambdmr.a();
    c(parambdmr);
    b(parambdmr);
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSystem\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("fd: ").append((String)localEntry.getKey()).append(" ").append("(").append("count: ").append(localEntry.getValue()).append(")").append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private void b(bdmr parambdmr)
  {
    Object localObject = parambdmr.a();
    parambdmr = new HashMap(20);
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      String str = (String)localEntry.getValue();
      if (bdmr.a(str) == null) {
        parambdmr.put(localEntry.getKey(), str);
      }
    }
    this.jdField_a_of_type_JavaUtilTreeMap = new TreeMap(parambdmr);
  }
  
  private void c(bdmr parambdmr)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap(10);
    parambdmr = parambdmr.b().entrySet().iterator();
    while (parambdmr.hasNext())
    {
      Object localObject = (Map.Entry)parambdmr.next();
      bdmq localbdmq = (bdmq)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(localbdmq.jdField_a_of_type_Int));
      }
      else
      {
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        Map localMap = this.jdField_a_of_type_JavaUtilMap;
        int i = localInteger.intValue();
        localMap.put(localObject, Integer.valueOf(localbdmq.jdField_a_of_type_Int + i));
      }
    }
  }
  
  public String a(bdmr parambdmr)
  {
    a(parambdmr);
    return a() + b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmp
 * JD-Core Version:    0.7.0.1
 */