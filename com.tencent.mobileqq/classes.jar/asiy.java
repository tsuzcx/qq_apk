import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class asiy
{
  private static asiy jdField_a_of_type_Asiy;
  ArrayList<WeakReference<asix>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static asiy a()
  {
    if (jdField_a_of_type_Asiy == null) {}
    try
    {
      if (jdField_a_of_type_Asiy == null) {
        jdField_a_of_type_Asiy = new asiy();
      }
      return jdField_a_of_type_Asiy;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        asix localasix = (asix)((WeakReference)localIterator.next()).get();
        if (localasix != null) {
          localasix.onPayBack(paramInt);
        }
      }
    }
  }
  
  public void a(asix paramasix)
  {
    if (paramasix == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramasix) {
          return;
        }
      }
    }
    paramasix = new WeakReference(paramasix);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramasix);
  }
  
  public void b(asix paramasix)
  {
    if (paramasix == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramasix) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asiy
 * JD-Core Version:    0.7.0.1
 */