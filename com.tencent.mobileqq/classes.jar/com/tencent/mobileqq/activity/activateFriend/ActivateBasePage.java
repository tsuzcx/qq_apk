package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class ActivateBasePage
  extends RelativeLayout
{
  public static float a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ActivateFriendGrid jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  
  static
  {
    jdField_a_of_type_Float = 2.364865F;
  }
  
  public ActivateBasePage(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setTextScrolling(false);
    }
  }
  
  public ActivateBasePage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public abstract void a();
  
  protected void a(View paramView)
  {
    int i = (int)((int)(getResources().getDisplayMetrics().widthPixels - 16.0F * getResources().getDisplayMetrics().density) / jdField_a_of_type_Float);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = i;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
    }
  }
  
  public void c() {}
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
 * JD-Core Version:    0.7.0.1
 */