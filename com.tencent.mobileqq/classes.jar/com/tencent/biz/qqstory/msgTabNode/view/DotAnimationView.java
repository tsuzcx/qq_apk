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
import niu;

public class DotAnimationView
  extends View
{
  private static String jdField_a_of_type_JavaLangString = "DotAnimationView";
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private List jdField_a_of_type_JavaUtilList = new ArrayList(3);
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
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
      niu localniu = (niu)localIterator.next();
      paramCanvas.drawCircle(getWidth() / 2 + localniu.b, getHeight() / 2, localniu.a, this.jdField_a_of_type_AndroidGraphicsPaint);
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
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#DDDEE2"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.1F);
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_JavaUtilList.add(new niu(this, null));
      i += 1;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      niu localniu = (niu)localIterator.next();
      localniu.a = 0.0F;
      localniu.b = 0.0F;
    }
    setTranslationY(0.0F);
    invalidate();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return;
    }
    Object localObject;
    niu localniu;
    if (paramFloat > this.jdField_a_of_type_Int)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localniu = (niu)((Iterator)localObject).next();
        localniu.a = 0.0F;
        localniu.b = 0.0F;
      }
      ((niu)this.jdField_a_of_type_JavaUtilList.get(1)).a = (this.f * (Math.abs(paramFloat) / Math.abs(this.jdField_a_of_type_Int)));
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramFloat > this.b)
      {
        paramFloat = (this.jdField_a_of_type_Int - paramFloat) / (this.jdField_a_of_type_Int - this.b);
        int i = 0;
        label137:
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          ((niu)this.jdField_a_of_type_JavaUtilList.get(i)).b = (((niu)this.jdField_a_of_type_JavaUtilList.get(i)).c * paramFloat);
          if (i != 1) {
            break label237;
          }
        }
        label237:
        for (((niu)this.jdField_a_of_type_JavaUtilList.get(i)).a = (this.f - (this.f - this.e) * paramFloat);; ((niu)this.jdField_a_of_type_JavaUtilList.get(i)).a = this.e)
        {
          i += 1;
          break label137;
          break;
        }
      }
      if (paramFloat > this.c)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localniu = (niu)((Iterator)localObject).next();
          localniu.a = this.e;
          localniu.b = localniu.c;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localniu = (niu)((Iterator)localObject).next();
          localniu.b = localniu.c;
        }
        float f1 = this.c + (this.d - this.c) / 2;
        float f2 = this.d;
        if (paramFloat > f1)
        {
          paramFloat = (this.c - paramFloat) / (this.c - f1);
          localObject = (niu)this.jdField_a_of_type_JavaUtilList.get(0);
          localniu = (niu)this.jdField_a_of_type_JavaUtilList.get(2);
          paramFloat = this.e - paramFloat * this.e;
          localniu.a = paramFloat;
          ((niu)localObject).a = paramFloat;
          ((niu)this.jdField_a_of_type_JavaUtilList.get(1)).a = this.e;
        }
        else if (paramFloat > f2)
        {
          paramFloat = (f1 - paramFloat) / (f1 - f2);
          localObject = (niu)this.jdField_a_of_type_JavaUtilList.get(0);
          ((niu)this.jdField_a_of_type_JavaUtilList.get(2)).a = 0.0F;
          ((niu)localObject).a = 0.0F;
          ((niu)this.jdField_a_of_type_JavaUtilList.get(1)).a = (this.e - paramFloat * this.e);
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((niu)((Iterator)localObject).next()).a = 0.0F;
          }
        }
      }
    }
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
      niu localniu = (niu)localIterator.next();
      localniu.a = 0.0F;
      localniu.b = 0.0F;
      localniu.c = 0.0F;
    }
    paramInt1 = this.g;
    ((niu)this.jdField_a_of_type_JavaUtilList.get(0)).c = UIUtils.a(getContext(), -20.0F);
    ((niu)this.jdField_a_of_type_JavaUtilList.get(1)).c = 0.0F;
    ((niu)this.jdField_a_of_type_JavaUtilList.get(2)).c = (-((niu)this.jdField_a_of_type_JavaUtilList.get(0)).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.DotAnimationView
 * JD-Core Version:    0.7.0.1
 */