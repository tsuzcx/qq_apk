import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class amto
  extends biht
{
  WeakReference<QQAppInterface> a;
  WeakReference<amtn> b;
  
  public amto(QQAppInterface paramQQAppInterface, amtn paramamtn)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramamtn);
  }
  
  public void onDone(bihu parambihu)
  {
    Object localObject = (QQAppInterface)this.a.get();
    amtn localamtn = (amtn)this.b.get();
    if ((localObject == null) || (localamtn == null) || (parambihu == null) || (parambihu.a() == null) || (parambihu.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambihu.f), ", status: ", Integer.valueOf(parambihu.a()), ",task.currUrl:", parambihu.c });
    }
    if (parambihu.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambihu.c + "_lastModifiedTime", parambihu.i);
      long l2 = 0L;
      File localFile = (File)parambihu.jdField_a_of_type_JavaUtilMap.get(parambihu.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambihu.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambihu.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localamtn.a(parambihu.jdField_a_of_type_Int, parambihu.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amto
 * JD-Core Version:    0.7.0.1
 */