import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bduo<V>
  implements Manager
{
  private final ArrayList<bduq<V>> a = new ArrayList();
  
  public static <E> bdup<E> a(bdup<E> parambdup)
  {
    return new bdur(parambdup);
  }
  
  public void a(String arg1, bdup<V> parambdup, Object paramObject)
  {
    if (parambdup != null)
    {
      parambdup = new bduq(parambdup, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambdup);
        return;
      }
    }
  }
  
  public void a(String paramString, V paramV)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        i = this.a.size() - 1;
        if (i >= 0)
        {
          bduq localbduq = (bduq)this.a.get(i);
          if (paramString.equals(localbduq.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbduq);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bduq)paramString.next();
          ((bduq)???).jdField_a_of_type_Bdup.a(paramV, ((bduq)???).jdField_a_of_type_JavaLangObject);
        }
      }
      i -= 1;
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduo
 * JD-Core Version:    0.7.0.1
 */