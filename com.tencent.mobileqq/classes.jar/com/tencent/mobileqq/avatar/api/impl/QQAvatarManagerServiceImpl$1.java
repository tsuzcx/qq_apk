package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.app.face.FaceDrawableImpl.DisFaceObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.NewTroopFaceObserver;

class QQAvatarManagerServiceImpl$1
  implements Runnable
{
  QQAvatarManagerServiceImpl$1(QQAvatarManagerServiceImpl paramQQAvatarManagerServiceImpl, Object paramObject, int paramInt, boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject instanceof FaceDrawableImpl.FaceObserver))
    {
      QQAvatarManagerServiceImpl.access$300(this.this$0, this.b, (FaceDrawableImpl.FaceObserver)localObject, this.c, this.d);
      return;
    }
    if ((localObject instanceof FaceDrawableImpl.DisFaceObserver))
    {
      QQAvatarManagerServiceImpl.access$400(this.this$0, this.b, (FaceDrawableImpl.DisFaceObserver)localObject, this.c, this.d);
      return;
    }
    if ((localObject instanceof FaceDrawableImpl.NewTroopFaceObserver)) {
      QQAvatarManagerServiceImpl.access$500(this.this$0, this.b, (FaceDrawableImpl.NewTroopFaceObserver)localObject, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */