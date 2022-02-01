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
  private static Animation a;
  private static Random b = new Random();
  private static int[] c;
  private static Set<Object> d = new HashSet();
  private static int e;
  private static Drawable f;
  private static String g;
  
  public static int a(@NonNull String paramString)
  {
    try
    {
      if (!paramString.equals(g))
      {
        e = SharedPreUtils.p(paramString);
        f = null;
        g = paramString;
      }
      int i = e;
      return i;
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
      paramInt1 = -b.nextInt(2000) + 1000;
    } else {
      paramInt1 = -b.nextInt(8000) + 4000;
    }
    double d1 = paramInt1;
    if (bool)
    {
      paramString = b;
      paramInt1 = 500;
    }
    else
    {
      paramString = b;
      paramInt1 = paramInt2;
    }
    return paramArrayOfInt.a(new ItemStatus.Velocity(d1, paramString.nextInt(paramInt1))).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(49);
  }
  
  public static AddItemRequest a(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = a(paramInt);
    paramPoint = new AddItemRequest().a(paramPoint).a(paramString).a(bool);
    if (bool) {
      paramInt = -b.nextInt(1500) + 750;
    } else {
      paramInt = -b.nextInt(6000) + 3000;
    }
    double d1 = paramInt;
    if (bool) {
      paramInt = -1000 - b.nextInt(500);
    } else {
      paramInt = -2000 - b.nextInt(1000);
    }
    return paramPoint.a(new ItemStatus.Velocity(d1, paramInt)).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(85);
  }
  
  public static void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleHelper", 2, "stopAndClean");
    }
    StickerBubbleAnimationViewHolder.b().a();
  }
  
  public static void a(@NonNull PEItemData paramPEItemData, @NonNull String paramString)
  {
    try
    {
      e = paramPEItemData.a;
      f = PEPanelHelper.c(e);
      SharedPreUtils.d(paramPEItemData.a, paramString);
      g = paramString;
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
    d.remove(paramObject);
    if (d.isEmpty())
    {
      paramObject = a;
      if ((paramObject != null) && (paramObject.hasStarted()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerBubbleHelper", 2, "cancelShakeWindowAnim");
        }
        a.cancel();
        a.reset();
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
    if (c == null)
    {
      paramQQAppInterface = PokeItemHelper.c(paramQQAppInterface, 7);
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
          c = (int[])localObject;
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
    Object localObject = c;
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
  
  @Nullable
  public static Drawable b(@NonNull String paramString)
  {
    try
    {
      if (((!paramString.equals(g)) || (f == null)) && (a(paramString) > 0)) {
        f = PEPanelHelper.c(a(paramString));
      }
      paramString = f;
      return paramString;
    }
    finally {}
  }
  
  public static AddItemRequest b(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = a(paramInt);
    paramPoint = new AddItemRequest().a(paramPoint).a(paramString).a(bool);
    if (bool) {
      paramInt = -b.nextInt(1500) + 750;
    } else {
      paramInt = -b.nextInt(6000) + 3000;
    }
    double d1 = paramInt;
    if (bool) {
      paramInt = -1000 - b.nextInt(500);
    } else {
      paramInt = -2000 - b.nextInt(1000);
    }
    return paramPoint.a(new ItemStatus.Velocity(d1, paramInt)).a(new ItemStatus.Acceleration(0.0D, 200.0D)).a(81);
  }
  
  public static void b(Object paramObject, View paramView)
  {
    d.add(paramObject);
    if (a == null)
    {
      a = a(paramView.getContext());
      a.setAnimationListener(new StickerBubbleAnimationHelper.1());
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleHelper", 2, "start to shake");
    }
    if (paramView != null) {
      paramView.startAnimation(a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper
 * JD-Core Version:    0.7.0.1
 */