package com.tencent.av.opengl.api.impl;

import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.avcore.jni.render.RenderProxy;

public class GraphicRenderImpl
  extends RenderProxy
  implements IGraphicRender
{
  private int decoderPtrRef = 0;
  
  public void clearDecoderPtrRef()
  {
    this.decoderPtrRef = 0;
  }
  
  public void decreaseDecoderPtrRef()
  {
    this.decoderPtrRef -= 1;
  }
  
  public int getDecodePtrRef()
  {
    return this.decoderPtrRef;
  }
  
  public void increaseDecodePtrRef()
  {
    this.decoderPtrRef += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.api.impl.GraphicRenderImpl
 * JD-Core Version:    0.7.0.1
 */