package com.tencent.mobileqq.activity.contact.troop;

import ahoe;
import alpg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import bhsl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseTroopView
  extends FrameLayout
{
  protected int a;
  public ahoe a;
  View a;
  public QQAppInterface a;
  protected boolean a;
  View b;
  public boolean b;
  View c;
  View d;
  
  public BaseTroopView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Ahoe.a();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
    setBackgroundDrawable(null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Ahoe.a().sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahoe.a(paramInt, paramBoolean);
  }
  
  public void a(alpg paramalpg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramalpg);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    a(paramIntent, 0);
  }
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_Ahoe.a().startActivityForResult(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, ahoe paramahoe)
  {
    this.jdField_a_of_type_Ahoe = paramahoe;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_Ahoe.a();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Ahoe.b();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Ahoe.c();
    this.c = this.jdField_a_of_type_Ahoe.a();
    this.d = this.jdField_a_of_type_Ahoe.d();
  }
  
  protected final void a(String paramString)
  {
    if (!a()) {
      this.jdField_a_of_type_Ahoe.a(paramString);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public final void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void b(alpg paramalpg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(paramalpg);
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void d() {}
  
  protected void e() {}
  
  protected void f()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.BaseTroopView
 * JD-Core Version:    0.7.0.1
 */