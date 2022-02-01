package com.tencent.image;

import java.net.URL;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;

public class DownloadParams
{
  public CookieStore cookies;
  public long downloaded;
  public Header[] headers;
  public boolean mAutoScaleByDensity;
  public DownloadParams.DecodeHandler mDecodeHandler;
  public Object mExtraInfo;
  public float mGifRoundCorner;
  public Object mHttpDownloaderParams;
  public int mImgType;
  public boolean needCheckNetType = false;
  public int outHeight;
  public int outOrientation = 0;
  public int outWidth;
  public int reqHeight;
  public int reqWidth;
  public int retryCount = 0;
  public Object tag;
  public URL url;
  public String urlStr;
  public boolean useApngImage;
  public boolean useExifOrientation;
  public boolean useGifAnimation;
  public boolean useSharpPImage;
  
  public Header getHeader(String paramString)
  {
    Header[] arrayOfHeader = this.headers;
    if (arrayOfHeader != null)
    {
      int j = arrayOfHeader.length;
      int i = 0;
      while (i < j)
      {
        Header localHeader = arrayOfHeader[i];
        if ((paramString != null) && (paramString.equals(localHeader.getName()))) {
          return localHeader;
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.DownloadParams
 * JD-Core Version:    0.7.0.1
 */