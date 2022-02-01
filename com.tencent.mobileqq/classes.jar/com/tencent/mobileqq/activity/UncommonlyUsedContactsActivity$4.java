package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import java.util.List;

class UncommonlyUsedContactsActivity$4
  extends FriendListObserver
{
  UncommonlyUsedContactsActivity$4(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
      return;
    }
    this.a.a(2131718794, 1);
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.a(2131691465, 2);
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean3))
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.4
 * JD-Core Version:    0.7.0.1
 */