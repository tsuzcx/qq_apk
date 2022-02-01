import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class arvg
{
  private static arvg jdField_a_of_type_Arvg;
  ArrayList<WeakReference<arvf>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static arvg a()
  {
    if (jdField_a_of_type_Arvg == null) {}
    try
    {
      if (jdField_a_of_type_Arvg == null) {
        jdField_a_of_type_Arvg = new arvg();
      }
      return jdField_a_of_type_Arvg;
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
        arvf localarvf = (arvf)((WeakReference)localIterator.next()).get();
        if (localarvf != null) {
          localarvf.a(paramInt);
        }
      }
    }
  }
  
  public void a(arvf paramarvf)
  {
    if (paramarvf == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramarvf) {
          return;
        }
      }
    }
    paramarvf = new WeakReference(paramarvf);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramarvf);
  }
  
  public void b(arvf paramarvf)
  {
    if (paramarvf == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramarvf) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvg
 * JD-Core Version:    0.7.0.1
 */