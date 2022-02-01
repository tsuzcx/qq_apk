package com.tencent.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.tencent.image.downloader.IllegalURLDownloader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Executor;

public abstract class URLDrawableParams
{
  public static final int TASK_TYPE_ASYNC_TASK = 0;
  public static final int TASK_TYPE_SWING_WORKER = 1;
  public boolean mAutoScaleByDensity = true;
  public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  int mDeviceDensity = 160;
  private Hashtable<String, ProtocolDownloader> mDownLoaderMap = new Hashtable();
  public boolean mFadeInImage = true;
  HashMap<String, String> mLocalFileMap = new HashMap();
  int mMemoryCacheSize = 5242880;
  public int mReqHeight;
  public int mReqWidth;
  public Handler mSubHandler;
  public Executor mURLDrawableExecutor;
  public boolean mUseGifAnimation = true;
  
  public URLDrawableParams(Context paramContext)
  {
    this.mDeviceDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.mReqWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.mReqHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  protected abstract ProtocolDownloader doGetDownloader(String paramString, Object paramObject);
  
  protected abstract String doGetLocalFilePath(String paramString);
  
  protected abstract ApngSoLoader getApngSoLoader();
  
  protected abstract Drawable getDefaultLoadingDrawable();
  
  protected abstract Drawable getDefualtFailedDrawable();
  
  ProtocolDownloader getDownloader(String paramString, Object paramObject)
  {
    ProtocolDownloader localProtocolDownloader = (ProtocolDownloader)this.mDownLoaderMap.get(paramString);
    Object localObject = localProtocolDownloader;
    if (localProtocolDownloader == null)
    {
      localObject = doGetDownloader(paramString, paramObject);
      paramObject = localObject;
      if (localObject == null) {
        if ("file".equalsIgnoreCase(paramString))
        {
          paramObject = new LocaleFileDownloader();
        }
        else if ("qqlive".equalsIgnoreCase(paramString))
        {
          paramObject = new QQLiveDownloader();
        }
        else
        {
          paramObject = localObject;
          if ("illegalurl".equals(paramString)) {
            paramObject = new IllegalURLDownloader();
          }
        }
      }
      localObject = paramObject;
      if (paramObject != null)
      {
        this.mDownLoaderMap.put(paramString, paramObject);
        localObject = paramObject;
      }
    }
    return localObject;
  }
  
  String getLocalFilePath(String paramString)
  {
    String str2 = (String)this.mLocalFileMap.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str2 = doGetLocalFilePath(paramString);
      str1 = str2;
      if (str2 != null)
      {
        this.mLocalFileMap.put(paramString, str2);
        str1 = str2;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.URLDrawableParams
 * JD-Core Version:    0.7.0.1
 */