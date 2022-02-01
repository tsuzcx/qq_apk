package com.tencent.mobileqq.ar.codeEngine;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.MiniScanDecodeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.MiniScanDetectModelsDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.MiniScanDetectSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class MiniResDownloadManager
{
  public static Handler a;
  private static ArrayList<MiniResDownloadManager.DownloadCallback> a;
  
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
        MiniResDownloadManager.DownloadCallback localDownloadCallback = (MiniResDownloadManager.DownloadCallback)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.1(localDownloadCallback, paramInt1, paramInt2));
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
      paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
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
      bool = MiniScanDecodeSoLoader.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
      bool = MiniScanDetectSoLoader.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      bool = MiniScanDetectModelLoader.a();
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
        MiniResDownloadManager.DownloadCallback localDownloadCallback = (MiniResDownloadManager.DownloadCallback)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.2(localDownloadCallback, paramInt, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static void a(MiniResDownloadManager.DownloadCallback paramDownloadCallback)
  {
    if (paramDownloadCallback != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramDownloadCallback))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.ResDownloadManager", 2, "addDownloadCallback");
        }
        jdField_a_of_type_JavaUtilArrayList.add(paramDownloadCallback);
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
              paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
            } while (paramQQAppInterface == null);
            if (!paramBoolean) {
              break;
            }
            paramQQAppInterface = (MiniScanDecodeSoDownloadHandler)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
          } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (MiniScanDecodeSoLoader.a()));
          paramQQAppInterface.g();
        } while (!QLog.isColorLevel());
        QLog.d("MiniRecog.ResDownloadManager", 2, "reset decode so download state");
        return;
        MiniScanDetectSoDownloadHandler localMiniScanDetectSoDownloadHandler = (MiniScanDetectSoDownloadHandler)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
        if ((localMiniScanDetectSoDownloadHandler != null) && (localMiniScanDetectSoDownloadHandler.g()) && (!MiniScanDetectSoLoader.a()))
        {
          localMiniScanDetectSoDownloadHandler.g();
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, "reset detect so download state");
          }
        }
        paramQQAppInterface = (MiniScanDetectModelsDownloadHandler)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (MiniScanDetectModelLoader.a()));
      paramQQAppInterface.f();
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "reset model so download state");
  }
  
  private static boolean a(EarlyHandler paramEarlyHandler)
  {
    if (paramEarlyHandler == null) {}
    do
    {
      do
      {
        return false;
        paramEarlyHandler = paramEarlyHandler.a();
      } while (paramEarlyHandler == null);
      if ((!TextUtils.isEmpty(paramEarlyHandler.strPkgName)) && (!TextUtils.isEmpty(paramEarlyHandler.strResURL_big))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(paramEarlyHandler.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(paramEarlyHandler.strResURL_big) + " loadState :" + paramEarlyHandler.loadState);
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
      paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    } while (paramQQAppInterface == null);
    if (paramBoolean)
    {
      paramQQAppInterface = (MiniScanDecodeSoDownloadHandler)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
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
            if (MiniScanDecodeSoLoader.a()) {
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
    MiniScanDetectSoDownloadHandler localMiniScanDetectSoDownloadHandler = (MiniScanDetectSoDownloadHandler)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
    boolean bool1 = a(localMiniScanDetectSoDownloadHandler);
    paramBoolean = bool1;
    if (!bool1)
    {
      paramBoolean = bool1;
      if (localMiniScanDetectSoDownloadHandler != null)
      {
        paramBoolean = bool1;
        if (localMiniScanDetectSoDownloadHandler.g())
        {
          paramBoolean = bool1;
          if (MiniScanDetectSoLoader.a()) {
            paramBoolean = true;
          }
        }
      }
    }
    if (paramBoolean) {
      localMiniScanDetectSoDownloadHandler.f();
    }
    paramQQAppInterface = (MiniScanDetectModelsDownloadHandler)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
    bool1 = a(paramQQAppInterface);
    if ((!bool1) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (MiniScanDetectModelLoader.a())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager
 * JD-Core Version:    0.7.0.1
 */