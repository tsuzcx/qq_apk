package com.tencent.mobileqq.activity.photo;

import akqv;
import akqw;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import avii;
import com.tencent.image.RegionDrawableData;
import com.tencent.widget.Gallery;

public class ProGallery
  extends Gallery
{
  private int jdField_a_of_type_Int = 1;
  private akqv jdField_a_of_type_Akqv;
  private akqw jdField_a_of_type_Akqw;
  private avii jdField_a_of_type_Avii;
  
  public ProGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Akqw != null) {
      this.jdField_a_of_type_Akqw.onscaleBegin(paramInt, paramView, paramViewGroup);
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Akqw != null) {
      this.jdField_a_of_type_Akqw.onViewDetached(paramInt, paramView, paramViewGroup, paramBoolean);
    }
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    super.a(paramInt, paramView, paramRegionDrawableData);
    if (this.jdField_a_of_type_Akqw != null) {
      this.jdField_a_of_type_Akqw.onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    }
  }
  
  public void a(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    int n = this.jdField_a_of_type_Int;
    if ((n == 0) || (this.jdField_a_of_type_Akqw == null)) {}
    int m;
    label34:
    do
    {
      return;
      m = this.mItemCount;
      int i = 0;
      int j = paramInt;
      if (i < n)
      {
        j -= 1;
        if (j >= 0) {}
      }
      else
      {
        j = paramInt;
        i = k;
      }
      for (;;)
      {
        if (i < n)
        {
          j += 1;
          if (j < m) {}
        }
        else
        {
          if (!paramBoolean2) {
            break;
          }
          if (!paramBoolean1) {
            break label158;
          }
          paramInt = paramInt - n - 1;
          if (paramInt < 0) {
            break;
          }
          this.jdField_a_of_type_Akqw.onDestroyView(paramInt, null, paramViewGroup);
          return;
          this.jdField_a_of_type_Akqw.onCreateView(j, null, paramViewGroup);
          i += 1;
          break label34;
        }
        this.jdField_a_of_type_Akqw.onCreateView(j, null, paramViewGroup);
        i += 1;
      }
      paramInt = paramInt + n + 1;
    } while (paramInt >= m);
    label158:
    this.jdField_a_of_type_Akqw.onDestroyView(paramInt, null, paramViewGroup);
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Akqw != null) {
      this.jdField_a_of_type_Akqw.onSlot(paramInt, paramView, paramViewGroup);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Avii != null) {
      this.jdField_a_of_type_Avii.a(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Avii != null) {
      this.jdField_a_of_type_Avii.a(paramScaleGestureDetector);
    }
    return super.onScale(paramScaleGestureDetector);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (this.jdField_a_of_type_Akqv != null) {
      this.jdField_a_of_type_Akqv.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return bool;
  }
  
  public void setGalleryScaleListener(avii paramavii)
  {
    this.jdField_a_of_type_Avii = paramavii;
  }
  
  public void setGestureListener(akqv paramakqv)
  {
    this.jdField_a_of_type_Akqv = paramakqv;
  }
  
  public void setOnNoBlankListener(akqw paramakqw)
  {
    if (paramakqw != this.jdField_a_of_type_Akqw) {
      this.jdField_a_of_type_Akqw = paramakqw;
    }
  }
  
  public void setSelection(int paramInt)
  {
    int m = 0;
    super.setSelection(paramInt);
    int n = this.jdField_a_of_type_Int;
    if ((n == 0) || (this.jdField_a_of_type_Akqw == null)) {}
    label193:
    for (;;)
    {
      return;
      int i1 = this.mItemCount;
      int i = this.mOldSelectedPosition;
      int j = i - n;
      int k = i + n;
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = k;
      if (k >= i1) {
        j = i1 - 1;
      }
      k = paramInt - n;
      n += paramInt;
      paramInt = k;
      if (k < 0) {
        paramInt = 0;
      }
      k = n;
      if (n >= i1) {
        k = i1 - 1;
      }
      if ((paramInt > j) || (k < i))
      {
        paramInt = i;
        i = j;
      }
      for (;;)
      {
        if (paramInt >= i) {
          break label193;
        }
        while (paramInt <= i)
        {
          this.jdField_a_of_type_Akqw.onDestroyView(paramInt, null, this);
          paramInt += 1;
        }
        break;
        if (paramInt > i)
        {
          j = paramInt - 1;
          paramInt = i;
          i = j;
        }
        else if (k < j)
        {
          paramInt = k + 1;
          i = j;
        }
        else
        {
          paramInt = 0;
          i = m;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ProGallery
 * JD-Core Version:    0.7.0.1
 */