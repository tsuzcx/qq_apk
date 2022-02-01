package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.os.MqqHandler;

public class AIOJubaoDialogHelper
  implements DialogGenerator, ILifeCycleHelper
{
  Dialog jdField_a_of_type_AndroidAppDialog;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Dialog b;
  Dialog c;
  Dialog d;
  
  public AIOJubaoDialogHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramHelperProvider.a(this);
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755842);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559084);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365811);
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365796);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365802);
      localTextView1.setText(2131718545);
      ((TextView)localObject).setText(2131718543);
      localTextView3.setText(2131718544);
      localTextView3.setOnClickListener(new AIOJubaoDialogHelper.1(this));
      localTextView2.setText(2131690800);
      localTextView2.setOnClickListener(new AIOJubaoDialogHelper.2(this));
      return this.jdField_a_of_type_AndroidAppDialog;
    case 231: 
      this.b = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755842);
      this.b.setContentView(2131558435);
      ((TextView)this.b.findViewById(2131365807)).setText(2131718546);
      return this.b;
    case 232: 
      this.c = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755842);
      this.c.setContentView(2131563107);
      localTextView1 = (TextView)this.c.findViewById(2131379105);
      localObject = (ImageView)this.c.findViewById(2131368754);
      localTextView1.setText(2131690824);
      ((ImageView)localObject).setImageResource(2130839730);
      return this.c;
    }
    this.d = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755842);
    this.d.setContentView(2131563107);
    TextView localTextView1 = (TextView)this.d.findViewById(2131379105);
    Object localObject = (ImageView)this.d.findViewById(2131368754);
    localTextView1.setText(2131690822);
    ((ImageView)localObject).setImageResource(2130839715);
    return this.d;
  }
  
  public void a()
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(231);
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().postDelayed(new AIOJubaoDialogHelper.3(this), 1000L);
  }
  
  public String getTag()
  {
    return "AIOJubaoDialogHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper
 * JD-Core Version:    0.7.0.1
 */