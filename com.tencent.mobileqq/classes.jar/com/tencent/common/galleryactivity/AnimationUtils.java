package com.tencent.common.galleryactivity;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.widget.Gallery;

public class AnimationUtils
{
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (paramInt1 > 0)
    {
      f1 = f2;
      if (paramInt2 > 0)
      {
        f1 = f2;
        if (paramInt3 > 0)
        {
          if (paramInt4 <= 0) {
            return 1.0F;
          }
          if ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4 * paramInt1 / paramInt3)) {}
          for (;;)
          {
            return paramInt3 / paramInt1;
            if ((paramInt1 < paramInt3) && (paramInt2 >= paramInt4)) {
              return 1.0F;
            }
            if ((paramInt1 < paramInt3) || (paramInt2 >= paramInt4 * paramInt1 / paramInt3))
            {
              if ((paramInt1 > paramInt3) || (paramInt2 > paramInt4)) {
                break;
              }
              f1 = f2;
              if (paramInt1 >= paramInt3) {
                break label146;
              }
              f1 = f2;
              if (paramInt1 <= paramInt3 / 2) {
                break label146;
              }
              f1 = f2;
              if (paramInt4 <= paramInt3 / paramInt1 * paramInt2) {
                break label146;
              }
            }
          }
          f1 = Math.min(paramInt4 / paramInt2, paramInt3 / paramInt1);
        }
      }
    }
    label146:
    return f1;
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramObject);
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Object paramObject)
  {
    float f = Gallery.getAIOImageScale(paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    if (paramInt2 >= paramInt1 * 3) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && ((paramInt1 > paramInt3) || (paramInt2 > paramInt4)) && ((paramInt1 >= URLDrawableHelper.AIO_IMAGE_MAX_SIZE) || (paramInt2 >= URLDrawableHelper.AIO_IMAGE_MAX_SIZE)))
    {
      f = Math.min(paramInt3 / paramInt1, Gallery.MAX_SCALE_DEFAULT);
      i = 49;
    }
    else
    {
      i = 17;
    }
    if ((paramBoolean) || (f <= 1.0F))
    {
      paramInt1 = (int)(paramInt1 * f);
      paramInt2 = (int)(paramInt2 * f);
    }
    Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
    if (i == 49)
    {
      localRect.offset((paramInt3 - paramInt1) / 2, 0);
      return localRect;
    }
    if (i == 17)
    {
      localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
      if ((paramObject != null) && ((paramObject instanceof AIOImageData)))
      {
        paramObject = (AIOImageData)paramObject;
        if ((paramObject.z != null) && (paramObject.z.length() != 0) && (!paramObject.z.equals("null"))) {
          localRect.offset(0, (int)(BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density * -15.0F * f));
        }
      }
    }
    return localRect;
  }
  
  public static Rect a(View paramView)
  {
    Rect localRect = new Rect(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getWidth() - paramView.getPaddingRight(), paramView.getHeight() - paramView.getPaddingBottom());
    a(paramView, localRect);
    return localRect;
  }
  
  public static boolean a(View paramView, Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    Point localPoint = new Point();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (j > 0)
      {
        Rect localRect = paramRect;
        if (paramRect == null)
        {
          localRect = new Rect();
          localRect.set(0, 0, i, j);
        }
        localPoint.set(-paramView.getScrollX(), -paramView.getScrollY());
        localRect.offset((i - localRect.width()) / 2, (j - localRect.height()) / 2);
        if (localViewGroup != null)
        {
          bool1 = bool2;
          if (!localViewGroup.getChildVisibleRect(paramView, localRect, localPoint)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */