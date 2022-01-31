package com.qflutter.qflutter_skin_engine;

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
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QFlutterSkinEngine
{
  public static final String TAG = "QFlutterSkinEngine";
  private Context context;
  private String mCurrentThemeId = "0";
  private String mSkinCachePath;
  private QFlutterSkinEngineNativeInterface nativeInterface;
  private ConcurrentHashMap<String, CacheItem> sCacheObj = new ConcurrentHashMap();
  private boolean sJniSoLoaded = false;
  
  private void buildImageInfoForFlutterAndReply(String paramString, NativeImageInfo paramNativeImageInfo, boolean paramBoolean, MethodChannel.Result paramResult)
  {
    if ((paramNativeImageInfo == null) || (paramNativeImageInfo.isNull())) {
      paramResult.success(NativeImageInfoForFlutter.defaultErrorImage());
    }
    while (((paramNativeImageInfo.bitmap != null) && (replyBitmap(paramNativeImageInfo, paramString, paramResult))) || ((paramNativeImageInfo.drawable != null) && (replyDrawable(paramNativeImageInfo, paramString, paramResult)))) {
      return;
    }
    if (paramNativeImageInfo.drawableId != 0)
    {
      replyDrawableIdImage(paramNativeImageInfo, paramString, paramResult);
      return;
    }
    if (!TextUtils.isEmpty(paramNativeImageInfo.assetsPath))
    {
      replyAssetImage(paramNativeImageInfo, paramString, paramResult);
      return;
    }
    if (!TextUtils.isEmpty(paramNativeImageInfo.path))
    {
      replyFilePath(paramNativeImageInfo, paramNativeImageInfo.path, paramResult);
      return;
    }
    if (!TextUtils.isEmpty(paramNativeImageInfo.url))
    {
      replyImageUrl(paramNativeImageInfo, paramResult);
      return;
    }
    if (paramNativeImageInfo.color != null)
    {
      replyImageColor(paramNativeImageInfo, paramResult);
      return;
    }
    paramResult.success(NativeImageInfoForFlutter.defaultErrorImage());
  }
  
  public static QFlutterSkinEngine get()
  {
    return QFlutterSkinEngine._Inner._instance;
  }
  
  private Map<String, Object> getNativeThemeInfo()
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("currentThemeId", this.mCurrentThemeId);
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = this.nativeInterface.getNativeSkinColors();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("_loadNativeThemeInfo skinColors: ");
    ((StringBuilder)localObject2).append(localObject1);
    Log.d("QFlutterSkinEngine", ((StringBuilder)localObject2).toString());
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
  
  private void replyAssetImage(NativeImageInfo paramNativeImageInfo, String paramString, MethodChannel.Result paramResult)
  {
    String str = paramNativeImageInfo.assetsPath;
    try
    {
      replyRawData(paramNativeImageInfo, this.context.getAssets().open(str), paramString, paramResult);
      return;
    }
    catch (IOException paramNativeImageInfo)
    {
      paramString = new StringBuilder();
      paramString.append("replyAssetImage: ");
      paramString.append(paramNativeImageInfo.getMessage());
      Log.e("QFlutterSkinEngine", paramString.toString());
    }
  }
  
  private boolean replyBitmap(NativeImageInfo paramNativeImageInfo, String paramString, MethodChannel.Result paramResult)
  {
    Bitmap localBitmap = paramNativeImageInfo.bitmap;
    if (localBitmap != null)
    {
      if ((paramNativeImageInfo.isNinePatch) && (paramNativeImageInfo.ninePatchInfo == null)) {
        paramNativeImageInfo.ninePatchInfo = QFlutterSkinEngineUtils.getNinePatchInfoFromChunk(paramNativeImageInfo.bitmap.getNinePatchChunk());
      }
      long l = QFlutterSkinEngineJniInterface.getBitmapPixelDataMemoryPtr(localBitmap);
      if (l != 0L)
      {
        NativeImageInfoForFlutter localNativeImageInfoForFlutter = new NativeImageInfoForFlutter();
        localNativeImageInfoForFlutter.type = 3;
        localNativeImageInfoForFlutter.pixelsDataAddress = l;
        localNativeImageInfoForFlutter.pixelsDataWidth = localBitmap.getWidth();
        localNativeImageInfoForFlutter.pixelsDataHeight = localBitmap.getHeight();
        localNativeImageInfoForFlutter.pixelsDataFormat = "rgba8888";
        if (paramNativeImageInfo.scale > 0.01D) {
          localNativeImageInfoForFlutter.scale = paramNativeImageInfo.scale;
        }
        if ((paramNativeImageInfo.isNinePatch) && (paramNativeImageInfo.ninePatchInfo != null)) {
          localNativeImageInfoForFlutter.ninePatchInfo = paramNativeImageInfo.ninePatchInfo;
        }
        cacheObj(paramString, localBitmap);
        paramResult.success(localNativeImageInfoForFlutter.buildFlutterReply());
        return true;
      }
    }
    return false;
  }
  
  private boolean replyDrawable(NativeImageInfo paramNativeImageInfo, String paramString, MethodChannel.Result paramResult)
  {
    Object localObject2 = paramNativeImageInfo.drawable;
    if (localObject2 != null)
    {
      Object localObject1;
      if ((localObject2 instanceof BitmapDrawable)) {
        localObject1 = ((BitmapDrawable)localObject2).getBitmap();
      }
      while (localObject1 != null)
      {
        paramNativeImageInfo.bitmap = ((Bitmap)localObject1);
        return replyBitmap(paramNativeImageInfo, paramString, paramResult);
        if ((localObject2 instanceof NinePatchDrawable))
        {
          localObject2 = QFlutterSkinEngineUtils.getBitmapFromNinePatchDrawable((NinePatchDrawable)localObject2);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            paramNativeImageInfo.isNinePatch = true;
            localObject1 = localObject2;
            if (paramNativeImageInfo.ninePatchInfo == null)
            {
              paramNativeImageInfo.ninePatchInfo = QFlutterSkinEngineUtils.getNinePatchInfoFromChunk(((Bitmap)localObject2).getNinePatchChunk());
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
              paramNativeImageInfo.ninePatchInfo = QFlutterSkinEngineUtils.getNinePatchInfoFromChunk(((Bitmap)localObject1).getNinePatchChunk());
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
            Log.d("QFlutterSkinEngine", ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    return false;
  }
  
  private void replyDrawableIdImage(NativeImageInfo paramNativeImageInfo, String paramString, MethodChannel.Result paramResult)
  {
    paramNativeImageInfo.drawable = this.context.getResources().getDrawable(paramNativeImageInfo.drawableId);
    if (replyDrawable(paramNativeImageInfo, paramString, paramResult)) {
      return;
    }
    try
    {
      replyRawData(paramNativeImageInfo, this.context.getResources().openRawResource(paramNativeImageInfo.drawableId), paramString, paramResult);
      return;
    }
    catch (Exception paramNativeImageInfo)
    {
      paramString = new StringBuilder();
      paramString.append("replyDrawableIdImage: ");
      paramString.append(paramNativeImageInfo.getMessage());
      Log.e("QFlutterSkinEngine", paramString.toString());
    }
  }
  
  private void replyFilePath(NativeImageInfo paramNativeImageInfo, String paramString, MethodChannel.Result paramResult)
  {
    NativeImageInfoForFlutter localNativeImageInfoForFlutter = new NativeImageInfoForFlutter();
    localNativeImageInfoForFlutter.type = 1;
    localNativeImageInfoForFlutter.path = paramString;
    if (paramNativeImageInfo.scale > 0.01D) {
      localNativeImageInfoForFlutter.scale = paramNativeImageInfo.scale;
    }
    if ((paramNativeImageInfo.isNinePatch) && (paramNativeImageInfo.ninePatchInfo != null)) {
      localNativeImageInfoForFlutter.ninePatchInfo = paramNativeImageInfo.ninePatchInfo;
    }
    paramResult.success(localNativeImageInfoForFlutter.buildFlutterReply());
  }
  
  private void replyImageColor(NativeImageInfo paramNativeImageInfo, MethodChannel.Result paramResult)
  {
    NativeImageInfoForFlutter localNativeImageInfoForFlutter = new NativeImageInfoForFlutter();
    localNativeImageInfoForFlutter.type = 6;
    localNativeImageInfoForFlutter.color = paramNativeImageInfo.color.intValue();
    localNativeImageInfoForFlutter.borderRadius = paramNativeImageInfo.borderRadius;
    paramResult.success(localNativeImageInfoForFlutter.buildFlutterReply());
  }
  
  private void replyImageUrl(NativeImageInfo paramNativeImageInfo, MethodChannel.Result paramResult)
  {
    NativeImageInfoForFlutter localNativeImageInfoForFlutter = new NativeImageInfoForFlutter();
    localNativeImageInfoForFlutter.type = 2;
    localNativeImageInfoForFlutter.url = paramNativeImageInfo.url;
    if (paramNativeImageInfo.scale > 0.01D) {
      localNativeImageInfoForFlutter.scale = paramNativeImageInfo.scale;
    }
    if ((paramNativeImageInfo.isNinePatch) && (paramNativeImageInfo.ninePatchInfo != null)) {
      localNativeImageInfoForFlutter.ninePatchInfo = paramNativeImageInfo.ninePatchInfo;
    }
    paramResult.success(localNativeImageInfoForFlutter.buildFlutterReply());
  }
  
  private void replyRawData(NativeImageInfo paramNativeImageInfo, InputStream paramInputStream, String paramString, MethodChannel.Result paramResult)
  {
    int j = 0;
    try
    {
      int i = paramInputStream.available();
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(i);
      Object localObject = new byte[Math.min(1024, i)];
      for (i = paramInputStream.read((byte[])localObject); i != -1; i = paramInputStream.read((byte[])localObject))
      {
        j += i;
        localByteBuffer.put((byte[])localObject, 0, i);
      }
      long l = QFlutterSkinEngineJniInterface.getByteBufferPtr(localByteBuffer);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("replyRawData ptr:");
      ((StringBuilder)localObject).append(l);
      Log.d("QFlutterSkinEngine", ((StringBuilder)localObject).toString());
      localObject = new NativeImageInfoForFlutter();
      ((NativeImageInfoForFlutter)localObject).type = 4;
      ((NativeImageInfoForFlutter)localObject).rawDataAddress = l;
      ((NativeImageInfoForFlutter)localObject).rawDataLength = j;
      if (paramNativeImageInfo.scale > 0.01D) {
        ((NativeImageInfoForFlutter)localObject).scale = paramNativeImageInfo.scale;
      }
      if ((paramNativeImageInfo.isNinePatch) && (paramNativeImageInfo.ninePatchInfo != null)) {
        ((NativeImageInfoForFlutter)localObject).ninePatchInfo = paramNativeImageInfo.ninePatchInfo;
      }
      cacheObj(paramString, localByteBuffer);
      paramResult.success(((NativeImageInfoForFlutter)localObject).buildFlutterReply());
      paramInputStream.close();
      return;
    }
    catch (IOException paramNativeImageInfo)
    {
      paramNativeImageInfo.printStackTrace();
    }
  }
  
  private boolean writeFile(InputStream paramInputStream, File paramFile)
  {
    try
    {
      Object localObject = paramFile.getParentFile();
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramFile = new FileOutputStream(paramFile);
      localObject = new byte[1024];
      for (int i = paramInputStream.read((byte[])localObject); i != -1; i = paramInputStream.read((byte[])localObject)) {
        paramFile.write((byte[])localObject, 0, i);
      }
      paramFile.flush();
      paramInputStream.close();
      paramFile.close();
      return true;
    }
    catch (IOException paramInputStream)
    {
      paramFile = new StringBuilder();
      paramFile.append("writeFile: ");
      paramFile.append(paramInputStream.getMessage());
      Log.e("QFlutterSkinEngine", paramFile.toString());
    }
    return false;
  }
  
  public void cacheObj(String paramString, Object paramObject)
  {
    CacheItem localCacheItem;
    if (this.sCacheObj.containsKey(paramString))
    {
      localCacheItem = (CacheItem)this.sCacheObj.get(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cacheBitmap:");
      localStringBuilder.append(paramString);
      Log.i("QFlutterSkinEngine", localStringBuilder.toString());
      if (localCacheItem != null) {
        break label96;
      }
      localCacheItem = new CacheItem();
      localCacheItem.cache(paramObject);
      localCacheItem.increment();
      this.sCacheObj.put(paramString, localCacheItem);
    }
    label96:
    while (localCacheItem == null)
    {
      return;
      localCacheItem = null;
      break;
    }
    localCacheItem.cache(paramObject);
    localCacheItem.increment();
  }
  
  public void deCache(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("deCache:");
    ((StringBuilder)localObject).append(paramString);
    Log.i("QFlutterSkinEngine", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString)) && (this.sCacheObj.containsKey(paramString)))
    {
      localObject = (CacheItem)this.sCacheObj.get(paramString);
      if ((localObject != null) && (((CacheItem)localObject).decrement())) {
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
    CacheItem localCacheItem = (CacheItem)this.sCacheObj.get(paramString);
    if ((localCacheItem != null) && (localCacheItem.bytes != null))
    {
      paramResult.success(((CacheItem)this.sCacheObj.get(paramString)).bytes);
      return;
    }
    paramResult.success(null);
  }
  
  public void init(Context paramContext, QFlutterSkinEngineNativeInterface paramQFlutterSkinEngineNativeInterface)
  {
    this.context = paramContext.getApplicationContext();
    this.nativeInterface = paramQFlutterSkinEngineNativeInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getCacheDir().getPath());
    localStringBuilder.append("/default_theme/");
    this.mSkinCachePath = localStringBuilder.toString();
    if (!this.sJniSoLoaded)
    {
      paramQFlutterSkinEngineNativeInterface.loadJniSo();
      this.sJniSoLoaded = true;
    }
  }
  
  public void loadNativeImageInfo(String paramString, boolean paramBoolean, MethodChannel.Result paramResult)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramResult.success(NativeImageInfoForFlutter.defaultErrorImage());
      return;
    }
    NativeImageInfo localNativeImageInfo1 = null;
    if (!TextUtils.isEmpty(paramString)) {
      localNativeImageInfo1 = this.nativeInterface.getNativeAppImage(paramString);
    }
    Object localObject;
    if (localNativeImageInfo1 != null)
    {
      localObject = localNativeImageInfo1;
      if (!localNativeImageInfo1.isNull()) {}
    }
    else
    {
      NativeImageInfo localNativeImageInfo2 = localNativeImageInfo1;
      if (localNativeImageInfo1 == null) {
        localNativeImageInfo2 = new NativeImageInfo();
      }
      if ((!paramString.startsWith("https:")) && (!paramString.startsWith("http:")) && (!paramString.startsWith("HTTPS:")))
      {
        localObject = localNativeImageInfo2;
        if (!paramString.startsWith("HTTP:")) {}
      }
      else
      {
        localNativeImageInfo2.url = paramString;
        localObject = localNativeImageInfo2;
      }
    }
    buildImageInfoForFlutterAndReply(paramString, (NativeImageInfo)localObject, paramBoolean, paramResult);
  }
  
  public void loadNativeThemeInfo(MethodChannel.Result paramResult)
  {
    Log.d("QFlutterSkinEngine", "loadNativeThemeInfo");
    if ((this.nativeInterface.getSubThreadHandler() != null) && (this.nativeInterface.getUiThreadHandler() != null))
    {
      this.nativeInterface.getSubThreadHandler().post(new QFlutterSkinEngine.1(this, paramResult));
      return;
    }
    paramResult.success(getNativeThemeInfo());
  }
  
  public void onPostThemeChanged(String paramString)
  {
    this.mCurrentThemeId = paramString;
    QFlutterSkinEnginePlugin.onPostThemeChanged(paramString);
  }
  
  public void setCurrentThemeId(String paramString)
  {
    if (!TextUtils.equals(this.mCurrentThemeId, paramString)) {
      onPostThemeChanged(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qflutter.qflutter_skin_engine.QFlutterSkinEngine
 * JD-Core Version:    0.7.0.1
 */