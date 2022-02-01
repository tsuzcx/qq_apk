package com.tencent.biz.pubaccount.readinjoy.download;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;

public class ReadInJoyDownloader
{
  private static volatile ReadInJoyDownloader jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadReadInJoyDownloader;
  private final DownloadListenerDelegate jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadDownloadListenerDelegate = new DownloadListenerDelegate();
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  
  private ReadInJoyDownloader()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadDownloadListenerDelegate);
  }
  
  public static ReadInJoyDownloader a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadReadInJoyDownloader != null) {
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadReadInJoyDownloader;
    }
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadReadInJoyDownloader == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadReadInJoyDownloader = new ReadInJoyDownloader();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadReadInJoyDownloader;
    }
    finally {}
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDownloadDownloadListenerDelegate.a(paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader
 * JD-Core Version:    0.7.0.1
 */