package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class PublicAccountHttpDownloaderImpl$1
  implements Runnable
{
  PublicAccountHttpDownloaderImpl$1(PublicAccountHttpDownloaderImpl paramPublicAccountHttpDownloaderImpl, OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong) {}
  
  public void run()
  {
    try
    {
      PublicAccountHttpDownloaderImpl.access$601(this.this$0, this.jdField_a_of_type_JavaIoOutputStream, this.jdField_a_of_type_ComTencentImageDownloadParams, this.jdField_a_of_type_ComTencentImageURLDrawableHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaIoOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoOutputStream.close();
        return;
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("PubAccountHttpDownloader", 1, localIOException.getMessage());
      PublicAccountHttpDownloaderImpl.access$700(this.this$0, this.jdField_a_of_type_ComTencentImageDownloadParams, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b, localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountHttpDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */