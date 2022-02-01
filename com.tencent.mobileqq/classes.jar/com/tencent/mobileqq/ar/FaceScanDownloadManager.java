package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.FaceModelsDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.FaceScanNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class FaceScanDownloadManager
{
  public static Handler a = new Handler(Looper.getMainLooper());
  private static ArrayList<FaceScanDownloadManager.DownloadCallback> b = new ArrayList(2);
  
  public static void a()
  {
    ArrayList localArrayList = b;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanDownloadManager", 2, "clearCallback");
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object[] arrayOfObject = b.toArray();
      if (arrayOfObject != null)
      {
        if (arrayOfObject.length <= 0) {
          return;
        }
        int i = 0;
        while (i < arrayOfObject.length)
        {
          FaceScanDownloadManager.DownloadCallback localDownloadCallback = (FaceScanDownloadManager.DownloadCallback)arrayOfObject[i];
          a.post(new FaceScanDownloadManager.1(localDownloadCallback, paramInt1, paramInt2));
          i += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanDownloadManager", 2, "downloadFaceRes app is null");
      }
      return;
    }
    Object localObject = (IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    paramQQAppInterface = null;
    boolean bool = false;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramQQAppInterface = ((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.ar.face.so_v8.5.2_32");
        bool = FaceScanNativeSoLoader.c();
        if (paramQQAppInterface != null) {
          BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", paramQQAppInterface.f()).commit();
        }
      }
    }
    else
    {
      paramQQAppInterface = ((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.ar.face.models_v8.2.0");
      bool = FaceScanModelsLoader.d();
    }
    if (paramQQAppInterface != null)
    {
      paramInt = paramQQAppInterface.f();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initAr version=");
        ((StringBuilder)localObject).append(paramQQAppInterface.f());
        QLog.d("FaceScanDownloadManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((!bool) || (!paramQQAppInterface.r()) || (paramInt <= 1)) {
        paramQQAppInterface.a(true);
      }
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      Object[] arrayOfObject = b.toArray();
      if (arrayOfObject != null)
      {
        if (arrayOfObject.length <= 0) {
          return;
        }
        int i = 0;
        while (i < arrayOfObject.length)
        {
          FaceScanDownloadManager.DownloadCallback localDownloadCallback = (FaceScanDownloadManager.DownloadCallback)arrayOfObject[i];
          a.post(new FaceScanDownloadManager.2(localDownloadCallback, paramInt, paramBoolean));
          i += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_download_cfg_version");
    localStringBuilder.append(paramQQAppInterface.getLongAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = Xml.newPullParser();
    boolean bool2 = false;
    int i;
    try
    {
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject).getEventType();
    }
    catch (Exception paramQQAppInterface)
    {
      if (!QLog.isColorLevel()) {
        break label181;
      }
      QLog.e("FaceScanDownloadManager", 2, paramString, paramQQAppInterface);
      label181:
      return;
    }
    boolean bool1 = bool2;
    if (((XmlPullParser)localObject).getName().equalsIgnoreCase("PreDownload"))
    {
      bool1 = bool2;
      if (Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue() != 1) {}
    }
    for (bool1 = true;; bool1 = bool2)
    {
      i = ((XmlPullParser)localObject).next();
      bool2 = bool1;
      while (i == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleResp_GetArScanFacePreDownConfig success：isPreDownload|version=");
          ((StringBuilder)localObject).append(bool2);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("FaceScanDownloadManager", 2, ((StringBuilder)localObject).toString());
        }
        a(paramQQAppInterface, paramInt);
        a(paramQQAppInterface, bool2);
        return;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_download_cfg_enable");
    localStringBuilder.append(paramQQAppInterface.getLongAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static void a(FaceScanDownloadManager.DownloadCallback paramDownloadCallback)
  {
    if (paramDownloadCallback != null) {
      try
      {
        if (!b.contains(paramDownloadCallback))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FaceScanDownloadManager", 2, "addDownloadCallback");
          }
          b.add(paramDownloadCallback);
        }
      }
      finally {}
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool4 = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    if (paramQQAppInterface == null) {
      return false;
    }
    Object localObject = (FaceScanNativeSoDownloadHandler)paramQQAppInterface.getEarlyHandler("qq.android.ar.face.so_v8.5.2_32");
    boolean bool2 = a((EarlyHandler)localObject);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((FaceScanNativeSoDownloadHandler)localObject).r())
        {
          bool1 = bool2;
          if (FaceScanNativeSoLoader.c()) {
            bool1 = true;
          }
        }
      }
    }
    if (bool1) {
      ((FaceScanNativeSoDownloadHandler)localObject).w();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("native so config is exist :");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("FaceScanDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface = (FaceModelsDownloadHandler)paramQQAppInterface.getEarlyHandler("qq.android.ar.face.models_v8.2.0");
    boolean bool3 = a(paramQQAppInterface);
    bool2 = bool3;
    if (!bool3)
    {
      bool2 = bool3;
      if (paramQQAppInterface != null)
      {
        bool2 = bool3;
        if (paramQQAppInterface.r())
        {
          bool2 = bool3;
          if (FaceScanModelsLoader.d()) {
            bool2 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("models config is exist :");
      paramQQAppInterface.append(bool2);
      QLog.d("FaceScanDownloadManager", 2, paramQQAppInterface.toString());
    }
    bool3 = bool4;
    if (bool1)
    {
      bool3 = bool4;
      if (bool2) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  private static boolean a(EarlyHandler paramEarlyHandler)
  {
    if (paramEarlyHandler == null) {
      return false;
    }
    paramEarlyHandler = paramEarlyHandler.h();
    if (paramEarlyHandler == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramEarlyHandler.strPkgName)) && (!TextUtils.isEmpty(paramEarlyHandler.strResURL_big))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("strPkgName is empty:");
      localStringBuilder.append(TextUtils.isEmpty(paramEarlyHandler.strPkgName));
      localStringBuilder.append(" strResURL_big is empty:");
      localStringBuilder.append(TextUtils.isEmpty(paramEarlyHandler.strResURL_big));
      localStringBuilder.append(" loadState :");
      localStringBuilder.append(paramEarlyHandler.loadState);
      QLog.d("FaceScanDownloadManager", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = (IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    if (paramQQAppInterface == null) {
      return;
    }
    FaceScanNativeSoDownloadHandler localFaceScanNativeSoDownloadHandler = (FaceScanNativeSoDownloadHandler)paramQQAppInterface.getEarlyHandler("qq.android.ar.face.so_v8.5.2_32");
    if ((localFaceScanNativeSoDownloadHandler != null) && (localFaceScanNativeSoDownloadHandler.r()) && (!FaceScanNativeSoLoader.c()))
    {
      localFaceScanNativeSoDownloadHandler.x();
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanDownloadManager", 2, "reset native so download state");
      }
    }
    paramQQAppInterface = (FaceModelsDownloadHandler)paramQQAppInterface.getEarlyHandler("qq.android.ar.face.models_v8.2.0");
    if ((paramQQAppInterface != null) && (paramQQAppInterface.r()) && (!FaceScanModelsLoader.d()))
    {
      paramQQAppInterface.w();
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanDownloadManager", 2, "reset modules so download state");
      }
    }
  }
  
  public static boolean b()
  {
    return (FaceScanNativeSoLoader.c()) && (FaceScanModelsLoader.d());
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_download_cfg_version");
    localStringBuilder.append(paramQQAppInterface.getLongAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_download_cfg_enable");
    localStringBuilder.append(paramQQAppInterface.getLongAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, 0);
    a(paramQQAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanDownloadManager
 * JD-Core Version:    0.7.0.1
 */