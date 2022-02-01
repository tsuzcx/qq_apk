package com.tencent.mobileqq.activity.contacts.device;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ContactsDeviceAdapter$2
  implements QQPermissionCallback
{
  ContactsDeviceAdapter$2(ContactsDeviceAdapter paramContactsDeviceAdapter, View paramView, Friends paramFriends, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ContactsDeviceAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsDeviceContactsDeviceAdapter, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.ContactsDeviceAdapter.2
 * JD-Core Version:    0.7.0.1
 */