import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class baqy
{
  private static baqp jdField_a_of_type_Baqp = new baqq();
  private static final HashMap<Long, baqp> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static baqp a(long paramLong)
  {
    baqp localbaqp2 = (baqp)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    baqp localbaqp1 = localbaqp2;
    if (localbaqp2 == null) {
      localbaqp1 = jdField_a_of_type_Baqp;
    }
    return localbaqp1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((baqp)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(baqp parambaqp)
  {
    try
    {
      jdField_a_of_type_Baqp = parambaqp;
      return;
    }
    finally
    {
      parambaqp = finally;
      throw parambaqp;
    }
  }
  
  public static void b(baqp parambaqp)
  {
    try
    {
      if (jdField_a_of_type_Baqp == parambaqp) {
        jdField_a_of_type_Baqp = new baqq();
      }
      return;
    }
    finally
    {
      parambaqp = finally;
      throw parambaqp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     baqy
 * JD-Core Version:    0.7.0.1
 */