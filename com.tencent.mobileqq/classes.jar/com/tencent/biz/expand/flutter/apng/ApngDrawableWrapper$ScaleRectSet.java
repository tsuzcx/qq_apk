package com.tencent.biz.expand.flutter.apng;

import android.graphics.Rect;

public class ApngDrawableWrapper$ScaleRectSet
{
  public Rect a;
  public String a;
  public Rect b = new Rect();
  
  public ApngDrawableWrapper$ScaleRectSet()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public static ScaleRectSet a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    ScaleRectSet localScaleRectSet = new ScaleRectSet();
    localScaleRectSet.jdField_a_of_type_JavaLangString = a(paramRect1, paramRect2, paramInt);
    localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.set(paramRect1);
    localScaleRectSet.b.set(paramRect2);
    if ((paramInt == 0) || (paramRect1.width() == 0) || (paramRect1.height() == 0) || (paramRect2.width() == 0) || (paramRect2.height() == 0)) {}
    float f1;
    float f2;
    do
    {
      do
      {
        return localScaleRectSet;
        f1 = paramRect1.width() * 1.0F / paramRect1.height();
        f2 = paramRect2.width() * 1.0F / paramRect2.height();
      } while (f1 == f2);
      if (paramInt == 1)
      {
        if (f1 > f2)
        {
          paramInt = (int)(paramRect1.height() * f2);
          localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.left = ((paramRect1.width() - paramInt) / 2);
          localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.right = (paramInt + localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.left);
          return localScaleRectSet;
        }
        paramInt = (int)(paramRect1.width() / f2);
        localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.top = ((paramRect1.height() - paramInt) / 2);
        localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.bottom = (paramInt + localScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.top);
        return localScaleRectSet;
      }
    } while (paramInt != 2);
    if (f1 > f2)
    {
      paramInt = (int)(paramRect2.width() / f1);
      localScaleRectSet.b.top = ((paramRect2.height() - paramInt) / 2);
      localScaleRectSet.b.bottom = (paramInt + localScaleRectSet.b.top);
      return localScaleRectSet;
    }
    paramInt = (int)(f1 * paramRect2.height());
    localScaleRectSet.b.left = ((paramRect2.width() - paramInt) / 2);
    localScaleRectSet.b.right = (paramInt + localScaleRectSet.b.right);
    return localScaleRectSet;
  }
  
  public static String a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    return paramRect1.hashCode() + "," + paramRect2.hashCode() + "," + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.apng.ApngDrawableWrapper.ScaleRectSet
 * JD-Core Version:    0.7.0.1
 */