import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class bbsw<K, V>
{
  private HashMap<K, ArrayList<V>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bbsw(bbsv parambbsv) {}
  
  public ArrayList<V> a(K paramK)
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramK);
  }
  
  public void a(V paramV)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ArrayList localArrayList = (ArrayList)localEntry.getValue();
      int i = 0;
      while (i < localArrayList.size())
      {
        Object localObject = localArrayList.get(i);
        if ((localObject == paramV) || ((localObject != null) && (localObject.equals(paramV)))) {
          ((ArrayList)localEntry.getValue()).remove(paramV);
        } else {
          i += 1;
        }
      }
    }
  }
  
  public void a(K paramK, V paramV)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramK);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramK, localArrayList1);
    }
    if (!localArrayList1.contains(paramV)) {
      localArrayList1.add(paramV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsw
 * JD-Core Version:    0.7.0.1
 */