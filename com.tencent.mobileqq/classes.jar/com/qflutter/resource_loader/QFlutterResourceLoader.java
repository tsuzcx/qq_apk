package com.qflutter.resource_loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.nativebmp.NativeBitmap;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QFlutterResourceLoader
{
  public static final String TAG = "QFlutterResourceLoader";
  private Context context;
  private NativeAppInterface nativeInterface;
  private ConcurrentHashMap<String, QFlutterResourceLoader.CacheItem> sCacheObj = new ConcurrentHashMap();
  private boolean sJniSoLoaded = false;
  
  private NativeImageReplyInfo buildImageInfoReply(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("buildImageInfoReply nativeImageID：");
    ((StringBuilder)localObject1).append(paramString);
    Log.d("QFlutterResourceLoader", ((StringBuilder)localObject1).toString());
    if (!TextUtils.isEmpty(paramString)) {
      localObject1 = this.nativeInterface.getNativeAppImage(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = localObject1;
      if (!((NativeImageInfo)localObject1).isNull()) {}
    }
    else
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new NativeImageInfo();
      }
      if ((!paramString.startsWith("https:")) && (!paramString.startsWith("http:")) && (!paramString.startsWith("HTTPS:")))
      {
        localObject3 = localObject2;
        if (!paramString.startsWith("HTTP:")) {}
      }
      else
      {
        ((NativeImageInfo)localObject2).url = paramString;
        localObject3 = localObject2;
      }
    }
    localObject1 = new NativeImageReplyInfo();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject3.bitmap != null)
    {
      bool1 = bool2;
      if (replyBitmap(localObject3, paramString, (NativeImageReplyInfo)localObject1)) {
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (localObject3.drawable != null)
      {
        bool2 = bool1;
        if (replyDrawable(localObject3, paramString, (NativeImageReplyInfo)localObject1)) {
          bool2 = true;
        }
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (localObject3.drawableId != 0)
      {
        replyDrawableIdImage(localObject3, paramString, (NativeImageReplyInfo)localObject1);
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (localObject3.bytes != null)
      {
        replyChannelBytes(localObject3, paramString, (NativeImageReplyInfo)localObject1);
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localObject3.assetsPath))
      {
        replyAssetImage(localObject3, paramString, (NativeImageReplyInfo)localObject1);
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(localObject3.path))
      {
        replyFilePath(localObject3, paramString, (NativeImageReplyInfo)localObject1);
        bool2 = true;
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localObject3.url))
      {
        replyImageUrl(localObject3, paramString, (NativeImageReplyInfo)localObject1);
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (localObject3.color != null)
      {
        replyImageColor(localObject3, paramString, (NativeImageReplyInfo)localObject1);
        bool2 = true;
      }
    }
    if (localObject3.scale > 0.01D) {
      ((NativeImageReplyInfo)localObject1).scale = localObject3.scale;
    }
    if ((localObject3.isNinePatch) && (localObject3.ninePatchInfo != null)) {
      ((NativeImageReplyInfo)localObject1).ninePatchInfo = localObject3.ninePatchInfo;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("buildImageInfoReply nativeImageID：");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" handled:");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append(" replyInfo:");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(" info:");
    ((StringBuilder)localObject2).append(localObject3);
    Log.d("QFlutterResourceLoader", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public static QFlutterResourceLoader get()
  {
    return QFlutterResourceLoader._Inner._instance;
  }
  
  private Map<String, Object> getNativeThemeInfo()
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("currentThemeId", this.nativeInterface.getThemeId());
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = this.nativeInterface.getNativeThemeColors();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("_loadNativeThemeInfo themeColors: ");
    ((StringBuilder)localObject2).append(localObject1);
    Log.d("QFlutterResourceLoader", ((StringBuilder)localObject2).toString());
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NativeColorInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((NativeColorInfo)localObject2).name)))
        {
          Map localMap = ((NativeColorInfo)localObject2).buildFlutterReply(this.context);
          if (localMap != null) {
            localHashMap2.put(((NativeColorInfo)localObject2).name, localMap);
          }
        }
      }
    }
    localHashMap1.put("nativeColors", localHashMap2);
    return localHashMap1;
  }
  
  private void replyAssetImage(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    String str = paramNativeImageInfo.assetsPath;
    try
    {
      replyRawData(paramNativeImageInfo, paramString, this.context.getAssets().open(str), paramNativeImageReplyInfo);
      return;
    }
    catch (IOException paramNativeImageInfo)
    {
      paramString = new StringBuilder();
      paramString.append("replyAssetImage: ");
      paramString.append(paramNativeImageInfo.getMessage());
      Log.e("QFlutterResourceLoader", paramString.toString());
    }
  }
  
  private boolean replyBitmap(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    Bitmap localBitmap = paramNativeImageInfo.bitmap;
    if (localBitmap != null)
    {
      if ((paramNativeImageInfo.isNinePatch) && (paramNativeImageInfo.ninePatchInfo == null)) {
        paramNativeImageInfo.ninePatchInfo = Utils.getNinePatchInfoFromChunk(paramNativeImageInfo.bitmap.getNinePatchChunk());
      }
      long l = JniInterface.getBitmapPixelDataMemoryPtr(localBitmap);
      if (l != 0L)
      {
        paramNativeImageReplyInfo.type = 3;
        paramNativeImageReplyInfo.pixelsDataAddress = l;
        paramNativeImageReplyInfo.pixelsDataWidth = localBitmap.getWidth();
        paramNativeImageReplyInfo.pixelsDataHeight = localBitmap.getHeight();
        paramNativeImageReplyInfo.pixelsDataFormat = "rgba8888";
        cacheObj(paramString, localBitmap);
        return true;
      }
    }
    return false;
  }
  
  private void replyChannelBytes(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    paramNativeImageReplyInfo.type = 5;
    cacheObj(paramString, paramNativeImageInfo.bytes);
  }
  
  private boolean replyDrawable(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    Object localObject2 = paramNativeImageInfo.drawable;
    if (localObject2 != null)
    {
      Object localObject1;
      if ((localObject2 instanceof BitmapDrawable))
      {
        localObject1 = ((BitmapDrawable)localObject2).getBitmap();
      }
      else if ((localObject2 instanceof NinePatchDrawable))
      {
        localObject2 = Utils.getBitmapFromNinePatchDrawable((NinePatchDrawable)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          paramNativeImageInfo.isNinePatch = true;
          localObject1 = localObject2;
          if (paramNativeImageInfo.ninePatchInfo == null)
          {
            paramNativeImageInfo.ninePatchInfo = Utils.getNinePatchInfoFromChunk(((Bitmap)localObject2).getNinePatchChunk());
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject1 = this.nativeInterface.getBitmapFromDrawable((Drawable)localObject2);
        if ((localObject1 != null) && (this.nativeInterface.isNinePatchDrawable((Drawable)localObject2)))
        {
          paramNativeImageInfo.isNinePatch = true;
          if (paramNativeImageInfo.ninePatchInfo == null) {
            paramNativeImageInfo.ninePatchInfo = this.nativeInterface.getNinePatchInfo((Drawable)localObject2);
          }
          if (paramNativeImageInfo.ninePatchInfo == null) {
            paramNativeImageInfo.ninePatchInfo = Utils.getNinePatchInfoFromChunk(((Bitmap)localObject1).getNinePatchChunk());
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("replyDrawable: ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" ninePatchInfo:");
          ((StringBuilder)localObject2).append(paramNativeImageInfo.ninePatchInfo);
          ((StringBuilder)localObject2).append(" density:");
          ((StringBuilder)localObject2).append(((Bitmap)localObject1).getDensity());
          ((StringBuilder)localObject2).append(" densityDpi:");
          ((StringBuilder)localObject2).append(this.context.getResources().getDisplayMetrics().densityDpi);
          ((StringBuilder)localObject2).append(" \nchunk:");
          ((StringBuilder)localObject2).append(Arrays.toString(((Bitmap)localObject1).getNinePatchChunk()));
          Log.d("QFlutterResourceLoader", ((StringBuilder)localObject2).toString());
        }
      }
      if (localObject1 != null)
      {
        paramNativeImageInfo.bitmap = ((Bitmap)localObject1);
        return replyBitmap(paramNativeImageInfo, paramString, paramNativeImageReplyInfo);
      }
    }
    return false;
  }
  
  private void replyDrawableIdImage(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    paramNativeImageInfo.drawable = this.context.getResources().getDrawable(paramNativeImageInfo.drawableId);
    if (replyDrawable(paramNativeImageInfo, paramString, paramNativeImageReplyInfo)) {
      return;
    }
    try
    {
      replyRawData(paramNativeImageInfo, paramString, this.context.getResources().openRawResource(paramNativeImageInfo.drawableId), paramNativeImageReplyInfo);
      return;
    }
    catch (Exception paramNativeImageInfo)
    {
      paramString = new StringBuilder();
      paramString.append("replyDrawableIdImage: ");
      paramString.append(paramNativeImageInfo.getMessage());
      Log.e("QFlutterResourceLoader", paramString.toString());
    }
  }
  
  private void replyFilePath(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    paramNativeImageReplyInfo.type = 1;
    paramNativeImageReplyInfo.path = paramNativeImageInfo.path;
  }
  
  private void replyImageColor(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    paramNativeImageReplyInfo.type = 6;
    paramNativeImageReplyInfo.color = paramNativeImageInfo.color.intValue();
    paramNativeImageReplyInfo.borderRadius = paramNativeImageInfo.borderRadius;
  }
  
  private void replyImageUrl(NativeImageInfo paramNativeImageInfo, String paramString, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    paramNativeImageReplyInfo.type = 2;
    paramNativeImageReplyInfo.url = paramNativeImageInfo.url;
  }
  
  private void replyRawData(NativeImageInfo paramNativeImageInfo, String paramString, InputStream paramInputStream, NativeImageReplyInfo paramNativeImageReplyInfo)
  {
    try
    {
      int i = paramInputStream.available();
      paramNativeImageInfo = ByteBuffer.allocateDirect(i);
      Object localObject = new byte[Math.min(1024, i)];
      i = paramInputStream.read((byte[])localObject);
      int j = 0;
      while (i != -1)
      {
        j += i;
        paramNativeImageInfo.put((byte[])localObject, 0, i);
        i = paramInputStream.read((byte[])localObject);
      }
      long l = JniInterface.getByteBufferPtr(paramNativeImageInfo);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("replyRawData ptr:");
      ((StringBuilder)localObject).append(l);
      Log.d("QFlutterResourceLoader", ((StringBuilder)localObject).toString());
      paramNativeImageReplyInfo.type = 4;
      paramNativeImageReplyInfo.rawDataAddress = l;
      paramNativeImageReplyInfo.rawDataLength = j;
      cacheObj(paramString, paramNativeImageInfo);
      paramInputStream.close();
      return;
    }
    catch (IOException paramNativeImageInfo)
    {
      paramNativeImageInfo.printStackTrace();
    }
  }
  
  public void cacheObj(String paramString, Object paramObject)
  {
    QFlutterResourceLoader.CacheItem localCacheItem;
    if (this.sCacheObj.containsKey(paramString)) {
      localCacheItem = (QFlutterResourceLoader.CacheItem)this.sCacheObj.get(paramString);
    } else {
      localCacheItem = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cacheBitmap:");
    localStringBuilder.append(paramString);
    Log.i("QFlutterResourceLoader", localStringBuilder.toString());
    if (localCacheItem == null)
    {
      localCacheItem = new QFlutterResourceLoader.CacheItem(this, null);
      localCacheItem.cache(paramObject);
      localCacheItem.increment();
      this.sCacheObj.put(paramString, localCacheItem);
      return;
    }
    if (localCacheItem != null)
    {
      localCacheItem.cache(paramObject);
      localCacheItem.increment();
    }
  }
  
  public void deCache(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("deCache:");
    ((StringBuilder)localObject).append(paramString);
    Log.i("QFlutterResourceLoader", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString)) && (this.sCacheObj.containsKey(paramString)))
    {
      localObject = (QFlutterResourceLoader.CacheItem)this.sCacheObj.get(paramString);
      if ((localObject != null) && (((QFlutterResourceLoader.CacheItem)localObject).decrement())) {
        this.sCacheObj.remove(paramString);
      }
    }
  }
  
  public void deCacheAll()
  {
    this.sCacheObj.clear();
  }
  
  public void getNativeImageRawByteList(String paramString, MethodChannel.Result paramResult)
  {
    QFlutterResourceLoader.CacheItem localCacheItem = (QFlutterResourceLoader.CacheItem)this.sCacheObj.get(paramString);
    if ((localCacheItem != null) && (localCacheItem.bytes != null))
    {
      paramResult.success(localCacheItem.bytes);
      deCache(paramString);
      return;
    }
    paramResult.success(null);
  }
  
  public void init(Context paramContext, NativeAppInterface paramNativeAppInterface)
  {
    this.context = paramContext.getApplicationContext();
    this.nativeInterface = paramNativeAppInterface;
    if (!this.sJniSoLoaded)
    {
      NativeBitmap.init(paramNativeAppInterface.getLibPath());
      this.sJniSoLoaded = true;
    }
  }
  
  public void loadNativeImageInfo(String paramString, MethodChannel.Result paramResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadNativeImageInfo nativeImageID：");
    localStringBuilder.append(paramString);
    Log.d("QFlutterResourceLoader", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      paramResult.success(new NativeImageReplyInfo());
      return;
    }
    if ((this.nativeInterface.getSubThreadHandler() != null) && (this.nativeInterface.getUiThreadHandler() != null))
    {
      this.nativeInterface.getSubThreadHandler().post(new QFlutterResourceLoader.2(this, paramString, paramResult));
      return;
    }
    paramResult.success(buildImageInfoReply(paramString).buildFlutterReply());
  }
  
  public void loadNativeThemeInfo(MethodChannel.Result paramResult)
  {
    Log.d("QFlutterResourceLoader", "loadNativeThemeInfo");
    if ((this.nativeInterface.getSubThreadHandler() != null) && (this.nativeInterface.getUiThreadHandler() != null))
    {
      this.nativeInterface.getSubThreadHandler().post(new QFlutterResourceLoader.1(this, paramResult));
      return;
    }
    paramResult.success(getNativeThemeInfo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.resource_loader.QFlutterResourceLoader
 * JD-Core Version:    0.7.0.1
 */