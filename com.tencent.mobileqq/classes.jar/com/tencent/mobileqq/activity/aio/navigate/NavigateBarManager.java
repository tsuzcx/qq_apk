package com.tencent.mobileqq.activity.aio.navigate;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class NavigateBarManager
  implements Handler.Callback
{
  private static int[] l = { 2131442214, 2131442214 };
  private QQAppInterface a;
  private Context b;
  private SessionInfo c;
  private BaseChatPie d;
  private RelativeLayout e;
  private HashMap<Integer, NavigateBar> f;
  private NavigateBar g;
  private Animation h;
  private Animation i;
  private Handler j;
  private RelativeLayout k;
  private int m = 18;
  private Animation.AnimationListener n = new NavigateBarManager.1(this);
  private Animation.AnimationListener o = new NavigateBarManager.2(this);
  private View.OnClickListener p = new NavigateBarManager.3(this);
  private View.OnTouchListener q = new NavigateBarManager.4(this);
  
  public NavigateBarManager(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.d = paramBaseChatPie;
    this.c = paramSessionInfo;
    this.e = paramRelativeLayout;
    this.f = new HashMap();
    this.j = new Handler(this);
  }
  
  private void a(NavigateBar paramNavigateBar)
  {
    if (paramNavigateBar == null)
    {
      QLog.d("NavigateBarManager", 1, "show navigate bar, navigateBar == null");
      return;
    }
    this.g = paramNavigateBar;
    Object localObject1 = paramNavigateBar.a();
    if (localObject1 != null)
    {
      Object localObject2 = ((View)localObject1).getParent();
      if ((localObject2 instanceof ViewGroup)) {
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      if (this.k == null)
      {
        this.k = new RelativeLayout(this.b);
        this.k.setMinimumHeight(ViewUtils.dpToPx(45.0F));
        this.k.setOnClickListener(this.p);
        this.k.setOnTouchListener(this.q);
        this.k.setVisibility(8);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        int i1 = c();
        if (i1 != -1) {
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, i1);
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(this.m);
        this.e.addView(this.k, (ViewGroup.LayoutParams)localObject2);
      }
      if (this.h == null)
      {
        this.h = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        this.h.setDuration(500L);
        this.h.setAnimationListener(this.n);
      }
      if (this.i == null)
      {
        this.i = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
        this.i.setDuration(500L);
        this.i.setAnimationListener(this.o);
      }
      this.k.removeAllViews();
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      this.k.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.k.clearAnimation();
      this.k.startAnimation(this.h);
      this.k.setVisibility(0);
      this.j.removeMessages(1);
      if (paramNavigateBar.g() > 0L)
      {
        localObject1 = this.j.obtainMessage(1);
        ((Message)localObject1).arg1 = paramNavigateBar.e;
        this.j.sendMessageDelayed((Message)localObject1, paramNavigateBar.g());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("show navigate bar: %s", new Object[] { paramNavigateBar }));
    }
  }
  
  private int c()
  {
    Object localObject1 = null;
    int i1 = 0;
    for (;;)
    {
      Object localObject2 = l;
      if (i1 >= localObject2.length) {
        break;
      }
      View localView = this.e.findViewById(localObject2[i1]);
      localObject2 = localObject1;
      if (localView != null) {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (localView.getBottom() <= localObject1.getBottom()) {}
        }
        else
        {
          localObject2 = localView;
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return localObject1.getId();
    }
    return -1;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("hide navigate bar: %s", new Object[] { this.g }));
    }
    Object localObject = this.k;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0))
    {
      this.k.clearAnimation();
      this.k.startAnimation(this.i);
    }
    localObject = this.g;
    if (localObject != null)
    {
      b(((NavigateBar)localObject).e);
      this.g = null;
    }
  }
  
  public void a()
  {
    this.f.entrySet();
    Iterator localIterator = this.f.entrySet().iterator();
    label23:
    NavigateBar localNavigateBar;
    for (Object localObject = null; localIterator.hasNext(); localObject = localNavigateBar)
    {
      localNavigateBar = (NavigateBar)((Map.Entry)localIterator.next()).getValue();
      if ((localObject != null) && (localNavigateBar.f <= localObject.f)) {
        break label23;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("refresh navigate bar: %s", new Object[] { localObject }));
    }
    if (localObject != null) {
      a(localObject);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 5))
    {
      Object localObject;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              localObject = null;
            } else {
              localObject = new TroopAppShortcutHasNewAppNavBar(this.d, this.a, this.b, this.c, paramInt, 4);
            }
          }
          else {
            localObject = new TroopAppShortcutNavBar(this.d, this.a, this.b, this.c, paramInt, 4);
          }
        }
        else {
          localObject = new TroopDNANavBar(this.d, this.a, this.b, this.c, paramInt, 4);
        }
      }
      else {
        localObject = new IntimateInfoNavBar(this.d, this.a, this.b, this.c, paramInt, 4);
      }
      if (localObject != null)
      {
        boolean bool = ((NavigateBar)localObject).c();
        if (bool) {
          this.f.put(Integer.valueOf(((NavigateBar)localObject).e), localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("NavigateBarManager", 2, String.format("addTask, barId: %s, needShow: %s", new Object[] { Integer.valueOf(((NavigateBar)localObject).e), Boolean.valueOf(bool) }));
        }
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).removeAllViews();
      this.k.setVisibility(8);
      if (this.e.indexOfChild(this.k) != -1) {
        this.e.removeView(this.k);
      }
      this.k = null;
      localObject = this.g;
      if (localObject != null) {
        ((NavigateBar)localObject).f();
      }
      this.g = null;
    }
    localObject = this.f;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, "onDestroy");
    }
  }
  
  public void b(int paramInt)
  {
    this.f.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("removeTask, barId: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void d(int paramInt)
  {
    NavigateBar localNavigateBar = this.g;
    if ((localNavigateBar != null) && (localNavigateBar.e == paramInt)) {
      d();
    } else {
      b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("hide navigate bar id: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      int i1 = paramMessage.arg1;
      paramMessage = this.g;
      if ((paramMessage != null) && (i1 == paramMessage.e))
      {
        d();
      }
      else
      {
        paramMessage = new StringBuilder();
        paramMessage.append("hide bar msg but not found, barId: ");
        paramMessage.append(i1);
        QLog.d("NavigateBarManager", 1, paramMessage.toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager
 * JD-Core Version:    0.7.0.1
 */