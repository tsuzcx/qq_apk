package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.ShieldFriendStoryEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.RegionDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class StoryListUtils
{
  public static String a;
  public static final int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 120, 200, 320, 512, 640, 750, 1000 };
    jdField_a_of_type_JavaLangString = Integer.toString(jdField_a_of_type_ArrayOfInt[0]);
  }
  
  public static float a(long paramLong)
  {
    return (float)(NetConnInfoCenter.getServerTimeMillis() - paramLong) / 3600000.0F;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 5;
    case 3: 
    case 6: 
      return 2;
    case 1: 
    case 2: 
    case 4: 
      return 1;
    case 0: 
      return 0;
    }
    return 3;
  }
  
  public static int a(View paramView)
  {
    if (paramView != null)
    {
      if (!paramView.isShown()) {
        return 2147483647;
      }
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = paramView.getHeight();
      int j = UIUtils.d(paramView.getContext()) / 2;
      if (i > 0)
      {
        i = Math.min(Math.abs(j - arrayOfInt[1]), Math.abs(j - (arrayOfInt[1] + i)));
        paramView = new StringBuilder();
        paramView.append("getDistanceToCenterY=");
        paramView.append(i);
        SLog.b("Q.qqstory.home.StoryListUtils", paramView.toString());
        return i;
      }
    }
    return 2147483647;
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2, Map<String, Bitmap> paramMap, Transformation paramTransformation)
  {
    long l = System.currentTimeMillis();
    if (paramDrawable == null) {
      return null;
    }
    Object localObject1;
    float f1;
    int i;
    if ((paramDrawable instanceof RegionDrawable))
    {
      localObject1 = (RegionDrawable)paramDrawable;
      if ((((RegionDrawable)localObject1).getBitmap() != null) && (!((RegionDrawable)localObject1).getBitmap().isRecycled()))
      {
        f1 = ((RegionDrawable)localObject1).getBitmap().getWidth();
        i = ((RegionDrawable)localObject1).getBitmap().getHeight();
      }
      else
      {
        f1 = ((RegionDrawable)localObject1).getIntrinsicWidth();
        i = ((RegionDrawable)localObject1).getIntrinsicHeight();
      }
    }
    else
    {
      f1 = paramDrawable.getIntrinsicWidth();
      i = paramDrawable.getIntrinsicHeight();
    }
    float f2 = i;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(f1 / f2 * paramInt2);
        break label157;
      }
      f1 = f2 / f1 * paramInt1;
    }
    else
    {
      paramInt1 = (int)f1;
      f1 = f2;
    }
    paramInt2 = (int)f1;
    label157:
    if (paramMap != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("w=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("h=");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject1 = (Bitmap)paramMap.get(((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    try
    {
      if (((Bitmap)localObject1).isRecycled())
      {
        InfoPrinter.b("Q.qqstory.home.StoryListUtils", new Object[] { "drawable2Bitmap need create width=", Integer.valueOf(paramInt1), ",height=", Integer.valueOf(paramInt2) });
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject2 = localObject1;
        if (paramMap != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("w=");
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append("h=");
          ((StringBuilder)localObject2).append(paramInt2);
          paramMap.put(((StringBuilder)localObject2).toString(), localObject1);
          localObject2 = localObject1;
        }
      }
      if (localObject2 != null)
      {
        ((Bitmap)localObject2).eraseColor(0);
        paramMap = new Canvas((Bitmap)localObject2);
        paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
        paramDrawable.draw(paramMap);
      }
      SLog.a("Q.qqstory.home.StoryListUtils", "drawable2Bitmap:width=%d,height=%d,cost time=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis() - l));
      if (paramTransformation != null) {
        return paramTransformation.a((Bitmap)localObject2);
      }
      return localObject2;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      label423:
      break label423;
    }
    paramDrawable = new StringBuilder();
    paramDrawable.append("drawable2Bitmap out off memory width=");
    paramDrawable.append(paramInt1);
    paramDrawable.append(",height=");
    paramDrawable.append(paramInt2);
    SLog.e("Q.qqstory.home.StoryListUtils", paramDrawable.toString());
    return null;
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      break;
    case 13: 
      str = HardCodeUtil.a(2131714241);
      break;
    case 12: 
      str = HardCodeUtil.a(2131714270);
      break;
    case 11: 
      str = HardCodeUtil.a(2131714257);
      break;
    case 10: 
      str = HardCodeUtil.a(2131714273);
      break;
    case 9: 
      str = HardCodeUtil.a(2131714262);
      break;
    case 8: 
      str = HardCodeUtil.a(2131714253);
      break;
    case 7: 
      str = HardCodeUtil.a(2131714245);
      break;
    case 6: 
      str = HardCodeUtil.a(2131714239);
      break;
    case 5: 
      str = HardCodeUtil.a(2131714275);
      break;
    case 4: 
      str = HardCodeUtil.a(2131714248);
      break;
    case 3: 
      str = HardCodeUtil.a(2131714258);
      break;
    case 2: 
      str = HardCodeUtil.a(2131714259);
      break;
    case 1: 
      str = HardCodeUtil.a(2131714274);
      break;
    case 0: 
      str = HardCodeUtil.a(2131714280);
      break;
    case -1: 
      str = HardCodeUtil.a(2131714261);
      break;
    case -2: 
      str = HardCodeUtil.a(2131714281);
      break;
    case -3: 
      str = HardCodeUtil.a(2131714266);
      break;
    case -4: 
      str = HardCodeUtil.a(2131714265);
      break;
    case -5: 
      str = HardCodeUtil.a(2131714244);
      break;
    case -6: 
      str = HardCodeUtil.a(2131714254);
      break;
    case -7: 
      str = HardCodeUtil.a(2131714276);
      break;
    case -8: 
      str = HardCodeUtil.a(2131714240);
      break;
    case -9: 
      str = HardCodeUtil.a(2131714243);
      break;
    case -10: 
      str = HardCodeUtil.a(2131714279);
      break;
    case -11: 
      str = HardCodeUtil.a(2131714250);
      break;
    case -12: 
      str = HardCodeUtil.a(2131714252);
    }
    if (TextUtils.isEmpty(str)) {
      return HardCodeUtil.a(2131714251);
    }
    Object localObject = str;
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131714263));
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, TimeZone.getDefault().getRawOffset(), false);
  }
  
  public static String a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong1 == -1L) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramBoolean) && (TimeZone.getDefault().getRawOffset() / 3600000 != (int)(paramLong2 / 3600000L))) {
      localStringBuilder.append("当地 ");
    }
    Calendar localCalendar = Calendar.getInstance();
    long l = NetConnInfoCenter.getServerTimeMillis();
    if ((l - paramLong1) / 1000L < 60L)
    {
      localStringBuilder.append("刚刚");
    }
    else
    {
      localCalendar.setTimeInMillis(l);
      int i = localCalendar.get(1);
      int j = localCalendar.get(6);
      localCalendar.setTimeInMillis(paramLong1);
      int k = localCalendar.get(1);
      int m = localCalendar.get(6);
      localCalendar.add(6, 1);
      int n = localCalendar.get(6);
      if (paramBoolean)
      {
        TimeZone localTimeZone = TimeZone.getDefault();
        localTimeZone.setRawOffset((int)paramLong2);
        localCalendar.setTimeZone(localTimeZone);
      }
      localCalendar.setTimeInMillis(paramLong1);
      int i1 = localCalendar.get(1);
      int i2 = localCalendar.get(2) + 1;
      int i3 = localCalendar.get(5);
      int i4 = localCalendar.get(11);
      int i5 = localCalendar.get(12);
      if (m == j)
      {
        localStringBuilder.append(String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5) }));
      }
      else if (n == j)
      {
        localStringBuilder.append("昨天 ");
        localStringBuilder.append(String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5) }));
      }
      else if (k == i)
      {
        localStringBuilder.append(String.format(Locale.getDefault(), "%d月%d日 %02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5) }));
      }
      else
      {
        localStringBuilder.append(String.format(Locale.getDefault(), "%d年%d月%d日", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramLong1 == -1L) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2;
    if ((paramBoolean2) && (paramBoolean1))
    {
      i = TimeZone.getDefault().getRawOffset() / 3600000;
      j = (int)(paramLong2 / 3600000L);
      if (i != j)
      {
        localObject1 = a(j, false);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("·");
        localStringBuilder.append(((StringBuilder)localObject2).toString());
      }
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    int i = ((Calendar)localObject1).get(1);
    int j = ((Calendar)localObject1).get(6);
    ((Calendar)localObject1).setTimeInMillis(paramLong1);
    int k = ((Calendar)localObject1).get(1);
    int m = ((Calendar)localObject1).get(6);
    ((Calendar)localObject1).add(6, 1);
    int n = ((Calendar)localObject1).get(6);
    if (paramBoolean1)
    {
      localObject2 = TimeZone.getDefault();
      ((TimeZone)localObject2).setRawOffset((int)paramLong2);
      ((Calendar)localObject1).setTimeZone((TimeZone)localObject2);
    }
    ((Calendar)localObject1).setTimeInMillis(paramLong1);
    int i1 = ((Calendar)localObject1).get(1);
    int i2 = ((Calendar)localObject1).get(2) + 1;
    int i3 = ((Calendar)localObject1).get(5);
    int i4 = ((Calendar)localObject1).get(11);
    int i5 = ((Calendar)localObject1).get(12);
    if (paramBoolean2) {
      if ((k == i) && (m == j)) {
        localStringBuilder.append("今天");
      } else if ((k == i) && (n == j)) {
        localStringBuilder.append("昨天 ");
      } else if (k == i) {
        localStringBuilder.append(String.format(Locale.getDefault(), "%d月%d日", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) }));
      } else {
        localStringBuilder.append(String.format(Locale.getDefault(), "%d年%d月%d日", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
    }
    if (paramBoolean3) {
      localStringBuilder.append(String.format(Locale.getDefault(), " %02d:%02d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5) }));
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, boolean paramBoolean)
  {
    int i = paramInt1 + paramInt3;
    if (i <= paramBitmap1.getWidth())
    {
      int j = paramInt2 + paramInt4;
      if (j <= paramBitmap1.getHeight())
      {
        if ((!paramBitmap1.isMutable()) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == paramBitmap1.getWidth()) && (paramInt4 == paramBitmap1.getHeight()) && ((paramMatrix == null) || (paramMatrix.isIdentity()))) {
          return;
        }
        Canvas localCanvas = new Canvas();
        Rect localRect = new Rect(paramInt1, paramInt2, i, j);
        RectF localRectF = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
        if ((paramMatrix != null) && (!paramMatrix.isIdentity()))
        {
          boolean bool = paramMatrix.rectStaysRect();
          Object localObject = new RectF();
          paramMatrix.mapRect((RectF)localObject, localRectF);
          localCanvas.translate(-((RectF)localObject).left, -((RectF)localObject).top);
          localCanvas.concat(paramMatrix);
          localObject = new Paint();
          ((Paint)localObject).setFilterBitmap(paramBoolean);
          paramMatrix = (Matrix)localObject;
          if ((bool ^ true))
          {
            ((Paint)localObject).setAntiAlias(true);
            paramMatrix = (Matrix)localObject;
          }
        }
        else
        {
          paramMatrix = null;
        }
        localCanvas.setBitmap(paramBitmap2);
        localCanvas.drawBitmap(paramBitmap1, localRect, localRectF, paramMatrix);
        localCanvas.setBitmap(null);
        return;
      }
      throw new IllegalArgumentException("y + height must be <= bitmap.height()");
    }
    throw new IllegalArgumentException("x + width must be <= bitmap.width()");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).a(false);
    paramQQAppInterface = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
      if (localQQStoryUserInfo != null) {
        paramQQAppInterface.add(localQQStoryUserInfo.uin);
      }
    }
    a(paramQQAppInterface);
  }
  
  public static void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportShieldFriendStory:");
      ((StringBuilder)localObject).append(paramArrayList.size());
      SLog.b("Q.qqstory.home.StoryListUtils", ((StringBuilder)localObject).toString());
      localObject = new ShieldFriendStoryEvent();
      ((ShieldFriendStoryEvent)localObject).a = paramArrayList;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str;
    if (paramString.startsWith("file://"))
    {
      str = paramString.replaceFirst("file://", "");
    }
    else
    {
      str = paramString;
      if (paramString.startsWith("file:")) {
        str = paramString.replaceFirst("file:", "");
      }
    }
    return new File(str).exists();
  }
  
  public static int b(View paramView)
  {
    if (paramView != null)
    {
      if (!paramView.isShown()) {
        return 2147483647;
      }
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = paramView.getHeight();
      if (i > 0)
      {
        i = Math.min(Math.abs(0 - arrayOfInt[1]), Math.abs(0 - (arrayOfInt[1] + i)));
        paramView = new StringBuilder();
        paramView.append("getDistanceToTop=");
        paramView.append(i);
        SLog.b("Q.qqstory.home.StoryListUtils", paramView.toString());
        return i;
      }
    }
    return 2147483647;
  }
  
  public static String b(long paramLong)
  {
    if (paramLong == -1L) {
      return "(Unknown Time)";
    }
    Calendar localCalendar = Calendar.getInstance();
    long l = NetConnInfoCenter.getServerTimeMillis();
    if ((l - paramLong) / 1000L < 60L) {
      return HardCodeUtil.a(2131714255);
    }
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2) + 1;
    int k = localCalendar.get(5);
    int m = localCalendar.get(6);
    int n = localCalendar.get(11);
    int i1 = localCalendar.get(12);
    localCalendar.setTimeInMillis(l);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(6);
    if (m == i3) {
      return String.format(Locale.getDefault(), HardCodeUtil.a(2131714260), new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
    }
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.add(6, 1);
    if (localCalendar.get(6) == i3) {
      return String.format(Locale.getDefault(), HardCodeUtil.a(2131714249), new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
    }
    if (i != i2) {
      return String.format(Locale.getDefault(), "%d年%d月%d日", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    }
    return String.format(Locale.getDefault(), "%d月%d日 %02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i1) });
  }
  
  public static int c(View paramView)
  {
    if (paramView != null)
    {
      if (!paramView.isShown()) {
        return 2147483647;
      }
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = paramView.getHeight();
      int j = UIUtils.d(paramView.getContext());
      if (i > 0)
      {
        i = Math.min(Math.abs(j - arrayOfInt[1]), Math.abs(j - (arrayOfInt[1] + i)));
        paramView = new StringBuilder();
        paramView.append("getDistanceToBottom=");
        paramView.append(i);
        SLog.b("Q.qqstory.home.StoryListUtils", paramView.toString());
        return i;
      }
    }
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils
 * JD-Core Version:    0.7.0.1
 */