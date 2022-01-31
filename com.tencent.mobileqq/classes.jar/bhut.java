import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class bhut
  implements bhwn
{
  private static bhut jdField_a_of_type_Bhut = new bhut();
  private static final String jdField_a_of_type_JavaLangString = bhut.class.getSimpleName();
  private HashMap<String, bhwk> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, AtomicInteger> b = new HashMap();
  
  public static bhut a()
  {
    return jdField_a_of_type_Bhut;
  }
  
  @NonNull
  public <T extends bhwk> T a(@NonNull Class<T> paramClass)
  {
    if (bhus.class.isAssignableFrom(paramClass))
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
        return (bhwk)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass.getName());
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
  
  public void a(bhwk parambhwk)
  {
    if ((parambhwk instanceof bhus))
    {
      AtomicInteger localAtomicInteger = (AtomicInteger)this.b.get(parambhwk.getClass().getName());
      if ((localAtomicInteger != null) && (localAtomicInteger.decrementAndGet() == 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(parambhwk.getClass().getName());
        this.b.remove(parambhwk.getClass().getName());
        QLog.d(jdField_a_of_type_JavaLangString, 1, parambhwk.getClass().getName() + " has removed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhut
 * JD-Core Version:    0.7.0.1
 */