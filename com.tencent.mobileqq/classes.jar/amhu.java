import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class amhu
  extends bhhe
{
  WeakReference<QQAppInterface> a;
  WeakReference<amht> b;
  
  public amhu(QQAppInterface paramQQAppInterface, amht paramamht)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramamht);
  }
  
  public void onDone(bhhf parambhhf)
  {
    Object localObject = (QQAppInterface)this.a.get();
    amht localamht = (amht)this.b.get();
    if ((localObject == null) || (localamht == null) || (parambhhf == null) || (parambhhf.a() == null) || (parambhhf.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambhhf.f), ", status: ", Integer.valueOf(parambhhf.a()), ",task.currUrl:", parambhhf.c });
    }
    if (parambhhf.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambhhf.c + "_lastModifiedTime", parambhhf.i);
      long l2 = 0L;
      File localFile = (File)parambhhf.jdField_a_of_type_JavaUtilMap.get(parambhhf.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambhhf.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambhhf.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localamht.a(parambhhf.jdField_a_of_type_Int, parambhhf.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhu
 * JD-Core Version:    0.7.0.1
 */