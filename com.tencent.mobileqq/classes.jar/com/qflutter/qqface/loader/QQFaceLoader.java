package com.qflutter.qqface.loader;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.qflutter.qqface.QQFacePlugin;
import com.qflutter.qqface.cache.BitmapCache;
import com.qflutter.qqface.data.QQFaceFlutterData;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
import com.tencent.nativebmp.NativeBitmap;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QQFaceLoader
{
  public static final String TAG = "QQFaceLoader";
  private BitmapCache mBitmapCache;
  private QQFaceInterface mQQFaceInterface;
  private Set<QQFacePlugin> mQQFacePlugins;
  private HandlerThread mQQFaceThread = new HandlerThread("QQFaceLoader");
  private Handler mSubHandler;
  private Handler mUIHandler;
  
  private QQFaceLoader()
  {
    this.mQQFaceThread.start();
    this.mUIHandler = new Handler();
    this.mSubHandler = new Handler(this.mQQFaceThread.getLooper());
    this.mBitmapCache = new BitmapCache();
    this.mQQFacePlugins = new HashSet();
  }
  
  private QQFaceFlutterData buildFlutterDate(String paramString, QQFaceNativeData paramQQFaceNativeData, boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildFlutterDate, shareBitmap: ");
    ((StringBuilder)localObject).append(paramBoolean);
    Log.d("QQFaceLoader", ((StringBuilder)localObject).toString());
    localObject = new QQFaceFlutterData(paramString);
    Bitmap localBitmap = paramQQFaceNativeData.getBitmap();
    String str = paramQQFaceNativeData.getPath();
    byte[] arrayOfByte = paramQQFaceNativeData.getRawData();
    boolean bool1 = bool3;
    if (localBitmap != null)
    {
      bool1 = bool3;
      if (paramBoolean)
      {
        long l = NativeBitmap.getBitmapPixelDataMemoryPtr(localBitmap);
        bool1 = bool3;
        if (l > 0L)
        {
          ((QQFaceFlutterData)localObject).dataFormat = 0;
          ((QQFaceFlutterData)localObject).bitmapPtr = l;
          ((QQFaceFlutterData)localObject).bitmapWidth = localBitmap.getWidth();
          ((QQFaceFlutterData)localObject).bitmapHeight = localBitmap.getHeight();
          ((QQFaceFlutterData)localObject).pixelsFormat = "rgba8888";
          ((QQFaceFlutterData)localObject).isDefault = paramQQFaceNativeData.isDefaultFace;
          if (!paramQQFaceNativeData.isDefaultFace) {
            this.mBitmapCache.addCache(paramString, localBitmap);
          }
          bool1 = true;
        }
      }
    }
    paramBoolean = bool1;
    if (!bool1)
    {
      paramBoolean = bool1;
      if (arrayOfByte != null)
      {
        ((QQFaceFlutterData)localObject).dataFormat = 1;
        ((QQFaceFlutterData)localObject).rawData = arrayOfByte;
        paramBoolean = true;
      }
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(str)))
    {
      ((QQFaceFlutterData)localObject).dataFormat = 2;
      ((QQFaceFlutterData)localObject).path = str;
      paramBoolean = bool2;
    }
    for (;;)
    {
      paramString = new StringBuilder();
      paramString.append("buildFlutterDate dataFormat: ");
      paramString.append(((QQFaceFlutterData)localObject).dataFormat);
      paramString.append(", handle: ");
      paramString.append(paramBoolean);
      paramString.append(", isDefault: ");
      paramString.append(((QQFaceFlutterData)localObject).isDefault);
      Log.d("QQFaceLoader", paramString.toString());
      return localObject;
    }
  }
  
  public static QQFaceLoader instance()
  {
    return QQFaceLoader.QQFaceLoaderHolder.access$100();
  }
  
  public void asyncLoadQQFace(QQFaceParam paramQQFaceParam, MethodChannel.Result paramResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asyncLoadQQFace qqFaceParam: ");
    localStringBuilder.append(paramQQFaceParam);
    Log.d("QQFaceLoader", localStringBuilder.toString());
    this.mSubHandler.post(new QQFaceLoader.1(this, paramQQFaceParam, paramResult));
  }
  
  public void clearCache()
  {
    Log.d("QQFaceLoader", "clearCache");
    this.mBitmapCache.clearCache();
    this.mQQFaceInterface.clearCache();
  }
  
  public void init(QQFaceInterface paramQQFaceInterface)
  {
    this.mQQFaceInterface = paramQQFaceInterface;
    NativeBitmap.init(paramQQFaceInterface.getLibPath());
  }
  
  public void onAttachedToEngine(QQFacePlugin paramQQFacePlugin)
  {
    Log.d("QQFaceLoader", "onAttachedToEngine");
    this.mQQFacePlugins.add(paramQQFacePlugin);
  }
  
  public void onDestroy()
  {
    if (this.mQQFaceInterface != null) {
      this.mQQFaceInterface.onDestroy();
    }
  }
  
  public void onDetachedFromEngine(QQFacePlugin paramQQFacePlugin)
  {
    Log.d("QQFaceLoader", "onDetachedFromEngine");
    if (this.mQQFacePlugins.contains(paramQQFacePlugin)) {
      this.mQQFacePlugins.remove(paramQQFacePlugin);
    }
  }
  
  public void onUpdate(String paramString, QQFaceNativeData paramQQFaceNativeData)
  {
    paramString = buildFlutterDate(paramString, paramQQFaceNativeData, true);
    paramQQFaceNativeData = this.mQQFacePlugins.iterator();
    while (paramQQFaceNativeData.hasNext()) {
      ((QQFacePlugin)paramQQFaceNativeData.next()).updateHead(paramString);
    }
  }
  
  public void removeCache(String paramString, int paramInt)
  {
    this.mBitmapCache.removeCache(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqface.loader.QQFaceLoader
 * JD-Core Version:    0.7.0.1
 */