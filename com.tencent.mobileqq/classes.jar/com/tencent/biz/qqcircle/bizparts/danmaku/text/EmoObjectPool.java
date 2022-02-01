package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class EmoObjectPool
{
  private static int a = ViewUtils.a(5.0F);
  private static volatile EmoObjectPool b;
  private static Object c = new Object();
  private SparseArray<Drawable> d = new SparseArray();
  private ConcurrentHashMap<String, SparseArray<SoftReference<EmoCell>>> e = new ConcurrentHashMap();
  private URLDrawable.URLDrawableOptions f;
  private Handler g = new Handler(Looper.getMainLooper());
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int j = 0;
      int n = paramString.length();
      int i1 = paramString.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      while (j < n)
      {
        int i2 = localStringBuilder.codePointAt(j);
        int m = HostEmotionUtil.getSingleEmoji(i2);
        int k;
        if (i2 > 65535)
        {
          i = j + 2;
          if (i1 > i)
          {
            i = localStringBuilder.codePointAt(i);
            break label137;
          }
        }
        else
        {
          i = j + 1;
          if (i1 > i)
          {
            k = localStringBuilder.codePointAt(i);
            i = k;
            if (k != 65039) {
              break label137;
            }
            int i3 = j + 2;
            i = k;
            if (i1 <= i3) {
              break label137;
            }
            i = localStringBuilder.codePointAt(i3);
            break label137;
          }
        }
        int i = -1;
        label137:
        boolean bool = HostEmotionUtil.isSkinEmoji(i);
        if (m != -1)
        {
          k = m;
          if (!bool) {}
        }
        else
        {
          k = HostEmotionUtil.getDoubleEmoji(i2, i);
          if (k == -1) {
            k = m;
          }
        }
        if (k != -1) {
          return k;
        }
        j += 1;
      }
    }
    return -1;
  }
  
  private Drawable a(int paramInt)
  {
    label73:
    try
    {
      Drawable localDrawable = (Drawable)this.d.get(paramInt);
      localObject1 = localDrawable;
      if (localDrawable != null) {}
    }
    finally {}
    try
    {
      localObject1 = QCircleApplication.APP.getResources().getDrawable(2130842422);
      if (localObject1 == null)
      {
        localObject1 = new ColorDrawable(Color.parseColor("#e8e8e8"));
        return localObject1;
      }
      ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
      this.d.put(paramInt, localObject1);
    }
    catch (Exception localException)
    {
      break label73;
    }
    Object localObject1 = new ColorDrawable(Color.parseColor("#e8e8e8"));
    return localObject1;
    return localObject1;
  }
  
  protected static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable != null)
    {
      if (paramInt == 0) {
        return paramDrawable;
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if ((i > 0) && (j > 0)) {
        i = (int)(paramInt * i / j);
      } else {
        i = paramInt;
      }
      Drawable.Callback localCallback = paramDrawable.getCallback();
      paramDrawable.setCallback(null);
      paramDrawable.setBounds(0, 0, i, paramInt);
      paramDrawable.setCallback(localCallback);
    }
    return paramDrawable;
  }
  
  public static EmoObjectPool a()
  {
    if (b == null) {
      synchronized (c)
      {
        if (b == null) {
          b = new EmoObjectPool();
        }
      }
    }
    return b;
  }
  
  private void a(int paramInt1, int paramInt2, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    HostStaticInvokeHelper.summitHighPriortyJob(new EmoObjectPool.1(this, paramImageLoadListener, paramInt2, paramInt1, paramOptions));
  }
  
  private void a(EmoCell paramEmoCell, String paramString, int paramInt, TextLayoutBase paramTextLayoutBase, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadEmoAsync emotionCode: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", bound: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoObjectPool", 2, ((StringBuilder)localObject).toString());
    }
    if (HostEmotionUtil.getLocalIdFromEMCodeFromSystem(paramString) != -1)
    {
      localObject = ImageLoader.Options.obtain();
      ((ImageLoader.Options)localObject).obj = paramEmoCell;
      ((ImageLoader.Options)localObject).useMainThread = true;
      ((ImageLoader.Options)localObject).disableHitRateReport = true;
      a(HostEmotionUtil.getLocalIdFromEMCodeFromSystem(paramString), 1, new EmoObjectPool.EmoLoadListener(this, paramInt, paramTextLayoutBase, paramImageLoadListener), (ImageLoader.Options)localObject);
    }
    else if (HostEmotionUtil.getLocalIdFromEMCodeFromEmoji(paramString) != -1)
    {
      localObject = ImageLoader.Options.obtain();
      ((ImageLoader.Options)localObject).obj = paramEmoCell;
      ((ImageLoader.Options)localObject).useMainThread = true;
      ((ImageLoader.Options)localObject).disableHitRateReport = true;
      a(HostEmotionUtil.getLocalIdFromEMCodeFromEmoji(paramString), 2, new EmoObjectPool.EmoLoadListener(this, paramInt, paramTextLayoutBase, paramImageLoadListener), (ImageLoader.Options)localObject);
    }
    else
    {
      if (!paramString.startsWith("[dra]")) {
        break label233;
      }
      localObject = ImageLoader.Options.obtain();
      ((ImageLoader.Options)localObject).obj = paramEmoCell;
      ((ImageLoader.Options)localObject).useMainThread = true;
      ((ImageLoader.Options)localObject).disableHitRateReport = true;
      a(c(paramString), paramInt, new EmoObjectPool.EmoLoadListener(this, paramInt, paramTextLayoutBase, paramImageLoadListener), (ImageLoader.Options)localObject);
    }
    paramString = null;
    break label361;
    label233:
    int i = paramString.indexOf(HostEmotionUtil.EMO_PREFIX());
    int j = HostEmotionUtil.EMO_PREFIX().length();
    int k = paramString.indexOf(HostEmotionUtil.EMO_TAIL());
    if (k == -1) {
      return;
    }
    paramTextLayoutBase = paramString.substring(i + j, k);
    try
    {
      paramString = HostEmotionUtil.getEmoUrlFromConfig(paramTextLayoutBase);
    }
    catch (Exception paramString)
    {
      label288:
      break label288;
    }
    paramString = new StringBuilder();
    paramString.append(HostEmotionUtil.SIGN_ICON_URL_PREFIX());
    paramString.append(paramTextLayoutBase);
    paramString.append(HostEmotionUtil.SIGN_ICON_URL_END());
    paramString = paramString.toString();
    paramTextLayoutBase = ImageLoader.Options.obtain();
    paramTextLayoutBase.obj = paramEmoCell;
    paramTextLayoutBase.useMainThread = true;
    paramTextLayoutBase.disableHitRateReport = true;
    paramTextLayoutBase.type = QCircleHostConstants.AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_EMO();
    paramString = b(paramString);
    label361:
    if (paramString != null)
    {
      a(paramString, paramInt);
      paramEmoCell.emoDrawable = paramString;
      paramEmoCell.isDrawableLoaded = true;
    }
  }
  
  private void a(String paramString, int paramInt, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    QCircleHostQzoneThreadHelper.postNormalThread(new EmoObjectPool.2(this, paramString, paramOptions, paramImageLoadListener));
  }
  
  private static Drawable b(String paramString, Resources paramResources)
  {
    try
    {
      paramString = paramResources.getDrawable(d(paramString));
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("ERROR", 1, "PICTURE NOT　FOUND！", paramString);
    }
    return null;
  }
  
  private URLDrawable b(String paramString)
  {
    if (this.f == null) {
      this.f = URLDrawable.URLDrawableOptions.obtain();
    }
    return URLDrawable.getDrawable(paramString, this.f);
  }
  
  private static String c(String paramString)
  {
    int i = paramString.indexOf("[dra]") + 5;
    int j = paramString.indexOf("[/dra]");
    if ((i != -1) && (j != -1)) {
      return paramString.substring(i, j);
    }
    return null;
  }
  
  private static int d(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("pending_qzone_famous_icon"))) {
      return 2130842421;
    }
    return 0;
  }
  
  public EmoCell a(String paramString, int paramInt, TextLayoutBase paramTextLayoutBase)
  {
    Object localObject2 = (SparseArray)this.e.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new SparseArray();
    }
    localObject2 = a(paramInt);
    SoftReference localSoftReference = (SoftReference)((SparseArray)localObject1).get(paramInt);
    if (localSoftReference != null)
    {
      EmoCell localEmoCell = (EmoCell)localSoftReference.get();
      if ((localEmoCell != null) && (localEmoCell.emoDrawable.getBounds().isEmpty())) {
        a(localEmoCell.emoDrawable, paramInt);
      }
      if ((localEmoCell != null) && (localEmoCell.emoDrawable == localObject2))
      {
        localEmoCell.isDrawableLoaded = false;
        a(localEmoCell, paramString, paramInt, paramTextLayoutBase, null);
      }
    }
    if ((localSoftReference != null) && (localSoftReference.get() != null)) {
      return (EmoCell)localSoftReference.get();
    }
    localObject2 = new EmoCell(new String(paramString), (Drawable)localObject2);
    if (((EmoCell)localObject2).emoDrawable.getBounds().isEmpty()) {
      a(((EmoCell)localObject2).emoDrawable, paramInt);
    }
    ((EmoCell)localObject2).isDrawableLoaded = false;
    a((EmoCell)localObject2, paramString, paramInt, paramTextLayoutBase, null);
    ((SparseArray)localObject1).put(paramInt, new SoftReference(localObject2));
    this.e.put(paramString, localObject1);
    return localObject2;
  }
  
  public void a(EmoCell paramEmoCell, TextLayoutBase paramTextLayoutBase, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    if (paramEmoCell == null) {
      return;
    }
    int i = (int)paramEmoCell.getWidth(null);
    Drawable localDrawable = a(i);
    if (paramEmoCell.emoDrawable == localDrawable) {
      a(paramEmoCell, paramEmoCell.emoCode, i, paramTextLayoutBase, paramImageLoadListener);
    }
  }
  
  public void a(SystemEmoCell paramSystemEmoCell, TextLayoutBase paramTextLayoutBase, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    if (paramSystemEmoCell == null) {
      return;
    }
    int i = a(paramSystemEmoCell.text);
    if (i >= 0)
    {
      paramTextLayoutBase = HostEmotionUtil.getEmojiDrawable(i, new EmoObjectPool.SysEmoLoadListener(this, paramTextLayoutBase, paramSystemEmoCell, paramImageLoadListener));
      if (paramTextLayoutBase != null)
      {
        paramSystemEmoCell.isDrawableLoaded = true;
        paramSystemEmoCell.emoDrawable = paramTextLayoutBase;
        a(paramTextLayoutBase, paramSystemEmoCell.mHeight);
        paramSystemEmoCell.mWidth = paramTextLayoutBase.getBounds().width();
        return;
      }
    }
    paramSystemEmoCell.isDrawableLoaded = false;
  }
  
  public SystemEmoCell b(String paramString, int paramInt, TextLayoutBase paramTextLayoutBase)
  {
    paramString = new SystemEmoCell(paramString, paramInt);
    paramString.isDrawableLoaded = false;
    a(paramString, paramTextLayoutBase, null);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool
 * JD-Core Version:    0.7.0.1
 */