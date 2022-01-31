import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bbtm
{
  private static bbtc jdField_a_of_type_Bbtc = new bbtd();
  private static final HashMap<Long, bbtc> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bbtc a(long paramLong)
  {
    bbtc localbbtc2 = (bbtc)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bbtc localbbtc1 = localbbtc2;
    if (localbbtc2 == null) {
      localbbtc1 = jdField_a_of_type_Bbtc;
    }
    return localbbtc1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bbtc parambbtc)
  {
    try
    {
      jdField_a_of_type_Bbtc = parambbtc;
      return;
    }
    finally
    {
      parambbtc = finally;
      throw parambbtc;
    }
  }
  
  public static void b(bbtc parambbtc)
  {
    try
    {
      if (jdField_a_of_type_Bbtc == parambbtc) {
        jdField_a_of_type_Bbtc = new bbtd();
      }
      return;
    }
    finally
    {
      parambbtc = finally;
      throw parambbtc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbtm
 * JD-Core Version:    0.7.0.1
 */