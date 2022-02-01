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

class Conversation$32
  extends FriendListObserver
{
  Conversation$32(Conversation paramConversation) {}
  
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
      localObject = (MayknowRecommendManager)this.a.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      ArrayList localArrayList = ((MayknowRecommendManager)localObject).f();
      if (((MayknowRecommendManager)localObject).c(paramString)) {
        this.a.A.sendEmptyMessage(1009);
      }
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "onCancelMayKnowRecommend recommends is empty ");
        }
        ((MayknowRecommendManager)localObject).i();
        this.a.A.sendEmptyMessage(1009);
        ((FriendListHandler)this.a.s().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqHideConversationMayknowRecommend();
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
      Conversation.r(this.a);
    }
    this.a.A.sendEmptyMessage(1009);
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (Utils.a(paramString, this.a.aF.getAccount()))) {
      this.a.Y.b("onGetOnlineInfoByUinOrMobile");
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
    if (paramHashSet.contains(this.a.s().getCurrentAccountUin())) {
      this.a.Y.q.sendEmptyMessage(3);
    }
    this.a.b(new Conversation.32.2(this, paramHashSet));
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
      paramObject = (MayknowRecommendManager)this.a.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      paramObject.i();
      this.a.A.sendEmptyMessage(1009);
      paramBoolean = paramObject.d("sp_mayknow_ml_s_a_vl");
      paramObject = this.a.s();
      if (!paramBoolean) {
        i = 1;
      }
      ContactReportUtils.a(paramObject, "msgtab_listhide_clk", 1, i);
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131900758), 0).show();
    paramBoolean = ((MayknowRecommendManager)this.a.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).d("sp_mayknow_ml_s_a_vl");
    paramObject = this.a.s();
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
      this.a.A.removeCallbacks(this.a.av);
      this.a.A.postDelayed(this.a.av, 1600L);
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
    if ((paramBoolean) && (((MayknowRecommendManager)this.a.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).d("sp_mayknow_ml_s_a_vl")))
    {
      this.a.A.sendEmptyMessage(1009);
      this.a.A.removeCallbacks(this.a.av);
      this.a.A.postDelayed(this.a.av, 1600L);
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
      Conversation.s(this.a);
      this.a.Y.b("onSetVisibilityForNetWorkStatus");
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
    if (!Utils.a(paramString, this.a.aF.getAccount()))
    {
      this.a.a(0L);
      return;
    }
    Conversation.d(this.a, "onUpdateFriendInfo");
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
      }
      this.a.a(0L);
      this.a.b(new Conversation.32.1(this));
      Conversation.d(this.a, "onUpdateFriendList");
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if (paramBoolean) {
      this.a.b(new Conversation.32.3(this, paramArrayList));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.32
 * JD-Core Version:    0.7.0.1
 */