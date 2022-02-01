package com.qflutter.vistaimage;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class VistaImageTask$1
  implements Observable.OnSubscribe<TextureRecord>
{
  VistaImageTask$1(VistaImageTask paramVistaImageTask, IVistaImage paramIVistaImage, float paramFloat) {}
  
  public void a(Subscriber<? super TextureRecord> paramSubscriber)
  {
    this.jdField_a_of_type_ComQflutterVistaimageIVistaImage.loadBitmap(VistaImageTask.access$000(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask), Math.round(VistaImageTask.access$100(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask) * this.jdField_a_of_type_Float), Math.round(VistaImageTask.access$200(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask) * this.jdField_a_of_type_Float), VistaImageTask.access$300(this.jdField_a_of_type_ComQflutterVistaimageVistaImageTask), new VistaImageTask.1.1(this, paramSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageTask.1
 * JD-Core Version:    0.7.0.1
 */