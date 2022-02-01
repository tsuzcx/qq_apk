package com.tencent.mobileqq.app.face;

import andd;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class FaceDecoderImpl$MyTroopHeaderObserver
  extends andd
{
  private FaceDecoderImpl$MyTroopHeaderObserver(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  public void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoderImpl.access$200(this.this$0) == null) {}
    do
    {
      return;
      if (this.this$0.mDecodeTaskCompletionListener != null)
      {
        Bitmap localBitmap = this.this$0.getBitmapFromCache(113, paramString, 0, (byte)3, 0);
        if ((paramBoolean1) && (localBitmap != null))
        {
          this.this$0.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.this$0.iRunningRequests + this.this$0.mReadyRequests.size(), 113, paramString, localBitmap);
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateNewTroopFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113 + ",style: " + -1);
          }
        }
      }
    } while ((this.this$0.mPause) || (this.this$0.mReadyRequests.isEmpty()) || (this.this$0.iRunningRequests >= this.this$0.maxDecodingTask));
    this.this$0.runNextTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl.MyTroopHeaderObserver
 * JD-Core Version:    0.7.0.1
 */