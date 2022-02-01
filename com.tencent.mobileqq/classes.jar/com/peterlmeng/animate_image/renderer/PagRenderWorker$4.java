package com.peterlmeng.animate_image.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import com.peterlmeng.animate_image.RenderUtils;
import com.peterlmeng.animate_image.model.ReplaceImageModel;
import com.peterlmeng.animate_image.support.log.LogUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import org.libpag.PAGFile;
import org.libpag.PAGImage;

class PagRenderWorker$4
  implements Runnable
{
  PagRenderWorker$4(PagRenderWorker paramPagRenderWorker) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.this$0.registrarWeakReference == null) {
          return;
        }
        Object localObject2 = (Context)this.this$0.registrarWeakReference.get();
        Object localObject1 = RenderUtils.pathToFile((Context)localObject2, this.this$0.url, this.this$0.packagePath);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break;
        }
        localObject1 = PAGFile.Load(((File)localObject1).getAbsolutePath());
        if (this.this$0.replaceImageModel != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("replace :");
          localStringBuilder.append(this.this$0.replaceImageModel.path);
          localStringBuilder.append(",");
          localStringBuilder.append(this.this$0.replaceImageModel.index);
          LogUtils.c("PagRenderWorker", localStringBuilder.toString());
          localObject2 = RenderUtils.getBitmapFromPath((Context)localObject2, this.this$0.replaceImageModel.path, this.this$0.replaceImageModel.packagePath);
          if (localObject2 != null)
          {
            localObject2 = PAGImage.FromBitmap((Bitmap)localObject2);
            ((PAGFile)localObject1).replaceImage(this.this$0.replaceImageModel.index, (PAGImage)localObject2);
          }
          PagRenderWorker.access$400(this.this$0, (PAGFile)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtils.b("PagRenderWorker", localException.getMessage());
        return;
      }
      LogUtils.c("PagRenderWorker", "need not replace resource");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.4
 * JD-Core Version:    0.7.0.1
 */