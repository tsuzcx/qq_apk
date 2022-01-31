import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class azox
{
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private TreeMap<azoy, String> jdField_a_of_type_JavaUtilTreeMap;
  
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
    localStringBuilder.append("fd: ").append((String)((Map.Entry)localObject).getValue()).append(" ").append("(").append("count: ").append(((azoy)((Map.Entry)localObject).getKey()).jdField_a_of_type_Int).append(")").append("\n");
    Object localObject = new ArrayList(((azoy)((Map.Entry)localObject).getKey()).jdField_a_of_type_JavaUtilHashMap.values());
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    int j = 0;
    for (;;)
    {
      azoy localazoy;
      if (((Iterator)localObject).hasNext())
      {
        localazoy = (azoy)((Iterator)localObject).next();
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
      localStringBuilder.append("\t\t").append(localazoy.jdField_a_of_type_JavaLangString).append("(").append("count: ").append(localazoy.jdField_a_of_type_Int).append(")").append("\n");
    }
  }
  
  private void a(azoz paramazoz)
  {
    paramazoz.a();
    c(paramazoz);
    b(paramazoz);
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
  
  private void b(azoz paramazoz)
  {
    Object localObject = paramazoz.a();
    paramazoz = new HashMap(20);
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      String str = (String)localEntry.getValue();
      if (azoz.a(str) == null) {
        paramazoz.put(localEntry.getKey(), str);
      }
    }
    this.jdField_a_of_type_JavaUtilTreeMap = new TreeMap(paramazoz);
  }
  
  private void c(azoz paramazoz)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap(10);
    paramazoz = paramazoz.b().entrySet().iterator();
    while (paramazoz.hasNext())
    {
      Object localObject = (Map.Entry)paramazoz.next();
      azoy localazoy = (azoy)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(localazoy.jdField_a_of_type_Int));
      }
      else
      {
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        Map localMap = this.jdField_a_of_type_JavaUtilMap;
        int i = localInteger.intValue();
        localMap.put(localObject, Integer.valueOf(localazoy.jdField_a_of_type_Int + i));
      }
    }
  }
  
  public String a(azoz paramazoz)
  {
    a(paramazoz);
    return a() + b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azox
 * JD-Core Version:    0.7.0.1
 */