package com.tencent.mobileqq.activity.home;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class Conversation$31
  extends FriendListObserver
{
  Conversation$31(Conversation paramConversation) {}
  
  public void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onCancelMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      ArrayList localArrayList = localMayknowRecommendManager.c();
      if (localMayknowRecommendManager.a(paramString)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "onCancelMayKnowRecommend recommends is empty ");
        }
        localMayknowRecommendManager.e();
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        ((FriendListHandler)this.a.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqHideConversationMayknowRecommend();
      }
    }
  }
  
  public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = (ProxyManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.PROXY_MANAGER);
    if (localObject1 == null)
    {
      localObject1 = null;
      TroopAssistantManager.a().i(this.a.a());
      if (localObject1 != null) {
        break label179;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label191;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.getType() == 1) && (this.a.a().getTroopMask(localRecentUser.uin) == 3))
        {
          if (localObject1 != null) {
            ((RecentUserProxy)localObject1).a(localRecentUser);
          }
          RecentUtil.b(this.a.a(), localRecentUser.uin, 1);
          this.a.a().getMessageFacade().c(localRecentUser.uin, localRecentUser.getType());
        }
      }
      localObject1 = ((ProxyManager)localObject1).a();
      break;
      label179:
      localObject2 = ((RecentUserProxy)localObject1).a(false);
    }
    label191:
    this.a.a(9, AppConstants.TROOP_ASSISTANT_UIN, 5000);
    this.a.a(9, AppConstants.HOTCHAT_CENTER_UIN, 5001);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onGetGenralSettings");
    }
  }
  
  public void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("is_from_init");; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onGetMayKnowRecommend isSuccess = " + paramBoolean + " isFromInit: " + bool);
      }
      if (!bool) {
        Conversation.i(this.a);
      }
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      return;
    }
  }
  
  public void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (Utils.a(paramString, this.a.jdField_a_of_type_MqqAppAppRuntime.getAccount()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("onGetOnlineInfoByUinOrMobile");
    }
  }
  
  public void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uins:" + paramHashSet + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (paramHashSet.contains(this.a.a().getCurrentAccountUin())) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
    }
    this.a.b(new Conversation.31.2(this, paramHashSet));
  }
  
  public void onHideConversationMayKnowRecommend(boolean paramBoolean, Object paramObject)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onHideConversationMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      paramObject = (MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      paramObject.e();
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      paramBoolean = paramObject.b("sp_mayknow_ml_s_a_vl");
      paramObject = this.a.a();
      if (paramBoolean) {}
      for (i = 2;; i = 1)
      {
        ContactReportUtils.a(paramObject, "msgtab_listhide_clk", 1, i);
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131702634), 0).a();
    paramBoolean = ((MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b("sp_mayknow_ml_s_a_vl");
    paramObject = this.a.a();
    if (paramBoolean) {}
    for (;;)
    {
      ContactReportUtils.a(paramObject, "msgtab_listhide_clk", 0, i);
      return;
      i = 1;
    }
  }
  
  public void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
    }
  }
  
  public void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onMayknowStateChanged isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (((MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b("sp_mayknow_ml_s_a_vl")))
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
    }
  }
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a(1009, 500L, true);
    }
  }
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap != null) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = paramMap.size())
    {
      QLog.d("Q.recent", 2, i);
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break;
      }
      return;
    }
    Object localObject = (ProxyManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.PROXY_MANAGER);
    label114:
    String str;
    if (localObject == null)
    {
      localObject = null;
      paramMap = paramMap.entrySet().iterator();
      if (!paramMap.hasNext()) {
        break label340;
      }
      str = (String)((Map.Entry)paramMap.next()).getKey();
      i = this.a.a().getTroopMask(str);
      if (i != 2) {
        break label322;
      }
      TroopAssistantManager.a().a(str, this.a.a());
    }
    for (;;)
    {
      if ((i == 3) && (localObject != null)) {}
      try
      {
        RecentUser localRecentUser = ((RecentUserProxy)localObject).b(str, 1);
        if (localRecentUser != null)
        {
          ((RecentUserProxy)localObject).a(localRecentUser);
          RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
          ((RecentUserProxy)localObject).a(localRecentUser);
          RecentUtil.b(this.a.a(), localRecentUser.uin, 1);
          this.a.a().getMessageFacade().c(localRecentUser.uin, localRecentUser.getType());
        }
      }
      catch (Exception localException)
      {
        label297:
        break label297;
      }
      this.a.a(9, str, 1);
      break label114;
      localObject = ((ProxyManager)localObject).a();
      break;
      label322:
      TroopAssistantManager.a().c(str, this.a.a());
    }
    label340:
    this.a.a(9, AppConstants.TROOP_ASSISTANT_UIN, 5000);
    this.a.a(9, AppConstants.HOTCHAT_CENTER_UIN, 5001);
  }
  
  public void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Conversation.j(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("onSetVisibilityForNetWorkStatus");
    }
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatedelfriend");
      }
      this.a.a(0L);
    }
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (!Utils.a(paramString, this.a.jdField_a_of_type_MqqAppAppRuntime.getAccount()))
    {
      this.a.a(0L);
      return;
    }
    Conversation.c(this.a, "onUpdateFriendInfo");
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
      }
      this.a.a(0L);
      this.a.b(new Conversation.31.1(this));
      Conversation.c(this.a, "onUpdateFriendList");
    }
  }
  
  public void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if (paramBoolean) {
      this.a.b(new Conversation.31.3(this, paramArrayList));
    }
  }
  
  public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
  
  public void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.31
 * JD-Core Version:    0.7.0.1
 */