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
import com.tencent.mobileqq.util.DisplayUtil;
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
    Drawable localDrawable = getResources().getDrawable(2130841367);
    if ((localDrawable instanceof RotateDrawable))
    {
      Object localObject = (RotateDrawable)localDrawable;
      float f = DisplayUtil.a(getContext(), 66.5F);
      try
      {
        Field localField = RotateDrawable.class.getDeclaredField("mState");
        localField.setAccessible(true);
        localObject = localField.get(localObject);
        localField = Class.forName(localField.getType().getName()).getDeclaredField("mPivotX");
        localField.setAccessible(true);
        localField.set(localObject, Float.valueOf(f));
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
      if (Build.VERSION.SDK_INT < 16)
      {
        setBackgroundDrawable(localDrawable);
        return;
      }
      setBackground(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.TroopStoryLineLinearLayout
 * JD-Core Version:    0.7.0.1
 */