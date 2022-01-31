package com.tencent.biz.pubaccount.util;

import com.tencent.image.URLDrawableHandler;

public class PubAccountHttpDownloader$PubAccoutImageReporter$WrapURLDrawableHandler
  implements URLDrawableHandler
{
  private PubAccountHttpDownloader.PubAccoutImageReporter jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader$PubAccoutImageReporter;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public PubAccountHttpDownloader$PubAccoutImageReporter$WrapURLDrawableHandler(URLDrawableHandler paramURLDrawableHandler, PubAccountHttpDownloader.PubAccoutImageReporter paramPubAccoutImageReporter)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
    this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader$PubAccoutImageReporter = paramPubAccoutImageReporter;
  }
  
  public PubAccountHttpDownloader.PubAccoutImageReporter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader$PubAccoutImageReporter;
  }
  
  public void doCancel()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.doCancel();
  }
  
  public boolean isCancelled()
  {
    return this.jdField_a_of_type_ComTencentImageURLDrawableHandler.isCancelled();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader$PubAccoutImageReporter.a(false, paramInt);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramInt);
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader$PubAccoutImageReporter.b();
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadStarted();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilPubAccountHttpDownloader$PubAccoutImageReporter.a(true, 0);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadSucceed(paramLong);
  }
  
  public void publishProgress(int paramInt)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.publishProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PubAccountHttpDownloader.PubAccoutImageReporter.WrapURLDrawableHandler
 * JD-Core Version:    0.7.0.1
 */