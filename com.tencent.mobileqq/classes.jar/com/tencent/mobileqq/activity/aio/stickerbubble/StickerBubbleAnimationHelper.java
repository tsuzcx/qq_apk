package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import wbq;
import wbu;

public class StickerBubbleAnimationHelper
{
  private static int jdField_a_of_type_Int;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private static String jdField_a_of_type_JavaLangString;
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static int b;
  
  public static int a(@NonNull String paramString)
  {
    try
    {
      if (!paramString.equals(jdField_a_of_type_JavaLangString))
      {
        jdField_a_of_type_Int = SharedPreUtils.a(paramString);
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        jdField_a_of_type_JavaLangString = paramString;
      }
      int i = jdField_a_of_type_Int;
      return i;
    }
    finally {}
  }
  
  @Nullable
  public static Drawable a(@NonNull String paramString)
  {
    try
    {
      if (((!paramString.equals(jdField_a_of_type_JavaLangString)) || (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) && (a(paramString) > 0)) {
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = PEPanelHelper.a(a(paramString));
      }
      paramString = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      return paramString;
    }
    finally {}
  }
  
  private static Animation a(Context paramContext)
  {
    int i = AIOUtils.a(8.0F, paramContext.getResources());
    paramContext = new TranslateAnimation(-i, i, 0.0F, 0.0F);
    paramContext.setDuration(100L);
    paramContext.setInterpolator(new AccelerateInterpolator());
    paramContext.setRepeatCount(-1);
    paramContext.setRepeatMode(2);
    return paramContext;
  }
  
  @Nullable
  public static StickerBubbleAnimationHelper.CacheItem a(String paramString)
  {
    return (StickerBubbleAnimationHelper.CacheItem)CommonImageCacheHelper.a("StickerBubbleGifCache_" + paramString);
  }
  
  public static wbu a(int paramInt1, String paramString, int paramInt2, int[] paramArrayOfInt)
  {
    boolean bool = a(paramInt2, paramArrayOfInt);
    paramArrayOfInt = new Point(paramInt1 / 2, 0);
    double d1;
    if (bool)
    {
      d1 = -jdField_a_of_type_JavaUtilRandom.nextInt(2000) + 1000;
      if (!bool) {
        break label114;
      }
    }
    label114:
    for (double d2 = jdField_a_of_type_JavaUtilRandom.nextInt(500);; d2 = jdField_a_of_type_JavaUtilRandom.nextInt(2000))
    {
      return new wbu(paramArrayOfInt, paramString, bool, new ItemStatus.Velocity(d1, d2), new ItemStatus.Acceleration(0.0D, 200.0D), 49);
      d1 = -jdField_a_of_type_JavaUtilRandom.nextInt(8000) + 4000;
      break;
    }
  }
  
  public static wbu a(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = a(paramInt);
    double d1;
    if (bool)
    {
      d1 = -jdField_a_of_type_JavaUtilRandom.nextInt(1500) + 750;
      if (!bool) {
        break label102;
      }
    }
    label102:
    for (double d2 = -1000 - jdField_a_of_type_JavaUtilRandom.nextInt(500);; d2 = -2000 - jdField_a_of_type_JavaUtilRandom.nextInt(1000))
    {
      return new wbu(paramPoint, paramString, bool, new ItemStatus.Velocity(d1, d2), new ItemStatus.Acceleration(0.0D, 200.0D), 85);
      d1 = -jdField_a_of_type_JavaUtilRandom.nextInt(6000) + 3000;
      break;
    }
  }
  
  public static void a()
  {
    b += 1;
  }
  
  public static void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleHelper", 2, "stopAndClean");
    }
    StickerBubbleAnimationViewHolder.a().a();
  }
  
  public static void a(@NonNull PEItemData paramPEItemData, @NonNull String paramString)
  {
    try
    {
      jdField_a_of_type_Int = paramPEItemData.jdField_a_of_type_Int;
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = PEPanelHelper.a(jdField_a_of_type_Int);
      SharedPreUtils.b(paramPEItemData.jdField_a_of_type_Int, paramString);
      jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    finally
    {
      paramPEItemData = finally;
      throw paramPEItemData;
    }
  }
  
  public static void a(Object paramObject, View paramView)
  {
    jdField_a_of_type_JavaUtilSet.remove(paramObject);
    if ((jdField_a_of_type_JavaUtilSet.isEmpty()) && (jdField_a_of_type_AndroidViewAnimationAnimation != null) && (jdField_a_of_type_AndroidViewAnimationAnimation.hasStarted()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleHelper", 2, "cancelShakeWindowAnim");
      }
      jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
      jdField_a_of_type_AndroidViewAnimationAnimation.reset();
      paramView.clearAnimation();
    }
  }
  
  public static void a(String paramString, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleHelper", 2, "putFramesToCache: " + paramString + " / " + paramArrayOfBitmapDrawable);
      }
      String str = "StickerBubbleGifCache_" + paramString;
      if (CommonImageCacheHelper.a(str) == null) {
        CommonImageCacheHelper.a(str, new StickerBubbleAnimationHelper.CacheItem(paramString, paramArrayOfBitmapDrawable, paramInt));
      }
    }
  }
  
  private static boolean a()
  {
    return b > 3;
  }
  
  private static boolean a(int paramInt)
  {
    int[] arrayOfInt = a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ArrayOfInt == null)
    {
      paramQQAppInterface = PokeItemHelper.a(paramQQAppInterface, 7);
      if (paramQQAppInterface != null) {
        paramQQAppInterface = paramQQAppInterface.split(",");
      }
    }
    try
    {
      int[] arrayOfInt = new int[paramQQAppInterface.length];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = Integer.parseInt(paramQQAppInterface[i]);
        i += 1;
      }
      jdField_a_of_type_ArrayOfInt = arrayOfInt;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("StickerBubbleHelper", 1, "PE_SWITCH_TYPE_SURPRISE_INDEXS is illegal to parse, " + paramQQAppInterface);
      }
    }
    if (jdField_a_of_type_ArrayOfInt == null) {
      return new int[] { 10, 20, 30 };
    }
    return jdField_a_of_type_ArrayOfInt;
  }
  
  public static wbu b(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = a(paramInt);
    double d1;
    if (bool)
    {
      d1 = -jdField_a_of_type_JavaUtilRandom.nextInt(1500) + 750;
      if (!bool) {
        break label102;
      }
    }
    label102:
    for (double d2 = -1000 - jdField_a_of_type_JavaUtilRandom.nextInt(500);; d2 = -2000 - jdField_a_of_type_JavaUtilRandom.nextInt(1000))
    {
      return new wbu(paramPoint, paramString, bool, new ItemStatus.Velocity(d1, d2), new ItemStatus.Acceleration(0.0D, 200.0D), 81);
      d1 = -jdField_a_of_type_JavaUtilRandom.nextInt(6000) + 3000;
      break;
    }
  }
  
  public static void b(Object paramObject, View paramView)
  {
    jdField_a_of_type_JavaUtilSet.add(paramObject);
    if (jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      jdField_a_of_type_AndroidViewAnimationAnimation = a(paramView.getContext());
      jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new wbq());
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleHelper", 2, "start to shake");
    }
    if (paramView != null) {
      paramView.startAnimation(jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper
 * JD-Core Version:    0.7.0.1
 */