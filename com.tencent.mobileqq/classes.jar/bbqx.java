import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class bbqx<V>
  implements Manager
{
  private final ArrayList<bbqz<V>> a = new ArrayList();
  
  public static <E> bbqy<E> a(bbqy<E> parambbqy)
  {
    return new bbra(parambbqy);
  }
  
  public void a(String arg1, bbqy<V> parambbqy, Object paramObject)
  {
    if (parambbqy != null)
    {
      parambbqy = new bbqz(parambbqy, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(parambbqy);
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
          bbqz localbbqz = (bbqz)this.a.get(i);
          if (paramString.equals(localbbqz.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localbbqz);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (bbqz)paramString.next();
          ((bbqz)???).jdField_a_of_type_Bbqy.a(paramV, ((bbqz)???).jdField_a_of_type_JavaLangObject);
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
 * Qualified Name:     bbqx
 * JD-Core Version:    0.7.0.1
 */