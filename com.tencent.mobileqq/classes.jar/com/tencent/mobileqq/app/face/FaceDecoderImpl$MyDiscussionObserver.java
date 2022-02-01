package com.tencent.mobileqq.app.face;

import amrc;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class FaceDecoderImpl$MyDiscussionObserver
  extends amrc
{
  private FaceDecoderImpl$MyDiscussionObserver(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  public void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoderImpl.access$200(this.this$0) == null) {
      return;
    }
    int i;
    String str;
    if (this.this$0.mDecodeTaskCompletionListener != null)
    {
      i = 101;
      if (!GroupIconHelper.a(paramString)) {
        break label228;
      }
      str = GroupIconHelper.b(paramString);
      i = 1001;
    }
    for (;;)
    {
      paramString = this.this$0.getBitmapFromCache(i, paramString, 0, (byte)3, 0);
      if ((paramBoolean1) && (paramString != null)) {
        if (i != 1001) {
          break label190;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + str + ",type: " + i + ",style: " + -1);
        }
        if ((this.this$0.mPause) || (this.this$0.mReadyRequests.isEmpty()) || (this.this$0.iRunningRequests >= this.this$0.maxDecodingTask)) {
          break;
        }
        this.this$0.runNextTask();
        return;
        label190:
        this.this$0.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.this$0.iRunningRequests + this.this$0.mReadyRequests.size(), i, str, paramString);
      }
      label228:
      str = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */