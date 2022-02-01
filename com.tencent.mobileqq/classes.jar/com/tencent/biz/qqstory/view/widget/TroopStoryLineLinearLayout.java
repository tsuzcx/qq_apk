package com.tencent.biz.qqstory.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import bggq;
import java.lang.reflect.Field;

public class TroopStoryLineLinearLayout
  extends LinearLayout
{
  public TroopStoryLineLinearLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TroopStoryLineLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  @TargetApi(16)
  private void a()
  {
    Drawable localDrawable = getResources().getDrawable(2130840505);
    Object localObject;
    float f;
    if ((localDrawable instanceof RotateDrawable))
    {
      localObject = (RotateDrawable)localDrawable;
      f = bggq.a(getContext(), 66.5F);
    }
    try
    {
      Field localField = RotateDrawable.class.getDeclaredField("mState");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = Class.forName(localField.getType().getName()).getDeclaredField("mPivotX");
      localField.setAccessible(true);
      localField.set(localObject, Float.valueOf(f));
      if (Build.VERSION.SDK_INT < 16)
      {
        setBackgroundDrawable(localDrawable);
        return;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
      setBackground(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.TroopStoryLineLinearLayout
 * JD-Core Version:    0.7.0.1
 */