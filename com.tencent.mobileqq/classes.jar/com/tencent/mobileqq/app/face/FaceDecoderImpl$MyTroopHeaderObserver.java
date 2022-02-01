package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class FaceDecoderImpl$MyTroopHeaderObserver
  extends TroopAvatarObserver
{
  private FaceDecoderImpl$MyTroopHeaderObserver(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoderImpl.access$200(this.this$0) == null) {
      return;
    }
    if (this.this$0.mDecodeTaskCompletionListener != null)
    {
      Object localObject = this.this$0.getBitmapFromCache(113, paramString, 0, (byte)3, 0);
      if ((paramBoolean1) && (localObject != null))
      {
        this.this$0.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.this$0.iRunningRequests + this.this$0.mReadyRequests.size(), 113, paramString, (Bitmap)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("====faceDecoderImpl onUpdateNewTroopFaceIcon === isSuccess: ");
          ((StringBuilder)localObject).append(paramBoolean1);
          ((StringBuilder)localObject).append(", isComplete: ");
          ((StringBuilder)localObject).append(paramBoolean2);
          ((StringBuilder)localObject).append(",disUin: ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",type: ");
          ((StringBuilder)localObject).append(113);
          ((StringBuilder)localObject).append(",style: ");
          ((StringBuilder)localObject).append(-1);
          QLog.i("Q.qqhead.FaceDecoderImpl", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if ((!this.this$0.mPause) && (!this.this$0.mReadyRequests.isEmpty()) && (this.this$0.iRunningRequests < this.this$0.maxDecodingTask)) {
      this.this$0.runNextTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl.MyTroopHeaderObserver
 * JD-Core Version:    0.7.0.1
 */