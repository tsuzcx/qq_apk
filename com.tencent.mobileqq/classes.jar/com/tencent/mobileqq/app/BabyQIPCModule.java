package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
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
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo = new ProfileCardInfo();
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new BabyQIPCModule.2(this);
  private ConcurrentHashMap<String, Bundle> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_a_of_type_Boolean = false;
  
  public BabyQIPCModule(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.nameArray = new String[8];
  }
  
  public static BabyQIPCModule a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule == null) {
          jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule = new BabyQIPCModule("BabyQIPCModule");
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqAppBabyQIPCModule;
  }
  
  FriendsManager a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    }
    return null;
  }
  
  QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    long l1;
    if ((localCardHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card != null) && (NetworkUtil.isNetSupport(BaseApplication.getContext())))
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.bAvailVoteCnt <= 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.bHaveVotedCnt <= 0) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.bAvailVoteCnt <= 0)) {
        j = 1;
      } else {
        j = 0;
      }
      long l2 = 1L;
      l1 = l2;
      if (i == 0)
      {
        l1 = l2;
        if (j == 0)
        {
          Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
          localCard.lVoteCount += 1L;
          localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
          localCard.bVoted = 1;
          localCard.bAvailVoteCnt = ((short)(localCard.bAvailVoteCnt - 1));
          localCardHandler.a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.vCookies, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.favoriteSource, 1, 0);
          boolean bool = NearbyManagerHelper.a(paramQQAppInterface).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.uin).longValue());
          if (PraiseManager.a(paramQQAppInterface) > 0)
          {
            if (bool) {
              i = 3;
            } else {
              i = 2;
            }
          }
          else if (bool) {
            i = 1;
          } else {
            i = 0;
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 1, 1, i, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.profileEntryType)), String.valueOf(1), paramQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.uin);
          l1 = 0L;
        }
      }
    }
    else
    {
      l1 = 2L;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("babyqWeb vote, card.bAvailVoteCnt = ");
    paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.bAvailVoteCnt);
    paramQQAppInterface.append(",card.bHaveVotedCnt = ");
    paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.bHaveVotedCnt);
    paramQQAppInterface.append(",card.strVoteLimitedNotice = ");
    paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card.strVoteLimitedNotice);
    QLog.i("BabyQIPCModule", 1, paramQQAppInterface.toString());
    paramBundle.putLong("key_request_zan_vote_result", l1);
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne != null)
    {
      paramQQAppInterface = a();
      if (paramQQAppInterface == null) {
        paramQQAppInterface = null;
      } else {
        paramQQAppInterface = paramQQAppInterface.e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      }
      if (paramQQAppInterface != null)
      {
        paramBundle.putString("friendUin", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
        paramBundle.putByte("mgid", (byte)paramQQAppInterface.groupid);
      }
    }
    if (paramInt != -1)
    {
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
      Bundle localBundle = new Bundle();
      Object localObject1 = (Bundle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("setFriendGrouping");
      Object localObject2 = ((Bundle)localObject1).getString("key_js_callback_id");
      int i = ((Bundle)localObject1).getInt("key_process_callback_id");
      if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne != null) && (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne)))
      {
        localBundle.putString("key_method_action", "setFriendGrouping");
        localBundle.putString("web_js_call_back_id", (String)localObject2);
        localObject2 = a();
        if (localObject2 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((FriendsManager)localObject2).e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
        }
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
    }
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
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, (byte)2);
      MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
      }
      localMqqHandler = paramQQAppInterface.getHandler(ChatSettingActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
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
    Object localObject1 = a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCard = ProfileCardUtil.a(localQQAppInterface, AppConstants.BABY_Q_UIN);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if ((localObject2 != null) && (localObject1 != null))
    {
      if (((FriendsManager)localObject1).b(((Card)localObject2).uin)) {
        localObject1 = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1);
      } else {
        localObject1 = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 19);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne = ((AllInOne)localObject1);
      localObject2 = (CardHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject2 == null) {
        return;
      }
      long l = ProfileUtils.getControl((AllInOne)localObject1, false);
      ((CardHandler)localObject2).a(localQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)1);
      localObject1 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(localQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localObject1 != null) {
        ((TempGetProfileDetailProcessor)localObject1).getBabyQSwitch();
      }
    }
  }
  
  EIPCResult c(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne != null) && (ProfilePAUtils.isPaTypeFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne)))
    {
      Object localObject = a();
      if (localObject == null) {
        paramQQAppInterface = null;
      } else {
        paramQQAppInterface = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      }
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = ((FriendsManager)localObject).a(String.valueOf(paramQQAppInterface.groupid));
        if (paramQQAppInterface != null)
        {
          paramBundle.putString("key_handle_set_get_group", paramQQAppInterface.group_name);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("babyqWeb get group =");
          ((StringBuilder)localObject).append(paramQQAppInterface.group_name);
          QLog.i("BabyQIPCModule", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("babyqWeb action = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("BabyQIPCModule", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
      b();
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    QQAppInterface localQQAppInterface = a();
    if (paramBundle != null) {
      localObject = paramBundle.getString("web_js_call_back_id");
    } else {
      localObject = null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_method_action", paramString);
    localBundle.putString("web_js_call_back_id", (String)localObject);
    boolean bool3 = paramString.equals("getFriendStatus");
    boolean bool2 = false;
    boolean bool1 = false;
    long l = 0L;
    if (bool3)
    {
      paramString = a();
      if (paramString != null) {
        bool1 = paramString.b(AppConstants.BABY_Q_UIN);
      }
      if (bool1) {
        l = 1L;
      }
      localBundle.putLong("key_get_friend_status", l);
      return EIPCResult.createSuccessResult(localBundle);
    }
    if (paramString.equals("getZanVoteCount"))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (paramString != null) {
        localBundle.putLong("key_get_zan_vote_count", paramString.lVoteCount);
      }
      return EIPCResult.createSuccessResult(localBundle);
    }
    if (paramString.equals("requestZan")) {
      return a(localQQAppInterface, localBundle);
    }
    if (paramString.equals("addFriend"))
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
      return null;
    }
    if (paramString.equals("sendmsg"))
    {
      localBundle.putParcelable("key_parcel_allinone", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne);
      return EIPCResult.createSuccessResult(localBundle);
    }
    if (paramString.equals("deleteFriend")) {
      return b(localQQAppInterface, localBundle);
    }
    if (paramString.equals("getFriendGrouping")) {
      return c(localQQAppInterface, localBundle);
    }
    if (paramString.equals("setFriendGrouping")) {
      return a(localQQAppInterface, localBundle, paramString, paramInt, (String)localObject);
    }
    if (paramString.equals("reportFriend"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne != null) {
        try
        {
          localBundle.putString("key_report_msg", NewReportPlugin.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, "", 21001, null));
        }
        catch (Exception paramString)
        {
          QLog.e("BabyQIPCModule", 1, "babyqWeb getReportMsg Exception", paramString);
        }
      }
      return EIPCResult.createSuccessResult(localBundle);
    }
    if (paramString.equals("getPushStatus"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.babyQSwitch) {
        l = 1L;
      }
      localBundle.putLong("key_request_zan_vote_result", l);
      return EIPCResult.createSuccessResult(localBundle);
    }
    if (paramString.equals("setPushStatus"))
    {
      if (paramBundle != null) {
        l = paramBundle.getLong("key_push_status", 0L);
      }
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramString = (CardHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        bool1 = bool2;
        if (l == 1L) {
          bool1 = true;
        }
        paramString.m(bool1);
        paramString = new StringBuilder();
        paramString.append("babyqWeb set babyQSwitch = ");
        paramString.append(l);
        QLog.i("BabyQIPCModule", 1, paramString.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQIPCModule
 * JD-Core Version:    0.7.0.1
 */