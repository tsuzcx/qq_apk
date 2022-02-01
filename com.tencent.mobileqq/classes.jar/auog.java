import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class auog
{
  public static Handler a;
  private static auoh jdField_a_of_type_Auoh = new auoh(null);
  private static ArrayList<auoi> jdField_a_of_type_JavaUtilArrayList;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "libflutter.so" };
  private static auoh jdField_b_of_type_Auoh = new auoh(null);
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "libapp.so", "libqflutter-resource-loader.so", "res.apk" };
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    return localFile.getAbsolutePath() + File.separator + "qflutter";
  }
  
  public static String a(String paramString)
  {
    return new File(a(), paramString).getAbsolutePath();
  }
  
  private static void a()
  {
    String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      FileUtils.deleteFile(a(arrayOfString[i]));
      i += 1;
    }
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    label161:
    for (;;)
    {
      try
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("onDownloadFinish, type: %s, isSuccess: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
        if (paramInt == 0)
        {
          jdField_a_of_type_Auoh.a(paramBoolean, false);
          if ((jdField_b_of_type_Auoh.a()) && (jdField_a_of_type_Auoh.a()))
          {
            if ((!jdField_b_of_type_Auoh.jdField_a_of_type_Boolean) || (!jdField_a_of_type_Auoh.jdField_a_of_type_Boolean)) {
              break label161;
            }
            paramBoolean = bool;
            long l = Math.max(auoh.a(jdField_b_of_type_Auoh), auoh.a(jdField_a_of_type_Auoh));
            a(paramBoolean, auoh.a(jdField_a_of_type_Auoh), auoh.a(jdField_b_of_type_Auoh));
            aupl.a(paramBoolean, l, auoh.a(jdField_a_of_type_Auoh), auoh.a(jdField_b_of_type_Auoh));
          }
        }
        else
        {
          if (paramInt != 1) {
            continue;
          }
          jdField_b_of_type_Auoh.a(paramBoolean, false);
          continue;
        }
        paramBoolean = false;
      }
      finally {}
    }
  }
  
  private static void a(auoi paramauoi)
  {
    if (paramauoi != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramauoi)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramauoi);
      }
      return;
    }
    finally
    {
      paramauoi = finally;
      throw paramauoi;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, auoi paramauoi)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      try
      {
        bool2 = a(paramQQAppInterface);
        bool3 = b(paramQQAppInterface);
        a(paramauoi);
        StringBuilder localStringBuilder = new StringBuilder().append("install isEngineReady:").append(bool2).append(" isAppReady:").append(bool3).append(" installCallback:");
        if (paramauoi != null)
        {
          QLog.i("QFlutter.QFlutterDownloadManager", 1, bool1);
          if ((bool2) && (bool3)) {
            a(true, true, true);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        if (jdField_a_of_type_Boolean)
        {
          QLog.d("QFlutter.QFlutterDownloadManager", 1, "install, is downloading...");
          continue;
        }
        jdField_a_of_type_Boolean = true;
      }
      finally {}
      paramQQAppInterface = (asbm)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if (!bool2)
      {
        jdField_a_of_type_Auoh.a();
        paramauoi = (auof)paramQQAppInterface.a("qq.android.flutter.engine.v8.4.10");
        if (paramauoi != null) {
          paramauoi.a(true);
        }
      }
      for (;;)
      {
        if (bool3) {
          break label207;
        }
        jdField_b_of_type_Auoh.a();
        paramQQAppInterface = (auoe)paramQQAppInterface.a("qq.android.flutter.app.v8.4.10");
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.a(true);
        break;
        jdField_a_of_type_Auoh.a(true, true);
      }
      label207:
      jdField_b_of_type_Auoh.a(true, true);
    }
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      int i;
      try
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("notifyResult, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
        i = 0;
        if (i < jdField_a_of_type_JavaUtilArrayList.size())
        {
          auoi localauoi = (auoi)jdField_a_of_type_JavaUtilArrayList.get(i);
          if (paramBoolean1) {
            localauoi.onResult(true, a(), paramBoolean2, paramBoolean3);
          } else {
            localauoi.onResult(false, null, paramBoolean2, paramBoolean3);
          }
        }
      }
      finally {}
      jdField_a_of_type_JavaUtilArrayList.clear();
      jdField_a_of_type_Boolean = false;
      return;
      i += 1;
    }
  }
  
  private static boolean a(asbv paramasbv)
  {
    if (paramasbv == null) {
      return false;
    }
    paramasbv = paramasbv.a();
    if (paramasbv == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "isEarlyDownloadConfigReady, data == null");
      return false;
    }
    if ((TextUtils.isEmpty(paramasbv.strPkgName)) || (TextUtils.isEmpty(paramasbv.strResURL_big)))
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("isEarlyDownloadConfigReady, strPkgName: %s, strResURL_big: %s", new Object[] { paramasbv.strPkgName, paramasbv.strResURL_big }));
      return false;
    }
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (auof)((asbm)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.flutter.engine.v8.4.10");
    boolean bool2 = a(paramQQAppInterface);
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (a((QFlutterEngineData)paramQQAppInterface.a()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isEngineConfigReady : %s, isEngineInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
    }
  }
  
  private static boolean a(QFlutterAppData paramQFlutterAppData)
  {
    if (paramQFlutterAppData == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkAppFiles, engineData == null");
      return false;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put(a("libapp.so"), paramQFlutterAppData.libAppSoMD5);
    ((HashMap)localObject1).put(a("libqflutter-resource-loader.so"), paramQFlutterAppData.libSkinSoMD5);
    ((HashMap)localObject1).put(a("res.apk"), paramQFlutterAppData.assetResMD5);
    paramQFlutterAppData = ((HashMap)localObject1).entrySet().iterator();
    Object localObject2;
    boolean bool;
    if (paramQFlutterAppData.hasNext())
    {
      localObject2 = (Map.Entry)paramQFlutterAppData.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      if (!FileUtil.isFileExists((String)localObject1))
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("checkAppFiles, %s is not exist", new Object[] { localObject1 }));
        bool = false;
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkAppFiles result: " + bool + ", cost: " + (l2 - l1));
      return bool;
      String str = aznv.a((String)localObject1);
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equalsIgnoreCase(str))) {
        break;
      }
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("checkAppFiles, %s md5 check fail, md5: %s fileMD5: %s", new Object[] { localObject1, localObject2, str }));
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private static boolean a(QFlutterEngineData paramQFlutterEngineData)
  {
    if (paramQFlutterEngineData == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkEngineFiles, engineData == null");
      return false;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = new File(a(), "libflutter.so");
    if (!((File)localObject).exists())
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkEngineFiles, libEngineFile is not exist");
      return false;
    }
    localObject = aznv.a(((File)localObject).getAbsolutePath());
    if ((TextUtils.isEmpty(paramQFlutterEngineData.libEngineSoMD5)) || (!paramQFlutterEngineData.libEngineSoMD5.equalsIgnoreCase((String)localObject)))
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("checkEngineFiles, libEngineFile md5 check fail, md5: %s fileMD5: %s", new Object[] { paramQFlutterEngineData.libEngineSoMD5, localObject }));
      return false;
    }
    long l2 = System.currentTimeMillis();
    QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkEngineFiles success, cost: " + (l2 - l1));
    return true;
  }
  
  public static boolean a(String paramString, QFlutterAppData paramQFlutterAppData)
  {
    if (a(paramQFlutterAppData)) {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "installApp, engine had installed");
    }
    for (;;)
    {
      return true;
      try
      {
        a();
        FileUtils.uncompressZip(paramString, a(), false);
        if (!a(paramQFlutterAppData))
        {
          QLog.d("QFlutter.QFlutterDownloadManager", 1, "installApp check failed, srcPath: " + paramString);
          a();
          return false;
        }
      }
      catch (IOException paramQFlutterAppData)
      {
        paramQFlutterAppData.printStackTrace();
        QLog.d("QFlutter.QFlutterDownloadManager", 1, "uncompressZip fail: " + paramString);
        a();
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, QFlutterEngineData paramQFlutterEngineData)
  {
    if (a(paramQFlutterEngineData)) {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "installEngine, engine had installed");
    }
    for (;;)
    {
      return true;
      try
      {
        b();
        FileUtils.uncompressZip(paramString, a(), false);
        if (!a(paramQFlutterEngineData))
        {
          QLog.d("QFlutter.QFlutterDownloadManager", 1, "installEngine check failed, srcPath: " + paramString);
          b();
          return false;
        }
      }
      catch (IOException paramQFlutterEngineData)
      {
        paramQFlutterEngineData.printStackTrace();
        QLog.d("QFlutter.QFlutterDownloadManager", 1, "uncompressZip fail: " + paramString);
        b();
      }
    }
    return false;
  }
  
  private static void b()
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      FileUtils.deleteFile(a(arrayOfString[i]));
      i += 1;
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (auoe)((asbm)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.flutter.app.v8.4.10");
    boolean bool2 = a(paramQQAppInterface);
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (a((QFlutterAppData)paramQQAppInterface.a()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isAppConfigReady: %s, isAppInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auog
 * JD-Core Version:    0.7.0.1
 */