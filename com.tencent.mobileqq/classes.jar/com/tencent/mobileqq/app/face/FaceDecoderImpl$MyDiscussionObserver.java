package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.DiscussionAvatarObserver;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class FaceDecoderImpl$MyDiscussionObserver
  extends DiscussionAvatarObserver
{
  private FaceDecoderImpl$MyDiscussionObserver(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  protected void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoderImpl.access$200(this.this$0) == null) {
      return;
    }
    if (this.this$0.mDecodeTaskCompletionListener != null)
    {
      int i = 101;
      String str;
      if (AvatarUtil.a(paramString))
      {
        str = AvatarUtil.b(paramString);
        i = 1001;
      }
      else
      {
        str = paramString;
      }
      paramString = this.this$0.getBitmapFromCache(i, paramString, 0, (byte)3, 0);
      if ((paramBoolean1) && (paramString != null))
      {
        if (i != 1001) {
          this.this$0.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.this$0.iRunningRequests + this.this$0.mReadyRequests.size(), i, str, paramString);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("====faceDecoderImpl onUpdateDiscussionFaceIcon === isSuccess: ");
          paramString.append(paramBoolean1);
          paramString.append(", isComplete: ");
          paramString.append(paramBoolean2);
          paramString.append(",disUin: ");
          paramString.append(str);
          paramString.append(",type: ");
          paramString.append(i);
          paramString.append(",style: ");
          paramString.append(-1);
          QLog.i("Q.qqhead.FaceDecoderImpl", 2, paramString.toString());
        }
      }
    }
    if ((!this.this$0.mPause) && (!this.this$0.mReadyRequests.isEmpty()) && (this.this$0.iRunningRequests < this.this$0.maxDecodingTask)) {
      this.this$0.runNextTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */