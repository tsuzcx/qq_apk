import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bics
{
  private static bici jdField_a_of_type_Bici = new bicj();
  private static final HashMap<Long, bici> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bici a(long paramLong)
  {
    bici localbici2 = (bici)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bici localbici1 = localbici2;
    if (localbici2 == null) {
      localbici1 = jdField_a_of_type_Bici;
    }
    return localbici1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bici)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bici parambici)
  {
    try
    {
      jdField_a_of_type_Bici = parambici;
      return;
    }
    finally
    {
      parambici = finally;
      throw parambici;
    }
  }
  
  public static void b(bici parambici)
  {
    try
    {
      if (jdField_a_of_type_Bici == parambici) {
        jdField_a_of_type_Bici = new bicj();
      }
      return;
    }
    finally
    {
      parambici = finally;
      throw parambici;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bics
 * JD-Core Version:    0.7.0.1
 */