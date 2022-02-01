package com.qflutter.vistaimage;

import java.util.Map;
import rx.functions.Action1;

class VistaImageProcessor$6
  implements Action1<TextureRecord>
{
  VistaImageProcessor$6(VistaImageProcessor paramVistaImageProcessor, long paramLong) {}
  
  public void a(TextureRecord paramTextureRecord)
  {
    TextureRecord localTextureRecord = (TextureRecord)VistaImageProcessor.access$100(this.a).get(Long.valueOf(this.b));
    if (localTextureRecord == null) {}
    try
    {
      VistaImageLog.w("VistaImageProcessor", "[processTasks] no available TextureRecord to update");
      return;
    }
    catch (Throwable paramTextureRecord)
    {
      VistaImageLog.e("VistaImageProcessor", "[processTasks] update texture error", paramTextureRecord);
    }
    localTextureRecord.update(paramTextureRecord.getDrawable());
    localTextureRecord.render();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageProcessor.6
 * JD-Core Version:    0.7.0.1
 */