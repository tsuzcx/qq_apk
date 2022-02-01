package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.MqqWeakReferenceHandler;

public class BaseTroopView
  extends FrameLayout
{
  protected BaseTroopView.ITroopContext a;
  protected QQAppInterface b;
  protected boolean c = true;
  public boolean d = false;
  View e;
  View f;
  View g;
  View h;
  protected int i = 0;
  
  public BaseTroopView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.d = true;
  }
  
  protected final void a(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, long paramLong)
  {
    this.a.h().sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  protected void a(Intent paramIntent)
  {
    a(paramIntent, 0);
  }
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    this.a.b().startActivityForResult(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    this.a = paramITroopContext;
    this.b = this.a.a();
    this.e = this.a.e();
    this.f = this.a.f();
    this.g = this.a.d();
    this.h = this.a.g();
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(paramBusinessObserver);
    }
  }
  
  protected final void a(String paramString)
  {
    if (!h()) {
      this.a.a(paramString);
    }
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b()
  {
    this.d = false;
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(paramBusinessObserver);
    }
  }
  
  protected void c()
  {
    this.c = false;
  }
  
  protected void d() {}
  
  protected void e() {}
  
  protected void f()
  {
    this.c = true;
  }
  
  protected void g() {}
  
  public Activity getActivity()
  {
    return this.a.b();
  }
  
  protected final boolean h()
  {
    return this.c;
  }
  
  public void i() {}
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
    setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.BaseTroopView
 * JD-Core Version:    0.7.0.1
 */