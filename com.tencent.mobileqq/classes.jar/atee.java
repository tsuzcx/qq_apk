import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.2;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.4;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.6;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class atee
{
  static int jdField_a_of_type_Int = 1;
  private atep jdField_a_of_type_Atep = new atef(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Map<String, atei> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private boolean jdField_a_of_type_Boolean = true;
  private Map<String, atem> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  
  public atee(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private atei a(String paramString1, String paramString2, Signature[] paramArrayOfSignature, long paramLong, atel paramatel, atep paramatep)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. filePath is null");
      return null;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. pkgName is null");
      return null;
    }
    if (paramLong == 0L)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. fileSize is 0");
      return null;
    }
    if (paramatel == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. fileBusiInfo is null");
      return null;
    }
    if (paramatep == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. safeCheckerProxy is null");
      return null;
    }
    return new atei(this, paramString1, paramString2, paramArrayOfSignature, paramLong, paramatel, paramatep);
  }
  
  private atem a(String paramString)
  {
    try
    {
      paramString = (atem)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] remTask size:" + this.jdField_a_of_type_JavaUtilMap.size() + " filePath:" + paramString);
  }
  
  private void a(String paramString, atei paramatei)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramatei);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] addTask size:" + this.jdField_a_of_type_JavaUtilMap.size() + " filePath:" + paramString);
  }
  
  private void a(String paramString, atem paramatem)
  {
    label149:
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilMap.size() > 50)
        {
          long l = 9223372036854775807L;
          String str = "";
          Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((atem)localEntry.getValue()).jdField_b_of_type_Long >= l) {
              break label149;
            }
            l = ((atem)localEntry.getValue()).jdField_b_of_type_Long;
            str = (String)localEntry.getKey();
            break label149;
          }
          if (!TextUtils.isEmpty(str)) {
            this.jdField_b_of_type_JavaUtilMap.remove(str);
          }
        }
        this.jdField_b_of_type_JavaUtilMap.put(paramString, paramatem);
        return;
      }
      finally {}
    }
  }
  
  private void a(String paramString, aten paramaten)
  {
    paramString = (atei)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.a(paramaten);
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  private boolean a(String paramString, atel paramatel, aten paramaten)
  {
    if (5 != atvo.a(paramString)) {
      return false;
    }
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. filePath=" + paramString + " binfo:" + paramatel.toString());
    if (a(paramString))
    {
      QLog.w("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. is checking");
      a(paramString, paramaten);
      return true;
    }
    if (!atwl.a(paramString))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. file not exists");
      return false;
    }
    long l = atvo.a(paramString);
    String str = "";
    Signature[] arrayOfSignature = null;
    try
    {
      PackageInfo localPackageInfo = BaseApplicationImpl.getContext().getBaseContext().getPackageManager().getPackageArchiveInfo(paramString, 64);
      if (localPackageInfo != null) {
        arrayOfSignature = localPackageInfo.signatures;
      }
      if (localPackageInfo != null) {
        str = localPackageInfo.packageName;
      }
      paramatel = a(paramString, str, arrayOfSignature, l, paramatel, this.jdField_a_of_type_Atep);
      if (paramatel == null) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. exception:" + paramString.toString());
      return false;
    }
    paramatel.a(paramaten);
    a(paramString, paramatel);
    paramatel.a();
    return true;
  }
  
  private boolean a(String paramString, ateo paramateo)
  {
    atem localatem = a(paramString);
    if ((localatem != null) && (localatem.jdField_a_of_type_ArrayOfByte != null) && (localatem.jdField_b_of_type_ArrayOfByte != null))
    {
      if (atwl.a(paramString) == localatem.jdField_a_of_type_Long)
      {
        paramateo.a(true, localatem);
        return true;
      }
      b(paramString);
    }
    c();
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new MMApkFileSafeChecker.6(this, paramString, paramateo));
    return true;
  }
  
  private void b(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    atel localatel = new atel(this, null);
    localatel.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localatel.jdField_a_of_type_Int = 2;
    localatel.c = String.valueOf(paramLong);
    localatel.e = paramItem.FilePath;
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk. Item.Id=" + paramItem.getId() + " binfo:" + localatel.toString());
    a(paramItem.LocalFile, localatel, new ateh(this, paramItem, paramLong));
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    atel localatel = new atel(this, null);
    localatel.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localatel.jdField_a_of_type_Int = 1;
    if ((paramFileManagerEntity.peerType == 0) || (paramFileManagerEntity.peerType == 3) || (paramFileManagerEntity.peerType == 1000))
    {
      localatel.b = paramFileManagerEntity.peerUin;
      localatel.d = paramFileManagerEntity.Uuid;
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] interCheckLocalApk. nSessionId=" + paramFileManagerEntity.nSessionId + " binfo:" + localatel.toString());
      a(paramFileManagerEntity.strFilePath, localatel, new ateg(this, paramFileManagerEntity));
      return;
    }
    QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] interCheckLocalApk err. is no buddy apk");
  }
  
  private void b(String paramString)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] start DigestGet pool");
    }
    try
    {
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.priority = 5;
      localThreadPoolParams.poolThreadName = "FileDigestGetPool";
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] start DigestGet pool exception:" + localException.toString());
    }
  }
  
  private boolean c()
  {
    atam localatam = (atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localatam != null) {
      return localatam.i();
    }
    return false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor != null) {
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] close DigestGet pool");
    }
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentExecutor instanceof ExecutorService)) {
        ((ExecutorService)this.jdField_a_of_type_JavaUtilConcurrentExecutor).shutdown();
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] close DigestGet pool exception:" + localException.toString());
      }
    }
  }
  
  private void e()
  {
    try
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] init.");
    try
    {
      bgjv.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] initTuringSdk exception." + localThrowable.toString());
    }
  }
  
  public void a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (!c()) {
      return;
    }
    if (paramItem == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk err. troopFileItem=null");
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new MMApkFileSafeChecker.4(this, paramLong, paramItem));
      return;
    }
    b(paramLong, paramItem);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!c()) {
      return;
    }
    if (paramFileManagerEntity == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk err. entity=null");
      return;
    }
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk. entity.nSessionId=" + paramFileManagerEntity.nSessionId);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new MMApkFileSafeChecker.2(this, paramFileManagerEntity));
      return;
    }
    b(paramFileManagerEntity);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    QLog.w("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] release.");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((atei)localIterator.next()).c();
    }
    d();
    this.jdField_a_of_type_JavaUtilMap.clear();
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atee
 * JD-Core Version:    0.7.0.1
 */