import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class asvu
{
  private asvz jdField_a_of_type_Asvz;
  private bezv jdField_a_of_type_Bezv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, asvs> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private String b;
  
  public asvu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_Bezv = ((bezv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
    }
  }
  
  public static String a()
  {
    return String.format("%s/res", new Object[] { b() });
  }
  
  private String a(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { b(), paramString });
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean a(asvs paramasvs)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramasvs != null)
    {
      bool1 = bool3;
      if (paramasvs.a()) {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      }
    }
    try
    {
      bool3 = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramasvs.jdField_a_of_type_JavaLangString);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (new File(paramString1).exists())
    {
      paramString1 = azul.a(paramString1);
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static String b()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/ef_res";
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private void b(asvs paramasvs)
  {
    c(paramasvs);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendResourceDownloader.4(this, paramasvs));
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.b)) {
      bool = a(a(this.b), this.b);
    }
    return bool;
  }
  
  private boolean b(asvs paramasvs)
  {
    return (paramasvs != null) && (paramasvs.a()) && (atax.a.contains(paramasvs.jdField_a_of_type_JavaLangString));
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    try
    {
      apjh.a(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendResourceDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  private void c(asvs paramasvs)
  {
    if ((paramasvs != null) && (paramasvs.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramasvs.jdField_a_of_type_JavaLangString, paramasvs);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.b))
    {
      bool1 = bool2;
      if (atcj.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d(asvs paramasvs)
  {
    if ((paramasvs != null) && (paramasvs.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramasvs.jdField_a_of_type_JavaLangString);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a()
  {
    int i = 1;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b))) {
      QLog.e("ExtendFriendResourceDownloader", 1, "downloadResource invalid parameters.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    }
    Object localObject1 = a(this.b);
    if (!a((String)localObject1, this.b))
    {
      a((String)localObject1);
      if (this.jdField_a_of_type_Bezv != null)
      {
        localObject2 = new beum();
        ((beum)localObject2).jdField_a_of_type_Beuq = new asvv(this);
        ((beum)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((beum)localObject2).jdField_a_of_type_Int = 0;
        ((beum)localObject2).c = ((String)localObject1);
        ((beum)localObject2).d = 0;
        ((beum)localObject2).jdField_a_of_type_Beup = new asvw(this);
        localObject2 = new bezt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, new asvx(this), (beum)localObject2);
        this.jdField_a_of_type_Bezv.a(10073, "prd", this.b, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, 2, 0, false, (bezs)localObject2);
      }
    }
    while (c())
    {
      Object localObject2;
      return;
    }
    boolean bool3 = b((String)localObject1, a());
    boolean bool2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
    }
    boolean bool1;
    if (this.jdField_a_of_type_Asvz != null)
    {
      localObject1 = this.jdField_a_of_type_Asvz;
      if ((bool3) && (bool2))
      {
        bool1 = true;
        ((asvz)localObject1).a(bool1);
      }
    }
    else
    {
      localObject1 = atci.a();
      if ((!bool3) || (!bool2)) {
        break label347;
      }
      bool1 = true;
      label330:
      if (bool2) {
        break label352;
      }
    }
    for (;;)
    {
      ((atci)localObject1).b(bool1, i);
      return;
      bool1 = false;
      break;
      label347:
      bool1 = false;
      break label330;
      label352:
      i = 0;
    }
  }
  
  public void a(asvs paramasvs)
  {
    if (paramasvs == null)
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is null");
      return;
    }
    if (!paramasvs.a())
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is not effect");
      return;
    }
    if (!a(paramasvs))
    {
      b(paramasvs);
      return;
    }
    QLog.i("ExtendFriendResourceDownloader", 2, "Limitchatres is downloading" + paramasvs.jdField_a_of_type_JavaLangString);
  }
  
  public void a(asvz paramasvz)
  {
    this.jdField_a_of_type_Asvz = paramasvz;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("setDownloadInfo url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public boolean a()
  {
    boolean bool1 = b();
    boolean bool2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bezv != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Bezv.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvu
 * JD-Core Version:    0.7.0.1
 */