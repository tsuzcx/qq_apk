package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;

class AddFriendVerifyFragment$20
  extends ProfileCardObserver
{
  AddFriendVerifyFragment$20(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (AddFriendVerifyFragment.b(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      IProfileCardBusinessApi localIProfileCardBusinessApi = (IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class);
      Object localObject;
      if ((paramObject instanceof Card))
      {
        localObject = (Card)paramObject;
        if ((((Card)localObject).uin != null) && (((Card)localObject).uin.equals(AddFriendVerifyFragment.a(this.a))))
        {
          paramObject = localIProfileCardBusinessApi.makeSexAgeArea(this.a.getActivity(), ((Card)localObject).shGender, ((Card)localObject).age, ((Card)localObject).strCountry, ((Card)localObject).strProvince, ((Card)localObject).strCity);
          if (this.a.a != null) {
            paramObject = localIProfileCardBusinessApi.makeSexAgeArea(this.a.getActivity(), ((Card)localObject).shGender, 0, "", "", "");
          }
          if (!TextUtils.isEmpty(paramObject))
          {
            AddFriendVerifyFragment.b(this.a).setVisibility(0);
            AddFriendVerifyFragment.b(this.a).setText(paramObject);
          }
        }
      }
      else if ((paramObject instanceof ContactCard))
      {
        localObject = (ContactCard)paramObject;
        if ((((ContactCard)localObject).mobileNo != null) && (((ContactCard)localObject).mobileNo.equals(AddFriendVerifyFragment.a(this.a))))
        {
          paramObject = localIProfileCardBusinessApi.makeSexAgeArea(this.a.getActivity(), ((ContactCard)localObject).bSex, ((ContactCard)localObject).bAge, ((ContactCard)localObject).strCountry, ((ContactCard)localObject).strProvince, ((ContactCard)localObject).strCity);
          if (this.a.a != null) {
            paramObject = localIProfileCardBusinessApi.makeSexAgeArea(this.a.getActivity(), ((ContactCard)localObject).bSex, 0, "", "", "");
          }
          if (!TextUtils.isEmpty(paramObject))
          {
            AddFriendVerifyFragment.b(this.a).setVisibility(0);
            AddFriendVerifyFragment.b(this.a).setText(paramObject);
          }
        }
      }
      if (((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isQidianMaster(AddFriendVerifyFragment.a(this.a), AddFriendVerifyFragment.a(this.a))) {
        AddFriendVerifyFragment.b(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.20
 * JD-Core Version:    0.7.0.1
 */