package com.peterlmeng.animate_image;

import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

class AnimateImagePlugin$1$1
  implements Runnable
{
  AnimateImagePlugin$1$1(AnimateImagePlugin.1 param1) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResourceLoaded succ! ");
    localStringBuilder.append(this.this$1.val$entry.id());
    LogUtils.a("ImgStPlugin", localStringBuilder.toString());
    this.this$1.val$result.success(Long.valueOf(this.this$1.val$entry.id()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.AnimateImagePlugin.1.1
 * JD-Core Version:    0.7.0.1
 */