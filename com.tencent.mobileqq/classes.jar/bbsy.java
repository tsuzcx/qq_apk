import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bbsy
{
  private static bbso jdField_a_of_type_Bbso = new bbsp();
  private static final HashMap<Long, bbso> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bbso a(long paramLong)
  {
    bbso localbbso2 = (bbso)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bbso localbbso1 = localbbso2;
    if (localbbso2 == null) {
      localbbso1 = jdField_a_of_type_Bbso;
    }
    return localbbso1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bbso)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bbso parambbso)
  {
    try
    {
      jdField_a_of_type_Bbso = parambbso;
      return;
    }
    finally
    {
      parambbso = finally;
      throw parambbso;
    }
  }
  
  public static void b(bbso parambbso)
  {
    try
    {
      if (jdField_a_of_type_Bbso == parambbso) {
        jdField_a_of_type_Bbso = new bbsp();
      }
      return;
    }
    finally
    {
      parambbso = finally;
      throw parambbso;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsy
 * JD-Core Version:    0.7.0.1
 */