package com.tencent.biz.pubaccount.util;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import usq;

public class PubAccountHttpDownloader$1
  implements Runnable
{
  public PubAccountHttpDownloader$1(usq paramusq, OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong) {}
  
  public void run()
  {
    try
    {
      usq.a(this.this$0, this.jdField_a_of_type_JavaIoOutputStream, this.jdField_a_of_type_ComTencentImageDownloadParams, this.jdField_a_of_type_ComTencentImageURLDrawableHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaIoOutputStream != null) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e("PubAccountHttpDownloader", 1, localIOException.getMessage());
      usq.a(this.this$0, this.jdField_a_of_type_ComTencentImageDownloadParams, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b, localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PubAccountHttpDownloader.1
 * JD-Core Version:    0.7.0.1
 */