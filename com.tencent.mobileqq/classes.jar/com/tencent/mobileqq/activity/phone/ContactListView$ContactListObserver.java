package com.tencent.mobileqq.activity.phone;

import android.widget.TextView;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ContactListView$ContactListObserver
  extends ContactBindObserver
{
  private ContactListView$ContactListObserver(ContactListView paramContactListView) {}
  
  protected void onHideContact(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHideContact isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ContactListView", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.c == 5)) {
      this.a.k();
    }
  }
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.a.e.getSelfBindState();
    if (!paramBoolean1)
    {
      this.a.j();
      this.a.h();
      if (((i == 0) || (i == 7)) && ((this.a.c != 2) || (!(this.a.t instanceof ForwardShareCardOption))) && (this.a.n == 0)) {
        this.a.a(2131915700, 3000L);
      }
    }
    else
    {
      this.a.g.setEnabled(true);
      if (this.a.e.isAutoUploadContacts()) {
        this.a.a(2131916272, 0L, false);
      }
    }
  }
  
  protected void onQueryContactList(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.j();
      ContactListView.a(this.a, true);
      if ((paramInt & 0x1) == 0) {
        this.a.h();
      }
    }
    else
    {
      this.a.h();
    }
    if (this.a.c == 6) {
      this.a.g();
    }
  }
  
  protected void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!NetworkUtil.isNetSupport(this.a.getContext())))
    {
      this.a.j();
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.ContactListObserver
 * JD-Core Version:    0.7.0.1
 */