package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.mobileqq.ar.arcore.ArCoreNativeSoManager;
import com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;>;
import mqq.os.MqqHandler;

public class ArNativeSoManager
{
  ARPreSoResourceDownload a;
  private WeakReference<ARPreSoResourceDownload.ARResourceDownloadCallback> b;
  private WeakReference<ARPreSoResourceDownload.ARResourceDownloadCallback> c;
  private WeakReference<ARPreSoResourceDownload.ARResourceDownloadCallback> d;
  private WeakReference<ARPreSoResourceDownload.ARResourceDownloadCallback> e;
  
  public ArNativeSoManager(QQAppInterface paramQQAppInterface)
  {
    this.a = new ARPreSoResourceDownload(paramQQAppInterface);
  }
  
  private void a(ARCommonConfigInfo.NativeSoRes paramNativeSoRes, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadSoRes. fileName = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.d);
    ((StringBuilder)localObject).append(", url = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.b);
    QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject == null) {
      return;
    }
    ((ARPreSoResourceDownload)localObject).a(paramDownloadInfo, new ArNativeSoManager.4(this, paramNativeSoRes));
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private void a(String paramString, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    if (paramString.equalsIgnoreCase("arsdk2"))
    {
      this.b = new WeakReference(paramARResourceDownloadCallback);
      return;
    }
    if (paramString.equalsIgnoreCase("arcloud"))
    {
      this.c = new WeakReference(paramARResourceDownloadCallback);
      return;
    }
    if (paramString.equalsIgnoreCase("arfeature"))
    {
      this.e = new WeakReference(paramARResourceDownloadCallback);
      return;
    }
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    if ((localIArCoreNativeSoLoader != null) && (paramString.equalsIgnoreCase(localIArCoreNativeSoLoader.a()))) {
      this.d = new WeakReference(paramARResourceDownloadCallback);
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("deleteDir. dir = ");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(", excludeSubDirOrFile = ");
    localStringBuilder1.append(paramString2);
    QLog.i("AREngine_ArNativeSoManager", 1, localStringBuilder1.toString());
    paramString1 = new File(paramString1).listFiles();
    int i = 0;
    if (paramString1 == null) {
      return false;
    }
    boolean bool = false;
    while (i < paramString1.length)
    {
      localStringBuilder1 = paramString1[i];
      StringBuilder localStringBuilder2;
      if (!localStringBuilder1.getAbsolutePath().equalsIgnoreCase(paramString2))
      {
        if (localStringBuilder1.isDirectory())
        {
          bool = a(localStringBuilder1.getAbsolutePath(), paramString2);
          if (bool)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = ");
            localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
            QLog.i("AREngine_ArNativeSoManager", 1, localStringBuilder2.toString());
          }
          else
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("deleteDir. delete dir or file = ");
            localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
            QLog.i("AREngine_ArNativeSoManager", 1, localStringBuilder2.toString());
            localStringBuilder1.delete();
            break label301;
          }
        }
        else
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("deleteDir. delete dir or file = ");
          localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
          QLog.i("AREngine_ArNativeSoManager", 1, localStringBuilder2.toString());
          localStringBuilder1.delete();
          break label301;
        }
      }
      else
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = ");
        localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
        QLog.i("AREngine_ArNativeSoManager", 1, localStringBuilder2.toString());
      }
      bool = true;
      label301:
      i += 1;
    }
    return bool;
  }
  
  private String b(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return ArSDK2NativeSoLoader.a();
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return "v8.4.1.1";
    }
    if (paramString.equalsIgnoreCase("arfeature")) {
      return "v8.0.0";
    }
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    if ((localIArCoreNativeSoLoader != null) && (paramString.equalsIgnoreCase(localIArCoreNativeSoLoader.a()))) {
      return localIArCoreNativeSoLoader.b();
    }
    return "";
  }
  
  private void b(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downloadArNativeSo. resName = ");
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = ((StringBuilder)localObject1).toString();
    boolean bool = true;
    QLog.i("AREngine_ArNativeSoManager", 1, (String)localObject1);
    String str = b(paramString);
    a(paramString, paramARResourceDownloadCallback);
    localObject1 = new ARCommonConfigInfo.NativeSoRes();
    int i = 0;
    Object localObject2;
    while (i < paramArrayList.size())
    {
      localObject2 = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
      if ((((ARCommonConfigInfo.NativeSoRes)localObject2).a.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject2).b.equalsIgnoreCase(str)))
      {
        paramArrayList = (ArrayList<ARCommonConfigInfo.NativeSoRes>)localObject2;
        i = 1;
        break label136;
      }
      i += 1;
    }
    i = 0;
    paramArrayList = (ArrayList<ARCommonConfigInfo.NativeSoRes>)localObject1;
    label136:
    if ((i != 0) && (this.a != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ArNativeSoLoaderBase.a(paramArrayList.a, paramArrayList.b, paramArrayList.d));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(paramArrayList.d);
      ((StringBuilder)localObject1).append(".zip");
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!b((String)localObject1, paramArrayList.d))
      {
        a((String)localObject1);
        if ((!TextUtils.isEmpty(paramArrayList.c)) && (!TextUtils.isEmpty(paramArrayList.d)))
        {
          localObject2 = new ARPreSoResourceDownload.DownloadInfo();
          ((ARPreSoResourceDownload.DownloadInfo)localObject2).a = 5;
          ((ARPreSoResourceDownload.DownloadInfo)localObject2).b = paramArrayList.c;
          ((ARPreSoResourceDownload.DownloadInfo)localObject2).c = paramArrayList.d;
          ((ARPreSoResourceDownload.DownloadInfo)localObject2).e = paramArrayList.a;
          ((ARPreSoResourceDownload.DownloadInfo)localObject2).d = ((String)localObject1);
          ((ARPreSoResourceDownload.DownloadInfo)localObject2).f = true;
          this.a.a((ARPreSoResourceDownload.DownloadInfo)localObject2, new ArNativeSoManager.2(this, paramString, paramARResourceDownloadCallback));
          return;
        }
        paramArrayList = new StringBuilder();
        paramArrayList.append("downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = ");
        paramArrayList.append((String)localObject1);
        QLog.i("AREngine_ArNativeSoManager", 1, paramArrayList.toString());
        if (paramARResourceDownloadCallback != null) {
          paramARResourceDownloadCallback.a(false, null);
        }
      }
      else if (!c(paramString))
      {
        i = a(paramString, (String)localObject1, paramArrayList.d);
        if (paramARResourceDownloadCallback != null)
        {
          if (i != 0) {
            bool = false;
          }
          paramARResourceDownloadCallback.a(bool, null);
        }
      }
      else if (paramARResourceDownloadCallback != null)
      {
        paramARResourceDownloadCallback.a(true, null);
      }
    }
    else if (paramARResourceDownloadCallback != null)
    {
      paramARResourceDownloadCallback.a(false, null);
    }
  }
  
  private void b(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList1, ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList2, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downloadSoResIfNeed. resName = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject1).toString());
    localObject1 = b(paramString);
    int i = 0;
    while (i < paramArrayList2.size())
    {
      Object localObject2 = (ARCommonConfigInfo.NativeSoRes)paramArrayList2.get(i);
      Object localObject3;
      if (((ARCommonConfigInfo.NativeSoRes)localObject2).a.equalsIgnoreCase(paramString))
      {
        if (((ARCommonConfigInfo.NativeSoRes)localObject2).b.equalsIgnoreCase((String)localObject1))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(ArNativeSoLoaderBase.a(((ARCommonConfigInfo.NativeSoRes)localObject2).a, ((ARCommonConfigInfo.NativeSoRes)localObject2).b, ((ARCommonConfigInfo.NativeSoRes)localObject2).d));
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(((ARCommonConfigInfo.NativeSoRes)localObject2).d);
          ((StringBuilder)localObject3).append(".zip");
          localObject3 = ((StringBuilder)localObject3).toString();
          Object localObject4;
          if (!b((String)localObject3, ((ARCommonConfigInfo.NativeSoRes)localObject2).d))
          {
            a((String)localObject3);
            if ((!TextUtils.isEmpty(((ARCommonConfigInfo.NativeSoRes)localObject2).c)) && (!TextUtils.isEmpty(((ARCommonConfigInfo.NativeSoRes)localObject2).d)))
            {
              int j = 0;
              while (j < paramArrayList1.size())
              {
                localObject4 = (ARCommonConfigInfo.NativeSoRes)paramArrayList1.get(j);
                if ((((ARCommonConfigInfo.NativeSoRes)localObject4).a.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject4).b.equalsIgnoreCase((String)localObject1))) {
                  a(ArNativeSoLoaderBase.a(((ARCommonConfigInfo.NativeSoRes)localObject4).a), ArNativeSoLoaderBase.a(((ARCommonConfigInfo.NativeSoRes)localObject4).a, ((ARCommonConfigInfo.NativeSoRes)localObject4).b, ((ARCommonConfigInfo.NativeSoRes)localObject4).d));
                }
                j += 1;
              }
              localObject4 = new ARPreSoResourceDownload.DownloadInfo();
              ((ARPreSoResourceDownload.DownloadInfo)localObject4).a = 5;
              ((ARPreSoResourceDownload.DownloadInfo)localObject4).b = ((ARCommonConfigInfo.NativeSoRes)localObject2).c;
              ((ARPreSoResourceDownload.DownloadInfo)localObject4).c = ((ARCommonConfigInfo.NativeSoRes)localObject2).d;
              ((ARPreSoResourceDownload.DownloadInfo)localObject4).e = ((ARCommonConfigInfo.NativeSoRes)localObject2).a;
              ((ARPreSoResourceDownload.DownloadInfo)localObject4).d = ((String)localObject3);
              ((ARPreSoResourceDownload.DownloadInfo)localObject4).f = true;
              a((ARCommonConfigInfo.NativeSoRes)localObject2, (ARPreSoResourceDownload.DownloadInfo)localObject4);
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = ");
              ((StringBuilder)localObject2).append((String)localObject3);
              QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("downloadSoResIfNeed. soRes exists, not need to download. soZipFilename = ");
            ((StringBuilder)localObject4).append((String)localObject3);
            QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject4).toString());
            a(paramString, (String)localObject3, ((ARCommonConfigInfo.NativeSoRes)localObject2).d);
          }
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("downloadSoResIfNeed. soResVersion is not need to download. soResName = ");
          ((StringBuilder)localObject3).append(((ARCommonConfigInfo.NativeSoRes)localObject2).a);
          ((StringBuilder)localObject3).append(", soResVersionFromConfig = ");
          ((StringBuilder)localObject3).append(((ARCommonConfigInfo.NativeSoRes)localObject2).b);
          ((StringBuilder)localObject3).append(", soResVersionFromLocal = ");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("downloadSoResIfNeed. soResName is not need to download. soResName = ");
        ((StringBuilder)localObject3).append(((ARCommonConfigInfo.NativeSoRes)localObject2).a);
        QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject3).toString());
      }
      i += 1;
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(PortalUtils.a(paramString1)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFileValid failed. check md5 failed. filename = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", md5FromConfig = ");
        localStringBuilder.append(paramString2);
        QLog.i("AREngine_ArNativeSoManager", 1, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkFileValid failed. file is not exist. filename = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", md5FromConfig = ");
    localStringBuilder.append(paramString2);
    QLog.i("AREngine_ArNativeSoManager", 1, localStringBuilder.toString());
    return false;
  }
  
  private boolean c(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return ArSDK2NativeSoLoader.b();
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return ArCloudNativeSoLoader.b();
    }
    if (paramString.equalsIgnoreCase("arfeature")) {
      return ArFeatureSwepNativeSoLoader.a();
    }
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    if ((localIArCoreNativeSoLoader != null) && (paramString.equalsIgnoreCase(localIArCoreNativeSoLoader.a()))) {
      return ArCoreNativeSoManager.b(localIArCoreNativeSoLoader);
    }
    return true;
  }
  
  private ARPreSoResourceDownload.ARResourceDownloadCallback d(String paramString)
  {
    boolean bool = paramString.equalsIgnoreCase("arsdk2");
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = null;
    Object localObject2 = null;
    WeakReference localWeakReference = null;
    Object localObject1 = null;
    if (bool)
    {
      localWeakReference = this.b;
      paramString = (String)localObject1;
      if (localWeakReference != null) {
        paramString = (ARPreSoResourceDownload.ARResourceDownloadCallback)localWeakReference.get();
      }
      return paramString;
    }
    if (paramString.equalsIgnoreCase("arcloud"))
    {
      localObject1 = this.c;
      paramString = localIArCoreNativeSoLoader;
      if (localObject1 != null) {
        paramString = (ARPreSoResourceDownload.ARResourceDownloadCallback)((WeakReference)localObject1).get();
      }
      return paramString;
    }
    if (paramString.equalsIgnoreCase("arfeature"))
    {
      localObject1 = this.e;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = (ARPreSoResourceDownload.ARResourceDownloadCallback)((WeakReference)localObject1).get();
      }
      return paramString;
    }
    localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    localObject1 = localWeakReference;
    if (localIArCoreNativeSoLoader != null)
    {
      localObject1 = localWeakReference;
      if (paramString.equalsIgnoreCase(localIArCoreNativeSoLoader.a()))
      {
        paramString = this.d;
        localObject1 = localWeakReference;
        if (paramString != null) {
          localObject1 = (ARPreSoResourceDownload.ARResourceDownloadCallback)paramString.get();
        }
      }
    }
    return localObject1;
  }
  
  public int a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int i;
      if (paramString1.equalsIgnoreCase("arsdk2"))
      {
        i = ArSDK2NativeSoLoader.a(paramString2, paramString3);
        return i;
      }
      if (paramString1.equalsIgnoreCase("arcloud"))
      {
        i = ArCloudNativeSoLoader.a(paramString2, paramString3);
        return i;
      }
      if (paramString1.equalsIgnoreCase("arfeature"))
      {
        i = ArFeatureSwepNativeSoLoader.a(paramString2, paramString3);
        return i;
      }
      IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
      if ((localIArCoreNativeSoLoader != null) && (paramString1.equalsIgnoreCase(localIArCoreNativeSoLoader.a())))
      {
        i = ArCoreNativeSoManager.a(localIArCoreNativeSoLoader, paramString2, paramString3);
        return i;
      }
      return -1;
    }
    finally {}
  }
  
  public void a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    ThreadManager.getSubThreadHandler().post(new ArNativeSoManager.1(this, paramArrayList, paramString, paramARResourceDownloadCallback));
  }
  
  public void a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList1, ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList2, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ArNativeSoManager.3(this, paramArrayList1, paramArrayList2, paramString));
  }
  
  public boolean a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isArNativeSoDownload. resName = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject).toString());
    String str = b(paramString);
    int i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
      if ((((ARCommonConfigInfo.NativeSoRes)localObject).a.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject).b.equalsIgnoreCase(str)))
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append(ArNativeSoLoaderBase.a(((ARCommonConfigInfo.NativeSoRes)localObject).a, ((ARCommonConfigInfo.NativeSoRes)localObject).b, ((ARCommonConfigInfo.NativeSoRes)localObject).d));
        paramArrayList.append(File.separator);
        paramArrayList.append(((ARCommonConfigInfo.NativeSoRes)localObject).d);
        paramArrayList.append(".zip");
        paramArrayList = paramArrayList.toString();
        if (!b(paramArrayList, ((ARCommonConfigInfo.NativeSoRes)localObject).d))
        {
          a(paramArrayList);
          return false;
        }
        return c(paramString);
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoManager
 * JD-Core Version:    0.7.0.1
 */