import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anjy
  extends ankh
{
  private static final anjy a;
  public List<anki> a;
  
  static
  {
    jdField_a_of_type_Anjy = new anjy();
  }
  
  private anjy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new anjz());
    this.jdField_a_of_type_JavaUtilList.add(anjr.a());
  }
  
  public static anjy a()
  {
    return jdField_a_of_type_Anjy;
  }
  
  public anki a(Class<? extends anki> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      anki localanki = (anki)localIterator.next();
      if (localanki.getClass() == paramClass) {
        return localanki;
      }
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anki)localIterator.next()).a();
    }
  }
  
  public void a(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anki)localIterator.next()).a(paramActivity);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anki)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anki)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjy
 * JD-Core Version:    0.7.0.1
 */