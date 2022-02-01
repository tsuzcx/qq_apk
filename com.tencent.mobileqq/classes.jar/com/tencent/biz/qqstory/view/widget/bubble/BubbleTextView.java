package com.tencent.biz.qqstory.view.widget.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class BubbleTextView
  extends TextView
{
  public float a;
  public int a;
  private BubbleDrawable a;
  public boolean a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d = 50.0F;
  
  public BubbleTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 11.0F);
    this.jdField_b_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 3.0F);
    this.jdField_c_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 5.0F);
    this.jdField_a_of_type_Int = getResources().getColor(2131166511);
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 11.0F);
    this.jdField_b_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 3.0F);
    this.jdField_c_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 5.0F);
    this.jdField_a_of_type_Int = getResources().getColor(2131166511);
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    a();
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 11.0F);
    this.jdField_b_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 3.0F);
    this.jdField_c_of_type_Float = UIUtils.a(BaseApplicationImpl.getContext(), 5.0F);
    this.jdField_a_of_type_Int = getResources().getColor(2131166511);
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(0, paramInt1, 0, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleDrawable = new BubbleDrawable();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleDrawable.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramInt1, paramInt3, paramInt2, paramInt4);
    BubbleDrawable localBubbleDrawable = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleDrawable;
    localBubbleDrawable.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localBubbleDrawable.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
    localBubbleDrawable.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    localBubbleDrawable.jdField_c_of_type_Float = this.jdField_c_of_type_Float;
    localBubbleDrawable.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    localBubbleDrawable.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localBubbleDrawable.d = this.d;
    localBubbleDrawable.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  private void c()
  {
    a(getWidth(), getHeight());
  }
  
  private void d()
  {
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int n = this.jdField_b_of_type_Int;
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3) {
            m = (int)(m + this.jdField_c_of_type_Float);
          }
        }
        else {
          k = (int)(k + this.jdField_c_of_type_Float);
        }
      }
      else {
        j = (int)(j + this.jdField_a_of_type_Float);
      }
    }
    else {
      i = (int)(i + this.jdField_a_of_type_Float);
    }
    setPadding(i, k, j, m);
  }
  
  public void a()
  {
    b();
    d();
  }
  
  protected void b() {}
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    BubbleDrawable localBubbleDrawable = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleDrawable;
    if (localBubbleDrawable != null) {
      localBubbleDrawable.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView
 * JD-Core Version:    0.7.0.1
 */