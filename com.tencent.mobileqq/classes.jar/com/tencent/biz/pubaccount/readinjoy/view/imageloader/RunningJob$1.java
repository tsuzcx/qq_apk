package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport;
import com.tencent.qphone.base.util.QLog;

class RunningJob$1
  implements RunningJob.RIJImageRequestHandler
{
  RunningJob$1(RunningJob paramRunningJob, StringBuilder paramStringBuilder) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.b = paramString;
  }
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    QLog.d(RunningJob.jdField_a_of_type_JavaLangString, 1, "receive image data error: " + paramInt + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.e = paramInt;
  }
  
  public void onFileDownloadStarted()
  {
    RIJImageOptReport.b(3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    RunningJob.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.i = paramLong;
    QLog.d(RunningJob.jdField_a_of_type_JavaLangString, 1, "receive image data success, total size: " + paramLong + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
  }
  
  public void publishProgress(int paramInt)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(System.currentTimeMillis() + " " + paramInt + " ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.1
 * JD-Core Version:    0.7.0.1
 */