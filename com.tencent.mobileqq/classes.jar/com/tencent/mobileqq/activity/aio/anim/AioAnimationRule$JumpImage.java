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
  public static final int a;
  static final int b = DisplayUtil.a(BaseApplicationImpl.getContext(), 44.0F);
  public String a;
  boolean a;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  static
  {
    jdField_a_of_type_Int = (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 32.0F + 0.5F);
  }
  
  public AioAnimationRule$JumpImage()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a(String paramString)
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
  
  public static Drawable a(Context paramContext, JumpImage paramJumpImage)
  {
    int i;
    if (paramJumpImage.jdField_a_of_type_Boolean) {
      i = b;
    } else {
      i = jdField_a_of_type_Int;
    }
    int j = paramJumpImage.c;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 4)
          {
            if (j != 5)
            {
              if (j != 6) {
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
        ((StringBuilder)localObject).append(paramJumpImage.e);
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
              ((StringBuilder)localObject).append(paramJumpImage.e);
              QLog.e("AioAnimationRule", 2, ((StringBuilder)localObject).toString());
              localObject = localBitmap;
            }
          }
        }
        paramContext = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
        paramContext.setBounds(new Rect(0, 0, i, i));
        return paramContext;
      }
      paramContext = a(paramJumpImage.e);
      if (paramContext != null) {
        paramContext.setBounds(new Rect(0, 0, i, i));
      }
      return paramContext;
    }
    j = Integer.valueOf(paramJumpImage.e).intValue();
    if (j >= 0)
    {
      paramContext = QQEmojiUtil.getEmojiDrawable(j);
      if (paramContext != null) {
        paramContext.setBounds(new Rect(0, 0, i, i));
      }
      return paramContext;
    }
    return null;
  }
  
  public static Drawable a(String paramString)
  {
    int j = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]))
      {
        j = i;
        if (!QLog.isColorLevel()) {
          break label90;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("find str = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", index = ");
        localStringBuilder.append(i);
        QLog.d("AioAnimationRule", 2, localStringBuilder.toString());
        j = i;
        break label90;
      }
      i += 1;
    }
    j = -1;
    label90:
    if (j < 0) {
      return null;
    }
    return TextUtils.getSysEmotcationDrawable(j, false);
  }
  
  private static Drawable b(Context paramContext, JumpImage paramJumpImage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AioAnimationConfigHelper.a);
    localStringBuilder.append(paramJumpImage.e);
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
    ((StringBuilder)localObject).append(paramJumpImage.e);
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
          ((StringBuilder)localObject).append(paramJumpImage.e);
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
    float f = paramContext.getResources().getDisplayMetrics().density;
    paramJumpImage.setBounds(new Rect(0, 0, (int)(paramJumpImage.getIntrinsicWidth() * f), (int)(paramJumpImage.getIntrinsicHeight() * f)));
    return paramJumpImage;
  }
  
  private static Drawable e(Context paramContext, JumpImage paramJumpImage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AioAnimationConfigHelper.a);
    localStringBuilder.append(paramJumpImage.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage
 * JD-Core Version:    0.7.0.1
 */