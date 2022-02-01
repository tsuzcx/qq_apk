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
      str1 = this.val$gestureType + "_" + str1 + "_" + UUID.randomUUID().toString() + ".jpeg";
      String str2 = this.val$srcPath + str1;
      if (AVCosUpload.access$000(this.this$0, str2, this.val$rgba, this.val$imageWidth, this.val$imageHeight))
      {
        if (AVGestureWrapper.mReport != null) {
          AVGestureWrapper.mReport.avGestureUploadReport("0X800839B", "0");
        }
        String str3 = AVGestureWrapper.getMultiSign("", "", "", "");
        AVCosUpload.access$100(this.this$0, str2, this.val$gestureType, str1, "", str3, 20971520, this.val$monitor);
        this.this$0.startUploadTimer(3);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("uploadFile", localException.toString());
      this.val$monitor.onCompleted(8193, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.avgesture.AVCosUpload.1
 * JD-Core Version:    0.7.0.1
 */