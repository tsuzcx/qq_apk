import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bhzv<V>
  implements Manager
{
  private final ArrayList<bhzx<V>> a = new ArrayList();
  
  static
  {
    biev.a.a();
  }
  
  public static <E> bhzw<E> a(bhzw<E> parambhzw)
  {
    return new bhzy(parambhzw);
  }
  
  public void a(String arg1, bhzw<V> parambhzw, Object paramObject)
  {
    if (parambhzw != null)
    {
      parambhzw = new bhzx(parambhzw, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambhzw);
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
          bhzx localbhzx = (bhzx)this.a.get(i);
          if (paramString.equals(localbhzx.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbhzx);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bhzx)paramString.next();
          ((bhzx)???).jdField_a_of_type_Bhzw.a(paramV, ((bhzx)???).jdField_a_of_type_JavaLangObject);
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
 * Qualified Name:     bhzv
 * JD-Core Version:    0.7.0.1
 */