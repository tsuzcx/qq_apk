package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

@SuppressLint({"ViewConstructor"})
public class BaseActivityView
  extends FrameLayout
{
  protected QQAppInterface a;
  BaseActivity b;
  protected int c;
  QQProgressDialog d;
  protected IPhoneContactService e;
  protected ImageView f;
  protected TextView g;
  protected TextView h;
  protected TextView i;
  protected View j;
  protected View k;
  private TextView l;
  private View m;
  private PhoneInnerFrame n;
  private BaseActivityView.UiHandler o;
  private Drawable p;
  private boolean q;
  
  public BaseActivityView(Context paramContext, int paramInt)
  {
    super(paramContext);
    if ((paramContext instanceof BaseActivity)) {
      this.b = ((BaseActivity)paramContext);
    }
    this.c = paramInt;
  }
  
  private int getTitleBarHeight()
  {
    return this.j.getHeight();
  }
  
  private void setViews(BaseActivityView.IPhoneContext paramIPhoneContext)
  {
    this.i = paramIPhoneContext.b();
    this.l = paramIPhoneContext.h();
    this.j = paramIPhoneContext.f();
    this.k = paramIPhoneContext.g();
    this.f = paramIPhoneContext.c();
    this.g = paramIPhoneContext.d();
    this.h = paramIPhoneContext.e();
  }
  
  protected View a(int paramInt)
  {
    View localView = this.m;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return findViewById(paramInt);
  }
  
  protected void a()
  {
    this.i.setVisibility(8);
    this.l.setVisibility(0);
    int i1 = this.c;
    if (i1 == 2)
    {
      this.g.setVisibility(0);
      this.g.setText(2131887648);
      this.g.setContentDescription(HardCodeUtil.a(2131899172));
      this.f.setVisibility(8);
    }
    else if (i1 != 1)
    {
      if (i1 == 0)
      {
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        this.f.setImageResource(2130841188);
      }
      else if (i1 == 5)
      {
        this.g.setVisibility(8);
        this.f.setVisibility(8);
      }
      else
      {
        this.f.setVisibility(8);
        this.g.setVisibility(8);
      }
    }
    this.l.setOnClickListener(new BaseActivityView.1(this));
    this.q = false;
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    this.n.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(int paramInt, long paramLong)
  {
    if (!f())
    {
      b(paramInt);
      this.o.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  protected void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Message localMessage = this.o.obtainMessage(1, paramInt, paramBoolean ^ true);
    this.o.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected final void a(int paramInt, boolean paramBoolean)
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (paramBoolean)
    {
      BounceScrollView localBounceScrollView = (BounceScrollView)localLayoutInflater.inflate(2131624339, null);
      this.m = localLayoutInflater.inflate(paramInt, null);
      localBounceScrollView.addView(this.m);
      addView(localBounceScrollView);
      return;
    }
    localLayoutInflater.inflate(paramInt, this, true);
  }
  
  protected final void a(Intent paramIntent)
  {
    a(paramIntent, 0);
  }
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    this.n.a(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    this.o = new BaseActivityView.UiHandler(this);
    this.n = paramPhoneInnerFrame;
    paramIntent = paramPhoneInnerFrame.getPhoneContext();
    this.a = paramIntent.a();
    this.e = ((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class));
    setViews(paramIntent);
  }
  
  protected void a(String paramString)
  {
    if (!f()) {
      QQToast.makeText(getContext(), 0, paramString, 0).show(getTitleBarHeight());
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (!f()) {
      DialogUtil.a(getContext(), 231, paramString1, paramString2, new BaseActivityView.2(this), null).show();
    }
  }
  
  protected void b() {}
  
  protected void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  void b(int paramInt, boolean paramBoolean)
  {
    if ((!f()) && (this.d == null))
    {
      this.d = new QQProgressDialog(getContext(), getTitleBarHeight());
      this.d.setOnDismissListener(new BaseActivityView.3(this));
      if (paramBoolean) {
        this.d.setOnKeyListener(new BaseActivityView.4(this));
      }
      this.d.c(paramInt);
      this.d.setCanceledOnTouchOutside(false);
      this.d.show();
    }
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.q = true;
    h();
  }
  
  protected void e() {}
  
  protected boolean f()
  {
    return this.q;
  }
  
  protected void g()
  {
    this.q = true;
    this.n.g();
  }
  
  protected void h()
  {
    this.o.removeMessages(1);
    QQProgressDialog localQQProgressDialog = this.d;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.cancel();
      this.d = null;
    }
  }
  
  protected void i()
  {
    if ((this.h != null) && (this.p == null))
    {
      this.p = getResources().getDrawable(2130839590);
      this.h.setCompoundDrawablePadding(10);
      this.h.setCompoundDrawablesWithIntrinsicBounds(this.p, null, null, null);
      ((Animatable)this.p).start();
      this.o.removeMessages(3);
      this.o.sendEmptyMessageDelayed(3, 120000L);
    }
  }
  
  protected void j()
  {
    if ((this.h != null) && (this.p != null))
    {
      this.o.removeMessages(3);
      ((Animatable)this.p).stop();
      this.p = null;
      this.h.setCompoundDrawables(null, null, null, null);
    }
  }
  
  protected final void setContentView(int paramInt)
  {
    a(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView
 * JD-Core Version:    0.7.0.1
 */