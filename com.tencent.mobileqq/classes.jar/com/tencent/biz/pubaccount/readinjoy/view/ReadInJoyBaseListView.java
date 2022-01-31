package com.tencent.biz.pubaccount.readinjoy.view;

import actn;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bfob;
import bfsy;
import bhvh;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import rap;
import rbx;
import rby;
import rbz;
import rca;
import rcb;
import shx;

public abstract class ReadInJoyBaseListView
  extends XListView
  implements bfob
{
  protected int a;
  private View jdField_a_of_type_AndroidViewView;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  private ArrayList<bfsy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  rby jdField_a_of_type_Rby = new rby();
  private rbz jdField_a_of_type_Rbz;
  protected rca a;
  private rcb jdField_a_of_type_Rcb;
  protected boolean a;
  protected int b;
  public boolean b;
  public int c;
  protected boolean c;
  public int d;
  private boolean d;
  
  public ReadInJoyBaseListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  private boolean a()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), paramInt);
    }
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, actn.a(62.0F, getResources())));
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131718462);
    localTextView.setTextColor(-4473925);
    localTextView.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(0, 12, 0, 12);
    localTextView.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localTextView);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560103, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372152));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372153));
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramInt == 4) {
          break;
        }
      } while ((!a()) || (this.jdField_a_of_type_Rca == null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699649);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      b(0);
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_Rca.b(this, paramInt);
      return;
      if (a())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699649);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        b(0);
      }
    } while (this.jdField_a_of_type_Rca == null);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Rca.b(this, paramInt);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyXListView);
    this.jdField_d_of_type_Boolean = paramContext.getBoolean(0, false);
    paramContext.recycle();
    if (this.jdField_d_of_type_Boolean) {
      a();
    }
    if (shx.a(this.jdField_d_of_type_Int)) {
      c();
    }
    super.setOnScrollListener(this.jdField_a_of_type_Rby);
    a(this);
  }
  
  public void a(bfob parambfob)
  {
    if (this.jdField_a_of_type_Rby != null) {
      this.jdField_a_of_type_Rby.a(parambfob);
    }
  }
  
  public void a(bfsy parambfsy)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambfsy);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean);
    }
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699648);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      b(-this.jdField_a_of_type_Int);
    }
    setFooterView(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, new Object[] { "loadingMoreComplete mCurrentStatus = ", Integer.valueOf(this.jdField_c_of_type_Int), ", hasMoreData = ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rby != null) {
      this.jdField_a_of_type_Rby.a();
    }
  }
  
  public void b(bfob parambfob)
  {
    if (this.jdField_a_of_type_Rby != null) {
      this.jdField_a_of_type_Rby.b(parambfob);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Rbz != null)
    {
      this.jdField_a_of_type_Rbz.a(this);
      if (this.jdField_a_of_type_Rcb != null) {
        this.jdField_a_of_type_Rcb.a();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_a_of_type_Int < 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      b(-this.jdField_a_of_type_Int);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_Int < 0) && (this.jdField_c_of_type_Int != 1) && (paramInt1 >= paramInt3 - paramInt2 * 2) && ((!shx.a(this.jdField_d_of_type_Int)) || (!this.jdField_b_of_type_Boolean))) {
      a(2);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bfsy)localIterator.next()).a(this.mFirstPosition, getChildCount(), this.mItemCount);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof rap))) {
      ((rap)paramListAdapter).a(new rbx(this));
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (shx.a(this.jdField_d_of_type_Int))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        removeFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        a();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    do
    {
      return;
      if (shx.a(this.jdField_d_of_type_Int))
      {
        removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.jdField_a_of_type_AndroidViewView);
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        a();
      }
      if ((bhvh.i()) && ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 56)))
      {
        QLog.d("ReadInJoyBaseListView", 1, "independent kd recommend and video channel, keep footer view.");
        return;
      }
    } while (getFooterViewsCount() <= 0);
    removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void setNeedShowFootView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void setNoMoreData(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (!this.jdField_b_of_type_Boolean) {
        break label74;
      }
      if (shx.a(this.jdField_d_of_type_Int))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    label74:
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    removeFooterView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void setOnDrawCompleteListener(rbz paramrbz)
  {
    this.jdField_a_of_type_Rbz = paramrbz;
  }
  
  public final void setOnScrollListener(bfob parambfob)
  {
    throw new RuntimeException("use addScrollListener  or removeScrollListener，better call addScrollListener in ReadInJoyBaseAdapter.onAddScrollListeners for control the call sequence");
  }
  
  public void setRefreshCallback(rca paramrca)
  {
    this.jdField_a_of_type_Rca = paramrca;
  }
  
  public void setScrollEventCallback(rcb paramrcb)
  {
    this.jdField_a_of_type_Rcb = paramrcb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView
 * JD-Core Version:    0.7.0.1
 */