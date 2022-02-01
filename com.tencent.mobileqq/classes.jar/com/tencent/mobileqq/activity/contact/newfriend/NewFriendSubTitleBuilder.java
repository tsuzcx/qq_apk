package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendSubTitleBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendSubTitleBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)))
    {
      localObject = new NewFriendSubTitleBuilder.NewFriendSubTitleHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561414, null);
      ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379432));
      ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366395);
      ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((NewFriendSubTitleMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.title);
      localObject = ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)localObject).jdField_a_of_type_AndroidViewView;
      if (!((NewFriendSubTitleMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (NewFriendSubTitleBuilder.NewFriendSubTitleHolder)paramView.getTag();
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NewFriendVerificationManager.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      ReportController.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendSubTitleBuilder
 * JD-Core Version:    0.7.0.1
 */