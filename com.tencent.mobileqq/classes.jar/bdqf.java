import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bdqf<V>
  implements Manager
{
  private final ArrayList<bdqh<V>> a = new ArrayList();
  
  public static <E> bdqg<E> a(bdqg<E> parambdqg)
  {
    return new bdqi(parambdqg);
  }
  
  public void a(String arg1, bdqg<V> parambdqg, Object paramObject)
  {
    if (parambdqg != null)
    {
      parambdqg = new bdqh(parambdqg, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambdqg);
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
          bdqh localbdqh = (bdqh)this.a.get(i);
          if (paramString.equals(localbdqh.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbdqh);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bdqh)paramString.next();
          ((bdqh)???).jdField_a_of_type_Bdqg.a(paramV, ((bdqh)???).jdField_a_of_type_JavaLangObject);
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
 * Qualified Name:     bdqf
 * JD-Core Version:    0.7.0.1
 */