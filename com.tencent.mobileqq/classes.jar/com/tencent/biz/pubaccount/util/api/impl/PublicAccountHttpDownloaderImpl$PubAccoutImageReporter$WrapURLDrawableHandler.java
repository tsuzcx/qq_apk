package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.RIJImageRequestHandler;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class PublicAccountHttpDownloaderImpl$PubAccoutImageReporter$WrapURLDrawableHandler
  implements URLDrawableHandler
{
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  private PublicAccountHttpDownloaderImpl.PubAccoutImageReporter b;
  
  public PublicAccountHttpDownloaderImpl$PubAccoutImageReporter$WrapURLDrawableHandler(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter paramPubAccoutImageReporter1, URLDrawableHandler paramURLDrawableHandler, PublicAccountHttpDownloaderImpl.PubAccoutImageReporter paramPubAccoutImageReporter2)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
    this.b = paramPubAccoutImageReporter2;
  }
  
  public PublicAccountHttpDownloaderImpl.PubAccoutImageReporter a()
  {
    return this.b;
  }
  
  protected void a()
  {
    QLog.d(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountHttpDownloaderImpl$PubAccoutImageReporter), 1, "image download start: " + PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountHttpDownloaderImpl$PubAccoutImageReporter) + " supportInnerIp: " + PublicAccountHttpDownloaderImpl.access$400(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountHttpDownloaderImpl$PubAccoutImageReporter.a));
    if (PublicAccountHttpDownloaderImpl.access$500(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountHttpDownloaderImpl$PubAccoutImageReporter.a))
    {
      Object localObject1 = InnerDns.getHostFromUrl(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountHttpDownloaderImpl$PubAccoutImageReporter));
      Object localObject2 = InnerDns.getInstance().reqSerAddrList((String)localObject1, 1002);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject1 = new StringBuilder();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append(((ServerAddr)((Iterator)localObject2).next()).toString()).append(" ");
        }
        QLog.d(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountHttpDownloaderImpl$PubAccoutImageReporter), 1, "InnerIp address " + localObject1);
      }
    }
    else
    {
      return;
    }
    QLog.d(PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountHttpDownloaderImpl$PubAccoutImageReporter), 1, "InnerIp address empty");
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawableHandler instanceof RunningJob.RIJImageRequestHandler)) {
      ((RunningJob.RIJImageRequestHandler)this.jdField_a_of_type_ComTencentImageURLDrawableHandler).a(paramString);
    }
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
    this.b.a(false, paramInt);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramInt);
  }
  
  public void onFileDownloadStarted()
  {
    this.b.b();
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadStarted();
    a();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.b.a(true, 0);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadSucceed(paramLong);
  }
  
  public void publishProgress(int paramInt)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.publishProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler
 * JD-Core Version:    0.7.0.1
 */