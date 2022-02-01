package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendVerifyBlockedMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendVerifyBlockedBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendVerifyBlockedBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder localNewFriendVerifyBlockedHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561666, null);
      localNewFriendVerifyBlockedHolder = new NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder();
      localNewFriendVerifyBlockedHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368281));
      paramView.setOnClickListener(this);
      paramView.setTag(localNewFriendVerifyBlockedHolder);
    }
    for (;;)
    {
      String str = ((NewFriendVerifyBlockedMsg)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).b;
      localNewFriendVerifyBlockedHolder.jdField_f_of_type_JavaLangString = str;
      localNewFriendVerifyBlockedHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(1, str));
      NewFriendVerificationManager.a += 1;
      return paramView;
      localNewFriendVerifyBlockedHolder = (NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    NewFriendVerificationManager.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    ReportController.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendVerifyBlockedBuilder
 * JD-Core Version:    0.7.0.1
 */