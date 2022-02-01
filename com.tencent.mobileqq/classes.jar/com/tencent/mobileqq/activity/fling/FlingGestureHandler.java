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
  private View a;
  public TopGestureLayout mTopLayout;
  
  public FlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private ViewGroup a(Activity paramActivity)
  {
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = paramActivity.getChildAt(0);
    if (FlingHelperUtils.utils.isDragFrameLayoutClass(localView)) {
      paramActivity = (ViewGroup)localView;
    }
    return paramActivity;
  }
  
  protected void a()
  {
    if (!a()) {
      return;
    }
    Object localObject3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject3 == null) {
      return;
    }
    Object localObject1 = a((Activity)localObject3);
    Object localObject2;
    if (this.mTopLayout == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject1).getChildAt(0);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
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
    if (!b())
    {
      localObject2 = this.mTopLayout;
      if ((localObject2 != null) && (((TopGestureLayout)localObject2).getParent() != null)) {
        ((ViewGroup)this.mTopLayout.getParent()).removeView(this.mTopLayout);
      }
      ((ViewGroup)localObject1).addView(this.mTopLayout);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if ((localObject1 != null) && (((View)localObject1).getParent() != null)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      try
      {
        this.mTopLayout.addView(this.jdField_a_of_type_AndroidViewView);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("FlingGestureHandler", 1, localException, new Object[0]);
      }
    }
  }
  
  protected void b()
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = a((Activity)localObject);
    if ((b()) && (this.mTopLayout.getParent().equals(localObject)))
    {
      ((ViewGroup)localObject).removeView(this.mTopLayout);
      if (this.jdField_a_of_type_AndroidViewView.getParent().equals(this.mTopLayout))
      {
        this.mTopLayout.removeView(this.jdField_a_of_type_AndroidViewView);
        ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  protected boolean b()
  {
    Object localObject = this.mTopLayout;
    if ((localObject != null) && (((TopGestureLayout)localObject).getParent() != null))
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((localObject != null) && (((View)localObject).getParent() == this.mTopLayout)) {
        return true;
      }
    }
    return false;
  }
  
  public void flingLToR()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null) {
      localActivity.onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void setTopLayout(TopGestureLayout paramTopGestureLayout)
  {
    if ((!a()) && (paramTopGestureLayout == null)) {
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null) {
      return;
    }
    if (b())
    {
      b();
      this.jdField_a_of_type_AndroidViewView = a(localActivity).getChildAt(0);
      this.mTopLayout = paramTopGestureLayout;
      paramTopGestureLayout.setOnFlingGesture(this);
      a();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a(localActivity).getChildAt(0);
    this.mTopLayout = paramTopGestureLayout;
    paramTopGestureLayout.setOnFlingGesture(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */