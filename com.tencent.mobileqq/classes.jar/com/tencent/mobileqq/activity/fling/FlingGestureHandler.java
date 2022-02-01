package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FlingGestureHandler
  extends FlingHandler
  implements TopGestureLayout.OnGestureListener
{
  private View mInnerView;
  public TopGestureLayout mTopLayout;
  
  public FlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private ViewGroup getDecorView(Activity paramActivity)
  {
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = paramActivity.getChildAt(0);
    if (FlingHelperUtils.utils.isDragFrameLayoutClass(localView)) {
      paramActivity = (ViewGroup)localView;
    }
    return paramActivity;
  }
  
  public void flingLToR()
  {
    Activity localActivity = (Activity)this.mWrappedActivity.get();
    if (localActivity != null) {
      localActivity.onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  protected boolean isWrapped()
  {
    Object localObject = this.mTopLayout;
    if ((localObject != null) && (((TopGestureLayout)localObject).getParent() != null))
    {
      localObject = this.mInnerView;
      if ((localObject != null) && (((View)localObject).getParent() == this.mTopLayout)) {
        return true;
      }
    }
    return false;
  }
  
  public void setTopLayout(TopGestureLayout paramTopGestureLayout)
  {
    if ((!canWrapContent()) && (paramTopGestureLayout == null)) {
      return;
    }
    Activity localActivity = (Activity)this.mWrappedActivity.get();
    if (localActivity == null) {
      return;
    }
    if (isWrapped())
    {
      unwrap();
      this.mInnerView = getDecorView(localActivity).getChildAt(0);
      this.mTopLayout = paramTopGestureLayout;
      paramTopGestureLayout.setOnFlingGesture(this);
      wrap();
      return;
    }
    this.mInnerView = getDecorView(localActivity).getChildAt(0);
    this.mTopLayout = paramTopGestureLayout;
    paramTopGestureLayout.setOnFlingGesture(this);
  }
  
  protected void unwrap()
  {
    Object localObject = (Activity)this.mWrappedActivity.get();
    if (localObject == null) {
      return;
    }
    localObject = getDecorView((Activity)localObject);
    if ((isWrapped()) && (this.mTopLayout.getParent().equals(localObject)))
    {
      ((ViewGroup)localObject).removeView(this.mTopLayout);
      if (this.mInnerView.getParent().equals(this.mTopLayout))
      {
        this.mTopLayout.removeView(this.mInnerView);
        ((ViewGroup)localObject).addView(this.mInnerView);
      }
    }
  }
  
  protected void wrap()
  {
    if (!canWrapContent()) {
      return;
    }
    Object localObject3 = (Activity)this.mWrappedActivity.get();
    if (localObject3 == null) {
      return;
    }
    Object localObject1 = getDecorView((Activity)localObject3);
    Object localObject2;
    if (this.mTopLayout == null)
    {
      this.mInnerView = ((ViewGroup)localObject1).getChildAt(0);
      localObject2 = this.mInnerView;
      if (localObject2 == null) {
        return;
      }
      this.mTopLayout = new TopGestureLayout((Context)localObject3);
      localObject3 = this.mTopLayout;
      ((TopGestureLayout)localObject3).setOnFlingGesture(this);
      ((ViewGroup)localObject1).addView((View)localObject3);
      ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
      ((TopGestureLayout)localObject3).addView((View)localObject2);
      return;
    }
    if (!isWrapped())
    {
      localObject2 = this.mTopLayout;
      if ((localObject2 != null) && (((TopGestureLayout)localObject2).getParent() != null)) {
        ((ViewGroup)this.mTopLayout.getParent()).removeView(this.mTopLayout);
      }
      ((ViewGroup)localObject1).addView(this.mTopLayout);
      localObject1 = this.mInnerView;
      if ((localObject1 != null) && (((View)localObject1).getParent() != null)) {
        ((ViewGroup)this.mInnerView.getParent()).removeView(this.mInnerView);
      }
      try
      {
        this.mTopLayout.addView(this.mInnerView);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("FlingGestureHandler", 1, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */