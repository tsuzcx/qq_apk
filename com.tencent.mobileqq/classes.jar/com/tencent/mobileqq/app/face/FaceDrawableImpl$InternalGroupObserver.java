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
    Object localObject;
    if (paramBoolean2)
    {
      localObject = this.this$0;
      ((FaceDrawableImpl)localObject).onUpdateHead(paramBoolean1, 113, paramString, ((FaceDrawableImpl)localObject).mGroupObserver);
    }
    else
    {
      this.this$0.onUpdateHead(paramBoolean1, 113, paramString, null);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("====faceDrawableImpl onUpdateGroupFaceIcon === isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", isComplete: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",disUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",type: ");
      ((StringBuilder)localObject).append(113);
      QLog.i("Q.qqhead.FaceDrawableImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalGroupObserver
 * JD-Core Version:    0.7.0.1
 */