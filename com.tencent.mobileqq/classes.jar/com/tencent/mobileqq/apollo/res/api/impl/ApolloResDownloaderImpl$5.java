package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnAudioDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ApolloResDownloaderImpl$5
  extends DownloadListener
{
  ApolloResDownloaderImpl$5(ApolloResDownloaderImpl paramApolloResDownloaderImpl, int paramInt, IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 != paramDownloadTask.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadApolloAudio error id->");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" task.getStatus()->");
      localStringBuilder.append(paramDownloadTask.a());
      QLog.e("[cmshow][ApolloResDownloader]", 1, localStringBuilder.toString());
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnAudioDownloadListener;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, this.jdField_a_of_type_Int);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downloadApolloAudio ok id");
      paramDownloadTask.append(this.jdField_a_of_type_Int);
      QLog.d("[cmshow][ApolloResDownloader]", 2, paramDownloadTask.toString());
    }
    paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnAudioDownloadListener;
    if (paramDownloadTask != null) {
      paramDownloadTask.a(true, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl.5
 * JD-Core Version:    0.7.0.1
 */