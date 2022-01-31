import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class blyo
  implements bmaj
{
  private static blyo jdField_a_of_type_Blyo = new blyo();
  private static final String jdField_a_of_type_JavaLangString = blyo.class.getSimpleName();
  private HashMap<String, bmag> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, AtomicInteger> b = new HashMap();
  
  public static blyo a()
  {
    return jdField_a_of_type_Blyo;
  }
  
  @NonNull
  public <T extends bmag> T a(@NonNull Class<T> paramClass)
  {
    if (blyn.class.isAssignableFrom(paramClass))
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
        return (bmag)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass.getName());
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
  
  public void a(bmag parambmag)
  {
    if ((parambmag instanceof blyn))
    {
      AtomicInteger localAtomicInteger = (AtomicInteger)this.b.get(parambmag.getClass().getName());
      if ((localAtomicInteger != null) && (localAtomicInteger.decrementAndGet() == 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(parambmag.getClass().getName());
        this.b.remove(parambmag.getClass().getName());
        QLog.d(jdField_a_of_type_JavaLangString, 1, parambmag.getClass().getName() + " has removed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyo
 * JD-Core Version:    0.7.0.1
 */