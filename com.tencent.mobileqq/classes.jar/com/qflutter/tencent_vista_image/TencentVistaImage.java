package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.TextureRegistry;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

@RequiresApi(api=16)
final class TencentVistaImage
{
  public static final String TAG = "TencentVistaImage";
  private float density;
  private Set<String> pendingWidgetKeySet = new ConcurrentSkipListSet();
  private Map<String, TextureRecord> textureRecordMap = new ConcurrentHashMap();
  private TextureRegistry textureRegistry;
  private IVistaImage vistaImageImpl;
  
  private void doCreateTexture(TextureRecord paramTextureRecord)
  {
    try
    {
      StringBuilder localStringBuilder;
      if (!this.pendingWidgetKeySet.contains(paramTextureRecord.getWidgetKey()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doCreateTexture] no pending widget key=");
        localStringBuilder.append(paramTextureRecord.getWidgetKey());
        PLog.w("TencentVistaImage", localStringBuilder.toString());
        return;
      }
      this.pendingWidgetKeySet.remove(paramTextureRecord.getWidgetKey());
      if (PLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doCreateTexture] remove pending widget key=");
        localStringBuilder.append(paramTextureRecord.getWidgetKey());
        PLog.d("TencentVistaImage", localStringBuilder.toString());
      }
      long l = paramTextureRecord.make(this.textureRegistry);
      this.vistaImageImpl.releaseBitmap(paramTextureRecord.getImageUri());
      if (PLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onCreateTexture] create texture id=");
        localStringBuilder.append(l);
        localStringBuilder.append(", url=");
        localStringBuilder.append(paramTextureRecord.getImageUri());
        PLog.d("TencentVistaImage", localStringBuilder.toString());
      }
      if (l < 0L)
      {
        paramTextureRecord.notifyDartFail("-8", "invalid texture id", null);
        return;
      }
    }
    catch (Exception localException)
    {
      PLog.e("TencentVistaImage", "[onCreateTexture]", localException);
      paramTextureRecord.notifyDartFail("-9999", "unknown error", null);
      return;
    }
    this.textureRecordMap.put(paramTextureRecord.getTextureKey(), paramTextureRecord);
    paramTextureRecord.notifyDartSuccess();
    paramTextureRecord.render();
  }
  
  private int dp2px(int paramInt)
  {
    return Math.round(paramInt * this.density);
  }
  
  public void clear()
  {
    this.textureRegistry = null;
    Iterator localIterator = this.textureRecordMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TextureRecord)localIterator.next()).release();
    }
    this.textureRecordMap.clear();
  }
  
  public void createTexture(String paramString1, @NonNull String paramString2, int paramInt1, int paramInt2, int paramInt3, MethodChannel.Result paramResult)
  {
    if (this.vistaImageImpl == null)
    {
      PLog.e("TencentVistaImage", "[createTexture] no IVistaImage implementation");
      paramResult.error("-1", "no IVistaImage implementation", null);
      return;
    }
    paramInt1 = dp2px(paramInt1);
    paramInt2 = dp2px(paramInt2);
    Object localObject = TextureRecord.genTextureKey(paramString1, paramInt1, paramInt2, paramInt3, 0);
    if (this.textureRecordMap.containsKey(localObject))
    {
      paramString1 = (TextureRecord)this.textureRecordMap.get(localObject);
      if (paramString1 == null) {}
      for (long l = -1L;; l = paramString1.joinSurface())
      {
        if (PLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[createTexture] has texture cache, id=");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(", url=");
          ((StringBuilder)localObject).append(paramString2);
          PLog.d("TencentVistaImage", ((StringBuilder)localObject).toString());
        }
        if (l >= 0L) {
          break;
        }
        paramResult.error("-8", "invalid texture id", null);
        return;
      }
      paramString1.notifyDartSuccess(paramResult);
      return;
    }
    paramResult = new TextureRecord(paramString1, paramString2, paramInt1, paramInt2, paramInt3, 0, this.density, paramResult);
    this.pendingWidgetKeySet.add(paramString1);
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[createTexture] add widget widget key=");
      ((StringBuilder)localObject).append(paramString1);
      PLog.d("TencentVistaImage", ((StringBuilder)localObject).toString());
    }
    this.vistaImageImpl.loadBitmap(paramString2, paramInt1, paramInt2, paramInt3, new TencentVistaImage.1(this, paramResult));
  }
  
  protected void doUpdateTexture(String paramString, Bitmap paramBitmap)
  {
    if (this.vistaImageImpl == null) {
      PLog.e("TencentVistaImage", "[doUpdateTexture] no IVistaImage implementation");
    }
    while (!this.textureRecordMap.containsKey(paramString)) {
      return;
    }
    paramString = (TextureRecord)this.textureRecordMap.get(paramString);
    if (paramString == null) {}
    for (long l = -1L; l < 0L; l = paramString.getTextureId())
    {
      paramString = new StringBuilder();
      paramString.append("[doUpdateTexture] invalid texture id, textureId=");
      paramString.append(l);
      PLog.w("TencentVistaImage", paramString.toString());
      return;
    }
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doUpdateTexture] has texture cache, textureId=");
      localStringBuilder.append(l);
      localStringBuilder.append(", uri=");
      localStringBuilder.append(paramString.getImageUri());
      PLog.d("TencentVistaImage", localStringBuilder.toString());
    }
    if (paramBitmap == null)
    {
      PLog.e("TencentVistaImage", "[doUpdateTexture] no bitmap");
      return;
    }
    if (paramBitmap.isRecycled())
    {
      PLog.e("TencentVistaImage", "[doUpdateTexture] recycled bitmap");
      return;
    }
    paramString = paramString.getRenderer();
    if (paramString == null)
    {
      PLog.w("TencentVistaImage", "[doUpdateTexture] invalid renderer");
      return;
    }
    if ((paramString instanceof BitmapRenderer))
    {
      ((BitmapRenderer)paramString).a(paramBitmap);
      paramString.render();
      return;
    }
    PLog.w("TencentVistaImage", "[doUpdateTexture] only BitmapRenderer supports update for now");
  }
  
  protected void onCreateTexture(TextureRecord paramTextureRecord)
  {
    if (this.textureRegistry == null)
    {
      PLog.e("TencentVistaImage", "[onCreateTexture] -4");
      paramTextureRecord.notifyDartFail("-4", "no texture registry", null);
      return;
    }
    if (this.vistaImageImpl == null)
    {
      PLog.e("TencentVistaImage", "[onCreateTexture] no IVistaImage implementation");
      paramTextureRecord.notifyDartFail("-1", "no IVistaImage implementation", null);
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      doCreateTexture(paramTextureRecord);
      return;
    }
    Observable.just(paramTextureRecord).observeOn(AndroidSchedulers.mainThread()).subscribe(new TencentVistaImage.4(this));
  }
  
  public void releaseTexture(String paramString1, @NonNull String paramString2, int paramInt1, int paramInt2, int paramInt3, MethodChannel.Result paramResult)
  {
    if (this.vistaImageImpl == null)
    {
      PLog.e("TencentVistaImage", "[releaseTexture] no IVistaImage implementation");
      paramResult.error("-1", "no IVistaImage implementation", null);
      return;
    }
    paramString2 = TextureRecord.genTextureKey(paramString1, dp2px(paramInt1), dp2px(paramInt2), paramInt3, 0);
    if (this.pendingWidgetKeySet.remove(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[releaseTexture] remove pending widget key=");
      localStringBuilder.append(paramString1);
      PLog.w("TencentVistaImage", localStringBuilder.toString());
    }
    if (this.textureRecordMap.containsKey(paramString2))
    {
      paramString1 = (TextureRecord)this.textureRecordMap.get(paramString2);
      if (paramString1 == null) {
        break label190;
      }
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label165;
      }
      if (paramString1.release()) {
        this.textureRecordMap.remove(paramString1.getTextureKey());
      }
    }
    for (;;)
    {
      paramResult.success(null);
      return;
      label165:
      Observable.just(paramString1).observeOn(AndroidSchedulers.mainThread()).subscribe(new TencentVistaImage.2(this));
      continue;
      label190:
      this.textureRecordMap.remove(paramString2);
    }
  }
  
  public void setDensity(float paramFloat)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setDensity] density=");
      localStringBuilder.append(paramFloat);
      PLog.d("TencentVistaImage", localStringBuilder.toString());
    }
    this.density = paramFloat;
  }
  
  public void setTextureRegistry(TextureRegistry paramTextureRegistry)
  {
    this.textureRegistry = paramTextureRegistry;
  }
  
  public void setVistaImageImpl(IVistaImage paramIVistaImage)
  {
    this.vistaImageImpl = paramIVistaImage;
  }
  
  public void updateTexture(String paramString1, @NonNull String paramString2, int paramInt1, int paramInt2, int paramInt3, MethodChannel.Result paramResult)
  {
    if (this.vistaImageImpl == null)
    {
      PLog.e("TencentVistaImage", "[updateTexture] no IVistaImage implementation");
      return;
    }
    paramInt1 = dp2px(paramInt1);
    paramInt2 = dp2px(paramInt2);
    paramString1 = TextureRecord.genTextureKey(paramString1, paramInt1, paramInt2, paramInt3, 0);
    if (this.textureRecordMap.containsKey(paramString1))
    {
      paramResult = (TextureRecord)this.textureRecordMap.get(paramString1);
      if (paramResult == null) {}
      for (long l = -1L;; l = paramResult.getTextureId())
      {
        if (PLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[updateTexture] has texture cache, id=");
          localStringBuilder.append(l);
          localStringBuilder.append(", uri=");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(", imageUri=");
          localStringBuilder.append(paramResult.getImageUri());
          PLog.d("TencentVistaImage", localStringBuilder.toString());
        }
        if (l >= 0L) {
          break;
        }
        paramString1 = new StringBuilder();
        paramString1.append("[updateTexture] invalid texture id, textureId=");
        paramString1.append(l);
        PLog.w("TencentVistaImage", paramString1.toString());
        return;
      }
      if (paramResult.getImageUri().equals(paramString2))
      {
        paramString1 = new StringBuilder();
        paramString1.append("[updateTexture] the same uri no need update, uri=");
        paramString1.append(paramString2);
        PLog.w("TencentVistaImage", paramString1.toString());
        return;
      }
      if (!(paramResult.getRenderer() instanceof BitmapRenderer))
      {
        PLog.w("TencentVistaImage", "[updateTexture] only BitmapRenderer supports update for now");
        return;
      }
      this.vistaImageImpl.loadBitmap(paramString2, paramInt1, paramInt2, paramInt3, new TencentVistaImage.3(this, paramString1));
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[updateTexture] no TextureRecord found, uri=");
    paramString1.append(paramString2);
    PLog.w("TencentVistaImage", paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TencentVistaImage
 * JD-Core Version:    0.7.0.1
 */