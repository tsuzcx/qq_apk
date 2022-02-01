package com.peterlmeng.animate_image;

import android.os.Handler;
import com.peterlmeng.animate_image.renderer.RenderWorker.OnResourceLoadListener;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

class AnimateImagePlugin$1
  implements RenderWorker.OnResourceLoadListener
{
  AnimateImagePlugin$1(AnimateImagePlugin paramAnimateImagePlugin, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, MethodChannel.Result paramResult) {}
  
  public void onResourceLoaded(Size paramSize)
  {
    this.this$0.mUIHandler.post(new AnimateImagePlugin.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.AnimateImagePlugin.1
 * JD-Core Version:    0.7.0.1
 */