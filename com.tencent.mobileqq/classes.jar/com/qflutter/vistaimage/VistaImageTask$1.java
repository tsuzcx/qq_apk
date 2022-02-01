package com.qflutter.vistaimage;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class VistaImageTask$1
  implements Observable.OnSubscribe<TextureRecord>
{
  VistaImageTask$1(VistaImageTask paramVistaImageTask, IVistaImage paramIVistaImage, float paramFloat) {}
  
  public void a(Subscriber<? super TextureRecord> paramSubscriber)
  {
    this.c.loadBitmap(VistaImageTask.access$000(this.a), Math.round(VistaImageTask.access$100(this.a) * this.b), Math.round(VistaImageTask.access$200(this.a) * this.b), VistaImageTask.access$300(this.a), new VistaImageTask.1.1(this, paramSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageTask.1
 * JD-Core Version:    0.7.0.1
 */