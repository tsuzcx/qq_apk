package com.tencent.av.video.effect.lowlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.av.video.effect.utils.StorageUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class LowLightTools
{
  private static final String LOW_LIGHT_IMAGE = "LowLight.png";
  public static final String TAG = "LowLightTools";
  
  public static <T extends Number> double clipping(T paramT)
  {
    if (paramT.doubleValue() < 0.0D) {
      return 0.0D;
    }
    if (paramT.doubleValue() > 255.0D) {
      return 255.0D;
    }
    return paramT.doubleValue();
  }
  
  public static Bitmap getLowLightImage(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    int k;
    int m;
    for (;;)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        localObject = new byte[262144];
        k = 0;
        j = 0;
      }
      catch (Throwable localThrowable)
      {
        Bitmap localBitmap;
        int j;
        float f;
        int i;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getLowLightImage:");
        ((StringBuilder)localObject).append(localThrowable);
        Log.d("LowLightTools", ((StringBuilder)localObject).toString());
        return null;
      }
      if (m >= 256) {
        break label228;
      }
      f = (float)Math.pow(1.0F - (255.0F - m) * paramFloat2 / (255.0F - paramFloat1), paramFloat3);
      i = (byte)(byte)(int)clipping(Double.valueOf(Math.pow((int)clipping(Integer.valueOf((int)((k - paramFloat1) / f + paramFloat1))) / 255.0F, paramFloat4) * 255.0D));
      localObject[j] = i;
      localObject[(j + 1)] = i;
      localObject[(j + 2)] = i;
      localObject[(j + 3)] = -1;
      j += 4;
      m += 1;
    }
    label228:
    label235:
    for (;;)
    {
      localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap((byte[])localObject));
      if (paramBoolean) {
        saveBitmap(localBitmap);
      }
      return localBitmap;
      for (;;)
      {
        if (k >= 256) {
          break label235;
        }
        m = 0;
        break;
        k += 1;
      }
    }
  }
  
  public static Bitmap getLowLightImage(Context paramContext, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("/");
      localStringBuilder.append("LowLight.png");
      paramContext = BitmapFactory.decodeStream(CommonUtils.getInputStreamFromPath(paramContext, localStringBuilder.toString()));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getLowLightImage:");
      paramString.append(paramContext);
      Log.d("LowLightTools", paramString.toString());
    }
    return null;
  }
  
  public static void saveBitmap(Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(StorageUtils.VIDEO_EFFECT_PATH);
    ((StringBuilder)localObject).append("LowLight/lowLight_saved.png");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      localObject = new FileOutputStream((File)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      return;
    }
    catch (Exception paramBitmap)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveBitmap:");
      ((StringBuilder)localObject).append(paramBitmap);
      Log.d("LowLightTools", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.lowlight.LowLightTools
 * JD-Core Version:    0.7.0.1
 */