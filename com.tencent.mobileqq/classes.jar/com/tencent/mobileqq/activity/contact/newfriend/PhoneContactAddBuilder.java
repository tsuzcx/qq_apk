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
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.PhoneContactAddMessage;
import wgm;

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
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2130970593, localPhoneContactAddHolder);
      localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366518));
      localPhoneContactAddHolder.h = ((TextView)paramView.findViewById(2131362876));
      localPhoneContactAddHolder.i = ((TextView)paramView.findViewById(2131369905));
      localPhoneContactAddHolder.l = ((TextView)paramView.findViewById(2131371369));
      localPhoneContactAddHolder.j = ((TextView)paramView.findViewById(2131369907));
      localPhoneContactAddHolder.k = ((TextView)paramView.findViewById(2131368908));
      localPhoneContactAddHolder.a = ((Button)paramView.findViewById(2131368907));
      paramView.setTag(localPhoneContactAddHolder);
      localPhoneContactAddHolder.jdField_f_of_type_AndroidViewView.setTag(localPhoneContactAddHolder);
      localPhoneContactAddHolder.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localPhoneContactAddHolder, this);
      localPhoneContactAddHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838581);
      localPhoneContactAdd = ((PhoneContactAddMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label339;
      }
      localPhoneContactAddHolder.h.setVisibility(0);
      localPhoneContactAddHolder.h.setText(localPhoneContactAdd.name);
      label214:
      localPhoneContactAddHolder.l.setVisibility(8);
      localPhoneContactAddHolder.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label351;
      }
      localPhoneContactAddHolder.i.setVisibility(0);
      localPhoneContactAddHolder.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localPhoneContactAddHolder.k.setVisibility(0);
      localPhoneContactAddHolder.a.setVisibility(8);
      localPhoneContactAddHolder.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131433031));
      localPhoneContactAddHolder.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localPhoneContactAddHolder = (PhoneContactAddBuilder.PhoneContactAddHolder)paramView.getTag();
      break;
      label339:
      localPhoneContactAddHolder.h.setVisibility(8);
      break label214;
      label351:
      localPhoneContactAddHolder.i.setVisibility(8);
    }
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new wgm(this), null, true);
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
        return;
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof PhoneContactAddBuilder.PhoneContactAddHolder)));
      localPhoneContactAdd = ((PhoneContactAddMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
    } while (localPhoneContactAdd == null);
    paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramView.c(localPhoneContactAdd.unifiedCode) == null) {
      paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      paramView.h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 227);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).e();
      return;
      if (paramView.g()) {
        paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 34);
      } else {
        paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder
 * JD-Core Version:    0.7.0.1
 */