import android.content.Intent;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bgjd
{
  private static final bgjd jdField_a_of_type_Bgjd = new bgjd();
  private ArrayList<bgje> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<bgjf> b;
  
  public static bgjd a()
  {
    return jdField_a_of_type_Bgjd;
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
          bgje localbgje = (bgje)localIterator.next();
          if (localbgje.doOnActivityResult(paramInt1, paramInt2, paramIntent))
          {
            QMLog.d("ActivityResultManager", "triggerListener " + localbgje);
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
          bgjf localbgjf = (bgjf)localIterator.next();
          if (localbgjf.doOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt))
          {
            QMLog.d("ActivityResultManager", "triggerListener " + localbgjf);
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
  
  public void a(bgje parambgje)
  {
    QMLog.d("ActivityResultManager", "addActivityResultListener " + parambgje);
    if (parambgje == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(parambgje);
      return;
    }
    catch (Throwable parambgje)
    {
      QMLog.e("ActivityResultManager", parambgje.getMessage(), parambgje);
    }
  }
  
  public void a(bgjf parambgjf)
  {
    QMLog.d("ActivityResultManager", "addRequestPermissionResultListener " + parambgjf);
    if (parambgjf == null) {
      return;
    }
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(parambgjf);
      return;
    }
    catch (Throwable parambgjf)
    {
      QMLog.e("ActivityResultManager", parambgjf.getMessage(), parambgjf);
    }
  }
  
  public void b(bgje parambgje)
  {
    QMLog.d("ActivityResultManager", "removeActivityResultListener " + parambgje);
    if (parambgje != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(parambgje);
        return;
      }
      catch (Throwable parambgje)
      {
        QMLog.e("ActivityResultManager", parambgje.getMessage(), parambgje);
      }
    }
  }
  
  public void b(bgjf parambgjf)
  {
    QMLog.d("ActivityResultManager", "removeRequestPermissionResultListener " + parambgjf);
    if (parambgjf != null) {
      try
      {
        if (this.b == null) {
          return;
        }
        this.b.remove(parambgjf);
        return;
      }
      catch (Throwable parambgjf)
      {
        QMLog.e("ActivityResultManager", parambgjf.getMessage(), parambgjf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjd
 * JD-Core Version:    0.7.0.1
 */