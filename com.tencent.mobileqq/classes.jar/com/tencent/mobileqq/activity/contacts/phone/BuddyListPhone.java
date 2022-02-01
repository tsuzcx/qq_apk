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
    paramOnClickListener = this.d;
    Object localObject1 = "";
    Object localObject2 = (IPhoneContactService)paramOnClickListener.getRuntimeService(IPhoneContactService.class, "");
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListPhone.PhoneContactChildTag)))
    {
      paramOnClickListener = (BuddyListPhone.PhoneContactChildTag)paramView.getTag();
      paramViewGroup = paramView;
    }
    else
    {
      paramViewGroup = LayoutInflater.from(this.e).inflate(2131624556, paramViewGroup, false);
      paramOnClickListener = new BuddyListPhone.PhoneContactChildTag();
      paramOnClickListener.r = ((ImageView)paramViewGroup.findViewById(2131435219));
      paramOnClickListener.a = ((SingleLineTextView)paramViewGroup.findViewById(2131447063));
      paramOnClickListener.d = ((SingleLineTextView)paramViewGroup.findViewById(2131448627));
      paramOnClickListener.e = ((ImageView)paramViewGroup.findViewById(2131436608));
      paramOnClickListener.g = ((Button)paramViewGroup.findViewById(2131444718));
      paramOnClickListener.h = ((TextView)paramViewGroup.findViewById(2131444726));
      paramViewGroup.setTag(paramOnClickListener);
      a(paramViewGroup.findViewById(2131435219));
    }
    PhoneContact localPhoneContact = (PhoneContact)this.f;
    paramOnClickListener.c = localPhoneContact;
    paramOnClickListener.p = localPhoneContact.mobileCode;
    int i = OnlineStatusUtils.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
    Object localObject3 = (FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
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
        paramView = this.e.getString(2131916781);
        paramInt1 = paramInt2;
      }
      break;
    case 7: 
      paramView = this.e.getString(2131916777);
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
      paramView = this.e.getString(2131916783);
      paramInt1 = paramInt2;
      break;
    case 2: 
      paramView = this.e.getString(2131916773);
      paramInt1 = paramInt2;
      break;
    case 1: 
      paramView = this.e.getString(2131916771);
      paramInt1 = paramInt2;
    }
    if ((i != 0) && (i != 6)) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if ((((IPhoneContactService)localObject2).getUIBits() & 0x8) != 8L)
    {
      localObject1 = g();
      localObject3 = paramOnClickListener.r;
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
      paramOnClickListener.d.setVisibility(8);
    }
    else if (!TextUtils.isEmpty(paramView))
    {
      localObject1 = paramOnClickListener.d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramView);
      ((StringBuilder)localObject2).append("]");
      ((SingleLineTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      paramOnClickListener.d.setVisibility(0);
    }
    else
    {
      paramOnClickListener.d.setVisibility(8);
    }
    paramOnClickListener.e.setVisibility(8);
    paramOnClickListener.a.setTextColor(a(this.e, 2131168001));
    paramOnClickListener.a.setText(localPhoneContact.name);
    localObject1 = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0")))
    {
      paramOnClickListener.g.setVisibility(8);
      paramOnClickListener.h.setVisibility(0);
      paramOnClickListener.h.setText(HardCodeUtil.a(2131899460));
      paramOnClickListener.h.setContentDescription(HardCodeUtil.a(2131899463));
    }
    else if (((FriendsManager)localObject1).b(localPhoneContact.unifiedCode, true))
    {
      paramOnClickListener.g.setVisibility(8);
      paramOnClickListener.h.setVisibility(0);
      paramOnClickListener.h.setText(HardCodeUtil.a(2131899462));
      paramOnClickListener.h.setContentDescription(HardCodeUtil.a(2131899464));
    }
    else
    {
      paramOnClickListener.g.setVisibility(0);
      paramOnClickListener.g.setText(HardCodeUtil.a(2131886199));
      paramOnClickListener.g.setTag(localPhoneContact);
      paramOnClickListener.g.setContentDescription(HardCodeUtil.a(2131886199));
      paramOnClickListener.h.setVisibility(8);
    }
    if (AppSetting.e)
    {
      paramOnClickListener = paramOnClickListener.f;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.BuddyListPhone
 * JD-Core Version:    0.7.0.1
 */