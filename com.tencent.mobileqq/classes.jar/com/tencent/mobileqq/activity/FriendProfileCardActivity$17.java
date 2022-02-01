package com.tencent.mobileqq.activity;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class FriendProfileCardActivity$17
  implements Handler.Callback
{
  FriendProfileCardActivity$17(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "SUBTHREAD_MSG_INIT_CARD");
      }
      paramMessage = (String)paramMessage.obj;
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardByDbStart", true);
      Object localObject1 = ProfileCardUtil.a(this.a.app, paramMessage);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardByDbEnd", "initCardByDbStart", false);
      if ((localObject1 != null) && (localObject2 != null))
      {
        if ((((FriendsManager)localObject2).b(((Card)localObject1).uin)) && (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
        this.a.a((Card)localObject1, false, 1);
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardBySSOStart", true);
        localObject2 = ((Card)localObject1).vSeed;
        paramMessage = null;
        label304:
        label375:
        Object localObject3;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57))
        {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
          this.a.a(((Card)localObject1).feedPreviewTime, (byte[])localObject2, paramMessage, false);
          if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
            continue;
          }
          paramMessage = this.a.app.getCurrentAccountUin();
          localObject2 = new StringBuilder().append("");
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label523;
          }
          i = 1;
          localObject2 = i;
          localObject3 = new StringBuilder().append("");
          if (((Card)localObject1).lCurrentStyleId <= 0L) {
            break label528;
          }
        }
        label523:
        label528:
        for (int i = 2;; i = 1)
        {
          VasWebviewUtil.reportCommercialDrainage(paramMessage, "group_card", "show", "", 0, 0, 0, "", "", (String)localObject2, i, "", "", "", 0, 0, 0, 0);
          break;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
            break label304;
          }
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte;
          break label304;
          i = 2;
          break label375;
        }
        paramMessage = this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        if ((localObject2 != null) && (paramMessage != null) && (paramMessage.length() > 0))
        {
          localObject1 = (IProfileDataService)this.a.app.getRuntimeService(IProfileDataService.class, "all");
          paramMessage = ((IProfileDataService)localObject1).getContactCardByMobileNo(paramMessage, true);
          localObject3 = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (localObject3 != null)
          {
            paramMessage.nationCode = ((ProfileActivity.CardContactInfo)localObject3).b;
            paramMessage.mobileCode = ((ProfileActivity.CardContactInfo)localObject3).c;
            paramMessage.strContactName = ((ProfileActivity.CardContactInfo)localObject3).jdField_a_of_type_JavaLangString;
          }
          if ((paramMessage.nickName == null) || (paramMessage.nickName.length() == 0)) {
            paramMessage.nickName = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
          }
          ((IProfileDataService)localObject1).saveContactCard(paramMessage);
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Boolean = paramMessage.bindQQ;
          if (!TextUtils.isEmpty(paramMessage.uin))
          {
            localObject1 = ((FriendsManager)localObject2).e(paramMessage.uin);
            if (localObject1 != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = ((Friends)localObject1).remark;
            }
          }
          this.a.a(paramMessage, false);
          FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramMessage;
          ((Message)localObject1).arg1 = 0;
          this.a.b.sendMessage((Message)localObject1);
          this.a.a(0L, null, null, false);
          continue;
          try
          {
            if ((paramMessage.arg1 == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!ProfileCardTemplate.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))) {
              this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
            }
            if (paramMessage.arg2 == 1) {
              this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, true, 13);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("FriendProfileCardActivity", 1, "handle SUBTHREAD_MSG_DOWNLOAD_RES fail.", localException);
            }
            this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, 7);
          }
          continue;
          if ((paramMessage.obj instanceof Card))
          {
            this.a.a((Card)paramMessage.obj, true, 8);
          }
          else
          {
            this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, true, 8);
            continue;
            if ((this.a.app != null) && (localObject2 != null))
            {
              paramMessage = ((FriendsManager)localObject2).a(this.a.app.getCurrentAccountUin());
              if (paramMessage != null) {
                this.a.a(paramMessage.feedPreviewTime, paramMessage.vSeed, null, false);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.17
 * JD-Core Version:    0.7.0.1
 */