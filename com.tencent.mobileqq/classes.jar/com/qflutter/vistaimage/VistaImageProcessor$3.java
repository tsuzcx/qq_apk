package com.qflutter.vistaimage;

import rx.Observable;
import rx.functions.Func1;

class VistaImageProcessor$3
  implements Func1<VistaImageTask, Observable<TextureRecord>>
{
  VistaImageProcessor$3(VistaImageProcessor paramVistaImageProcessor, IVistaImage paramIVistaImage) {}
  
  public Observable<TextureRecord> a(VistaImageTask paramVistaImageTask)
  {
    return paramVistaImageTask.loadImage(this.b, VistaImageProcessor.access$200(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageProcessor.3
 * JD-Core Version:    0.7.0.1
 */