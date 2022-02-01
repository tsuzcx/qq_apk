import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ares
{
  private static ares jdField_a_of_type_Ares;
  ArrayList<WeakReference<arer>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static ares a()
  {
    if (jdField_a_of_type_Ares == null) {}
    try
    {
      if (jdField_a_of_type_Ares == null) {
        jdField_a_of_type_Ares = new ares();
      }
      return jdField_a_of_type_Ares;
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
        arer localarer = (arer)((WeakReference)localIterator.next()).get();
        if (localarer != null) {
          localarer.onPayBack(paramInt);
        }
      }
    }
  }
  
  public void a(arer paramarer)
  {
    if (paramarer == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramarer) {
          return;
        }
      }
    }
    paramarer = new WeakReference(paramarer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramarer);
  }
  
  public void b(arer paramarer)
  {
    if (paramarer == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramarer) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ares
 * JD-Core Version:    0.7.0.1
 */