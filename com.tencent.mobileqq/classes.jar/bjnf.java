import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class bjnf
  implements bjoz
{
  private static bjnf jdField_a_of_type_Bjnf = new bjnf();
  private static final String jdField_a_of_type_JavaLangString = bjnf.class.getSimpleName();
  private HashMap<String, bjow> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, AtomicInteger> b = new HashMap();
  
  public static bjnf a()
  {
    return jdField_a_of_type_Bjnf;
  }
  
  @NonNull
  public <T extends bjow> T a(@NonNull Class<T> paramClass)
  {
    if (bjne.class.isAssignableFrom(paramClass))
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramClass.getName())) {}
      try
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.getName(), paramClass.newInstance());
        this.b.put(paramClass.getName(), new AtomicInteger(0));
        AtomicInteger localAtomicInteger = (AtomicInteger)this.b.get(paramClass.getName());
        if (localAtomicInteger != null)
        {
          localAtomicInteger.incrementAndGet();
          QLog.d(jdField_a_of_type_JavaLangString, 1, paramClass.getName() + " has created and ref = " + localAtomicInteger.get());
        }
        return (bjow)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass.getName());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          localInstantiationException.printStackTrace();
        }
      }
    }
    throw new RuntimeException("Cannot create non global view model " + paramClass.getName() + " by GlobalViewModelFactory");
  }
  
  public void a(bjow parambjow)
  {
    if ((parambjow instanceof bjne))
    {
      AtomicInteger localAtomicInteger = (AtomicInteger)this.b.get(parambjow.getClass().getName());
      if ((localAtomicInteger != null) && (localAtomicInteger.decrementAndGet() == 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(parambjow.getClass().getName());
        this.b.remove(parambjow.getClass().getName());
        QLog.d(jdField_a_of_type_JavaLangString, 1, parambjow.getClass().getName() + " has removed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnf
 * JD-Core Version:    0.7.0.1
 */