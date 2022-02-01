package com.tencent.mobileqq.activity.contacts.device;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ContactsDeviceAdapter$1
  implements QQPermissionCallback
{
  ContactsDeviceAdapter$1(ContactsDeviceAdapter paramContactsDeviceAdapter, View paramView, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.b);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ContactsDeviceAdapter.a(this.c, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.ContactsDeviceAdapter.1
 * JD-Core Version:    0.7.0.1
 */