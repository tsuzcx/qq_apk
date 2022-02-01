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
import com.tencent.mobileqq.filemanager.util.FileUtil;
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

public class asii
{
  static int jdField_a_of_type_Int = 1;
  private asit jdField_a_of_type_Asit = new asij(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Map<String, asim> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private boolean jdField_a_of_type_Boolean = true;
  private Map<String, asiq> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  
  public asii(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private asim a(String paramString1, String paramString2, Signature[] paramArrayOfSignature, long paramLong, asip paramasip, asit paramasit)
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
    if (paramasip == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. fileBusiInfo is null");
      return null;
    }
    if (paramasit == null)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. safeCheckerProxy is null");
      return null;
    }
    return new asim(this, paramString1, paramString2, paramArrayOfSignature, paramLong, paramasip, paramasit);
  }
  
  private asiq a(String paramString)
  {
    try
    {
      paramString = (asiq)this.jdField_b_of_type_JavaUtilMap.get(paramString);
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
  
  private void a(String paramString, asim paramasim)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramasim);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] addTask size:" + this.jdField_a_of_type_JavaUtilMap.size() + " filePath:" + paramString);
  }
  
  private void a(String paramString, asiq paramasiq)
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
            if (((asiq)localEntry.getValue()).jdField_b_of_type_Long >= l) {
              break label149;
            }
            l = ((asiq)localEntry.getValue()).jdField_b_of_type_Long;
            str = (String)localEntry.getKey();
            break label149;
          }
          if (!TextUtils.isEmpty(str)) {
            this.jdField_b_of_type_JavaUtilMap.remove(str);
          }
        }
        this.jdField_b_of_type_JavaUtilMap.put(paramString, paramasiq);
        return;
      }
      finally {}
    }
  }
  
  private void a(String paramString, asir paramasir)
  {
    paramString = (asim)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.a(paramasir);
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  private boolean a(String paramString, asip paramasip, asir paramasir)
  {
    if (5 != aszt.a(paramString)) {
      return false;
    }
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. filePath=" + paramString + " binfo:" + paramasip.toString());
    if (a(paramString))
    {
      QLog.w("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. is checking");
      a(paramString, paramasir);
      return true;
    }
    if (!FileUtil.isFileExists(paramString))
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. file not exists");
      return false;
    }
    long l = aszt.a(paramString);
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
      paramasip = a(paramString, str, arrayOfSignature, l, paramasip, this.jdField_a_of_type_Asit);
      if (paramasip == null) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. exception:" + paramString.toString());
      return false;
    }
    paramasip.a(paramasir);
    a(paramString, paramasip);
    paramasip.a();
    return true;
  }
  
  private boolean a(String paramString, asis paramasis)
  {
    asiq localasiq = a(paramString);
    if ((localasiq != null) && (localasiq.jdField_a_of_type_ArrayOfByte != null) && (localasiq.jdField_b_of_type_ArrayOfByte != null))
    {
      if (FileUtil.getFileSize(paramString) == localasiq.jdField_a_of_type_Long)
      {
        paramasis.a(true, localasiq);
        return true;
      }
      b(paramString);
    }
    c();
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new MMApkFileSafeChecker.6(this, paramString, paramasis));
    return true;
  }
  
  private void b(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    asip localasip = new asip(this, null);
    localasip.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localasip.jdField_a_of_type_Int = 2;
    localasip.c = String.valueOf(paramLong);
    localasip.e = paramItem.FilePath;
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk. Item.Id=" + paramItem.getId() + " binfo:" + localasip.toString());
    a(paramItem.LocalFile, localasip, new asil(this, paramItem, paramLong));
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    asip localasip = new asip(this, null);
    localasip.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localasip.jdField_a_of_type_Int = 1;
    if ((paramFileManagerEntity.peerType == 0) || (paramFileManagerEntity.peerType == 3) || (paramFileManagerEntity.peerType == 1000))
    {
      localasip.b = paramFileManagerEntity.peerUin;
      localasip.d = paramFileManagerEntity.Uuid;
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] interCheckLocalApk. nSessionId=" + paramFileManagerEntity.nSessionId + " binfo:" + localasip.toString());
      a(paramFileManagerEntity.strFilePath, localasip, new asik(this, paramFileManagerEntity));
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
    aser localaser = (aser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317);
    if (localaser != null) {
      return localaser.i();
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
      bfte.a();
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
      ((asim)localIterator.next()).c();
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
 * Qualified Name:     asii
 * JD-Core Version:    0.7.0.1
 */