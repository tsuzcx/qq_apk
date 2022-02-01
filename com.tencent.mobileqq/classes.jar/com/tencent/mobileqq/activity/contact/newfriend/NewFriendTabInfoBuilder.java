package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendTabInfoMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

public class NewFriendTabInfoBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendTabInfoBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  private void a(TextView paramTextView, NewFriendMessage paramNewFriendMessage)
  {
    if ((paramNewFriendMessage == null) || (!(paramNewFriendMessage instanceof NewFriendTabInfoMessage))) {}
    do
    {
      return;
      paramNewFriendMessage = (NewFriendTabInfoMessage)paramNewFriendMessage;
    } while ((paramNewFriendMessage.a == null) || (paramNewFriendMessage.a.size() == 0));
    paramNewFriendMessage = this.jdField_a_of_type_AndroidContentContext.getString(2131698970);
    paramTextView.setVisibility(0);
    paramTextView.setText(paramNewFriendMessage);
    paramTextView.setPadding(0, ViewUtils.a(16.0F), 0, ViewUtils.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendTabInfoBuilder.NewFriendTabInfoHolder)))
    {
      paramView = new NewFriendTabInfoBuilder.NewFriendTabInfoHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561411, null);
      paramView.a = ((TextView)localView.findViewById(2131378831));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((NewFriendTabInfoBuilder.NewFriendTabInfoHolder)localObject).a);
      a(((NewFriendTabInfoBuilder.NewFriendTabInfoHolder)localObject).a, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage);
      localView.setOnClickListener(this);
      return localView;
      localObject = (NewFriendTabInfoBuilder.NewFriendTabInfoHolder)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839537);
      return;
    }
    paramView.setBackgroundResource(2130850652);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendTabInfoBuilder
 * JD-Core Version:    0.7.0.1
 */