package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import java.util.ArrayList;
import java.util.Iterator;

class UncommonlyUsedContactsActivity$3
  extends ProfileCardObserver
{
  UncommonlyUsedContactsActivity$3(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    Card localCard = null;
    if ((paramObject instanceof Card)) {
      localCard = (Card)paramObject;
    }
    int j = 0;
    int i = j;
    if (localCard != null)
    {
      i = j;
      if (!TextUtils.isEmpty(localCard.uin))
      {
        paramObject = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        UncommonlyUsedContactsActivity.ListItem localListItem;
        do
        {
          i = j;
          if (!paramObject.hasNext()) {
            break;
          }
          localListItem = (UncommonlyUsedContactsActivity.ListItem)paramObject.next();
        } while ((localListItem.a == null) || (!(localListItem.a instanceof Friends)) || (!localCard.uin.equals(((Friends)localListItem.a).uin)));
        i = 1;
      }
    }
    if (i != 0)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.3
 * JD-Core Version:    0.7.0.1
 */