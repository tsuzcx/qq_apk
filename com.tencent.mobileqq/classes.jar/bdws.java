import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bdws
{
  private static bdwi jdField_a_of_type_Bdwi = new bdwj();
  private static final HashMap<Long, bdwi> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bdwi a(long paramLong)
  {
    bdwi localbdwi2 = (bdwi)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bdwi localbdwi1 = localbdwi2;
    if (localbdwi2 == null) {
      localbdwi1 = jdField_a_of_type_Bdwi;
    }
    return localbdwi1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bdwi)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bdwi parambdwi)
  {
    try
    {
      jdField_a_of_type_Bdwi = parambdwi;
      return;
    }
    finally
    {
      parambdwi = finally;
      throw parambdwi;
    }
  }
  
  public static void b(bdwi parambdwi)
  {
    try
    {
      if (jdField_a_of_type_Bdwi == parambdwi) {
        jdField_a_of_type_Bdwi = new bdwj();
      }
      return;
    }
    finally
    {
      parambdwi = finally;
      throw parambdwi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdws
 * JD-Core Version:    0.7.0.1
 */