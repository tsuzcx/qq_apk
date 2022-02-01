package com.tencent.image;

import android.graphics.drawable.Drawable;
import com.tencent.image.api.ICache;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;

public class URLDrawable$URLDrawableOptions
{
  private static final int MAX_POOL_SIZE = 30;
  private static final String TAG = "URLDrawableOptions";
  private static URLDrawableOptions sPool;
  private static int sPoolSize = 0;
  private static final Object sPoolSync = new Object();
  public boolean isFlashPic = false;
  public int mDecodeFileStrategy = 1;
  public Object mExtraInfo;
  public Drawable mFailedDrawable = null;
  public float mGifRoundCorner = 0.0F;
  public Object mHttpDownloaderParams;
  public int mImgType;
  public boolean mKeyAddWHSuffix = true;
  public Drawable mLoadingDrawable = null;
  public String mMemoryCacheKeySuffix = null;
  public boolean mNeedCheckNetType = false;
  private URLDrawableOptions mNext;
  public boolean mPlayGifImage = false;
  public byte mPriority = URLDrawable.depImp.mCache.getNormalPriority();
  private boolean mRecycled = false;
  public int mRequestHeight = 0;
  public int mRequestWidth = 0;
  public int mRetryCount = 0;
  public boolean mUseApngImage = false;
  public boolean mUseAutoScaleParams = true;
  public boolean mUseExifOrientation = true;
  public boolean mUseMemoryCache = true;
  public boolean mUseSharpPImage = false;
  public boolean mUseThreadPool = true;
  public boolean mUseUnFinishCache = true;
  
  private void clearForRecycle()
  {
    this.mRequestWidth = 0;
    this.mRequestHeight = 0;
    this.mLoadingDrawable = null;
    this.mFailedDrawable = null;
    this.mPlayGifImage = false;
    this.mUseApngImage = false;
    this.mUseSharpPImage = false;
    this.mGifRoundCorner = 0.0F;
    this.mUseAutoScaleParams = true;
    this.mUseExifOrientation = true;
    this.mUseMemoryCache = true;
    this.mUseUnFinishCache = true;
    this.mUseThreadPool = true;
    this.mRecycled = true;
    this.mExtraInfo = null;
    this.mMemoryCacheKeySuffix = null;
    this.mPriority = URLDrawable.depImp.mCache.getNormalPriority();
    this.mHttpDownloaderParams = null;
    this.mNeedCheckNetType = false;
    this.mKeyAddWHSuffix = true;
    this.mDecodeFileStrategy = 1;
  }
  
  public static URLDrawableOptions obtain()
  {
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        sPool.mUseApngImage = false;
        sPool.mExtraInfo = null;
        sPool.mHttpDownloaderParams = null;
        localURLDrawableOptions = sPool;
        sPool = localURLDrawableOptions.mNext;
        localURLDrawableOptions.mRecycled = false;
        localURLDrawableOptions.mNext = null;
        localURLDrawableOptions.isFlashPic = false;
        sPoolSize -= 1;
        return localURLDrawableOptions;
      }
      URLDrawableOptions localURLDrawableOptions = new URLDrawableOptions();
      return localURLDrawableOptions;
    }
  }
  
  public void Recycle()
  {
    if (this.mRecycled) {
      return;
    }
    clearForRecycle();
    for (;;)
    {
      synchronized (sPoolSync)
      {
        if (sPoolSize < 30)
        {
          this.mNext = sPool;
          sPool = this;
          sPoolSize += 1;
          return;
        }
      }
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.i("URLDrawableOptions", 2, "URLDrawableOptions pool size is full");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawable.URLDrawableOptions
 * JD-Core Version:    0.7.0.1
 */