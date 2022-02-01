package com.qflutter.vistaimage;

import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import java.util.Map;

class TextureRecord
{
  static final int STATE_ERROR = 2;
  static final int STATE_SUCCESS = 1;
  private static final String TAG = "TextureRecord";
  private int bitmapHeight;
  private int bitmapWidth;
  private float density;
  private Drawable drawable;
  private TextureRegistry.SurfaceTextureEntry entry;
  private String errCode;
  private String errDesc;
  private int fitType;
  private int heightPx;
  private String imageUri;
  private boolean isBitmapClipped;
  private double radius;
  private IRenderer renderer;
  private RendererParams.ImageRepeat repeat = RendererParams.ImageRepeat.NO_REPEAT;
  private int state;
  private VistaImageTask vistaImageTask;
  private int widthPx;
  
  TextureRecord(VistaImageTask paramVistaImageTask, float paramFloat, boolean paramBoolean, Drawable paramDrawable, IRenderer paramIRenderer)
  {
    this.state = 1;
    this.vistaImageTask = paramVistaImageTask;
    this.imageUri = paramVistaImageTask.getUri();
    this.widthPx = Math.round(paramVistaImageTask.getWidth() * paramFloat);
    this.heightPx = Math.round(paramVistaImageTask.getHeight() * paramFloat);
    this.density = paramFloat;
    this.fitType = paramVistaImageTask.getFitType();
    this.drawable = paramDrawable;
    this.bitmapWidth = paramDrawable.getIntrinsicWidth();
    this.bitmapHeight = paramDrawable.getIntrinsicHeight();
    this.renderer = paramIRenderer;
    this.isBitmapClipped = paramBoolean;
    double d1 = paramVistaImageTask.getRadius();
    double d2 = paramFloat;
    Double.isNaN(d2);
    Double.isNaN(d2);
    this.radius = (d1 * d2);
    this.repeat = paramVistaImageTask.getRepeat();
    if (this.widthPx == 0) {
      this.widthPx = (this.bitmapWidth * this.heightPx / this.bitmapHeight);
    }
    if (this.heightPx == 0) {
      this.heightPx = (this.bitmapHeight * this.widthPx / this.bitmapWidth);
    }
    if (VistaImageLog.isColorLevel())
    {
      paramVistaImageTask = new StringBuilder();
      paramVistaImageTask.append("[TextureRecord] uri=");
      paramVistaImageTask.append(this.imageUri);
      paramVistaImageTask.append(", widthPx=");
      paramVistaImageTask.append(this.widthPx);
      paramVistaImageTask.append(", heightPx=");
      paramVistaImageTask.append(this.heightPx);
      paramVistaImageTask.append(", bmpWidth=");
      paramVistaImageTask.append(this.bitmapWidth);
      paramVistaImageTask.append(", bmpHeight=");
      paramVistaImageTask.append(this.bitmapHeight);
      paramVistaImageTask.append(", density=");
      paramVistaImageTask.append(paramFloat);
      VistaImageLog.d("TextureRecord", paramVistaImageTask.toString());
    }
  }
  
  TextureRecord(VistaImageTask paramVistaImageTask, String paramString1, String paramString2)
  {
    this.vistaImageTask = paramVistaImageTask;
    this.state = 2;
    this.errCode = paramString1;
    this.errDesc = paramString2;
  }
  
  private int getConstrainedHeight()
  {
    int i = this.heightPx;
    if (i > 0) {
      return i;
    }
    return this.bitmapHeight;
  }
  
  private int getConstrainedWidth()
  {
    int i = this.widthPx;
    if (i > 0) {
      return i;
    }
    return this.bitmapWidth;
  }
  
  private void notifyDartFail()
  {
    VistaImageTask localVistaImageTask = this.vistaImageTask;
    if (localVistaImageTask == null)
    {
      VistaImageLog.w("TextureRecord", "[notifyDartFail] invalid vistaImageTask");
      return;
    }
    localVistaImageTask.notifyDartFail(this.errCode, this.errDesc);
  }
  
  private void notifyDartSuccess()
  {
    if (this.vistaImageTask == null)
    {
      VistaImageLog.w("TextureRecord", "[notifyDartSuccess] invalid vistaImageTask");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("texture_id", Long.valueOf(getTextureId()));
    localHashMap.put("width", Float.valueOf(this.widthPx * 1.0F / this.density));
    localHashMap.put("height", Float.valueOf(this.heightPx * 1.0F / this.density));
    this.vistaImageTask.notifyDartSuccess(localHashMap);
  }
  
  Drawable getDrawable()
  {
    return this.drawable;
  }
  
  String getImageUri()
  {
    return this.imageUri;
  }
  
  long getTextureId()
  {
    TextureRegistry.SurfaceTextureEntry localSurfaceTextureEntry = this.entry;
    if (localSurfaceTextureEntry != null) {
      return localSurfaceTextureEntry.id();
    }
    throw new RuntimeException("no SurfaceTexture, please run make() method first");
  }
  
  boolean isError()
  {
    return isSuccess() ^ true;
  }
  
  boolean isSuccess()
  {
    return this.state == 1;
  }
  
  @UiThread
  long make(@NonNull TextureRegistry paramTextureRegistry)
  {
    this.entry = paramTextureRegistry.createSurfaceTexture();
    paramTextureRegistry = this.entry.surfaceTexture();
    paramTextureRegistry.setDefaultBufferSize(getConstrainedWidth(), getConstrainedHeight());
    paramTextureRegistry = new Surface(paramTextureRegistry);
    if (this.renderer == null) {
      this.renderer = new DrawableRenderer();
    }
    paramTextureRegistry = RendererParams.Builder.aRendererParams().withSurface(paramTextureRegistry).withDrawable(this.drawable).withFitType(this.fitType).withIsClipped(this.isBitmapClipped).withViewWidth(getConstrainedWidth()).withViewHeight(getConstrainedHeight()).withRadius(this.radius).withRepeat(this.repeat).build();
    this.renderer.init(paramTextureRegistry);
    if (VistaImageLog.isColorLevel())
    {
      paramTextureRegistry = new StringBuilder();
      paramTextureRegistry.append("[make] textureId=");
      paramTextureRegistry.append(this.entry.id());
      VistaImageLog.d("TextureRecord", paramTextureRegistry.toString());
    }
    return this.entry.id();
  }
  
  void notifyDart()
  {
    if (isError())
    {
      notifyDartFail();
      return;
    }
    notifyDartSuccess();
  }
  
  void notifyDartEmpty()
  {
    HashMap localHashMap = new HashMap();
    this.vistaImageTask.notifyDartSuccess(localHashMap);
  }
  
  @UiThread
  void release()
  {
    if (VistaImageLog.isColorLevel()) {
      VistaImageLog.d("TextureRecord", "[release]");
    }
    Object localObject = this.entry;
    if (localObject != null) {
      ((TextureRegistry.SurfaceTextureEntry)localObject).release();
    }
    localObject = this.renderer;
    if (localObject != null) {
      ((IRenderer)localObject).clean();
    }
  }
  
  @UiThread
  void render()
  {
    IRenderer localIRenderer = this.renderer;
    if (localIRenderer == null)
    {
      VistaImageLog.w("TextureRecord", "[render] invalid renderer");
      return;
    }
    localIRenderer.render();
  }
  
  void setError(String paramString1, String paramString2)
  {
    this.state = 2;
    this.errCode = paramString1;
    this.errDesc = paramString2;
  }
  
  void update(Drawable paramDrawable)
  {
    IRenderer localIRenderer = this.renderer;
    if (localIRenderer == null)
    {
      VistaImageLog.w("TextureRecord", "[update] invalid renderer, please call make() first");
      return;
    }
    localIRenderer.updateDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.TextureRecord
 * JD-Core Version:    0.7.0.1
 */