package com.tencent.av.opengl.api;

import com.tencent.avcore.jni.render.IRenderEngine;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=true)
public abstract interface IGraphicRender
  extends IRenderEngine, QRouteApi
{
  public abstract void clearDecoderPtrRef();
  
  public abstract void decreaseDecoderPtrRef();
  
  public abstract int getDecodePtrRef();
  
  public abstract void increaseDecodePtrRef();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.api.IGraphicRender
 * JD-Core Version:    0.7.0.1
 */