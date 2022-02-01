package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class AccountDetailXListView
  extends XListView
  implements AbsListView.OnScrollListener, Runnable
{
  protected int a = 0;
  protected int b;
  protected int c = 0;
  protected TextView d;
  protected RelativeLayout e;
  protected ProgressBar f;
  public AccountDetailXListView.RefreshCallback g;
  public boolean h = true;
  protected boolean i;
  protected float j = 0.0F;
  protected float k = 0.0F;
  protected float l = 0.0F;
  protected int m = 0;
  protected float n = 0.0F;
  float o = 0.0F;
  private AccountDetailXListView.OnEndScrollListener p;
  private int q;
  private int r = 100;
  
  public AccountDetailXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.e;
    if (localRelativeLayout != null) {
      localRelativeLayout.setPadding(localRelativeLayout.getPaddingLeft(), 0, this.e.getPaddingRight(), paramInt);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    c();
    this.c = paramContext.getResources().getDisplayMetrics().heightPixels;
    setOnScrollListener(this);
  }
  
  private void c()
  {
    this.e = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131626022, this, false));
    this.f = ((ProgressBar)this.e.findViewById(2131440882));
    this.d = ((TextView)this.e.findViewById(2131440883));
    addFooterView(this.e, null, false);
    setFooterDividersEnabled(false);
  }
  
  private boolean d()
  {
    ListAdapter localListAdapter = getAdapter();
    boolean bool = false;
    if (localListAdapter == null) {
      return false;
    }
    if (getFooterViewsCount() <= 0) {
      return false;
    }
    if (getLastVisiblePosition() == getAdapter().getCount() - 1) {
      bool = true;
    }
    return bool;
  }
  
  private void e()
  {
    if ((d()) && (this.g != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadingMore");
      }
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      this.d.setText(2131886140);
      a(0);
      this.a = 1;
      this.g.startLoadMore(this);
    }
  }
  
  public void a()
  {
    this.g = null;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.e == null) {
        c();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.e);
      }
    }
    else if ((this.e != null) && (getFooterViewsCount() > 0))
    {
      removeFooterView(this.e);
    }
  }
  
  public void b()
  {
    if (this.e != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadMoreFail");
      }
      this.e.setVisibility(0);
      this.d.setText(2131886139);
      this.f.setVisibility(8);
      a(0);
      this.a = 0;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.e != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadMoreComplete hasMoreData = ");
        localStringBuilder.append(paramBoolean);
        QLog.d("AccountDetailXListView", 2, localStringBuilder.toString());
      }
      this.a = 0;
      if (!paramBoolean)
      {
        this.d.setText(2131886141);
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        this.h = false;
        return;
      }
      this.e.setVisibility(8);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.b < 0))
    {
      RelativeLayout localRelativeLayout = this.e;
      if (localRelativeLayout != null)
      {
        this.b = localRelativeLayout.getHeight();
        a(-this.b);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.h)) {
      e();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    this.k = paramMotionEvent.getY();
    float f1;
    if (i1 == 0)
    {
      this.m = ((int)paramMotionEvent.getY());
      f1 = this.k;
      this.j = f1;
      this.i = true;
      this.l = f1;
    }
    else if (i1 == 2)
    {
      this.m = ((int)(paramMotionEvent.getY() - this.m));
      if (Math.abs(this.k - this.j) < DisplayUtil.a(super.getContext(), 10.0F))
      {
        this.m = ((int)paramMotionEvent.getY());
        f1 = this.k;
        this.n = (f1 - this.l);
        this.l = f1;
      }
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      this.o = Math.abs(this.n);
      this.l = this.k;
      this.m = ((int)paramMotionEvent.getY());
      this.i = false;
      f1 = this.k;
      this.n = (f1 - this.l);
      this.l = f1;
      this.q = getScrollY();
      removeCallbacks(this);
      postDelayed(this, this.r);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void run()
  {
    int i1 = getScrollY();
    if (this.q - i1 == 0)
    {
      AccountDetailXListView.OnEndScrollListener localOnEndScrollListener = this.p;
      if (localOnEndScrollListener != null) {
        localOnEndScrollListener.a((int)this.o);
      }
    }
    else
    {
      this.q = getScrollY();
      postDelayed(this, this.r);
    }
  }
  
  public void setOnEndScrollListener(AccountDetailXListView.OnEndScrollListener paramOnEndScrollListener)
  {
    this.p = paramOnEndScrollListener;
  }
  
  public void setRefreshCallback(AccountDetailXListView.RefreshCallback paramRefreshCallback)
  {
    this.g = paramRefreshCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView
 * JD-Core Version:    0.7.0.1
 */