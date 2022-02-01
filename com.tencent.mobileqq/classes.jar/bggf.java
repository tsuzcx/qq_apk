import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bggf<V>
  implements Manager
{
  private final ArrayList<bggh<V>> a = new ArrayList();
  
  static
  {
    bglg.a.a();
  }
  
  public static <E> bggg<E> a(bggg<E> parambggg)
  {
    return new bggi(parambggg);
  }
  
  public void a(String arg1, bggg<V> parambggg, Object paramObject)
  {
    if (parambggg != null)
    {
      parambggg = new bggh(parambggg, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambggg);
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
          bggh localbggh = (bggh)this.a.get(i);
          if (paramString.equals(localbggh.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbggh);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bggh)paramString.next();
          ((bggh)???).jdField_a_of_type_Bggg.a(paramV, ((bggh)???).jdField_a_of_type_JavaLangObject);
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
 * Qualified Name:     bggf
 * JD-Core Version:    0.7.0.1
 */