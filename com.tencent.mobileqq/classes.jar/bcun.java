import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class bcun
{
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private TreeMap<bcuo, String> jdField_a_of_type_JavaUtilTreeMap;
  
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
    localStringBuilder.append("fd: ").append((String)((Map.Entry)localObject).getValue()).append(" ").append("(").append("count: ").append(((bcuo)((Map.Entry)localObject).getKey()).jdField_a_of_type_Int).append(")").append("\n");
    Object localObject = new ArrayList(((bcuo)((Map.Entry)localObject).getKey()).jdField_a_of_type_JavaUtilHashMap.values());
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    int j = 0;
    for (;;)
    {
      bcuo localbcuo;
      if (((Iterator)localObject).hasNext())
      {
        localbcuo = (bcuo)((Iterator)localObject).next();
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
      localStringBuilder.append("\t\t").append(localbcuo.jdField_a_of_type_JavaLangString).append("(").append("count: ").append(localbcuo.jdField_a_of_type_Int).append(")").append("\n");
    }
  }
  
  private void a(bcup parambcup)
  {
    parambcup.a();
    c(parambcup);
    b(parambcup);
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
  
  private void b(bcup parambcup)
  {
    Object localObject = parambcup.a();
    parambcup = new HashMap(20);
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      String str = (String)localEntry.getValue();
      if (bcup.a(str) == null) {
        parambcup.put(localEntry.getKey(), str);
      }
    }
    this.jdField_a_of_type_JavaUtilTreeMap = new TreeMap(parambcup);
  }
  
  private void c(bcup parambcup)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap(10);
    parambcup = parambcup.b().entrySet().iterator();
    while (parambcup.hasNext())
    {
      Object localObject = (Map.Entry)parambcup.next();
      bcuo localbcuo = (bcuo)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(localbcuo.jdField_a_of_type_Int));
      }
      else
      {
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        Map localMap = this.jdField_a_of_type_JavaUtilMap;
        int i = localInteger.intValue();
        localMap.put(localObject, Integer.valueOf(localbcuo.jdField_a_of_type_Int + i));
      }
    }
  }
  
  public String a(bcup parambcup)
  {
    a(parambcup);
    return a() + b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcun
 * JD-Core Version:    0.7.0.1
 */