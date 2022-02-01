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
    case 233: 
      this.d = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131756189);
      this.d.setContentView(2131562931);
      localTextView1 = (TextView)this.d.findViewById(2131378475);
      localObject = (ImageView)this.d.findViewById(2131368486);
      localTextView1.setText(2131690750);
      ((ImageView)localObject).setImageResource(2130839573);
      return this.d;
    case 232: 
      this.c = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131756189);
      this.c.setContentView(2131562931);
      localTextView1 = (TextView)this.c.findViewById(2131378475);
      localObject = (ImageView)this.c.findViewById(2131368486);
      localTextView1.setText(2131690752);
      ((ImageView)localObject).setImageResource(2130839588);
      return this.c;
    case 231: 
      this.b = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131756189);
      this.b.setContentView(2131558463);
      ((TextView)this.b.findViewById(2131365644)).setText(2131718214);
      return this.b;
    }
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131756189);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558978);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365648);
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365633);
    TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365639);
    localTextView1.setText(2131718213);
    ((TextView)localObject).setText(2131718211);
    localTextView3.setText(2131718212);
    localTextView3.setOnClickListener(new AIOJubaoDialogHelper.1(this));
    localTextView2.setText(2131690728);
    localTextView2.setOnClickListener(new AIOJubaoDialogHelper.2(this));
    return this.jdField_a_of_type_AndroidAppDialog;
  }
  
  public void a()
  {
    Dialog localDialog = this.b;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(231);
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    if ((paramInt != 232) && (paramInt != 233)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper
 * JD-Core Version:    0.7.0.1
 */