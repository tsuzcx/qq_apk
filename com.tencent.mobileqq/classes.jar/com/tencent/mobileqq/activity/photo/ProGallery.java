package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.RegionDrawableData;
import com.tencent.mobileqq.gallery.listener.IGalleryScaleListener;
import com.tencent.widget.Gallery;

public class ProGallery
  extends Gallery
{
  private OnProGalleryListener a;
  private ProGallery.OnProGalleryGestureListener b;
  private IGalleryScaleListener c;
  private int d = 1;
  
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
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    IGalleryScaleListener localIGalleryScaleListener = this.c;
    if (localIGalleryScaleListener != null) {
      localIGalleryScaleListener.a(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    IGalleryScaleListener localIGalleryScaleListener = this.c;
    if (localIGalleryScaleListener != null) {
      localIGalleryScaleListener.a(paramScaleGestureDetector);
    }
    return super.onScale(paramScaleGestureDetector);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    ProGallery.OnProGalleryGestureListener localOnProGalleryGestureListener = this.b;
    if (localOnProGalleryGestureListener != null) {
      localOnProGalleryGestureListener.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return bool;
  }
  
  protected void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    super.onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    OnProGalleryListener localOnProGalleryListener = this.a;
    if (localOnProGalleryListener != null) {
      localOnProGalleryListener.onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    }
  }
  
  protected void onSlotChanged(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    OnProGalleryListener localOnProGalleryListener = this.a;
    if (localOnProGalleryListener != null) {
      localOnProGalleryListener.onSlot(paramInt, paramView, paramViewGroup);
    }
  }
  
  protected void onViewCreated(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    int n = this.d;
    if (n != 0)
    {
      if (this.a == null) {
        return;
      }
      int m = this.mItemCount;
      int k = 0;
      int j = paramInt;
      int i = 0;
      while (i < n)
      {
        j -= 1;
        if (j < 0) {
          break;
        }
        this.a.onCreateView(j, null, paramViewGroup);
        i += 1;
      }
      j = paramInt;
      i = k;
      while (i < n)
      {
        j += 1;
        if (j >= m) {
          break;
        }
        this.a.onCreateView(j, null, paramViewGroup);
        i += 1;
      }
      if (!paramBoolean2) {
        return;
      }
      if (paramBoolean1)
      {
        paramInt = paramInt - n - 1;
        if (paramInt >= 0) {
          this.a.onDestroyView(paramInt, null, paramViewGroup);
        }
      }
      else
      {
        paramInt = paramInt + n + 1;
        if (paramInt < m) {
          this.a.onDestroyView(paramInt, null, paramViewGroup);
        }
      }
    }
  }
  
  protected void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    OnProGalleryListener localOnProGalleryListener = this.a;
    if (localOnProGalleryListener != null) {
      localOnProGalleryListener.onViewDetached(paramInt, paramView, paramViewGroup, paramBoolean);
    }
  }
  
  protected void onZoomBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    OnProGalleryListener localOnProGalleryListener = this.a;
    if (localOnProGalleryListener != null) {
      localOnProGalleryListener.onscaleBegin(paramInt, paramView, paramViewGroup);
    }
  }
  
  public void setGalleryScaleListener(IGalleryScaleListener paramIGalleryScaleListener)
  {
    this.c = paramIGalleryScaleListener;
  }
  
  public void setGestureListener(ProGallery.OnProGalleryGestureListener paramOnProGalleryGestureListener)
  {
    this.b = paramOnProGalleryGestureListener;
  }
  
  public void setOnNoBlankListener(OnProGalleryListener paramOnProGalleryListener)
  {
    if (paramOnProGalleryListener != this.a) {
      this.a = paramOnProGalleryListener;
    }
  }
  
  public void setSelection(int paramInt)
  {
    super.setSelection(paramInt);
    int m = this.d;
    if (m != 0)
    {
      if (this.a == null) {
        return;
      }
      int i1 = this.mItemCount;
      int i = this.mOldSelectedPosition;
      int j = i - m;
      int k = i + m;
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = k;
      if (k >= i1) {
        j = i1 - 1;
      }
      k = paramInt - m;
      paramInt += m;
      m = k;
      if (k < 0) {
        m = 0;
      }
      int n = paramInt;
      if (paramInt >= i1) {
        n = i1 - 1;
      }
      k = j;
      paramInt = i;
      if (m <= j) {
        if (n < i)
        {
          k = j;
          paramInt = i;
        }
        else if (m > i)
        {
          k = m - 1;
          paramInt = i;
        }
        else if (n < j)
        {
          paramInt = n + 1;
          k = j;
        }
        else
        {
          k = 0;
          paramInt = 0;
        }
      }
      if (paramInt < k) {
        while (paramInt <= k)
        {
          this.a.onDestroyView(paramInt, null, this);
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ProGallery
 * JD-Core Version:    0.7.0.1
 */