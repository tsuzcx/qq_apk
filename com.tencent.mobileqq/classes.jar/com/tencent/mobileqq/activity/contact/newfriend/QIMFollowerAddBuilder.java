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
import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

public class QIMFollowerAddBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public QIMFollowerAddBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297494);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    QIMFollowerAddBuilder.QIMFollowerAddHolder localQIMFollowerAddHolder;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof QIMFollowerAddBuilder.QIMFollowerAddHolder)))
    {
      localQIMFollowerAddHolder = new QIMFollowerAddBuilder.QIMFollowerAddHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561658, localQIMFollowerAddHolder);
      a(paramView, this.b);
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localQIMFollowerAddHolder.h = ((TextView)paramView.findViewById(2131372288));
      localQIMFollowerAddHolder.i = ((TextView)paramView.findViewById(2131377005));
      localQIMFollowerAddHolder.l = ((TextView)paramView.findViewById(2131362338));
      localQIMFollowerAddHolder.j = ((TextView)paramView.findViewById(2131378318));
      localQIMFollowerAddHolder.k = ((TextView)paramView.findViewById(2131377001));
      localQIMFollowerAddHolder.a = ((Button)paramView.findViewById(2131376990));
      b(localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localQIMFollowerAddHolder);
      localQIMFollowerAddHolder.g.setTag(localQIMFollowerAddHolder);
      localQIMFollowerAddHolder.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage, localQIMFollowerAddHolder, this);
      localQIMFollowerAddHolder.g.setBackgroundResource(2130839534);
      localQIMFollwerAdd = ((QIMFollowMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localQIMFollowerAddHolder.h.setVisibility(0);
      localQIMFollowerAddHolder.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localQIMFollowerAddHolder.g;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localQIMFollowerAddHolder.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localQIMFollowerAddHolder.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131709779), new Object[] { localQIMFollwerAdd.source });
      localQIMFollowerAddHolder.j.setText((CharSequence)localObject);
      localQIMFollowerAddHolder.j.setVisibility(0);
    }
    for (;;)
    {
      localQIMFollowerAddHolder.k.setVisibility(8);
      localQIMFollowerAddHolder.a.setText(HardCodeUtil.a(2131709778));
      localQIMFollowerAddHolder.a.setVisibility(0);
      localQIMFollowerAddHolder.a.setOnClickListener(this);
      localQIMFollowerAddHolder.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localQIMFollowerAddHolder = (QIMFollowerAddBuilder.QIMFollowerAddHolder)paramView.getTag();
      break;
      label470:
      localQIMFollowerAddHolder.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localQIMFollowerAddHolder.i.setVisibility(0);
      localQIMFollowerAddHolder.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.d) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localQIMFollowerAddHolder.j.setVisibility(8);
    }
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new QIMFollowerAddBuilder.1(this), null, true);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.QIMFollowerAddBuilder
 * JD-Core Version:    0.7.0.1
 */