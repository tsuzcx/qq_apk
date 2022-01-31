import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bapa<V>
  implements Manager
{
  private final ArrayList<bapc<V>> a = new ArrayList();
  
  public static <E> bapb<E> a(bapb<E> parambapb)
  {
    return new bapd(parambapb);
  }
  
  public void a(String arg1, bapb<V> parambapb, Object paramObject)
  {
    if (parambapb != null)
    {
      parambapb = new bapc(parambapb, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambapb);
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
          bapc localbapc = (bapc)this.a.get(i);
          if (paramString.equals(localbapc.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbapc);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bapc)paramString.next();
          ((bapc)???).jdField_a_of_type_Bapb.a(paramV, ((bapc)???).jdField_a_of_type_JavaLangObject);
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
 * Qualified Name:     bapa
 * JD-Core Version:    0.7.0.1
 */