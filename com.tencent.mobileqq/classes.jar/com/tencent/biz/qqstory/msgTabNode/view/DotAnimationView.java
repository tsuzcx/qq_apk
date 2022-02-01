package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wxn;
import zps;

public class DotAnimationView
  extends View
{
  private static String jdField_a_of_type_JavaLangString = "DotAnimationView";
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private List<wxn> jdField_a_of_type_JavaUtilList = new ArrayList(3);
  private boolean jdField_a_of_type_Boolean;
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
      wxn localwxn = (wxn)localIterator.next();
      paramCanvas.drawCircle(getWidth() / 2 + localwxn.b, getHeight() / 2, localwxn.a, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = zps.a(getContext(), -20.0F);
    this.b = zps.a(getContext(), -50.0F);
    this.c = zps.a(getContext(), -70.0F);
    this.d = zps.a(getContext(), -95.0F);
    this.e = zps.a(getContext(), 3.0F);
    this.f = zps.a(getContext(), 6.0F);
    this.g = zps.a(getContext(), 30.0F);
    this.h = zps.a(getContext(), -20.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#DDDEE2"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.1F);
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_JavaUtilList.add(new wxn(this, null));
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        wxn localwxn = (wxn)localIterator.next();
        if ((localwxn.a != 0.0F) || (localwxn.b != 0.0F)) {
          i = 1;
        }
        localwxn.a = 0.0F;
        localwxn.b = 0.0F;
      }
    } while (i == 0);
    setTranslationY(0.0F);
    invalidate();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    Object localObject;
    wxn localwxn;
    if (paramFloat > this.jdField_a_of_type_Int)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localwxn = (wxn)((Iterator)localObject).next();
        localwxn.a = 0.0F;
        localwxn.b = 0.0F;
      }
      ((wxn)this.jdField_a_of_type_JavaUtilList.get(1)).a = (this.f * (Math.abs(paramFloat) / Math.abs(this.jdField_a_of_type_Int)));
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramFloat > this.b)
      {
        paramFloat = (this.jdField_a_of_type_Int - paramFloat) / (this.jdField_a_of_type_Int - this.b);
        int i = 0;
        label142:
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          ((wxn)this.jdField_a_of_type_JavaUtilList.get(i)).b = (((wxn)this.jdField_a_of_type_JavaUtilList.get(i)).c * paramFloat);
          if (i != 1) {
            break label242;
          }
        }
        label242:
        for (((wxn)this.jdField_a_of_type_JavaUtilList.get(i)).a = (this.f - (this.f - this.e) * paramFloat);; ((wxn)this.jdField_a_of_type_JavaUtilList.get(i)).a = this.e)
        {
          i += 1;
          break label142;
          break;
        }
      }
      if (paramFloat > this.c)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localwxn = (wxn)((Iterator)localObject).next();
          localwxn.a = this.e;
          localwxn.b = localwxn.c;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localwxn = (wxn)((Iterator)localObject).next();
          localwxn.b = localwxn.c;
        }
        float f1 = this.c + (this.d - this.c) / 2;
        float f2 = this.d;
        if (paramFloat > f1)
        {
          paramFloat = (this.c - paramFloat) / (this.c - f1);
          localObject = (wxn)this.jdField_a_of_type_JavaUtilList.get(0);
          localwxn = (wxn)this.jdField_a_of_type_JavaUtilList.get(2);
          paramFloat = this.e - paramFloat * this.e;
          localwxn.a = paramFloat;
          ((wxn)localObject).a = paramFloat;
          ((wxn)this.jdField_a_of_type_JavaUtilList.get(1)).a = this.e;
        }
        else if (paramFloat > f2)
        {
          paramFloat = (f1 - paramFloat) / (f1 - f2);
          localObject = (wxn)this.jdField_a_of_type_JavaUtilList.get(0);
          ((wxn)this.jdField_a_of_type_JavaUtilList.get(2)).a = 0.0F;
          ((wxn)localObject).a = 0.0F;
          ((wxn)this.jdField_a_of_type_JavaUtilList.get(1)).a = (this.e - paramFloat * this.e);
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((wxn)((Iterator)localObject).next()).a = 0.0F;
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
      wxn localwxn = (wxn)localIterator.next();
      localwxn.a = 0.0F;
      localwxn.b = 0.0F;
      localwxn.c = 0.0F;
    }
    paramInt1 = this.g;
    ((wxn)this.jdField_a_of_type_JavaUtilList.get(0)).c = this.h;
    ((wxn)this.jdField_a_of_type_JavaUtilList.get(1)).c = 0.0F;
    ((wxn)this.jdField_a_of_type_JavaUtilList.get(2)).c = (-((wxn)this.jdField_a_of_type_JavaUtilList.get(0)).c);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.DotAnimationView
 * JD-Core Version:    0.7.0.1
 */