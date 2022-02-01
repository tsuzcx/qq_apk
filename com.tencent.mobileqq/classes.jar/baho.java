import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class baho
{
  private static int jdField_a_of_type_Int = 5;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString = baho.class.getSimpleName();
  private static ArrayList<bahp> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Long = 60000L;
  }
  
  public static blkh a()
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
        localObject3 = new bahn();
        ((blkh)localObject3).a();
        jdField_a_of_type_JavaUtilArrayList.add(new bahp((blkh)localObject3));
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
  
  public static void a(blkh paramblkh)
  {
    for (;;)
    {
      bahp localbahp;
      try
      {
        Object localObject = jdField_a_of_type_JavaUtilArrayList;
        if (localObject == null) {}else {
          localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
        }
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        localbahp = (bahp)((Iterator)localObject).next();
        if (paramblkh != localbahp.jdField_a_of_type_Blkh) {
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
        localbahp.jdField_a_of_type_Boolean = false;
      }
      finally {}
      localbahp.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    }
  }
  
  private static blkh b()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bahp localbahp = (bahp)((Iterator)localObject).next();
      if (!localbahp.jdField_a_of_type_Boolean)
      {
        localObject = localbahp.jdField_a_of_type_Blkh;
        localbahp.jdField_a_of_type_Boolean = true;
        long l = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "query for sscm, get one expired:" + (l - localbahp.jdField_a_of_type_Long));
        }
        if (l - localbahp.jdField_a_of_type_Long > jdField_a_of_type_Long) {
          localbahp.jdField_a_of_type_Blkh.a();
        }
        return localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baho
 * JD-Core Version:    0.7.0.1
 */