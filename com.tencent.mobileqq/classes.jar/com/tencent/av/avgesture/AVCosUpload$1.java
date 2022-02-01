package com.tencent.av.avgesture;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

class AVCosUpload$1
  implements Runnable
{
  AVCosUpload$1(AVCosUpload paramAVCosUpload, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, AVCosUpload.UploadFileListener paramUploadFileListener) {}
  
  public void run()
  {
    try
    {
      String str1 = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.val$gestureType);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(UUID.randomUUID().toString());
      ((StringBuilder)localObject).append(".jpeg");
      str1 = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.val$srcPath);
      ((StringBuilder)localObject).append(str1);
      localObject = ((StringBuilder)localObject).toString();
      if (AVCosUpload.access$000(this.this$0, (String)localObject, this.val$rgba, this.val$imageWidth, this.val$imageHeight))
      {
        if (AVGestureWrapper.mReport != null) {
          AVGestureWrapper.mReport.avGestureUploadReport("0X800839B", "0");
        }
        String str2 = AVGestureWrapper.getMultiSign("", "", "", "");
        AVCosUpload.access$100(this.this$0, (String)localObject, this.val$gestureType, str1, "", str2, 20971520, this.val$monitor);
        this.this$0.startUploadTimer(3);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("uploadFile", localException.toString());
      this.val$monitor.onCompleted(8193, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avgesture.AVCosUpload.1
 * JD-Core Version:    0.7.0.1
 */