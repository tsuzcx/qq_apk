package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AioAnimationRule$JumpImage
{
  public static final int a = (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 32.0F + 0.5F);
  static final int b = DisplayUtil.a(BaseApplicationImpl.getContext(), 44.0F);
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public String h;
  boolean i = false;
  
  public static Drawable a(Context paramContext, JumpImage paramJumpImage)
  {
    int j;
    if (paramJumpImage.i) {
      j = b;
    } else {
      j = a;
    }
    int k = paramJumpImage.g;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k != 5)
            {
              if (k != 6) {
                return null;
              }
              return b(paramContext, paramJumpImage);
            }
            return d(paramContext, paramJumpImage);
          }
          return e(paramContext, paramJumpImage);
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AioAnimationConfigHelper.a);
        ((StringBuilder)localObject).append(paramJumpImage.h);
        String str1 = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JumpImage:");
        ((StringBuilder)localObject).append(str1);
        String str2 = ((StringBuilder)localObject).toString();
        Bitmap localBitmap = (Bitmap)GlobalImageCache.a.get(str2);
        localObject = localBitmap;
        if (localBitmap == null)
        {
          localBitmap = BitmapManager.a(str1);
          if (localBitmap != null)
          {
            GlobalImageCache.a.put(str2, localBitmap);
            localObject = localBitmap;
          }
          else
          {
            localObject = localBitmap;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("decodeFile error, fileName: ");
              ((StringBuilder)localObject).append(paramJumpImage.h);
              QLog.e("AioAnimationRule", 2, ((StringBuilder)localObject).toString());
              localObject = localBitmap;
            }
          }
        }
        paramContext = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
        paramContext.setBounds(new Rect(0, 0, j, j));
        return paramContext;
      }
      paramContext = a(paramJumpImage.h);
      if (paramContext != null) {
        paramContext.setBounds(new Rect(0, 0, j, j));
      }
      return paramContext;
    }
    k = Integer.valueOf(paramJumpImage.h).intValue();
    if (k >= 0)
    {
      paramContext = QQEmojiUtil.getEmojiDrawable(k);
      if (paramContext != null) {
        paramContext.setBounds(new Rect(0, 0, j, j));
      }
      return paramContext;
    }
    return null;
  }
  
  public static Drawable a(String paramString)
  {
    int k = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
    int j = 0;
    while (j < k)
    {
      if (paramString.equals(EmotcationConstants.SYS_EMOTICON_SYMBOL[j]))
      {
        k = j;
        if (!QLog.isColorLevel()) {
          break label90;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("find str = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", index = ");
        localStringBuilder.append(j);
        QLog.d("AioAnimationRule", 2, localStringBuilder.toString());
        k = j;
        break label90;
      }
      j += 1;
    }
    k = -1;
    label90:
    if (k < 0) {
      return null;
    }
    return TextUtils.getSysEmotcationDrawable(k, false);
  }
  
  public static int b(String paramString)
  {
    if (paramString.equalsIgnoreCase("Emoji")) {
      return 0;
    }
    if (paramString.equalsIgnoreCase("Face")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("Apng")) {
      return 6;
    }
    if (paramString.equalsIgnoreCase("Image")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("Lottie")) {
      return 3;
    }
    if (paramString.equalsIgnoreCase("Gif")) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("Pic")) {
      return 5;
    }
    return -1;
  }
  
  private static Drawable b(Context paramContext, JumpImage paramJumpImage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AioAnimationConfigHelper.a);
    localStringBuilder.append(paramJumpImage.h);
    paramJumpImage = new File(localStringBuilder.toString());
    try
    {
      paramContext = new ApngDrawable(paramJumpImage, paramContext.getResources());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("AioAnimationRule", 1, "[getApngDrawable] get apng drawable error", paramContext);
    }
    return null;
  }
  
  private static Drawable c(Context paramContext, JumpImage paramJumpImage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AioAnimationConfigHelper.a);
    ((StringBuilder)localObject).append(paramJumpImage.h);
    String str1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("JumpImage:");
    ((StringBuilder)localObject).append(str1);
    String str2 = ((StringBuilder)localObject).toString();
    Bitmap localBitmap = (Bitmap)GlobalImageCache.a.get(str2);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      localBitmap = BitmapManager.a(str1);
      if (localBitmap != null)
      {
        GlobalImageCache.a.put(str2, localBitmap);
        localObject = localBitmap;
      }
      else
      {
        localObject = localBitmap;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decodeFile error, fileName: ");
          ((StringBuilder)localObject).append(paramJumpImage.h);
          QLog.e("AioAnimationRule", 2, ((StringBuilder)localObject).toString());
          localObject = localBitmap;
        }
      }
    }
    return new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
  }
  
  private static Drawable d(Context paramContext, JumpImage paramJumpImage)
  {
    paramJumpImage = c(paramContext, paramJumpImage);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    paramJumpImage.setBounds(new Rect(0, 0, (int)(paramJumpImage.getIntrinsicWidth() * f1), (int)(paramJumpImage.getIntrinsicHeight() * f1)));
    return paramJumpImage;
  }
  
  private static Drawable e(Context paramContext, JumpImage paramJumpImage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AioAnimationConfigHelper.a);
    localStringBuilder.append(paramJumpImage.h);
    paramJumpImage = new File(localStringBuilder.toString());
    try
    {
      paramContext = new GifDrawable(paramJumpImage, paramContext.getResources());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("AioAnimationRule", 1, "[getGifDrawable] get gif drawable error", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage
 * JD-Core Version:    0.7.0.1
 */