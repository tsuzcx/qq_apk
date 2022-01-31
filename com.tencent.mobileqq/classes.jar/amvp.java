import android.app.Activity;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amvp
{
  private static volatile amvp jdField_a_of_type_Amvp;
  volatile amvs jdField_a_of_type_Amvs = null;
  List<amvs> jdField_a_of_type_JavaUtilList;
  
  public static amvp a()
  {
    if (jdField_a_of_type_Amvp == null)
    {
      jdField_a_of_type_Amvp = new amvp();
      jdField_a_of_type_Amvp.a();
    }
    return jdField_a_of_type_Amvp;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new amvv());
  }
  
  public static boolean a(String paramString)
  {
    if (bdje.a(paramString)) {}
    while (!("" + Build.MANUFACTURER).equalsIgnoreCase(paramString)) {
      return false;
    }
    return true;
  }
  
  public amvs a()
  {
    if (this.jdField_a_of_type_Amvs != null) {
      return this.jdField_a_of_type_Amvs;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    amvs localamvs;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localamvs = (amvs)localIterator.next();
    } while (!localamvs.a());
    for (;;)
    {
      this.jdField_a_of_type_Amvs = localamvs;
      return localamvs;
      localamvs = null;
    }
  }
  
  public amvt a(Activity paramActivity)
  {
    amvs localamvs = a();
    if (localamvs == null) {}
    while (!localamvs.a(paramActivity)) {
      return null;
    }
    return localamvs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvp
 * JD-Core Version:    0.7.0.1
 */