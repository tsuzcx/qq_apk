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

public class anok
{
  private anop jdField_a_of_type_Anop;
  private axxj jdField_a_of_type_Axxj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, anoi> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private String b;
  
  public anok(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_Axxj = ((axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
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
  
  private boolean a(anoi paramanoi)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramanoi != null)
    {
      bool1 = bool3;
      if (paramanoi.a()) {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      }
    }
    try
    {
      bool3 = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramanoi.jdField_a_of_type_JavaLangString);
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
      paramString1 = attn.a(paramString1);
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
  
  private void b(anoi paramanoi)
  {
    c(paramanoi);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendResourceDownloader.4(this, paramanoi));
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.b)) {
      bool = a(a(this.b), this.b);
    }
    return bool;
  }
  
  private boolean b(anoi paramanoi)
  {
    return (paramanoi != null) && (paramanoi.a()) && (ansv.a.contains(paramanoi.jdField_a_of_type_JavaLangString));
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    try
    {
      aknk.a(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendResourceDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  private void c(anoi paramanoi)
  {
    if ((paramanoi != null) && (paramanoi.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramanoi.jdField_a_of_type_JavaLangString, paramanoi);
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
      if (antz.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d(anoi paramanoi)
  {
    if ((paramanoi != null) && (paramanoi.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramanoi.jdField_a_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Axxj != null)
      {
        localObject2 = new axro();
        ((axro)localObject2).jdField_a_of_type_Axrt = new anol(this);
        ((axro)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((axro)localObject2).jdField_a_of_type_Int = 0;
        ((axro)localObject2).c = ((String)localObject1);
        ((axro)localObject2).e = 0;
        ((axro)localObject2).jdField_a_of_type_Axrs = new anom(this);
        localObject2 = new axxh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, new anon(this), (axro)localObject2);
        this.jdField_a_of_type_Axxj.a(10073, "prd", this.b, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, 2, 0, false, (axxg)localObject2);
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
    if (this.jdField_a_of_type_Anop != null)
    {
      localObject1 = this.jdField_a_of_type_Anop;
      if ((bool3) && (bool2))
      {
        bool1 = true;
        ((anop)localObject1).a(bool1);
      }
    }
    else
    {
      localObject1 = anty.a();
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
      ((anty)localObject1).b(bool1, i);
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
  
  public void a(anoi paramanoi)
  {
    if (paramanoi == null)
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is null");
      return;
    }
    if (!paramanoi.a())
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is not effect");
      return;
    }
    if (!a(paramanoi))
    {
      b(paramanoi);
      return;
    }
    QLog.i("ExtendFriendResourceDownloader", 2, "Limitchatres is downloading" + paramanoi.jdField_a_of_type_JavaLangString);
  }
  
  public void a(anop paramanop)
  {
    this.jdField_a_of_type_Anop = paramanop;
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
    if ((this.jdField_a_of_type_Axxj != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Axxj.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anok
 * JD-Core Version:    0.7.0.1
 */