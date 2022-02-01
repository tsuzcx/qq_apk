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
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
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
    paramOnClickListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = "";
    Object localObject2 = (IPhoneContactService)paramOnClickListener.getRuntimeService(IPhoneContactService.class, "");
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListPhone.PhoneContactChildTag)))
    {
      paramOnClickListener = (BuddyListPhone.PhoneContactChildTag)paramView.getTag();
      paramViewGroup = paramView;
    }
    else
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558926, paramViewGroup, false);
      paramOnClickListener = new BuddyListPhone.PhoneContactChildTag();
      paramOnClickListener.d = ((ImageView)paramViewGroup.findViewById(2131368343));
      paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131378461));
      paramOnClickListener.c = ((SingleLineTextView)paramViewGroup.findViewById(2131379798));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369520));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131376477));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376485));
      paramViewGroup.setTag(paramOnClickListener);
      a(paramViewGroup.findViewById(2131368343));
    }
    PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
    paramOnClickListener.jdField_a_of_type_JavaLangObject = localPhoneContact;
    paramOnClickListener.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
    int i = OnlineStatusUtils.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
    Object localObject3 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    paramInt2 = localPhoneContact.netTypeIconId;
    paramInt1 = paramInt2;
    paramView = (View)localObject1;
    switch (i)
    {
    case 5: 
    default: 
      localObject1 = ((FriendListHandler)localObject3).getOfflineTipsConfig(((IPhoneContactService)localObject2).getLastLoginType(localPhoneContact.unifiedCode));
      paramInt1 = paramInt2;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719229);
        paramInt1 = paramInt2;
      }
      break;
    case 7: 
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719225);
      paramInt1 = paramInt2;
      break;
    case 4: 
    case 8: 
      paramInt1 = paramInt2;
      if (i == 8)
      {
        paramInt1 = paramInt2;
        if ((localPhoneContact.abilityBits & 1L) == 0L) {
          if (localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi != 0) {
            paramInt1 = localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi;
          } else {
            paramInt1 = localPhoneContact.netTypeIconId;
          }
        }
      }
      paramView = ContactUtils.a(paramInt1);
      break;
    case 3: 
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719231);
      paramInt1 = paramInt2;
      break;
    case 2: 
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719221);
      paramInt1 = paramInt2;
      break;
    case 1: 
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719219);
      paramInt1 = paramInt2;
    }
    if ((i != 0) && (i != 6)) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if ((((IPhoneContactService)localObject2).getUIBits() & 0x8) != 8L)
    {
      localObject1 = a();
      localObject3 = paramOnClickListener.d;
      if (paramInt2 == 0) {
        localObject1 = null;
      }
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
    }
    if ((((IPhoneContactService)localObject2).getUIBits() & 0x4) == 4L) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      paramOnClickListener.c.setVisibility(8);
    }
    else if (!TextUtils.isEmpty(paramView))
    {
      localObject1 = paramOnClickListener.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramView);
      ((StringBuilder)localObject2).append("]");
      ((SingleLineTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      paramOnClickListener.c.setVisibility(0);
    }
    else
    {
      paramOnClickListener.c.setVisibility(8);
    }
    paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
    paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localPhoneContact.name);
    localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0")))
    {
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701435));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131701438));
    }
    else if (((FriendsManager)localObject1).a(localPhoneContact.unifiedCode, true))
    {
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701437));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131701439));
    }
    else
    {
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setTag(localPhoneContact);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689589));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (AppSetting.d)
    {
      paramOnClickListener = paramOnClickListener.jdField_a_of_type_JavaLangStringBuilder;
      if (paramOnClickListener == null) {
        paramOnClickListener = new StringBuilder(24);
      } else {
        paramOnClickListener.delete(0, paramOnClickListener.length());
      }
      paramOnClickListener.append(localPhoneContact.name);
      paramOnClickListener.append(".");
      paramOnClickListener.append(paramView);
      paramOnClickListener.append(".");
      paramOnClickListener.append(ContactUtils.b(paramInt1));
      paramViewGroup.setContentDescription(paramOnClickListener);
    }
    return paramViewGroup;
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.BuddyListPhone
 * JD-Core Version:    0.7.0.1
 */