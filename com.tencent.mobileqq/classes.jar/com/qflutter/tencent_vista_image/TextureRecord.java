package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class TextureRecord
{
  public static final int IMAGE_TYPE_GIF = 1;
  public static final int IMAGE_TYPE_IMAGE = 0;
  public static final int STATE_LOADED_BITMAP = 1;
  public static final int STATE_LOADING_BITMAP = 0;
  public static final int STATE_LOAD_ERROR = 2;
  private static final String TAG = "TextureRecord";
  private static Map<String, TextureRecord.SharedSurface> sharedSurfaceMap = new ConcurrentHashMap();
  private Bitmap bitmap;
  private int bitmapHeight;
  private int bitmapWidth;
  private MethodChannel.Result callback;
  private float density;
  private int fitType;
  private int heightPx;
  private int imageType;
  private String imageUri;
  private boolean isBitmapClipped;
  private String key;
  private IRenderer renderer;
  private int state;
  private String widgetKey;
  private int widthPx;
  
  TextureRecord(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, MethodChannel.Result paramResult)
  {
    this.imageUri = paramString2;
    this.widthPx = paramInt1;
    this.heightPx = paramInt2;
    this.fitType = paramInt3;
    this.imageType = paramInt4;
    this.widgetKey = paramString1;
    this.callback = paramResult;
    this.density = paramFloat;
    this.key = genTextureKey(paramString1, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static String genTextureKey(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    return localStringBuilder.toString();
  }
  
  private int getConstraindHeight()
  {
    if (this.heightPx > 0) {
      return this.heightPx;
    }
    return this.bitmapHeight;
  }
  
  private int getConstraindWidth()
  {
    if (this.widthPx > 0) {
      return this.widthPx;
    }
    return this.bitmapWidth;
  }
  
  String getImageUri()
  {
    return this.imageUri;
  }
  
  IRenderer getRenderer()
  {
    return this.renderer;
  }
  
  long getTextureId()
  {
    TextureRecord.SharedSurface localSharedSurface = (TextureRecord.SharedSurface)sharedSurfaceMap.get(this.key);
    if (localSharedSurface == null) {
      return -1L;
    }
    return localSharedSurface.entry.id();
  }
  
  String getTextureKey()
  {
    return this.key;
  }
  
  String getWidgetKey()
  {
    return this.widgetKey;
  }
  
  long joinSurface()
  {
    if (sharedSurfaceMap.containsKey(this.key))
    {
      TextureRecord.SharedSurface localSharedSurface = (TextureRecord.SharedSurface)sharedSurfaceMap.get(this.key);
      if (localSharedSurface != null)
      {
        localSharedSurface.addRef();
        if (PLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[joinSurface] textureId=");
          localStringBuilder.append(localSharedSurface.entry.id());
          localStringBuilder.append(", count=");
          localStringBuilder.append(localSharedSurface.count.intValue());
          PLog.d("TextureRecord", localStringBuilder.toString());
        }
        return localSharedSurface.entry.id();
      }
      PLog.w("TextureRecord", "[joinSurface] no sharedSurface found");
      sharedSurfaceMap.remove(this.key);
    }
    return -1L;
  }
  
  @UiThread
  long make(@NonNull TextureRegistry paramTextureRegistry)
  {
    try
    {
      paramTextureRegistry = paramTextureRegistry.createSurfaceTexture();
      Object localObject = paramTextureRegistry.surfaceTexture();
      ((SurfaceTexture)localObject).setDefaultBufferSize(getConstraindWidth(), getConstraindHeight());
      localObject = new Surface((SurfaceTexture)localObject);
      if (this.renderer == null) {
        this.renderer = new BitmapRenderer();
      }
      this.renderer.init((Surface)localObject, this.bitmap, this.fitType, this.isBitmapClipped, getConstraindWidth(), getConstraindHeight());
      localObject = new TextureRecord.SharedSurface(paramTextureRegistry, this.renderer);
      sharedSurfaceMap.put(this.key, localObject);
      if (PLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[make] textureId=");
        ((StringBuilder)localObject).append(paramTextureRegistry.id());
        PLog.d("TextureRecord", ((StringBuilder)localObject).toString());
      }
      long l = paramTextureRegistry.id();
      return l;
    }
    catch (Exception paramTextureRegistry)
    {
      PLog.e("TextureRecord", "[make]", paramTextureRegistry);
    }
    return -1L;
  }
  
  void notifyDartFail(String paramString1, String paramString2, Object paramObject)
  {
    if (this.callback == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("[notifyDartFail] invalid callback, url=");
      paramString1.append(this.imageUri);
      PLog.w("TextureRecord", paramString1.toString());
      return;
    }
    this.callback.error(paramString1, paramString2, paramObject);
    this.callback = null;
  }
  
  void notifyDartSuccess()
  {
    if (this.callback == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notifyDartSuccess] invalid callback, url=");
      ((StringBuilder)localObject).append(this.imageUri);
      PLog.w("TextureRecord", ((StringBuilder)localObject).toString());
      return;
    }
    long l = getTextureId();
    float f1 = getConstraindWidth() / this.density;
    float f2 = getConstraindHeight() / this.density;
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notifyDartSuccess] id=");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", width=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", height=");
      ((StringBuilder)localObject).append(f2);
      PLog.d("TextureRecord", ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("texture_id", Long.valueOf(l));
    ((Map)localObject).put("width", Float.valueOf(f1));
    ((Map)localObject).put("height", Float.valueOf(f2));
    this.callback.success(localObject);
    this.callback = null;
  }
  
  void notifyDartSuccess(MethodChannel.Result paramResult)
  {
    long l = getTextureId();
    float f1 = getConstraindWidth() / this.density;
    float f2 = getConstraindHeight() / this.density;
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notifyDartSuccess] id=");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", width=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", height=");
      ((StringBuilder)localObject).append(f2);
      PLog.d("TextureRecord", ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("texture_id", Long.valueOf(l));
    ((Map)localObject).put("width", Float.valueOf(f1));
    ((Map)localObject).put("height", Float.valueOf(f2));
    paramResult.success(localObject);
  }
  
  @UiThread
  boolean release()
  {
    if (sharedSurfaceMap.containsKey(this.key))
    {
      TextureRecord.SharedSurface localSharedSurface = (TextureRecord.SharedSurface)sharedSurfaceMap.get(this.key);
      if (localSharedSurface != null)
      {
        if (PLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[release] textureId=");
          localStringBuilder.append(localSharedSurface.entry.id());
          localStringBuilder.append(", count=");
          localStringBuilder.append(localSharedSurface.count.intValue());
          localStringBuilder.append(", url=");
          localStringBuilder.append(this.imageUri);
          PLog.d("TextureRecord", localStringBuilder.toString());
        }
        if (localSharedSurface.deRef())
        {
          sharedSurfaceMap.remove(this.key);
          return true;
        }
        return false;
      }
      PLog.w("TextureRecord", "[release] no sharedSurface found");
      sharedSurfaceMap.remove(this.key);
    }
    return true;
  }
  
  @UiThread
  public void render()
  {
    if (this.renderer == null)
    {
      PLog.w("TextureRecord", "[render] invalid renderer");
      return;
    }
    this.renderer.render();
  }
  
  void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.bitmapWidth = paramBitmap.getWidth();
      this.bitmapHeight = paramBitmap.getHeight();
    }
  }
  
  void setBitmapClipped(boolean paramBoolean)
  {
    this.isBitmapClipped = paramBoolean;
  }
  
  void setRenderer(IRenderer paramIRenderer)
  {
    this.renderer = paramIRenderer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TextureRecord
 * JD-Core Version:    0.7.0.1
 */