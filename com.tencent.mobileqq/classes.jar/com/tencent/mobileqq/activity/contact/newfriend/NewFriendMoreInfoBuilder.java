package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.statistics.ReportController;

public class NewFriendMoreInfoBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendMoreInfoBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder localNewFriendMoreInfoHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)))
    {
      localNewFriendMoreInfoHolder = new NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970499, null);
      localNewFriendMoreInfoHolder.a = ((TextView)paramView.findViewById(2131370883));
      paramView.setTag(localNewFriendMoreInfoHolder);
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((NewFriendMoreInfoMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      localNewFriendMoreInfoHolder.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      localNewFriendMoreInfoHolder = (NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder))) {}
    switch (((NewFriendMoreInfoMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.type)
    {
    default: 
      return;
    case 1000: 
      int i = this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      return;
    }
    paramView = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 4);
    localIntent.putExtra("EntranceId", 6);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
    paramView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreInfoBuilder
 * JD-Core Version:    0.7.0.1
 */