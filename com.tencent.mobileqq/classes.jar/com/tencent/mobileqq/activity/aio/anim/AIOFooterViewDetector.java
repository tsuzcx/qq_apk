package com.tencent.mobileqq.activity.aio.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.BaseChatPie;
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
  private View jdField_a_of_type_AndroidViewView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
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
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewView.setId(2131361978);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.jdField_a_of_type_AndroidViewView, null, false);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
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
      QLog.d("AIOFooterViewDetector", 2, "removeFooterView minHeight=" + this.b + ",listFooter=" + this.jdField_a_of_type_AndroidViewView + ",listView=" + this.jdField_a_of_type_ComTencentWidgetListView);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(Math.max(this.b, 0), false, "removeFooter");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    int j = 0;
    int i = 0;
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    label414:
    for (;;)
    {
      return;
      ListAdapter localListAdapter2 = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      ListAdapter localListAdapter1 = localListAdapter2;
      if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
        localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOFooterViewDetector", 2, "updateFooterView from=" + paramString + ",newHeight=" + paramInt + ",bAnim=" + paramBoolean + ",listFooter=" + this.jdField_a_of_type_AndroidViewView + ",listAdapter=" + localListAdapter1);
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_Int = paramInt;
        if (localListAdapter1 != null) {
          if (this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition() == localListAdapter1.getCount() - 1 + this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount())
          {
            this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
            a(paramInt);
            this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(localListAdapter1);
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label414;
        }
        paramString = (BaseChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (paramString == null) {
          break;
        }
        paramString.b(196608);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIOFooterViewDetector", 2, "updateFooterView refresh");
        return;
        int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        i = j;
        if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0)
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
          if (paramString != null) {
            break label307;
          }
        }
        label307:
        for (i = j;; i = paramString.getTop())
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
          a(paramInt);
          this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(localListAdapter1);
          this.jdField_a_of_type_ComTencentWidgetListView.setSelectionFromTop(k, i);
          break;
        }
        a(paramInt);
        paramInt = i;
        continue;
        paramInt = Math.max(this.b, paramInt);
        this.jdField_a_of_type_Int = paramInt;
        paramString = (AbsListView.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramString.height == paramInt) {
          break;
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { paramString.height, paramInt });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          paramInt = i;
        }
        else
        {
          paramString.height = paramInt;
          this.jdField_a_of_type_AndroidViewView.requestLayout();
          paramInt = i;
        }
      }
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
      if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
        this.jdField_a_of_type_ComTencentWidgetListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
      return;
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      paramValueAnimator.cancel();
    }
    AbsListView.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (AbsListView.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidViewView.requestLayout();
    } while (!QLog.isColorLevel());
    QLog.d("AIOFooterViewDetector", 2, "onAnimationUpdate, listFooter height=" + localLayoutParams.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector
 * JD-Core Version:    0.7.0.1
 */