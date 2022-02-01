package com.tencent.av.wtogether.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ListView;

public abstract class QBaseContentView
  extends RelativeLayout
{
  protected FragmentActivity a;
  View a;
  protected QQAppInterface a;
  
  public QBaseContentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QBaseContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QBaseContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppInterface());
  }
  
  public abstract ListView a();
  
  public abstract void a();
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QBaseContentView
 * JD-Core Version:    0.7.0.1
 */