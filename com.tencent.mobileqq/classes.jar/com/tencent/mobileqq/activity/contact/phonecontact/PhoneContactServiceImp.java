package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.api.inject.IPhoneContactService;
import com.tencent.mobileqq.model.PhoneContactManager;

public class PhoneContactServiceImp
  implements IPhoneContactService
{
  public String a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (PhoneContactManager)paramAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.a(paramString);
      if (paramAppInterface != null) {
        return paramAppInterface.name;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactServiceImp
 * JD-Core Version:    0.7.0.1
 */