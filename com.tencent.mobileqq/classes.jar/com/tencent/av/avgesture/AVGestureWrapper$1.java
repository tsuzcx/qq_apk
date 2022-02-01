package com.tencent.av.avgesture;

class AVGestureWrapper$1
  implements AVCosUpload.UploadFileListener
{
  AVGestureWrapper$1(AVGestureWrapper paramAVGestureWrapper) {}
  
  public void onCompleted(int paramInt, String paramString1, String paramString2)
  {
    if (AVGestureWrapper.mReport != null)
    {
      AVGestureWrapper.mReport.avGestureUploadReport("0X80083AD", String.valueOf(paramInt));
      if (paramInt == 0) {
        AVGestureWrapper.mReport.avGestureUploadReport("0X800839C", "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avgesture.AVGestureWrapper.1
 * JD-Core Version:    0.7.0.1
 */