package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class BabyQIPCModule
  extends QIPCModule
{
  private static volatile BabyQIPCModule jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new BabyQIPCModule.1(this);
  Card jdField_a_of_type_ComTencentMobileqqDataCard = null;
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new BabyQIPCModule.2(this);
  private ConcurrentHashMap<String, Bundle> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_a_of_type_Boolean = false;
  
  public BabyQIPCModule(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[8];
  }
  
  public static BabyQIPCModule a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule = new BabyQIPCModule("BabyQIPCModule");
      }
      return jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule;
    }
    finally {}
  }
  
  EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    int i;
    int j;
    label80:
    boolean bool;
    label232:
    long l;
    if ((localCardHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (NetworkUtil.d(BaseApplication.getContext()))) {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt <= 0)
      {
        i = 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt > 0)) {
          break label374;
        }
        j = 1;
        if ((i != 0) || (j != 0)) {
          break label400;
        }
        Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
        localCard.lVoteCount += 1L;
        this.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted = 1;
        localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
        localCard.bAvailVoteCnt = ((short)(localCard.bAvailVoteCnt - 1));
        localCardHandler.a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a).longValue(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, 1, 0);
        bool = ((NearbyLikeLimitManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin).longValue());
        if (PraiseManager.a(paramQQAppInterface) <= 0) {
          break label385;
        }
        if (!bool) {
          break label380;
        }
        i = 3;
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 1, 1, i, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)), String.valueOf(1), paramQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
        l = 0L;
      }
    }
    for (;;)
    {
      QLog.i("BabyQIPCModule", 1, "babyqWeb vote, card.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt + ",card.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strVoteLimitedNotice);
      paramBundle.putLong("key_request_zan_vote_result", l);
      return EIPCResult.createSuccessResult(paramBundle);
      i = 0;
      break;
      label374:
      j = 0;
      break label80;
      label380:
      i = 2;
      break label232;
      label385:
      if (bool)
      {
        i = 1;
        break label232;
      }
      i = 0;
      break label232;
      label400:
      l = 1L;
      continue;
      l = 2L;
    }
  }
  
  EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramQQAppInterface != null) {
        break label75;
      }
    }
    label75:
    for (paramQQAppInterface = null;; paramQQAppInterface = paramQQAppInterface.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
    {
      if (paramQQAppInterface != null)
      {
        paramBundle.putString("friendUin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        paramBundle.putByte("mgid", (byte)paramQQAppInterface.groupid);
      }
      if (paramInt == -1) {
        break;
      }
      a(paramString1, paramInt, paramString2);
      return null;
    }
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("setFriendGrouping") != null)
    {
      localBundle = new Bundle();
      localObject2 = (Bundle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("setFriendGrouping");
      localObject1 = ((Bundle)localObject2).getString("key_js_callback_id");
      i = ((Bundle)localObject2).getInt("key_process_callback_id");
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localBundle.putString("key_method_action", "setFriendGrouping");
        localBundle.putString("web_js_call_back_id", (String)localObject1);
        localObject2 = (FriendsManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject2 != null) {
          break label194;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((FriendsManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
          if (localObject1 != null) {
            localBundle.putString("key_handle_set_get_group", ((Groups)localObject1).group_name);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove("setFriendGrouping");
      callbackResult(i, EIPCResult.createSuccessResult(localBundle));
    }
    label194:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        Bundle localBundle;
        Object localObject2;
        int i;
        return;
        Object localObject1 = ((FriendsManager)localObject2).e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      }
    }
    QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
  }
  
  void a(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_process_callback_id", paramInt);
    localBundle.putString("key_js_callback_id", paramString2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localBundle);
  }
  
  public void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("BabyQIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, (byte)2);
      MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a));
      }
      localMqqHandler = paramQQAppInterface.getHandler(ChatSettingActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a));
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
      return EIPCResult.createSuccessResult(paramBundle);
    }
    return EIPCResult.createResult(-102, paramBundle);
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb BabyQFriendStatusWebPlugin init ");
    }
    Object localObject = (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCard = ProfileCardUtil.a(localQQAppInterface, AppConstants.BABY_Q_UIN);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    }
    CardHandler localCardHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localObject != null))
    {
      if (!((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin)) {
        break label166;
      }
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)localObject);
      localCardHandler = (CardHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localCardHandler != null) {
        break label186;
      }
    }
    label166:
    label186:
    do
    {
      return;
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 19);
      break;
      long l = ProfileActivity.a((ProfileActivity.AllInOne)localObject, false);
      localCardHandler.a(localQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)1);
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(localQQAppInterface, TempGetProfileDetailProcessor.class);
    } while (localObject == null);
    ((TempGetProfileDetailProcessor)localObject).getBabyQSwitch();
  }
  
  EIPCResult c(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    FriendsManager localFriendsManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
    {
      localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null) {
        break label105;
      }
    }
    label105:
    for (paramQQAppInterface = null;; paramQQAppInterface = localFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
    {
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = localFriendsManager.a(String.valueOf(paramQQAppInterface.groupid));
        if (paramQQAppInterface != null)
        {
          paramBundle.putString("key_handle_set_get_group", paramQQAppInterface.group_name);
          QLog.i("BabyQIPCModule", 1, "babyqWeb get group =" + paramQQAppInterface.group_name);
        }
      }
      return EIPCResult.createSuccessResult(paramBundle);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("BabyQIPCModule", 1, "babyqWeb action = " + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
      b();
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = null;
    if (paramBundle != null) {
      str = paramBundle.getString("web_js_call_back_id");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_method_action", paramString);
    localBundle.putString("web_js_call_back_id", str);
    if (paramString.equals("getFriendStatus"))
    {
      paramString = (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramString == null) {
        break label571;
      }
    }
    label563:
    label565:
    label571:
    for (boolean bool = paramString.b(AppConstants.BABY_Q_UIN);; bool = false)
    {
      if (bool) {}
      for (long l = 1L;; l = 0L)
      {
        localBundle.putLong("key_get_friend_status", l);
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("getZanVoteCount"))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          localBundle.putLong("key_get_zan_vote_count", this.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount);
        }
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("requestZan")) {
        return a(localQQAppInterface, localBundle);
      }
      if (paramString.equals("addFriend")) {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
      }
      do
      {
        return null;
        if (paramString.equals("sendmsg"))
        {
          localBundle.putParcelable("key_parcel_allinone", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          return EIPCResult.createSuccessResult(localBundle);
        }
        if (paramString.equals("deleteFriend")) {
          return b(localQQAppInterface, localBundle);
        }
        if (paramString.equals("getFriendGrouping")) {
          return c(localQQAppInterface, localBundle);
        }
        if (paramString.equals("setFriendGrouping")) {
          return a(localQQAppInterface, localBundle, paramString, paramInt, str);
        }
        if (paramString.equals("reportFriend"))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
          try
          {
            localBundle.putString("key_report_msg", NewReportPlugin.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, "", 21001, null));
            return EIPCResult.createSuccessResult(localBundle);
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              QLog.e("BabyQIPCModule", 1, "babyqWeb getReportMsg Exception", paramString);
            }
          }
        }
        if (paramString.equals("getPushStatus"))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.babyQSwitch) {}
          for (l = 1L;; l = 0L)
          {
            localBundle.putLong("key_request_zan_vote_result", l);
            return EIPCResult.createSuccessResult(localBundle);
          }
        }
      } while (!paramString.equals("setPushStatus"));
      if (paramBundle != null)
      {
        l = paramBundle.getLong("key_push_status", 0L);
        label492:
        if (!NetworkUtil.d(BaseApplication.getContext())) {
          break label563;
        }
        paramString = (CardHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (l != 1L) {
          break label565;
        }
      }
      for (bool = true;; bool = false)
      {
        paramString.m(bool);
        QLog.i("BabyQIPCModule", 1, "babyqWeb set babyQSwitch = " + l);
        break;
        l = 0L;
        break label492;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQIPCModule
 * JD-Core Version:    0.7.0.1
 */