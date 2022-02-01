import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bgjd
{
  private static bgit jdField_a_of_type_Bgit = new bgiu();
  private static final HashMap<Long, bgit> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bgit a(long paramLong)
  {
    bgit localbgit2 = (bgit)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bgit localbgit1 = localbgit2;
    if (localbgit2 == null) {
      localbgit1 = jdField_a_of_type_Bgit;
    }
    return localbgit1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bgit)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bgit parambgit)
  {
    try
    {
      jdField_a_of_type_Bgit = parambgit;
      return;
    }
    finally
    {
      parambgit = finally;
      throw parambgit;
    }
  }
  
  public static void b(bgit parambgit)
  {
    try
    {
      if (jdField_a_of_type_Bgit == parambgit) {
        jdField_a_of_type_Bgit = new bgiu();
      }
      return;
    }
    finally
    {
      parambgit = finally;
      throw parambgit;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjd
 * JD-Core Version:    0.7.0.1
 */