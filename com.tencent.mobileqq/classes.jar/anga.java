import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class anga
{
  private static anga jdField_a_of_type_Anga;
  ArrayList<WeakReference<anfz>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static anga a()
  {
    if (jdField_a_of_type_Anga == null) {}
    try
    {
      if (jdField_a_of_type_Anga == null) {
        jdField_a_of_type_Anga = new anga();
      }
      return jdField_a_of_type_Anga;
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
        anfz localanfz = (anfz)((WeakReference)localIterator.next()).get();
        if (localanfz != null) {
          localanfz.a(paramInt);
        }
      }
    }
  }
  
  public void a(anfz paramanfz)
  {
    if (paramanfz == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanfz) {
          return;
        }
      }
    }
    paramanfz = new WeakReference(paramanfz);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramanfz);
  }
  
  public void b(anfz paramanfz)
  {
    if (paramanfz == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanfz) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anga
 * JD-Core Version:    0.7.0.1
 */