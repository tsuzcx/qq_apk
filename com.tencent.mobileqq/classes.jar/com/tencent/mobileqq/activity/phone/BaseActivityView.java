package com.tencent.mobileqq.activity.phone;

import agij;
import agik;
import agil;
import agim;
import agin;
import agio;
import ajya;
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
import bbdj;
import bbgu;
import bcqf;
import bcql;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;

@SuppressLint({"ViewConstructor"})
public class BaseActivityView
  extends FrameLayout
{
  public int a;
  private agio jdField_a_of_type_Agio;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View a;
  protected ImageView a;
  public TextView a;
  public bcqf a;
  private PhoneInnerFrame jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame;
  public BaseActivity a;
  public PhoneContactManagerImp a;
  public QQAppInterface a;
  private boolean jdField_a_of_type_Boolean;
  protected View b;
  protected TextView b;
  private View c;
  protected TextView c;
  private TextView d;
  
  public BaseActivityView(Context paramContext, int paramInt)
  {
    super(paramContext);
    if ((paramContext instanceof BaseActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramContext);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getHeight();
  }
  
  private void a(agin paramagin)
  {
    this.jdField_c_of_type_AndroidWidgetTextView = paramagin.a();
    this.d = paramagin.d();
    this.jdField_a_of_type_AndroidViewView = paramagin.a();
    this.jdField_b_of_type_AndroidViewView = paramagin.b();
    this.jdField_a_of_type_AndroidWidgetImageView = paramagin.a();
    this.jdField_a_of_type_AndroidWidgetTextView = paramagin.b();
    this.jdField_b_of_type_AndroidWidgetTextView = paramagin.c();
  }
  
  protected View a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return this.jdField_c_of_type_AndroidViewView.findViewById(paramInt);
    }
    return findViewById(paramInt);
  }
  
  protected void a()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(0);
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690596);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajya.a(2131700936));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.d.setOnClickListener(new agij(this));
      this.jdField_a_of_type_Boolean = false;
      return;
      if (this.jdField_a_of_type_Int != 1) {
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840080);
        }
        else if (this.jdField_a_of_type_Int == 5)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
  
  protected final void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, long paramLong)
  {
    if (!a())
    {
      b(paramInt);
      this.jdField_a_of_type_Agio.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Agio;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localObject = ((agio)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Agio.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  protected final void a(int paramInt, boolean paramBoolean)
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (paramBoolean)
    {
      BounceScrollView localBounceScrollView = (BounceScrollView)localLayoutInflater.inflate(2131558649, null);
      this.jdField_c_of_type_AndroidViewView = localLayoutInflater.inflate(paramInt, null);
      localBounceScrollView.addView(this.jdField_c_of_type_AndroidViewView);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.a(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    this.jdField_a_of_type_Agio = new agio(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame = paramPhoneInnerFrame;
    paramIntent = paramPhoneInnerFrame.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramIntent.a();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    a(paramIntent);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (!a()) {
      bbdj.a(getContext(), 231, paramString1, paramString2, new agik(this), null).show();
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b() {}
  
  protected void b(int paramInt)
  {
    b(getResources().getString(paramInt));
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if ((!a()) && (this.jdField_a_of_type_Bcqf == null))
    {
      this.jdField_a_of_type_Bcqf = new bcqf(getContext(), a());
      this.jdField_a_of_type_Bcqf.setOnDismissListener(new agil(this));
      if (paramBoolean) {
        this.jdField_a_of_type_Bcqf.setOnKeyListener(new agim(this));
      }
      this.jdField_a_of_type_Bcqf.c(paramInt);
      this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  public void b(String paramString)
  {
    if (!a()) {
      bcql.a(getContext(), 0, paramString, 0).b(a());
    }
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_a_of_type_Boolean = true;
    g();
  }
  
  protected void e() {}
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.f();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Agio.removeMessages(1);
    if (this.jdField_a_of_type_Bcqf != null)
    {
      this.jdField_a_of_type_Bcqf.cancel();
      this.jdField_a_of_type_Bcqf = null;
    }
  }
  
  protected void h()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839144);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      this.jdField_a_of_type_Agio.removeMessages(3);
      this.jdField_a_of_type_Agio.sendEmptyMessageDelayed(3, 120000L);
    }
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_Agio.removeMessages(3);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView
 * JD-Core Version:    0.7.0.1
 */