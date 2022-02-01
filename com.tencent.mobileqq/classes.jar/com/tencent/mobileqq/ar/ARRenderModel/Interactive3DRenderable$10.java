package com.tencent.mobileqq.ar.ARRenderModel;

import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARMusicController;

class Interactive3DRenderable$10
  implements Runnable
{
  Interactive3DRenderable$10(Interactive3DRenderable paramInteractive3DRenderable, String paramString) {}
  
  public void run()
  {
    if ((Interactive3DRenderable.c(this.this$0) != null) && (!TextUtils.isEmpty(this.a)))
    {
      ARMusicController localARMusicController = Interactive3DRenderable.c(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Interactive3DRenderable.e(this.this$0));
      localStringBuilder.append(this.a);
      localARMusicController.a(localStringBuilder.toString(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.10
 * JD-Core Version:    0.7.0.1
 */