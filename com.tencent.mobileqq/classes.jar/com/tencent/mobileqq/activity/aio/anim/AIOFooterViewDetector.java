package com.tencent.mobileqq.activity.aio.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import mqq.util.WeakReference;

public class AIOFooterViewDetector
  implements ValueAnimator.AnimatorUpdateListener
{
  int jdField_a_of_type_Int = -1;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private WeakReference<BaseChatPie> jdField_a_of_type_MqqUtilWeakReference;
  private int b;
  
  public AIOFooterViewDetector(Context paramContext, ListView paramListView, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131362465);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_AndroidWidgetFrameLayout, null, false);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public AIOFooterViewDetector a(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = 0;
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_AndroidUtilSparseIntArray;
    if (paramInt2 < 1) {}
    try
    {
      this.jdField_a_of_type_AndroidUtilSparseIntArray.delete(paramInt1);
      for (;;)
      {
        int m = this.jdField_a_of_type_AndroidUtilSparseIntArray.size();
        if (m <= 0) {
          break;
        }
        int i = 0;
        paramInt1 = k;
        for (;;)
        {
          j = paramInt1;
          if (i >= m) {
            break;
          }
          paramInt1 = Math.max(paramInt1, this.jdField_a_of_type_AndroidUtilSparseIntArray.valueAt(i));
          i += 1;
        }
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
      }
      this.b = j;
    }
    finally {}
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "setMinHeight newMinHeight=" + paramInt2 + ",minHeight=" + this.b);
    }
    return this;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "removeFooterView minHeight=" + this.b + ",listFooter=" + this.jdField_a_of_type_AndroidWidgetFrameLayout + ",listView=" + this.jdField_a_of_type_ComTencentWidgetListView);
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      a(Math.max(this.b, 0), false, "removeFooter", 0);
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
    Object localObject = localListAdapter;
    if ((localListAdapter instanceof HeaderViewListAdapter)) {
      localObject = ((HeaderViewListAdapter)localListAdapter).getWrappedAdapter();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "updateFooterView from=" + paramString + ",newHeight=" + paramInt1 + ",bAnim=" + paramBoolean + ",listFooter=" + this.jdField_a_of_type_AndroidWidgetFrameLayout + ",listAdapter=" + localObject);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (localObject != null) {
        if (this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition() == ((ListAdapter)localObject).getCount() - 1 + this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount())
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
          a(paramInt1);
          this.jdField_a_of_type_ComTencentWidgetListView.setAdapter((ListAdapter)localObject);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramString = (BaseChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (paramString != null)
        {
          paramString.g(196608);
          if (QLog.isColorLevel()) {
            QLog.d("AIOFooterViewDetector", 2, "updateFooterView refresh");
          }
        }
      }
      QLog.d("AIOFooterViewDetector", 2, "updateFooterView, footerHeight: " + this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
        if (paramString != null) {
          break label309;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
        a(paramInt1);
        this.jdField_a_of_type_ComTencentWidgetListView.setAdapter((ListAdapter)localObject);
        break;
        label309:
        paramString.getTop();
      }
      a(paramInt1);
      paramInt1 = 0;
      continue;
      paramInt1 = Math.max(this.b, paramInt1);
      this.jdField_a_of_type_Int = paramInt1;
      paramString = (AbsListView.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (paramString.height == paramInt1) {
        break;
      }
      localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if (paramInt2 > 0) {}
      for (long l = paramInt2;; l = 300L)
      {
        ((ValueAnimator)localObject).setDuration(l);
        if (!paramBoolean) {
          break label429;
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { paramString.height, paramInt1 });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        paramInt1 = 0;
        break;
      }
      label429:
      paramString.height = paramInt1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
      paramInt1 = 0;
    }
  }
  
  public void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, paramLayoutParams);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "onDestroy");
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.b = 0;
    synchronized (this.jdField_a_of_type_AndroidUtilSparseIntArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
      if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)) {
        this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      }
      return;
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      paramValueAnimator.cancel();
    }
    AbsListView.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (AbsListView.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    } while (!QLog.isColorLevel());
    QLog.d("AIOFooterViewDetector", 2, "onAnimationUpdate, listFooter height=" + localLayoutParams.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector
 * JD-Core Version:    0.7.0.1
 */