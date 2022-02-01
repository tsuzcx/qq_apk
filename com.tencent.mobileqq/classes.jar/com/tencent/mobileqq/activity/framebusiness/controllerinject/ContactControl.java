package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.activity.contacts.base.Contacts;

public class ContactControl
  implements BaseTabControl
{
  public boolean a(String paramString)
  {
    return Contacts.class.getName().equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.ContactControl
 * JD-Core Version:    0.7.0.1
 */