import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class anwj
{
  private static anwj jdField_a_of_type_Anwj;
  ArrayList<WeakReference<anwi>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static anwj a()
  {
    if (jdField_a_of_type_Anwj == null) {}
    try
    {
      if (jdField_a_of_type_Anwj == null) {
        jdField_a_of_type_Anwj = new anwj();
      }
      return jdField_a_of_type_Anwj;
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
        anwi localanwi = (anwi)((WeakReference)localIterator.next()).get();
        if (localanwi != null) {
          localanwi.a(paramInt);
        }
      }
    }
  }
  
  public void a(anwi paramanwi)
  {
    if (paramanwi == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwi) {
          return;
        }
      }
    }
    paramanwi = new WeakReference(paramanwi);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramanwi);
  }
  
  public void b(anwi paramanwi)
  {
    if (paramanwi == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwi) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwj
 * JD-Core Version:    0.7.0.1
 */