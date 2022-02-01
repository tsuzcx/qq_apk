package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
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
  private IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDetailTopGestureLayoutProxy$OnFlingListener;
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
    boolean bool2 = false;
    int m = arrayOfInt[0] + localRect.left;
    int n = localRect.width();
    int j = arrayOfInt[1] + localRect.top;
    int i1 = localRect.height();
    int k = this.jdField_a_of_type_Int;
    int i = j;
    if (k > 0)
    {
      i = j;
      if (j >= 0)
      {
        i = j;
        if (j <= k) {
          i = k;
        }
      }
    }
    boolean bool1 = bool2;
    if (m < paramFloat1)
    {
      bool1 = bool2;
      if (paramFloat1 < n + m)
      {
        bool1 = bool2;
        if (i < paramFloat2)
        {
          bool1 = bool2;
          if (paramFloat2 < i1 + j) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public GestureDetector.OnGestureListener a(Context paramContext, IPublicAccountDetailTopGestureLayoutProxy.OnFlingListener paramOnFlingListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDetailTopGestureLayoutProxy$OnFlingListener = paramOnFlingListener;
    this.gestureListener = new AccountDetailTopGestureLayout.PublicAccountTopGestureDetector(this, paramContext);
    return this.gestureListener;
  }
  
  public TopGestureLayout.OnGestureListener a()
  {
    return this.mOnFlingGesture;
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
  
  public boolean isInTwoFingerMode()
  {
    return super.isInTwoFingerMode();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((WeakReference)((Iterator)localObject).next()).get();
        if ((localView != null) && (localView.getVisibility() == 0) && (a(localView, f1, f2))) {
          return false;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDefaultDetector(GestureDetector paramGestureDetector)
  {
    this.defaultGestureDetector = paramGestureDetector;
  }
  
  public void setTitleHeight(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setTopGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mTopGestureDetector = paramGestureDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */