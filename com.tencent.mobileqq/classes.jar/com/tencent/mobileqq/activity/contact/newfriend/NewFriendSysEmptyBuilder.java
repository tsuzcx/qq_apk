package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class NewFriendSysEmptyBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendSysEmptyBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder localNewFriendSysEmptyHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder)))
    {
      localNewFriendSysEmptyHolder = new NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder();
      paramView = LayoutInflater.from(this.a).inflate(2131561415, null);
      paramView.setTag(localNewFriendSysEmptyHolder);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localNewFriendSysEmptyHolder = (NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendSysEmptyBuilder
 * JD-Core Version:    0.7.0.1
 */