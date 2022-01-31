import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class bjmo
  implements bjoi
{
  private static bjmo jdField_a_of_type_Bjmo = new bjmo();
  private static final String jdField_a_of_type_JavaLangString = bjmo.class.getSimpleName();
  private HashMap<String, bjof> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, AtomicInteger> b = new HashMap();
  
  public static bjmo a()
  {
    return jdField_a_of_type_Bjmo;
  }
  
  @NonNull
  public <T extends bjof> T a(@NonNull Class<T> paramClass)
  {
    if (bjmn.class.isAssignableFrom(paramClass))
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
        return (bjof)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass.getName());
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
  
  public void a(bjof parambjof)
  {
    if ((parambjof instanceof bjmn))
    {
      AtomicInteger localAtomicInteger = (AtomicInteger)this.b.get(parambjof.getClass().getName());
      if ((localAtomicInteger != null) && (localAtomicInteger.decrementAndGet() == 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(parambjof.getClass().getName());
        this.b.remove(parambjof.getClass().getName());
        QLog.d(jdField_a_of_type_JavaLangString, 1, parambjof.getClass().getName() + " has removed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjmo
 * JD-Core Version:    0.7.0.1
 */