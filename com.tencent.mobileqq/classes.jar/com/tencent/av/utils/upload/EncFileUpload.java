package com.tencent.av.utils.upload;

import com.tencent.av.app.VideoAppInterface;

public class EncFileUpload
  extends FileUpload
{
  public EncFileUpload(VideoAppInterface paramVideoAppInterface, long paramLong)
  {
    super(paramVideoAppInterface, 64, paramLong);
  }
  
  public void a(String paramString, FileUpload.UploadCallback paramUploadCallback)
  {
    super.b(paramString, paramUploadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.upload.EncFileUpload
 * JD-Core Version:    0.7.0.1
 */