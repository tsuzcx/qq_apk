package com.tencent.mobileqq.activity.activateFriend;

import acgv;
import achf;
import achg;
import achh;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import mqq.util.WeakReference;

public class PositionActivatePage
  extends ActivateBasePage
{
  private acgv jdField_a_of_type_Acgv = new achf(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new achg(this);
  public String a;
  private WeakReference<ActivateFriendActivity> jdField_a_of_type_MqqUtilWeakReference;
  private View.OnClickListener b;
  
  public PositionActivatePage(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new achh(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((ActivateFriendActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131624057);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this.jdField_a_of_type_Acgv);
    this.d.setVisibility(0);
    this.d.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495021, this, false);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296404));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296400));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296401));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131296398));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296403));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296397));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_a_of_type_AndroidViewView.findViewById(2131301173));
    a((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296418));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage
 * JD-Core Version:    0.7.0.1
 */