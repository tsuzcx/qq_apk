import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class axte
{
  private int jdField_a_of_type_Int;
  private LinkedHashMap<String, Integer> jdField_a_of_type_JavaUtilLinkedHashMap;
  private int b;
  
  public axte(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(paramInt1, 0.5F, true);
  }
  
  public Map<String, Integer> a()
  {
    HashMap localHashMap = null;
    label110:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Integer)localEntry.getValue()).intValue() < this.b) {
            break label110;
          }
          if (localHashMap == null)
          {
            localHashMap = new HashMap();
            localHashMap.put(localEntry.getKey(), localEntry.getValue());
            break label110;
          }
        }
        else
        {
          return localHashMap;
        }
      }
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      return;
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramString))
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString)).intValue() + 1));
          if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() <= this.jdField_a_of_type_Int) {
            break;
          }
          paramString = (Map.Entry)this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator().next();
          this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString.getKey());
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axte
 * JD-Core Version:    0.7.0.1
 */