package com.tencent.mobileqq.app.face;

import com.tencent.qphone.base.util.QLog;

public class FaceDrawableImpl$InternalGroupObserver
  implements FaceDrawableImpl.NewTroopFaceObserver
{
  public String discussionUin;
  
  FaceDrawableImpl$InternalGroupObserver(FaceDrawableImpl paramFaceDrawableImpl, FaceDrawable paramFaceDrawable)
  {
    if ((paramFaceDrawable != null) && (paramFaceDrawable.mFaceInfo != null)) {
      this.discussionUin = paramFaceDrawable.mFaceInfo.a;
    }
  }
  
  public void onUpdateGroupFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      this.this$0.onUpdateHead(paramBoolean1, 113, paramString, this.this$0.mGroupObserver);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateGroupFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113);
      }
      return;
      this.this$0.onUpdateHead(paramBoolean1, 113, paramString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalGroupObserver
 * JD-Core Version:    0.7.0.1
 */