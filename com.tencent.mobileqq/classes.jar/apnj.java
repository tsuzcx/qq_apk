import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.1;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.2;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apnj
{
  public static Handler a;
  private static ArrayList<apnk> a;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilArrayList != null) {
      jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.ResDownloadManager", 2, "clearCallback");
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        apnk localapnk = (apnk)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.1(localapnk, paramInt1, paramInt2));
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, "downloadFaceRes app is null");
      }
    }
    do
    {
      return;
      paramQQAppInterface = (asbm)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    } while (paramQQAppInterface == null);
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      paramQQAppInterface = null;
    }
    while (paramQQAppInterface != null)
    {
      paramInt = paramQQAppInterface.b();
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, "initAr version=" + paramQQAppInterface.b());
      }
      if ((bool) && (paramQQAppInterface.g()) && (paramInt > 1)) {
        break;
      }
      paramQQAppInterface.a(true);
      return;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
      bool = apnl.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
      bool = apnn.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      bool = apnm.a();
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        apnk localapnk = (apnk)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.2(localapnk, paramInt, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static void a(apnk paramapnk)
  {
    if (paramapnk != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramapnk))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.ResDownloadManager", 2, "addDownloadCallback");
        }
        jdField_a_of_type_JavaUtilArrayList.add(paramapnk);
      }
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramQQAppInterface = (asbm)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
            } while (paramQQAppInterface == null);
            if (!paramBoolean) {
              break;
            }
            paramQQAppInterface = (asca)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
          } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (apnl.a()));
          paramQQAppInterface.g();
        } while (!QLog.isColorLevel());
        QLog.d("MiniRecog.ResDownloadManager", 2, "reset decode so download state");
        return;
        ascc localascc = (ascc)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
        if ((localascc != null) && (localascc.g()) && (!apnn.a()))
        {
          localascc.g();
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, "reset detect so download state");
          }
        }
        paramQQAppInterface = (ascb)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (apnm.a()));
      paramQQAppInterface.f();
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "reset model so download state");
  }
  
  private static boolean a(asbv paramasbv)
  {
    if (paramasbv == null) {}
    do
    {
      do
      {
        return false;
        paramasbv = paramasbv.a();
      } while (paramasbv == null);
      if ((!TextUtils.isEmpty(paramasbv.strPkgName)) && (!TextUtils.isEmpty(paramasbv.strResURL_big))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(paramasbv.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(paramasbv.strResURL_big) + " loadState :" + paramasbv.loadState);
    return false;
    return true;
  }
  
  public static boolean a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      paramQQAppInterface = (asbm)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    } while (paramQQAppInterface == null);
    if (paramBoolean)
    {
      paramQQAppInterface = (asca)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
      bool1 = a(paramQQAppInterface);
      paramBoolean = bool1;
      if (!bool1)
      {
        paramBoolean = bool1;
        if (paramQQAppInterface != null)
        {
          paramBoolean = bool1;
          if (paramQQAppInterface.g())
          {
            paramBoolean = bool1;
            if (apnl.a()) {
              paramBoolean = true;
            }
          }
        }
      }
      if (paramBoolean) {
        paramQQAppInterface.f();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isMiniResConfigReady config exist [decode]=[%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      return paramBoolean;
    }
    ascc localascc = (ascc)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
    boolean bool1 = a(localascc);
    paramBoolean = bool1;
    if (!bool1)
    {
      paramBoolean = bool1;
      if (localascc != null)
      {
        paramBoolean = bool1;
        if (localascc.g())
        {
          paramBoolean = bool1;
          if (apnn.a()) {
            paramBoolean = true;
          }
        }
      }
    }
    if (paramBoolean) {
      localascc.f();
    }
    paramQQAppInterface = (ascb)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
    bool1 = a(paramQQAppInterface);
    if ((!bool1) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (apnm.a())) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isMiniResConfigReady config exist [detect,model]=[%b,%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) }));
      }
      if ((paramBoolean) && (bool1)) {}
      for (paramBoolean = bool2;; paramBoolean = false) {
        return paramBoolean;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnj
 * JD-Core Version:    0.7.0.1
 */