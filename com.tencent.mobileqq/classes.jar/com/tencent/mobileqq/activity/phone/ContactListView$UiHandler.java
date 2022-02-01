package com.tencent.mobileqq.activity.phone;

import android.os.Message;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;

class ContactListView$UiHandler
  extends MqqHandler
{
  private WeakReference<ContactListView> a;
  
  public ContactListView$UiHandler(ContactListView paramContactListView)
  {
    this.a = new WeakReference(paramContactListView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (ContactListView)this.a.get();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactListView", 2, "UiHandler() handleMessage a == null");
      }
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6)
            {
              if (i == 8)
              {
                ((ContactListView)localObject1).j();
                ((ContactListView)localObject1).l();
                return;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Unknown message: ");
              ((StringBuilder)localObject1).append(paramMessage.what);
              throw new RuntimeException(((StringBuilder)localObject1).toString());
            }
            ContactListView.a((ContactListView)localObject1, (QQPimTipsInfo)paramMessage.obj);
            return;
          }
          paramMessage = ContactListView.b((ContactListView)localObject1).getAccount();
          Object localObject2 = (TicketManagerImpl)ContactListView.b((ContactListView)localObject1).getManager(2);
          if (localObject2 == null) {
            return;
          }
          localObject2 = ((TicketManagerImpl)localObject2).getA2(paramMessage);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("a2 = ");
            localStringBuilder.append((String)localObject2);
            QLog.i("ContactListView", 2, localStringBuilder.toString());
          }
          QQPimGetTipsInfoIPC.a().a(ContactListView.b((ContactListView)localObject1), ContactListView.c((ContactListView)localObject1), paramMessage, (String)localObject2);
          return;
        }
        ((ContactListView)localObject1).p = ((List)paramMessage.obj);
        ((ContactListView)localObject1).q.a(((ContactListView)localObject1).p);
        ((ContactListView)localObject1).q.notifyDataSetChanged();
        return;
      }
      ((ContactListView)localObject1).k();
      if (!NetworkUtil.isNetSupport(((ContactListView)localObject1).getContext()))
      {
        ((ContactListView)localObject1).j();
        ((ContactListView)localObject1).a(HardCodeUtil.a(2131900658));
      }
    }
    else
    {
      if ((ContactListView.a((ContactListView)localObject1)) && (!((ContactListView)localObject1).e.isAutoUploadContacts()))
      {
        ((ContactListView)localObject1).h();
        ContactListView.a((ContactListView)localObject1, false);
      }
      ((ContactListView)localObject1).k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.UiHandler
 * JD-Core Version:    0.7.0.1
 */