import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginManager.1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class biqb
  implements Manager
{
  public biqc a;
  private HashSet<String> a;
  public byte[] a;
  
  public biqb(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HcePluginManager.1(this);
  }
  
  public static biqb a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (biqb)((QQAppInterface)localAppRuntime).getManager(291);
    }
    return null;
  }
  
  public static String a()
  {
    String str2 = "";
    String str1 = str2;
    if (BaseApplicationImpl.getApplication().getRuntime() != null)
    {
      str1 = str2;
      if (BaseApplicationImpl.getApplication().getRuntime().getAccount() != null) {
        str1 = MD5.toMD5(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      }
    }
    return str1;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HcePluginManager", 2, "matchAID fail  commandApdu is null");
      }
      return -1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      byte[] arrayOfByte = bipy.a(str);
      if (QLog.isColorLevel()) {
        QLog.i("HcePluginManager", 2, "aidApdu: " + bipy.a(arrayOfByte) + " commandApdu" + bipy.a(paramArrayOfByte));
      }
      if (Arrays.equals(arrayOfByte, paramArrayOfByte))
      {
        if (QLog.isColorLevel()) {
          QLog.i("HcePluginManager", 2, "matchAID succ, aid=" + str);
        }
        return 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginManager", 2, "matchAID fail  no match aid");
    }
    return -1;
  }
  
  public long a()
  {
    String str = bdea.a(BaseApplicationImpl.getApplication(), "vfcStartTime");
    if (bdnn.a(str)) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public void a()
  {
    bdea.a(BaseApplicationImpl.getApplication(), "vfcStartTime", System.currentTimeMillis() + "");
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      bdea.a(paramContext, "vfcState", paramInt + "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("HcePluginManager", 2, "onVfcPluginLifecycle state " + paramInt + " Context " + paramContext);
    }
  }
  
  public boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    return (localAppRuntime != null) && (localAppRuntime.isLogin());
  }
  
  public boolean a(Context paramContext)
  {
    return (paramContext != null) && ("1".equals(bdea.a(paramContext, "vfcState")));
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 0) && (paramArrayOfByte[1] == -92);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Biqc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biqb
 * JD-Core Version:    0.7.0.1
 */