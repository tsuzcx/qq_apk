package com.tencent.mobileqq.activity;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;

class FriendProfileCardActivity$5
  extends ProfileCardObserver
{
  FriendProfileCardActivity$5(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if ((CrmUtils.c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (QidianManager.b(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      CrmUtils.a(this.a, null, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, -1, true, -1);
      this.a.finish();
    }
    boolean bool2 = ProfileActivity.AllInOne.g(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = bool2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) {}
      }
      else
      {
        bool1 = false;
      }
    }
    Object localObject1;
    if (((paramObject instanceof Card)) && (bool1))
    {
      Card localCard = (Card)paramObject;
      bool2 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localCard.uin);
      bool1 = bool2;
      localObject1 = localObject2;
      paramObject = localCard;
      if ((localCard.lUserFlag & 1L) != 0L)
      {
        EnterpriseQQManager.a(this.a.app).a(this.a.app, localCard.uin, false);
        paramObject = localCard;
        localObject1 = localObject2;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardBySSOEnd", "initCardBySSOStart", false);
      if ((bool1) && (paramObject != null) && (paramBoolean))
      {
        localObject1 = (IQQAvatarHandlerService)this.a.app.getRuntimeService(IQQAvatarHandlerService.class, "");
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e == null) && (localObject1 != null)) {
          if (ProfileActivity.AllInOne.g(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            ((IQQAvatarHandlerService)localObject1).getCustomHead(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
            break label762;
          }
          localObject1 = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
          ((Message)localObject1).what = 8;
          ((Message)localObject1).obj = paramObject;
          this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject1);
          return;
          if (((paramObject instanceof ContactCard)) && (!bool1))
          {
            localObject1 = (ContactCard)paramObject;
            bool1 = Utils.a(((ContactCard)localObject1).mobileNo, this.a.a(FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)));
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((ContactCard)localObject1).mobileNo;
            paramObject = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
            if ((paramObject != null) && (paramObject.jdField_a_of_type_JavaUtilArrayList != null) && (paramObject.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
              ((ProfileActivity.CardContactInfo)paramObject.jdField_a_of_type_JavaUtilArrayList.get(0)).c = ((ContactCard)localObject1).mobileNo;
            }
            paramObject = null;
            break;
          }
          if ((paramObject instanceof String))
          {
            paramObject = (String)paramObject;
            if (bool1) {}
            for (bool1 = Utils.a(paramObject, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; bool1 = Utils.a(paramObject, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
            {
              paramObject = null;
              localObject1 = localObject2;
              break;
            }
          }
          if ((!(paramObject instanceof Card)) || (bool1)) {
            break label1220;
          }
          paramObject = (Card)paramObject;
          bool1 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o, paramObject.encId);
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramObject.uin;
          this.a.c = true;
          localObject1 = localObject2;
          break;
          if (localObject1 != null) {
            ((IQQAvatarHandlerService)localObject1).getCustomHead(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
        label762:
        break;
      }
      if ((bool1) && (localObject1 != null) && (paramBoolean))
      {
        paramObject = (IQQAvatarHandlerService)this.a.app.getRuntimeService(IQQAvatarHandlerService.class, "");
        if ((paramObject != null) && (!TextUtils.isEmpty(((ContactCard)localObject1).mobileNo))) {
          paramObject.getMobileQQHead(((ContactCard)localObject1).mobileNo);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = ((ContactCard)localObject1).bindQQ;
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k)) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
        }
        if (!TextUtils.isEmpty(((ContactCard)localObject1).nickName)) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ((ContactCard)localObject1).nickName;
        }
        paramObject = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
        {
          paramObject = paramObject.a(((ContactCard)localObject1).uin);
          if (paramObject != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramObject.remark;
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = ((ContactCard)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("ContactCard", 2, "contactCard .bindQQ = " + ((ContactCard)localObject1).bindQQ + " contactCard.uin  = " + ((ContactCard)localObject1).uin);
        }
        paramObject = Message.obtain();
        paramObject.what = 4;
        paramObject.obj = localObject1;
        paramObject.arg1 = 1;
        this.a.b.sendMessage(paramObject);
        return;
      }
      if ((paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != -1L)) {
        break;
      }
      QLog.e("Q.profilecard.FrdProfileCard", 1, "onCardDownload isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
      if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
        break;
      }
      paramObject = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
      paramObject.what = 8;
      paramObject.obj = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramObject);
      return;
      label1220:
      bool1 = false;
      paramObject = null;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.5
 * JD-Core Version:    0.7.0.1
 */