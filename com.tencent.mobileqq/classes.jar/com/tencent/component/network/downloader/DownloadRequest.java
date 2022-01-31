package com.tencent.component.network.downloader;

import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.utils.AssertUtil;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DownloadRequest
{
  private boolean mCacheEntry = false;
  private boolean mIsCanceled = false;
  private Downloader.DownloadListener mListener;
  private Map mParams;
  private final String[] mPaths;
  private final String mUrl;
  public Downloader.DownloadMode mode = Downloader.DownloadMode.FastMode;
  public boolean needMd5 = false;
  public OutputStream outputStream;
  public long range;
  
  public DownloadRequest(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    boolean bool1 = bool2;
    if (Utils.checkUrl(paramString))
    {
      bool1 = bool2;
      if (paramArrayOfString != null) {
        bool1 = true;
      }
    }
    AssertUtil.a(bool1);
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
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    if (this.mParams == null) {
      this.mParams = new HashMap();
    }
    this.mParams.put(paramString1, paramString2);
  }
  
  public void cancel()
  {
    this.mIsCanceled = true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof DownloadRequest))) {
        return false;
      }
      paramObject = (DownloadRequest)paramObject;
    } while ((this.mUrl.equalsIgnoreCase(paramObject.mUrl)) && (equalsObject(this.mListener, paramObject.mListener)));
    return false;
  }
  
  public Downloader.DownloadListener getListener()
  {
    return this.mListener;
  }
  
  public Map getParams()
  {
    return this.mParams;
  }
  
  public String getPath()
  {
    if ((this.mPaths != null) && (this.mPaths.length > 0)) {
      return this.mPaths[0];
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
    return (this.mUrl.hashCode() + 527) * 31 + hashCodeObject(this.mListener);
  }
  
  public boolean isCanceled()
  {
    return this.mIsCanceled;
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