import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public class bejc
{
  private static final bejc jdField_a_of_type_Bejc = new bejc();
  private ArrayList<bejd> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<beje> b;
  
  public static bejc a()
  {
    return jdField_a_of_type_Bejc;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    betc.a("ActivityResultManager", "notifyActivityResultListener requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      betc.d("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          bejd localbejd = (bejd)localIterator.next();
          if (localbejd.doOnActivityResult(paramInt1, paramInt2, paramIntent))
          {
            betc.a("ActivityResultManager", "triggerListener " + localbejd);
            return;
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      betc.d("ActivityResultManager", paramIntent.getMessage(), paramIntent);
      return;
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    betc.a("ActivityResultManager", "notifyRequestPermissionResultListener requestCode:" + paramInt + " permission:" + paramArrayOfString);
    if ((this.b == null) || (this.b.size() == 0))
    {
      betc.d("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          beje localbeje = (beje)localIterator.next();
          if (localbeje.doOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt))
          {
            betc.a("ActivityResultManager", "triggerListener " + localbeje);
            return;
          }
        }
      }
    }
    catch (Throwable paramArrayOfString)
    {
      betc.d("ActivityResultManager", paramArrayOfString.getMessage(), paramArrayOfString);
      return;
    }
  }
  
  public void a(bejd parambejd)
  {
    betc.a("ActivityResultManager", "addActivityResultListener " + parambejd);
    if (parambejd == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(parambejd);
      return;
    }
    catch (Throwable parambejd)
    {
      betc.d("ActivityResultManager", parambejd.getMessage(), parambejd);
    }
  }
  
  public void a(beje parambeje)
  {
    betc.a("ActivityResultManager", "addRequestPermissionResultListener " + parambeje);
    if (parambeje == null) {
      return;
    }
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(parambeje);
      return;
    }
    catch (Throwable parambeje)
    {
      betc.d("ActivityResultManager", parambeje.getMessage(), parambeje);
    }
  }
  
  public void b(bejd parambejd)
  {
    betc.a("ActivityResultManager", "removeActivityResultListener " + parambejd);
    if (parambejd != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(parambejd);
        return;
      }
      catch (Throwable parambejd)
      {
        betc.d("ActivityResultManager", parambejd.getMessage(), parambejd);
      }
    }
  }
  
  public void b(beje parambeje)
  {
    betc.a("ActivityResultManager", "removeRequestPermissionResultListener " + parambeje);
    if (parambeje != null) {
      try
      {
        if (this.b == null) {
          return;
        }
        this.b.remove(parambeje);
        return;
      }
      catch (Throwable parambeje)
      {
        betc.d("ActivityResultManager", parambeje.getMessage(), parambeje);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejc
 * JD-Core Version:    0.7.0.1
 */