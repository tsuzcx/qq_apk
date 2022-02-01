package com.qflutter.vistaimage;

import rx.Observable;
import rx.functions.Func1;

class VistaImageProcessor$8
  implements Func1<VistaImageTask, Observable<TextureRecord>>
{
  VistaImageProcessor$8(VistaImageProcessor paramVistaImageProcessor) {}
  
  public Observable<TextureRecord> a(VistaImageTask paramVistaImageTask)
  {
    return paramVistaImageTask.loadImage(VistaImageProcessor.access$100(this.a), VistaImageProcessor.access$300(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageProcessor.8
 * JD-Core Version:    0.7.0.1
 */