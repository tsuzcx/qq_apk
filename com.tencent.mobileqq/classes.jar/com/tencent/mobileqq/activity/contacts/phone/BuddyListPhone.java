package com.tencent.mobileqq.activity.contacts.phone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;

public class BuddyListPhone
  extends BuddyListItem
{
  public BuddyListPhone(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    PhoneContact localPhoneContact;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListPhone.PhoneContactChildTag)))
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559032, paramViewGroup, false);
      paramOnClickListener = new BuddyListPhone.PhoneContactChildTag();
      paramOnClickListener.d = ((ImageView)paramViewGroup.findViewById(2131368603));
      paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131379092));
      paramOnClickListener.c = ((SingleLineTextView)paramViewGroup.findViewById(2131380497));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369834));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131376990));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377001));
      paramViewGroup.setTag(paramOnClickListener);
      a(paramViewGroup.findViewById(2131368603));
      localPhoneContact = (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramOnClickListener.jdField_a_of_type_JavaLangObject = localPhoneContact;
      paramOnClickListener.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      paramInt2 = ContactUtils.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      paramInt1 = localPhoneContact.netTypeIconId;
    }
    label313:
    Object localObject;
    switch (paramInt2)
    {
    case 5: 
    default: 
      paramView = paramView.getOfflineTipsConfig(localPhoneContactManagerImp.a(localPhoneContact.unifiedCode));
      if (paramView == null) {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719511);
      }
      break;
    case 1: 
    case 2: 
    case 7: 
    case 3: 
    case 6: 
    case 4: 
    case 8: 
      for (;;)
      {
        if ((paramInt2 == 0) || (paramInt2 == 6))
        {
          paramInt2 = 1;
          if ((localPhoneContactManagerImp.f & 0x8) != 8L)
          {
            localObject = a();
            ImageView localImageView = paramOnClickListener.d;
            if (paramInt2 == 0) {
              break label710;
            }
            label346:
            localImageView.setImageDrawable((Drawable)localObject);
          }
          if ((localPhoneContactManagerImp.f & 0x4) != 4L) {
            break label716;
          }
          paramInt2 = 1;
          label371:
          if (paramInt2 == 0) {
            break label721;
          }
          paramOnClickListener.c.setVisibility(8);
          label385:
          paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167040));
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localPhoneContact.name);
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((TextUtils.isEmpty(localPhoneContact.uin)) || (localPhoneContact.uin.equals("0"))) {
            break label787;
          }
          paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701295));
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131701298));
          label509:
          if (AppSetting.d)
          {
            paramOnClickListener = paramOnClickListener.jdField_a_of_type_JavaLangStringBuilder;
            if (paramOnClickListener != null) {
              break label911;
            }
            paramOnClickListener = new StringBuilder(24);
            paramOnClickListener.append(localPhoneContact.name).append(".").append(paramView).append(".");
            paramOnClickListener.append(ContactUtils.b(paramInt1));
            paramViewGroup.setContentDescription(paramOnClickListener);
          }
          label538:
          return paramViewGroup;
          paramOnClickListener = (BuddyListPhone.PhoneContactChildTag)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719501);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719503);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719507);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719513);
          continue;
          paramView = "";
          continue;
          if ((paramInt2 != 8) || ((localPhoneContact.abilityBits & 1L) != 0L)) {
            break label929;
          }
          if (localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi != 0) {
            paramInt1 = localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi;
          }
        }
      }
    }
    label787:
    label929:
    for (;;)
    {
      paramView = ContactUtils.a(paramInt1);
      break;
      paramInt1 = localPhoneContact.netTypeIconId;
      continue;
      paramInt2 = 0;
      break label313;
      label710:
      localObject = null;
      break label346;
      label716:
      paramInt2 = 0;
      break label371;
      label721:
      if (!TextUtils.isEmpty(paramView))
      {
        paramOnClickListener.c.setText("[" + paramView + "]");
        paramOnClickListener.c.setVisibility(0);
        break label385;
      }
      paramOnClickListener.c.setVisibility(8);
      break label385;
      if (((FriendsManager)localObject).a(localPhoneContact.unifiedCode, true))
      {
        paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701297));
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131701299));
        break label509;
      }
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689557));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setTag(localPhoneContact);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689557));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label509;
      paramOnClickListener.delete(0, paramOnClickListener.length());
      break label538;
      break;
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.BuddyListPhone
 * JD-Core Version:    0.7.0.1
 */