package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
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
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Acceleration;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Velocity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StickerBubbleAnimationHelper
{
  private static int jdField_a_of_type_Int;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private static String jdField_a_of_type_JavaLangString;
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private static Set<Object> jdField_a_of_type_JavaUtilSet = new HashSet();
  private static int[] jdField_a_of_type_ArrayOfInt;
  
  public static int a(@NonNull String paramString)
  {
    try
    {
      if (!paramString.equals(jdField_a_of_type_JavaLangString))
      {
        jdField_a_of_type_Int = SharedPreUtils.b(paramString);
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
    int i = AIOUtils.b(8.0F, paramContext.getResources());
    paramContext = new TranslateAnimation(-i, i, 0.0F, 0.0F);
    paramContext.setDuration(100L);
    paramContext.setInterpolator(new AccelerateInterpolator());
    paramContext.setRepeatCount(-1);
    paramContext.setRepeatMode(2);
    return paramContext;
  }
  
  public static AddItemRequest a(int paramInt1, String paramString, int paramInt2, int[] paramArrayOfInt)
  {
    boolean bool = a(paramInt2, paramArrayOfInt);
    paramArrayOfInt = new AddItemRequest().a(new Point(paramInt1 / 2, 0)).a(paramString).a(bool);
    paramInt2 = 2000;
    if (bool) {
      paramInt1 = -jdField_a_of_type_JavaUtilRandom.nextInt(2000) + 1000;
    } else {
      paramInt1 = -jdField_a_of_type_JavaUtilRandom.nextInt(8000) + 4000;
    }
    double d = paramInt1;
    if (bool)
    {
      paramString = jdField_a_of_type_JavaUtilRandom;
      paramInt1 = 500;
    }
    else
    {
      paramString = jdField_a_of_type_JavaUtilRandom;
      paramInt1 = paramInt2;
    }
    return paramArrayOfInt.a(new ItemStatus.Velocity(d, paramString.nextInt(paramInt1))).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(49);
  }
  
  public static AddItemRequest a(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = a(paramInt);
    paramPoint = new AddItemRequest().a(paramPoint).a(paramString).a(bool);
    if (bool) {
      paramInt = -jdField_a_of_type_JavaUtilRandom.nextInt(1500) + 750;
    } else {
      paramInt = -jdField_a_of_type_JavaUtilRandom.nextInt(6000) + 3000;
    }
    double d = paramInt;
    if (bool) {
      paramInt = -1000 - jdField_a_of_type_JavaUtilRandom.nextInt(500);
    } else {
      paramInt = -2000 - jdField_a_of_type_JavaUtilRandom.nextInt(1000);
    }
    return paramPoint.a(new ItemStatus.Velocity(d, paramInt)).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(85);
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
    if (jdField_a_of_type_JavaUtilSet.isEmpty())
    {
      paramObject = jdField_a_of_type_AndroidViewAnimationAnimation;
      if ((paramObject != null) && (paramObject.hasStarted()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerBubbleHelper", 2, "cancelShakeWindowAnim");
        }
        jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
        jdField_a_of_type_AndroidViewAnimationAnimation.reset();
        paramView.clearAnimation();
      }
    }
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
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ArrayOfInt == null)
    {
      paramQQAppInterface = PokeItemHelper.a(paramQQAppInterface, 7);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.split(",");
        try
        {
          localObject = new int[paramQQAppInterface.length];
          int i = 0;
          while (i < localObject.length)
          {
            localObject[i] = Integer.parseInt(paramQQAppInterface[i]);
            i += 1;
          }
          jdField_a_of_type_ArrayOfInt = (int[])localObject;
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("PE_SWITCH_TYPE_SURPRISE_INDEXS is illegal to parse, ");
          ((StringBuilder)localObject).append(paramQQAppInterface);
          QLog.e("StickerBubbleHelper", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
    Object localObject = jdField_a_of_type_ArrayOfInt;
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localObject == null)
    {
      paramQQAppInterface = new int[3];
      paramQQAppInterface[0] = 10;
      paramQQAppInterface[1] = 20;
      paramQQAppInterface[2] = 30;
      paramQQAppInterface;
    }
    return paramQQAppInterface;
  }
  
  public static AddItemRequest b(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = a(paramInt);
    paramPoint = new AddItemRequest().a(paramPoint).a(paramString).a(bool);
    if (bool) {
      paramInt = -jdField_a_of_type_JavaUtilRandom.nextInt(1500) + 750;
    } else {
      paramInt = -jdField_a_of_type_JavaUtilRandom.nextInt(6000) + 3000;
    }
    double d = paramInt;
    if (bool) {
      paramInt = -1000 - jdField_a_of_type_JavaUtilRandom.nextInt(500);
    } else {
      paramInt = -2000 - jdField_a_of_type_JavaUtilRandom.nextInt(1000);
    }
    return paramPoint.a(new ItemStatus.Velocity(d, paramInt)).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(81);
  }
  
  public static void b(Object paramObject, View paramView)
  {
    jdField_a_of_type_JavaUtilSet.add(paramObject);
    if (jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      jdField_a_of_type_AndroidViewAnimationAnimation = a(paramView.getContext());
      jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new StickerBubbleAnimationHelper.1());
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleHelper", 2, "start to shake");
    }
    if (paramView != null) {
      paramView.startAnimation(jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper
 * JD-Core Version:    0.7.0.1
 */