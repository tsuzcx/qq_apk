package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.c.b;
import com.tencent.luggage.wxa.c.c.a;
import com.tencent.luggage.wxa.c.c.b;
import com.tencent.luggage.wxa.d.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Keep
public class BaseImageDecodeService
  implements IImageDecodeService
{
  private static final String TAG = "BaseImageDecodeService";
  private IImageDecodeService.b mCompactDecodeEventListener = new BaseImageDecodeService.a(this, null);
  private List<IImageDecodeService.b> mDecodeEventListeners = new LinkedList();
  private IImageDecodeService.a mDecodeSlave = null;
  private com.tencent.luggage.wxa.d.d mFallbackImageStreamFetcher;
  private c mHttpImageStreamFetcher = new c();
  private LinkedList<com.tencent.luggage.wxa.d.d> mImageStreamFetcherList = new LinkedList();
  private boolean mIsTrackInitImages = false;
  
  public BaseImageDecodeService()
  {
    addImageStreamFetcher(this.mHttpImageStreamFetcher, false);
    setBitmapDecodeSlave(new a());
  }
  
  private Bitmap.CompressFormat ensureCompressFormat(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return Bitmap.CompressFormat.PNG;
      }
      return Bitmap.CompressFormat.JPEG;
    }
    return Bitmap.CompressFormat.WEBP;
  }
  
  private Bitmap.CompressFormat ensureCompressFormat(String paramString)
  {
    if ("image/webp".equals(paramString)) {
      return Bitmap.CompressFormat.WEBP;
    }
    if ((!"image/jpeg".equals(paramString)) && (!"image/jpg".equals(paramString))) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  private int ensureQuality(float paramFloat)
  {
    float f;
    if (paramFloat >= 0.0F)
    {
      f = paramFloat;
      if (paramFloat <= 1.0F) {}
    }
    else
    {
      f = 0.92F;
    }
    return (int)(f * 100.0F);
  }
  
  private void runInThreadPool(Object paramObject, Runnable paramRunnable)
  {
    if (this.mHttpImageStreamFetcher.a(paramObject))
    {
      d.a.a(paramRunnable);
      return;
    }
    d.a.b(paramRunnable);
  }
  
  public void addDecodeEventListener(@NonNull IImageDecodeService.b paramb)
  {
    this.mDecodeEventListeners.add(paramb);
  }
  
  public void addImageStreamFetcher(@NonNull com.tencent.luggage.wxa.d.d paramd, boolean paramBoolean)
  {
    b.b("BaseImageDecodeService", "hy: %d adding stream fetcher: %s %b", new Object[] { Integer.valueOf(hashCode()), paramd.getClass().getSimpleName(), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.mImageStreamFetcherList.push(paramd);
      return;
    }
    this.mFallbackImageStreamFetcher = paramd;
  }
  
  public String encodeToBase64(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    if ((paramBitmap != null) && (paramBitmap.getWidth() != 0) && (paramBitmap.getHeight() != 0))
    {
      if (paramBitmap.isRecycled()) {
        return null;
      }
      Bitmap.CompressFormat localCompressFormat = ensureCompressFormat(paramInt);
      paramInt = ensureQuality(paramFloat);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      boolean bool = paramBitmap.compress(localCompressFormat, paramInt, localByteArrayOutputStream);
      try
      {
        localByteArrayOutputStream.close();
      }
      catch (IOException paramBitmap)
      {
        b.d("BaseImageDecodeService", "base64_encode IOException e %s", new Object[] { paramBitmap.toString() });
        bool = false;
      }
      if ((bool) && (localByteArrayOutputStream.size() > 0)) {
        return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
      }
      b.d("BaseImageDecodeService", "base64_encode Bitmap compress error.", new Object[0]);
    }
    return null;
  }
  
  public byte[] encodeToBuffer(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    if ((paramBitmap != null) && (paramBitmap.getWidth() != 0) && (paramBitmap.getHeight() != 0))
    {
      if (paramBitmap.isRecycled()) {
        return null;
      }
      Bitmap.CompressFormat localCompressFormat = ensureCompressFormat(paramInt);
      paramInt = ensureQuality(paramFloat);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      boolean bool = paramBitmap.compress(localCompressFormat, paramInt, localByteArrayOutputStream);
      try
      {
        localByteArrayOutputStream.close();
      }
      catch (IOException paramBitmap)
      {
        b.d("BaseImageDecodeService", "encodeToBuffer IOException e %s", new Object[] { paramBitmap.toString() });
        bool = false;
      }
      if ((bool) && (localByteArrayOutputStream.size() > 0)) {
        return localByteArrayOutputStream.toByteArray();
      }
      b.d("BaseImageDecodeService", "encodeToBuffer Bitmap compress error.", new Object[0]);
    }
    return null;
  }
  
  public void forceSetUseType(BitmapType paramBitmapType)
  {
    this.mDecodeSlave.a(paramBitmapType);
  }
  
  public Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    return e.a().a(paramInt1, paramInt2);
  }
  
  public void init() {}
  
  public void loadBitmapAsync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    ImageDecodeConfig localImageDecodeConfig = paramImageDecodeConfig;
    if (paramImageDecodeConfig == null) {
      localImageDecodeConfig = new ImageDecodeConfig();
    }
    runInThreadPool(paramObject, new BaseImageDecodeService.c(this, paramObject, localImageDecodeConfig));
  }
  
  public void loadBitmapAsync(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      loadBitmapAsync(paramString, new ImageDecodeConfig());
    }
  }
  
  public void loadBitmapAsync(String paramString, ImageDecodeConfig paramImageDecodeConfig)
  {
    loadBitmapAsync(paramString, paramImageDecodeConfig);
  }
  
  public IBitmap loadBitmapSync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    ImageDecodeConfig localImageDecodeConfig = paramImageDecodeConfig;
    if (paramImageDecodeConfig == null) {
      localImageDecodeConfig = new ImageDecodeConfig();
    }
    Object localObject = this.mImageStreamFetcherList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramImageDecodeConfig = (com.tencent.luggage.wxa.d.d)((Iterator)localObject).next();
      if (paramImageDecodeConfig.a(paramObject)) {
        break label59;
      }
    }
    paramImageDecodeConfig = null;
    label59:
    localObject = paramImageDecodeConfig;
    if (paramImageDecodeConfig == null) {
      localObject = this.mFallbackImageStreamFetcher;
    }
    if (localObject == null)
    {
      b.d("BaseImageDecodeService", "No fit image stream fetcher found for %s", new Object[] { paramObject.toString() });
      return null;
    }
    try
    {
      paramImageDecodeConfig = this.mDecodeSlave.a(paramObject.toString(), paramObject, (com.tencent.luggage.wxa.d.d)localObject, localImageDecodeConfig);
      return paramImageDecodeConfig;
    }
    catch (Exception paramImageDecodeConfig)
    {
      b.d("BaseImageDecodeService", "ImageDecoder(%s) decode path[%s] error %s", new Object[] { localObject, paramObject.toString(), paramImageDecodeConfig.toString() });
    }
    return null;
  }
  
  public IBitmap loadBitmapSync(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return loadBitmapSync(paramString, new ImageDecodeConfig());
    }
    return null;
  }
  
  public IBitmap loadBitmapSync(String paramString, ImageDecodeConfig paramImageDecodeConfig)
  {
    return loadBitmapSync(paramString, paramImageDecodeConfig);
  }
  
  public void release()
  {
    try
    {
      if (this.mDecodeSlave != null)
      {
        this.mDecodeSlave.a();
        this.mDecodeSlave = null;
      }
      return;
    }
    finally {}
  }
  
  public void releaseBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    b.b("BaseImageDecodeService", "recycle because releaseBitmap", new Object[0]);
    paramBitmap.recycle();
  }
  
  public void removeDecodeEventListener(@NonNull IImageDecodeService.b paramb)
  {
    this.mDecodeEventListeners.remove(paramb);
  }
  
  public void removeImageStreamFetcher(@NonNull com.tencent.luggage.wxa.d.d paramd, boolean paramBoolean)
  {
    b.b("BaseImageDecodeService", "hy: %d removing stream fetcher: %s %b", new Object[] { Integer.valueOf(hashCode()), paramd.getClass().getSimpleName(), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.mImageStreamFetcherList.remove(paramd);
      return;
    }
    this.mFallbackImageStreamFetcher = null;
  }
  
  public void setBitmapDecodeSlave(@NonNull IImageDecodeService.a parama)
  {
    this.mDecodeSlave = parama;
    this.mDecodeSlave.a(this.mCompactDecodeEventListener);
  }
  
  public void setIdKeyReportDelegate(c.a parama) {}
  
  public void setKvReportDelegate(c.b paramb) {}
  
  public void setMaxDecodeDimension(int paramInt1, int paramInt2)
  {
    this.mDecodeSlave.a(paramInt1, paramInt2);
  }
  
  public void setNetworkTimeout(int paramInt1, int paramInt2)
  {
    this.mHttpImageStreamFetcher.a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.BaseImageDecodeService
 * JD-Core Version:    0.7.0.1
 */