package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnAudioDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ApolloResDownloaderImpl$6
  extends DownloadListener
{
  ApolloResDownloaderImpl$6(ApolloResDownloaderImpl paramApolloResDownloaderImpl, int paramInt, IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnAudioDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnAudioDownloadListener.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + paramDownloadTask.a());
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnAudioDownloadListener == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnAudioDownloadListener.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.6
 * JD-Core Version:    0.7.0.1
 */