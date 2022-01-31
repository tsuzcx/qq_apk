import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public class bdel
{
  private static final bdel jdField_a_of_type_Bdel = new bdel();
  private ArrayList<bdem> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<bden> b;
  
  public static bdel a()
  {
    return jdField_a_of_type_Bdel;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    bdnw.a("ActivityResultManager", "notifyActivityResultListener requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      bdnw.d("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          bdem localbdem = (bdem)localIterator.next();
          if (localbdem.doOnActivityResult(paramInt1, paramInt2, paramIntent))
          {
            bdnw.a("ActivityResultManager", "triggerListener " + localbdem);
            return;
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      bdnw.d("ActivityResultManager", paramIntent.getMessage(), paramIntent);
      return;
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdnw.a("ActivityResultManager", "notifyRequestPermissionResultListener requestCode:" + paramInt + " permission:" + paramArrayOfString);
    if ((this.b == null) || (this.b.size() == 0))
    {
      bdnw.d("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          bden localbden = (bden)localIterator.next();
          if (localbden.doOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt))
          {
            bdnw.a("ActivityResultManager", "triggerListener " + localbden);
            return;
          }
        }
      }
    }
    catch (Throwable paramArrayOfString)
    {
      bdnw.d("ActivityResultManager", paramArrayOfString.getMessage(), paramArrayOfString);
      return;
    }
  }
  
  public void a(bdem parambdem)
  {
    bdnw.a("ActivityResultManager", "addActivityResultListener " + parambdem);
    if (parambdem == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(parambdem);
      return;
    }
    catch (Throwable parambdem)
    {
      bdnw.d("ActivityResultManager", parambdem.getMessage(), parambdem);
    }
  }
  
  public void a(bden parambden)
  {
    bdnw.a("ActivityResultManager", "addRequestPermissionResultListener " + parambden);
    if (parambden == null) {
      return;
    }
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(parambden);
      return;
    }
    catch (Throwable parambden)
    {
      bdnw.d("ActivityResultManager", parambden.getMessage(), parambden);
    }
  }
  
  public void b(bdem parambdem)
  {
    bdnw.a("ActivityResultManager", "removeActivityResultListener " + parambdem);
    if (parambdem != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(parambdem);
        return;
      }
      catch (Throwable parambdem)
      {
        bdnw.d("ActivityResultManager", parambdem.getMessage(), parambdem);
      }
    }
  }
  
  public void b(bden parambden)
  {
    bdnw.a("ActivityResultManager", "removeRequestPermissionResultListener " + parambden);
    if (parambden != null) {
      try
      {
        if (this.b == null) {
          return;
        }
        this.b.remove(parambden);
        return;
      }
      catch (Throwable parambden)
      {
        bdnw.d("ActivityResultManager", parambden.getMessage(), parambden);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdel
 * JD-Core Version:    0.7.0.1
 */