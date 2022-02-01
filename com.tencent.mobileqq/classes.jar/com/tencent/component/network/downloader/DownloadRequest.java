package com.tencent.component.network.downloader;

import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.utils.AssertUtil;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DownloadRequest
{
  private long fileSizeForRangeMode;
  private boolean mCacheEntry;
  private boolean mIsCanceled;
  private Downloader.DownloadListener mListener;
  private Map<String, String> mParams;
  private final String[] mPaths;
  private final String mUrl;
  public Downloader.DownloadMode mode;
  public boolean needMd5;
  public DownloadRequest.OnResponseDataListener onResponseDataListener;
  public OutputStream outputStream;
  public float progressCallbackStep;
  public long range;
  public int rangeNumber;
  
  public DownloadRequest(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    boolean bool2 = false;
    this.mIsCanceled = false;
    this.mCacheEntry = false;
    this.mode = Downloader.DownloadMode.FastMode;
    this.progressCallbackStep = 0.0F;
    this.needMd5 = false;
    boolean bool1 = bool2;
    if (Utils.checkUrl(paramString))
    {
      bool1 = bool2;
      if (paramArrayOfString != null) {
        bool1 = true;
      }
    }
    AssertUtil.assertTrue(bool1);
    this.mUrl = paramString;
    this.mPaths = paramArrayOfString;
    this.mListener = paramDownloadListener;
    this.mCacheEntry = paramBoolean;
  }
  
  private static boolean equalsObject(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private static int hashCodeObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  public void addParam(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      if (this.mParams == null) {
        this.mParams = new HashMap();
      }
      this.mParams.put(paramString1, paramString2);
    }
  }
  
  public void cancel()
  {
    this.mIsCanceled = true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof DownloadRequest)) {
        return false;
      }
      paramObject = (DownloadRequest)paramObject;
      return (this.mUrl.equalsIgnoreCase(paramObject.mUrl)) && (equalsObject(this.mListener, paramObject.mListener));
    }
    return false;
  }
  
  public long getFileSizeForRangeMode()
  {
    return this.fileSizeForRangeMode;
  }
  
  public Downloader.DownloadListener getListener()
  {
    return this.mListener;
  }
  
  public Map<String, String> getParams()
  {
    return this.mParams;
  }
  
  public String getPath()
  {
    String[] arrayOfString = this.mPaths;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return arrayOfString[0];
    }
    return null;
  }
  
  public String[] getPaths()
  {
    return this.mPaths;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public int hashCode()
  {
    return (527 + this.mUrl.hashCode()) * 31 + hashCodeObject(this.mListener);
  }
  
  public boolean isCanceled()
  {
    return this.mIsCanceled;
  }
  
  public void setFileSizeForRangeMode(long paramLong)
  {
    this.fileSizeForRangeMode = paramLong;
  }
  
  public void setListener(Downloader.DownloadListener paramDownloadListener)
  {
    this.mListener = paramDownloadListener;
  }
  
  public boolean shouldCacheEntry()
  {
    return this.mCacheEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadRequest
 * JD-Core Version:    0.7.0.1
 */