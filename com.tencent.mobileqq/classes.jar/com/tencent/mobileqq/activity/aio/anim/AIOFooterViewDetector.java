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
  int a = -1;
  private FrameLayout b;
  private int c;
  private Context d;
  private ListView e;
  private WeakReference<BaseChatPie> f;
  private ValueAnimator g;
  private SparseIntArray h = new SparseIntArray();
  
  public AIOFooterViewDetector(Context paramContext, ListView paramListView, BaseChatPie paramBaseChatPie)
  {
    this.d = paramContext;
    this.e = paramListView;
    this.f = new WeakReference(paramBaseChatPie);
    this.g = new ValueAnimator();
    this.g.addUpdateListener(this);
    this.g.setDuration(300L);
  }
  
  private void a(int paramInt)
  {
    if (this.b == null)
    {
      this.b = new FrameLayout(this.d);
      this.b.setId(2131428029);
      this.b.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
      this.e.addFooterView(this.b, null, false);
    }
  }
  
  public View a()
  {
    return this.b;
  }
  
  public AIOFooterViewDetector a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.h;
    if (paramInt2 < 1) {}
    try
    {
      this.h.delete(paramInt1);
      break label34;
      this.h.put(paramInt1, paramInt2);
      label34:
      int j = this.h.size();
      paramInt1 = 0;
      int i = 0;
      if (j > 0)
      {
        paramInt1 = 0;
        while (i < j)
        {
          paramInt1 = Math.max(paramInt1, this.h.valueAt(i));
          i += 1;
        }
      }
      this.c = paramInt1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setMinHeight newMinHeight=");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(",minHeight=");
        ((StringBuilder)localObject1).append(this.c);
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
  
  public void a(int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    Object localObject1 = this.e;
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
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(",listAdapter=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("AIOFooterViewDetector", 2, ((StringBuilder)localObject2).toString());
    }
    this.g.cancel();
    paramString = this.b;
    int i = 1;
    if (paramString == null)
    {
      this.a = paramInt1;
      if (localObject1 != null)
      {
        if (this.e.getLastVisiblePosition() == ((ListAdapter)localObject1).getCount() - 1 + this.e.getFooterViewsCount())
        {
          this.e.setAdapter(null);
          a(paramInt1);
          this.e.setAdapter((ListAdapter)localObject1);
          paramInt1 = i;
          break label420;
        }
        this.e.getFirstVisiblePosition();
        if (this.e.getChildCount() > 0)
        {
          paramString = this.e.getChildAt(0);
          if (paramString != null) {
            paramString.getTop();
          }
        }
        this.e.setAdapter(null);
        a(paramInt1);
        this.e.setAdapter((ListAdapter)localObject1);
        paramInt1 = i;
        break label420;
      }
      a(paramInt1);
    }
    else
    {
      paramInt1 = Math.max(this.c, paramInt1);
      this.a = paramInt1;
      paramString = (AbsListView.LayoutParams)this.b.getLayoutParams();
      if (paramString.height == paramInt1) {
        return;
      }
      localObject1 = this.g;
      long l;
      if (paramInt2 > 0) {
        l = paramInt2;
      } else {
        l = 300L;
      }
      ((ValueAnimator)localObject1).setDuration(l);
      if (paramBoolean)
      {
        this.g.setIntValues(new int[] { paramString.height, paramInt1 });
        this.g.start();
      }
      else
      {
        paramString.height = paramInt1;
        this.b.requestLayout();
      }
    }
    paramInt1 = 0;
    label420:
    if (paramInt1 != 0)
    {
      paramString = (BaseChatPie)this.f.get();
      if (paramString != null)
      {
        paramString.j(196608);
        if (QLog.isColorLevel()) {
          QLog.d("AIOFooterViewDetector", 2, "updateFooterView refresh");
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("updateFooterView, footerHeight: ");
    paramString.append(this.a);
    QLog.d("AIOFooterViewDetector", 2, paramString.toString());
  }
  
  public void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = this.b;
    if (localFrameLayout != null) {
      localFrameLayout.addView(paramView, paramLayoutParams);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFooterView minHeight=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",listFooter=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",listView=");
      localStringBuilder.append(this.e);
      QLog.d("AIOFooterViewDetector", 2, localStringBuilder.toString());
    }
    if (this.b != null) {
      a(Math.max(this.c, 0), false, "removeFooter", 0);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "onDestroy");
    }
    this.g.cancel();
    this.c = 0;
    synchronized (this.h)
    {
      this.h.clear();
      ??? = this.e;
      if (??? != null)
      {
        FrameLayout localFrameLayout = this.b;
        if (localFrameLayout != null) {
          ((ListView)???).removeFooterView(localFrameLayout);
        }
      }
      ??? = this.b;
      if (??? != null)
      {
        ((FrameLayout)???).removeAllViews();
        this.b = null;
      }
      return;
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      paramValueAnimator.cancel();
      return;
    }
    localObject = (AbsListView.LayoutParams)((FrameLayout)localObject).getLayoutParams();
    ((AbsListView.LayoutParams)localObject).height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.requestLayout();
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("onAnimationUpdate, listFooter height=");
      paramValueAnimator.append(((AbsListView.LayoutParams)localObject).height);
      QLog.d("AIOFooterViewDetector", 2, paramValueAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector
 * JD-Core Version:    0.7.0.1
 */