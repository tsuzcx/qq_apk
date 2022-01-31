package com.tencent.mobileqq.adapter.contacts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.SingleLineTextView;
import yiw;

public class BuddyListPhone
  extends BuddyListItem
{
  protected BuddyListPhone(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    PhoneContact localPhoneContact;
    if ((paramView == null) || (!(paramView.getTag() instanceof yiw)))
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968817, paramViewGroup, false);
      paramOnClickListener = new yiw();
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362719));
      paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131363896));
      paramOnClickListener.c = ((SingleLineTextView)paramViewGroup.findViewById(2131363898));
      paramOnClickListener.b = ((ImageView)paramViewGroup.findViewById(2131363885));
      paramViewGroup.setTag(paramOnClickListener);
      localPhoneContact = (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramOnClickListener.jdField_a_of_type_JavaLangObject = localPhoneContact;
      paramOnClickListener.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      paramInt2 = ContactUtils.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      paramInt1 = localPhoneContact.netTypeIconId;
    }
    label269:
    Drawable localDrawable;
    switch (paramInt2)
    {
    case 5: 
    case 6: 
    default: 
      paramView = paramView.a(localPhoneContactManagerImp.a(localPhoneContact.unifiedCode));
      if (paramView == null) {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436026);
      }
      break;
    case 1: 
    case 2: 
    case 7: 
    case 3: 
    case 4: 
    case 8: 
      for (;;)
      {
        if ((paramInt2 == 0) || (paramInt2 == 6))
        {
          paramInt2 = 1;
          if ((localPhoneContactManagerImp.e & 0x8) != 8L)
          {
            localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842368);
            ImageView localImageView = paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt2 == 0) {
              break label583;
            }
            label310:
            localImageView.setImageDrawable(localDrawable);
          }
          paramViewGroup.setBackgroundResource(2130838587);
          paramViewGroup.setPadding(0, 0, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
          if ((localPhoneContactManagerImp.e & 0x4) != 4L) {
            break label589;
          }
          paramInt2 = 1;
          label360:
          if (paramInt2 == 0) {
            break label594;
          }
          paramOnClickListener.c.setVisibility(8);
          label374:
          paramOnClickListener.b.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494219));
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localPhoneContact.name);
          if (AppSetting.b)
          {
            paramOnClickListener = paramOnClickListener.jdField_a_of_type_JavaLangStringBuilder;
            if (paramOnClickListener != null) {
              break label638;
            }
            paramOnClickListener = new StringBuilder(24);
            label443:
            paramOnClickListener.append(localPhoneContact.name).append(".").append(paramView).append(".");
            paramOnClickListener.append(ContactUtils.b(paramInt1));
            paramViewGroup.setContentDescription(paramOnClickListener);
          }
          return paramViewGroup;
          paramOnClickListener = (yiw)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436021);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436022);
          continue;
          if ((paramInt2 != 8) || ((localPhoneContact.abilityBits & 1L) != 0L)) {
            break label656;
          }
          if (localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi != 0) {
            paramInt1 = localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi;
          }
        }
      }
    }
    label656:
    for (;;)
    {
      paramView = ContactUtils.a(paramInt1);
      break;
      paramInt1 = localPhoneContact.netTypeIconId;
      continue;
      paramInt2 = 0;
      break label269;
      label583:
      localDrawable = null;
      break label310;
      label589:
      paramInt2 = 0;
      break label360;
      label594:
      paramOnClickListener.c.setText("[" + paramView + "]");
      paramOnClickListener.c.setVisibility(0);
      break label374;
      label638:
      paramOnClickListener.delete(0, paramOnClickListener.length());
      break label443;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.contacts.BuddyListPhone
 * JD-Core Version:    0.7.0.1
 */