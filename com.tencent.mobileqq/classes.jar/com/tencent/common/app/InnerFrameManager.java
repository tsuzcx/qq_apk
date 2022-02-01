package com.tencent.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewFlipper;
import com.tencent.common.app.business.BaseQQAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InnerFrameManager
  extends ViewFlipper
  implements ViewStub.OnInflateListener
{
  public Activity a = null;
  private BaseQQAppInterface b = null;
  private Set<InnerFrame> c = new HashSet();
  private boolean d = false;
  private Bundle e;
  
  public InnerFrameManager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerFrameManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new InnerFrame(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(paramContext, 0);
  }
  
  public void a()
  {
    this.d = true;
    ((InnerFrame)getChildAt(getDisplayedChild())).a();
  }
  
  public void a(int paramInt)
  {
    this.e = null;
    a(paramInt, true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.e = paramBundle;
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    paramInt += 1;
    if (getDisplayedChild() == paramInt) {
      return;
    }
    if (this.d) {
      ((InnerFrame)getChildAt(getDisplayedChild())).b();
    }
    ((InnerFrame)getChildAt(getDisplayedChild())).c();
    getChildAt(paramInt).setVisibility(0);
    if (paramBoolean)
    {
      if (getDisplayedChild() != 0) {
        if (getDisplayedChild() < paramInt)
        {
          setInAnimation(this.a, 2130772108);
          setOutAnimation(this.a, 2130772109);
        }
        else
        {
          setInAnimation(this.a, 2130772102);
          setOutAnimation(this.a, 2130772103);
        }
      }
    }
    else
    {
      setInAnimation(this.a, 2130772196);
      setOutAnimation(this.a, 2130772196);
    }
    setDisplayedChild(paramInt);
    ((InnerFrame)getChildAt(paramInt)).b(this.e);
    if (this.d) {
      ((InnerFrame)getChildAt(paramInt)).a();
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.a = paramActivity;
    int j = getChildCount();
    int i = 1;
    while (i < j)
    {
      ((ViewStub)getChildAt(i)).setOnInflateListener(this);
      i += 1;
    }
  }
  
  public void b()
  {
    this.d = false;
    ((InnerFrame)getChildAt(getDisplayedChild())).b();
  }
  
  public void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).d();
    }
  }
  
  public int getCurrentPage()
  {
    return getDisplayedChild() - 1;
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    paramViewStub = (InnerFrame)paramView;
    this.c.add(paramViewStub);
    paramViewStub.setActivity(this.a);
    paramViewStub.setInnerFrameManager(this);
    paramViewStub.setAppIntf(this.b);
    paramViewStub.a(this.e);
  }
  
  public void setAppIntf(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.b = paramBaseQQAppInterface;
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).setAppIntf(paramBaseQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.InnerFrameManager
 * JD-Core Version:    0.7.0.1
 */