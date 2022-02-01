package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;

public class GdtAppOpenUtil
{
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramContext = DownloadManagerV2.a().b(paramString2);
      if (paramContext == null)
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("isPkgDownloading pkg:");
          paramContext.append(paramString1);
          paramContext.append(", apkUrlhttp :");
          paramContext.append(paramString2);
          paramContext.append(" false");
          QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
        }
        return -1;
      }
      if (paramContext.a() == 2)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isPkgDownloading pkg:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(", apkUrlhttp :");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" true");
          QLog.d("GdtAppOpenUtil", 2, localStringBuilder.toString());
        }
        return paramContext.t;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isPkgDownloading pkg:");
        paramContext.append(paramString1);
        paramContext.append(", apkUrlhttp :");
        paramContext.append(paramString2);
        paramContext.append(" false");
        QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
      }
      return -1;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isPkgDownloading pkg:");
      paramContext.append(paramString1);
      paramContext.append(", apkUrlhttp :");
      paramContext.append(paramString2);
      paramContext.append(" false");
      QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
    }
    return -1;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append(" packageName:");
        paramContext.append(paramString);
        QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
      }
      DownloadInfo localDownloadInfo = DownloadManagerV2.a().c(paramString);
      if (localDownloadInfo == null)
      {
        QLog.e("GdtAppOpenUtil", 2, " DownloadInfo == null");
        return false;
      }
      Object localObject = "";
      if (!TextUtils.isEmpty(localDownloadInfo.q))
      {
        paramContext = localDownloadInfo.q;
      }
      else
      {
        int i = localDownloadInfo.o;
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
        if (i == 0)
        {
          localTMAssistantDownloadTaskInfo2 = DownloadManagerV2.a().g(localDownloadInfo.d);
          paramContext = (Context)localObject;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            paramContext = (Context)localObject;
            if (localTMAssistantDownloadTaskInfo2.mState == 4) {
              paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
            }
          }
          localObject = paramContext;
          if (TextUtils.isEmpty(paramContext))
          {
            localTMAssistantDownloadTaskInfo1 = DownloadManagerV2.a().c(localDownloadInfo);
            localObject = paramContext;
          }
        }
        else
        {
          localTMAssistantDownloadTaskInfo2 = DownloadManagerV2.a().c(localDownloadInfo);
          paramContext = (Context)localObject;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            paramContext = (Context)localObject;
            if (localTMAssistantDownloadTaskInfo2.mState == 4) {
              paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
            }
          }
          localObject = paramContext;
          if (TextUtils.isEmpty(paramContext))
          {
            localTMAssistantDownloadTaskInfo1 = DownloadManagerV2.a().g(localDownloadInfo.d);
            localObject = paramContext;
          }
        }
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo1 != null)
        {
          paramContext = (Context)localObject;
          if (localTMAssistantDownloadTaskInfo1.mState == 4) {
            paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
          }
        }
        if (!TextUtils.isEmpty(paramContext))
        {
          localDownloadInfo.q = paramContext;
          localDownloadInfo.a(4);
          DownloadManagerV2.a().e(localDownloadInfo);
        }
      }
      boolean bool1 = bool3;
      if (!TextUtils.isEmpty(paramContext))
      {
        bool1 = bool3;
        if (new File(paramContext).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isPkgExist(");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(")  packageName:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", path:");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("GdtAppOpenUtil", 2, ((StringBuilder)localObject).toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    int j = -1;
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return -1;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        paramContext = DownloadManagerV2.a().b(paramString2);
        if (paramContext == null)
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("isPkgDownloading pkg:");
            paramContext.append(paramString1);
            paramContext.append(", apkUrlhttp :");
            paramContext.append(paramString2);
            paramContext.append(" false");
            QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
          }
          return -1;
        }
        if (paramContext.a() == 3)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isPkgDownloading pkg:");
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", apkUrlhttp :");
            localStringBuilder.append(paramString2);
            localStringBuilder.append(" true");
            QLog.d("GdtAppOpenUtil", 2, localStringBuilder.toString());
          }
          int i = j;
          if (!TextUtils.isEmpty(paramContext.q))
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramContext.q);
            paramString1.append(".temp");
            i = j;
            if (new File(paramString1.toString()).exists()) {
              i = paramContext.t;
            }
          }
          return i;
        }
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("isPkgDownloading pkg:");
          paramContext.append(paramString1);
          paramContext.append(", apkUrlhttp :");
          paramContext.append(paramString2);
          paramContext.append(" false");
          QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
        }
        return -1;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isPkgDownloading pkg:");
        paramContext.append(paramString1);
        paramContext.append(", apkUrlhttp :");
        paramContext.append(paramString2);
        paramContext.append(" false");
        QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
      }
    }
    return -1;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append(" apkUrlhttp :");
        paramContext.append(paramString);
        QLog.d("GdtAppOpenUtil", 2, paramContext.toString());
      }
      DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(paramString);
      if (localDownloadInfo == null) {
        return false;
      }
      Object localObject = "";
      if (!TextUtils.isEmpty(localDownloadInfo.q))
      {
        paramContext = localDownloadInfo.q;
      }
      else
      {
        int i = localDownloadInfo.o;
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
        if (i == 0)
        {
          localTMAssistantDownloadTaskInfo2 = DownloadManagerV2.a().g(localDownloadInfo.d);
          paramContext = (Context)localObject;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            paramContext = (Context)localObject;
            if (localTMAssistantDownloadTaskInfo2.mState == 4) {
              paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
            }
          }
          localObject = paramContext;
          if (TextUtils.isEmpty(paramContext))
          {
            localTMAssistantDownloadTaskInfo1 = DownloadManagerV2.a().c(localDownloadInfo);
            localObject = paramContext;
          }
        }
        else
        {
          localTMAssistantDownloadTaskInfo2 = DownloadManagerV2.a().c(localDownloadInfo);
          paramContext = (Context)localObject;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            paramContext = (Context)localObject;
            if (localTMAssistantDownloadTaskInfo2.mState == 4) {
              paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
            }
          }
          localObject = paramContext;
          if (TextUtils.isEmpty(paramContext))
          {
            localTMAssistantDownloadTaskInfo1 = DownloadManagerV2.a().g(localDownloadInfo.d);
            localObject = paramContext;
          }
        }
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo1 != null)
        {
          paramContext = (Context)localObject;
          if (localTMAssistantDownloadTaskInfo1.mState == 4) {
            paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
          }
        }
        if (!TextUtils.isEmpty(paramContext))
        {
          localDownloadInfo.q = paramContext;
          localDownloadInfo.a(4);
          DownloadManagerV2.a().e(localDownloadInfo);
        }
      }
      boolean bool1 = bool3;
      if (!TextUtils.isEmpty(paramContext))
      {
        bool1 = bool3;
        if (new File(paramContext).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isPkgExist(");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(")  apkUrlhttp :");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", path:");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("GdtAppOpenUtil", 2, ((StringBuilder)localObject).toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static int c(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return -1;
      }
      paramContext = DownloadManagerV2.a().b(paramString2);
      if (paramContext == null) {
        return -1;
      }
      if ((paramContext.a() != 2) && (paramContext.a() != 3)) {
        return -1;
      }
      return paramContext.t;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtAppOpenUtil
 * JD-Core Version:    0.7.0.1
 */