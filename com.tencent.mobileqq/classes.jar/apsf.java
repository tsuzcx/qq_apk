import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class apsf
{
  private static apsf jdField_a_of_type_Apsf;
  ArrayList<WeakReference<apse>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static apsf a()
  {
    if (jdField_a_of_type_Apsf == null) {}
    try
    {
      if (jdField_a_of_type_Apsf == null) {
        jdField_a_of_type_Apsf = new apsf();
      }
      return jdField_a_of_type_Apsf;
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
        apse localapse = (apse)((WeakReference)localIterator.next()).get();
        if (localapse != null) {
          localapse.a(paramInt);
        }
      }
    }
  }
  
  public void a(apse paramapse)
  {
    if (paramapse == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramapse) {
          return;
        }
      }
    }
    paramapse = new WeakReference(paramapse);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramapse);
  }
  
  public void b(apse paramapse)
  {
    if (paramapse == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramapse) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsf
 * JD-Core Version:    0.7.0.1
 */