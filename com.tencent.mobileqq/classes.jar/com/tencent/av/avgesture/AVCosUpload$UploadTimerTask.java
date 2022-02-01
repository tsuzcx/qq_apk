package com.tencent.av.avgesture;

import java.util.Timer;
import java.util.TimerTask;

class AVCosUpload$UploadTimerTask
  extends TimerTask
{
  AVCosUpload$UploadTimerTask(AVCosUpload paramAVCosUpload) {}
  
  public void run()
  {
    this.this$0.IsUploading = false;
    AVCosUpload.access$200(this.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.avgesture.AVCosUpload.UploadTimerTask
 * JD-Core Version:    0.7.0.1
 */