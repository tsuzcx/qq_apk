import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public class beil
{
  private static final beil jdField_a_of_type_Beil = new beil();
  private ArrayList<beim> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<bein> b;
  
  public static beil a()
  {
    return jdField_a_of_type_Beil;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    besl.a("ActivityResultManager", "notifyActivityResultListener requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      besl.d("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          beim localbeim = (beim)localIterator.next();
          if (localbeim.doOnActivityResult(paramInt1, paramInt2, paramIntent))
          {
            besl.a("ActivityResultManager", "triggerListener " + localbeim);
            return;
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      besl.d("ActivityResultManager", paramIntent.getMessage(), paramIntent);
      return;
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    besl.a("ActivityResultManager", "notifyRequestPermissionResultListener requestCode:" + paramInt + " permission:" + paramArrayOfString);
    if ((this.b == null) || (this.b.size() == 0))
    {
      besl.d("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          bein localbein = (bein)localIterator.next();
          if (localbein.doOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt))
          {
            besl.a("ActivityResultManager", "triggerListener " + localbein);
            return;
          }
        }
      }
    }
    catch (Throwable paramArrayOfString)
    {
      besl.d("ActivityResultManager", paramArrayOfString.getMessage(), paramArrayOfString);
      return;
    }
  }
  
  public void a(beim parambeim)
  {
    besl.a("ActivityResultManager", "addActivityResultListener " + parambeim);
    if (parambeim == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(parambeim);
      return;
    }
    catch (Throwable parambeim)
    {
      besl.d("ActivityResultManager", parambeim.getMessage(), parambeim);
    }
  }
  
  public void a(bein parambein)
  {
    besl.a("ActivityResultManager", "addRequestPermissionResultListener " + parambein);
    if (parambein == null) {
      return;
    }
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(parambein);
      return;
    }
    catch (Throwable parambein)
    {
      besl.d("ActivityResultManager", parambein.getMessage(), parambein);
    }
  }
  
  public void b(beim parambeim)
  {
    besl.a("ActivityResultManager", "removeActivityResultListener " + parambeim);
    if (parambeim != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(parambeim);
        return;
      }
      catch (Throwable parambeim)
      {
        besl.d("ActivityResultManager", parambeim.getMessage(), parambeim);
      }
    }
  }
  
  public void b(bein parambein)
  {
    besl.a("ActivityResultManager", "removeRequestPermissionResultListener " + parambein);
    if (parambein != null) {
      try
      {
        if (this.b == null) {
          return;
        }
        this.b.remove(parambein);
        return;
      }
      catch (Throwable parambein)
      {
        besl.d("ActivityResultManager", parambein.getMessage(), parambein);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beil
 * JD-Core Version:    0.7.0.1
 */