import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class apnw
{
  private static apnw jdField_a_of_type_Apnw;
  ArrayList<WeakReference<apnv>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static apnw a()
  {
    if (jdField_a_of_type_Apnw == null) {}
    try
    {
      if (jdField_a_of_type_Apnw == null) {
        jdField_a_of_type_Apnw = new apnw();
      }
      return jdField_a_of_type_Apnw;
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
        apnv localapnv = (apnv)((WeakReference)localIterator.next()).get();
        if (localapnv != null) {
          localapnv.a(paramInt);
        }
      }
    }
  }
  
  public void a(apnv paramapnv)
  {
    if (paramapnv == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramapnv) {
          return;
        }
      }
    }
    paramapnv = new WeakReference(paramapnv);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramapnv);
  }
  
  public void b(apnv paramapnv)
  {
    if (paramapnv == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramapnv) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnw
 * JD-Core Version:    0.7.0.1
 */