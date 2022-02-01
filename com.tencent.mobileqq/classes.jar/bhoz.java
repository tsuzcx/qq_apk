import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bhoz<V>
  implements Manager
{
  private final ArrayList<bhpb<V>> a = new ArrayList();
  
  static
  {
    bhvq.a.a();
  }
  
  public static <E> bhpa<E> a(bhpa<E> parambhpa)
  {
    return new bhpc(parambhpa);
  }
  
  public void a(String arg1, bhpa<V> parambhpa, Object paramObject)
  {
    if (parambhpa != null)
    {
      parambhpa = new bhpb(parambhpa, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambhpa);
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
          bhpb localbhpb = (bhpb)this.a.get(i);
          if (paramString.equals(localbhpb.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbhpb);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bhpb)paramString.next();
          ((bhpb)???).jdField_a_of_type_Bhpa.a(paramV, ((bhpb)???).jdField_a_of_type_JavaLangObject);
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
 * Qualified Name:     bhoz
 * JD-Core Version:    0.7.0.1
 */