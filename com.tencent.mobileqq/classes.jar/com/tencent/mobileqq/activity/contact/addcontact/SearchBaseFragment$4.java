package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.record;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;

class SearchBaseFragment$4
  extends FriendListObserver
{
  SearchBaseFragment$4(SearchBaseFragment paramSearchBaseFragment) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && (SearchBaseFragment.a(this.a) != null) && (SearchBaseFragment.a(this.a).uin.get() == ((Long)paramObject).longValue())) {
      SearchBaseFragment.a(this.a).relation.set(SearchBaseFragment.a(this.a).relation.get() & 0x10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */