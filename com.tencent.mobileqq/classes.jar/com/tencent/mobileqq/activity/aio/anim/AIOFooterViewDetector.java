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
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131362421);
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
    Object localObject1 = this.jdField_a_of_type_AndroidUtilSparseIntArray;
    if (paramInt2 < 1) {}
    try
    {
      this.jdField_a_of_type_AndroidUtilSparseIntArray.delete(paramInt1);
      break label34;
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
      label34:
      int j = this.jdField_a_of_type_AndroidUtilSparseIntArray.size();
      paramInt1 = 0;
      int i = 0;
      if (j > 0)
      {
        paramInt1 = 0;
        while (i < j)
        {
          paramInt1 = Math.max(paramInt1, this.jdField_a_of_type_AndroidUtilSparseIntArray.valueAt(i));
          i += 1;
        }
      }
      this.b = paramInt1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setMinHeight newMinHeight=");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(",minHeight=");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("AIOFooterViewDetector", 2, ((StringBuilder)localObject1).toString());
      }
      return this;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFooterView minHeight=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",listFooter=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      localStringBuilder.append(",listView=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetListView);
      QLog.d("AIOFooterViewDetector", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      a(Math.max(this.b, 0), false, "removeFooter", 0);
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((ListView)localObject1).getAdapter();
    localObject1 = localObject2;
    if ((localObject2 instanceof HeaderViewListAdapter)) {
      localObject1 = ((HeaderViewListAdapter)localObject2).getWrappedAdapter();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateFooterView from=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",newHeight=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(",bAnim=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(",listFooter=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      ((StringBuilder)localObject2).append(",listAdapter=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("AIOFooterViewDetector", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    paramString = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    int i = 1;
    if (paramString == null)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition() == ((ListAdapter)localObject1).getCount() - 1 + this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount())
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
          a(paramInt1);
          this.jdField_a_of_type_ComTencentWidgetListView.setAdapter((ListAdapter)localObject1);
          paramInt1 = i;
          break label420;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0)
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
          if (paramString != null) {
            paramString.getTop();
          }
        }
        this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
        a(paramInt1);
        this.jdField_a_of_type_ComTencentWidgetListView.setAdapter((ListAdapter)localObject1);
        paramInt1 = i;
        break label420;
      }
      a(paramInt1);
    }
    else
    {
      paramInt1 = Math.max(this.b, paramInt1);
      this.jdField_a_of_type_Int = paramInt1;
      paramString = (AbsListView.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (paramString.height == paramInt1) {
        return;
      }
      localObject1 = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      long l;
      if (paramInt2 > 0) {
        l = paramInt2;
      } else {
        l = 300L;
      }
      ((ValueAnimator)localObject1).setDuration(l);
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { paramString.height, paramInt1 });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      else
      {
        paramString.height = paramInt1;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
      }
    }
    paramInt1 = 0;
    label420:
    if (paramInt1 != 0)
    {
      paramString = (BaseChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramString != null)
      {
        paramString.e(196608);
        if (QLog.isColorLevel()) {
          QLog.d("AIOFooterViewDetector", 2, "updateFooterView refresh");
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("updateFooterView, footerHeight: ");
    paramString.append(this.jdField_a_of_type_Int);
    QLog.d("AIOFooterViewDetector", 2, paramString.toString());
  }
  
  public void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null) {
      localFrameLayout.addView(paramView, paramLayoutParams);
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
      ??? = this.jdField_a_of_type_ComTencentWidgetListView;
      if (??? != null)
      {
        FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
        if (localFrameLayout != null) {
          ((ListView)???).removeFooterView(localFrameLayout);
        }
      }
      ??? = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (??? != null)
      {
        ((FrameLayout)???).removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      }
      return;
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject == null)
    {
      paramValueAnimator.cancel();
      return;
    }
    localObject = (AbsListView.LayoutParams)((FrameLayout)localObject).getLayoutParams();
    ((AbsListView.LayoutParams)localObject).height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("onAnimationUpdate, listFooter height=");
      paramValueAnimator.append(((AbsListView.LayoutParams)localObject).height);
      QLog.d("AIOFooterViewDetector", 2, paramValueAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector
 * JD-Core Version:    0.7.0.1
 */