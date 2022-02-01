import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bhcg
{
  private static bhbw jdField_a_of_type_Bhbw = new bhbx();
  private static final HashMap<Long, bhbw> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bhbw a(long paramLong)
  {
    bhbw localbhbw2 = (bhbw)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bhbw localbhbw1 = localbhbw2;
    if (localbhbw2 == null) {
      localbhbw1 = jdField_a_of_type_Bhbw;
    }
    return localbhbw1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bhbw)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bhbw parambhbw)
  {
    try
    {
      jdField_a_of_type_Bhbw = parambhbw;
      return;
    }
    finally
    {
      parambhbw = finally;
      throw parambhbw;
    }
  }
  
  public static void b(bhbw parambhbw)
  {
    try
    {
      if (jdField_a_of_type_Bhbw == parambhbw) {
        jdField_a_of_type_Bhbw = new bhbx();
      }
      return;
    }
    finally
    {
      parambhbw = finally;
      throw parambhbw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcg
 * JD-Core Version:    0.7.0.1
 */