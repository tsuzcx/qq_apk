import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aomr
  extends aona
{
  private static final aomr a;
  public List<aonb> a;
  
  static
  {
    jdField_a_of_type_Aomr = new aomr();
  }
  
  private aomr()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new aoms());
    this.jdField_a_of_type_JavaUtilList.add(aomk.a());
  }
  
  public static aomr a()
  {
    return jdField_a_of_type_Aomr;
  }
  
  public aonb a(Class<? extends aonb> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aonb localaonb = (aonb)localIterator.next();
      if (localaonb.getClass() == paramClass) {
        return localaonb;
      }
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aonb)localIterator.next()).a();
    }
  }
  
  public void a(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aonb)localIterator.next()).a(paramActivity);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aonb)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aonb)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomr
 * JD-Core Version:    0.7.0.1
 */