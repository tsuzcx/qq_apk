package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneContactAddBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public PhoneContactAddBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    PhoneContactAddBuilder.PhoneContactAddHolder localPhoneContactAddHolder;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof PhoneContactAddBuilder.PhoneContactAddHolder)))
    {
      localPhoneContactAddHolder = new PhoneContactAddBuilder.PhoneContactAddHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561658, localPhoneContactAddHolder);
      localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localPhoneContactAddHolder.h = ((TextView)paramView.findViewById(2131372288));
      localPhoneContactAddHolder.i = ((TextView)paramView.findViewById(2131377005));
      localPhoneContactAddHolder.l = ((TextView)paramView.findViewById(2131362338));
      localPhoneContactAddHolder.j = ((TextView)paramView.findViewById(2131378318));
      localPhoneContactAddHolder.k = ((TextView)paramView.findViewById(2131377001));
      localPhoneContactAddHolder.a = ((Button)paramView.findViewById(2131376990));
      b(localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localPhoneContactAddHolder);
      localPhoneContactAddHolder.g.setTag(localPhoneContactAddHolder);
      localPhoneContactAddHolder.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage, localPhoneContactAddHolder, this);
      a(localPhoneContactAddHolder.g, false);
      localPhoneContactAdd = ((PhoneContactAddMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localPhoneContactAddHolder.h.setVisibility(0);
      localPhoneContactAddHolder.h.setText(localPhoneContactAdd.name);
      label221:
      localPhoneContactAddHolder.l.setVisibility(8);
      localPhoneContactAddHolder.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localPhoneContactAddHolder.i.setVisibility(0);
      localPhoneContactAddHolder.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localPhoneContactAddHolder.k.setVisibility(0);
      localPhoneContactAddHolder.a.setVisibility(8);
      localPhoneContactAddHolder.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718554));
      localPhoneContactAddHolder.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localPhoneContactAddHolder = (PhoneContactAddBuilder.PhoneContactAddHolder)paramView.getTag();
      break;
      label346:
      localPhoneContactAddHolder.h.setVisibility(8);
      break label221;
      label358:
      localPhoneContactAddHolder.i.setVisibility(8);
    }
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new PhoneContactAddBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    PhoneContactAdd localPhoneContactAdd;
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = paramView.getTag();
      } while ((localObject == null) || (!(localObject instanceof PhoneContactAddBuilder.PhoneContactAddHolder)));
      localPhoneContactAdd = ((PhoneContactAddMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
    } while (localPhoneContactAdd == null);
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (((PhoneContactManagerImp)localObject).c(localPhoneContactAdd.unifiedCode) == null) {
      localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      ((ProfileActivity.AllInOne)localObject).h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, 227);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).g();
      break;
      if (((PhoneContactManagerImp)localObject).i()) {
        localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 34);
      } else {
        localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder
 * JD-Core Version:    0.7.0.1
 */