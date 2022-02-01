package com.qflutter.vistaimage;

import java.util.Map;
import rx.functions.Action1;

class VistaImageProcessor$4
  implements Action1<VistaImageTask>
{
  VistaImageProcessor$4(VistaImageProcessor paramVistaImageProcessor) {}
  
  public void a(VistaImageTask paramVistaImageTask)
  {
    TextureRecord localTextureRecord = (TextureRecord)VistaImageProcessor.access$200(this.a).remove(Long.valueOf(paramVistaImageTask.getTextureId()));
    if (localTextureRecord == null)
    {
      new TextureRecord(paramVistaImageTask, "-7", "no texture record").notifyDart();
      return;
    }
    localTextureRecord.release();
    localTextureRecord.notifyDartEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageProcessor.4
 * JD-Core Version:    0.7.0.1
 */