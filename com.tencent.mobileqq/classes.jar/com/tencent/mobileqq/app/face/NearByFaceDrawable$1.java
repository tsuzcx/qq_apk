package com.tencent.mobileqq.app.face;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class NearByFaceDrawable$1
  extends FaceObserver
{
  NearByFaceDrawable$1(NearByFaceDrawable paramNearByFaceDrawable) {}
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateStrangerHead.faceInfo=");
      ((StringBuilder)localObject).append(paramFaceInfo);
      ((StringBuilder)localObject).append(", isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.a.mCancelled) && (this.a.mFaceInfo != null))
    {
      if (paramFaceInfo == null) {
        return;
      }
      if (paramFaceInfo.d == this.a.mFaceInfo.d)
      {
        if (!this.a.mFaceInfo.c.equals(paramFaceInfo.c)) {
          return;
        }
        if ((this.a.b != null) && (this.a.a != null)) {
          this.a.a.removeObserver(this.a.b);
        }
        if (paramBoolean)
        {
          paramFaceInfo = this.a.getBitmapFromCache();
          if (paramFaceInfo != null)
          {
            localObject = this.a;
            ((NearByFaceDrawable)localObject).onDecodeTaskCompleted(((NearByFaceDrawable)localObject).mFaceInfo, paramFaceInfo);
            return;
          }
          this.a.requestDecode();
          return;
        }
        paramFaceInfo = this.a;
        paramFaceInfo.onDecodeTaskCompleted(paramFaceInfo.mFaceInfo, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearByFaceDrawable.1
 * JD-Core Version:    0.7.0.1
 */