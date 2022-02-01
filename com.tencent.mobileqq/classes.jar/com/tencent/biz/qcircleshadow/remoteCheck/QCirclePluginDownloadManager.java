package com.tencent.biz.qcircleshadow.remoteCheck;

import android.content.Context;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;
import mqq.app.MobileQQ;

public class QCirclePluginDownloadManager
{
  private static QCirclePluginDownloadManager jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager;
  private Context jdField_a_of_type_AndroidContentContext = MobileQQ.sMobileQQ;
  private QCirclePluginDownloadManager.DownloadEnty jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = null;
  private Vector<QCirclePluginDownloadManager.DownloadEnty> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean;
  
  public static QCirclePluginDownloadManager a()
  {
    if (jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager == null) {
      try
      {
        jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager = new QCirclePluginDownloadManager();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager;
  }
  
  private Downloader a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
        return localObject1;
      }
      Object localObject1 = null;
      try
      {
        Downloader localDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
        localObject1 = localDownloader;
        localDownloader.enableResumeTransfer();
        localObject1 = localDownloader;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = ((Downloader)localObject1);
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
        return localObject1;
      }
      throw new RuntimeException("no downloader available");
    }
    finally {}
  }
  
  private boolean a(QCirclePluginDownloadManager.DownloadEnty paramDownloadEnty)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (paramDownloadEnty.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilVector.add(0, paramDownloadEnty);
        } else {
          this.jdField_a_of_type_JavaUtilVector.add(paramDownloadEnty);
        }
        return true;
      }
      if (paramDownloadEnty.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest != null)
      {
        if (a().download(paramDownloadEnty.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest, paramDownloadEnty.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty = paramDownloadEnty;
          this.jdField_a_of_type_Boolean = true;
          return true;
        }
        return false;
      }
      if (a().download(paramDownloadEnty.jdField_b_of_type_JavaLangString, paramDownloadEnty.jdField_a_of_type_JavaLangString, paramDownloadEnty.jdField_b_of_type_Boolean, paramDownloadEnty.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener))
      {
        this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty = paramDownloadEnty;
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public final boolean a(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, false, false, paramDownloadListener);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DownloadRequest paramDownloadRequest, Downloader.DownloadListener paramDownloadListener)
  {
    QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = new QCirclePluginDownloadManager.DownloadEnty(this);
    localDownloadEnty.jdField_a_of_type_JavaLangString = paramString2;
    localDownloadEnty.jdField_b_of_type_JavaLangString = paramString1;
    localDownloadEnty.jdField_b_of_type_Boolean = paramBoolean1;
    localDownloadEnty.jdField_a_of_type_Boolean = paramBoolean2;
    localDownloadEnty.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = paramDownloadListener;
    localDownloadEnty.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new QCirclePluginDownloadManager.1(this, localDownloadEnty);
    if (paramDownloadRequest != null)
    {
      paramDownloadRequest.setListener(localDownloadEnty.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      localDownloadEnty.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest = paramDownloadRequest;
    }
    return a(localDownloadEnty);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, null, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginDownloadManager
 * JD-Core Version:    0.7.0.1
 */