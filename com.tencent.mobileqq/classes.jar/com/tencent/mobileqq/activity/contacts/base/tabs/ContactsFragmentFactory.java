package com.tencent.mobileqq.activity.contacts.base.tabs;

import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment;
import com.tencent.mobileqq.activity.contacts.device.DeviceFragment;
import com.tencent.mobileqq.activity.contacts.friend.FriendFragment;
import com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment;
import com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;

public class ContactsFragmentFactory
{
  public static ContactsBaseFragment a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new FriendFragment();
      break;
    case 6: 
      localObject = new AlphabetFriendFragment();
      break;
    case 5: 
      localObject = new PublicAccountFragment();
      break;
    case 4: 
      localObject = new PhoneContactFragment();
      break;
    case 3: 
      localObject = new DeviceFragment();
      break;
    case 2: 
      localObject = new TroopFragment();
      break;
    case 1: 
      localObject = new FriendFragment();
      break;
    case 0: 
      localObject = new RecommendFriendFragment();
    }
    ((ContactsBaseFragment)localObject).d(paramInt);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsFragmentFactory
 * JD-Core Version:    0.7.0.1
 */