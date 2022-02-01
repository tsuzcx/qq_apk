package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class CanDisableTouchViewPager
  extends ViewPager
{
  protected int a;
  protected boolean a;
  protected boolean b = true;
  
  public CanDisableTouchViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
  }
  
  public CanDisableTouchViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a(int paramInt)
  {
    try
    {
      Method localMethod = getClass().getSuperclass().getDeclaredMethod("pageScrolled", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CanDisableTouchViewPager", 1, "superPageScrolled: ", localException);
    }
  }
  
  private boolean a()
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      Object localObject = localView.getTag();
      if ((localObject == null) || (!(localObject instanceof Integer))) {}
      int j;
      do
      {
        i += 1;
        break;
        j = ((Integer)localObject).intValue();
      } while ((localView.getScaleX() != 1.0F) || (j == getCurrentItem()));
      return false;
    }
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Int != getChildCount()) {
      this.b = true;
    }
    if (!a()) {
      this.b = true;
    }
    if (this.b) {
      a(getScrollX());
    }
    this.jdField_a_of_type_Int = getChildCount();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCanScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.CanDisableTouchViewPager
 * JD-Core Version:    0.7.0.1
 */