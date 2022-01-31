import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class anwo
{
  private static anwo jdField_a_of_type_Anwo;
  ArrayList<WeakReference<anwn>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static anwo a()
  {
    if (jdField_a_of_type_Anwo == null) {}
    try
    {
      if (jdField_a_of_type_Anwo == null) {
        jdField_a_of_type_Anwo = new anwo();
      }
      return jdField_a_of_type_Anwo;
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
        anwn localanwn = (anwn)((WeakReference)localIterator.next()).get();
        if (localanwn != null) {
          localanwn.a(paramInt);
        }
      }
    }
  }
  
  public void a(anwn paramanwn)
  {
    if (paramanwn == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwn) {
          return;
        }
      }
    }
    paramanwn = new WeakReference(paramanwn);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramanwn);
  }
  
  public void b(anwn paramanwn)
  {
    if (paramanwn == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwn) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwo
 * JD-Core Version:    0.7.0.1
 */