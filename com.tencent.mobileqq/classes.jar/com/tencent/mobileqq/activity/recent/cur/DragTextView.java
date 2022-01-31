package com.tencent.mobileqq.activity.recent.cur;

import ahpr;
import ahps;
import ahpt;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

@TargetApi(19)
public class DragTextView
  extends TextView
  implements ahps
{
  private static int jdField_a_of_type_Int;
  private static int b;
  private static int c;
  private ahpt jdField_a_of_type_Ahpt;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  private int d = -1;
  
  public DragTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private static void a(Context paramContext)
  {
    if (jdField_a_of_type_Int == 0)
    {
      float f = 16.0F * paramContext.getResources().getDisplayMetrics().density;
      jdField_a_of_type_Int = (int)f;
      b = (int)(1.5F * f);
      c = (int)(f * 0.5F);
    }
  }
  
  private void a(View paramView, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    super.getGlobalVisibleRect(paramRect);
    if (this.d == 2)
    {
      paramRect.top = (paramRect.top - localRect.top - jdField_a_of_type_Int);
      paramRect.left = (paramRect.left - localRect.left - c);
      paramRect.bottom = (paramRect.bottom - localRect.top + c);
      paramRect.right = (paramRect.right - localRect.left + jdField_a_of_type_Int);
      return;
    }
    paramRect.top = (paramRect.top - localRect.top - b);
    paramRect.left = (paramRect.left - localRect.left - b);
    paramRect.bottom = (paramRect.bottom - localRect.top + jdField_a_of_type_Int);
    paramRect.right = (paramRect.right - localRect.left + jdField_a_of_type_Int);
  }
  
  public int a()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (paramBoolean)) {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.d != -1) && (!this.jdField_a_of_type_Boolean) && (paramMotionEvent.getAction() == 0))
    {
      if (this.jdField_a_of_type_Ahpt != null)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ahpt.a(this, this.d);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragViewType(int paramInt)
  {
    setDragViewType(paramInt, null);
  }
  
  public void setDragViewType(int paramInt, View paramView)
  {
    this.d = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)getParent());
    }
    if ((this.jdField_a_of_type_Ahpt != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidGraphicsRect == null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidViewView.setTouchDelegate(new ahpr(this, this.jdField_a_of_type_AndroidGraphicsRect, this));
    }
  }
  
  public void setOnModeChangeListener(ahpt paramahpt)
  {
    this.jdField_a_of_type_Ahpt = paramahpt;
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "setOnModeChangeListener:" + paramahpt);
    }
    if ((this.jdField_a_of_type_Ahpt != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidGraphicsRect == null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidViewView.setTouchDelegate(new ahpr(this, this.jdField_a_of_type_AndroidGraphicsRect, this));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragTextView
 * JD-Core Version:    0.7.0.1
 */