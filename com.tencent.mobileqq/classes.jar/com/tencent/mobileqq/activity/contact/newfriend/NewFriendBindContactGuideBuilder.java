package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendBindContactGuideBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendBindContactGuideBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof NewFriendBindContactGuideBuilder.MyHolder)) {}
    }
    else
    {
      localView = LayoutInflater.from(this.a).inflate(2131561664, null);
    }
    localView.setOnClickListener(this);
    localView.setTag(new NewFriendBindContactGuideBuilder.MyHolder());
    return localView;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendBindContactGuideBuilder", 2, "start PhoneLaunchActivity");
    }
    Intent localIntent = new Intent(paramView.getContext(), BindNumberActivity.class);
    localIntent.putExtra("kSrouce", 15);
    ((Activity)paramView.getContext()).startActivityForResult(localIntent, 230);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilder
 * JD-Core Version:    0.7.0.1
 */