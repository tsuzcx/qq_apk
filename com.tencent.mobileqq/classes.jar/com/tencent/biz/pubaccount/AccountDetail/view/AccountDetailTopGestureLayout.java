package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccountDetailTopGestureLayout
  extends TopGestureLayout
{
  private int jdField_a_of_type_Int;
  private HashMap<Integer, WeakReference<View>> jdField_a_of_type_JavaUtilHashMap;
  
  public AccountDetailTopGestureLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    int k = arrayOfInt[0] + localRect.left;
    int m = localRect.width();
    int j = arrayOfInt[1] + localRect.top;
    int n = localRect.height();
    int i = j;
    if (this.jdField_a_of_type_Int > 0)
    {
      i = j;
      if (j >= 0)
      {
        i = j;
        if (j <= this.jdField_a_of_type_Int) {
          i = this.jdField_a_of_type_Int;
        }
      }
    }
    return (k < paramFloat1) && (paramFloat1 < m + k) && (i < paramFloat2) && (paramFloat2 < n + j);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)
    {
      Object localObject1 = new HashSet();
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        if (((WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(localInteger)).get() == null) {
          ((HashSet)localObject1).add(localInteger);
        }
      }
      if (((HashSet)localObject1).size() > 0)
      {
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Integer)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramView.hashCode()), new WeakReference(paramView));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0))
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)((WeakReference)localIterator.next()).get();
        if ((localView != null) && (localView.getVisibility() == 0) && (a(localView, f1, f2))) {
          return false;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setTitleHeight(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */