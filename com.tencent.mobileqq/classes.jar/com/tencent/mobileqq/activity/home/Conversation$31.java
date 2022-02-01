package com.tencent.mobileqq.activity.home;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class Conversation$31
  extends FriendListObserver
{
  Conversation$31(Conversation paramConversation) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCancelMayKnowRecommend isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = (MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      ArrayList localArrayList = ((MayknowRecommendManager)localObject).c();
      if (((MayknowRecommendManager)localObject).a(paramString)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "onCancelMayKnowRecommend recommends is empty ");
        }
        ((MayknowRecommendManager)localObject).e();
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        ((FriendListHandler)this.a.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqHideConversationMayknowRecommend();
      }
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("is_from_init");
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetMayKnowRecommend isSuccess = ");
      paramBundle.append(paramBoolean);
      paramBundle.append(" isFromInit: ");
      paramBundle.append(bool);
      QLog.d("Q.recent", 2, paramBundle.toString());
    }
    if (!bool) {
      Conversation.i(this.a);
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (Utils.a(paramString, this.a.jdField_a_of_type_MqqAppAppRuntime.getAccount()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("onGetOnlineInfoByUinOrMobile");
    }
  }
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" Conversation.onUpdateCustomHead: uins:");
      localStringBuilder.append(paramHashSet);
      localStringBuilder.append(", success :");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      return;
    }
    if (paramHashSet.contains(this.a.a().getCurrentAccountUin())) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
    }
    this.a.b(new Conversation.31.2(this, paramHashSet));
  }
  
  protected void onHideConversationMayKnowRecommend(boolean paramBoolean, Object paramObject)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      paramObject = new StringBuilder();
      paramObject.append("onHideConversationMayKnowRecommend isSuccess = ");
      paramObject.append(paramBoolean);
      QLog.d("Q.recent", 2, paramObject.toString());
    }
    if (paramBoolean)
    {
      paramObject = (MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      paramObject.e();
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      paramBoolean = paramObject.b("sp_mayknow_ml_s_a_vl");
      paramObject = this.a.a();
      if (!paramBoolean) {
        i = 1;
      }
      ContactReportUtils.a(paramObject, "msgtab_listhide_clk", 1, i);
      return;
    }
    QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131702767), 0).a();
    paramBoolean = ((MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b("sp_mayknow_ml_s_a_vl");
    paramObject = this.a.a();
    if (!paramBoolean) {
      i = 1;
    }
    ContactReportUtils.a(paramObject, "msgtab_listhide_clk", 0, i);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onMayKnowEntryStateChanged isSuccess=");
      paramBundle.append(paramBoolean);
      QLog.d("Q.recent", 2, paramBundle.toString());
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMayknowStateChanged isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (((MayknowRecommendManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b("sp_mayknow_ml_s_a_vl")))
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a(1009, 500L, true);
    }
  }
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Conversation.j(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("onSetVisibilityForNetWorkStatus");
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatedelfriend");
      }
      this.a.a(0L);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFriendInfo uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isSc = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.recent", 2, localStringBuilder.toString());
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
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
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
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if (paramBoolean) {
      this.a.b(new Conversation.31.3(this, paramArrayList));
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel())
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("onUpdateOnlineFriend| isSuc = ");
      paramArrayOfString.append(paramBoolean);
      QLog.i("Q.recent", 4, paramArrayOfString.toString());
    }
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
  
  protected void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.31
 * JD-Core Version:    0.7.0.1
 */