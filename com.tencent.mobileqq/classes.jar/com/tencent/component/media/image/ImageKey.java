package com.tencent.component.media.image;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;
import java.util.LinkedList;

public class ImageKey
{
  private static int keyIndex;
  private static LinkedList<ImageKey> mObjectCache = new LinkedList();
  public String bigUrl;
  public String filePath = null;
  public byte flag = 0;
  private int hashCodeEx = 0;
  public ImageLoader.ImageDownloadListener imglistener = null;
  public int inSampleSize;
  public boolean isHighScaleUrl = false;
  public boolean isNetworkUrl = true;
  public boolean isSuperResolutionUrl = false;
  private int keySeq = 0;
  public ImageLoader.ImageLoadListener listener = null;
  public boolean needCallBackProcessPercent = false;
  public boolean needSuperResolution = true;
  public ImageLoader.Options options = null;
  public int orgHeight;
  public int orgWidth;
  public String srUrl;
  public ImageLoader.StreamDownloadListener streamDownloadListener = null;
  public String url = null;
  public String urlKey = null;
  public Integer urlKeyHashCode;
  
  static
  {
    keyIndex = 0;
    clearAndInitSize();
  }
  
  private ImageKey(int paramInt)
  {
    this.keySeq = paramInt;
  }
  
  public static void clearAndInitSize()
  {
    synchronized (mObjectCache)
    {
      mObjectCache.clear();
      int i = 0;
      while (i < 100)
      {
        LinkedList localLinkedList2 = mObjectCache;
        int j = keyIndex;
        keyIndex = j + 1;
        localLinkedList2.add(new ImageKey(j));
        i += 1;
      }
      return;
    }
  }
  
  public static ImageKey copy(ImageKey paramImageKey)
  {
    ImageKey localImageKey = obtain();
    localImageKey.urlKey = paramImageKey.urlKey;
    localImageKey.url = paramImageKey.url;
    localImageKey.isNetworkUrl = paramImageKey.isNetworkUrl;
    localImageKey.filePath = paramImageKey.filePath;
    localImageKey.flag = paramImageKey.flag;
    localImageKey.imglistener = paramImageKey.imglistener;
    localImageKey.needCallBackProcessPercent = paramImageKey.needCallBackProcessPercent;
    localImageKey.listener = paramImageKey.listener;
    localImageKey.streamDownloadListener = paramImageKey.streamDownloadListener;
    localImageKey.options = ImageLoader.Options.copy(paramImageKey.options);
    localImageKey.needSuperResolution = paramImageKey.needSuperResolution;
    localImageKey.srUrl = paramImageKey.srUrl;
    localImageKey.bigUrl = paramImageKey.bigUrl;
    localImageKey.isSuperResolutionUrl = paramImageKey.isSuperResolutionUrl;
    localImageKey.isHighScaleUrl = paramImageKey.isHighScaleUrl;
    return localImageKey;
  }
  
  private static boolean equalsObject(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static String getUrlKey(String paramString, boolean paramBoolean)
  {
    return getUrlKey(paramString, paramBoolean, ImageManagerEnv.g().isHighScaleUrl(paramString));
  }
  
  public static String getUrlKey(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = isNeedToSplitCache(paramString);
    paramString = getUrlKey4NoneHighScale(paramString, paramBoolean1);
    str = paramString + str;
    paramString = str;
    if (paramBoolean2)
    {
      paramString = str;
      if (!str.contains("srhs=1")) {
        paramString = str + "srhs=1";
      }
    }
    return paramString;
  }
  
  public static String getUrlKey4NoneHighScale(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean) {
      bool = ImageManager.isNetworkUrl(paramString);
    }
    int k;
    int i;
    if (bool)
    {
      k = paramString.indexOf('/', 8);
      int j = paramString.indexOf("ek=1");
      i = j;
      if (j == -1)
      {
        j = paramString.indexOf('#');
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
      }
      if ((k + 1 >= 0) && (k + 1 <= i) && (i <= paramString.length())) {}
    }
    else
    {
      return paramString;
    }
    return paramString.substring(k + 1, i);
  }
  
  public static String isNeedToSplitCache(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("t");
      if (!TextUtils.isEmpty(paramString))
      {
        if ((paramString.equals("6")) || (paramString.equals("7"))) {
          return "t=" + paramString;
        }
      }
      else {
        return "";
      }
    }
    catch (Throwable paramString)
    {
      return "";
    }
    return "";
  }
  
  public static ImageKey obtain()
  {
    synchronized (mObjectCache)
    {
      ImageKey localImageKey2 = (ImageKey)mObjectCache.poll();
      ImageKey localImageKey1 = localImageKey2;
      if (localImageKey2 == null)
      {
        int i = keyIndex;
        keyIndex = i + 1;
        localImageKey1 = new ImageKey(i);
      }
      localImageKey1.hashCodeEx = 0;
      return localImageKey1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label268:
    label403:
    label408:
    label413:
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramObject == null);
              bool1 = bool3;
            } while (!(paramObject instanceof ImageKey));
            paramObject = (ImageKey)paramObject;
            if ((!equalsObject(this.urlKey, paramObject.urlKey)) || (!equalsObject(this.url, paramObject.url)) || (!equalsObject(this.listener, paramObject.listener))) {
              break;
            }
            i = 1;
            bool1 = bool3;
          } while (i == 0);
          if ((this.options == null) || (paramObject.options == null)) {
            break label413;
          }
          if ((!equalsObject(Integer.valueOf(this.options.clipHeight), Integer.valueOf(paramObject.options.clipHeight))) || (!equalsObject(Integer.valueOf(this.options.clipWidth), Integer.valueOf(paramObject.options.clipWidth))) || (!equalsObject(Boolean.valueOf(this.options.needShowGifAnimation), Boolean.valueOf(paramObject.options.needShowGifAnimation))) || (!equalsObject(this.options.extraProcessor, paramObject.options.extraProcessor)) || (!equalsObject(this.options.imageConfig, paramObject.options.imageConfig)) || (!equalsObject(this.options.fileRootPath, this.options.fileRootPath)) || (!equalsObject(Boolean.valueOf(this.options.needShowPhotoGifAnimation), Boolean.valueOf(paramObject.options.needShowPhotoGifAnimation)))) {
            break label403;
          }
          i = 1;
          bool1 = bool3;
        } while (i == 0);
        bool1 = bool2;
        if (this.listener != null)
        {
          bool1 = bool2;
          if (paramObject.listener != null) {
            if ((!equalsObject(Boolean.valueOf(this.options.useMainThread), Boolean.valueOf(paramObject.options.useMainThread))) || (!equalsObject(this.options.obj, paramObject.options.obj)) || (!equalsObject(Integer.valueOf(this.options.arg1), Integer.valueOf(paramObject.options.arg1))) || (!equalsObject(Integer.valueOf(this.options.arg2), Integer.valueOf(paramObject.options.arg2)))) {
              break label408;
            }
          }
        }
        for (bool1 = bool2;; bool1 = false)
        {
          return bool1;
          i = 0;
          break;
          i = 0;
          break label268;
        }
        bool1 = bool3;
      } while (this.options != null);
      bool1 = bool3;
    } while (paramObject.options != null);
    return true;
  }
  
  public int hashCode()
  {
    int i2 = 1;
    int i1 = 0;
    int i;
    label42:
    label92:
    label104:
    int k;
    label116:
    int m;
    label129:
    int n;
    if ((this.urlKeyHashCode == null) || (this.urlKeyHashCode.intValue() == -1)) {
      if (this.url == null)
      {
        i = 0;
        if (this.listener != null) {
          break label277;
        }
        j = 0;
        int i3 = j + (i + 0) * 31;
        i = i3;
        if (this.options != null)
        {
          int i4 = this.options.clipHeight;
          int i5 = this.options.clipWidth;
          if (!this.options.needShowGifAnimation) {
            break label288;
          }
          i = 1;
          if (this.options.extraProcessor != null) {
            break label293;
          }
          j = 0;
          if (this.options.imageConfig != null) {
            break label307;
          }
          k = 0;
          if (this.options.fileRootPath != null) {
            break label321;
          }
          m = 0;
          if (!this.options.needShowPhotoGifAnimation) {
            break label336;
          }
          n = 1;
          label142:
          k = n + (m + (k + (j + (i + ((i3 * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31) * 31;
          i = k;
          if (this.listener != null)
          {
            if (!this.options.useMainThread) {
              break label342;
            }
            i = i2;
            label206:
            if (this.options.obj != null) {
              break label347;
            }
          }
        }
      }
    }
    label277:
    label288:
    label293:
    label307:
    label321:
    label336:
    label342:
    label347:
    for (int j = i1;; j = this.options.obj.hashCode())
    {
      i = (((k * 31 + i) * 31 + j) * 31 + this.options.arg1) * 31 + this.options.arg2;
      return i;
      i = this.url.hashCode();
      break;
      i = this.urlKeyHashCode.intValue();
      break;
      j = this.listener.hashCode();
      break label42;
      i = 0;
      break label92;
      j = this.options.extraProcessor.getType();
      break label104;
      k = this.options.imageConfig.hashCode();
      break label116;
      m = this.options.fileRootPath.hashCode();
      break label129;
      n = 0;
      break label142;
      i = 0;
      break label206;
    }
  }
  
  public int hashCodeEx()
  {
    int n = 1;
    int i;
    int i1;
    int i2;
    int i3;
    label64:
    int j;
    label76:
    int k;
    label88:
    int m;
    if (this.hashCodeEx == 0)
    {
      if (this.urlKey != null) {
        break label163;
      }
      i = 0;
      i1 = i + 0;
      i = i1;
      if (this.options != null)
      {
        i2 = this.options.clipHeight;
        i3 = this.options.clipWidth;
        if (!this.options.needShowGifAnimation) {
          break label174;
        }
        i = 1;
        if (this.options.extraProcessor != null) {
          break label179;
        }
        j = 0;
        if (this.options.imageConfig != null) {
          break label193;
        }
        k = 0;
        if (this.options.fileRootPath != null) {
          break label207;
        }
        m = 0;
        label101:
        if (!this.options.needShowPhotoGifAnimation) {
          break label222;
        }
      }
    }
    for (;;)
    {
      i = (m + (k + (j + (i + ((i1 * 31 + i2) * 31 + i3) * 31) * 31) * 31) * 31) * 31 + n;
      this.hashCodeEx = i;
      return this.hashCodeEx;
      label163:
      i = this.urlKey.hashCode();
      break;
      label174:
      i = 0;
      break label64;
      label179:
      j = this.options.extraProcessor.getType();
      break label76;
      label193:
      k = this.options.imageConfig.hashCode();
      break label88;
      label207:
      m = this.options.fileRootPath.hashCode();
      break label101;
      label222:
      n = 0;
    }
  }
  
  public boolean isAvatarUrl()
  {
    if (TextUtils.isEmpty(this.url)) {
      return false;
    }
    return this.url.startsWith("avatar://");
  }
  
  public boolean isSame(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    while (paramImageKey.keySeq != this.keySeq) {
      return false;
    }
    return true;
  }
  
  public boolean needDecode()
  {
    return (this.flag == 1) || (this.flag == 2);
  }
  
  public void recycle()
  {
    this.urlKey = null;
    this.url = null;
    this.isNetworkUrl = true;
    this.filePath = null;
    this.flag = 0;
    this.imglistener = null;
    this.needCallBackProcessPercent = false;
    this.listener = null;
    this.streamDownloadListener = null;
    if (this.options != null) {
      this.options = null;
    }
    this.hashCodeEx = 0;
    this.needSuperResolution = true;
    this.srUrl = null;
    this.bigUrl = null;
    this.isSuperResolutionUrl = false;
    this.isHighScaleUrl = false;
    synchronized (mObjectCache)
    {
      mObjectCache.add(this);
      return;
    }
  }
  
  public void setUrl(ImageUrl paramImageUrl)
  {
    this.url = paramImageUrl.url;
    this.isNetworkUrl = paramImageUrl.isNetWorkUrl;
    this.isSuperResolutionUrl = paramImageUrl.isSuperResolutionUrl;
    this.isHighScaleUrl = paramImageUrl.isHighScaleUrl;
    this.urlKey = paramImageUrl.urlKey;
    this.urlKeyHashCode = paramImageUrl.urlKeyHashCode;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
    this.isNetworkUrl = ImageManager.isNetworkUrl(paramString);
    this.isSuperResolutionUrl = ImageManagerEnv.g().isSuperResolutionUrl(paramString);
    if ((this.isSuperResolutionUrl) && (ImageManagerEnv.g().isHighScaleUrl(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      this.isHighScaleUrl = bool;
      if (!this.isNetworkUrl) {
        break;
      }
      this.urlKey = getUrlKey(paramString, true, this.isHighScaleUrl);
      return;
    }
    this.urlKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageKey
 * JD-Core Version:    0.7.0.1
 */