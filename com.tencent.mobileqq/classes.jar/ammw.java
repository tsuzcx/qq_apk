import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class ammw
  extends bhyn
{
  WeakReference<QQAppInterface> a;
  WeakReference<ammv> b;
  
  public ammw(QQAppInterface paramQQAppInterface, ammv paramammv)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramammv);
  }
  
  public void onDone(bhyo parambhyo)
  {
    Object localObject = (QQAppInterface)this.a.get();
    ammv localammv = (ammv)this.b.get();
    if ((localObject == null) || (localammv == null) || (parambhyo == null) || (parambhyo.a() == null) || (parambhyo.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambhyo.f), ", status: ", Integer.valueOf(parambhyo.a()), ",task.currUrl:", parambhyo.c });
    }
    if (parambhyo.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambhyo.c + "_lastModifiedTime", parambhyo.i);
      long l2 = 0L;
      File localFile = (File)parambhyo.jdField_a_of_type_JavaUtilMap.get(parambhyo.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambhyo.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambhyo.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localammv.a(parambhyo.jdField_a_of_type_Int, parambhyo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammw
 * JD-Core Version:    0.7.0.1
 */