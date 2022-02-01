package com.tencent.biz.qcircleshadow.remoteCheck;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class QCirclePluginDownloadManager$1
  implements Downloader.DownloadListener
{
  QCirclePluginDownloadManager$1(QCirclePluginDownloadManager paramQCirclePluginDownloadManager, QCirclePluginDownloadManager.DownloadEnty paramDownloadEnty) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager, false);
    if (QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).size() > 0)
    {
      QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = (QCirclePluginDownloadManager.DownloadEnty)QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).get(0);
      QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).remove(0);
      QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager, localDownloadEnty);
    }
    if (this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a != null) {
      this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager, false);
    if (QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).size() > 0)
    {
      QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = (QCirclePluginDownloadManager.DownloadEnty)QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).get(0);
      QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).remove(0);
      QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager, localDownloadEnty);
    }
    if (this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a != null) {
      this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a != null) {
      this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager, false);
    if (QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).size() > 0)
    {
      QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = (QCirclePluginDownloadManager.DownloadEnty)QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).get(0);
      QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager).remove(0);
      QCirclePluginDownloadManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager, localDownloadEnty);
    }
    if (this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a != null) {
      this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginDownloadManager$DownloadEnty.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */