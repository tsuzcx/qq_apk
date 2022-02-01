import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;

public class atud
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public atud(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static String a()
  {
    return String.format("%s/res", new Object[] { b() });
  }
  
  private String a(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { b(), paramString });
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (new File(paramString1).exists())
    {
      paramString1 = ayja.a(paramString1);
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
  
  public static boolean a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!new File(str).exists())
      {
        QLog.e("IntimateInfoManager", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { str }));
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static String b()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/intimate_res";
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
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.b)) {
      bool = a(a(this.b), this.b);
    }
    return bool;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    try
    {
      aocu.a(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("IntimateInfoManager", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  private boolean c()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      String str = a();
      if (a(new String[] { str + "/boy_add", str + "/boy_reduce", str + "/couple_add", str + "/couple_reduce", str + "/girl_add", str + "/girl_reduce", str + "/bestfriend_add", str + "/bestfriend_reduce" })) {
        return true;
      }
    }
    return false;
  }
  
  public IntimateInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      return null;
    }
    return (IntimateInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(IntimateInfo.class, paramString);
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str = a();
    if (paramInt == 3) {
      if (paramBoolean) {
        str = str + "/boy_add/data.json";
      }
    }
    for (;;)
    {
      if ((!new File(str).exists()) && (QLog.isColorLevel())) {
        QLog.d("IntimateInfoManager", 2, "getIntimateScoreAnimJsonPath not exists:" + str);
      }
      return str;
      str = str + "/boy_reduce/data.json";
      continue;
      if (paramInt == 2)
      {
        if (paramBoolean) {
          str = str + "/girl_add/data.json";
        } else {
          str = str + "/girl_reduce/data.json";
        }
      }
      else if (paramInt == 26)
      {
        if (paramBoolean) {
          str = str + "/bestfriend_add/data.json";
        } else {
          str = str + "/bestfriend_reduce/data.json";
        }
      }
      else
      {
        if (paramInt != 1) {
          break;
        }
        if (paramBoolean) {
          str = str + "/couple_add/data.json";
        } else {
          str = str + "/couple_reduce/data.json";
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b))) {
      QLog.e("IntimateInfoManager", 1, "downloadResource invalid parameters.");
    }
    boolean bool1;
    boolean bool2;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController == null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
          }
          str = a(this.b);
          if (a(str, this.b)) {
            break;
          }
          b(str);
        } while (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController == null);
        Object localObject = new HttpNetReq();
        ((HttpNetReq)localObject).mCallback = new atue(this);
        ((HttpNetReq)localObject).mReqUrl = this.jdField_a_of_type_JavaLangString;
        ((HttpNetReq)localObject).mHttpMethod = 0;
        ((HttpNetReq)localObject).mOutPath = str;
        ((HttpNetReq)localObject).mPrioty = 0;
        ((HttpNetReq)localObject).mBreakDownFix = new atuf(this);
        localObject = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, new atug(this), (HttpNetReq)localObject);
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.requestPreDownload(10089, "prd", this.b, 0, this.jdField_a_of_type_JavaLangString, str, 2, 0, false, (AbsPreDownloadTask)localObject);
        return;
      } while (c());
      bool1 = b(str, a());
      bool2 = c();
    } while (!QLog.isColorLevel());
    QLog.d("IntimateInfoManager", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
  }
  
  public void a(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramIntimateInfo);
      }
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", new Object[] { paramIntimateInfo.friendUin }));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()));
      paramString = (IntimateInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(IntimateInfo.class, paramString);
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, "removeIntimateInfo: " + paramString);
  }
  
  public void a(String paramString, IntimateInfo paramIntimateInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntimateInfo == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramIntimateInfo);
      }
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", new Object[] { paramString }));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("checkAndDownloadIntimateResources url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (!a()) {
      a();
    }
  }
  
  public boolean a()
  {
    boolean bool1 = b();
    boolean bool2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "IntimateInfoManager onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atud
 * JD-Core Version:    0.7.0.1
 */