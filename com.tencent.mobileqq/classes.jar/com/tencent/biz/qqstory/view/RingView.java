package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xuq;

public class RingView
  extends View
{
  protected RectF a;
  protected List<xuq> a;
  
  public RingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected static void a()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("not main thread !");
    }
  }
  
  public void a(xuq paramxuq)
  {
    
    if (paramxuq == null) {
      throw new NullPointerException("drawInfo should not be NULL");
    }
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()) {
      paramxuq.a((int)this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramxuq);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xuq localxuq = (xuq)localIterator.next();
      localxuq.a((int)this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2);
      localxuq.a(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = super.getWidth();
    paramInt2 = super.getHeight();
    int j = super.getPaddingLeft();
    int k = super.getPaddingRight();
    paramInt3 = super.getPaddingTop();
    paramInt4 = super.getPaddingBottom();
    paramInt1 = Math.min(i - j - k, paramInt2 - paramInt3 - paramInt4);
    i = (i - j - k - paramInt1) / 2 + j;
    paramInt2 = (paramInt2 - paramInt3 - paramInt4 - paramInt1) / 2 + paramInt3;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = i;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (i + paramInt1);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramInt2 + paramInt1);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xuq)localIterator.next()).a((int)this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height() / 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.RingView
 * JD-Core Version:    0.7.0.1
 */