package com.tencent.component.media.image;

import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import com.tencent.component.media.utils.RapidNetUtils;
import java.util.LinkedList;

public class ImageKey
{
  private static int jdField_a_of_type_Int;
  private static LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private int b = 0;
  private int c = 0;
  public String filePath = null;
  public byte flag = 0;
  public ImageLoader.ImageDownloadListener imglistener = null;
  public boolean isNetworkUrl = true;
  public ImageLoader.ImageLoadListener listener = null;
  public boolean needCallBackProcessPercent = false;
  public boolean needSuperResolution = true;
  public ImageLoader.Options options = null;
  public String srUrl;
  public ImageLoader.StreamDownloadListener streamDownloadListener = null;
  public String url = null;
  public String urlKey = null;
  
  static
  {
    jdField_a_of_type_Int = 0;
    clearAndInitSize();
  }
  
  private ImageKey(int paramInt)
  {
    this.b = paramInt;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      jdField_a_of_type_JavaUtilLinkedList.clear();
      int i = 0;
      while (i < 100)
      {
        LinkedList localLinkedList2 = jdField_a_of_type_JavaUtilLinkedList;
        int j = jdField_a_of_type_Int;
        jdField_a_of_type_Int = j + 1;
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
    return localImageKey;
  }
  
  public static String getUrlKey(String paramString, boolean paramBoolean)
  {
    String str2 = getUrlKey4NoneHighScale(paramString, paramBoolean);
    String str1 = str2;
    if (RapidNetUtils.isHighScaleUrl(paramString))
    {
      str1 = str2;
      if (!str2.contains("srhs=1")) {
        str1 = str2 + "srhs=1";
      }
    }
    return str1;
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
  
  public static ImageKey obtain()
  {
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      ImageKey localImageKey2 = (ImageKey)jdField_a_of_type_JavaUtilLinkedList.poll();
      ImageKey localImageKey1 = localImageKey2;
      if (localImageKey2 == null)
      {
        int i = jdField_a_of_type_Int;
        jdField_a_of_type_Int = i + 1;
        localImageKey1 = new ImageKey(i);
      }
      localImageKey1.c = 0;
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
            if ((!a(this.urlKey, paramObject.urlKey)) || (!a(this.url, paramObject.url)) || (!a(this.listener, paramObject.listener))) {
              break;
            }
            i = 1;
            bool1 = bool3;
          } while (i == 0);
          if ((this.options == null) || (paramObject.options == null)) {
            break label413;
          }
          if ((!a(Integer.valueOf(this.options.clipHeight), Integer.valueOf(paramObject.options.clipHeight))) || (!a(Integer.valueOf(this.options.clipWidth), Integer.valueOf(paramObject.options.clipWidth))) || (!a(Boolean.valueOf(this.options.needShowGifAnimation), Boolean.valueOf(paramObject.options.needShowGifAnimation))) || (!a(this.options.extraProcessor, paramObject.options.extraProcessor)) || (!a(this.options.imageConfig, paramObject.options.imageConfig)) || (!a(this.options.fileRootPath, this.options.fileRootPath)) || (!a(Boolean.valueOf(this.options.needShowPhotoGifAnimation), Boolean.valueOf(paramObject.options.needShowPhotoGifAnimation)))) {
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
            if ((!a(Boolean.valueOf(this.options.useMainThread), Boolean.valueOf(paramObject.options.useMainThread))) || (!a(this.options.obj, paramObject.options.obj)) || (!a(Integer.valueOf(this.options.arg1), Integer.valueOf(paramObject.options.arg1))) || (!a(Integer.valueOf(this.options.arg2), Integer.valueOf(paramObject.options.arg2)))) {
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
    label24:
    int k;
    label33:
    label88:
    label100:
    label112:
    int m;
    label125:
    int n;
    if (this.urlKey == null)
    {
      i = 0;
      if (this.url != null) {
        break label262;
      }
      j = 0;
      if (this.listener != null) {
        break label273;
      }
      k = 0;
      int i3 = k + (j + (i + 0) * 31) * 31;
      i = i3;
      if (this.options != null)
      {
        int i4 = this.options.clipHeight;
        int i5 = this.options.clipWidth;
        if (!this.options.needShowGifAnimation) {
          break label284;
        }
        i = 1;
        if (this.options.extraProcessor != null) {
          break label289;
        }
        j = 0;
        if (this.options.imageConfig != null) {
          break label303;
        }
        k = 0;
        if (this.options.fileRootPath != null) {
          break label317;
        }
        m = 0;
        if (!this.options.needShowPhotoGifAnimation) {
          break label332;
        }
        n = 1;
        label138:
        k = n + (m + (k + (j + (i + ((i3 * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31) * 31;
        i = k;
        if (this.listener != null)
        {
          if (!this.options.useMainThread) {
            break label338;
          }
          i = i2;
          label202:
          if (this.options.obj != null) {
            break label343;
          }
        }
      }
    }
    label262:
    label273:
    label284:
    label289:
    label303:
    label317:
    label332:
    label338:
    label343:
    for (int j = i1;; j = this.options.obj.hashCode())
    {
      i = (((k * 31 + i) * 31 + j) * 31 + this.options.arg1) * 31 + this.options.arg2;
      return i;
      i = this.urlKey.hashCode();
      break;
      j = this.url.hashCode();
      break label24;
      k = this.listener.hashCode();
      break label33;
      i = 0;
      break label88;
      j = this.options.extraProcessor.getType();
      break label100;
      k = this.options.imageConfig.hashCode();
      break label112;
      m = this.options.fileRootPath.hashCode();
      break label125;
      n = 0;
      break label138;
      i = 0;
      break label202;
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
    if (this.c == 0)
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
      this.c = i;
      return this.c;
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
    while (paramImageKey.b != this.b) {
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
    this.c = 0;
    this.needSuperResolution = true;
    this.srUrl = null;
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      jdField_a_of_type_JavaUtilLinkedList.add(this);
      return;
    }
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
    this.isNetworkUrl = ImageManager.isNetworkUrl(paramString);
    if (this.isNetworkUrl)
    {
      this.urlKey = getUrlKey(paramString, true);
      return;
    }
    this.urlKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageKey
 * JD-Core Version:    0.7.0.1
 */