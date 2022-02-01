import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bgzp<V>
  implements Manager
{
  private final ArrayList<bgzr<V>> a = new ArrayList();
  
  static
  {
    bhek.a.a();
  }
  
  public static <E> bgzq<E> a(bgzq<E> parambgzq)
  {
    return new bgzs(parambgzq);
  }
  
  public void a(String arg1, bgzq<V> parambgzq, Object paramObject)
  {
    if (parambgzq != null)
    {
      parambgzq = new bgzr(parambgzq, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambgzq);
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
          bgzr localbgzr = (bgzr)this.a.get(i);
          if (paramString.equals(localbgzr.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbgzr);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bgzr)paramString.next();
          ((bgzr)???).jdField_a_of_type_Bgzq.a(paramV, ((bgzr)???).jdField_a_of_type_JavaLangObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzp
 * JD-Core Version:    0.7.0.1
 */