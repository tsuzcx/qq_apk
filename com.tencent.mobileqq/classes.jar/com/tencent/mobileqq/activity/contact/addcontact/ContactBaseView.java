package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class ContactBaseView
  extends FrameLayout
{
  public ContactBaseView.IAddContactContext E;
  public Activity F;
  public QQAppInterface G;
  
  public ContactBaseView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext.b());
    this.E = paramIAddContactContext;
    this.F = this.E.b();
    this.G = paramIAddContactContext.a();
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public int getHeightToTabBar()
  {
    return getResources().getDimensionPixelSize(2131298867);
  }
  
  public void h() {}
  
  public void i() {}
  
  public final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
 * JD-Core Version:    0.7.0.1
 */