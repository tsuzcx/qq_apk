package com.tencent.mobileqq.apollo.res.api.impl;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.res.api.IApolloDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileDownloadFailedException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

public class ApolloDownloaderImpl
  extends AbsDownloader
  implements IApolloDownloader
{
  public static final String TAG = "[cmshow]ApolloDownloader";
  protected BaseApplicationImpl application = BaseApplicationImpl.getApplication();
  private BitmapFactory.Options mOptions = new BitmapFactory.Options();
  
  public ApolloDownloaderImpl()
  {
    BitmapFactory.Options localOptions = this.mOptions;
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = this.application.getResources().getDisplayMetrics().densityDpi;
    this.mOptions.inScreenDensity = this.application.getResources().getDisplayMetrics().densityDpi;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null) {
      return new File(AppConstants.SDCARD_PATH);
    }
    paramURLDrawableHandler = paramDownloadParams.getHeader("apollo_tasks");
    if (paramURLDrawableHandler == null) {
      return new File(AppConstants.SDCARD_PATH);
    }
    paramOutputStream = paramDownloadParams.getHeader("apollo_uin");
    if (paramOutputStream != null) {
      paramOutputStream = paramOutputStream.getValue();
    } else {
      paramOutputStream = "";
    }
    Object localObject;
    int i;
    try
    {
      if (this.application != null) {
        paramOutputStream = (AppInterface)this.application.getAppRuntime(paramOutputStream);
      } else {
        paramOutputStream = null;
      }
    }
    catch (Throwable paramOutputStream)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception:");
      ((StringBuilder)localObject).append(paramOutputStream.getMessage());
      QLog.e("[cmshow]ApolloDownloader", 1, ((StringBuilder)localObject).toString());
      paramOutputStream = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      } else {
        i = 0;
      }
      localObject = paramOutputStream.getSharedPreferences("Last_Login", i).getString("uin", "");
      paramOutputStream = this.application;
      if (paramOutputStream != null) {
        paramOutputStream = (AppInterface)paramOutputStream.getAppRuntime((String)localObject);
      } else {
        paramOutputStream = null;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("a second time: uin->");
        localStringBuilder.append((String)localObject);
        QLog.d("[cmshow]ApolloDownloader", 2, localStringBuilder.toString());
      }
    }
    if (paramOutputStream != null)
    {
      localObject = (ApolloManagerServiceImpl)paramOutputStream.getRuntimeService(IApolloManagerService.class, "all");
      i = Integer.parseInt(paramURLDrawableHandler.getValue());
      if (i == 0)
      {
        paramOutputStream = (ApolloActionPackage)paramDownloadParams.tag;
        if (paramOutputStream == null) {
          return null;
        }
        if (ApolloUtilImpl.isTabExist(paramOutputStream))
        {
          if (QLog.isColorLevel())
          {
            paramDownloadParams = new StringBuilder();
            paramDownloadParams.append("packageTab is exist pid=");
            paramDownloadParams.append(paramOutputStream.packageId);
            QLog.d("[cmshow]ApolloDownloader", 2, paramDownloadParams.toString());
          }
          return ((ApolloManagerServiceImpl)localObject).getTabFile(paramOutputStream);
        }
        if (((ApolloManagerServiceImpl)localObject).downloadActionPackageTab(paramOutputStream)) {
          return ((ApolloManagerServiceImpl)localObject).getTabFile(paramOutputStream);
        }
        throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
      }
      paramDownloadParams = (ApolloActionData)paramDownloadParams.tag;
      if (paramDownloadParams == null) {
        return null;
      }
      if ((((ApolloManagerServiceImpl)localObject).isPlayerAction(paramDownloadParams)) && (((ApolloManagerServiceImpl)localObject).isCMSPanelPicExists(paramDownloadParams)))
      {
        QLog.d("[cmshow]ApolloDownloader", 2, "[cmshow]ApolloDownloader isCMSPanelPicExists, return");
        return new File(((ApolloManagerServiceImpl)localObject).getPanelPicPath(paramDownloadParams));
      }
      paramOutputStream = (ApolloResManagerImpl)paramOutputStream.getRuntimeService(IApolloResManager.class, "all");
      if (ApolloUtilImpl.isResExist(paramDownloadParams, i))
      {
        if (QLog.isColorLevel())
        {
          paramOutputStream = new StringBuilder();
          paramOutputStream.append("actionRes is exist aid=");
          paramOutputStream.append(paramDownloadParams.actionId);
          QLog.d("[cmshow]ApolloDownloader", 2, paramOutputStream.toString());
        }
        return ((ApolloManagerServiceImpl)localObject).getResFile(paramDownloadParams, i);
      }
      if (paramOutputStream.downloadApolloRes(paramDownloadParams, i, null)) {
        return ((ApolloManagerServiceImpl)localObject).getResFile(paramDownloadParams, i);
      }
      throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
    }
    QLog.e("[cmshow]ApolloDownloader", 1, "downloadImage app is null");
    throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */