package com.tencent.mobileqq.apollo.api.res.impl;

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
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.res.IApolloDownloader;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
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
  public static final String TAG = "ApolloDownloader";
  protected BaseApplicationImpl application = BaseApplicationImpl.getApplication();
  private BitmapFactory.Options mOptions = new BitmapFactory.Options();
  
  public ApolloDownloaderImpl()
  {
    this.mOptions.inDensity = 320;
    this.mOptions.inTargetDensity = this.application.getResources().getDisplayMetrics().densityDpi;
    this.mOptions.inScreenDensity = this.application.getResources().getDisplayMetrics().densityDpi;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int j;
    if (paramDownloadParams != null)
    {
      paramOutputStream = paramDownloadParams.getHeader("apollo_tasks");
      if (paramOutputStream != null)
      {
        j = Integer.parseInt(paramOutputStream.getValue());
        paramURLDrawableHandler = paramDownloadParams.getHeader("apollo_uin");
        paramOutputStream = "";
        if (paramURLDrawableHandler != null) {
          paramOutputStream = paramURLDrawableHandler.getValue();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.application == null) {
          break label497;
        }
        paramOutputStream = (AppInterface)this.application.getAppRuntime(paramOutputStream);
        if (paramOutputStream != null) {
          break label234;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDownloader", 2, "downloadImage app is null");
        }
        throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
      }
      catch (Throwable paramOutputStream)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDownloader", 2, "exception:" + paramOutputStream.getMessage());
        }
        paramOutputStream = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT <= 10) {
          break label228;
        }
      }
      int i = 4;
      label150:
      String str = paramOutputStream.getSharedPreferences("Last_Login", i).getString("uin", "");
      if (this.application != null) {}
      for (paramURLDrawableHandler = (AppInterface)this.application.getAppRuntime(str);; paramURLDrawableHandler = null)
      {
        paramOutputStream = paramURLDrawableHandler;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloDownloader", 2, "a second time: uin->" + str);
        paramOutputStream = paramURLDrawableHandler;
        break;
        label228:
        i = 0;
        break label150;
        label234:
        paramOutputStream = (ApolloManagerServiceImpl)paramOutputStream.getRuntimeService(IApolloManagerService.class, "all");
        if (paramOutputStream != null)
        {
          if (j == 0)
          {
            paramDownloadParams = (ApolloActionPackage)paramDownloadParams.tag;
            if (paramDownloadParams != null) {}
          }
          do
          {
            return null;
            if (ApolloUtilImpl.isTabExist(paramDownloadParams))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloDownloader", 2, "packageTab is exist pid=" + paramDownloadParams.packageId);
              }
              return paramOutputStream.getTabFile(paramDownloadParams);
            }
            if (paramOutputStream.downloadActionPackageTab(paramDownloadParams)) {
              return paramOutputStream.getTabFile(paramDownloadParams);
            }
            throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
            paramDownloadParams = (ApolloActionData)paramDownloadParams.tag;
          } while (paramDownloadParams == null);
          if ((paramOutputStream.isPlayerAction(paramDownloadParams)) && (paramOutputStream.isCMSPanelPicExists(paramDownloadParams)))
          {
            QLog.d("ApolloDownloader", 2, "ApolloDownloader isCMSPanelPicExists, return");
            return new File(paramOutputStream.getPanelPicPath(paramDownloadParams));
          }
          if (ApolloUtilImpl.isResExist(paramDownloadParams, j))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDownloader", 2, "actionRes is exist aid=" + paramDownloadParams.actionId);
            }
            return paramOutputStream.getResFile(paramDownloadParams, j);
          }
          if (paramOutputStream.downloadApolloRes(paramDownloadParams, j, null)) {
            return paramOutputStream.getResFile(paramDownloadParams, j);
          }
          throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        }
        return new File(AppConstants.SDCARD_PATH);
      }
      label497:
      paramOutputStream = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */