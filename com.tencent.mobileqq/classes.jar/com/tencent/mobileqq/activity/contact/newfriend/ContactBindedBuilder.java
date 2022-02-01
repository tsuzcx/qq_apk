package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class ContactBindedBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public ContactBindedBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels >= 1080) {}
    for (int i = 5;; i = 4)
    {
      this.jdField_a_of_type_Int = i;
      this.b = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.b.clone());
      int j = this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilArrayList.size();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_JavaUtilArrayList, i);
      return;
    }
  }
  
  private void a(ContactBindedBuilder.ContactBindedHolder paramContactBindedHolder)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage.a()))
    {
      CustomWidgetUtil.a(paramContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactBindedBuilder.ContactBindedHolder localContactBindedHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ContactBindedBuilder.ContactBindedHolder)))
    {
      localContactBindedHolder = new ContactBindedBuilder.ContactBindedHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561402, null);
      localContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380941));
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372950));
      localContactBindedHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372953);
      localContactBindedHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372954);
      localContactBindedHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372955);
      localContactBindedHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372956);
      localContactBindedHolder.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131372957);
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368307));
      localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368308));
      localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368309));
      localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368310));
      localContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368311));
      localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372274));
      localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372275));
      localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372276));
      localContactBindedHolder.f = ((TextView)paramView.findViewById(2131372277));
      localContactBindedHolder.g = ((TextView)paramView.findViewById(2131372278));
      b(localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localContactBindedHolder);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131702492), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localContactBindedHolder = (ContactBindedBuilder.ContactBindedHolder)paramView.getTag();
    }
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = paramInt;
    if (paramInt < this.jdField_a_of_type_Int)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      i = paramInt;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PhoneContact)((Iterator)localObject1).next();
        if ((this.jdField_a_of_type_JavaUtilArrayList.contains(localObject2)) || (!((PhoneContact)localObject2).uin.equals("0"))) {
          break label1822;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramInt += 1;
      }
    }
    label1822:
    for (;;)
    {
      if (paramInt == this.jdField_a_of_type_Int)
      {
        i = paramInt;
        switch (i)
        {
        default: 
          label556:
          if (AppSetting.d) {
            paramView.setContentDescription(String.format(HardCodeUtil.a(2131702500), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localContactBindedHolder);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
          localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
          localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
          localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
          localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
          localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localContactBindedHolder.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_d_of_type_JavaLangString));
          localContactBindedHolder.f.setText(((PhoneContact)localObject1).name);
          break;
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
        localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
        localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
        localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localContactBindedHolder.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_d_of_type_JavaLangString));
        localContactBindedHolder.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localContactBindedHolder.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_e_of_type_JavaLangString));
        localContactBindedHolder.g.setText(((PhoneContact)localObject1).name);
        break label556;
      }
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
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ContactBindedBuilder.ContactBindedHolder)))
      {
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.h();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactBindedBuilder
 * JD-Core Version:    0.7.0.1
 */