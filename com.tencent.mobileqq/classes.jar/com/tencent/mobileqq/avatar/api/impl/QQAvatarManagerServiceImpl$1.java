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
    if ((this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.FaceObserver)) {
      QQAvatarManagerServiceImpl.access$300(this.this$0, this.jdField_a_of_type_Int, (FaceDrawableImpl.FaceObserver)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfJavaLangObject);
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.DisFaceObserver))
      {
        QQAvatarManagerServiceImpl.access$400(this.this$0, this.jdField_a_of_type_Int, (FaceDrawableImpl.DisFaceObserver)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfJavaLangObject);
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    QQAvatarManagerServiceImpl.access$500(this.this$0, this.jdField_a_of_type_Int, (FaceDrawableImpl.NewTroopFaceObserver)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */