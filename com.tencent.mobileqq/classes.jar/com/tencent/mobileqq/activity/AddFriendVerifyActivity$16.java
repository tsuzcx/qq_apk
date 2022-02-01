package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qidian.QidianManager;

class AddFriendVerifyActivity$16
  extends ProfileCardObserver
{
  AddFriendVerifyActivity$16(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      Object localObject;
      if ((paramObject instanceof Card))
      {
        localObject = (Card)paramObject;
        if ((((Card)localObject).uin != null) && (((Card)localObject).uin.equals(AddFriendVerifyActivity.a(this.a))))
        {
          paramObject = ProfileCardUtil.a(this.a, ((Card)localObject).shGender, ((Card)localObject).age, ((Card)localObject).strCountry, ((Card)localObject).strProvince, ((Card)localObject).strCity);
          if (this.a.a != null) {
            paramObject = ProfileCardUtil.a(this.a, ((Card)localObject).shGender, 0, "", "", "");
          }
          if (!TextUtils.isEmpty(paramObject))
          {
            this.a.c.setVisibility(0);
            this.a.c.setText(paramObject);
          }
        }
      }
      else if ((paramObject instanceof ContactCard))
      {
        localObject = (ContactCard)paramObject;
        if ((((ContactCard)localObject).mobileNo != null) && (((ContactCard)localObject).mobileNo.equals(AddFriendVerifyActivity.a(this.a))))
        {
          paramObject = ProfileCardUtil.a(this.a, ((ContactCard)localObject).bSex, ((ContactCard)localObject).bAge, ((ContactCard)localObject).strCountry, ((ContactCard)localObject).strProvince, ((ContactCard)localObject).strCity);
          if (this.a.a != null) {
            paramObject = ProfileCardUtil.a(this.a, ((ContactCard)localObject).bSex, 0, "", "", "");
          }
          if (!TextUtils.isEmpty(paramObject))
          {
            this.a.c.setVisibility(0);
            this.a.c.setText(paramObject);
          }
        }
      }
      if (QidianManager.a(this.a.app, AddFriendVerifyActivity.a(this.a))) {
        this.a.c.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.16
 * JD-Core Version:    0.7.0.1
 */