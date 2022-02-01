package com.tencent.component.media.image;

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
    for (;;)
    {
      throw localObject;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    paramString = str;
    if (paramBoolean2)
    {
      paramString = str;
      if (!str.contains("srhs=1"))
      {
        paramString = new StringBuilder();
        paramString.append(str);
        paramString.append("srhs=1");
        paramString = paramString.toString();
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
    String str = paramString;
    if (bool)
    {
      int k = paramString.indexOf('/', 8);
      int j = paramString.indexOf("ek=1");
      int i = j;
      if (j == -1)
      {
        j = paramString.indexOf('#');
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
      }
      j = k + 1;
      str = paramString;
      if (j >= 0)
      {
        str = paramString;
        if (j <= i)
        {
          if (i > paramString.length()) {
            return paramString;
          }
          str = paramString.substring(j, i);
        }
      }
    }
    return str;
  }
  
  public static String isNeedToSplitCache(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("t");
      if (!TextUtils.isEmpty(paramString))
      {
        if (!paramString.equals("6")) {
          if (!paramString.equals("7")) {
            break label73;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("t=");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        return paramString;
      }
      else
      {
        return "";
      }
    }
    catch (Throwable paramString)
    {
      return "";
    }
    label73:
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof ImageKey)) {
        return false;
      }
      paramObject = (ImageKey)paramObject;
      int i;
      if ((equalsObject(this.urlKey, paramObject.urlKey)) && (equalsObject(this.url, paramObject.url)) && (equalsObject(this.listener, paramObject.listener))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return false;
      }
      ImageLoader.Options localOptions = this.options;
      if ((localOptions != null) && (paramObject.options != null))
      {
        if ((equalsObject(Integer.valueOf(localOptions.clipHeight), Integer.valueOf(paramObject.options.clipHeight))) && (equalsObject(Integer.valueOf(this.options.clipWidth), Integer.valueOf(paramObject.options.clipWidth))) && (equalsObject(Boolean.valueOf(this.options.needShowGifAnimation), Boolean.valueOf(paramObject.options.needShowGifAnimation))) && (equalsObject(this.options.extraProcessor, paramObject.options.extraProcessor)) && (equalsObject(this.options.imageConfig, paramObject.options.imageConfig)) && (equalsObject(this.options.fileRootPath, this.options.fileRootPath)) && (equalsObject(Boolean.valueOf(this.options.needShowPhotoGifAnimation), Boolean.valueOf(paramObject.options.needShowPhotoGifAnimation)))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          return false;
        }
        boolean bool1 = bool2;
        if (this.listener != null)
        {
          bool1 = bool2;
          if (paramObject.listener != null)
          {
            if ((equalsObject(Boolean.valueOf(this.options.useMainThread), Boolean.valueOf(paramObject.options.useMainThread))) && (equalsObject(this.options.obj, paramObject.options.obj)) && (equalsObject(Integer.valueOf(this.options.arg1), Integer.valueOf(paramObject.options.arg1))) && (equalsObject(Integer.valueOf(this.options.arg2), Integer.valueOf(paramObject.options.arg2)))) {
              return true;
            }
            bool1 = false;
          }
        }
        return bool1;
      }
      if ((this.options == null) && (paramObject.options == null)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int hashCodeEx()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    boolean bool = false;
    if (paramImageKey == null) {
      return false;
    }
    if (paramImageKey.keySeq == this.keySeq) {
      bool = true;
    }
    return bool;
  }
  
  public boolean needDecode()
  {
    int i = this.flag;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
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
    boolean bool;
    if ((this.isSuperResolutionUrl) && (ImageManagerEnv.g().isHighScaleUrl(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    this.isHighScaleUrl = bool;
    if (this.isNetworkUrl)
    {
      this.urlKey = getUrlKey(paramString, true, this.isHighScaleUrl);
      return;
    }
    this.urlKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageKey
 * JD-Core Version:    0.7.0.1
 */