package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import zxz;
import zya;

public class ArNativeSoManager
{
  ARPreSoResourceDownload jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference b;
  
  public ArNativeSoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload = new ARPreSoResourceDownload(paramQQAppInterface);
  }
  
  private ARPreSoResourceDownload.ARResourceDownloadCallback a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramString.equalsIgnoreCase("arsdk2"))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        localObject1 = (ARPreSoResourceDownload.ARResourceDownloadCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!paramString.equalsIgnoreCase("arcloud"));
      localObject1 = localObject2;
    } while (this.b == null);
    return (ARPreSoResourceDownload.ARResourceDownloadCallback)this.b.get();
  }
  
  private String a(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return "v7.3.5.1";
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return "v7.3.0.2";
    }
    return "";
  }
  
  private void a(ARCommonConfigInfo.NativeSoRes paramNativeSoRes, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes. fileName = " + paramDownloadInfo.c + ", url = " + paramDownloadInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload.a(paramDownloadInfo, new zya(this, paramNativeSoRes));
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
    if (paramString.equalsIgnoreCase("arsdk2")) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramARResourceDownloadCallback);
    }
    while (!paramString.equalsIgnoreCase("arcloud")) {
      return;
    }
    this.b = new WeakReference(paramARResourceDownloadCallback);
  }
  
  private boolean a(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return ArSDK2NativeSoLoader.a();
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return ArCloudNativeSoLoader.a();
    }
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    int i = 0;
    QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. dir = " + paramString1 + ", excludeSubDirOrFile = " + paramString2);
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      return false;
    }
    boolean bool = false;
    if (i < paramString1.length)
    {
      Object localObject = paramString1[i];
      if (!localObject.getAbsolutePath().equalsIgnoreCase(paramString2)) {
        if (localObject.isDirectory())
        {
          bool = a(localObject.getAbsolutePath(), paramString2);
          if (bool)
          {
            QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
            bool = true;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
        bool = true;
      }
    }
    return bool;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(PortalUtils.a(paramString1)))
      {
        QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. check md5 failed. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
        return false;
      }
      return true;
    }
    QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. file is not exist. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
    return false;
  }
  
  /* Error */
  public int a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 26
    //   5: invokevirtual 32	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   8: ifeq +15 -> 23
    //   11: aload_2
    //   12: aload_3
    //   13: invokestatic 157	com/tencent/mobileqq/ar/ArSDK2NativeSoLoader:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: istore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 4
    //   22: ireturn
    //   23: aload_1
    //   24: ldc 44
    //   26: invokevirtual 32	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   29: ifeq +13 -> 42
    //   32: aload_2
    //   33: aload_3
    //   34: invokestatic 158	com/tencent/mobileqq/ar/ArCloudNativeSoLoader:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: istore 4
    //   39: goto -21 -> 18
    //   42: iconst_m1
    //   43: istore 4
    //   45: goto -27 -> 18
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	ArNativeSoManager
    //   0	53	1	paramString1	String
    //   0	53	2	paramString2	String
    //   0	53	3	paramString3	String
    //   16	28	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	18	48	finally
    //   23	39	48	finally
  }
  
  public void a(ArrayList paramArrayList, String paramString, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    boolean bool = false;
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadArNativeSo. resName = " + paramString);
    String str = a(paramString);
    a(paramString, paramARResourceDownloadCallback);
    Object localObject1 = new ARCommonConfigInfo.NativeSoRes();
    int i = 0;
    Object localObject2;
    if (i < paramArrayList.size())
    {
      localObject2 = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
      if ((((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject2).b.equalsIgnoreCase(str)))
      {
        paramArrayList = (ArrayList)localObject2;
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload != null))
      {
        localObject1 = ArNativeSoLoaderBase.a(paramArrayList.jdField_a_of_type_JavaLangString, paramArrayList.b, paramArrayList.d) + File.separator + paramArrayList.d + ".zip";
        if (!b((String)localObject1, paramArrayList.d))
        {
          a((String)localObject1);
          if ((!TextUtils.isEmpty(paramArrayList.c)) && (!TextUtils.isEmpty(paramArrayList.d)))
          {
            localObject2 = new ARPreSoResourceDownload.DownloadInfo();
            ((ARPreSoResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 5;
            ((ARPreSoResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = paramArrayList.c;
            ((ARPreSoResourceDownload.DownloadInfo)localObject2).b = paramArrayList.d;
            ((ARPreSoResourceDownload.DownloadInfo)localObject2).d = paramArrayList.jdField_a_of_type_JavaLangString;
            ((ARPreSoResourceDownload.DownloadInfo)localObject2).c = ((String)localObject1);
            ((ARPreSoResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload.a((ARPreSoResourceDownload.DownloadInfo)localObject2, new zxz(this, paramString, paramARResourceDownloadCallback));
          }
        }
      }
      label370:
      while (paramARResourceDownloadCallback == null)
      {
        do
        {
          do
          {
            do
            {
              return;
              i += 1;
              break;
              QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + (String)localObject1);
            } while (paramARResourceDownloadCallback == null);
            paramARResourceDownloadCallback.a(false, null);
            return;
            if (a(paramString)) {
              break label370;
            }
            i = a(paramString, (String)localObject1, paramArrayList.d);
          } while (paramARResourceDownloadCallback == null);
          if (i == 0) {
            bool = true;
          }
          paramARResourceDownloadCallback.a(bool, null);
          return;
        } while (paramARResourceDownloadCallback == null);
        paramARResourceDownloadCallback.a(true, null);
        return;
      }
      paramARResourceDownloadCallback.a(false, null);
      return;
      i = 0;
      paramArrayList = (ArrayList)localObject1;
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. resName = " + paramString);
    String str1 = a(paramString);
    int i = 0;
    if (i < paramArrayList2.size())
    {
      ARCommonConfigInfo.NativeSoRes localNativeSoRes = (ARCommonConfigInfo.NativeSoRes)paramArrayList2.get(i);
      String str2;
      if (localNativeSoRes.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
        if (localNativeSoRes.b.equalsIgnoreCase(str1))
        {
          str2 = ArNativeSoLoaderBase.a(localNativeSoRes.jdField_a_of_type_JavaLangString, localNativeSoRes.b, localNativeSoRes.d) + File.separator + localNativeSoRes.d + ".zip";
          if (!b(str2, localNativeSoRes.d))
          {
            a(str2);
            if ((!TextUtils.isEmpty(localNativeSoRes.c)) && (!TextUtils.isEmpty(localNativeSoRes.d)))
            {
              int j = 0;
              while (j < paramArrayList1.size())
              {
                localObject = (ARCommonConfigInfo.NativeSoRes)paramArrayList1.get(j);
                if ((((ARCommonConfigInfo.NativeSoRes)localObject).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject).b.equalsIgnoreCase(str1))) {
                  a(ArNativeSoLoaderBase.a(((ARCommonConfigInfo.NativeSoRes)localObject).jdField_a_of_type_JavaLangString), ArNativeSoLoaderBase.a(((ARCommonConfigInfo.NativeSoRes)localObject).jdField_a_of_type_JavaLangString, ((ARCommonConfigInfo.NativeSoRes)localObject).b, ((ARCommonConfigInfo.NativeSoRes)localObject).d));
                }
                j += 1;
              }
              Object localObject = new ARPreSoResourceDownload.DownloadInfo();
              ((ARPreSoResourceDownload.DownloadInfo)localObject).jdField_a_of_type_Int = 5;
              ((ARPreSoResourceDownload.DownloadInfo)localObject).jdField_a_of_type_JavaLangString = localNativeSoRes.c;
              ((ARPreSoResourceDownload.DownloadInfo)localObject).b = localNativeSoRes.d;
              ((ARPreSoResourceDownload.DownloadInfo)localObject).d = localNativeSoRes.jdField_a_of_type_JavaLangString;
              ((ARPreSoResourceDownload.DownloadInfo)localObject).c = str2;
              ((ARPreSoResourceDownload.DownloadInfo)localObject).jdField_a_of_type_Boolean = true;
              a(localNativeSoRes, (ARPreSoResourceDownload.DownloadInfo)localObject);
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + str2);
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soRes exists, not need to download. soZipFilename = " + str2);
        if (a(paramString, str2, localNativeSoRes.d) == 0)
        {
          continue;
          QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResVersion is not need to download. soResName = " + localNativeSoRes.jdField_a_of_type_JavaLangString + ", soResVersionFromConfig = " + localNativeSoRes.b + ", soResVersionFromLocal = " + str1);
          continue;
          QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResName is not need to download. soResName = " + localNativeSoRes.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public boolean a(ArrayList paramArrayList, String paramString)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "isArNativeSoDownload. resName = " + paramString);
    String str = a(paramString);
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        ARCommonConfigInfo.NativeSoRes localNativeSoRes = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
        if ((!localNativeSoRes.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) || (!localNativeSoRes.b.equalsIgnoreCase(str))) {
          break label154;
        }
        paramArrayList = ArNativeSoLoaderBase.a(localNativeSoRes.jdField_a_of_type_JavaLangString, localNativeSoRes.b, localNativeSoRes.d) + File.separator + localNativeSoRes.d + ".zip";
        if (!b(paramArrayList, localNativeSoRes.d)) {
          a(paramArrayList);
        }
      }
      else
      {
        return false;
      }
      return a(paramString);
      label154:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoManager
 * JD-Core Version:    0.7.0.1
 */