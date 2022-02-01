package com.tencent.av.avgesture;

import java.util.Timer;
import java.util.TimerTask;

class AVCosUpload$UploadTimerTask
  extends TimerTask
{
  AVCosUpload$UploadTimerTask(AVCosUpload paramAVCosUpload) {}
  
  public void run()
  {
    AVCosUpload localAVCosUpload = this.this$0;
    localAVCosUpload.IsUploading = false;
    AVCosUpload.access$200(localAVCosUpload).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avgesture.AVCosUpload.UploadTimerTask
 * JD-Core Version:    0.7.0.1
 */