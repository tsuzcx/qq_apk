package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendSubTitleMessage;

public class NewFriendSubTitleBuilder
  extends NewFriendBaseBuilder
{
  public NewFriendSubTitleBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)))
    {
      paramView = new NewFriendSubTitleBuilder.NewFriendSubTitleHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970500, null);
      paramView.a = ((TextView)localView.findViewById(2131363378));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)localObject).a.setText(((NewFriendSubTitleMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.title);
      return localView;
      localObject = (NewFriendSubTitleBuilder.NewFriendSubTitleHolder)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendSubTitleBuilder
 * JD-Core Version:    0.7.0.1
 */