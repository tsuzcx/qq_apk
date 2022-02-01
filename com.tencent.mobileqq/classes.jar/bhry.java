import android.content.Context;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bhry
{
  private static bhro jdField_a_of_type_Bhro = new bhrp();
  private static final HashMap<Long, bhro> jdField_a_of_type_JavaUtilHashMap = new UpdateCallbackSelector.1();
  
  public static bhro a(long paramLong)
  {
    bhro localbhro2 = (bhro)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    bhro localbhro1 = localbhro2;
    if (localbhro2 == null) {
      localbhro1 = jdField_a_of_type_Bhro;
    }
    return localbhro1;
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bhro)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void a(bhro parambhro)
  {
    try
    {
      jdField_a_of_type_Bhro = parambhro;
      return;
    }
    finally
    {
      parambhro = finally;
      throw parambhro;
    }
  }
  
  public static void b(bhro parambhro)
  {
    try
    {
      if (jdField_a_of_type_Bhro == parambhro) {
        jdField_a_of_type_Bhro = new bhrp();
      }
      return;
    }
    finally
    {
      parambhro = finally;
      throw parambhro;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhry
 * JD-Core Version:    0.7.0.1
 */