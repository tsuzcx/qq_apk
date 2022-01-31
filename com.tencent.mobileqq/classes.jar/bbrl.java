import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bbrl<V>
  implements Manager
{
  private final ArrayList<bbrn<V>> a = new ArrayList();
  
  public static <E> bbrm<E> a(bbrm<E> parambbrm)
  {
    return new bbro(parambbrm);
  }
  
  public void a(String arg1, bbrm<V> parambbrm, Object paramObject)
  {
    if (parambbrm != null)
    {
      parambbrm = new bbrn(parambbrm, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambbrm);
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
          bbrn localbbrn = (bbrn)this.a.get(i);
          if (paramString.equals(localbbrn.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbbrn);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bbrn)paramString.next();
          ((bbrn)???).jdField_a_of_type_Bbrm.a(paramV, ((bbrn)???).jdField_a_of_type_JavaLangObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrl
 * JD-Core Version:    0.7.0.1
 */