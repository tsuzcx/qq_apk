package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import wgq;

public class QIMNotifyAddFriendBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public QIMNewFriendManager a;
  
  public QIMNotifyAddFriendBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager = ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(256));
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder localQIMNotifyAddFriendHolder;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    label260:
    int i;
    label300:
    int j;
    label358:
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder)))
    {
      localQIMNotifyAddFriendHolder = new QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2130970593, localQIMNotifyAddFriendHolder);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366518));
      localQIMNotifyAddFriendHolder.h = ((TextView)paramView.findViewById(2131362876));
      localQIMNotifyAddFriendHolder.i = ((TextView)paramView.findViewById(2131369905));
      localQIMNotifyAddFriendHolder.l = ((TextView)paramView.findViewById(2131371369));
      localQIMNotifyAddFriendHolder.j = ((TextView)paramView.findViewById(2131369907));
      localQIMNotifyAddFriendHolder.k = ((TextView)paramView.findViewById(2131368908));
      localQIMNotifyAddFriendHolder.a = ((Button)paramView.findViewById(2131368907));
      paramView.setTag(localQIMNotifyAddFriendHolder);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidViewView.setTag(localQIMNotifyAddFriendHolder);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidViewView.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localQIMNotifyAddFriendHolder, this);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838581);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      localQIMNotifyAddFriendHolder.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.b) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label701;
      }
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838585);
      paramInt = 0;
      switch (localQIMNotifyAddFriend.gender)
      {
      default: 
        i = 0;
        localQIMNotifyAddFriendHolder.l.setBackgroundResource(2130843021);
        if (localQIMNotifyAddFriend.age > 0)
        {
          localQIMNotifyAddFriendHolder.l.setText(String.valueOf(localQIMNotifyAddFriend.age));
          j = 1;
          paramInt = j;
          if (AppSetting.b)
          {
            localStringBuilder.append(",").append(String.valueOf(localQIMNotifyAddFriend.age));
            paramInt = j;
          }
          localQIMNotifyAddFriendHolder.l.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if (paramInt == 0) {
            break label825;
          }
          localQIMNotifyAddFriendHolder.l.setVisibility(0);
          localQIMNotifyAddFriendHolder.l.setPadding(8, 4, 8, 4);
          label397:
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label838;
          }
          localQIMNotifyAddFriendHolder.i.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).d();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), "来源：%s", new Object[] { localObject });
      localQIMNotifyAddFriendHolder.j.setText((CharSequence)localObject);
      localQIMNotifyAddFriendHolder.j.setVisibility(0);
      if (AppSetting.b) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localQIMNotifyAddFriendHolder.k.setVisibility(8);
      localQIMNotifyAddFriendHolder.a.setText("查看");
      localQIMNotifyAddFriendHolder.a.setVisibility(0);
      localQIMNotifyAddFriendHolder.a.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494230);
      if (localObject != null) {
        localQIMNotifyAddFriendHolder.a.setTextColor((ColorStateList)localObject);
      }
      localQIMNotifyAddFriendHolder.a.setBackgroundResource(2130838505);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.b) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localQIMNotifyAddFriendHolder = (QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder)paramView.getTag();
      break;
      label701:
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838581);
      break label260;
      j = 1;
      int k = 2130843020;
      localQIMNotifyAddFriendHolder.l.setBackgroundResource(2130843021);
      i = k;
      paramInt = j;
      if (!AppSetting.b) {
        break label300;
      }
      localStringBuilder.append("男");
      i = k;
      paramInt = j;
      break label300;
      j = 1;
      k = 2130843018;
      localQIMNotifyAddFriendHolder.l.setBackgroundResource(2130843019);
      i = k;
      paramInt = j;
      if (!AppSetting.b) {
        break label300;
      }
      localStringBuilder.append("女");
      i = k;
      paramInt = j;
      break label300;
      localQIMNotifyAddFriendHolder.l.setText("");
      break label358;
      label825:
      localQIMNotifyAddFriendHolder.l.setVisibility(8);
      break label397;
      label838:
      localQIMNotifyAddFriendHolder.i.setVisibility(0);
      localQIMNotifyAddFriendHolder.i.setText((CharSequence)localObject);
      if (AppSetting.b) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new wgq(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131366517: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(this.jdField_a_of_type_AndroidContentContext, null);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).e();
    paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localQIMNotifyAddFriend);
    paramView.a(localArrayList);
    ReportController.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.QIMNotifyAddFriendBuilder
 * JD-Core Version:    0.7.0.1
 */