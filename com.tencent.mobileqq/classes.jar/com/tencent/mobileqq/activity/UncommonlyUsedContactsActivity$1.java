package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class UncommonlyUsedContactsActivity$1
  implements ActionSheet.OnButtonClickListener
{
  UncommonlyUsedContactsActivity$1(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, UncommonlyUsedContactsActivity.ListItem paramListItem, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof Friends))
    {
      paramView = ((Friends)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a).uin;
    }
    else
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof PhoneContact)) {
        return;
      }
      paramView = ((PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a).mobileCode;
    }
    Object localObject = null;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C54", "0X8004C54", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity()))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof Friends))
            {
              localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(paramView);
              ((FriendListHandler)localObject).gatherContacts((short)1, localArrayList, false);
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof PhoneContact))
            {
              ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getRuntimeService(IPhoneContactService.class, "")).hideContact(((PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a).mobileCode, false);
            }
          }
          else {
            this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(2131694476, 0);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C53", "0X8004C53", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof Friends))
        {
          paramView = new AllInOne(paramView, 1);
          paramView.profileEntryType = 59;
          paramView.chatEntrance = 2;
        }
        else
        {
          paramView = (View)localObject;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof PhoneContact))
          {
            localObject = (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a;
            paramView = new AllInOne(((PhoneContact)localObject).mobileCode, 34);
            paramView.profileEntryType = 59;
            paramView.nickname = ((PhoneContact)localObject).name;
            paramView.chatEntrance = 2;
          }
        }
        ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C52", "0X8004C52", 0, 0, "", "", "", "");
      }
    }
    else
    {
      localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), SplashActivity.class), null);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof Friends))
      {
        ((Intent)localObject).putExtra("uintype", 0);
        ((Intent)localObject).putExtra("uin", paramView);
        ((Intent)localObject).putExtra("uinname", ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, paramView));
        ((Intent)localObject).putExtra("entrance", 2);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a instanceof PhoneContact))
      {
        ((Intent)localObject).putExtra("uintype", 1006);
        ((Intent)localObject).putExtra("uin", paramView);
        ((Intent)localObject).putExtra("uinname", ((PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$ListItem.a).name);
        ((Intent)localObject).putExtra("entrance", 2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C51", "0X8004C51", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */