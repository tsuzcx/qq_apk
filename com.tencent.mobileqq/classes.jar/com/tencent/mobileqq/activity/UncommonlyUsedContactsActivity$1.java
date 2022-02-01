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
  
  public void onClick(View paramView, int paramInt)
  {
    if ((this.a.b instanceof Friends))
    {
      paramView = ((Friends)this.a.b).uin;
    }
    else
    {
      if (!(this.a.b instanceof PhoneContact)) {
        return;
      }
      paramView = ((PhoneContact)this.a.b).mobileCode;
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
            this.c.a(paramView);
            ReportController.b(this.c.app, "CliOper", "", "", "0X8004C54", "0X8004C54", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (NetworkUtil.isNetSupport(this.c.getActivity()))
          {
            if ((this.a.b instanceof Friends))
            {
              localObject = (FriendListHandler)this.c.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(paramView);
              ((FriendListHandler)localObject).gatherContacts((short)1, localArrayList, false);
            }
            else if ((this.a.b instanceof PhoneContact))
            {
              ((IPhoneContactService)this.c.app.getRuntimeService(IPhoneContactService.class, "")).hideContact(((PhoneContact)this.a.b).mobileCode, false);
            }
          }
          else {
            this.c.a(2131892158, 0);
          }
          ReportController.b(this.c.app, "CliOper", "", "", "0X8004C53", "0X8004C53", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if ((this.a.b instanceof Friends))
        {
          paramView = new AllInOne(paramView, 1);
          paramView.profileEntryType = 59;
          paramView.chatEntrance = 2;
        }
        else
        {
          paramView = (View)localObject;
          if ((this.a.b instanceof PhoneContact))
          {
            localObject = (PhoneContact)this.a.b;
            paramView = new AllInOne(((PhoneContact)localObject).mobileCode, 34);
            paramView.profileEntryType = 59;
            paramView.nickname = ((PhoneContact)localObject).name;
            paramView.chatEntrance = 2;
          }
        }
        ProfileUtils.openProfileCard(this.c.getActivity(), paramView);
        ReportController.b(this.c.app, "CliOper", "", "", "0X8004C52", "0X8004C52", 0, 0, "", "", "", "");
      }
    }
    else
    {
      localObject = AIOUtils.a(new Intent(this.c.getActivity(), SplashActivity.class), null);
      if ((this.a.b instanceof Friends))
      {
        ((Intent)localObject).putExtra("uintype", 0);
        ((Intent)localObject).putExtra("uin", paramView);
        ((Intent)localObject).putExtra("uinname", ContactUtils.g(this.c.app, paramView));
        ((Intent)localObject).putExtra("entrance", 2);
      }
      else if ((this.a.b instanceof PhoneContact))
      {
        ((Intent)localObject).putExtra("uintype", 1006);
        ((Intent)localObject).putExtra("uin", paramView);
        ((Intent)localObject).putExtra("uinname", ((PhoneContact)this.a.b).name);
        ((Intent)localObject).putExtra("entrance", 2);
      }
      this.c.startActivity((Intent)localObject);
      ReportController.b(this.c.app, "CliOper", "", "", "0X8004C51", "0X8004C51", 0, 0, "", "", "", "");
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */