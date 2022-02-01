package com.qflutter.vistaimage;

import android.graphics.drawable.Drawable;
import rx.Subscriber;

class VistaImageTask$1$1
  implements IVistaImage.LoadBitmapCallback
{
  VistaImageTask$1$1(VistaImageTask.1 param1, Subscriber paramSubscriber) {}
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onFailed] url=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString2);
    VistaImageLog.e("VistaImageTask", localStringBuilder.toString());
    paramString1 = new TextureRecord(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_ComQflutterVistaimageVistaImageTask, "-5", "load bitmap error occurred");
    this.jdField_a_of_type_RxSubscriber.onNext(paramString1);
    this.jdField_a_of_type_RxSubscriber.onCompleted();
  }
  
  public void onLoaded(String paramString, Drawable paramDrawable, boolean paramBoolean, IRenderer paramIRenderer)
  {
    if (VistaImageLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadImage] url=");
      localStringBuilder.append(paramString);
      VistaImageLog.d("VistaImageTask", localStringBuilder.toString());
    }
    if (paramDrawable == null) {
      VistaImageLog.e("VistaImageTask", "[loadImage] no bitmap");
    }
    for (paramString = new TextureRecord(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_ComQflutterVistaimageVistaImageTask, "-2", "no bitmap");; paramString = new TextureRecord(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_ComQflutterVistaimageVistaImageTask, VistaImageTask.access$000(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_ComQflutterVistaimageVistaImageTask), VistaImageTask.access$100(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_ComQflutterVistaimageVistaImageTask), VistaImageTask.access$200(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_ComQflutterVistaimageVistaImageTask), this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_Float, VistaImageTask.access$300(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask$1.jdField_a_of_type_ComQflutterVistaimageVistaImageTask), paramBoolean, paramDrawable, paramIRenderer))
    {
      this.jdField_a_of_type_RxSubscriber.onNext(paramString);
      this.jdField_a_of_type_RxSubscriber.onCompleted();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageTask.1.1
 * JD-Core Version:    0.7.0.1
 */