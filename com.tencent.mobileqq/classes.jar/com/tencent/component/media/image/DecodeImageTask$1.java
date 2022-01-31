package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.FeedsBitmapImage;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.HashMap;

class DecodeImageTask$1
  implements Runnable
{
  DecodeImageTask$1(DecodeImageTask paramDecodeImageTask, ImageKey paramImageKey, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    ImageTracer.startSuperResolution(this.val$key.url);
    ProgressTracer.print(8, this.val$key.urlKey);
    if (this.val$bitmap == null)
    {
      ImageManagerLog.w(DecodeImageTask.access$100(), "super resolution. bitmap == null before process");
      return;
    }
    int i = ImageManagerEnv.g().getModelIdFromUrl(this.val$key.url);
    if (i < 0)
    {
      ImageManagerLog.e(DecodeImageTask.access$100(), "super resolution. invalid modelId. url=" + this.val$key.url);
      return;
    }
    Object localObject1 = Runtime.getRuntime();
    long l = ((Runtime)localObject1).maxMemory() - ((Runtime)localObject1).totalMemory() + ((Runtime)localObject1).freeMemory();
    ImageManagerLog.w(DecodeImageTask.access$100(), "super resolution. freeMemory=" + l);
    if (l / 1024L / 1024L < ImageManagerEnv.g().getSuperResolutionMemoryThreshold())
    {
      ImageManagerLog.w(DecodeImageTask.access$100(), "super resolution. Low memory, ignore super resolution.");
      return;
    }
    ImageManagerLog.w(DecodeImageTask.access$100(), "super resolution. using model modelId=" + i + " url=" + this.val$key.url);
    l = System.currentTimeMillis();
    localObject1 = ImageManagerEnv.g().doSuperResolution(this.val$bitmap, i);
    l = System.currentTimeMillis() - l;
    if (ImageManagerEnv.g().isHighScaleUrl(this.val$key.url))
    {
      ImageManagerLog.w(DecodeImageTask.access$100(), "high scale super resolution. Total function cost=" + l);
      ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "super_resolution_total_procedure_high_scale", (int)l);
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("PhoneType", Build.MODEL);
      ((HashMap)localObject2).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject2).put("modelId", String.valueOf(i));
      ((HashMap)localObject2).put("timeCost", String.valueOf(l));
      ((HashMap)localObject2).put("isHighScale", String.valueOf(ImageManagerEnv.g().isHighScaleUrl(this.val$key.url)));
      ImageManagerEnv.g().statisticCollectorReport("qzone_super_resolution", (HashMap)localObject2);
      if (localObject1 != null) {
        break;
      }
      ImageManagerLog.w(DecodeImageTask.access$100(), "super resolution. superResolutionBitmap == null after process. url=" + this.val$key.url);
      return;
      ImageManagerLog.w(DecodeImageTask.access$100(), "super resolution. Total function cost=" + l);
      ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "super_resolution_total_procedure", (int)l);
    }
    l = System.currentTimeMillis();
    ImageManager.getInstance().saveSuperResImage((Bitmap)localObject1, this.val$key);
    BitmapImage localBitmapImage = new BitmapImage(BitmapReference.getBitmapReference((Bitmap)localObject1));
    if ((this.val$key.options != null) && (this.val$key.options.extraProcessor != null))
    {
      localObject2 = new BitmapImageDrawable(localBitmapImage, this.val$finalClipw, this.val$finalCliph);
      ImageManagerLog.w(DecodeImageTask.access$100(), "super resolution. check high scale after sr. url=" + this.val$key.url);
      localObject1 = localObject2;
      if (DecodeImageTask.access$200((Drawable)localObject2)) {
        localObject1 = DecodeImageTask.access$300((Drawable)localObject2);
      }
      localObject1 = this.val$key.options.extraProcessor.doProcess((Drawable)localObject1);
      if ((localObject1 instanceof SpecifiedBitmapDrawable))
      {
        localObject2 = ((SpecifiedBitmapDrawable)localObject1).getBitmapRef();
        ImageManager.getInstance().putDrawableInMemoryCache(this.val$key, this.val$hashCodeEx, new FeedsBitmapImage((BitmapReference)localObject2), (Drawable)localObject1, this.val$key.options);
        if (this.val$key.listener != null) {
          DecodeImageTask.access$400().post(new DecodeImageTask.1.1(this, (Drawable)localObject1));
        }
        label670:
        l = System.currentTimeMillis() - l;
        if (!ImageManagerEnv.g().isHighScaleUrl(this.val$key.url)) {
          break label849;
        }
        ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "post_process_after_super_resolution_high_scale", (int)l);
      }
    }
    for (;;)
    {
      ImageTracer.reportDownloadTime(this.val$key.url, true);
      ImageTracer.reportDecodeTime(this.val$key.url, true);
      ImageTracer.endSuperResolution(this.val$key.url);
      ProgressTracer.print(9, this.val$key.urlKey);
      return;
      ImageManager.getInstance().putDrawableInMemoryCache(this.val$key, this.val$hashCodeEx, localBitmapImage, (Drawable)localObject1, this.val$key.options);
      break;
      localObject1 = new SpecifiedBitmapDrawable(localBitmapImage.getBitmap());
      ImageManager.getInstance().putDrawableInMemoryCache(this.val$key, this.val$hashCodeEx, localBitmapImage, (Drawable)localObject1, this.val$key.options);
      if (this.val$key.listener == null) {
        break label670;
      }
      DecodeImageTask.access$400().post(new DecodeImageTask.1.2(this, (Drawable)localObject1));
      break label670;
      label849:
      ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "post_process_after_super_resolution", (int)l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask.1
 * JD-Core Version:    0.7.0.1
 */