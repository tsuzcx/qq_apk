package com.tencent.mobileqq.app.face;

import com.tencent.qphone.base.util.QLog;

public class FaceDrawableImpl$InternalDiscussionObserver
  implements FaceDrawableImpl.DisFaceObserver
{
  public String discussionUin;
  
  FaceDrawableImpl$InternalDiscussionObserver(FaceDrawableImpl paramFaceDrawableImpl, FaceDrawable paramFaceDrawable)
  {
    if ((paramFaceDrawable != null) && (paramFaceDrawable.mFaceInfo != null)) {
      this.discussionUin = paramFaceDrawable.mFaceInfo.a;
    }
  }
  
  public void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i;
    if (GroupIconHelper.a(paramString)) {
      i = 1001;
    }
    for (String str = GroupIconHelper.b(paramString);; str = paramString)
    {
      if (paramBoolean2) {
        this.this$0.onUpdateHead(paramBoolean1, i, str, this.this$0.mDisObserver);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + i);
        }
        return;
        this.this$0.onUpdateHead(paramBoolean1, i, str, null);
      }
      i = 101;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */