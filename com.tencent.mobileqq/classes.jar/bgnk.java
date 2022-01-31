import android.content.Intent;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bgnk
{
  private static final bgnk jdField_a_of_type_Bgnk = new bgnk();
  private ArrayList<bgnl> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<bgnm> b;
  
  public static bgnk a()
  {
    return jdField_a_of_type_Bgnk;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.d("ActivityResultManager", "notifyActivityResultListener requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      QMLog.e("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          bgnl localbgnl = (bgnl)localIterator.next();
          if (localbgnl.doOnActivityResult(paramInt1, paramInt2, paramIntent))
          {
            QMLog.d("ActivityResultManager", "triggerListener " + localbgnl);
            return;
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QMLog.e("ActivityResultManager", paramIntent.getMessage(), paramIntent);
      return;
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QMLog.d("ActivityResultManager", "notifyRequestPermissionResultListener requestCode:" + paramInt + " permission:" + paramArrayOfString);
    if ((this.b == null) || (this.b.size() == 0))
    {
      QMLog.e("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          bgnm localbgnm = (bgnm)localIterator.next();
          if (localbgnm.doOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt))
          {
            QMLog.d("ActivityResultManager", "triggerListener " + localbgnm);
            return;
          }
        }
      }
    }
    catch (Throwable paramArrayOfString)
    {
      QMLog.e("ActivityResultManager", paramArrayOfString.getMessage(), paramArrayOfString);
      return;
    }
  }
  
  public void a(bgnl parambgnl)
  {
    QMLog.d("ActivityResultManager", "addActivityResultListener " + parambgnl);
    if (parambgnl == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(parambgnl);
      return;
    }
    catch (Throwable parambgnl)
    {
      QMLog.e("ActivityResultManager", parambgnl.getMessage(), parambgnl);
    }
  }
  
  public void a(bgnm parambgnm)
  {
    QMLog.d("ActivityResultManager", "addRequestPermissionResultListener " + parambgnm);
    if (parambgnm == null) {
      return;
    }
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(parambgnm);
      return;
    }
    catch (Throwable parambgnm)
    {
      QMLog.e("ActivityResultManager", parambgnm.getMessage(), parambgnm);
    }
  }
  
  public void b(bgnl parambgnl)
  {
    QMLog.d("ActivityResultManager", "removeActivityResultListener " + parambgnl);
    if (parambgnl != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(parambgnl);
        return;
      }
      catch (Throwable parambgnl)
      {
        QMLog.e("ActivityResultManager", parambgnl.getMessage(), parambgnl);
      }
    }
  }
  
  public void b(bgnm parambgnm)
  {
    QMLog.d("ActivityResultManager", "removeRequestPermissionResultListener " + parambgnm);
    if (parambgnm != null) {
      try
      {
        if (this.b == null) {
          return;
        }
        this.b.remove(parambgnm);
        return;
      }
      catch (Throwable parambgnm)
      {
        QMLog.e("ActivityResultManager", parambgnm.getMessage(), parambgnm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgnk
 * JD-Core Version:    0.7.0.1
 */