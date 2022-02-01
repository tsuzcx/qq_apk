package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.R.styleable;

public class Layer
  extends ConstraintHelper
{
  private static final String TAG = "Layer";
  private boolean mApplyElevationOnAttach;
  private boolean mApplyVisibilityOnAttach;
  protected float mComputedCenterX = (0.0F / 0.0F);
  protected float mComputedCenterY = (0.0F / 0.0F);
  protected float mComputedMaxX = (0.0F / 0.0F);
  protected float mComputedMaxY = (0.0F / 0.0F);
  protected float mComputedMinX = (0.0F / 0.0F);
  protected float mComputedMinY = (0.0F / 0.0F);
  ConstraintLayout mContainer;
  private float mGroupRotateAngle = (0.0F / 0.0F);
  boolean mNeedBounds = true;
  private float mRotationCenterX = (0.0F / 0.0F);
  private float mRotationCenterY = (0.0F / 0.0F);
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private float mShiftX = 0.0F;
  private float mShiftY = 0.0F;
  View[] mViews = null;
  
  public Layer(Context paramContext)
  {
    super(paramContext);
  }
  
  public Layer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Layer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void reCacheViews()
  {
    if (this.mContainer == null) {
      return;
    }
    if (this.mCount == 0) {
      return;
    }
    View[] arrayOfView = this.mViews;
    if ((arrayOfView == null) || (arrayOfView.length != this.mCount)) {
      this.mViews = new View[this.mCount];
    }
    int i = 0;
    while (i < this.mCount)
    {
      int j = this.mIds[i];
      this.mViews[i] = this.mContainer.getViewById(j);
      i += 1;
    }
  }
  
  private void transform()
  {
    if (this.mContainer == null) {
      return;
    }
    if (this.mViews == null) {
      reCacheViews();
    }
    calcCenters();
    double d = Math.toRadians(this.mGroupRotateAngle);
    float f1 = (float)Math.sin(d);
    float f2 = (float)Math.cos(d);
    float f3 = this.mScaleX;
    float f4 = this.mScaleY;
    float f5 = -f4;
    int i = 0;
    while (i < this.mCount)
    {
      View localView = this.mViews[i];
      int j = (localView.getLeft() + localView.getRight()) / 2;
      int k = (localView.getTop() + localView.getBottom()) / 2;
      float f6 = j - this.mComputedCenterX;
      float f7 = k - this.mComputedCenterY;
      float f8 = this.mShiftX;
      float f9 = this.mShiftY;
      localView.setTranslationX(f3 * f2 * f6 + f5 * f1 * f7 - f6 + f8);
      localView.setTranslationY(f6 * (f3 * f1) + f4 * f2 * f7 - f7 + f9);
      localView.setScaleY(this.mScaleY);
      localView.setScaleX(this.mScaleX);
      localView.setRotation(this.mGroupRotateAngle);
      i += 1;
    }
  }
  
  protected void calcCenters()
  {
    if (this.mContainer == null) {
      return;
    }
    if ((!this.mNeedBounds) && (!Float.isNaN(this.mComputedCenterX)) && (!Float.isNaN(this.mComputedCenterY))) {
      return;
    }
    if ((!Float.isNaN(this.mRotationCenterX)) && (!Float.isNaN(this.mRotationCenterY)))
    {
      this.mComputedCenterY = this.mRotationCenterY;
      this.mComputedCenterX = this.mRotationCenterX;
      return;
    }
    View[] arrayOfView = getViews(this.mContainer);
    int m = 0;
    int n = arrayOfView[0].getLeft();
    int k = arrayOfView[0].getTop();
    int j = arrayOfView[0].getRight();
    int i = arrayOfView[0].getBottom();
    while (m < this.mCount)
    {
      View localView = arrayOfView[m];
      n = Math.min(n, localView.getLeft());
      k = Math.min(k, localView.getTop());
      j = Math.max(j, localView.getRight());
      i = Math.max(i, localView.getBottom());
      m += 1;
    }
    this.mComputedMaxX = j;
    this.mComputedMaxY = i;
    this.mComputedMinX = n;
    this.mComputedMinY = k;
    if (Float.isNaN(this.mRotationCenterX)) {
      this.mComputedCenterX = ((n + j) / 2);
    } else {
      this.mComputedCenterX = this.mRotationCenterX;
    }
    if (Float.isNaN(this.mRotationCenterY))
    {
      this.mComputedCenterY = ((k + i) / 2);
      return;
    }
    this.mComputedCenterY = this.mRotationCenterY;
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    int i = 0;
    this.mUseViewMeasure = false;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_visibility) {
          this.mApplyVisibilityOnAttach = true;
        } else if (k == R.styleable.ConstraintLayout_Layout_android_elevation) {
          this.mApplyElevationOnAttach = true;
        }
        i += 1;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mContainer = ((ConstraintLayout)getParent());
    if ((this.mApplyVisibilityOnAttach) || (this.mApplyElevationOnAttach))
    {
      int j = getVisibility();
      float f;
      if (Build.VERSION.SDK_INT >= 21) {
        f = getElevation();
      } else {
        f = 0.0F;
      }
      int i = 0;
      while (i < this.mCount)
      {
        int k = this.mIds[i];
        View localView = this.mContainer.getViewById(k);
        if (localView != null)
        {
          if (this.mApplyVisibilityOnAttach) {
            localView.setVisibility(j);
          }
          if ((this.mApplyElevationOnAttach) && (f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
            localView.setTranslationZ(localView.getTranslationZ() + f);
          }
        }
        i += 1;
      }
    }
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    applyLayoutFeatures();
  }
  
  public void setPivotX(float paramFloat)
  {
    this.mRotationCenterX = paramFloat;
    transform();
  }
  
  public void setPivotY(float paramFloat)
  {
    this.mRotationCenterY = paramFloat;
    transform();
  }
  
  public void setRotation(float paramFloat)
  {
    this.mGroupRotateAngle = paramFloat;
    transform();
  }
  
  public void setScaleX(float paramFloat)
  {
    this.mScaleX = paramFloat;
    transform();
  }
  
  public void setScaleY(float paramFloat)
  {
    this.mScaleY = paramFloat;
    transform();
  }
  
  public void setTranslationX(float paramFloat)
  {
    this.mShiftX = paramFloat;
    transform();
  }
  
  public void setTranslationY(float paramFloat)
  {
    this.mShiftY = paramFloat;
    transform();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    applyLayoutFeatures();
  }
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout)
  {
    reCacheViews();
    this.mComputedCenterX = (0.0F / 0.0F);
    this.mComputedCenterY = (0.0F / 0.0F);
    paramConstraintLayout = ((ConstraintLayout.LayoutParams)getLayoutParams()).getConstraintWidget();
    paramConstraintLayout.setWidth(0);
    paramConstraintLayout.setHeight(0);
    calcCenters();
    layout((int)this.mComputedMinX - getPaddingLeft(), (int)this.mComputedMinY - getPaddingTop(), (int)this.mComputedMaxX + getPaddingRight(), (int)this.mComputedMaxY + getPaddingBottom());
    if (!Float.isNaN(this.mGroupRotateAngle)) {
      transform();
    }
  }
  
  public void updatePreDraw(ConstraintLayout paramConstraintLayout)
  {
    this.mContainer = paramConstraintLayout;
    float f = getRotation();
    if (f == 0.0F)
    {
      if (!Float.isNaN(this.mGroupRotateAngle)) {
        this.mGroupRotateAngle = f;
      }
    }
    else {
      this.mGroupRotateAngle = f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.helper.widget.Layer
 * JD-Core Version:    0.7.0.1
 */