package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DotAnimationView
  extends View
{
  private static String jdField_a_of_type_JavaLangString = "DotAnimationView";
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private List<DotAnimationView.Dot> jdField_a_of_type_JavaUtilList = new ArrayList(3);
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public DotAnimationView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public DotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public DotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DotAnimationView.Dot localDot = (DotAnimationView.Dot)localIterator.next();
      paramCanvas.drawCircle(getWidth() / 2 + localDot.b, getHeight() / 2, localDot.a, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), -20.0F);
    this.b = UIUtils.a(getContext(), -50.0F);
    this.c = UIUtils.a(getContext(), -70.0F);
    this.d = UIUtils.a(getContext(), -95.0F);
    this.e = UIUtils.a(getContext(), 3.0F);
    this.f = UIUtils.a(getContext(), 6.0F);
    this.g = UIUtils.a(getContext(), 30.0F);
    this.h = UIUtils.a(getContext(), -20.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#DDDEE2"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.1F);
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_JavaUtilList.add(new DotAnimationView.Dot(this, null));
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    int i = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DotAnimationView.Dot localDot = (DotAnimationView.Dot)localIterator.next();
      if ((localDot.a != 0.0F) || (localDot.b != 0.0F)) {
        i = 1;
      }
      localDot.a = 0.0F;
      localDot.b = 0.0F;
    }
    if (i != 0)
    {
      setTranslationY(0.0F);
      invalidate();
    }
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return;
    }
    int i = 0;
    this.jdField_a_of_type_Boolean = false;
    int j = this.jdField_a_of_type_Int;
    Object localObject;
    DotAnimationView.Dot localDot;
    if (paramFloat > j)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDot = (DotAnimationView.Dot)((Iterator)localObject).next();
        localDot.a = 0.0F;
        localDot.b = 0.0F;
      }
      ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(1)).a = (this.f * (Math.abs(paramFloat) / Math.abs(this.jdField_a_of_type_Int)));
    }
    else
    {
      int k = this.b;
      if (paramFloat > k)
      {
        paramFloat = (j - paramFloat) / (j - k);
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(i)).b = (((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(i)).c * paramFloat);
          if (i == 1)
          {
            localObject = (DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(i);
            j = this.f;
            ((DotAnimationView.Dot)localObject).a = (j - (j - this.e) * paramFloat);
          }
          else
          {
            ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(i)).a = this.e;
          }
          i += 1;
        }
      }
      if (paramFloat > this.c)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDot = (DotAnimationView.Dot)((Iterator)localObject).next();
          localDot.a = this.e;
          localDot.b = localDot.c;
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDot = (DotAnimationView.Dot)((Iterator)localObject).next();
        localDot.b = localDot.c;
      }
      i = this.c;
      j = this.d;
      float f1 = (j - i) / 2 + i;
      float f2 = j;
      if (paramFloat > f1)
      {
        paramFloat = (i - paramFloat) / (i - f1);
        localObject = (DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(0);
        localDot = (DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(2);
        i = this.e;
        paramFloat = i - i * paramFloat;
        localDot.a = paramFloat;
        ((DotAnimationView.Dot)localObject).a = paramFloat;
        ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(1)).a = this.e;
      }
      else if (paramFloat > f2)
      {
        paramFloat = (f1 - paramFloat) / (f1 - f2);
        localObject = (DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(0);
        ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(2)).a = 0.0F;
        ((DotAnimationView.Dot)localObject).a = 0.0F;
        localObject = (DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(1);
        i = this.e;
        ((DotAnimationView.Dot)localObject).a = (i - i * paramFloat);
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((DotAnimationView.Dot)((Iterator)localObject).next()).a = 0.0F;
        }
      }
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DotAnimationView.Dot localDot = (DotAnimationView.Dot)localIterator.next();
      localDot.a = 0.0F;
      localDot.b = 0.0F;
      localDot.c = 0.0F;
    }
    paramInt1 = this.g;
    ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(0)).c = this.h;
    ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(1)).c = 0.0F;
    ((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(2)).c = (-((DotAnimationView.Dot)this.jdField_a_of_type_JavaUtilList.get(0)).c);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.DotAnimationView
 * JD-Core Version:    0.7.0.1
 */