package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.qphone.base.util.QLog;

public class FaceDrawableImpl$InternalDiscussionObserver
  implements FaceDrawableImpl.DisFaceObserver
{
  public String discussionUin;
  
  FaceDrawableImpl$InternalDiscussionObserver(FaceDrawableImpl paramFaceDrawableImpl, FaceDrawable paramFaceDrawable)
  {
    if ((paramFaceDrawable != null) && (paramFaceDrawable.mFaceInfo != null)) {
      this.discussionUin = paramFaceDrawable.mFaceInfo.c;
    }
  }
  
  public void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i;
    Object localObject;
    if (AvatarUtil.b(paramString))
    {
      i = 1001;
      localObject = AvatarUtil.c(paramString);
    }
    else
    {
      i = 101;
      localObject = paramString;
    }
    if (paramBoolean2)
    {
      FaceDrawableImpl localFaceDrawableImpl = this.this$0;
      localFaceDrawableImpl.onUpdateHead(paramBoolean1, i, (String)localObject, localFaceDrawableImpl.mDisObserver);
    }
    else
    {
      this.this$0.onUpdateHead(paramBoolean1, i, (String)localObject, null);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("====faceDrawableImpl onUpdateDiscussionFaceIcon === isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", isComplete: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",disUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",type: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("Q.qqhead.FaceDrawableImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */