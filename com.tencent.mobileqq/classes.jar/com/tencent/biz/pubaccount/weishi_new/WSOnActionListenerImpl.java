package com.tencent.biz.pubaccount.weishi_new;

import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout.OnActionListener;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;

public class WSOnActionListenerImpl
  implements WSFeedsLinearLayout.OnActionListener
{
  private boolean a = false;
  private boolean b = false;
  private int c;
  private int d;
  private final WSRecommendFragment e;
  private final WSTabLayout f;
  
  public WSOnActionListenerImpl(WSRecommendFragment paramWSRecommendFragment, WSTabLayout paramWSTabLayout)
  {
    this.e = paramWSRecommendFragment;
    this.f = paramWSTabLayout;
  }
  
  private boolean a()
  {
    return this.e.n() == 1;
  }
  
  private void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSOnActionListenerImpl.java][actionUp] moveState:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mScrollingTopMargin:");
    localStringBuilder.append(this.d);
    WSLog.e("WSOnActionListenerImpl", localStringBuilder.toString());
    this.a = false;
    this.b = false;
    if (paramInt == 1)
    {
      this.f.b(true);
      this.e.e(false);
      return;
    }
    if (paramInt == 2)
    {
      this.f.a(true);
      this.e.e(true);
    }
  }
  
  private void d(int paramInt)
  {
    this.a = false;
    Object localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    if (!this.b)
    {
      this.b = true;
      this.c = ((LinearLayout.LayoutParams)localObject).topMargin;
      this.e.e(false);
      WSLog.b("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveDown] switchMoveDown!! ViewPager Cannot Scroll!!");
    }
    int i = ((LinearLayout.LayoutParams)localObject).topMargin;
    if (i == 0)
    {
      WSLog.g("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveDown] currentTopMargin:0, doNothing!!");
      return;
    }
    this.d = Math.min(-paramInt + this.c, 0);
    ((LinearLayout.LayoutParams)localObject).topMargin = this.d;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSOnActionListenerImpl.java][handleActionMoveDown] topMargin:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", currentTopMargin:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", dy:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.e("WSOnActionListenerImpl", ((StringBuilder)localObject).toString());
  }
  
  private void e(int paramInt)
  {
    this.b = false;
    Object localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    if (!this.a)
    {
      this.a = true;
      this.c = ((LinearLayout.LayoutParams)localObject).topMargin;
      this.e.e(false);
      WSLog.b("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveUp] switchMoveUp!! ViewPager Cannot Scroll!!");
    }
    int j = WeishiUIUtil.p;
    int i = ((LinearLayout.LayoutParams)localObject).topMargin;
    j = -j;
    if (i == j)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSOnActionListenerImpl.java][handleActionMoveUp] currentTopMargin:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", doNothing!!");
      WSLog.g("WSOnActionListenerImpl", ((StringBuilder)localObject).toString());
      return;
    }
    this.d = Math.max(-paramInt + this.c, j);
    ((LinearLayout.LayoutParams)localObject).topMargin = this.d;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSOnActionListenerImpl.java][handleActionMoveUp] topMargin:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", currentTopMargin:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", dy:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.e("WSOnActionListenerImpl", ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt)
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSOnActionListenerImpl.java][actionMoveUp] viewPager is dragging!! dy:");
      localStringBuilder.append(paramInt);
      WSLog.g("WSOnActionListenerImpl", localStringBuilder.toString());
      return;
    }
    e(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSOnActionListenerImpl.java][actionUp] viewPager is dragging!! dy:");
      localStringBuilder.append(paramInt2);
      WSLog.g("WSOnActionListenerImpl", localStringBuilder.toString());
      return;
    }
    c(paramInt1);
  }
  
  public void b(int paramInt)
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSOnActionListenerImpl.java][actionMoveDown] viewPager is dragging!! dy:");
      localStringBuilder.append(paramInt);
      WSLog.g("WSOnActionListenerImpl", localStringBuilder.toString());
      return;
    }
    d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSOnActionListenerImpl
 * JD-Core Version:    0.7.0.1
 */