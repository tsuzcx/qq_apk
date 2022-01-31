import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class awtm
{
  private static int jdField_a_of_type_Int = 5;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString = awtm.class.getSimpleName();
  private static ArrayList<awtn> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Long = 60000L;
  }
  
  public static bica a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList == null) {
        jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      Object localObject3 = b();
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject3 = new awtl();
        ((bica)localObject3).a();
        jdField_a_of_type_JavaUtilArrayList.add(new awtn((bica)localObject3));
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "can't find sscm object, add new one, size= " + jdField_a_of_type_JavaUtilArrayList.size());
          localObject1 = localObject3;
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(bica parambica)
  {
    for (;;)
    {
      awtn localawtn;
      try
      {
        Object localObject = jdField_a_of_type_JavaUtilArrayList;
        if (localObject == null) {}else {
          localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
        }
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        localawtn = (awtn)((Iterator)localObject).next();
        if (parambica != localawtn.jdField_a_of_type_Bica) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "return sscm, current size=" + jdField_a_of_type_JavaUtilArrayList.size());
        }
        if (jdField_a_of_type_JavaUtilArrayList.size() > jdField_a_of_type_Int)
        {
          ((Iterator)localObject).remove();
          continue;
        }
        localawtn.jdField_a_of_type_Boolean = false;
      }
      finally {}
      localawtn.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    }
  }
  
  private static bica b()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      awtn localawtn = (awtn)((Iterator)localObject).next();
      if (!localawtn.jdField_a_of_type_Boolean)
      {
        localObject = localawtn.jdField_a_of_type_Bica;
        localawtn.jdField_a_of_type_Boolean = true;
        long l = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "query for sscm, get one expired:" + (l - localawtn.jdField_a_of_type_Long));
        }
        if (l - localawtn.jdField_a_of_type_Long > jdField_a_of_type_Long) {
          localawtn.jdField_a_of_type_Bica.a();
        }
        return localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awtm
 * JD-Core Version:    0.7.0.1
 */