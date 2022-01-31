package com.tencent.mobileqq.activity.contacts.fragment;

public class ContactsFragmentFactory
{
  public static ContactsBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new FriendFragment();
    case 0: 
      return new FriendFragment();
    case 1: 
      return new TroopFragment();
    case 4: 
      return new PublicAccountFragment();
    case 2: 
      return new DeviceFragment();
    }
    return new PhoneContactFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.ContactsFragmentFactory
 * JD-Core Version:    0.7.0.1
 */