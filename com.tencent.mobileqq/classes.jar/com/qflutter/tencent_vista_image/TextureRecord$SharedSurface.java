package com.qflutter.tencent_vista_image;

import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.concurrent.atomic.AtomicInteger;

class TextureRecord$SharedSurface
{
  AtomicInteger count;
  TextureRegistry.SurfaceTextureEntry entry;
  IRenderer renderer;
  
  TextureRecord$SharedSurface(TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, IRenderer paramIRenderer)
  {
    this.entry = paramSurfaceTextureEntry;
    this.renderer = paramIRenderer;
    this.count = new AtomicInteger(1);
  }
  
  int addRef()
  {
    return this.count.incrementAndGet();
  }
  
  boolean deRef()
  {
    if (this.count.decrementAndGet() == 0)
    {
      this.entry.release();
      this.entry = null;
      this.renderer.clean();
      this.renderer = null;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TextureRecord.SharedSurface
 * JD-Core Version:    0.7.0.1
 */