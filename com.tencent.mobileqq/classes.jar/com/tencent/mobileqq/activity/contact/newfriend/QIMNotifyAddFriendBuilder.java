package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class QIMNotifyAddFriendBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public QIMNewFriendManager a;
  
  public QIMNotifyAddFriendBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager = ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297492);
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
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder)))
    {
      localQIMNotifyAddFriendHolder = new QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561658, localQIMNotifyAddFriendHolder);
      a(paramView, this.b);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localQIMNotifyAddFriendHolder.h = ((TextView)paramView.findViewById(2131372288));
      localQIMNotifyAddFriendHolder.i = ((TextView)paramView.findViewById(2131377005));
      localQIMNotifyAddFriendHolder.l = ((TextView)paramView.findViewById(2131362338));
      localQIMNotifyAddFriendHolder.j = ((TextView)paramView.findViewById(2131378318));
      localQIMNotifyAddFriendHolder.k = ((TextView)paramView.findViewById(2131377001));
      localQIMNotifyAddFriendHolder.a = ((Button)paramView.findViewById(2131376990));
      b(localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localQIMNotifyAddFriendHolder);
      localQIMNotifyAddFriendHolder.g.setTag(localQIMNotifyAddFriendHolder);
      localQIMNotifyAddFriendHolder.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage, localQIMNotifyAddFriendHolder, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
      localQIMNotifyAddFriendHolder.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.d) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localQIMNotifyAddFriendHolder.g;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localQIMNotifyAddFriendHolder.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localQIMNotifyAddFriendHolder.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131709784), new Object[] { localObject });
      localQIMNotifyAddFriendHolder.j.setText((CharSequence)localObject);
      localQIMNotifyAddFriendHolder.j.setVisibility(0);
      if (AppSetting.d) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localQIMNotifyAddFriendHolder.k.setVisibility(8);
      localQIMNotifyAddFriendHolder.a.setText(HardCodeUtil.a(2131709785));
      localQIMNotifyAddFriendHolder.a.setVisibility(0);
      localQIMNotifyAddFriendHolder.a.setOnClickListener(this);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localQIMNotifyAddFriendHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localQIMNotifyAddFriendHolder = (QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localQIMNotifyAddFriendHolder.i.setVisibility(0);
      localQIMNotifyAddFriendHolder.i.setText((CharSequence)localObject);
      if (AppSetting.d) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, null);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).g();
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      QIMNotifyAddFriend localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localQIMNotifyAddFriend);
      localFriendListHandler.addBatchQIMFriends(localArrayList);
      ReportController.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.QIMNotifyAddFriendBuilder
 * JD-Core Version:    0.7.0.1
 */