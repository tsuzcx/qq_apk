import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class asku
{
  private static asku jdField_a_of_type_Asku;
  ArrayList<WeakReference<askt>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static asku a()
  {
    if (jdField_a_of_type_Asku == null) {}
    try
    {
      if (jdField_a_of_type_Asku == null) {
        jdField_a_of_type_Asku = new asku();
      }
      return jdField_a_of_type_Asku;
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
        askt localaskt = (askt)((WeakReference)localIterator.next()).get();
        if (localaskt != null) {
          localaskt.a(paramInt);
        }
      }
    }
  }
  
  public void a(askt paramaskt)
  {
    if (paramaskt == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramaskt) {
          return;
        }
      }
    }
    paramaskt = new WeakReference(paramaskt);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaskt);
  }
  
  public void b(askt paramaskt)
  {
    if (paramaskt == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramaskt) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asku
 * JD-Core Version:    0.7.0.1
 */