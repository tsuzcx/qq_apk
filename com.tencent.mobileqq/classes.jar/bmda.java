import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class bmda
  implements bmev
{
  private static bmda jdField_a_of_type_Bmda = new bmda();
  private static final String jdField_a_of_type_JavaLangString = bmda.class.getSimpleName();
  private HashMap<String, bmes> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, AtomicInteger> b = new HashMap();
  
  public static bmda a()
  {
    return jdField_a_of_type_Bmda;
  }
  
  @NonNull
  public <T extends bmes> T a(@NonNull Class<T> paramClass)
  {
    if (bmcz.class.isAssignableFrom(paramClass))
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
        return (bmes)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass.getName());
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
  
  public void a(bmes parambmes)
  {
    if ((parambmes instanceof bmcz))
    {
      AtomicInteger localAtomicInteger = (AtomicInteger)this.b.get(parambmes.getClass().getName());
      if ((localAtomicInteger != null) && (localAtomicInteger.decrementAndGet() == 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(parambmes.getClass().getName());
        this.b.remove(parambmes.getClass().getName());
        QLog.d(jdField_a_of_type_JavaLangString, 1, parambmes.getClass().getName() + " has removed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmda
 * JD-Core Version:    0.7.0.1
 */