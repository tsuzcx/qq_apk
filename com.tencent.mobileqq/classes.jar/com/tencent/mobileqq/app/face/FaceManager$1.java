package com.tencent.mobileqq.app.face;

import anho;

public class FaceManager$1
  implements Runnable
{
  public FaceManager$1(anho paramanho, Object paramObject, int paramInt, boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.FaceObserver)) {
      anho.a(this.this$0, this.jdField_a_of_type_Int, (FaceDrawableImpl.FaceObserver)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfJavaLangObject);
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.DisFaceObserver))
      {
        anho.a(this.this$0, this.jdField_a_of_type_Int, (FaceDrawableImpl.DisFaceObserver)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfJavaLangObject);
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    anho.a(this.this$0, this.jdField_a_of_type_Int, (FaceDrawableImpl.NewTroopFaceObserver)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceManager.1
 * JD-Core Version:    0.7.0.1
 */