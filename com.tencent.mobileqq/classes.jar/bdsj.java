import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bdsj
{
  private static bdrz jdField_a_of_type_Bdrz = new bdsa();
  private static final HashMap<Long, bdrz> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bdrz a(long paramLong)
  {
    bdrz localbdrz2 = (bdrz)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bdrz localbdrz1 = localbdrz2;
    if (localbdrz2 == null) {
      localbdrz1 = jdField_a_of_type_Bdrz;
    }
    return localbdrz1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bdrz)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bdrz parambdrz)
  {
    try
    {
      jdField_a_of_type_Bdrz = parambdrz;
      return;
    }
    finally
    {
      parambdrz = finally;
      throw parambdrz;
    }
  }
  
  public static void b(bdrz parambdrz)
  {
    try
    {
      if (jdField_a_of_type_Bdrz == parambdrz) {
        jdField_a_of_type_Bdrz = new bdsa();
      }
      return;
    }
    finally
    {
      parambdrz = finally;
      throw parambdrz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsj
 * JD-Core Version:    0.7.0.1
 */